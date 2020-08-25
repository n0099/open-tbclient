package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes20.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private MediaMuxer bzO;
    private volatile boolean bzP = false;
    private f bzc;

    public boolean SI() {
        return this.bzP;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.hG(str)) {
            com.baidu.mario.a.c.a.hF(str);
        }
        try {
            this.bzO = new MediaMuxer(str, i);
            this.bzc = fVar;
            this.bzP = false;
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
            i = this.bzO.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void SJ() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bzO.start();
                this.bzP = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bzc != null) {
                this.bzc.cS(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bzO.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void SK() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bzO.stop();
                this.bzP = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bzc != null) {
                this.bzc.cT(z);
            }
        }
    }

    public void SL() {
        if (!this.bzP) {
            this.bzO.release();
            this.bzO = null;
        }
    }
}
