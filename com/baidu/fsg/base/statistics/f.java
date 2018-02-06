package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class f {
    private static final String a = f.class.getSimpleName();
    private JSONArray b;
    private byte[] c;
    private byte[] d;
    private byte[] e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {
        private static f a = new f();

        private b() {
        }
    }

    private f() {
        this.b = new JSONArray();
        this.c = new byte[0];
        this.d = new byte[0];
        this.e = new byte[0];
    }

    public static f a() {
        return b.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONObject jSONObject) {
        synchronized (this.d) {
            try {
                this.b.put(this.b.length(), jSONObject);
            } catch (JSONException e) {
            }
        }
    }

    public void b() {
        String str;
        RimStatisticsUtil.getInstance();
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
                            if (currentTimeMillis - jSONObject.getLong(c.a) <= 604800000) {
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

    /* loaded from: classes2.dex */
    static class a {
        public int a;
        public String b;
        public h[] c;

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        boolean z;
        synchronized (this.d) {
            z = this.b.length() == 0;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (com.baidu.fsg.base.statistics.b.o.equals(str)) {
            synchronized (this.d) {
                this.b = new JSONArray();
            }
            RimStatisticsUtil.getInstance();
            com.baidu.fsg.base.statistics.a.a(RimStatisticsUtil.getAppContext(), com.baidu.fsg.base.statistics.b.n, "{}", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSONArray d() {
        return this.b;
    }
}
