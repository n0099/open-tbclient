package com.baidu.apollon.statistics;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3847a = "c";

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f3848b;

    /* renamed from: c  reason: collision with root package name */
    public int f3849c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3850d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3851e;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3852a;

        /* renamed from: b  reason: collision with root package name */
        public String f3853b;
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f3854a = new c();
    }

    public static c a() {
        return b.f3854a;
    }

    @SuppressLint({"NewApi"})
    private void d() {
        int i = this.f3849c;
        if (i <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    this.f3848b.remove(0);
                    i = i2;
                } else {
                    this.f3849c = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField("values");
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f3848b);
                int i3 = this.f3849c;
                while (true) {
                    int i4 = i3 - 1;
                    if (i3 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i3 = i4;
                    } else {
                        this.f3849c = 0;
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
                synchronized (this.f3850d) {
                    this.f3848b = new JSONArray(a2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.f3850d) {
            z = this.f3848b.length() == 0;
        }
        return z;
    }

    public c() {
        this.f3848b = new JSONArray();
        this.f3849c = 0;
        this.f3850d = new byte[0];
        this.f3851e = new byte[0];
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f3850d) {
            try {
                this.f3848b.put(this.f3848b.length(), eVar.a());
            } catch (JSONException unused) {
            }
            a(g.a().a(eVar.f3869h));
            if (CustomerService.getInstance().isEnabled()) {
                CustomerService.getInstance().enqueEvent(eVar);
            }
        }
    }

    public void b(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f3850d) {
                d();
            }
            a(false);
        }
    }

    private void a(boolean z) {
        int i;
        synchronized (this.f3850d) {
            if (this.f3848b.length() == 0) {
                com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, "", false);
                return;
            }
            String jSONArray = this.f3848b.toString();
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
        synchronized (this.f3851e) {
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
        synchronized (this.f3850d) {
            try {
                jSONObject.put("array", this.f3848b);
                aVar.f3852a = this.f3848b.length();
                aVar.f3853b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return aVar;
    }

    public void a(int i, String str) {
        if ("normal_log".equals(str)) {
            this.f3849c = i;
        }
    }
}
