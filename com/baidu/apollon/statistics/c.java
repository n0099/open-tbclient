package com.baidu.apollon.statistics;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3883a = "c";

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f3884b;

    /* renamed from: c  reason: collision with root package name */
    public int f3885c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3886d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3887e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3888a;

        /* renamed from: b  reason: collision with root package name */
        public String f3889b;
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f3890a = new c();
    }

    public static c a() {
        return b.f3890a;
    }

    @SuppressLint({"NewApi"})
    private void d() {
        int i = this.f3885c;
        if (i <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    this.f3884b.remove(0);
                    i = i2;
                } else {
                    this.f3885c = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField("values");
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f3884b);
                int i3 = this.f3885c;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i3 = i4;
                    } else {
                        this.f3885c = 0;
                        return;
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b() {
        if (com.baidu.apollon.statistics.a.a(PayStatisticsUtil.c(), false, Config.v)) {
            String a2 = com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v);
            if (TextUtils.isEmpty(a2) || a2.getBytes().length > 409600) {
                return;
            }
            try {
                synchronized (this.f3886d) {
                    this.f3884b = new JSONArray(a2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.f3886d) {
            z = this.f3884b.length() == 0;
        }
        return z;
    }

    public c() {
        this.f3884b = new JSONArray();
        this.f3885c = 0;
        this.f3886d = new byte[0];
        this.f3887e = new byte[0];
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f3886d) {
            try {
                this.f3884b.put(this.f3884b.length(), eVar.a());
            } catch (JSONException unused) {
            }
            a(g.a().a(eVar.f3905h));
            if (CustomerService.getInstance().isEnabled()) {
                CustomerService.getInstance().enqueEvent(eVar);
            }
        }
    }

    public void b(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f3886d) {
                d();
            }
            a(false);
        }
    }

    private void a(boolean z) {
        int i;
        synchronized (this.f3886d) {
            if (this.f3884b.length() == 0) {
                com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, "", false);
                return;
            }
            String jSONArray = this.f3884b.toString();
            try {
                i = jSONArray.getBytes().length;
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    System.gc();
                    return;
                }
                i = 0;
            }
            if (i == 0) {
                return;
            }
            if (204800 > i) {
                com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, jSONArray, false);
            }
            if (i >= 204800 || z) {
                LogSender.getInstance().triggerSending("normal_log");
            }
        }
    }

    public a a(String str) {
        JSONObject jSONObject;
        a aVar = new a();
        synchronized (this.f3887e) {
            try {
                StatisticsSettings a2 = PayStatisticsUtil.getInstance().a();
                jSONObject = a2 != null ? new JSONObject(a2.getCommonHeader()) : null;
            } catch (JSONException unused) {
                return aVar;
            }
        }
        if (jSONObject == null) {
            return aVar;
        }
        synchronized (this.f3886d) {
            try {
                jSONObject.put("array", this.f3884b);
                aVar.f3888a = this.f3884b.length();
                aVar.f3889b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return aVar;
    }

    public void a(int i, String str) {
        if ("normal_log".equals(str)) {
            this.f3885c = i;
        }
    }
}
