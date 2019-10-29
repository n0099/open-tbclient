package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f axQ;
    private MediaMuxer ayO;
    private volatile boolean ayP = false;

    public boolean yZ() {
        return this.ayP;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.b.c.a.ds(str)) {
            com.baidu.mario.b.c.a.dr(str);
        }
        try {
            this.ayO = new MediaMuxer(str, i);
            this.axQ = fVar;
            this.ayP = false;
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
            i = this.ayO.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void za() {
        boolean z = true;
        synchronized (this) {
            try {
                this.ayO.start();
                this.ayP = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.axQ != null) {
                this.axQ.be(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.ayO.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void zb() {
        boolean z = false;
        synchronized (this) {
            try {
                this.ayO.stop();
                this.ayP = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.axQ != null) {
                this.axQ.bf(z);
            }
        }
    }

    public void zc() {
        if (!this.ayP) {
            this.ayO.release();
            this.ayO = null;
        }
    }
}
