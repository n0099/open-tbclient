package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes14.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f civ;
    private MediaMuxer cjh;
    private volatile boolean cji = false;

    public boolean abq() {
        return this.cji;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.jc(str)) {
            com.baidu.mario.a.c.a.jb(str);
        }
        try {
            this.cjh = new MediaMuxer(str, i);
            this.civ = fVar;
            this.cji = false;
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
            i = this.cjh.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void abr() {
        boolean z = true;
        synchronized (this) {
            try {
                this.cjh.start();
                this.cji = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.civ != null) {
                this.civ.dX(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.cjh.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void abs() {
        boolean z = false;
        synchronized (this) {
            try {
                this.cjh.stop();
                this.cji = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.civ != null) {
                this.civ.dY(z);
            }
        }
    }

    public void abt() {
        if (!this.cji) {
            this.cjh.release();
            this.cjh = null;
        }
    }
}
