package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bgw;
    private MediaMuxer bhi;
    private volatile boolean bhj = false;

    public boolean JA() {
        return this.bhj;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.fs(str)) {
            com.baidu.mario.a.c.a.fr(str);
        }
        try {
            this.bhi = new MediaMuxer(str, i);
            this.bgw = fVar;
            this.bhj = false;
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
            i = this.bhi.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void JB() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bhi.start();
                this.bhj = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bgw != null) {
                this.bgw.cq(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bhi.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void JC() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bhi.stop();
                this.bhj = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bgw != null) {
                this.bgw.cr(z);
            }
        }
    }

    public void JD() {
        if (!this.bhj) {
            this.bhi.release();
            this.bhi = null;
        }
    }
}
