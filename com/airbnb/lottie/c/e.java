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
        PointF de = hVar.de();
        path.moveTo(de.x, de.y);
        PointF pointF = new PointF(de.x, de.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.df().size()) {
                break;
            }
            com.airbnb.lottie.model.c cVar = hVar.df().get(i2);
            PointF cf = cVar.cf();
            PointF cg = cVar.cg();
            PointF ch = cVar.ch();
            if (cf.equals(pointF) && cg.equals(ch)) {
                path.lineTo(ch.x, ch.y);
            } else {
                path.cubicTo(cf.x, cf.y, cg.x, cg.y, ch.x, ch.y);
            }
            pointF.set(ch.x, ch.y);
            i = i2 + 1;
        }
        if (hVar.isClosed()) {
            path.close();
        }
    }

    public static float lerp(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return ((f2 - f) * f3) + f;
    }

    public static double a(double d, double d2, @FloatRange(from = 0.0d, to = 1.0d) double d3) {
        return ((d2 - d) * d3) + d;
    }

    public static int lerp(int i, int i2, @FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (int) (i + ((i2 - i) * f));
    }

    public static int h(float f, float f2) {
        return floorMod((int) f, (int) f2);
    }

    public static int floorMod(int i, int i2) {
        return i - (floorDiv(i, i2) * i2);
    }

    private static int floorDiv(int i, int i2) {
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
