package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f ccK;
    private MediaMuxer cdy;
    private volatile boolean cdz = false;

    public boolean Zy() {
        return this.cdz;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.iq(str)) {
            com.baidu.mario.a.c.a.ip(str);
        }
        try {
            this.cdy = new MediaMuxer(str, i);
            this.ccK = fVar;
            this.cdz = false;
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
            i = this.cdy.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void Zz() {
        boolean z = true;
        synchronized (this) {
            try {
                this.cdy.start();
                this.cdz = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.ccK != null) {
                this.ccK.dP(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.cdy.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void ZA() {
        boolean z = false;
        synchronized (this) {
            try {
                this.cdy.stop();
                this.cdz = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.ccK != null) {
                this.ccK.dQ(z);
            }
        }
    }

    public void ZB() {
        if (!this.cdz) {
            this.cdy.release();
            this.cdy = null;
        }
    }
}
