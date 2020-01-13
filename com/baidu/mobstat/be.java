package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.bk;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class be implements bk.b {
    @Override // com.baidu.mobstat.bk.b
    public void a(View view, boolean z, Activity activity) {
        if (activity != null && view != null) {
            ar.a(view, activity);
            if (bd.c().b() && z) {
                bd.c().a("OnEvent view:" + view.getClass().getName() + "; content:" + bj.h(view) + "; activity:" + activity.getClass().getName());
            }
            if (bh.c().b()) {
                bh.c().a("OnEvent view:" + view.getClass().getName() + "; content:" + bj.h(view) + "; activity:" + activity.getClass().getName());
            }
            JSONArray a = bj.a(activity, view);
            String f = bj.f(view);
            Map<String, String> g = bj.g(view);
            String a2 = bj.a(view);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            String name = activity.getClass().getName();
            if (z) {
                BDStatCore.instance().onEvent(applicationContext, "", a2, 1, currentTimeMillis, a, jSONArray, name, "", f, g);
            }
            JSONObject a3 = a(activity, view, az.a().b());
            String a4 = a(activity, view);
            aw.a().a(applicationContext, "", bj.k(view), 1, currentTimeMillis, name, a, "", jSONArray, f, g, a3, a4);
        }
    }

    private JSONObject a(Activity activity, View view, PointF pointF) {
        int[] iArr;
        if (pointF == null) {
            return null;
        }
        view.getLocationOnScreen(new int[2]);
        float f = pointF.x - iArr[0];
        float f2 = pointF.y - iArr[1];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float b = ah.b(activity, f);
        float b2 = ah.b(activity, f2);
        float a = ah.a(activity, bj.o(view));
        float a2 = ah.a(activity, bj.p(view));
        if (a == 0.0f || a2 == 0.0f) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put(Config.EVENT_HEAT_X, decimalFormat.format(b));
            jSONObject.put("y", decimalFormat.format(b2));
            jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((b * 100.0f) / a));
            jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((b2 * 100.0f) / a2));
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    private String a(Activity activity, View view) {
        View a;
        View n;
        if (activity == null || view == null || (n = bj.n((a = bj.a(view, activity)))) == null) {
            return "";
        }
        String a2 = at.a().a(activity, a, n);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return a2;
    }
}
