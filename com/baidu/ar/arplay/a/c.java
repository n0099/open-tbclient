package com.baidu.ar.arplay.a;

import android.content.Context;
import android.view.OrientationEventListener;
/* loaded from: classes.dex */
public class c extends OrientationEventListener {
    public a dp;
    public a dq;
    public boolean dr;
    public int ds;
    public int dt;

    /* loaded from: classes.dex */
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
        a aVar = this.dp;
        if (aVar == a.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (aVar == a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        return aVar == a.SCREEN_ORIENTATION_REVERSE_PORTRAIT ? 180 : 0;
    }

    public void aJ() {
        this.ds = aK();
    }

    public void h(int i) {
        this.dt = i;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        a aVar;
        a aVar2;
        if (i < 0) {
            aVar = a.SCREEN_ORIENTATION_NOT_DEFINED;
        } else {
            int i2 = this.dt;
            if (i2 == 1) {
                int i3 = ((i + 360) + this.ds) % 360;
                if (i3 <= 45 || i3 > 315) {
                    aVar2 = a.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i3 > 45 && i3 <= 135) {
                    aVar2 = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i3 <= 135 || i3 > 225) {
                    if (i3 > 225 && i3 <= 315) {
                        aVar2 = a.SCREEN_ORIENTATION_LANDSCAPE;
                    }
                    if (this.dr && this.dt == 1) {
                        this.dr = true;
                        this.dp = this.dq;
                        aJ();
                        return;
                    }
                    return;
                } else {
                    aVar2 = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                }
                this.dq = aVar2;
                if (this.dr) {
                    return;
                }
                return;
            } else if (i2 != 0) {
                return;
            } else {
                if (i <= 45 || i > 315) {
                    aVar = a.SCREEN_ORIENTATION_PORTRAIT;
                } else if (i > 45 && i <= 135) {
                    aVar = a.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
                } else if (i > 135 && i <= 225) {
                    aVar = a.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
                } else if (i <= 225 || i > 315) {
                    return;
                } else {
                    aVar = a.SCREEN_ORIENTATION_LANDSCAPE;
                }
            }
        }
        this.dq = aVar;
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
