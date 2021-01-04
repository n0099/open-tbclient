package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
/* loaded from: classes6.dex */
public class c extends OrientationEventListener {
    private a dp;
    private a dq;
    private boolean dr;
    private int ds;
    private int dt;

    /* loaded from: classes6.dex */
    public enum a {
        SCREEN_ORIENTATION_PORTRAIT,
        SCREEN_ORIENTATION_LANDSCAPE,
        SCREEN_ORIENTATION_REVERSE_PORTRAIT,
        SCREEN_ORIENTATION_REVERSE_LANDSCAPE,
        SCREEN_ORIENTATION_NOT_DEFINED
    }

    public c(Context context) {
        super(context);
        this.dr = false;
        this.dt = 0;
    }

    private int aK() {
        if (this.dp == a.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.dp == a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return this.dp == a.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void aJ() {
        this.ds = aK();
    }

    public void h(int i) {
        this.dt = i;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i < 0) {
            this.dq = a.SCREEN_ORIENTATION_NOT_DEFINED;
        } else if (this.dt != 1) {
            if (this.dt == 0) {
                if (i <= 45 || i > 315) {
                    this.dq = a.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i > 45 && i <= 135) {
                    this.dq = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i > 135 && i <= 225) {
                    this.dq = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (i <= 225 || i > 315) {
                } else {
                    this.dq = a.SCREEN_ORIENTATION_LANDSCAPE;
                }
            }
        } else {
            int i2 = ((i + EncoderTextureDrawer.X264_WIDTH) + this.ds) % EncoderTextureDrawer.X264_WIDTH;
            if (i2 <= 45 || i2 > 315) {
                this.dq = a.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i2 > 45 && i2 <= 135) {
                this.dq = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i2 > 135 && i2 <= 225) {
                this.dq = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 > 225 && i2 <= 315) {
                this.dq = a.SCREEN_ORIENTATION_LANDSCAPE;
            }
            if (this.dr || this.dt != 1) {
                return;
            }
            this.dr = true;
            this.dp = this.dq;
            aJ();
        }
    }

    public void release() {
        try {
            disable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        this.dt = 0;
    }

    public void start() {
        try {
            enable();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
