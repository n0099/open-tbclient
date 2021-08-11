package com.baidu.down.request.taskmanager;

import android.os.Build;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ByteArrayInfo {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] mByteArray;
    public int mByteArrayLength;
    public long mFilePos;
    public boolean mRecycled;
    public String mkey;

    public ByteArrayInfo() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mRecycled = true;
        if (Build.VERSION.SDK_INT > 20) {
            this.mByteArray = new byte[AbstractTask.DF_SEG_WRITE_SIZE];
        } else {
            this.mByteArray = new byte[16384];
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!this.mRecycled) {
                String str = "### Maybe ByteArrayInfo has not been recycled! last used : " + this.mkey + ", pos=" + this.mFilePos + ", len=" + this.mByteArrayLength;
            }
            super.finalize();
        }
    }
}
