package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a arm;
    private b arn;
    private com.baidu.helios.a.a.a.b aro;
    private i arp;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a arq;

        @Override // java.lang.Runnable
        public void run() {
            if (this.arq.arp != null) {
                this.arq.arp.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0126a {
        private static C0126a arr;

        private C0126a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.arm == null) {
                synchronized (a.class) {
                    if (a.arm == null) {
                        a unused = a.arm = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.arm.j = new HashMap();
            a.arm.j.put("Charset", "utf-8");
            a.arm.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.arm.aro = new com.baidu.helios.a.a.b.a();
        }

        public static C0126a ai(Context context) {
            if (arr == null) {
                synchronized (a.class) {
                    if (arr == null) {
                        arr = new C0126a(context);
                    }
                }
            }
            return arr;
        }

        public a uy() {
            if (a.arm.aro == null) {
                a();
            }
            return a.arm;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.arp = new m(context);
    }

    /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        return this.k == null ? str : o.c(str, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        com.baidu.helios.a.a.a.c uC;
        String a = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.aro != null && (uC = this.aro.uC()) != null) {
            str = uC.a(a, "POST", this.j, this.arn.uz());
        }
        JSONObject a2 = l.a(str);
        if (a2 == null) {
            return false;
        }
        return a2.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.arp != null) {
            this.arp.b(this.arn.uz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable uw() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.arn = new f(a.this.m);
                boolean z = false;
                if (a.this.arp != null) {
                    a.this.arp.r(a.this.arn.uz());
                    z = a.this.arp.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.d = null;
            }
        };
    }

    public void uv() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.d == null) {
                    this.d = new Thread(uw());
                }
                this.d.start();
            }
        }
    }
}
