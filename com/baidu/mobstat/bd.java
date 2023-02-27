package com.baidu.mobstat;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.text.TextUtils;
import android.view.View;
import com.baidu.android.common.others.IStringUtil;
import com.baidu.mobstat.bj;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class bd implements bj.b {
    private String a(Activity activity, View view2) {
        View a;
        View o;
        if (activity == null || view2 == null || (o = bi.o((a = bi.a(view2, activity)))) == null) {
            return "";
        }
        String a2 = as.a().a(activity, a, o);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }

    private JSONObject a(Activity activity, View view2, PointF pointF) {
        int[] iArr;
        if (pointF == null) {
            return null;
        }
        view2.getLocationOnScreen(new int[2]);
        float f = pointF.x - iArr[0];
        float f2 = pointF.y - iArr[1];
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        float b = ag.b(activity, f);
        float b2 = ag.b(activity, f2);
        float a = ag.a(activity, bi.p(view2));
        float a2 = ag.a(activity, bi.q(view2));
        if (a == 0.0f || a2 == 0.0f) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = new DecimalFormat("0.0");
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator(IStringUtil.EXTENSION_SEPARATOR);
            decimalFormat.setDecimalFormatSymbols(decimalFormatSymbols);
            jSONObject.put("x", decimalFormat.format(b));
            jSONObject.put("y", decimalFormat.format(b2));
            jSONObject.put(Config.EVENT_HEAT_XP, decimalFormat.format((b * 100.0f) / a));
            jSONObject.put(Config.EVENT_HEAT_YP, decimalFormat.format((b2 * 100.0f) / a2));
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    @Override // com.baidu.mobstat.bj.b
    public void a(View view2, boolean z, Activity activity) {
        if (activity != null && view2 != null) {
            aq.a(view2, activity);
            if (bc.c().b() && z) {
                bc c = bc.c();
                c.a("OnEvent view:" + view2.getClass().getName() + "; content:" + bi.h(view2) + "; activity:" + activity.getClass().getName());
            }
            if (bg.c().b()) {
                bg c2 = bg.c();
                c2.a("OnEvent view:" + view2.getClass().getName() + "; content:" + bi.h(view2) + "; activity:" + activity.getClass().getName());
            }
            JSONArray a = bi.a(activity, view2);
            String f = bi.f(view2);
            Map<String, String> g = bi.g(view2);
            String a2 = bi.a(view2);
            Context applicationContext = activity.getApplicationContext();
            long currentTimeMillis = System.currentTimeMillis();
            JSONArray jSONArray = new JSONArray();
            String name = activity.getClass().getName();
            if (z) {
                BDStatCore.instance().onEvent(applicationContext, "", a2, 1, currentTimeMillis, a, jSONArray, name, "", f, g);
            }
            JSONObject a3 = a(activity, view2, ay.a().b());
            String a4 = a(activity, view2);
            String l = bi.l(view2);
            JSONArray jSONArray2 = new JSONArray();
            Map<String, String> a5 = bi.a(bi.a(view2, activity), false);
            String str = "";
            if (!TextUtils.isEmpty(a4) && a5 != null && a5.size() > 0 && !TextUtils.isEmpty(a5.get("content"))) {
                str = a5.get("content");
            }
            av.a().a(applicationContext, "", l, str, 1, currentTimeMillis, name, a, "", jSONArray, f, g, a3, a4, jSONArray2);
        }
    }
}
