package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a {
    private static a atJ;
    private b atK;
    private com.baidu.helios.a.a.a.b atL;
    private i atM;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a atN;

        @Override // java.lang.Runnable
        public void run() {
            if (this.atN.atM != null) {
                this.atN.atM.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0124a {
        private static C0124a atO;

        private C0124a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.atJ == null) {
                synchronized (a.class) {
                    if (a.atJ == null) {
                        a unused = a.atJ = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.atJ.j = new HashMap();
            a.atJ.j.put("Charset", "utf-8");
            a.atJ.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.atJ.atL = new com.baidu.helios.a.a.b.a();
        }

        public static C0124a al(Context context) {
            if (atO == null) {
                synchronized (a.class) {
                    if (atO == null) {
                        atO = new C0124a(context);
                    }
                }
            }
            return atO;
        }

        public a uW() {
            if (a.atJ.atL == null) {
                a();
            }
            return a.atJ;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.atM = new m(context);
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
        com.baidu.helios.a.a.a.c va;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.atL != null && (va = this.atL.va()) != null) {
            str = va.a(a2, "POST", this.j, this.atK.uX());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.atM != null) {
            this.atM.b(this.atK.uX());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable uU() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.atK = new f(a.this.m);
                boolean z = false;
                if (a.this.atM != null) {
                    a.this.atM.u(a.this.atK.uX());
                    z = a.this.atM.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.d = null;
            }
        };
    }

    public void uT() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.d == null) {
                    this.d = new Thread(uU());
                }
                this.d.start();
            }
        }
    }
}
