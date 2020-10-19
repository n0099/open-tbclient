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
/* loaded from: classes17.dex */
public class a extends com.baidu.helios.channels.a {
    a.C0153a awJ;
    private C0149a axn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.channels.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public class C0149a {
        private long f;
        private String g;
        private boolean h;
        private boolean i = true;
        private int j;

        C0149a() {
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
                context = a.this.awZ.applicationContext.createPackageContext(str, 0);
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
            return c(a.this.awJ.q("pub.dat", true));
        }

        public boolean d() {
            if (this.i) {
                if (this.h) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.g);
                        jSONObject.put("pub_lst_ts", this.f);
                        jSONObject.put("d_form_ver", 1);
                        a.this.awJ.d("pub.dat", jSONObject.toString(), true);
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
                File file = new File(a.this.awZ.applicationContext.getExternalCacheDir(), "com.baidu.helios" + File.separator + "esc-es");
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

    /* loaded from: classes17.dex */
    class b extends a.b {
        private int i;
        private String j;
        private long k;
        private long l;
        private long m;
        private String n;

        public b(String str) {
            super(a.this.awJ, str);
        }

        public boolean Q(long j) {
            if (this.m != j) {
                this.m = j;
                aW(true);
                return true;
            }
            return false;
        }

        public String a() {
            return this.j;
        }

        public void a(C0149a c0149a) {
            b(c0149a.b());
            b(c0149a.a());
        }

        public boolean a(long j) {
            if (this.k != j) {
                this.k = j;
                aW(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.j)) {
                return false;
            }
            this.j = str;
            aW(true);
            return true;
        }

        public String b() {
            return this.n;
        }

        public boolean b(long j) {
            if (this.l != j) {
                this.l = j;
                aW(true);
                return true;
            }
            return false;
        }

        public boolean b(String str) {
            if (str.equals(this.n)) {
                return false;
            }
            this.n = str;
            aW(true);
            return true;
        }

        public long c() {
            return this.m;
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
        this.axn = new C0149a();
    }

    private a.e b(a.d dVar) {
        String AI = this.awZ.axd.fE("aid").AI();
        if (AI.equals(this.axn.b())) {
            return a.e.Aj();
        }
        this.axn.a(AI);
        this.axn.a(System.currentTimeMillis());
        this.axn.d();
        return this.axn.e() ? a.e.Aj() : a.e.Ak();
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.e.Ak();
        }
        this.axn.c();
        try {
            return b(dVar);
        } finally {
            this.axn.d();
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        b bVar = null;
        Context context = this.awZ.applicationContext;
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
            bVar.Ah();
            if (str.equals(bVar.a()) && packageInfo.lastUpdateTime == bVar.c()) {
                String b2 = bVar.b();
                if (!TextUtils.isEmpty(b2)) {
                    return a.g.fB(b2);
                }
            }
        }
        if (context.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            C0149a c0149a = new C0149a();
            if (c0149a.b(str)) {
                if (fVar.useCache && bVar != null) {
                    bVar.a(c0149a);
                    bVar.a(System.currentTimeMillis());
                    bVar.Q(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.Ai();
                }
                return a.g.fB(c0149a.b());
            }
            return a.g.dr(-2);
        }
        return a.g.dr(-100);
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.awJ = this.axa.fD("esc-es");
    }
}
