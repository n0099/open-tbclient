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
    public static Comparator<TrustSubject> f6272g = new a();

    /* renamed from: h  reason: collision with root package name */
    public static Comparator<TrustSubject> f6273h = new b();

    /* renamed from: a  reason: collision with root package name */
    public final String f6274a;

    /* renamed from: d  reason: collision with root package name */
    public Context f6277d;

    /* renamed from: e  reason: collision with root package name */
    public a.C1753a f6278e;

    /* renamed from: b  reason: collision with root package name */
    public final d.b.q.j.a.c.a f6275b = new d.b.q.j.a.c.a();

    /* renamed from: c  reason: collision with root package name */
    public final d.b.q.j.a.b.a f6276c = new d.b.q.j.a.b.a();

    /* renamed from: f  reason: collision with root package name */
    public c f6279f = new c();

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
            int i = ((trustSubject.f6279f.k() - trustSubject2.f6279f.k()) > 0L ? 1 : ((trustSubject.f6279f.k() - trustSubject2.f6279f.k()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : trustSubject.f6274a.compareTo(trustSubject2.f6274a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<TrustSubject> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            int i = ((trustSubject.f6279f.o() - trustSubject2.f6279f.o()) > 0L ? 1 : ((trustSubject.f6279f.o() - trustSubject2.f6279f.o()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : trustSubject.f6274a.compareTo(trustSubject2.f6274a);
        }
    }

    /* loaded from: classes2.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        public int f6280a;

        /* renamed from: b  reason: collision with root package name */
        public long f6281b;

        /* renamed from: c  reason: collision with root package name */
        public long f6282c;

        /* renamed from: d  reason: collision with root package name */
        public long f6283d;

        /* renamed from: e  reason: collision with root package name */
        public long f6284e;

        /* renamed from: f  reason: collision with root package name */
        public e f6285f = new e();

        /* renamed from: g  reason: collision with root package name */
        public boolean f6286g = true;

        /* renamed from: h  reason: collision with root package name */
        public Set<String> f6287h = new HashSet();

        public c() {
        }

        public long a(long j) {
            return this.f6285f.a(j);
        }

        public void c(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.f6287h.size() == 0) {
                    return;
                }
                this.f6287h.clear();
            } else if (this.f6287h.equals(set)) {
                return;
            } else {
                this.f6287h.clear();
                this.f6287h.addAll(set);
            }
            this.f6286g = true;
        }

        public boolean d(int i) {
            if (this.f6280a != i) {
                this.f6280a = i;
                this.f6286g = true;
                return true;
            }
            return false;
        }

        public boolean e(long j, long j2) {
            if (this.f6285f.c(j, j2)) {
                this.f6286g = true;
                return true;
            }
            return false;
        }

        public boolean f(boolean z) {
            return e(z ? 1L : 2L, 3L);
        }

        public int g() {
            return this.f6280a;
        }

        public boolean h(long j) {
            if (this.f6281b != j) {
                this.f6281b = j;
                this.f6286g = true;
                return true;
            }
            return false;
        }

        public long i() {
            return this.f6281b;
        }

        public boolean j(long j) {
            if (this.f6282c != j) {
                this.f6282c = j;
                this.f6286g = true;
                return true;
            }
            return false;
        }

        public long k() {
            return this.f6282c;
        }

        public boolean l(long j) {
            if (this.f6284e != j) {
                this.f6284e = j;
                this.f6286g = true;
                return true;
            }
            return false;
        }

        public long m() {
            return this.f6284e;
        }

        public boolean n(long j) {
            if (this.f6283d != j) {
                this.f6283d = j;
                return true;
            }
            return false;
        }

        public long o() {
            return this.f6283d;
        }

        public Set<String> p() {
            return this.f6287h;
        }

        public boolean q() {
            if (this.f6286g) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.f6281b);
                    jSONObject.put("version_code", this.f6280a);
                    jSONObject.put("trust_priority", this.f6282c);
                    jSONObject.put("quick_config_version", this.f6283d);
                    jSONObject.put("config_version", this.f6284e);
                    jSONObject.put("flags", this.f6285f.d());
                    if (this.f6287h.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.f6287h) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.f6278e.i("ts_info", jSONObject.toString(), true);
                    this.f6286g = false;
                    return true;
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            return false;
        }

        public void r() {
            String g2 = TrustSubject.this.f6278e.g("ts_info", true);
            if (TextUtils.isEmpty(g2)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(g2);
                this.f6281b = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.f6280a = jSONObject.getInt("version_code");
                this.f6282c = jSONObject.getLong("trust_priority");
                this.f6283d = jSONObject.getLong("quick_config_version");
                this.f6284e = jSONObject.getLong("config_version");
                this.f6285f.b(jSONObject.getLong("flags"));
                this.f6287h.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.f6287h.add(optJSONArray.getString(i));
                    }
                }
                this.f6286g = false;
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

    public TrustSubject(String str, Context context, a.C1753a c1753a) {
        this.f6277d = context;
        this.f6274a = str;
        this.f6278e = c1753a.f(c(str));
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
        return this.f6279f;
    }

    public void d(d.b.q.g.b.e.a aVar) {
        this.f6275b.b(aVar, true);
        this.f6279f.f(this.f6275b.d());
        this.f6279f.j(this.f6275b.i());
        this.f6279f.c(this.f6275b.j());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrustSubject.class != obj.getClass()) {
            return false;
        }
        return this.f6274a.equals(((TrustSubject) obj).f6274a);
    }

    public void g() {
        long a2 = this.f6276c.a();
        this.f6279f.e(a2 > -1 ? 128L : 256L, 384L);
        this.f6279f.n(a2);
    }

    public boolean h() {
        int d2 = this.f6276c.d();
        if (d2 == 0) {
            this.f6279f.e(16L, 48L);
            this.f6279f.e(64L, 64L);
            this.f6279f.e(4L, 12L);
            i();
            this.f6279f.l(this.f6276c.j());
            return true;
        } else if (d2 != 3) {
            this.f6279f.e(32L, 48L);
            this.f6279f.e(0L, 64L);
            return false;
        } else {
            this.f6279f.e(32L, 48L);
            this.f6279f.e(8L, 12L);
            return false;
        }
    }

    public int hashCode() {
        return this.f6274a.hashCode();
    }

    public void i() {
        this.f6276c.h();
    }

    public void j() {
        this.f6276c.i();
    }

    public void k() {
        this.f6276c.f();
        this.f6279f.e(0L, 64L);
    }

    public void l() {
        this.f6276c.g();
    }

    public String m(String str) {
        this.f6276c.h();
        return this.f6276c.b(str);
    }

    public long n() {
        return this.f6279f.f6284e;
    }

    public long o() {
        return this.f6279f.k();
    }

    public boolean p() {
        return this.f6279f.o() == this.f6279f.m();
    }

    public void q() {
        try {
            PackageInfo packageInfo = this.f6277d.getPackageManager().getPackageInfo(this.f6274a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            this.f6279f.h(j);
            this.f6279f.d(i);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public boolean r() {
        return this.f6279f.a(12L) == 4;
    }

    public boolean s() {
        PackageInfo packageInfo;
        try {
            packageInfo = this.f6277d.getPackageManager().getPackageInfo(this.f6274a, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public Set<String> t() {
        return new HashSet(this.f6279f.p());
    }

    public boolean u() {
        try {
            PackageInfo packageInfo = this.f6277d.getPackageManager().getPackageInfo(this.f6274a, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            if (this.f6279f.i() == j) {
                return this.f6279f.g() == i;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void v() {
        this.f6279f.r();
    }

    public boolean w() {
        return this.f6279f.q();
    }

    public final void x() {
        this.f6275b.c(this.f6274a, this.f6277d);
        this.f6276c.c(this.f6274a, this.f6277d, this.f6278e);
    }
}
