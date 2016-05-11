package com.baidu.tbadk.core.view;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes.dex */
public class at {
    private static at adZ = new at();
    private Handler aec;
    private int aea = 0;
    private boolean aeb = true;
    private Handler.Callback aed = new au(this);

    public static at vD() {
        return adZ;
    }

    private at() {
        HandlerThread handlerThread = new HandlerThread("release_media");
        handlerThread.start();
        this.aec = new Handler(handlerThread.getLooper(), this.aed);
    }

    public void a(MediaPlayer mediaPlayer) {
        if (mediaPlayer != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = mediaPlayer;
            this.aec.sendMessage(obtain);
        }
    }

    public void vE() {
        this.aea++;
    }

    public void vF() {
        this.aea--;
        if (this.aea < 0) {
            this.aea = 0;
        }
    }

    public int vG() {
        return this.aea;
    }

    public void aK(boolean z) {
        this.aeb = z;
    }

    public boolean vH() {
        return this.aeb;
    }

    public boolean vI() {
        return Build.MODEL != null && Build.MODEL.equals("MI 5");
    }
}
