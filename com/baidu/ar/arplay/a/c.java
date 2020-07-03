package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
/* loaded from: classes3.dex */
public class c extends OrientationEventListener {
    private ARPEngine.f dI;
    private boolean dJ;
    private int dK;
    private ARPEngine.f mTouchOrientation;

    public c(Context context) {
        super(context);
        this.dJ = false;
    }

    private int aL() {
        if (this.dI == ARPEngine.f.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.dI == ARPEngine.f.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return this.dI == ARPEngine.f.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void aK() {
        this.dK = aL();
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i < 0) {
            this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_NOT_DEFINED;
        } else if (ARPEngine.getInstance().getImuType() == 1) {
            int i2 = ((i + 360) + this.dK) % 360;
            if (i2 <= 45 || i2 > 315) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i2 > 45 && i2 <= 135) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i2 > 135 && i2 <= 225) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 > 225 && i2 <= 315) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_LANDSCAPE;
            }
            if (!this.dJ && ARPEngine.getInstance().getImuType() == 1) {
                this.dJ = true;
                this.dI = this.mTouchOrientation;
                aK();
            }
        } else if (ARPEngine.getInstance().getImuType() == 0) {
            if (i <= 45 || i > 315) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i > 45 && i <= 135) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i > 135 && i <= 225) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i > 225 && i <= 315) {
                this.mTouchOrientation = ARPEngine.f.SCREEN_ORIENTATION_LANDSCAPE;
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
