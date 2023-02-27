package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class d {
    public static final String TAG = "d";
    public MediaMuxer uV;
    public volatile boolean uW = false;
    public e uo;

    public synchronized int a(MediaFormat mediaFormat) {
        try {
            int addTrack = this.uV.addTrack(mediaFormat);
            if (addTrack >= 0) {
                return addTrack;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.ar.h.b.b(TAG, "addMuxerTrack error!!!");
        return -1;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.uV.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception unused) {
                com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
                return false;
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.c.a.ay(str)) {
            com.baidu.ar.recorder.c.a.ax(str);
        }
        try {
            this.uV = new MediaMuxer(str, i);
            this.uo = eVar;
            this.uW = false;
            return true;
        } catch (Exception e) {
            com.baidu.ar.h.b.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean fU() {
        return this.uW;
    }

    public synchronized void fV() {
        boolean z = true;
        try {
            this.uV.start();
            this.uW = true;
        } catch (Exception unused) {
            com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
            z = false;
        }
        if (this.uo != null) {
            this.uo.O(z);
        }
    }

    public synchronized void fW() {
        boolean z = false;
        try {
            this.uV.stop();
            this.uW = false;
            z = true;
        } catch (Exception unused) {
            com.baidu.ar.h.b.b(TAG, "stopMuxer error!!!");
        }
        if (this.uo != null) {
            this.uo.P(z);
        }
    }

    public void fX() {
        if (this.uW) {
            return;
        }
        this.uV.release();
        this.uV = null;
    }
}
