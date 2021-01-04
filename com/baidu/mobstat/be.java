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
/* loaded from: classes15.dex */
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
            JSONArray a2 = bj.a(activity, view);
            String f = bj.f(view);
            Map<String, String> g = bj.g(view);
            String a3 = bj.a(view);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            String name = activity.getClass().getName();
            if (z) {
                BDStatCore.instance().onEvent(applicationContext, "", a3, 1, currentTimeMillis, a2, jSONArray, name, "", f, g);
            }
            JSONObject a4 = a(activity, view, az.a().b());
            String a5 = a(activity, view);
            aw.a().a(applicationContext, "", bj.k(view), 1, currentTimeMillis, name, a2, "", jSONArray, f, g, a4, a5);
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
        float b2 = ah.b(activity, f);
        float b3 = ah.b(activity, f2);
        float a2 = ah.a(activity, bj.o(view));
        float a3 = ah.a(activity, bj.p(view));
        if (a2 == 0.0f || a3 == 0.0f) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put("x", decimalFormat.format(b2));
            jSONObject.put("y", decimalFormat.format(b3));
            jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((b2 * 100.0f) / a2));
            jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((b3 * 100.0f) / a3));
            return jSONObject;
        } catch (Exception e) {
            return jSONObject;
        }
    }

    private String a(Activity activity, View view) {
        View a2;
        View n;
        if (activity == null || view == null || (n = bj.n((a2 = bj.a(view, activity)))) == null) {
            return "";
        }
        String a3 = at.a().a(activity, a2, n);
        if (TextUtils.isEmpty(a3)) {
            a3 = "";
        }
        return a3;
    }
}
