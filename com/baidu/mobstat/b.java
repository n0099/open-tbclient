package com.baidu.mobstat;

import android.content.Context;
import android.telephony.TelephonyManager;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b {
    static String a = "Android";
    String b;
    String f;
    String g;
    int h;
    int i;
    String k;
    String l;
    String m;
    String n;
    String o;
    String p;
    String q;
    String r;
    String c = null;
    String d = null;
    int e = -1;
    String j = null;

    public synchronized void a(Context context) {
        com.baidu.mobstat.a.c.d(context, "android.permission.READ_PHONE_STATE");
        com.baidu.mobstat.a.c.d(context, "android.permission.INTERNET");
        com.baidu.mobstat.a.c.d(context, "android.permission.ACCESS_NETWORK_STATE");
        com.baidu.mobstat.a.c.d(context, "android.permission.WRITE_SETTINGS");
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.b = CooperService.getOSVersion();
        this.l = CooperService.getPhoneModel();
        this.g = CooperService.getDeviceId(telephonyManager, context);
        try {
            this.q = CooperService.getMacID(context);
        } catch (Exception e) {
            com.baidu.mobstat.a.e.a(e);
        }
        try {
            this.r = y.a();
        } catch (Exception e2) {
            com.baidu.mobstat.a.e.a(e2);
        }
        this.d = CooperService.getCUID(context, true);
        try {
            this.k = CooperService.getOperator(telephonyManager);
        } catch (Exception e3) {
            com.baidu.mobstat.a.e.a(e3);
        }
        try {
            this.h = y.a(context);
            this.i = y.b(context);
            if (context.getResources().getConfiguration().orientation == 2) {
                com.baidu.mobstat.a.e.a("statsdk", "Configuration.ORIENTATION_LANDSCAPE");
                this.h ^= this.i;
                this.i = this.h ^ this.i;
                this.h ^= this.i;
            }
        } catch (Exception e4) {
            com.baidu.mobstat.a.e.a(e4);
        }
        this.j = CooperService.getAppChannel(context);
        this.c = CooperService.getAppKey(context);
        try {
            this.e = CooperService.getAppVersionCode(context);
            this.f = CooperService.getAppVersionName(context);
        } catch (Exception e5) {
            com.baidu.mobstat.a.e.a(e5);
        }
        try {
            if (CooperService.checkCellLocationSetting(context)) {
                this.m = y.e(context);
            } else {
                this.m = "0_0_0";
            }
        } catch (Exception e6) {
            com.baidu.mobstat.a.e.a(e6);
        }
        try {
            if (CooperService.checkGPSLocationSetting(context)) {
                this.n = y.f(context);
            } else {
                this.n = "";
            }
        } catch (Exception e7) {
            com.baidu.mobstat.a.e.a(e7);
        }
        try {
            if (CooperService.checkWifiLocationSetting(context)) {
                this.o = y.h(context);
            } else {
                this.o = "";
            }
        } catch (Exception e8) {
            com.baidu.mobstat.a.e.a(e8);
        }
        try {
            this.p = CooperService.getLinkedWay(context);
        } catch (Exception e9) {
            com.baidu.mobstat.a.e.a(e9);
        }
    }

    public synchronized void b(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        JSONObject jSONObject5;
        JSONObject jSONObject6;
        JSONObject jSONObject7;
        JSONObject jSONObject8;
        JSONObject jSONObject9;
        JSONObject jSONObject10;
        JSONObject jSONObject11;
        JSONObject jSONObject12;
        JSONObject jSONObject13;
        JSONObject jSONObject14;
        JSONObject jSONObject15;
        JSONObject jSONObject16;
        JSONObject jSONObject17;
        JSONObject jSONObject18;
        JSONObject jSONObject19;
        JSONObject jSONObject20;
        JSONObject jSONObject21;
        JSONObject jSONObject22;
        JSONObject jSONObject23;
        JSONObject jSONObject24;
        JSONObject jSONObject25;
        JSONObject jSONObject26;
        JSONObject jSONObject27;
        jSONObject = DataCore.b;
        if (jSONObject.length() <= 0) {
            StringBuilder append = new StringBuilder().append("installHeader header=");
            jSONObject2 = DataCore.b;
            com.baidu.mobstat.a.e.a("sdkstat", append.append(jSONObject2).toString());
            a(context);
            try {
                jSONObject3 = DataCore.b;
                jSONObject3.put("o", a == null ? "" : a);
                jSONObject4 = DataCore.b;
                jSONObject4.put("s", this.b == null ? "" : this.b);
                jSONObject5 = DataCore.b;
                jSONObject5.put("k", this.c == null ? "" : this.c);
                jSONObject6 = DataCore.b;
                jSONObject6.put("i", "");
                jSONObject7 = DataCore.b;
                jSONObject7.put("v", "3.4.1.1");
                jSONObject8 = DataCore.b;
                jSONObject8.put("a", this.e);
                jSONObject9 = DataCore.b;
                jSONObject9.put("n", this.f == null ? "" : this.f);
                jSONObject10 = DataCore.b;
                jSONObject10.put("d", "");
                jSONObject11 = DataCore.b;
                jSONObject11.put("mc", this.q == null ? "" : this.q);
                jSONObject12 = DataCore.b;
                jSONObject12.put("bm", this.r == null ? "" : this.r);
                jSONObject13 = DataCore.b;
                jSONObject13.put("dd", this.g == null ? "" : this.g);
                jSONObject14 = DataCore.b;
                jSONObject14.put("ii", this.d == null ? "" : this.d);
                jSONObject15 = DataCore.b;
                jSONObject15.put("tg", 1);
                jSONObject16 = DataCore.b;
                jSONObject16.put("w", this.h);
                jSONObject17 = DataCore.b;
                jSONObject17.put("h", this.i);
                jSONObject18 = DataCore.b;
                jSONObject18.put("c", this.j == null ? "" : this.j);
                jSONObject19 = DataCore.b;
                jSONObject19.put("op", this.k == null ? "" : this.k);
                jSONObject20 = DataCore.b;
                jSONObject20.put("m", this.l == null ? "" : this.l);
                jSONObject21 = DataCore.b;
                jSONObject21.put("cl", this.m);
                jSONObject22 = DataCore.b;
                jSONObject22.put("gl", this.n == null ? "" : this.n);
                jSONObject23 = DataCore.b;
                jSONObject23.put("wl", this.o == null ? "" : this.o);
                jSONObject24 = DataCore.b;
                jSONObject24.put("l", this.p == null ? "" : this.p);
                jSONObject25 = DataCore.b;
                jSONObject25.put("t", System.currentTimeMillis());
                jSONObject26 = DataCore.b;
                jSONObject26.put("sq", 0);
                jSONObject27 = DataCore.b;
                com.baidu.mobstat.a.e.a("statsdk", jSONObject27.toString());
            } catch (JSONException e) {
                com.baidu.mobstat.a.e.a("statsdk", "header ini error");
                throw new RuntimeException("header ini error");
            }
        }
    }
}
