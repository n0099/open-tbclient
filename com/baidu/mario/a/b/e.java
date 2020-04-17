package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bgq;
    private MediaMuxer bhd;
    private volatile boolean bhe = false;

    public boolean JB() {
        return this.bhe;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.fs(str)) {
            com.baidu.mario.a.c.a.fr(str);
        }
        try {
            this.bhd = new MediaMuxer(str, i);
            this.bgq = fVar;
            this.bhe = false;
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
            i = this.bhd.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void JC() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bhd.start();
                this.bhe = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bgq != null) {
                this.bgq.cq(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bhd.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void JD() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bhd.stop();
                this.bhe = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bgq != null) {
                this.bgq.cr(z);
            }
        }
    }

    public void JE() {
        if (!this.bhe) {
            this.bhd.release();
            this.bhd = null;
        }
    }
}
