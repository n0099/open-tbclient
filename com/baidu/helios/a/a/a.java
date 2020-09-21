package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes12.dex */
public class a {
    private static a awM;
    private Thread awN;
    private b awO;
    private com.baidu.helios.a.a.a.b awP;
    private i awQ;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes12.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a awR;

        @Override // java.lang.Runnable
        public void run() {
            if (this.awR.awQ != null) {
                this.awR.awQ.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static class C0134a {
        private static C0134a awS;

        private C0134a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.awM == null) {
                synchronized (a.class) {
                    if (a.awM == null) {
                        a unused = a.awM = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.awM.j = new HashMap();
            a.awM.j.put("Charset", "utf-8");
            a.awM.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.awM.awP = new com.baidu.helios.a.a.b.a();
        }

        public static C0134a aj(Context context) {
            if (awS == null) {
                synchronized (a.class) {
                    if (awS == null) {
                        awS = new C0134a(context);
                    }
                }
            }
            return awS;
        }

        public a Aj() {
            if (a.awM.awP == null) {
                a();
            }
            return a.awM;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.awQ = new m(context);
    }

    /* synthetic */ a(Context context, AnonymousClass1 anonymousClass1) {
        this(context);
    }

    private Runnable Ah() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.awO = new f(a.this.m);
                boolean z = false;
                if (a.this.awQ != null) {
                    a.this.awQ.r(a.this.awO.Ak());
                    z = a.this.awQ.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.awN = null;
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
        com.baidu.helios.a.a.a.c An;
        String a = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.awP != null && (An = this.awP.An()) != null) {
            str = An.a(a, "POST", this.j, this.awO.Ak());
        }
        JSONObject a2 = l.a(str);
        if (a2 == null) {
            return false;
        }
        return a2.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.awQ != null) {
            this.awQ.b(this.awO.Ak());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    public void Ag() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.awN == null) {
                    this.awN = new Thread(Ah());
                }
                this.awN.start();
            }
        }
    }
}
