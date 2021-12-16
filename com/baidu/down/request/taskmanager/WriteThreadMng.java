package com.baidu.down.request.taskmanager;

import android.os.SystemClock;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.utils.NamingThreadFactory;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public class WriteThreadMng {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "WriteThreadMng";
    public transient /* synthetic */ FieldHolder $fh;
    public Object mLock;
    public Map<String, WriteThread> mThreadMap;
    public int mWritePoolSize;
    public WriteThread[] mWriteThread;
    public ExecutorService mWriteThreadPool;

    public WriteThreadMng(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mWriteThreadPool = null;
        this.mWritePoolSize = 3;
        this.mWriteThread = null;
        this.mThreadMap = null;
        this.mLock = new Object();
        this.mWritePoolSize = i2;
        this.mWriteThreadPool = Executors.newFixedThreadPool(i2, new NamingThreadFactory(WriteThread.TAG));
        this.mWriteThread = new WriteThread[this.mWritePoolSize];
        for (int i5 = 0; i5 < this.mWritePoolSize; i5++) {
            this.mWriteThread[i5] = new WriteThread();
            this.mWriteThreadPool.execute(this.mWriteThread[i5]);
        }
        this.mThreadMap = new HashMap();
    }

    public void closeDownloadFileStream(String str) {
        WriteThread remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            synchronized (this.mLock) {
                remove = this.mThreadMap.remove(str);
                if (TaskFacade.getInstance(null) != null && TaskFacade.getInstance(null).getBinaryTaskMng() != null && TaskFacade.getInstance(null).getBinaryTaskMng().getTaskByKey(str) != null && TaskFacade.getInstance(null).getBinaryTaskMng().getTaskByKey(str).mTaskSpeedStat.endWriteTimeMillis == -1) {
                    TaskFacade.getInstance(null).getBinaryTaskMng().getTaskByKey(str).mTaskSpeedStat.endWriteTimeMillis = SystemClock.elapsedRealtime();
                }
            }
            if (remove != null) {
                try {
                    remove.closeOutputFile(str);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void loadBalanceToWrite(ByteArrayInfo byteArrayInfo) {
        WriteThread writeThread;
        WriteThread[] writeThreadArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, byteArrayInfo) == null) {
            WriteThread writeThread2 = this.mThreadMap.get(byteArrayInfo.mkey);
            if (writeThread2 != null) {
                writeThread2.put(byteArrayInfo);
                return;
            }
            synchronized (this.mLock) {
                writeThread = this.mThreadMap.get(byteArrayInfo.mkey);
                if (writeThread == null) {
                    for (WriteThread writeThread3 : this.mWriteThread) {
                        if (writeThread == null || writeThread.getQueueSize() > writeThread3.getQueueSize()) {
                            writeThread = writeThread3;
                        }
                    }
                    this.mThreadMap.put(byteArrayInfo.mkey, writeThread);
                }
            }
            writeThread.put(byteArrayInfo);
        }
    }
}
