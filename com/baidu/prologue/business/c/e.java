package com.baidu.prologue.business.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.prologue.a.c.m;
import com.baidu.prologue.business.data.SplashStyleRecorder;
import org.json.JSONObject;
/* loaded from: classes19.dex */
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
            Context Xq = com.baidu.prologue.a.b.a.bSV.get().Xq();
            marginLayoutParams.setMargins(m.dip2px(Xq, iArr[0]), m.dip2px(Xq, iArr[1]), m.dip2px(Xq, iArr[2]), m.dip2px(Xq, iArr[3]));
        }
    }

    public static void a(View view, SplashStyleRecorder.SplashElements splashElements, boolean z) {
        JSONObject a2 = SplashStyleRecorder.a(splashElements, z);
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            JSONObject b = a2 == null ? SplashStyleRecorder.b(splashElements, z) : a2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                a((RelativeLayout.LayoutParams) layoutParams, b);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, JSONObject jSONObject) {
        if (jSONObject != null) {
            int ao = SplashStyleRecorder.ao(jSONObject);
            int[] ap = SplashStyleRecorder.ap(jSONObject);
            a(layoutParams, ao);
            a(layoutParams, ap);
        }
    }
}
