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
    public a.C0105a f8366d;

    /* renamed from: e  reason: collision with root package name */
    public a f8367e;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public long f8370c;

        /* renamed from: d  reason: collision with root package name */
        public g.a f8371d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8372e;

        /* renamed from: g  reason: collision with root package name */
        public int f8374g;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.f.b f8369b = new com.baidu.mobads.cid.cesium.f.b();

        /* renamed from: f  reason: collision with root package name */
        public boolean f8373f = true;

        public a() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f8370c = jSONObject.getLong("pub_lst_ts");
                    this.f8371d = g.a(jSONObject.getString("pub_info"));
                    this.f8374g = jSONObject.getInt("d_form_ver");
                    this.f8372e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public long a() {
            return this.f8370c;
        }

        public boolean a(PackageInfo packageInfo) {
            String a2 = c.this.f8366d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f8373f = false;
            return a(a2);
        }

        public g.a b() {
            return this.f8371d;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8376b;

        /* renamed from: c  reason: collision with root package name */
        public String f8377c;

        /* renamed from: d  reason: collision with root package name */
        public long f8378d;

        /* renamed from: e  reason: collision with root package name */
        public long f8379e;

        /* renamed from: f  reason: collision with root package name */
        public long f8380f;

        /* renamed from: g  reason: collision with root package name */
        public g.a f8381g;

        public b(String str) {
            super(c.this.f8366d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8377c = jSONObject.getString("pkg");
            this.f8379e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f8378d = jSONObject.getLong("last_fe_ts");
            this.f8381g = g.a(jSONObject.getString("info"));
            this.f8380f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8376b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8378d != j) {
                this.f8378d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8381g)) {
                return false;
            }
            this.f8381g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8377c)) {
                return false;
            }
            this.f8377c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8377c);
            jSONObject.put("last_fe_ts", this.f8378d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f8379e);
            jSONObject.put("info", this.f8381g.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8380f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8379e != j) {
                this.f8379e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8377c;
        }

        public boolean c(long j) {
            if (this.f8380f != j) {
                this.f8380f = j;
                a(true);
                return true;
            }
            return false;
        }

        public g.a d() {
            return this.f8381g;
        }

        public long e() {
            return this.f8380f;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f8367e = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        g.a b2;
        b bVar = null;
        try {
            packageInfo = this.f8350a.f8354a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.a(-2);
        }
        if (dVar.f8360a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                b2 = bVar.d();
                return a.e.a(b2);
            }
        }
        a aVar = new a();
        if (aVar.a(packageInfo)) {
            if (dVar.f8360a && bVar != null) {
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
        this.f8366d = this.f8351b.a("isc");
    }
}
