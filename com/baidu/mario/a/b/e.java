package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private MediaMuxer bXV;
    private volatile boolean bXW = false;
    private f bXj;

    public boolean ZL() {
        return this.bXW;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.jk(str)) {
            com.baidu.mario.a.c.a.jj(str);
        }
        try {
            this.bXV = new MediaMuxer(str, i);
            this.bXj = fVar;
            this.bXW = false;
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
            i = this.bXV.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void ZM() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bXV.start();
                this.bXW = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bXj != null) {
                this.bXj.dw(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bXV.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void ZN() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bXV.stop();
                this.bXW = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bXj != null) {
                this.bXj.dx(z);
            }
        }
    }

    public void ZO() {
        if (!this.bXW) {
            this.bXV.release();
            this.bXV = null;
        }
    }
}
