package com.baidu.helios.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.utils.HttpHelper;
import com.baidu.android.util.io.BaseJsonData;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a {
    private static a awi;
    private Thread awj;
    private b awk;
    private com.baidu.helios.a.a.a.b awl;
    private i awm;
    private AtomicInteger f;
    private AtomicBoolean g;
    private HashMap<String, String> j;
    private HashMap<String, String> k;
    private Context m;

    /* renamed from: com.baidu.helios.a.a.a$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ a awn;

        @Override // java.lang.Runnable
        public void run() {
            if (this.awn.awm != null) {
                this.awn.awm.b();
            }
        }
    }

    /* renamed from: com.baidu.helios.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0133a {
        private static C0133a awo;

        private C0133a(Context context) {
            if (context == null) {
                throw new NullPointerException("context should not be null");
            }
            if (a.awi == null) {
                synchronized (a.class) {
                    if (a.awi == null) {
                        a unused = a.awi = new a(context.getApplicationContext(), null);
                    }
                }
            }
        }

        private void a() {
            a.awi.j = new HashMap();
            a.awi.j.put("Charset", "utf-8");
            a.awi.j.put("Content-type", HttpHelper.CONTENT_JSON);
            a.awi.awl = new com.baidu.helios.a.a.b.a();
        }

        public static C0133a aj(Context context) {
            if (awo == null) {
                synchronized (a.class) {
                    if (awo == null) {
                        awo = new C0133a(context);
                    }
                }
            }
            return awo;
        }

        public a zV() {
            if (a.awi.awl == null) {
                a();
            }
            return a.awi;
        }
    }

    private a(Context context) {
        this.f = new AtomicInteger(0);
        this.g = new AtomicBoolean(false);
        this.m = context;
        this.awm = new m(context);
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
        com.baidu.helios.a.a.a.c zZ;
        String a = a("https://mbd.baidu.com/store");
        String str = null;
        if (this.awl != null && (zZ = this.awl.zZ()) != null) {
            str = zZ.a(a, "POST", this.j, this.awk.zW());
        }
        JSONObject a2 = l.a(str);
        if (a2 == null) {
            return false;
        }
        return a2.optInt(BaseJsonData.TAG_ERRNO, -1) == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.awm != null) {
            this.awm.b(this.awk.zW());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f != null) {
            this.f.set(2);
        }
    }

    private Runnable zT() {
        return new Runnable() { // from class: com.baidu.helios.a.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.this.awk = new f(a.this.m);
                boolean z = false;
                if (a.this.awm != null) {
                    a.this.awm.r(a.this.awk.zW());
                    z = a.this.awm.a();
                }
                if (z && a.this.c()) {
                    a.this.d();
                    a.this.e();
                }
                a.this.awj = null;
            }
        };
    }

    public void zS() {
        synchronized (a.class) {
            if (this.f.get() == 0) {
                if (this.m == null) {
                    throw new NullPointerException("context should not be null");
                }
                this.f.set(1);
                if (this.awj == null) {
                    this.awj = new Thread(zT());
                }
                this.awj.start();
            }
        }
    }
}
