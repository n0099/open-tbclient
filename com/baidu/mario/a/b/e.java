package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bRz;
    private MediaMuxer bSl;
    private volatile boolean bSm = false;

    public boolean Xm() {
        return this.bSm;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.iX(str)) {
            com.baidu.mario.a.c.a.iW(str);
        }
        try {
            this.bSl = new MediaMuxer(str, i);
            this.bRz = fVar;
            this.bSm = false;
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int b(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.bSl.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void Xn() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bSl.start();
                this.bSm = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bRz != null) {
                this.bRz.dp(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bSl.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void Xo() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bSl.stop();
                this.bSm = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bRz != null) {
                this.bRz.dq(z);
            }
        }
    }

    public void Xp() {
        if (!this.bSm) {
            this.bSl.release();
            this.bSl = null;
        }
    }
}
