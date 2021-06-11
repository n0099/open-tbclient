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
    public a.C0107a f8140d;

    /* renamed from: e  reason: collision with root package name */
    public a f8141e;

    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: c  reason: collision with root package name */
        public long f8144c;

        /* renamed from: d  reason: collision with root package name */
        public g.a f8145d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f8146e;

        /* renamed from: g  reason: collision with root package name */
        public int f8148g;

        /* renamed from: b  reason: collision with root package name */
        public com.baidu.mobads.cid.cesium.f.b f8143b = new com.baidu.mobads.cid.cesium.f.b();

        /* renamed from: f  reason: collision with root package name */
        public boolean f8147f = true;

        public a() {
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.f8144c = jSONObject.getLong("pub_lst_ts");
                    this.f8145d = g.a(jSONObject.getString("pub_info"));
                    this.f8148g = jSONObject.getInt("d_form_ver");
                    this.f8146e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public long a() {
            return this.f8144c;
        }

        public boolean a(PackageInfo packageInfo) {
            String a2 = c.this.f8140d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f8147f = false;
            return a(a2);
        }

        public g.a b() {
            return this.f8145d;
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a.b {

        /* renamed from: b  reason: collision with root package name */
        public int f8150b;

        /* renamed from: c  reason: collision with root package name */
        public String f8151c;

        /* renamed from: d  reason: collision with root package name */
        public long f8152d;

        /* renamed from: e  reason: collision with root package name */
        public long f8153e;

        /* renamed from: f  reason: collision with root package name */
        public long f8154f;

        /* renamed from: g  reason: collision with root package name */
        public g.a f8155g;

        public b(String str) {
            super(c.this.f8140d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void a(JSONObject jSONObject) {
            this.f8151c = jSONObject.getString("pkg");
            this.f8153e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.f8152d = jSONObject.getLong("last_fe_ts");
            this.f8155g = g.a(jSONObject.getString("info"));
            this.f8154f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.f8150b = jSONObject.getInt("d_form_ver");
        }

        public boolean a(long j) {
            if (this.f8152d != j) {
                this.f8152d = j;
                a(true);
                return true;
            }
            return false;
        }

        public boolean a(g.a aVar) {
            if (aVar.equals(this.f8155g)) {
                return false;
            }
            this.f8155g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.f8151c)) {
                return false;
            }
            this.f8151c = str;
            a(true);
            return true;
        }

        @Override // com.baidu.mobads.cid.cesium.b.a.b
        public void b(JSONObject jSONObject) {
            jSONObject.put("pkg", this.f8151c);
            jSONObject.put("last_fe_ts", this.f8152d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.f8153e);
            jSONObject.put("info", this.f8155g.b());
            jSONObject.put("tar_pkg_lst_up_ts", this.f8154f);
            jSONObject.put("d_form_ver", 1);
        }

        public boolean b(long j) {
            if (this.f8153e != j) {
                this.f8153e = j;
                a(true);
                return true;
            }
            return false;
        }

        public String c() {
            return this.f8151c;
        }

        public boolean c(long j) {
            if (this.f8154f != j) {
                this.f8154f = j;
                a(true);
                return true;
            }
            return false;
        }

        public g.a d() {
            return this.f8155g;
        }

        public long e() {
            return this.f8154f;
        }
    }

    public c() {
        super("isc", 8000000L);
        this.f8141e = new a();
    }

    @Override // com.baidu.mobads.cid.cesium.b.a
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        g.a b2;
        b bVar = null;
        try {
            packageInfo = this.f8124a.f8128a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.a(-2);
        }
        if (dVar.f8134a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                b2 = bVar.d();
                return a.e.a(b2);
            }
        }
        a aVar = new a();
        if (aVar.a(packageInfo)) {
            if (dVar.f8134a && bVar != null) {
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
        this.f8140d = this.f8125b.a("isc");
    }
}
