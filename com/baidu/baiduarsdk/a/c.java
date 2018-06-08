package com.baidu.baiduarsdk.a;

import android.content.Context;
import android.view.OrientationEventListener;
import com.baidu.baiduarsdk.ArBridge;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
/* loaded from: classes3.dex */
public class c extends OrientationEventListener {
    private ArBridge.TouchOrientation a;
    private ArBridge.TouchOrientation b;
    private boolean c;
    private int d;

    public c(Context context) {
        super(context);
        this.c = false;
    }

    private int d() {
        if (this.a == ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE) {
            return 90;
        }
        if (this.a == ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE) {
            return -90;
        }
        if (this.a == ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT) {
            return SubsamplingScaleImageView.ORIENTATION_180;
        }
        return 0;
    }

    public void a() {
        enable();
    }

    public void b() {
        this.d = d();
    }

    public void c() {
        disable();
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i) {
        if (i < 0) {
            this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_NOT_DEFINED;
        } else if (ArBridge.getInstance().getImuType() == 1) {
            int i2 = ((i + 360) + this.d) % 360;
            if (i2 <= 45 || i2 > 315) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i2 > 45 && i2 <= 135) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i2 > 135 && i2 <= 225) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i2 > 225 && i2 <= 315) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
            }
            if (!this.c && ArBridge.getInstance().getImuType() == 1) {
                this.c = true;
                this.a = this.b;
                b();
            }
        } else if (ArBridge.getInstance().getImuType() == 0) {
            if (i <= 45 || i > 315) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_PORTRAIT;
            } else if (i > 45 && i <= 135) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_LANDSCAPE;
            } else if (i > 135 && i <= 225) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_REVERSE_PORTRAIT;
            } else if (i > 225 && i <= 315) {
                this.b = ArBridge.TouchOrientation.SCREEN_ORIENTATION_LANDSCAPE;
            }
        }
        ArBridge.getInstance().setTouchOrientation(this.b);
    }
}
