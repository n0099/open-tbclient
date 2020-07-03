package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bsU;
    private MediaMuxer btG;
    private volatile boolean btH = false;

    public boolean MC() {
        return this.btH;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.gm(str)) {
            com.baidu.mario.a.c.a.gl(str);
        }
        try {
            this.btG = new MediaMuxer(str, i);
            this.bsU = fVar;
            this.btH = false;
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
            i = this.btG.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void MD() {
        boolean z = true;
        synchronized (this) {
            try {
                this.btG.start();
                this.btH = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bsU != null) {
                this.bsU.cI(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.btG.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void ME() {
        boolean z = false;
        synchronized (this) {
            try {
                this.btG.stop();
                this.btH = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bsU != null) {
                this.bsU.cJ(z);
            }
        }
    }

    public void MF() {
        if (!this.btH) {
            this.btG.release();
            this.btG = null;
        }
    }
}
