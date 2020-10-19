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
    private static a axv;
    private Thread axw;
    private b axx;
    private com.baidu.helios.a.a.a.b axy;
    private i axz;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a axA;

        @Override // java.lang.Runnable
        public void run() {
            if (this.axA.axz != null) {
                this.axA.axz.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0138a {
        private static C0138a axB;

        private C0138a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.axv == null) {
                synchronized (a.class) {
                    if (a.axv == null) {
                        a unused = a.axv = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.axv.j = new HashMap();
            a.axv.j.put("Charset", "utf-8");
            a.axv.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.axv.axy = new com.baidu.helios.a.a.b.a();
        }

        public static C0138a am(Context context) {
            if (axB == null) {
                synchronized (a.class) {
                    if (axB == null) {
                        axB = new C0138a(context);
                    }
                }
            }
            return axB;
        }

        public a Ar() {
            if (a.axv.axy == null) {
                a();
            }
            return a.axv;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.axz = new m(context);
    }

    /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private Runnable Ap() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.axx = new f(a.this.m);
                boolean z = false;
                if (a.this.axz != null) {
                    a.this.axz.r(a.this.axx.As());
                    z = a.this.axz.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.axw = null;
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
        if (this.axy != null && (Av = this.axy.Av()) != null) {
            str = Av.a(a2, "POST", this.j, this.axx.As());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.axz != null) {
            this.axz.b(this.axx.As());
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
                if (this.axw == null) {
                    this.axw = new Thread(Ap());
                }
                this.axw.start();
            }
        }
    }
}
