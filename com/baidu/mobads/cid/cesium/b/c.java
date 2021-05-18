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
    public a.C0105a f8178d;

    /* renamed from: e  reason: collision with root package name */
    public a f8179e;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public long f8182c;

        /* renamed from: d  reason: collision with root package name */
        public g.a f8183d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8184e;

        /* renamed from: g  reason: collision with root package name */
        public int f8186g;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.f.b f8181b = new com.baidu.mobads.cid.cesium.f.b();

        /* renamed from: f  reason: collision with root package name */
        public boolean f8185f = true;

        public a() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f8182c = jSONObject.getLong("pub_lst_ts");
                    this.f8183d = g.a(jSONObject.getString("pub_info"));
                    this.f8186g = jSONObject.getInt("d_form_ver");
                    this.f8184e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public long a() {
            return this.f8182c;
        }

        public boolean a(PackageInfo packageInfo) {
            String a2 = c.this.f8178d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f8185f = false;
            return a(a2);
        }

        public g.a b() {
            return this.f8183d;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8188b;

        /* renamed from: c  reason: collision with root package name */
        public String f8189c;

        /* renamed from: d  reason: collision with root package name */
        public long f8190d;

        /* renamed from: e  reason: collision with root package name */
        public long f8191e;

        /* renamed from: f  reason: collision with root package name */
        public long f8192f;

        /* renamed from: g  reason: collision with root package name */
        public g.a f8193g;

        public b(String str) {
            super(c.this.f8178d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8189c = jSONObject.getString("pkg");
            this.f8191e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f8190d = jSONObject.getLong("last_fe_ts");
            this.f8193g = g.a(jSONObject.getString("info"));
            this.f8192f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8188b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8190d != j) {
                this.f8190d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8193g)) {
                return false;
            }
            this.f8193g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8189c)) {
                return false;
            }
            this.f8189c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8189c);
            jSONObject.put("last_fe_ts", this.f8190d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f8191e);
            jSONObject.put("info", this.f8193g.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8192f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8191e != j) {
                this.f8191e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8189c;
        }

        public boolean c(long j) {
            if (this.f8192f != j) {
                this.f8192f = j;
                a(true);
                return true;
            }
            return false;
        }

        public g.a d() {
            return this.f8193g;
        }

        public long e() {
            return this.f8192f;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f8179e = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        g.a b2;
        b bVar = null;
        try {
            packageInfo = this.f8162a.f8166a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.a(-2);
        }
        if (dVar.f8172a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                b2 = bVar.d();
                return a.e.a(b2);
            }
        }
        a aVar = new a();
        if (aVar.a(packageInfo)) {
            if (dVar.f8172a && bVar != null) {
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
        this.f8178d = this.f8163b.a("isc");
    }
}
