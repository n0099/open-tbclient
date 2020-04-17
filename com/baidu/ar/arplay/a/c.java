package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.ar.arplay.core.engine.ARPEngine;
/* loaded from: classes3.dex */
public class c extends OrientationEventListener {
    private ARPEngine.h dw;
    private boolean dx;
    private int dy;
    private ARPEngine.h mTouchOrientation;

    public c(Context context) {
        super(context);
        this.dx = false;
    }

    private int ax() {
        if (this.dw == ARPEngine.h.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.dw == ARPEngine.h.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return this.dw == ARPEngine.h.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void aw() {
        this.dy = ax();
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i < 0) {
            this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_NOT_DEFINED;
        } else if (ARPEngine.getInstance().getImuType() == 1) {
            int i2 = ((i + 360) + this.dy) % 360;
            if (i2 <= 45 || i2 > 315) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i2 > 45 && i2 <= 135) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i2 > 135 && i2 <= 225) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 > 225 && i2 <= 315) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_LANDSCAPE;
            }
            if (!this.dx && ARPEngine.getInstance().getImuType() == 1) {
                this.dx = true;
                this.dw = this.mTouchOrientation;
                aw();
            }
        } else if (ARPEngine.getInstance().getImuType() == 0) {
            if (i <= 45 || i > 315) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i > 45 && i <= 135) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i > 135 && i <= 225) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i > 225 && i <= 315) {
                this.mTouchOrientation = ARPEngine.h.SCREEN_ORIENTATION_LANDSCAPE;
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
