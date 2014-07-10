package com.baidu.tbadk.b;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.i;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private static a a = null;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    public void a(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                a(0L);
                a(false);
                a((String) null);
                a(0);
                b(0);
            } else {
                a(jSONObject.optLong("ad_time"));
                a(jSONObject.optInt("ad_enabled") == 1);
                a(jSONObject.getString("ad_url"));
                a(jSONObject.getInt("start_time"));
                b(jSONObject.getInt("end_time"));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void b() {
        String g = g();
        if (!TextUtils.isEmpty(g)) {
            com.baidu.adp.lib.resourceLoader.d.a().a(g, 10, null, 0, 0, 0, new Object[0]);
        }
    }

    public boolean c() {
        if (!h()) {
            return false;
        }
        long e = e() * 1000;
        long currentTimeMillis = System.currentTimeMillis();
        if (d() * 1000 > currentTimeMillis || currentTimeMillis > e) {
            return false;
        }
        return true;
    }

    public int d() {
        return i.a().a("ad_start_time", 0);
    }

    public int e() {
        return i.a().a("ad_end_time", 0);
    }

    public long f() {
        return i.a().a("ad_time", 0L);
    }

    public String g() {
        return i.a().b("ad_url", (String) null);
    }

    public boolean h() {
        return i.a().a("ad_enabled", false);
    }

    public void a(long j) {
        i.a().b("ad_time", j);
    }

    public void a(String str) {
        i.a().a("ad_url", str);
    }

    public void a(boolean z) {
        i.a().c("ad_enabled", z);
    }

    public void a(int i) {
        i.a().b("ad_start_time", i);
    }

    public void b(int i) {
        i.a().b("ad_end_time", i);
    }
}
