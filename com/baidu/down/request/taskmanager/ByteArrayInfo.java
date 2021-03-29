package com.baidu.down.request.taskmanager;

import android.os.Build;
import android.util.Log;
import com.baidu.down.request.task.AbstractTask;
/* loaded from: classes.dex */
public class ByteArrayInfo {
    public byte[] mByteArray;
    public int mByteArrayLength;
    public long mFilePos;
    public boolean mRecycled = true;
    public String mkey;

    public ByteArrayInfo() {
        if (Build.VERSION.SDK_INT > 20) {
            this.mByteArray = new byte[AbstractTask.DF_SEG_WRITE_SIZE];
        } else {
            this.mByteArray = new byte[16384];
        }
    }

    public void finalize() throws Throwable {
        if (!this.mRecycled) {
            String simpleName = ByteArrayInfo.class.getSimpleName();
            Log.w(simpleName, "### Maybe ByteArrayInfo has not been recycled! last used : " + this.mkey + ", pos=" + this.mFilePos + ", len=" + this.mByteArrayLength);
        }
        super.finalize();
    }
}
