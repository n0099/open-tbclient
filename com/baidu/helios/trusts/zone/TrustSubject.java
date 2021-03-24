package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import d.b.q.g.c.a.e;
import d.b.q.g.d.a;
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
    public static Comparator<TrustSubject> f6271g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f6272h = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f6273a;

    /* renamed from: d  reason: collision with root package name */
    public Context f6276d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1752a f6277e;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.q.j.a.c.a f6274b = new d.b.q.j.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.b.q.j.a.b.a f6275c = new d.b.q.j.a.b.a();

    /* renamed from: f  reason: collision with root package name */
    public c f6278f = new c();

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
            long k = trustSubject.f6278f.k() - trustSubject2.f6278f.k();
            return k != 0 ? k > 0 ? -1 : 1 : trustSubject.f6273a.compareTo(trustSubject2.f6273a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            long o = trustSubject.f6278f.o() - trustSubject2.f6278f.o();
            return o != 0 ? o > 0 ? -1 : 1 : trustSubject.f6273a.compareTo(trustSubject2.f6273a);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6279a;

        /* renamed from: b  reason: collision with root package name */
        public long f6280b;

        /* renamed from: c  reason: collision with root package name */
        public long f6281c;

        /* renamed from: d  reason: collision with root package name */
        public long f6282d;

        /* renamed from: e  reason: collision with root package name */
        public long f6283e;

        /* renamed from: f  reason: collision with root package name */
        public e f6284f = new e();

        /* renamed from: g  reason: collision with root package name */
        public boolean f6285g = true;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f6286h = new HashSet();

        public c() {
        }

        public long a(long j) {
            return this.f6284f.a(j);
        }

        public void c(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f6286h.size() == 0) {
                    return;
                }
                this.f6286h.clear();
            } else if (this.f6286h.equals(set)) {
                return;
            } else {
                this.f6286h.clear();
                this.f6286h.addAll(set);
            }
            this.f6285g = true;
        }

        public boolean d(int i) {
            if (this.f6279a != i) {
                this.f6279a = i;
                this.f6285g = true;
                return true;
            }
            return false;
        }

        public boolean e(long j, long j2) {
            if (this.f6284f.c(j, j2)) {
                this.f6285g = true;
                return true;
            }
            return false;
        }

        public boolean f(boolean z) {
            return e(z ? 1L : 2L, 3L);
        }

        public int g() {
            return this.f6279a;
        }

        public boolean h(long j) {
            if (this.f6280b != j) {
                this.f6280b = j;
                this.f6285g = true;
                return true;
            }
            return false;
        }

        public long i() {
            return this.f6280b;
        }

        public boolean j(long j) {
            if (this.f6281c != j) {
                this.f6281c = j;
                this.f6285g = true;
                return true;
            }
            return false;
        }

        public long k() {
            return this.f6281c;
        }

        public boolean l(long j) {
            if (this.f6283e != j) {
                this.f6283e = j;
                this.f6285g = true;
                return true;
            }
            return false;
        }

        public long m() {
            return this.f6283e;
        }

        public boolean n(long j) {
            if (this.f6282d != j) {
                this.f6282d = j;
                return true;
            }
            return false;
        }

        public long o() {
            return this.f6282d;
        }

        public Set<String> p() {
            return this.f6286h;
        }

        public boolean q() {
            if (this.f6285g) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f6280b);
                    jSONObject.put("version_code", this.f6279a);
                    jSONObject.put("trust_priority", this.f6281c);
                    jSONObject.put("quick_config_version", this.f6282d);
                    jSONObject.put("config_version", this.f6283e);
                    jSONObject.put("flags", this.f6284f.d());
                    if (this.f6286h.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f6286h) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f6277e.i("ts_info", jSONObject.toString(), true);
                    this.f6285g = false;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        public void r() {
            String g2 = TrustSubject.this.f6277e.g("ts_info", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6280b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.f6279a = jSONObject.getInt("version_code");
                this.f6281c = jSONObject.getLong("trust_priority");
                this.f6282d = jSONObject.getLong("quick_config_version");
                this.f6283e = jSONObject.getLong("config_version");
                this.f6284f.b(jSONObject.getLong("flags"));
                this.f6286h.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.f6286h.add(optJSONArray.getString(i));
                    }
                }
                this.f6285g = false;
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

    public TrustSubject(String str, Context context, a.C1752a c1752a) {
        this.f6276d = context;
        this.f6273a = str;
        this.f6277e = c1752a.f(c(str));
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
        return this.f6278f;
    }

    public void d(d.b.q.g.b.e.a aVar) {
        this.f6274b.b(aVar, true);
        this.f6278f.f(this.f6274b.d());
        this.f6278f.j(this.f6274b.i());
        this.f6278f.c(this.f6274b.j());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.f6273a.equals(((TrustSubject) obj).f6273a);
    }

    public void g() {
        long a2 = this.f6275c.a();
        this.f6278f.e(a2 > -1 ? 128L : 256L, 384L);
        this.f6278f.n(a2);
    }

    public boolean h() {
        int d2 = this.f6275c.d();
        if (d2 == 0) {
            this.f6278f.e(16L, 48L);
            this.f6278f.e(64L, 64L);
            this.f6278f.e(4L, 12L);
            i();
            this.f6278f.l(this.f6275c.j());
            return true;
        } else if (d2 != 3) {
            this.f6278f.e(32L, 48L);
            this.f6278f.e(0L, 64L);
            return false;
        } else {
            this.f6278f.e(32L, 48L);
            this.f6278f.e(8L, 12L);
            return false;
        }
    }

    public int hashCode() {
        return this.f6273a.hashCode();
    }

    public void i() {
        this.f6275c.h();
    }

    public void j() {
        this.f6275c.i();
    }

    public void k() {
        this.f6275c.f();
        this.f6278f.e(0L, 64L);
    }

    public void l() {
        this.f6275c.g();
    }

    public String m(String str) {
        this.f6275c.h();
        return this.f6275c.b(str);
    }

    public long n() {
        return this.f6278f.f6283e;
    }

    public long o() {
        return this.f6278f.k();
    }

    public boolean p() {
        return this.f6278f.o() == this.f6278f.m();
    }

    public void q() {
        try {
            PackageInfo packageInfo = this.f6276d.getPackageManager().getPackageInfo(this.f6273a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            this.f6278f.h(j);
            this.f6278f.d(i);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean r() {
        return this.f6278f.a(12L) == 4;
    }

    public boolean s() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f6276d.getPackageManager().getPackageInfo(this.f6273a, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public Set<String> t() {
        return new HashSet(this.f6278f.p());
    }

    public boolean u() {
        try {
            PackageInfo packageInfo = this.f6276d.getPackageManager().getPackageInfo(this.f6273a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            if (this.f6278f.i() == j) {
                return this.f6278f.g() == i;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void v() {
        this.f6278f.r();
    }

    public boolean w() {
        return this.f6278f.q();
    }

    public final void x() {
        this.f6274b.c(this.f6273a, this.f6276d);
        this.f6275c.c(this.f6273a, this.f6276d, this.f6277e);
    }
}
