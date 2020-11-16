package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes6.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bVz;
    private MediaMuxer bWl;
    private volatile boolean bWm = false;

    public boolean Zc() {
        return this.bWm;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.je(str)) {
            com.baidu.mario.a.c.a.jd(str);
        }
        try {
            this.bWl = new MediaMuxer(str, i);
            this.bVz = fVar;
            this.bWm = false;
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
            i = this.bWl.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void Zd() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bWl.start();
                this.bWm = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bVz != null) {
                this.bVz.dy(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bWl.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void Ze() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bWl.stop();
                this.bWm = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bVz != null) {
                this.bVz.dz(z);
            }
        }
    }

    public void Zf() {
        if (!this.bWm) {
            this.bWl.release();
            this.bWl = null;
        }
    }
}
