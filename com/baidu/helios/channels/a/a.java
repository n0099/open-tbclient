package com.baidu.helios.channels.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.helios.channels.a;
import com.baidu.helios.common.c.a;
import com.baidu.mobstat.Config;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.helios.channels.a {
    a.C0143a aqD;
    private C0139a ari;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.channels.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0139a {
        private long f;
        private String g;
        private boolean h;
        private boolean i = true;
        private int j;

        C0139a() {
        }

        private boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f = jSONObject.getLong("pub_lst_ts");
                this.g = jSONObject.getString("pub_id");
                this.j = jSONObject.getInt("d_form_ver");
                this.h = false;
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public long a() {
            return this.f;
        }

        public void a(long j) {
            if (this.f != j) {
                this.f = j;
                this.h = true;
            }
        }

        public void a(String str) {
            if (str.equals(this.g)) {
                return;
            }
            this.g = str;
            this.h = true;
        }

        public String b() {
            return this.g;
        }

        public boolean b(String str) {
            Context context;
            this.i = false;
            try {
                context = a.this.aqT.applicationContext.createPackageContext(str, 0);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                context = null;
            }
            if (context == null) {
                return false;
            }
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    return c(com.baidu.helios.common.c.a.b(new File(externalCacheDir, "com.baidu.helios" + File.separator + "esc-es"), "pub.dat", "UTF-8", true));
                }
                return false;
            } catch (Throwable th) {
                return false;
            }
        }

        public boolean c() {
            return c(a.this.aqD.q("pub.dat", true));
        }

        public boolean d() {
            if (this.i) {
                if (this.h) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.g);
                        jSONObject.put("pub_lst_ts", this.f);
                        jSONObject.put("d_form_ver", 1);
                        a.this.aqD.d("pub.dat", jSONObject.toString(), true);
                        this.h = false;
                        return true;
                    } catch (Exception e) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean e() {
            try {
                File file = new File(a.this.aqT.applicationContext.getExternalCacheDir(), "com.baidu.helios" + File.separator + "esc-es");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pub_id", this.g);
                jSONObject.put("pub_lst_ts", this.f);
                jSONObject.put("d_form_ver", 1);
                com.baidu.helios.common.c.a.b(file, "pub.dat", jSONObject.toString(), "UTF-8", true);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /* loaded from: classes6.dex */
    class b extends a.b {
        private int i;
        private String j;
        private long k;
        private long l;
        private long m;
        private String n;

        public b(String str) {
            super(a.this.aqD, str);
        }

        public String a() {
            return this.j;
        }

        public void a(C0139a c0139a) {
            b(c0139a.b());
            b(c0139a.a());
        }

        public boolean a(long j) {
            if (this.k != j) {
                this.k = j;
                aL(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.j)) {
                return false;
            }
            this.j = str;
            aL(true);
            return true;
        }

        public String b() {
            return this.n;
        }

        public boolean b(long j) {
            if (this.l != j) {
                this.l = j;
                aL(true);
                return true;
            }
            return false;
        }

        public boolean b(String str) {
            if (str.equals(this.n)) {
                return false;
            }
            this.n = str;
            aL(true);
            return true;
        }

        public long c() {
            return this.m;
        }

        public boolean c(long j) {
            if (this.m != j) {
                this.m = j;
                aL(true);
                return true;
            }
            return false;
        }

        @Override // com.baidu.helios.channels.a.b
        public void p(JSONObject jSONObject) {
            this.j = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.l = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.k = jSONObject.getLong("last_fe_ts");
            this.n = jSONObject.getString("id");
            this.m = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.i = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void q(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.j);
            jSONObject.put("last_fe_ts", this.k);
            jSONObject.put("tar_pkg_lst_pub_ts", this.l);
            jSONObject.put("id", this.n);
            jSONObject.put("tar_pkg_lst_up_ts", this.m);
            jSONObject.put("d_form_ver", 1);
        }
    }

    public a() {
        super("esc-es", 7000000L);
        this.ari = new C0139a();
    }

    private a.e b(a.d dVar) {
        String uP = this.aqT.aqX.ee("aid").uP();
        if (uP.equals(this.ari.b())) {
            return a.e.uq();
        }
        this.ari.a(uP);
        this.ari.a(System.currentTimeMillis());
        this.ari.d();
        return this.ari.e() ? a.e.uq() : a.e.ur();
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e.ur();
        }
        this.ari.c();
        try {
            return b(dVar);
        } finally {
            this.ari.d();
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        b bVar = null;
        Context context = this.aqT.applicationContext;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.g.bB(-1);
        }
        if (fVar.aqY) {
            bVar = new b(str);
            bVar.uo();
            if (str.equals(bVar.a()) && packageInfo.lastUpdateTime == bVar.c()) {
                String b2 = bVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    return a.g.eb(b2);
                }
            }
        }
        if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            C0139a c0139a = new C0139a();
            if (c0139a.b(str)) {
                if (fVar.aqY && bVar != null) {
                    bVar.a(c0139a);
                    bVar.a(System.currentTimeMillis());
                    bVar.c(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.up();
                }
                return a.g.eb(c0139a.b());
            }
            return a.g.bB(-2);
        }
        return a.g.bB(-100);
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.aqD = this.aqU.ed("esc-es");
    }
}
