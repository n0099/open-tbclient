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
    private static a ast;
    private b asu;
    private com.baidu.helios.a.a.a.b asv;
    private i asw;
    private Thread d;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes14.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a asx;

        @Override // java.lang.Runnable
        public void run() {
            if (this.asx.asw != null) {
                this.asx.asw.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public static class C0118a {
        private static C0118a asy;

        private C0118a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.ast == null) {
                synchronized (a.class) {
                    if (a.ast == null) {
                        a unused = a.ast = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.ast.j = new HashMap();
            a.ast.j.put("Charset", "utf-8");
            a.ast.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.ast.asv = new com.baidu.helios.a.a.b.a();
        }

        public static C0118a am(Context context) {
            if (asy == null) {
                synchronized (a.class) {
                    if (asy == null) {
                        asy = new C0118a(context);
                    }
                }
            }
            return asy;
        }

        public a uW() {
            if (a.ast.asv == null) {
                a();
            }
            return a.ast;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.asw = new m(context);
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
        if (this.asv != null && (va = this.asv.va()) != null) {
            str = va.a(a2, "POST", this.j, this.asu.uX());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.asw != null) {
            this.asw.b(this.asu.uX());
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
                a.this.asu = new f(a.this.m);
                boolean z = false;
                if (a.this.asw != null) {
                    a.this.asw.s(a.this.asu.uX());
                    z = a.this.asw.a();
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
