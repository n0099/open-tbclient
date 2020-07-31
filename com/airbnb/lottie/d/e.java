package com.airbnb.lottie.d;

import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.FloatRange;
import com.airbnb.lottie.a.a.j;
import com.airbnb.lottie.model.content.h;
import java.util.List;
/* loaded from: classes20.dex */
public class e {
    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static void a(h hVar, Path path) {
        path.reset();
        PointF iM = hVar.iM();
        path.moveTo(iM.x, iM.y);
        PointF pointF = new PointF(iM.x, iM.y);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= hVar.iN().size()) {
                break;
            }
            com.airbnb.lottie.model.a aVar = hVar.iN().get(i2);
            PointF hR = aVar.hR();
            PointF hS = aVar.hS();
            PointF hT = aVar.hT();
            if (hR.equals(pointF) && hS.equals(hT)) {
                path.lineTo(hT.x, hT.y);
            } else {
                path.cubicTo(hR.x, hR.y, hS.x, hS.y, hT.x, hT.y);
            }
            pointF.set(hT.x, hT.y);
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(float f, float f2) {
        return j((int) f, (int) f2);
    }

    private static int j(int i, int i2) {
        return i - (k(i, i2) * i2);
    }

    private static int k(int i, int i2) {
        int i3 = i / i2;
        return (((i ^ i2) >= 0) || i % i2 == 0) ? i3 : i3 - 1;
    }

    public static int clamp(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static float clamp(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static boolean d(float f, float f2, float f3) {
        return f >= f2 && f <= f3;
    }

    public static void a(com.airbnb.lottie.model.e eVar, int i, List<com.airbnb.lottie.model.e> list, com.airbnb.lottie.model.e eVar2, j jVar) {
        if (eVar.i(jVar.getName(), i)) {
            list.add(eVar2.bf(jVar.getName()).a(jVar));
        }
    }
}
