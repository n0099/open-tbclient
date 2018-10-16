package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Base64;
import com.baidu.fsg.base.statistics.s;
import com.baidu.fsg.base.utils.LogUtil;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class l {
    private static final String a = "LogSender";
    private static final int c = 10000;
    private static final int d = 10001;
    private HandlerThread b;
    private Handler e;

    /* synthetic */ l(m mVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {
        private static l a = new l(null);

        private a() {
        }
    }

    private l() {
        this.b = new HandlerThread("LogSenderThread");
        this.b.start();
        this.e = new m(this, this.b.getLooper());
    }

    public static l a() {
        return a.a;
    }

    public void a(String str) {
        this.e.obtainMessage(10000, str).sendToTarget();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        Context appContext;
        LogUtil.d(a, new StringBuilder().append("=====sendLogData=====").append(str).toString() == b.p ? "normal" : "crash");
        if ((!str.equals(b.o) || !f.a().c()) && (appContext = RimStatisticsUtil.getAppContext()) != null && com.baidu.fsg.base.statistics.a.a(appContext)) {
            JSONArray jSONArray = null;
            h[] b = i.a(RimStatisticsUtil.getAppContext()).b();
            String str2 = b.j;
            if (b.p.equalsIgnoreCase(str)) {
                jSONArray = a(b);
                str2 = b.j;
            } else if (b.o.equalsIgnoreCase(str)) {
                p pVar = new p(RimStatisticsUtil.getAppContext(), a(f.a().d(), b.k));
                pVar.setResponseCallback(new n(this, str));
                pVar.execBean();
                return;
            }
            if (jSONArray != null && jSONArray.length() != 0) {
                a(a(jSONArray, str2), new o(this, str, b));
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
            LogUtil.d(a, hVar.a().toString());
            jSONArray.put(hVar.a());
        }
        return jSONArray;
    }

    private void a(String str, s.a aVar) {
        if (str != null && str.trim().length() != 0) {
            String str2 = str.toString();
            try {
                s sVar = new s();
                if (sVar != null) {
                    String encodeToString = Base64.encodeToString(str2.getBytes(), 2);
                    HashMap hashMap = new HashMap();
                    hashMap.put(b.g, encodeToString);
                    hashMap.put("sign", com.baidu.fsg.base.statistics.a.a((encodeToString + RimStatisticsUtil.getInstance().getSignKey()).getBytes("GBK"), false));
                    hashMap.put(b.i, "rim");
                    sVar.a(b.l, hashMap, aVar);
                }
            } catch (Exception e) {
                aVar.b();
            }
        }
    }
}
