package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1942a = f.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private JSONArray f1943b;
    private byte[] c;
    private byte[] d;
    private byte[] e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static f f1946a = new f();

        private b() {
        }
    }

    private f() {
        this.f1943b = new JSONArray();
        this.c = new byte[0];
        this.d = new byte[0];
        this.e = new byte[0];
    }

    public static f a() {
        return b.f1946a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        synchronized (this.d) {
            try {
                this.f1943b.put(this.f1943b.length(), jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void b() {
        String str;
        Context appContext = RimStatisticsUtil.getAppContext();
        if (com.baidu.fsg.base.statistics.a.c(appContext, com.baidu.fsg.base.statistics.b.n)) {
            String a2 = com.baidu.fsg.base.statistics.a.a(appContext, com.baidu.fsg.base.statistics.b.n);
            if (!TextUtils.isEmpty(a2)) {
                if ((a2 == null || a2.getBytes().length <= 102400) && d.a().a(appContext, a2)) {
                    try {
                        if (a2.getBytes().length > 51200) {
                            byte[] bArr = new byte[com.baidu.fsg.base.statistics.b.c];
                            a2.getBytes(0, com.baidu.fsg.base.statistics.b.c, bArr, 0);
                            str = new String(bArr);
                        } else {
                            str = a2;
                        }
                    } catch (Exception e) {
                        str = a2;
                    }
                    try {
                        JSONArray jSONArray = new JSONArray(str);
                        long currentTimeMillis = System.currentTimeMillis();
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                            if (currentTimeMillis - jSONObject.getLong(c.f1936a) <= 604800000) {
                                a().a(jSONObject);
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1944a;

        /* renamed from: b  reason: collision with root package name */
        public String f1945b;
        public h[] c;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        boolean z;
        synchronized (this.d) {
            z = this.f1943b.length() == 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (com.baidu.fsg.base.statistics.b.o.equals(str)) {
            synchronized (this.d) {
                this.f1943b = new JSONArray();
            }
            com.baidu.fsg.base.statistics.a.a(RimStatisticsUtil.getAppContext(), com.baidu.fsg.base.statistics.b.n, "{}", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray d() {
        return this.f1943b;
    }
}
