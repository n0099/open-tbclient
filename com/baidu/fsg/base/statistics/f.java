package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5325a = "f";

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f5326b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f5327c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f5328d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f5329e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f5330a;

        /* renamed from: b  reason: collision with root package name */
        public String f5331b;

        /* renamed from: c  reason: collision with root package name */
        public h[] f5332c;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static f f5333a = new f();
    }

    public static f a() {
        return b.f5333a;
    }

    public void b() {
        Context appContext = RimStatisticsUtil.getAppContext();
        if (com.baidu.fsg.base.statistics.a.c(appContext, com.baidu.fsg.base.statistics.b.n)) {
            String a2 = com.baidu.fsg.base.statistics.a.a(appContext, com.baidu.fsg.base.statistics.b.n);
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            if ((a2 == null || a2.getBytes().length <= 102400) && d.a().a(appContext, a2)) {
                try {
                    if (a2.getBytes().length > 51200) {
                        byte[] bArr = new byte[51200];
                        a2.getBytes(0, 51200, bArr, 0);
                        a2 = new String(bArr);
                    }
                } catch (Exception unused) {
                }
                try {
                    JSONArray jSONArray = new JSONArray(a2);
                    long currentTimeMillis = System.currentTimeMillis();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                        if (currentTimeMillis - jSONObject.getLong("dim_excep_time") <= 604800000) {
                            a().a(jSONObject);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.f5328d) {
            z = this.f5326b.length() == 0;
        }
        return z;
    }

    public JSONArray d() {
        return this.f5326b;
    }

    public f() {
        this.f5326b = new JSONArray();
        this.f5327c = new byte[0];
        this.f5328d = new byte[0];
        this.f5329e = new byte[0];
    }

    public void a(JSONObject jSONObject) {
        synchronized (this.f5328d) {
            try {
                this.f5326b.put(this.f5326b.length(), jSONObject);
            } catch (JSONException unused) {
            }
        }
    }

    public void a(String str) {
        if (com.baidu.fsg.base.statistics.b.o.equals(str)) {
            synchronized (this.f5328d) {
                this.f5326b = new JSONArray();
            }
            com.baidu.fsg.base.statistics.a.a(RimStatisticsUtil.getAppContext(), com.baidu.fsg.base.statistics.b.n, StringUtil.EMPTY_ARRAY, false);
        }
    }
}
