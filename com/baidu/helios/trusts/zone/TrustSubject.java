package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import d.a.q.g.c.a.e;
import d.a.q.g.d.a;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class TrustSubject {

    /* renamed from: g  reason: collision with root package name */
    public static Comparator<TrustSubject> f6345g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f6346h = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f6347a;

    /* renamed from: d  reason: collision with root package name */
    public Context f6350d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1785a f6351e;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q.j.a.c.a f6348b = new d.a.q.j.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.q.j.a.b.a f6349c = new d.a.q.j.a.b.a();

    /* renamed from: f  reason: collision with root package name */
    public c f6352f = new c();

    /* loaded from: classes2.dex */
    public static class ConfigNotFoundException extends Exception {
        public ConfigNotFoundException(String str) {
            super(str);
        }

        public ConfigNotFoundException(String str, Throwable th) {
            super(str, th);
        }

        public ConfigNotFoundException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public static class a implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i2 = ((trustSubject.f6352f.k() - trustSubject2.f6352f.k()) > 0L ? 1 : ((trustSubject.f6352f.k() - trustSubject2.f6352f.k()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f6347a.compareTo(trustSubject2.f6347a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i2 = ((trustSubject.f6352f.o() - trustSubject2.f6352f.o()) > 0L ? 1 : ((trustSubject.f6352f.o() - trustSubject2.f6352f.o()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f6347a.compareTo(trustSubject2.f6347a);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6353a;

        /* renamed from: b  reason: collision with root package name */
        public long f6354b;

        /* renamed from: c  reason: collision with root package name */
        public long f6355c;

        /* renamed from: d  reason: collision with root package name */
        public long f6356d;

        /* renamed from: e  reason: collision with root package name */
        public long f6357e;

        /* renamed from: f  reason: collision with root package name */
        public e f6358f = new e();

        /* renamed from: g  reason: collision with root package name */
        public boolean f6359g = true;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f6360h = new HashSet();

        public c() {
        }

        public long a(long j) {
            return this.f6358f.a(j);
        }

        public void c(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f6360h.size() == 0) {
                    return;
                }
                this.f6360h.clear();
            } else if (this.f6360h.equals(set)) {
                return;
            } else {
                this.f6360h.clear();
                this.f6360h.addAll(set);
            }
            this.f6359g = true;
        }

        public boolean d(int i2) {
            if (this.f6353a != i2) {
                this.f6353a = i2;
                this.f6359g = true;
                return true;
            }
            return false;
        }

        public boolean e(long j, long j2) {
            if (this.f6358f.c(j, j2)) {
                this.f6359g = true;
                return true;
            }
            return false;
        }

        public boolean f(boolean z) {
            return e(z ? 1L : 2L, 3L);
        }

        public int g() {
            return this.f6353a;
        }

        public boolean h(long j) {
            if (this.f6354b != j) {
                this.f6354b = j;
                this.f6359g = true;
                return true;
            }
            return false;
        }

        public long i() {
            return this.f6354b;
        }

        public boolean j(long j) {
            if (this.f6355c != j) {
                this.f6355c = j;
                this.f6359g = true;
                return true;
            }
            return false;
        }

        public long k() {
            return this.f6355c;
        }

        public boolean l(long j) {
            if (this.f6357e != j) {
                this.f6357e = j;
                this.f6359g = true;
                return true;
            }
            return false;
        }

        public long m() {
            return this.f6357e;
        }

        public boolean n(long j) {
            if (this.f6356d != j) {
                this.f6356d = j;
                return true;
            }
            return false;
        }

        public long o() {
            return this.f6356d;
        }

        public Set<String> p() {
            return this.f6360h;
        }

        public boolean q() {
            if (this.f6359g) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f6354b);
                    jSONObject.put("version_code", this.f6353a);
                    jSONObject.put("trust_priority", this.f6355c);
                    jSONObject.put("quick_config_version", this.f6356d);
                    jSONObject.put("config_version", this.f6357e);
                    jSONObject.put("flags", this.f6358f.d());
                    if (this.f6360h.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f6360h) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f6351e.i("ts_info", jSONObject.toString(), true);
                    this.f6359g = false;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        public void r() {
            String g2 = TrustSubject.this.f6351e.g("ts_info", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6354b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.f6353a = jSONObject.getInt("version_code");
                this.f6355c = jSONObject.getLong("trust_priority");
                this.f6356d = jSONObject.getLong("quick_config_version");
                this.f6357e = jSONObject.getLong("config_version");
                this.f6358f.b(jSONObject.getLong("flags"));
                this.f6360h.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f6360h.add(optJSONArray.getString(i2));
                    }
                }
                this.f6359g = false;
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().startsWith("pkg-");
        }
    }

    public TrustSubject(String str, Context context, a.C1785a c1785a) {
        this.f6350d = context;
        this.f6347a = str;
        this.f6351e = c1785a.f(c(str));
        x();
    }

    public static String c(String str) {
        return "pkg-" + Base64.encodeToString(str.getBytes(), 3);
    }

    public static String f(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > 4) {
            try {
                return new String(Base64.decode(str.substring(4), 3));
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public c a() {
        return this.f6352f;
    }

    public void d(d.a.q.g.b.e.a aVar) {
        this.f6348b.b(aVar, true);
        this.f6352f.f(this.f6348b.d());
        this.f6352f.j(this.f6348b.i());
        this.f6352f.c(this.f6348b.j());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.f6347a.equals(((TrustSubject) obj).f6347a);
    }

    public void g() {
        long a2 = this.f6349c.a();
        this.f6352f.e(a2 > -1 ? 128L : 256L, 384L);
        this.f6352f.n(a2);
    }

    public boolean h() {
        int d2 = this.f6349c.d();
        if (d2 == 0) {
            this.f6352f.e(16L, 48L);
            this.f6352f.e(64L, 64L);
            this.f6352f.e(4L, 12L);
            i();
            this.f6352f.l(this.f6349c.j());
            return true;
        } else if (d2 != 3) {
            this.f6352f.e(32L, 48L);
            this.f6352f.e(0L, 64L);
            return false;
        } else {
            this.f6352f.e(32L, 48L);
            this.f6352f.e(8L, 12L);
            return false;
        }
    }

    public int hashCode() {
        return this.f6347a.hashCode();
    }

    public void i() {
        this.f6349c.h();
    }

    public void j() {
        this.f6349c.i();
    }

    public void k() {
        this.f6349c.f();
        this.f6352f.e(0L, 64L);
    }

    public void l() {
        this.f6349c.g();
    }

    public String m(String str) {
        this.f6349c.h();
        return this.f6349c.b(str);
    }

    public long n() {
        return this.f6352f.f6357e;
    }

    public long o() {
        return this.f6352f.k();
    }

    public boolean p() {
        return this.f6352f.o() == this.f6352f.m();
    }

    public void q() {
        try {
            PackageInfo packageInfo = this.f6350d.getPackageManager().getPackageInfo(this.f6347a, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            this.f6352f.h(j);
            this.f6352f.d(i2);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean r() {
        return this.f6352f.a(12L) == 4;
    }

    public boolean s() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f6350d.getPackageManager().getPackageInfo(this.f6347a, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public Set<String> t() {
        return new HashSet(this.f6352f.p());
    }

    public boolean u() {
        try {
            PackageInfo packageInfo = this.f6350d.getPackageManager().getPackageInfo(this.f6347a, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            if (this.f6352f.i() == j) {
                return this.f6352f.g() == i2;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void v() {
        this.f6352f.r();
    }

    public boolean w() {
        return this.f6352f.q();
    }

    public final void x() {
        this.f6348b.c(this.f6347a, this.f6350d);
        this.f6349c.c(this.f6347a, this.f6350d, this.f6351e);
    }
}
