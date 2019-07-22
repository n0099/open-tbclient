package com.airbnb.lottie.c;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.model.content.h;
/* loaded from: classes2.dex */
public class e {
    public static PointF b(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF dA = hVar.dA();
        path.moveTo(dA.x, dA.y);
        PointF pointF = new PointF(dA.x, dA.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.dB().size()) {
                break;
            }
            com.airbnb.lottie.model.c cVar = hVar.dB().get(i2);
            PointF cz = cVar.cz();
            PointF cA = cVar.cA();
            PointF cB = cVar.cB();
            if (cz.equals(pointF) && cA.equals(cB)) {
                path.lineTo(cB.x, cB.y);
            } else {
                path.cubicTo(cz.x, cz.y, cA.x, cA.y, cB.x, cB.y);
            }
            pointF.set(cB.x, cB.y);
            i = i2 + 1;
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static double b(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return ((d2 - d) * d3) + d;
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + ((i2 - i) * f));
    }

    public static int k(float f, float f2) {
        return k((int) f, (int) f2);
    }

    public static int k(int i, int i2) {
        return i - (l(i, i2) * i2);
    }

    private static int l(int i, int i2) {
        int i3 = i / i2;
        if ((i ^ i2) < 0 && i3 * i2 != i) {
            return i3 - 1;
        }
        return i3;
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }
}
