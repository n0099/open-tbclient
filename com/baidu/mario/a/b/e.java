package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f caO;
    private MediaMuxer cbA;
    private volatile boolean cbB = false;

    public boolean abF() {
        return this.cbB;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.jI(str)) {
            com.baidu.mario.a.c.a.jH(str);
        }
        try {
            this.cbA = new MediaMuxer(str, i);
            this.caO = fVar;
            this.cbB = false;
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
            i = this.cbA.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void abG() {
        boolean z = true;
        synchronized (this) {
            try {
                this.cbA.start();
                this.cbB = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.caO != null) {
                this.caO.dM(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.cbA.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void abH() {
        boolean z = false;
        synchronized (this) {
            try {
                this.cbA.stop();
                this.cbB = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.caO != null) {
                this.caO.dN(z);
            }
        }
    }

    public void abI() {
        if (!this.cbB) {
            this.cbA.release();
            this.cbA = null;
        }
    }
}
