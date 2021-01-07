package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class a {
    private static a axe;
    private Thread axf;
    private b axg;
    private com.baidu.helios.a.a.a.b axh;
    private i axi;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a axj;

        @Override // java.lang.Runnable
        public void run() {
            if (this.axj.axi != null) {
                this.axj.axi.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0126a {
        private static C0126a axk;

        private C0126a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.axe == null) {
                synchronized (a.class) {
                    if (a.axe == null) {
                        a unused = a.axe = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.axe.j = new HashMap();
            a.axe.j.put("Charset", "utf-8");
            a.axe.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.axe.axh = new com.baidu.helios.a.a.b.a();
        }

        public static C0126a an(Context context) {
            if (axk == null) {
                synchronized (a.class) {
                    if (axk == null) {
                        axk = new C0126a(context);
                    }
                }
            }
            return axk;
        }

        public a yR() {
            if (a.axe.axh == null) {
                a();
            }
            return a.axe;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.axi = new m(context);
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
        com.baidu.helios.a.a.a.c yV;
        String a2 = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.axh != null && (yV = this.axh.yV()) != null) {
            str = yV.a(a2, "POST", this.j, this.axg.yS());
        }
        JSONObject a3 = l.a(str);
        if (a3 == null) {
            return false;
        }
        return a3.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.axi != null) {
            this.axi.b(this.axg.yS());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable yP() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.axg = new f(a.this.m);
                boolean z = false;
                if (a.this.axi != null) {
                    a.this.axi.s(a.this.axg.yS());
                    z = a.this.axi.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.axf = null;
            }
        };
    }

    public void yO() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.axf == null) {
                    this.axf = new Thread(yP());
                }
                this.axf.start();
            }
        }
    }
}
