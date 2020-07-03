package com.baidu.swan.menu;

import android.graphics.PointF;
import android.view.animation.Interpolator;
/* loaded from: classes11.dex */
public class e implements Interpolator {
    private int dnP = 0;
    private final PointF dnQ = new PointF();
    private final PointF dnR = new PointF();

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(float f, float f2, float f3, float f4) {
        this.dnQ.x = f;
        this.dnQ.y = f2;
        this.dnR.x = f3;
        this.dnR.y = f4;
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        double d = 1.0d;
        int i = this.dnP;
        float f2 = f;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = (1.0f * i) / 4096.0f;
            if (a(f2, 0.0d, this.dnQ.x, this.dnR.x, 1.0d) < f) {
                i++;
            } else {
                this.dnP = i;
                break;
            }
        }
        double a = a(f2, 0.0d, this.dnQ.y, this.dnR.y, 1.0d);
        if (a > 0.999d) {
            this.dnP = 0;
        } else {
            d = a;
        }
        return (float) d;
    }

    private double a(double d, double d2, double d3, double d4, double d5) {
        double d6 = 1.0d - d;
        double d7 = d * d;
        double d8 = d6 * d6;
        return (d6 * 3.0d * d7 * d4) + (d8 * 3.0d * d * d3) + (d8 * d6 * d2) + (d7 * d * d5);
    }
}
