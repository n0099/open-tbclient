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
    public static Comparator<TrustSubject> f6288g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f6289h = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f6290a;

    /* renamed from: d  reason: collision with root package name */
    public Context f6293d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1848a f6294e;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.q.j.a.c.a f6291b = new d.a.q.j.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.a.q.j.a.b.a f6292c = new d.a.q.j.a.b.a();

    /* renamed from: f  reason: collision with root package name */
    public c f6295f = new c();

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
            int i2 = ((trustSubject.f6295f.k() - trustSubject2.f6295f.k()) > 0L ? 1 : ((trustSubject.f6295f.k() - trustSubject2.f6295f.k()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f6290a.compareTo(trustSubject2.f6290a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i2 = ((trustSubject.f6295f.o() - trustSubject2.f6295f.o()) > 0L ? 1 : ((trustSubject.f6295f.o() - trustSubject2.f6295f.o()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : trustSubject.f6290a.compareTo(trustSubject2.f6290a);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6296a;

        /* renamed from: b  reason: collision with root package name */
        public long f6297b;

        /* renamed from: c  reason: collision with root package name */
        public long f6298c;

        /* renamed from: d  reason: collision with root package name */
        public long f6299d;

        /* renamed from: e  reason: collision with root package name */
        public long f6300e;

        /* renamed from: f  reason: collision with root package name */
        public e f6301f = new e();

        /* renamed from: g  reason: collision with root package name */
        public boolean f6302g = true;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f6303h = new HashSet();

        public c() {
        }

        public long a(long j) {
            return this.f6301f.a(j);
        }

        public void c(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f6303h.size() == 0) {
                    return;
                }
                this.f6303h.clear();
            } else if (this.f6303h.equals(set)) {
                return;
            } else {
                this.f6303h.clear();
                this.f6303h.addAll(set);
            }
            this.f6302g = true;
        }

        public boolean d(int i2) {
            if (this.f6296a != i2) {
                this.f6296a = i2;
                this.f6302g = true;
                return true;
            }
            return false;
        }

        public boolean e(long j, long j2) {
            if (this.f6301f.c(j, j2)) {
                this.f6302g = true;
                return true;
            }
            return false;
        }

        public boolean f(boolean z) {
            return e(z ? 1L : 2L, 3L);
        }

        public int g() {
            return this.f6296a;
        }

        public boolean h(long j) {
            if (this.f6297b != j) {
                this.f6297b = j;
                this.f6302g = true;
                return true;
            }
            return false;
        }

        public long i() {
            return this.f6297b;
        }

        public boolean j(long j) {
            if (this.f6298c != j) {
                this.f6298c = j;
                this.f6302g = true;
                return true;
            }
            return false;
        }

        public long k() {
            return this.f6298c;
        }

        public boolean l(long j) {
            if (this.f6300e != j) {
                this.f6300e = j;
                this.f6302g = true;
                return true;
            }
            return false;
        }

        public long m() {
            return this.f6300e;
        }

        public boolean n(long j) {
            if (this.f6299d != j) {
                this.f6299d = j;
                return true;
            }
            return false;
        }

        public long o() {
            return this.f6299d;
        }

        public Set<String> p() {
            return this.f6303h;
        }

        public boolean q() {
            if (this.f6302g) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f6297b);
                    jSONObject.put("version_code", this.f6296a);
                    jSONObject.put("trust_priority", this.f6298c);
                    jSONObject.put("quick_config_version", this.f6299d);
                    jSONObject.put("config_version", this.f6300e);
                    jSONObject.put("flags", this.f6301f.d());
                    if (this.f6303h.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f6303h) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f6294e.i("ts_info", jSONObject.toString(), true);
                    this.f6302g = false;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        public void r() {
            String g2 = TrustSubject.this.f6294e.g("ts_info", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6297b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.f6296a = jSONObject.getInt("version_code");
                this.f6298c = jSONObject.getLong("trust_priority");
                this.f6299d = jSONObject.getLong("quick_config_version");
                this.f6300e = jSONObject.getLong("config_version");
                this.f6301f.b(jSONObject.getLong("flags"));
                this.f6303h.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        this.f6303h.add(optJSONArray.getString(i2));
                    }
                }
                this.f6302g = false;
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

    public TrustSubject(String str, Context context, a.C1848a c1848a) {
        this.f6293d = context;
        this.f6290a = str;
        this.f6294e = c1848a.f(c(str));
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
        return this.f6295f;
    }

    public void d(d.a.q.g.b.e.a aVar) {
        this.f6291b.b(aVar, true);
        this.f6295f.f(this.f6291b.d());
        this.f6295f.j(this.f6291b.i());
        this.f6295f.c(this.f6291b.j());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.f6290a.equals(((TrustSubject) obj).f6290a);
    }

    public void g() {
        long a2 = this.f6292c.a();
        this.f6295f.e(a2 > -1 ? 128L : 256L, 384L);
        this.f6295f.n(a2);
    }

    public boolean h() {
        int d2 = this.f6292c.d();
        if (d2 == 0) {
            this.f6295f.e(16L, 48L);
            this.f6295f.e(64L, 64L);
            this.f6295f.e(4L, 12L);
            i();
            this.f6295f.l(this.f6292c.j());
            return true;
        } else if (d2 != 3) {
            this.f6295f.e(32L, 48L);
            this.f6295f.e(0L, 64L);
            return false;
        } else {
            this.f6295f.e(32L, 48L);
            this.f6295f.e(8L, 12L);
            return false;
        }
    }

    public int hashCode() {
        return this.f6290a.hashCode();
    }

    public void i() {
        this.f6292c.h();
    }

    public void j() {
        this.f6292c.i();
    }

    public void k() {
        this.f6292c.f();
        this.f6295f.e(0L, 64L);
    }

    public void l() {
        this.f6292c.g();
    }

    public String m(String str) {
        this.f6292c.h();
        return this.f6292c.b(str);
    }

    public long n() {
        return this.f6295f.f6300e;
    }

    public long o() {
        return this.f6295f.k();
    }

    public boolean p() {
        return this.f6295f.o() == this.f6295f.m();
    }

    public void q() {
        try {
            PackageInfo packageInfo = this.f6293d.getPackageManager().getPackageInfo(this.f6290a, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            this.f6295f.h(j);
            this.f6295f.d(i2);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean r() {
        return this.f6295f.a(12L) == 4;
    }

    public boolean s() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f6293d.getPackageManager().getPackageInfo(this.f6290a, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public Set<String> t() {
        return new HashSet(this.f6295f.p());
    }

    public boolean u() {
        try {
            PackageInfo packageInfo = this.f6293d.getPackageManager().getPackageInfo(this.f6290a, 0);
            long j = packageInfo.lastUpdateTime;
            int i2 = packageInfo.versionCode;
            if (this.f6295f.i() == j) {
                return this.f6295f.g() == i2;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void v() {
        this.f6295f.r();
    }

    public boolean w() {
        return this.f6295f.q();
    }

    public final void x() {
        this.f6291b.c(this.f6290a, this.f6293d);
        this.f6292c.c(this.f6290a, this.f6293d, this.f6294e);
    }
}
