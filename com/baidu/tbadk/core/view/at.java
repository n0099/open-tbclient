package com.baidu.tbadk.core.view;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes.dex */
public class at {
    private static at afo = new at();
    private Handler afr;
    private int afp = 0;
    private boolean afq = true;
    private Handler.Callback afs = new au(this);

    public static at vG() {
        return afo;
    }

    private at() {
        HandlerThread handlerThread = new HandlerThread("release_media");
        handlerThread.start();
        this.afr = new Handler(handlerThread.getLooper(), this.afs);
    }

    public void s(TextureVideoView textureVideoView) {
        if (textureVideoView != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = textureVideoView;
            this.afr.sendMessage(obtain);
        }
    }

    public void vH() {
        this.afp++;
    }

    public void vI() {
        this.afp--;
        if (this.afp < 0) {
            this.afp = 0;
        }
    }

    public int vJ() {
        return this.afp;
    }

    public void aL(boolean z) {
        this.afq = z;
    }

    public boolean vK() {
        return this.afq;
    }

    public boolean vL() {
        return Build.MODEL != null && Build.MODEL.equals("MI 5");
    }

    public boolean vM() {
        return "2014811".equals(Build.MODEL);
    }
}
