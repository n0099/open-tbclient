package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.util.Base64;
import com.baidu.fsg.base.statistics.r;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5323a = "LogSender";

    /* renamed from: b  reason: collision with root package name */
    public static final int f5324b = 10000;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5325c = 10001;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static l f5326a = new l(null);
    }

    public /* synthetic */ l(m mVar) {
        this();
    }

    public static l a() {
        return a.f5326a;
    }

    public void a(String str) {
    }

    public void b(String str) {
        Context appContext;
        StringBuilder sb = new StringBuilder();
        sb.append("=====sendLogData=====");
        sb.append(str);
        LogUtil.d(f5323a, sb.toString() == "normal_log" ? "normal" : "crash");
        if ((str.equals(b.o) && f.a().c()) || (appContext = RimStatisticsUtil.getAppContext()) == null || !com.baidu.fsg.base.statistics.a.a(appContext)) {
            return;
        }
        JSONArray jSONArray = null;
        h[] b2 = i.a(RimStatisticsUtil.getAppContext()).b();
        if ("normal_log".equalsIgnoreCase(str)) {
            jSONArray = a(b2);
        } else if (b.o.equalsIgnoreCase(str)) {
            o oVar = new o(RimStatisticsUtil.getAppContext(), a(f.a().d(), "exception"));
            oVar.setResponseCallback(new m(this, str));
            oVar.execBean();
            return;
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        a(a(jSONArray, "array"), new n(this, str, b2));
    }

    public l() {
    }

    public String a(JSONArray jSONArray, String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(j.c().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
            jSONObject = null;
        }
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        return jSONObject.toString();
    }

    private JSONArray a(h[] hVarArr) {
        JSONArray jSONArray = new JSONArray();
        for (h hVar : hVarArr) {
            LogUtil.d(f5323a, hVar.a().toString());
            jSONArray.put(hVar.a());
        }
        return jSONArray;
    }

    private void a(String str, r.a aVar) {
        if (str == null || str.trim().length() == 0) {
            return;
        }
        String str2 = str.toString();
        try {
            r rVar = new r();
            String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
            HashMap hashMap = new HashMap();
            hashMap.put("publish_data", encodeToString);
            String signKey = RimStatisticsUtil.getInstance().getSignKey();
            hashMap.put("sign", com.baidu.fsg.base.statistics.a.a((encodeToString + signKey).getBytes("GBK"), false));
            hashMap.put("mk", "rim");
            rVar.a(b.l, hashMap, aVar);
        } catch (Exception unused) {
            aVar.b();
        }
    }
}
