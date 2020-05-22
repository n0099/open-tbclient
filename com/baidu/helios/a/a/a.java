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
    private static a apY;
    private b apZ;
    private com.baidu.helios.a.a.a.b aqa;
    private i aqb;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a aqc;

        @Override // java.lang.Runnable
        public void run() {
            if (this.aqc.aqb != null) {
                this.aqc.aqb.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0126a {
        private static C0126a aqd;

        private C0126a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.apY == null) {
                synchronized (a.class) {
                    if (a.apY == null) {
                        a unused = a.apY = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.apY.j = new HashMap();
            a.apY.j.put("Charset", "utf-8");
            a.apY.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.apY.aqa = new com.baidu.helios.a.a.b.a();
        }

        public static C0126a ah(Context context) {
            if (aqd == null) {
                synchronized (a.class) {
                    if (aqd == null) {
                        aqd = new C0126a(context);
                    }
                }
            }
            return aqd;
        }

        public a ug() {
            if (a.apY.aqa == null) {
                a();
            }
            return a.apY;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.aqb = new m(context);
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
        com.baidu.helios.a.a.a.c uk;
        String a = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.aqa != null && (uk = this.aqa.uk()) != null) {
            str = uk.a(a, "POST", this.j, this.apZ.uh());
        }
        JSONObject a2 = l.a(str);
        if (a2 == null) {
            return false;
        }
        return a2.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.aqb != null) {
            this.aqb.b(this.apZ.uh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable ue() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.apZ = new f(a.this.m);
                boolean z = false;
                if (a.this.aqb != null) {
                    a.this.aqb.q(a.this.apZ.uh());
                    z = a.this.aqb.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.d = null;
            }
        };
    }

    public void ud() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.d == null) {
                    this.d = new Thread(ue());
                }
                this.d.start();
            }
        }
    }
}
