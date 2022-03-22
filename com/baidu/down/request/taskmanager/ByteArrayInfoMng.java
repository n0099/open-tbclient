package com.baidu.down.request.taskmanager;

import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.Queue;
/* loaded from: classes3.dex */
public class ByteArrayInfoMng {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ByteArrayInfoMng";
    public static int mMaxByteSize = 100;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mAllocateMemory;
    public Queue<ByteArrayInfo> mByteArrayGetList;
    public Queue<ByteArrayInfo> mByteArrayRecycleList;
    public int mCurDataCount;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(2037017518, "Lcom/baidu/down/request/taskmanager/ByteArrayInfoMng;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(2037017518, "Lcom/baidu/down/request/taskmanager/ByteArrayInfoMng;");
        }
    }

    public ByteArrayInfoMng() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mByteArrayGetList = null;
        this.mByteArrayRecycleList = null;
        this.mAllocateMemory = false;
        this.mCurDataCount = 0;
        this.mByteArrayGetList = new LinkedList();
        this.mByteArrayRecycleList = new LinkedList();
        this.mAllocateMemory = false;
    }

    public synchronized ByteArrayInfo getByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            synchronized (this) {
                if (this.mByteArrayGetList.size() == 0 && this.mByteArrayRecycleList.size() != 0) {
                    synchronized (this.mByteArrayRecycleList) {
                        this.mByteArrayGetList.addAll(this.mByteArrayRecycleList);
                        this.mByteArrayRecycleList.clear();
                    }
                }
                ByteArrayInfo poll = this.mByteArrayGetList.poll();
                if (poll == null) {
                    if (this.mCurDataCount >= mMaxByteSize * 2) {
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        return getByteArray();
                    }
                    poll = new ByteArrayInfo();
                    this.mCurDataCount++;
                }
                poll.mRecycled = false;
                return poll;
            }
        }
        return (ByteArrayInfo) invokeV.objValue;
    }

    public void initByteArray(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.mAllocateMemory) {
            return;
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.mByteArrayGetList.offer(new ByteArrayInfo());
        }
        this.mCurDataCount = mMaxByteSize;
        this.mAllocateMemory = true;
    }

    public void recycle(ByteArrayInfo byteArrayInfo) {
        Queue<ByteArrayInfo> queue;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, byteArrayInfo) == null) || byteArrayInfo == null || (queue = this.mByteArrayRecycleList) == null) {
            return;
        }
        synchronized (queue) {
            if (byteArrayInfo.mRecycled) {
                Log.w(TAG, "### ByteArrayInfo duplicated recycled!");
            } else {
                byteArrayInfo.mRecycled = true;
                if (this.mByteArrayRecycleList != null) {
                    this.mByteArrayRecycleList.offer(byteArrayInfo);
                }
            }
        }
    }

    public void recycleByteArray() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mByteArrayGetList.clear();
            this.mByteArrayRecycleList.clear();
            this.mAllocateMemory = false;
            this.mCurDataCount = 0;
        }
    }
}
