package com.baidu.helios.channels.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.helios.channels.a;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.mobstat.Config;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a extends com.baidu.helios.channels.a {
    private b apU;
    a.C0141a apk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.helios.channels.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0139a {
        static boolean a(a.C0141a c0141a, com.baidu.helios.common.c.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c0141a != null && !c0141a.uu().equals(aVar.uq())) {
                    c0141a.uu().setExecutable(true, false);
                    c0141a = c0141a.uw();
                }
                return true;
            }
            while (c0141a != null) {
                if (!a(c0141a.uu())) {
                    return false;
                }
                c0141a = c0141a.uw();
            }
            return a(aVar.uq());
        }

        private static boolean a(File file) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    int i = Os.stat(file.getAbsolutePath()).st_mode;
                    if ((i & 1) == 0) {
                        Os.chmod(file.getAbsolutePath(), i | 1);
                    }
                    return true;
                } catch (Throwable th) {
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class b {
        private long j;
        private String k;
        private boolean l;
        private int p;
        private e apV = new e();
        private boolean m = true;

        b() {
        }

        private boolean b(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.j = jSONObject.getLong("pub_lst_ts");
                this.k = jSONObject.getString("pub_id");
                this.p = jSONObject.getInt("d_form_ver");
                this.l = false;
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public long a() {
            return this.j;
        }

        public void a(long j) {
            if (this.j != j) {
                this.j = j;
                this.l = true;
            }
        }

        public void a(long j, long j2) {
            if (this.apV.d(j, j2)) {
                this.l = true;
            }
        }

        public void a(String str) {
            if (str.equals(this.k)) {
                return;
            }
            this.k = str;
            this.l = true;
        }

        public boolean a(PackageInfo packageInfo) {
            String q = a.this.apk.k(new File(packageInfo.applicationInfo.dataDir)).q("pub.dat", true);
            this.m = false;
            return b(q);
        }

        public String b() {
            return this.k;
        }

        public boolean c() {
            return b(a.this.apk.q("pub.dat", true));
        }

        public boolean d() {
            if (this.m) {
                if (this.l) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_id", this.k);
                        jSONObject.put("pub_lst_ts", this.j);
                        jSONObject.put("d_form_ver", 1);
                        a.this.apk.d("pub.dat", jSONObject.toString(), true);
                        this.l = false;
                        return true;
                    } catch (Exception e) {
                    }
                }
                return false;
            }
            throw new IllegalStateException();
        }

        public boolean e() {
            return a.b(a.this.apk.getFile("pub.dat"), true);
        }
    }

    /* loaded from: classes6.dex */
    class c extends a.b {
        private int i;
        private String j;
        private long k;
        private long l;
        private long m;
        private String n;

        public c(String str) {
            super(a.this.apk, str);
        }

        public String a() {
            return this.j;
        }

        public void a(b bVar) {
            b(bVar.b());
            b(bVar.a());
        }

        public boolean a(long j) {
            if (this.k != j) {
                this.k = j;
                aK(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.j)) {
                return false;
            }
            this.j = str;
            aK(true);
            return true;
        }

        public String b() {
            return this.n;
        }

        public boolean b(long j) {
            if (this.l != j) {
                this.l = j;
                aK(true);
                return true;
            }
            return false;
        }

        public boolean b(String str) {
            if (str.equals(this.n)) {
                return false;
            }
            this.n = str;
            aK(true);
            return true;
        }

        public long c() {
            return this.m;
        }

        public boolean c(long j) {
            if (this.m != j) {
                this.m = j;
                aK(true);
                return true;
            }
            return false;
        }

        @Override // com.baidu.helios.channels.a.b
        public void o(JSONObject jSONObject) {
            this.j = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.l = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.k = jSONObject.getLong("last_fe_ts");
            this.n = jSONObject.getString("id");
            this.m = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.i = jSONObject.getInt("d_form_ver");
        }

        @Override // com.baidu.helios.channels.a.b
        public void p(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.j);
            jSONObject.put("last_fe_ts", this.k);
            jSONObject.put("tar_pkg_lst_pub_ts", this.l);
            jSONObject.put("id", this.n);
            jSONObject.put("tar_pkg_lst_up_ts", this.m);
            jSONObject.put("d_form_ver", 1);
        }
    }

    public a() {
        super("isc", 8000000L);
        this.apU = new b();
    }

    private void a() {
        this.apU.a(C0139a.a(this.apk, this.apB.apE) ? 1 : 2, 3L);
    }

    private a.e b(a.d dVar) {
        this.apU.c();
        this.apk.ut();
        String ux = this.apB.apF.ec("aid").ux();
        if (ux.equals(this.apU.b())) {
            return a.e.tY();
        }
        this.apU.a(ux);
        this.apU.a(System.currentTimeMillis());
        return a.e.tY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, boolean z) {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                Os.chmod(file.getAbsolutePath(), z ? 436 : 432);
                return true;
            } catch (Throwable th) {
                return false;
            }
        }
        try {
            if (z) {
                z2 = file.setReadable(true, false);
            } else {
                boolean readable = file.setReadable(false, false);
                boolean readable2 = file.setReadable(true, true);
                if (!readable || !readable2) {
                    z2 = false;
                }
            }
            return z2;
        } catch (Throwable th2) {
            return false;
        }
    }

    @Override // com.baidu.helios.channels.a
    public a.e a(a.d dVar) {
        Context context = this.apB.applicationContext;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.apU.c();
            try {
                return b(dVar);
            } finally {
                this.apU.d();
                a();
                this.apU.d();
                this.apU.e();
            }
        }
        return a.e.bt(-100);
    }

    @Override // com.baidu.helios.channels.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        c cVar = null;
        try {
            packageInfo = this.apB.applicationContext.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.g.bu(-2);
        }
        if (fVar.apG) {
            cVar = new c(str);
            cVar.tW();
            if (str.equals(cVar.a()) && packageInfo.lastUpdateTime == cVar.c()) {
                return a.g.dZ(cVar.b());
            }
        }
        b bVar = new b();
        if (bVar.a(packageInfo)) {
            if (fVar.apG && cVar != null) {
                cVar.a(bVar);
                cVar.a(System.currentTimeMillis());
                cVar.c(packageInfo.lastUpdateTime);
                cVar.a(str);
                cVar.tX();
            }
            return a.g.dZ(bVar.b());
        }
        return a.g.bu(-2);
    }

    @Override // com.baidu.helios.channels.a
    public void a(a.c cVar) {
        this.apk = this.apC.eb("isc");
    }
}
