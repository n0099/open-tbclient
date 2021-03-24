package com.baidu.down.request.taskmanager;

import android.os.SystemClock;
import com.baidu.down.utils.NamingThreadFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes2.dex */
public class WriteThreadMng {
    public static final boolean DEBUG = false;
    public static final String TAG = "WriteThreadMng";
    public Object mLock = new Object();
    public Map<String, WriteThread> mThreadMap;
    public int mWritePoolSize;
    public WriteThread[] mWriteThread;
    public ExecutorService mWriteThreadPool;

    public WriteThreadMng(int i) {
        this.mWriteThreadPool = null;
        this.mWritePoolSize = 3;
        this.mWriteThread = null;
        this.mThreadMap = null;
        this.mWritePoolSize = i;
        this.mWriteThreadPool = Executors.newFixedThreadPool(i, new NamingThreadFactory(WriteThread.TAG));
        this.mWriteThread = new WriteThread[this.mWritePoolSize];
        for (int i2 = 0; i2 < this.mWritePoolSize; i2++) {
            this.mWriteThread[i2] = new WriteThread();
            this.mWriteThreadPool.execute(this.mWriteThread[i2]);
        }
        this.mThreadMap = new HashMap();
    }

    public void closeDownloadFileStream(String str) {
        WriteThread remove;
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

    public void loadBalanceToWrite(ByteArrayInfo byteArrayInfo) {
        WriteThread writeThread;
        WriteThread[] writeThreadArr;
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
