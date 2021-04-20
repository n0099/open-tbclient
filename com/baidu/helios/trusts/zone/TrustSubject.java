package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import d.b.p.g.c.a.e;
import d.b.p.g.d.a;
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
    public static Comparator<TrustSubject> f6307g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f6308h = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f6309a;

    /* renamed from: d  reason: collision with root package name */
    public Context f6312d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1765a f6313e;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.p.j.a.c.a f6310b = new d.b.p.j.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.b.p.j.a.b.a f6311c = new d.b.p.j.a.b.a();

    /* renamed from: f  reason: collision with root package name */
    public c f6314f = new c();

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
            int i = ((trustSubject.f6314f.k() - trustSubject2.f6314f.k()) > 0L ? 1 : ((trustSubject.f6314f.k() - trustSubject2.f6314f.k()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : trustSubject.f6309a.compareTo(trustSubject2.f6309a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i = ((trustSubject.f6314f.o() - trustSubject2.f6314f.o()) > 0L ? 1 : ((trustSubject.f6314f.o() - trustSubject2.f6314f.o()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : trustSubject.f6309a.compareTo(trustSubject2.f6309a);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6315a;

        /* renamed from: b  reason: collision with root package name */
        public long f6316b;

        /* renamed from: c  reason: collision with root package name */
        public long f6317c;

        /* renamed from: d  reason: collision with root package name */
        public long f6318d;

        /* renamed from: e  reason: collision with root package name */
        public long f6319e;

        /* renamed from: f  reason: collision with root package name */
        public e f6320f = new e();

        /* renamed from: g  reason: collision with root package name */
        public boolean f6321g = true;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f6322h = new HashSet();

        public c() {
        }

        public long a(long j) {
            return this.f6320f.a(j);
        }

        public void c(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f6322h.size() == 0) {
                    return;
                }
                this.f6322h.clear();
            } else if (this.f6322h.equals(set)) {
                return;
            } else {
                this.f6322h.clear();
                this.f6322h.addAll(set);
            }
            this.f6321g = true;
        }

        public boolean d(int i) {
            if (this.f6315a != i) {
                this.f6315a = i;
                this.f6321g = true;
                return true;
            }
            return false;
        }

        public boolean e(long j, long j2) {
            if (this.f6320f.c(j, j2)) {
                this.f6321g = true;
                return true;
            }
            return false;
        }

        public boolean f(boolean z) {
            return e(z ? 1L : 2L, 3L);
        }

        public int g() {
            return this.f6315a;
        }

        public boolean h(long j) {
            if (this.f6316b != j) {
                this.f6316b = j;
                this.f6321g = true;
                return true;
            }
            return false;
        }

        public long i() {
            return this.f6316b;
        }

        public boolean j(long j) {
            if (this.f6317c != j) {
                this.f6317c = j;
                this.f6321g = true;
                return true;
            }
            return false;
        }

        public long k() {
            return this.f6317c;
        }

        public boolean l(long j) {
            if (this.f6319e != j) {
                this.f6319e = j;
                this.f6321g = true;
                return true;
            }
            return false;
        }

        public long m() {
            return this.f6319e;
        }

        public boolean n(long j) {
            if (this.f6318d != j) {
                this.f6318d = j;
                return true;
            }
            return false;
        }

        public long o() {
            return this.f6318d;
        }

        public Set<String> p() {
            return this.f6322h;
        }

        public boolean q() {
            if (this.f6321g) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f6316b);
                    jSONObject.put("version_code", this.f6315a);
                    jSONObject.put("trust_priority", this.f6317c);
                    jSONObject.put("quick_config_version", this.f6318d);
                    jSONObject.put("config_version", this.f6319e);
                    jSONObject.put("flags", this.f6320f.d());
                    if (this.f6322h.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f6322h) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f6313e.i("ts_info", jSONObject.toString(), true);
                    this.f6321g = false;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        public void r() {
            String g2 = TrustSubject.this.f6313e.g("ts_info", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6316b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.f6315a = jSONObject.getInt("version_code");
                this.f6317c = jSONObject.getLong("trust_priority");
                this.f6318d = jSONObject.getLong("quick_config_version");
                this.f6319e = jSONObject.getLong("config_version");
                this.f6320f.b(jSONObject.getLong("flags"));
                this.f6322h.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.f6322h.add(optJSONArray.getString(i));
                    }
                }
                this.f6321g = false;
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

    public TrustSubject(String str, Context context, a.C1765a c1765a) {
        this.f6312d = context;
        this.f6309a = str;
        this.f6313e = c1765a.f(c(str));
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
        return this.f6314f;
    }

    public void d(d.b.p.g.b.e.a aVar) {
        this.f6310b.b(aVar, true);
        this.f6314f.f(this.f6310b.d());
        this.f6314f.j(this.f6310b.i());
        this.f6314f.c(this.f6310b.j());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.f6309a.equals(((TrustSubject) obj).f6309a);
    }

    public void g() {
        long a2 = this.f6311c.a();
        this.f6314f.e(a2 > -1 ? 128L : 256L, 384L);
        this.f6314f.n(a2);
    }

    public boolean h() {
        int d2 = this.f6311c.d();
        if (d2 == 0) {
            this.f6314f.e(16L, 48L);
            this.f6314f.e(64L, 64L);
            this.f6314f.e(4L, 12L);
            i();
            this.f6314f.l(this.f6311c.j());
            return true;
        } else if (d2 != 3) {
            this.f6314f.e(32L, 48L);
            this.f6314f.e(0L, 64L);
            return false;
        } else {
            this.f6314f.e(32L, 48L);
            this.f6314f.e(8L, 12L);
            return false;
        }
    }

    public int hashCode() {
        return this.f6309a.hashCode();
    }

    public void i() {
        this.f6311c.h();
    }

    public void j() {
        this.f6311c.i();
    }

    public void k() {
        this.f6311c.f();
        this.f6314f.e(0L, 64L);
    }

    public void l() {
        this.f6311c.g();
    }

    public String m(String str) {
        this.f6311c.h();
        return this.f6311c.b(str);
    }

    public long n() {
        return this.f6314f.f6319e;
    }

    public long o() {
        return this.f6314f.k();
    }

    public boolean p() {
        return this.f6314f.o() == this.f6314f.m();
    }

    public void q() {
        try {
            PackageInfo packageInfo = this.f6312d.getPackageManager().getPackageInfo(this.f6309a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            this.f6314f.h(j);
            this.f6314f.d(i);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean r() {
        return this.f6314f.a(12L) == 4;
    }

    public boolean s() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f6312d.getPackageManager().getPackageInfo(this.f6309a, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public Set<String> t() {
        return new HashSet(this.f6314f.p());
    }

    public boolean u() {
        try {
            PackageInfo packageInfo = this.f6312d.getPackageManager().getPackageInfo(this.f6309a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            if (this.f6314f.i() == j) {
                return this.f6314f.g() == i;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void v() {
        this.f6314f.r();
    }

    public boolean w() {
        return this.f6314f.q();
    }

    public final void x() {
        this.f6310b.c(this.f6309a, this.f6312d);
        this.f6311c.c(this.f6309a, this.f6312d, this.f6313e);
    }
}
