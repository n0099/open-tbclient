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

    public static at vE() {
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

    public void vF() {
        this.aea++;
    }

    public void vG() {
        this.aea--;
        if (this.aea < 0) {
            this.aea = 0;
        }
    }

    public int vH() {
        return this.aea;
    }

    public void aK(boolean z) {
        this.aeb = z;
    }

    public boolean vI() {
        return this.aeb;
    }

    public boolean vJ() {
        return Build.MODEL != null && Build.MODEL.equals("MI 5");
    }
}
