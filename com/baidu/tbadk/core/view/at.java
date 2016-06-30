package com.baidu.tbadk.core.view;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes.dex */
public class at {
    private static at aeA = new at();
    private Handler aeD;
    private int aeB = 0;
    private boolean aeC = true;
    private Handler.Callback aeE = new au(this);

    public static at vG() {
        return aeA;
    }

    private at() {
        HandlerThread handlerThread = new HandlerThread("release_media");
        handlerThread.start();
        this.aeD = new Handler(handlerThread.getLooper(), this.aeE);
    }

    public void q(TextureVideoView textureVideoView) {
        if (textureVideoView != null) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = textureVideoView;
            this.aeD.sendMessage(obtain);
        }
    }

    public void vH() {
        this.aeB++;
    }

    public void vI() {
        this.aeB--;
        if (this.aeB < 0) {
            this.aeB = 0;
        }
    }

    public int vJ() {
        return this.aeB;
    }

    public void aI(boolean z) {
        this.aeC = z;
    }

    public boolean vK() {
        return this.aeC;
    }

    public boolean vL() {
        return Build.MODEL != null && Build.MODEL.equals("MI 5");
    }

    public boolean vM() {
        return "2014811".equals(Build.MODEL);
    }
}
