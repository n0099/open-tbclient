package com.baidu.prologue.business.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.prologue.a.c.l;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class e {
    public static final boolean DEBUG = com.baidu.prologue.a.a.a.GLOBAL_DEBUG;

    private static void a(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i > 0) {
            a(layoutParams, i, 1, 10);
            a(layoutParams, i, 2, 12);
            a(layoutParams, i, 4, 9);
            a(layoutParams, i, 8, 11);
            a(layoutParams, i, 16, 14);
            a(layoutParams, i, 32, 15);
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i, int i2, int i3) {
        if ((i & i2) == i2) {
            layoutParams.addRule(i3);
        }
    }

    private static void a(ViewGroup.MarginLayoutParams marginLayoutParams, int[] iArr) {
        if (iArr != null && iArr.length == 4) {
            Context Nt = com.baidu.prologue.a.b.a.bzx.get().Nt();
            marginLayoutParams.setMargins(l.dip2px(Nt, iArr[0]), l.dip2px(Nt, iArr[1]), l.dip2px(Nt, iArr[2]), l.dip2px(Nt, iArr[3]));
        }
    }

    public static void a(View view, SplashStyleRecorder.SplashElements splashElements, boolean z) {
        JSONObject a = SplashStyleRecorder.a(splashElements, z);
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            JSONObject b = a == null ? SplashStyleRecorder.b(splashElements, z) : a;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                a((RelativeLayout.LayoutParams) layoutParams, b);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        if (jSONObject != null) {
            int Y = SplashStyleRecorder.Y(jSONObject);
            int[] Z = SplashStyleRecorder.Z(jSONObject);
            a(layoutParams, Y);
            a(layoutParams, Z);
        }
    }
}
