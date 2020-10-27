package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a {
    private static a axw;
    private i axA;
    private Thread axx;
    private b axy;
    private com.baidu.helios.a.a.a.b axz;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a axB;

        @Override // java.lang.Runnable
        public void run() {
            if (this.axB.axA != null) {
                this.axB.axA.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0138a {
        private static C0138a axC;

        private C0138a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.axw == null) {
                synchronized (a.class) {
                    if (a.axw == null) {
                        a unused = a.axw = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.axw.j = new HashMap();
            a.axw.j.put("Charset", "utf-8");
            a.axw.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.axw.axz = new com.baidu.helios.a.a.b.a();
        }

        public static C0138a am(Context context) {
            if (axC == null) {
                synchronized (a.class) {
                    if (axC == null) {
                        axC = new C0138a(context);
                    }
                }
            }
            return axC;
        }

        public a Ar() {
            if (a.axw.axz == null) {
                a();
            }
            return a.axw;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.axA = new m(context);
    }

    /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private Runnable Ap() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.axy = new f(a.this.m);
                boolean z = false;
                if (a.this.axA != null) {
                    a.this.axA.r(a.this.axy.As());
                    z = a.this.axA.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.axx = null;
            }
        };
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url should not be empty");
        }
        return this.k == null ? str : o.c(str, this.k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        com.baidu.helios.a.a.a.c Av;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.axz != null && (Av = this.axz.Av()) != null) {
            str = Av.a(a2, "POST", this.j, this.axy.As());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.axA != null) {
            this.axA.b(this.axy.As());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    public void Ao() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.axx == null) {
                    this.axx = new Thread(Ap());
                }
                this.axx.start();
            }
        }
    }
}
