package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    private static a awJ;
    private Thread awK;
    private b awL;
    private com.baidu.helios.a.a.a.b awM;
    private i awN;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a awO;

        @Override // java.lang.Runnable
        public void run() {
            if (this.awO.awN != null) {
                this.awO.awN.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0134a {
        private static C0134a awP;

        private C0134a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.awJ == null) {
                synchronized (a.class) {
                    if (a.awJ == null) {
                        a unused = a.awJ = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.awJ.j = new HashMap();
            a.awJ.j.put("Charset", "utf-8");
            a.awJ.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.awJ.awM = new com.baidu.helios.a.a.b.a();
        }

        public static C0134a ao(Context context) {
            if (awP == null) {
                synchronized (a.class) {
                    if (awP == null) {
                        awP = new C0134a(context);
                    }
                }
            }
            return awP;
        }

        public a zA() {
            if (a.awJ.awM == null) {
                a();
            }
            return a.awJ;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.awN = new m(context);
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
        com.baidu.helios.a.a.a.c zE;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.awM != null && (zE = this.awM.zE()) != null) {
            str = zE.a(a2, "POST", this.j, this.awL.zB());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.awN != null) {
            this.awN.b(this.awL.zB());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable zy() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.awL = new f(a.this.m);
                boolean z = false;
                if (a.this.awN != null) {
                    a.this.awN.l(a.this.awL.zB());
                    z = a.this.awN.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.awK = null;
            }
        };
    }

    public void zx() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.awK == null) {
                    this.awK = new Thread(zy());
                }
                this.awK.start();
            }
        }
    }
}
