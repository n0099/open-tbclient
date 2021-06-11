package com.baidu.apollon.statistics;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import androidx.lifecycle.SavedStateHandle;
import java.lang.reflect.Field;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3958a = "c";

    /* renamed from: b  reason: collision with root package name */
    public JSONArray f3959b;

    /* renamed from: c  reason: collision with root package name */
    public int f3960c;

    /* renamed from: d  reason: collision with root package name */
    public byte[] f3961d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f3962e;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f3963a;

        /* renamed from: b  reason: collision with root package name */
        public String f3964b;
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static c f3965a = new c();
    }

    public static c a() {
        return b.f3965a;
    }

    @SuppressLint({"NewApi"})
    private void d() {
        int i2 = this.f3960c;
        if (i2 <= 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 > 0) {
                    this.f3959b.remove(0);
                    i2 = i3;
                } else {
                    this.f3960c = 0;
                    return;
                }
            }
        } else {
            try {
                Field declaredField = JSONArray.class.getDeclaredField(SavedStateHandle.VALUES);
                declaredField.setAccessible(true);
                List list = (List) declaredField.get(this.f3959b);
                int i4 = this.f3960c;
                while (true) {
                    int i5 = i4 - 1;
                    if (i4 > 0) {
                        if (list.size() > 0) {
                            list.remove(0);
                        }
                        i4 = i5;
                    } else {
                        this.f3960c = 0;
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
                synchronized (this.f3961d) {
                    this.f3959b = new JSONArray(a2);
                }
            } catch (JSONException unused) {
            }
        }
    }

    public boolean c() {
        boolean z;
        synchronized (this.f3961d) {
            z = this.f3959b.length() == 0;
        }
        return z;
    }

    public c() {
        this.f3959b = new JSONArray();
        this.f3960c = 0;
        this.f3961d = new byte[0];
        this.f3962e = new byte[0];
    }

    public void a(e eVar) {
        if (eVar == null) {
            return;
        }
        synchronized (this.f3961d) {
            try {
                this.f3959b.put(this.f3959b.length(), eVar.a());
            } catch (JSONException unused) {
            }
            a(g.a().a(eVar.f3980h));
            if (CustomerService.getInstance().isEnabled()) {
                CustomerService.getInstance().enqueEvent(eVar);
            }
        }
    }

    public void b(String str) {
        if ("normal_log".equals(str)) {
            synchronized (this.f3961d) {
                d();
            }
            a(false);
        }
    }

    private void a(boolean z) {
        int i2;
        synchronized (this.f3961d) {
            if (this.f3959b.length() == 0) {
                com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, "", false);
                return;
            }
            String jSONArray = this.f3959b.toString();
            try {
                i2 = jSONArray.getBytes().length;
            } catch (Throwable th) {
                if (th instanceof OutOfMemoryError) {
                    System.gc();
                    return;
                }
                i2 = 0;
            }
            if (i2 == 0) {
                return;
            }
            if (204800 > i2) {
                com.baidu.apollon.statistics.a.a(false, PayStatisticsUtil.c(), Config.v, jSONArray, false);
            }
            if (i2 >= 204800 || z) {
                LogSender.getInstance().triggerSending("normal_log");
            }
        }
    }

    public a a(String str) {
        JSONObject jSONObject;
        a aVar = new a();
        synchronized (this.f3962e) {
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
        synchronized (this.f3961d) {
            try {
                jSONObject.put("array", this.f3959b);
                aVar.f3963a = this.f3959b.length();
                aVar.f3964b = jSONObject.toString();
            } catch (JSONException unused2) {
            }
        }
        return aVar;
    }

    public void a(int i2, String str) {
        if ("normal_log".equals(str)) {
            this.f3960c = i2;
        }
    }
}
