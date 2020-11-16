package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class a {
    private static a avL;
    private Thread avM;
    private b avN;
    private com.baidu.helios.a.a.a.b avO;
    private i avP;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a avQ;

        @Override // java.lang.Runnable
        public void run() {
            if (this.avQ.avP != null) {
                this.avQ.avP.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static class C0136a {
        private static C0136a avR;

        private C0136a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.avL == null) {
                synchronized (a.class) {
                    if (a.avL == null) {
                        a unused = a.avL = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.avL.j = new HashMap();
            a.avL.j.put("Charset", "utf-8");
            a.avL.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.avL.avO = new com.baidu.helios.a.a.b.a();
        }

        public static C0136a am(Context context) {
            if (avR == null) {
                synchronized (a.class) {
                    if (avR == null) {
                        avR = new C0136a(context);
                    }
                }
            }
            return avR;
        }

        public a zI() {
            if (a.avL.avO == null) {
                a();
            }
            return a.avL;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.avP = new m(context);
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
        com.baidu.helios.a.a.a.c zM;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.avO != null && (zM = this.avO.zM()) != null) {
            str = zM.a(a2, "POST", this.j, this.avN.zJ());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.avP != null) {
            this.avP.b(this.avN.zJ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable zG() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.avN = new f(a.this.m);
                boolean z = false;
                if (a.this.avP != null) {
                    a.this.avP.l(a.this.avN.zJ());
                    z = a.this.avP.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.avM = null;
            }
        };
    }

    public void zF() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.avM == null) {
                    this.avM = new Thread(zG());
                }
                this.avM.start();
            }
        }
    }
}
