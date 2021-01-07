package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.util.Base64;
import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2004a = "LogSender";

    /* renamed from: b  reason: collision with root package name */
    private static final int f2005b = 10000;
    private static final int c = 10001;

    /* synthetic */ l(m mVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static l f2006a = new l(null);

        private a() {
        }
    }

    private l() {
    }

    public static l a() {
        return a.f2006a;
    }

    public void a(String str) {
    }

    void b(String str) {
        Context appContext;
        LogUtil.d(f2004a, new StringBuilder().append("=====sendLogData=====").append(str).toString() == b.p ? "normal" : "crash");
        if ((!str.equals(b.o) || !f.a().c()) && (appContext = RimStatisticsUtil.getAppContext()) != null && com.baidu.fsg.base.statistics.a.a(appContext)) {
            JSONArray jSONArray = null;
            h[] b2 = i.a(RimStatisticsUtil.getAppContext()).b();
            String str2 = b.j;
            if (b.p.equalsIgnoreCase(str)) {
                jSONArray = a(b2);
                str2 = b.j;
            } else if (b.o.equalsIgnoreCase(str)) {
                o oVar = new o(RimStatisticsUtil.getAppContext(), a(f.a().d(), "exception"));
                oVar.setResponseCallback(new m(this, str));
                oVar.execBean();
                return;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                a(a(jSONArray, str2), new n(this, str, b2));
            }
        }
    }

    String a(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(j.c().a());
        } catch (JSONException e) {
            e.printStackTrace();
            jSONObject = null;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONArray a(h[] hVarArr) {
        JSONArray jSONArray = new JSONArray();
        for (h hVar : hVarArr) {
            LogUtil.d(f2004a, hVar.a().toString());
            jSONArray.put(hVar.a());
        }
        return jSONArray;
    }

    private void a(String str, r.a aVar) {
        if (str != null && str.trim().length() != 0) {
            String str2 = str.toString();
            try {
                r rVar = new r();
                if (rVar != null) {
                    String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                    HashMap hashMap = new HashMap();
                    hashMap.put(b.g, encodeToString);
                    hashMap.put("sign", com.baidu.fsg.base.statistics.a.a((encodeToString + RimStatisticsUtil.getInstance().getSignKey()).getBytes("GBK"), false));
                    hashMap.put(b.i, "rim");
                    rVar.a(b.l, hashMap, aVar);
                }
            } catch (Exception e) {
                aVar.b();
            }
        }
    }
}
