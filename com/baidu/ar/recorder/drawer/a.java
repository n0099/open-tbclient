package com.baidu.ar.recorder.drawer;

import android.util.Log;
/* loaded from: classes3.dex */
public class a {
    private static final String a = a.class.getSimpleName();

    public static void a(RectDrawableParams rectDrawableParams) {
        float f;
        float f2 = 1.0f;
        Log.d(a, "updateRectDrawableParams !!!");
        float a2 = (rectDrawableParams.a() * 1.0f) / rectDrawableParams.b();
        float c = ((rectDrawableParams.c() * 1.0f) / rectDrawableParams.d()) * 1.0f;
        if (rectDrawableParams.e() == 1) {
            if (a2 > c) {
                f = c / a2;
            } else {
                float f3 = a2 / c;
                f = 1.0f;
                f2 = f3;
            }
        } else if (rectDrawableParams.e() != 2) {
            f = 1.0f;
        } else if (a2 > c) {
            float f4 = a2 / c;
            f = 1.0f;
            f2 = f4;
        } else {
            f = c / a2;
        }
        rectDrawableParams.a(f);
        rectDrawableParams.b(f2);
    }
}
