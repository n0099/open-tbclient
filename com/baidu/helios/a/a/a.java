package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static a asi;
    private b asj;
    private com.baidu.helios.a.a.a.b ask;
    private i asl;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a asn;

        @Override // java.lang.Runnable
        public void run() {
            if (this.asn.asl != null) {
                this.asn.asl.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0118a {
        private static C0118a aso;

        private C0118a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.asi == null) {
                synchronized (a.class) {
                    if (a.asi == null) {
                        a unused = a.asi = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.asi.j = new HashMap();
            a.asi.j.put("Charset", "utf-8");
            a.asi.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.asi.ask = new com.baidu.helios.a.a.b.a();
        }

        public static C0118a am(Context context) {
            if (aso == null) {
                synchronized (a.class) {
                    if (aso == null) {
                        aso = new C0118a(context);
                    }
                }
            }
            return aso;
        }

        public a uT() {
            if (a.asi.ask == null) {
                a();
            }
            return a.asi;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.asl = new m(context);
    }

    /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        return this.k == null ? str : o.b(str, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        com.baidu.helios.a.a.a.c uX;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.ask != null && (uX = this.ask.uX()) != null) {
            str = uX.a(a2, "POST", this.j, this.asj.uU());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.asl != null) {
            this.asl.b(this.asj.uU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable uR() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.asj = new f(a.this.m);
                boolean z = false;
                if (a.this.asl != null) {
                    a.this.asl.s(a.this.asj.uU());
                    z = a.this.asl.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.d = null;
            }
        };
    }

    public void uQ() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.d == null) {
                    this.d = new Thread(uR());
                }
                this.d.start();
            }
        }
    }
}
