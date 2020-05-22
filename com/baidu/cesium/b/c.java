package com.baidu.cesium.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.system.Os;
import android.text.TextUtils;
import com.baidu.cesium.b.a;
import com.baidu.cesium.e.a;
import com.baidu.cesium.g;
import com.baidu.mobstat.Config;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes13.dex */
public class c extends com.baidu.cesium.b.a {
    a.C0101a aiH;
    private b aiI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        static boolean a(a.C0101a c0101a, com.baidu.cesium.e.a aVar) {
            if (Build.VERSION.SDK_INT < 23) {
                while (c0101a != null && !c0101a.b().equals(aVar.a())) {
                    c0101a.b().setExecutable(true, false);
                    c0101a = c0101a.sm();
                }
                return true;
            }
            while (c0101a != null) {
                if (!a(c0101a.b())) {
                    return false;
                }
                c0101a = c0101a.sm();
            }
            return a(aVar.a());
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
    /* loaded from: classes13.dex */
    public class b {
        private g.a aiK;
        private long j;
        private boolean l;
        private int p;
        private com.baidu.cesium.f.b aiJ = new com.baidu.cesium.f.b();
        private boolean m = true;

        b() {
        }

        private boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.j = jSONObject.getLong("pub_lst_ts");
                this.aiK = g.a(jSONObject.getString("pub_info"));
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
            if (this.aiJ.a(j, j2)) {
                this.l = true;
            }
        }

        public void a(g.a aVar) {
            if (aVar.equals(this.aiK)) {
                return;
            }
            this.aiK = aVar;
            this.l = true;
        }

        public boolean a(PackageInfo packageInfo) {
            String a = c.this.aiH.i(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.m = false;
            return a(a);
        }

        public g.a b() {
            return this.aiK;
        }

        public boolean c() {
            return a(c.this.aiH.a("pub.dat", true));
        }

        public boolean d() {
            if (this.m) {
                if (this.l) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("pub_info", this.aiK.f());
                        jSONObject.put("pub_lst_ts", this.j);
                        jSONObject.put("d_form_ver", 1);
                        c.this.aiH.c("pub.dat", jSONObject.toString(), true);
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
            return c.b(c.this.aiH.b("pub.dat"), true);
        }
    }

    /* renamed from: com.baidu.cesium.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    class C0099c extends a.b {
        private g.a aiM;
        private int i;
        private String j;
        private long k;
        private long l;
        private long m;

        public C0099c(String str) {
            super(c.this.aiH, str);
        }

        public void a(b bVar) {
            e(bVar.b());
            b(bVar.a());
        }

        @Override // com.baidu.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.j = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.l = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.k = jSONObject.getLong("last_fe_ts");
            this.aiM = g.a(jSONObject.getString("info"));
            this.m = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.i = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.k != j) {
                this.k = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.j)) {
                return false;
            }
            this.j = str;
            a(true);
            return true;
        }

        @Override // com.baidu.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.j);
            jSONObject.put("last_fe_ts", this.k);
            jSONObject.put("tar_pkg_lst_pub_ts", this.l);
            jSONObject.put("info", this.aiM.f());
            jSONObject.put("tar_pkg_lst_up_ts", this.m);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.l != j) {
                this.l = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.j;
        }

        public boolean c(long j) {
            if (this.m != j) {
                this.m = j;
                a(true);
                return true;
            }
            return false;
        }

        public g.a d() {
            return this.aiM;
        }

        public long e() {
            return this.m;
        }

        public boolean e(g.a aVar) {
            if (aVar.equals(this.aiM)) {
                return false;
            }
            this.aiM = aVar;
            a(true);
            return true;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.aiI = new b();
    }

    private a.e b(a.d dVar, g.a aVar) {
        this.aiI.c();
        this.aiH.a();
        if (aVar.equals(this.aiI.b())) {
            return a.e.se();
        }
        this.aiI.a(aVar);
        this.aiI.a(System.currentTimeMillis());
        return a.e.se();
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

    private void c() {
        this.aiI.a(a.a(this.aiH, this.aiA.aiD) ? 1 : 2, 3L);
    }

    @Override // com.baidu.cesium.b.a
    public a.e a(a.d dVar, g.a aVar) {
        Context context = this.aiA.a;
        if (Build.VERSION.SDK_INT < 28 || context.getApplicationInfo().targetSdkVersion < 28) {
            this.aiI.c();
            try {
                return b(dVar, aVar);
            } finally {
                this.aiI.d();
                c();
                this.aiI.d();
                this.aiI.e();
            }
        }
        return a.e.bp(-100);
    }

    @Override // com.baidu.cesium.b.a
    public a.g a(String str, a.f fVar) {
        PackageInfo packageInfo;
        C0099c c0099c = null;
        try {
            packageInfo = this.aiA.a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.g.bq(-2);
        }
        if (fVar.a) {
            c0099c = new C0099c(str);
            c0099c.a();
            if (str.equals(c0099c.c()) && packageInfo.lastUpdateTime == c0099c.e()) {
                return a.g.d(c0099c.d());
            }
        }
        b bVar = new b();
        if (bVar.a(packageInfo)) {
            if (fVar.a && c0099c != null) {
                c0099c.a(bVar);
                c0099c.a(System.currentTimeMillis());
                c0099c.c(packageInfo.lastUpdateTime);
                c0099c.a(str);
                c0099c.b();
            }
            return a.g.d(bVar.b());
        }
        return a.g.bq(-2);
    }

    @Override // com.baidu.cesium.b.a
    public void a(a.c cVar) {
        this.aiH = this.aiB.cZ("isc");
    }
}
