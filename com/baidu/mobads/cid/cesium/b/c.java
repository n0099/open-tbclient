package com.baidu.mobads.cid.cesium.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.mobads.cid.cesium.b.a;
import com.baidu.mobads.cid.cesium.e.a;
import com.baidu.mobads.cid.cesium.g;
import java.io.File;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.mobads.cid.cesium.b.a {

    /* renamed from: d  reason: collision with root package name */
    public a.C0105a f8075d;

    /* renamed from: e  reason: collision with root package name */
    public a f8076e;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public long f8079c;

        /* renamed from: d  reason: collision with root package name */
        public g.a f8080d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8081e;

        /* renamed from: g  reason: collision with root package name */
        public int f8083g;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.f.b f8078b = new com.baidu.mobads.cid.cesium.f.b();

        /* renamed from: f  reason: collision with root package name */
        public boolean f8082f = true;

        public a() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f8079c = jSONObject.getLong("pub_lst_ts");
                    this.f8080d = g.a(jSONObject.getString("pub_info"));
                    this.f8083g = jSONObject.getInt("d_form_ver");
                    this.f8081e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public long a() {
            return this.f8079c;
        }

        public boolean a(PackageInfo packageInfo) {
            String a2 = c.this.f8075d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f8082f = false;
            return a(a2);
        }

        public g.a b() {
            return this.f8080d;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8085b;

        /* renamed from: c  reason: collision with root package name */
        public String f8086c;

        /* renamed from: d  reason: collision with root package name */
        public long f8087d;

        /* renamed from: e  reason: collision with root package name */
        public long f8088e;

        /* renamed from: f  reason: collision with root package name */
        public long f8089f;

        /* renamed from: g  reason: collision with root package name */
        public g.a f8090g;

        public b(String str) {
            super(c.this.f8075d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8086c = jSONObject.getString("pkg");
            this.f8088e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f8087d = jSONObject.getLong("last_fe_ts");
            this.f8090g = g.a(jSONObject.getString("info"));
            this.f8089f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8085b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8087d != j) {
                this.f8087d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8090g)) {
                return false;
            }
            this.f8090g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8086c)) {
                return false;
            }
            this.f8086c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8086c);
            jSONObject.put("last_fe_ts", this.f8087d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f8088e);
            jSONObject.put("info", this.f8090g.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8089f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8088e != j) {
                this.f8088e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8086c;
        }

        public boolean c(long j) {
            if (this.f8089f != j) {
                this.f8089f = j;
                a(true);
                return true;
            }
            return false;
        }

        public g.a d() {
            return this.f8090g;
        }

        public long e() {
            return this.f8089f;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f8076e = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        g.a b2;
        b bVar = null;
        try {
            packageInfo = this.f8059a.f8063a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.a(-2);
        }
        if (dVar.f8069a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                b2 = bVar.d();
                return a.e.a(b2);
            }
        }
        a aVar = new a();
        if (aVar.a(packageInfo)) {
            if (dVar.f8069a && bVar != null) {
                bVar.a(aVar);
                bVar.a(System.currentTimeMillis());
                bVar.c(packageInfo.lastUpdateTime);
                bVar.a(str);
                bVar.b();
            }
            b2 = aVar.b();
            return a.e.a(b2);
        }
        return a.e.a(-2);
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public void a(a.c cVar) {
        this.f8075d = this.f8060b.a("isc");
    }
}
