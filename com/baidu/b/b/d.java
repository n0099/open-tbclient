package com.baidu.b.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import com.baidu.b.h;
import com.baidu.mobstat.Config;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends com.baidu.b.b.a {
    a.C0092a adh;
    private a adi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public class a {
        private h.a adk;
        private long c;
        private boolean e;
        private int g;
        private com.baidu.b.f.b adj = new com.baidu.b.f.b();
        private boolean f = true;

        a() {
        }

        private boolean a(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.c = jSONObject.getLong("pub_lst_ts");
                this.adk = h.a(jSONObject.getString("pub_info"));
                this.g = jSONObject.getInt("d_form_ver");
                this.e = false;
                return true;
            } catch (Exception e) {
                return false;
            }
        }

        public long a() {
            return this.c;
        }

        public boolean a(PackageInfo packageInfo) {
            String a2 = d.this.adh.i(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f = false;
            return a(a2);
        }

        public h.a b() {
            return this.adk;
        }
    }

    /* loaded from: classes7.dex */
    class b extends a.b {
        private int b;
        private String c;
        private long d;
        private long e;
        private long f;
        private h.a g;

        public b(String str) {
            super(d.this.adh, str);
        }

        public boolean Q(long j) {
            if (this.f != j) {
                this.f = j;
                a(true);
                return true;
            }
            return false;
        }

        public void a(a aVar) {
            b(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.b.b.a.b
        public void a(JSONObject jSONObject) {
            this.c = jSONObject.getString(Config.INPUT_DEF_PKG);
            this.e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.d = jSONObject.getLong("last_fe_ts");
            this.g = h.a(jSONObject.getString("info"));
            this.f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.d != j) {
                this.d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(String str) {
            if (str.equals(this.c)) {
                return false;
            }
            this.c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.b.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put(Config.INPUT_DEF_PKG, this.c);
            jSONObject.put("last_fe_ts", this.d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.e);
            jSONObject.put("info", this.g.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.e != j) {
                this.e = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean b(h.a aVar) {
            if (aVar.equals(this.g)) {
                return false;
            }
            this.g = aVar;
            a(true);
            return true;
        }

        public String c() {
            return this.c;
        }

        public long e() {
            return this.f;
        }

        public h.a sJ() {
            return this.g;
        }
    }

    public d() {
        super("isc", 8000000L);
        this.adi = new a();
    }

    @Override // com.baidu.b.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        b bVar = null;
        try {
            packageInfo = this.acY.f1249a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.bj(-2);
        }
        if (dVar.f1250a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                return a.e.a(bVar.sJ());
            }
        }
        a aVar = new a();
        if (aVar.a(packageInfo)) {
            if (dVar.f1250a && bVar != null) {
                bVar.a(aVar);
                bVar.a(System.currentTimeMillis());
                bVar.Q(packageInfo.lastUpdateTime);
                bVar.a(str);
                bVar.b();
            }
            return a.e.a(aVar.b());
        }
        return a.e.bj(-2);
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.adh = this.acZ.cZ("isc");
    }
}
