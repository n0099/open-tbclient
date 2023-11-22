package com.baidu.android.pushservice.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.j;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.l.d;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
import com.baidu.tieba.o6c;
import com.baidu.tieba.r4c;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import com.tencent.connect.common.Constants;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    public static final ConcurrentLinkedQueue<Long> e = new ConcurrentLinkedQueue<>();
    public static final ConcurrentLinkedQueue<Long> f = new ConcurrentLinkedQueue<>();
    public static final ConcurrentLinkedQueue<Long> g = new ConcurrentLinkedQueue<>();
    public static final ConcurrentLinkedQueue<Long> h = new ConcurrentLinkedQueue<>();
    public static volatile a i;
    public Context c;
    public String a = "";
    public String b = "";
    public Timer d = null;

    /* renamed from: com.baidu.android.pushservice.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0033a extends c {
        public C0033a() {
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            try {
                a.this.d();
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends TimerTask {
        public b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                a.this.f();
            } catch (Exception unused) {
            }
        }
    }

    public a(Context context) {
        this.c = context;
    }

    public static a a(Context context) {
        if (i == null) {
            synchronized (a.class) {
                if (i == null) {
                    i = new a(context);
                }
            }
        }
        return i;
    }

    public final String a(String str, String str2) {
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue = g;
        long j = 0;
        long longValue = (concurrentLinkedQueue == null || concurrentLinkedQueue.size() <= 0) ? 0L : g.poll().longValue();
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue2 = h;
        if (concurrentLinkedQueue2 != null && concurrentLinkedQueue2.size() > 0) {
            j = h.poll().longValue();
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put(Constants.PARAM_PLATFORM, 0);
            jSONObject2.put("token", str);
            jSONObject2.put("cost", j);
            jSONObject3.put(Constants.PARAM_PLATFORM, 9);
            jSONObject3.put("token", str2);
            jSONObject3.put("cost", longValue);
            jSONArray.put(jSONObject2);
            jSONArray.put(jSONObject3);
            jSONObject.put("info", jSONArray);
        } catch (JSONException unused) {
        }
        j.a(this.c, 5, str);
        j.a(this.c, 10, str2);
        return jSONObject.toString();
    }

    public synchronized void a(String str) {
        this.a = str;
        try {
            a(false);
            if (a()) {
                if (this.d != null) {
                    this.d.cancel();
                }
                f();
            }
        } catch (Exception unused) {
        }
    }

    public final void a(boolean z) {
        ConcurrentLinkedQueue<Long> concurrentLinkedQueue;
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        if (z) {
            if (e.size() > 0) {
                valueOf = e.poll();
            }
            concurrentLinkedQueue = h;
        } else {
            if (f.size() > 0) {
                valueOf = f.poll();
            }
            concurrentLinkedQueue = g;
        }
        concurrentLinkedQueue.add(Long.valueOf(System.currentTimeMillis() - valueOf.longValue()));
    }

    public final boolean a() {
        if (d.g(this.c) == 1) {
            return (TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.a)) ? false : true;
        }
        return !TextUtils.isEmpty(d.g(this.c) == 2 ? this.a : this.b);
    }

    public String b() {
        f.add(Long.valueOf(System.currentTimeMillis()));
        try {
            r4c.a().b(this.c, true);
        } catch (Throwable unused) {
        }
        return this.a;
    }

    public synchronized void b(String str) {
        this.b = str;
        try {
            a(true);
            if (a()) {
                if (this.d != null) {
                    this.d.cancel();
                }
                f();
            }
        } catch (Exception unused) {
        }
    }

    public String c() {
        e.add(Long.valueOf(System.currentTimeMillis()));
        try {
            String token = HmsInstanceId.getInstance(this.c).getToken(o6c.c(this.c).a("client/app_id"), HmsMessaging.DEFAULT_TOKEN_SCOPE);
            this.b = token;
            if (!TextUtils.isEmpty(token)) {
                a(true);
            }
        } catch (Throwable unused) {
            PushSettings.h = 1;
            i.b(this.c, "com.baidu.android.pushservice.PushSettings.hw_hms_down_mode", 1);
            Utility.W(this.c);
        }
        return this.b;
    }

    public void d() {
        if (this.d == null) {
            this.d = new Timer();
        }
        b bVar = new b();
        g();
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.a)) {
            if (d.g(this.c) == 1) {
                e.b(this.c, a(this.b, this.a));
            } else if (d.g(this.c) == 2) {
                e.a(this.c, this.a);
            } else {
                e.a(this.c, this.b, 5);
            }
        }
        if (!TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
            if (d.g(this.c) == 2) {
                e.a(this.c, this.a);
            } else {
                this.d.schedule(bVar, 3000L);
            }
        }
        if (!TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.a)) {
            if (d.g(this.c) == 2 || d.g(this.c) == 1) {
                this.d.schedule(bVar, 3000L);
            } else {
                e.a(this.c, this.b, 5);
            }
        }
        if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
            this.d.schedule(bVar, 3000L);
        }
    }

    public void e() {
        com.baidu.android.pushservice.z.e.a().a(new C0033a());
    }

    public final void f() {
        boolean z = System.currentTimeMillis() - j.d(this.c) <= 86400000;
        if (TextUtils.isEmpty(this.b) && z) {
            this.b = j.b(this.c);
            a(true);
        }
        if (TextUtils.isEmpty(this.a) && z) {
            this.a = j.a(this.c);
            a(false);
        }
        if (!TextUtils.isEmpty(this.b) && !TextUtils.isEmpty(this.a)) {
            if (d.g(this.c) == 1) {
                e.b(this.c, a(this.b, this.a));
            } else if (d.g(this.c) == 2) {
                e.a(this.c, this.a);
            } else {
                e.a(this.c, this.b, 5);
            }
        }
        if (!TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
            if (d.g(this.c) == 1) {
                e.b(this.c, a("", this.a));
            } else {
                e.a(this.c, this.a);
            }
        }
        if (!TextUtils.isEmpty(this.b) && TextUtils.isEmpty(this.a)) {
            e.a(this.c, this.b, 5);
        }
        if (TextUtils.isEmpty(this.a) && TextUtils.isEmpty(this.b)) {
            e.a(this.c, 0);
        }
    }

    public final void g() {
        if (d.g(this.c) == 1) {
            if (TextUtils.isEmpty(this.b)) {
                c();
            }
            if (!TextUtils.isEmpty(this.a)) {
                return;
            }
        } else if (d.g(this.c) != 2) {
            if (TextUtils.isEmpty(this.b)) {
                c();
                return;
            }
            return;
        } else if (!TextUtils.isEmpty(this.a)) {
            return;
        }
        b();
    }
}
