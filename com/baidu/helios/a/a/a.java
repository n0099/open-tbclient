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
    private static a arq;
    private b arr;
    private com.baidu.helios.a.a.a.b ars;
    private i art;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a aru;

        @Override // java.lang.Runnable
        public void run() {
            if (this.aru.art != null) {
                this.aru.art.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0128a {
        private static C0128a arv;

        private C0128a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.arq == null) {
                synchronized (a.class) {
                    if (a.arq == null) {
                        a unused = a.arq = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.arq.j = new HashMap();
            a.arq.j.put("Charset", "utf-8");
            a.arq.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.arq.ars = new com.baidu.helios.a.a.b.a();
        }

        public static C0128a ai(Context context) {
            if (arv == null) {
                synchronized (a.class) {
                    if (arv == null) {
                        arv = new C0128a(context);
                    }
                }
            }
            return arv;
        }

        public a uy() {
            if (a.arq.ars == null) {
                a();
            }
            return a.arq;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.art = new m(context);
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
        if (this.ars != null && (uC = this.ars.uC()) != null) {
            str = uC.a(a, "POST", this.j, this.arr.uz());
        }
        JSONObject a2 = l.a(str);
        if (a2 == null) {
            return false;
        }
        return a2.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.art != null) {
            this.art.b(this.arr.uz());
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
                a.this.arr = new f(a.this.m);
                boolean z = false;
                if (a.this.art != null) {
                    a.this.art.r(a.this.arr.uz());
                    z = a.this.art.a();
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
