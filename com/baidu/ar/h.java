package com.baidu.ar;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.baidu.ar.bean.ARConfiguration;
import com.baidu.ar.bean.ARResource;
import com.baidu.ar.i.f;
import com.baidu.ar.resloader.b;
import com.baidu.ar.slam.SlamStateMachine;
import com.baidu.ar.ui.a;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.Res;
import com.baidu.ar.util.k;
import com.baidu.ar.util.n;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {
    private static boolean a = false;
    private com.baidu.ar.i.b b;
    private Timer c;
    private TimerTask d;
    private Dialog f;
    private Dialog g;
    private Dialog h;
    private c m;
    private a n;
    private WeakReference<Activity> o;
    private Context p;
    private ARResource r;
    private int s;
    private b t;
    private com.baidu.ar.resloader.b u;
    private b.a v;
    private long e = 20000;
    private boolean i = true;
    private boolean j = false;
    private boolean k = false;
    private com.baidu.ar.i.c l = null;
    private boolean q = false;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a implements com.baidu.ar.i.a<String> {
        private SoftReference<h> a;

        public a(h hVar) {
            this.a = new SoftReference<>(hVar);
        }

        public void a() {
            this.a.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.i.f.a
        public void a(String str) {
            if (this.a.get().q) {
                return;
            }
            this.a.get().b();
            this.a.get().t.e(str);
            this.a.get().l();
        }

        @Override // com.baidu.ar.i.f.a
        public void b(String str) {
            com.baidu.ar.h.a.a().a("download_3d_res_failure");
            this.a.get().t.I();
            if (this.a.get().q) {
                return;
            }
            this.a.get().b();
            this.a.get().t.y();
            this.a.get().t.J();
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void H();

        void I();

        void J();

        void a(ARResource aRResource);

        void a(String str);

        ARConfiguration ac();

        void ai();

        void e(String str);

        boolean u();

        void x();

        void y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c implements f.a<JSONObject> {
        private SoftReference<h> a;

        public c(h hVar) {
            this.a = new SoftReference<>(hVar);
        }

        public void a() {
            this.a.clear();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.ar.i.f.a
        public void a(JSONObject jSONObject) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().a(jSONObject);
        }

        @Override // com.baidu.ar.i.f.a
        public void b(String str) {
            if (this.a == null || this.a.get() == null) {
                return;
            }
            this.a.get().a(str);
        }
    }

    public h(WeakReference<Activity> weakReference, b bVar) {
        this.o = weakReference;
        if (this.o != null) {
            this.p = this.o.get().getApplicationContext();
            this.u = new com.baidu.ar.resloader.b(this.p);
        }
        this.t = bVar;
    }

    private void a(ARConfiguration aRConfiguration) {
        if (a) {
            b(aRConfiguration);
            return;
        }
        com.baidu.ar.util.b.a("queryArType");
        this.t.x();
        this.t.H();
        this.m = new c(this);
        this.l = com.baidu.ar.i.e.a(this.p, aRConfiguration, this.m);
        if (this.l == null) {
            com.baidu.ar.util.b.d("Http Request Occur Error! Please Check");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (this.q) {
            return;
        }
        com.baidu.ar.util.b.d("http error msg = " + str);
        this.t.y();
        this.t.J();
        d();
        this.l = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        if (this.q) {
            return;
        }
        int aRType = this.t.ac().getARType();
        this.r = com.baidu.ar.e.a.a(jSONObject);
        if (this.r == null) {
            com.baidu.ar.util.b.d("ARResource parse error!");
        } else if (this.r.a() != 0) {
            if (aRType == 5) {
                SlamStateMachine.a().a(SlamStateMachine.EVENT.QUERY_RES_FAILED);
            }
            this.t.y();
            this.t.J();
            Activity activity = this.o != null ? this.o.get() : null;
            this.r.a();
            if (activity != null) {
                com.baidu.ar.ui.c.a(this.p, activity, this.r.b(), 0, 2).a();
            }
            com.baidu.ar.util.b.a("error code = " + this.r.a() + ", error msg = " + this.r.b());
        } else if (!this.r.f() && this.r.g()) {
            this.t.a(this.r);
            this.j = true;
            this.l = null;
        } else {
            this.t.y();
            this.t.J();
            if (TextUtils.isEmpty(this.r.d())) {
                this.t.a("https://dusee.baidu.com/static/site/pages/intro/ar_help.html");
            } else {
                this.t.a(this.r.d());
            }
            this.t.u();
        }
    }

    private void b(final ARConfiguration aRConfiguration) {
        this.t.x();
        this.t.H();
        this.m = new c(this);
        n.a(new Runnable() { // from class: com.baidu.ar.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.m.a(com.baidu.ar.g.a.a(aRConfiguration.getARType()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (!this.j || this.r == null) {
            a(this.t.ac());
        } else {
            a(0);
        }
    }

    private void k() {
        ARResource aRResource = this.r;
        if (aRResource == null || this.u == null) {
            com.baidu.ar.util.b.d("ERROR!! bundle data is null");
            return;
        }
        this.t.x();
        this.t.H();
        String i = aRResource.i();
        this.u.a(new b.a() { // from class: com.baidu.ar.h.2
            @Override // com.baidu.ar.resloader.b.a
            public void a(boolean z) {
                if (h.this.v != null) {
                    h.this.v.a(z);
                }
                if (z) {
                    h.this.l();
                } else if (h.this.q) {
                } else {
                    h.this.t.y();
                    h.this.d();
                    if (Constants.DEBUG_TOAST) {
                        Activity activity = h.this.o != null ? (Activity) h.this.o.get() : null;
                        if (activity != null) {
                            com.baidu.ar.ui.c.a(h.this.p, activity, "download error", 1).a();
                        }
                    }
                }
            }
        });
        this.u.a(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (a) {
            m();
        } else if (this.r == null || this.r.c() == null) {
            com.baidu.ar.util.b.d("ERROR!! bundle data is null");
        } else if (this.s < this.r.c().length) {
            String str = this.r.c()[this.s];
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.n = new a(this);
            this.b = com.baidu.ar.i.e.a(this.r.e(), str, Constants.RE_EXTRACT, this.p != null ? this.p.getContentResolver() : null, this.n);
            if (this.s != 0 || com.baidu.ar.external.a.a.a.a().b() == 3) {
            }
            this.s++;
            if (this.s == this.r.c().length) {
                n();
            }
        }
    }

    private void m() {
        if (this.s >= this.r.c().length || TextUtils.isEmpty(this.r.c()[this.s])) {
            return;
        }
        this.n = new a(this);
        n.a(new Runnable() { // from class: com.baidu.ar.h.3
            @Override // java.lang.Runnable
            public void run() {
                h.this.n.a(com.baidu.ar.g.a.a((Activity) h.this.o.get()));
            }
        });
        if (this.s == 0) {
            if (com.baidu.ar.external.a.a.a.a().b() == 3) {
            }
            this.t.x();
            this.t.H();
        }
        this.s++;
        if (this.s == this.r.c().length) {
            n();
        }
    }

    private void n() {
        b();
        this.c = new Timer();
        if (this.d == null) {
            this.d = new TimerTask() { // from class: com.baidu.ar.h.4
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (h.this.b != null) {
                        com.baidu.ar.util.b.a("timer timeout!");
                        AsyncTask.Status status = h.this.b.getStatus();
                        if (status == AsyncTask.Status.RUNNING || status == AsyncTask.Status.PENDING) {
                            com.baidu.ar.util.b.a("timer download timeout!");
                            h.this.b.a(true);
                            h.this.t.y();
                            h.this.o();
                        }
                    }
                }
            };
        }
        this.c.schedule(this.d, this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        n.a(new Runnable() { // from class: com.baidu.ar.h.7
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.h == null) {
                    if (h.this.o == null || h.this.o.get() == null) {
                        return;
                    }
                    a.C0039a c0039a = new a.C0039a((Activity) h.this.o.get());
                    c0039a.a(Res.getString("bdar_download_timeout_error"));
                    c0039a.a(Res.getString("bdar_ok"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.7.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (com.baidu.ar.external.a.a.a.a().b() != 3) {
                                h.this.t.x();
                            }
                            if (h.this.b != null) {
                                AsyncTask.Status status = h.this.b.getStatus();
                                if (status == AsyncTask.Status.RUNNING || status == AsyncTask.Status.PENDING) {
                                    h.this.b.a(false);
                                }
                            }
                        }
                    });
                    c0039a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.7.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            h.this.t.u();
                        }
                    });
                    h.this.h = c0039a.a();
                    h.this.h.setCanceledOnTouchOutside(false);
                }
                if (h.this.h.isShowing()) {
                    return;
                }
                h.this.h.show();
            }
        });
    }

    public void a() {
        if (a) {
            j();
        } else if (k.b(this.p) == null) {
            this.t.y();
            this.t.J();
            d();
        } else if (k.a(this.p)) {
            j();
        } else if (k.c(this.p)) {
            if (!this.i) {
                j();
                return;
            }
            this.t.y();
            this.t.J();
            com.baidu.ar.h.a.a().a("request_no_wifi_dialog");
            e();
        }
    }

    public void a(int i) {
        if (k.b(this.p) == null) {
            this.t.y();
            this.t.J();
            d();
            return;
        }
        if (!k.a(this.p)) {
            if (k.c(this.p)) {
                switch (k.d(this.p)) {
                    case 2:
                        this.e = 20000L;
                        break;
                    case 3:
                        this.e = 20000L;
                        break;
                    case 4:
                        this.e = 15000L;
                        break;
                    default:
                        this.e = 20000L;
                        break;
                }
            }
        } else {
            this.e = 15000L;
        }
        this.s = i;
        if (i == 0) {
            k();
        } else {
            l();
        }
    }

    public void a(b.a aVar) {
        this.v = aVar;
    }

    public void b() {
        if (this.c != null) {
            this.c.cancel();
            this.c.purge();
            this.c = null;
        }
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public void c() {
        if (this.g != null) {
            this.g.dismiss();
        }
        if (this.f != null) {
            this.f.dismiss();
        }
        if (this.h != null) {
            this.h.dismiss();
        }
    }

    public void d() {
        n.a(new Runnable() { // from class: com.baidu.ar.h.5
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.f == null) {
                    if (h.this.o == null || h.this.o.get() == null) {
                        return;
                    }
                    a.C0039a c0039a = new a.C0039a((Activity) h.this.o.get());
                    c0039a.a(Res.getString("bdar_error_network_tips"));
                    c0039a.a(Res.getString("bdar_retry"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (h.this.t != null) {
                                h.this.t.ai();
                            }
                        }
                    });
                    c0039a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.5.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            h.this.t.u();
                        }
                    });
                    h.this.f = c0039a.a();
                    h.this.f.setCanceledOnTouchOutside(false);
                }
                if (h.this.f.isShowing()) {
                    return;
                }
                h.this.f.show();
            }
        });
    }

    public void e() {
        n.a(new Runnable() { // from class: com.baidu.ar.h.6
            @Override // java.lang.Runnable
            public void run() {
                if (h.this.g == null) {
                    if (h.this.o == null || h.this.o.get() == null) {
                        return;
                    }
                    a.C0039a c0039a = new a.C0039a((Activity) h.this.o.get());
                    c0039a.a(Res.getString("bdar_non_wifi_tips"));
                    c0039a.a(Res.getString("bdar_ok"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.6.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            h.this.j();
                            h.this.i = false;
                            com.baidu.ar.h.a.a().a("no_wifi_permission_granted");
                        }
                    });
                    c0039a.b(Res.getString("bdar_cancel"), new DialogInterface.OnClickListener() { // from class: com.baidu.ar.h.6.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            com.baidu.ar.h.a.a().a("no_wifi_permission_deny");
                            h.this.t.u();
                        }
                    });
                    h.this.g = c0039a.a();
                    h.this.g.setCanceledOnTouchOutside(false);
                    h.this.g.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.ar.h.6.3
                        @Override // android.content.DialogInterface.OnKeyListener
                        public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                            if (i == 4) {
                                h.this.t.u();
                                h.this.i = true;
                                return false;
                            }
                            return false;
                        }
                    });
                }
                if (h.this.g.isShowing()) {
                    return;
                }
                h.this.g.show();
            }
        });
    }

    public void f() {
        if (this.b != null) {
            this.b.a(false);
            this.b.cancel(true);
            this.b = null;
        }
        if (this.u != null) {
            this.u.a();
        }
    }

    public void g() {
        if (this.l != null) {
            this.l.a();
            this.l = null;
        }
        if (this.m != null) {
            this.m.a();
        }
        if (this.n != null) {
            this.n.a();
        }
    }

    public void h() {
        this.q = false;
    }

    public void i() {
        this.q = true;
        if (this.b != null) {
            this.b.cancel(true);
        }
    }
}
