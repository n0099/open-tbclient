package com.baidu.tbadk.core.view;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes.dex */
public class au {
    private static au aij = new au();
    private Handler aim;
    private int aik = 0;
    private boolean ail = true;
    private Handler.Callback ain = new av(this);

    public static au wK() {
        return aij;
    }

    private au() {
        HandlerThread handlerThread = new HandlerThread("release_media");
        handlerThread.start();
        this.aim = new Handler(handlerThread.getLooper(), this.ain);
    }

    public void w(TextureVideoView textureVideoView) {
        if (textureVideoView != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = textureVideoView;
            this.aim.sendMessage(obtain);
        }
    }

    public void wL() {
        this.aik++;
    }

    public void wM() {
        this.aik--;
        if (this.aik < 0) {
            this.aik = 0;
        }
    }

    public int wN() {
        return this.aik;
    }

    public void aM(boolean z) {
        this.ail = z;
    }

    public boolean wO() {
        return this.ail;
    }

    public boolean wP() {
        return Build.MODEL != null && Build.MODEL.equals("MI 5");
    }

    public boolean wQ() {
        return "2014811".equals(Build.MODEL);
    }
}
