package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f axy;
    private MediaMuxer ayw;
    private volatile boolean ayx = false;

    public boolean za() {
        return this.ayx;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.b.c.a.ds(str)) {
            com.baidu.mario.b.c.a.dr(str);
        }
        try {
            this.ayw = new MediaMuxer(str, i);
            this.axy = fVar;
            this.ayx = false;
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
            i = this.ayw.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void zb() {
        boolean z = true;
        synchronized (this) {
            try {
                this.ayw.start();
                this.ayx = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.axy != null) {
                this.axy.be(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.ayw.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void zc() {
        boolean z = false;
        synchronized (this) {
            try {
                this.ayw.stop();
                this.ayx = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.axy != null) {
                this.axy.bf(z);
            }
        }
    }

    public void zd() {
        if (!this.ayx) {
            this.ayw.release();
            this.ayw = null;
        }
    }
}
