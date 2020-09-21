package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.ar.arplay.core.engine.ARPEngine;
/* loaded from: classes10.dex */
public class c extends OrientationEventListener {
    private ARPEngine.e dk;
    private boolean dl;
    private int dm;
    private ARPEngine.e mTouchOrientation;

    public c(Context context) {
        super(context);
        this.dl = false;
    }

    private int aJ() {
        if (this.dk == ARPEngine.e.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.dk == ARPEngine.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return this.dk == ARPEngine.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void aI() {
        this.dm = aJ();
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i < 0) {
            this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_NOT_DEFINED;
        } else if (ARPEngine.getInstance().getImuType() == 1) {
            int i2 = ((i + EncoderTextureDrawer.X264_WIDTH) + this.dm) % EncoderTextureDrawer.X264_WIDTH;
            if (i2 <= 45 || i2 > 315) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i2 > 45 && i2 <= 135) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i2 > 135 && i2 <= 225) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 > 225 && i2 <= 315) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_LANDSCAPE;
            }
            if (!this.dl && ARPEngine.getInstance().getImuType() == 1) {
                this.dl = true;
                this.dk = this.mTouchOrientation;
                aI();
            }
        } else if (ARPEngine.getInstance().getImuType() == 0) {
            if (i <= 45 || i > 315) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i > 45 && i <= 135) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i > 135 && i <= 225) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i > 225 && i <= 315) {
                this.mTouchOrientation = ARPEngine.e.SCREEN_ORIENTATION_LANDSCAPE;
            }
        }
        ARPEngine.getInstance().setTouchOrientation(this.mTouchOrientation);
    }

    public void release() {
        try {
            disable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            enable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
