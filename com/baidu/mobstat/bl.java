package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobstat.br;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class bl implements br.b {
    @Override // com.baidu.mobstat.br.b
    public void a(View view, boolean z, Activity activity) {
        if (activity != null && view != null) {
            ay.a(view, activity);
            if (bk.c().b() && z) {
                bk.c().a("OnEvent view:" + view.getClass().getName() + "; content:" + bq.h(view) + "; activity:" + activity.getClass().getName());
            }
            if (bo.c().b()) {
                bo.c().a("OnEvent view:" + view.getClass().getName() + "; content:" + bq.h(view) + "; activity:" + activity.getClass().getName());
            }
            JSONArray a = bq.a(activity, view);
            String f = bq.f(view);
            Map<String, String> g = bq.g(view);
            String a2 = bq.a(view);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            String name = activity.getClass().getName();
            if (z) {
                BDStatCore.instance().onEvent(applicationContext, "", a2, 1, currentTimeMillis, a, jSONArray, name, "", f, g);
            }
            JSONObject a3 = a(activity, view, bg.a().b());
            String a4 = a(activity, view);
            bd.a().a(applicationContext, "", bq.k(view), 1, currentTimeMillis, name, a, "", jSONArray, f, g, a3, a4);
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
        float b = ao.b(activity, f);
        float b2 = ao.b(activity, f2);
        float a = ao.a(activity, bq.o(view));
        float a2 = ao.a(activity, bq.p(view));
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
        if (activity == null || view == null || (n = bq.n((a = bq.a(view, activity)))) == null) {
            return "";
        }
        String a2 = ba.a().a(activity, a, n);
        if (TextUtils.isEmpty(a2)) {
            a2 = "";
        }
        return a2;
    }
}
