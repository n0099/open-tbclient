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
/* loaded from: classes7.dex */
public class a extends com.baidu.helios.channels.a {
    private C0137a awW;
    a.C0141a awu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.channels.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0137a {
        private long f;
        private String g;
        private boolean h;
        private boolean i = true;
        private int j;

        C0137a() {
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
                context = a.this.awI.applicationContext.createPackageContext(str, 0);
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
            return c(a.this.awu.p("pub.dat", true));
        }

        public boolean d() {
            if (this.i) {
                if (this.h) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.g);
                        jSONObject.put("pub_lst_ts", this.f);
                        jSONObject.put("d_form_ver", 1);
                        a.this.awu.c("pub.dat", jSONObject.toString(), true);
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
                File file = new File(a.this.awI.applicationContext.getExternalCacheDir(), "com.baidu.helios" + File.separator + "esc-es");
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

    /* loaded from: classes7.dex */
    class b extends a.b {
        private int i;
        private String j;
        private long k;
        private long l;
        private long m;
        private String n;

        public b(String str) {
            super(a.this.awu, str);
        }

        public String a() {
            return this.j;
        }

        public void a(C0137a c0137a) {
            b(c0137a.b());
            b(c0137a.a());
        }

        public boolean a(long j) {
            if (this.k != j) {
                this.k = j;
                aV(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.j)) {
                return false;
            }
            this.j = str;
            aV(true);
            return true;
        }

        public String b() {
            return this.n;
        }

        public boolean b(long j) {
            if (this.l != j) {
                this.l = j;
                aV(true);
                return true;
            }
            return false;
        }

        public boolean b(String str) {
            if (str.equals(this.n)) {
                return false;
            }
            this.n = str;
            aV(true);
            return true;
        }

        public long c() {
            return this.m;
        }

        public boolean c(long j) {
            if (this.m != j) {
                this.m = j;
                aV(true);
                return true;
            }
            return false;
        }

        @Override // com.baidu.helios.channels.a.b
        public void q(JSONObject jSONObject) {
            this.j = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.l = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.k = jSONObject.getLong("last_fe_ts");
            this.n = jSONObject.getString("id");
            this.m = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.i = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void r(JSONObject jSONObject) {
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
        this.awW = new C0137a();
    }

    private a.e b(a.d dVar) {
        String zk = this.awI.awM.fn("aid").zk();
        if (zk.equals(this.awW.b())) {
            return a.e.yJ();
        }
        this.awW.a(zk);
        this.awW.a(System.currentTimeMillis());
        this.awW.d();
        return this.awW.e() ? a.e.yJ() : a.e.yK();
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e.yK();
        }
        this.awW.c();
        try {
            return b(dVar);
        } finally {
            this.awW.d();
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        b bVar = null;
        Context context = this.awI.applicationContext;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.g.dr(-1);
        }
        if (fVar.useCache) {
            bVar = new b(str);
            bVar.yH();
            if (str.equals(bVar.a()) && packageInfo.lastUpdateTime == bVar.c()) {
                String b2 = bVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    return a.g.fk(b2);
                }
            }
        }
        if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            C0137a c0137a = new C0137a();
            if (c0137a.b(str)) {
                if (fVar.useCache && bVar != null) {
                    bVar.a(c0137a);
                    bVar.a(System.currentTimeMillis());
                    bVar.c(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.yI();
                }
                return a.g.fk(c0137a.b());
            }
            return a.g.dr(-2);
        }
        return a.g.dr(-100);
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.awu = this.awJ.fm("esc-es");
    }
}
