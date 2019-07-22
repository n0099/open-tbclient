package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f aes;
    private MediaMuxer afq;
    private volatile boolean afr = false;

    public boolean uf() {
        return this.afr;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.b.c.a.cH(str)) {
            com.baidu.mario.b.c.a.cG(str);
        }
        try {
            this.afq = new MediaMuxer(str, i);
            this.aes = fVar;
            this.afr = false;
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
            i = this.afq.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void ug() {
        boolean z = true;
        synchronized (this) {
            try {
                this.afq.start();
                this.afr = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.aes != null) {
                this.aes.aM(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.afq.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void uh() {
        boolean z = false;
        synchronized (this) {
            try {
                this.afq.stop();
                this.afr = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.aes != null) {
                this.aes.aN(z);
            }
        }
    }

    public void ui() {
        if (!this.afr) {
            this.afq.release();
            this.afq = null;
        }
    }
}
