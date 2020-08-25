package com.baidu.helios.trusts.zone;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes20.dex */
public class TrustSubject {
    static Comparator<TrustSubject> a = new Comparator<TrustSubject>() { // from class: com.baidu.helios.trusts.zone.TrustSubject.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            long d = trustSubject.axT.d() - trustSubject2.axT.d();
            return d != 0 ? d > 0 ? -1 : 1 : trustSubject.packageName.compareTo(trustSubject2.packageName);
        }
    };
    static Comparator<TrustSubject> axU = new Comparator<TrustSubject>() { // from class: com.baidu.helios.trusts.zone.TrustSubject.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(TrustSubject trustSubject, TrustSubject trustSubject2) {
            long f = trustSubject.axT.f() - trustSubject2.axT.f();
            return f != 0 ? f > 0 ? -1 : 1 : trustSubject.packageName.compareTo(trustSubject2.packageName);
        }
    };
    private a.C0148a axS;
    private Context e;
    public final String packageName;
    private final com.baidu.helios.trusts.zone.b.a axQ = new com.baidu.helios.trusts.zone.b.a();
    private final com.baidu.helios.trusts.zone.a.a axR = new com.baidu.helios.trusts.zone.a.a();
    private a axT = new a();

    /* loaded from: classes20.dex */
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a {
        private int t;
        private long u;
        private long v;
        private long w;
        private long x;
        private e axV = new e();
        private boolean z = true;
        private Set<String> axW = new HashSet();

        a() {
        }

        public Set<String> Aw() {
            return this.axW;
        }

        public boolean Q(long j) {
            if (this.v != j) {
                this.v = j;
                this.z = true;
                return true;
            }
            return false;
        }

        public boolean U(long j) {
            if (this.x != j) {
                this.x = j;
                this.z = true;
                return true;
            }
            return false;
        }

        public boolean V(long j) {
            if (this.w != j) {
                this.w = j;
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a(long j) {
            return this.axV.T(j);
        }

        public void a(Set<String> set) {
            if (set == null || set.size() == 0) {
                if (this.axW.size() != 0) {
                    this.axW.clear();
                    this.z = true;
                }
            } else if (this.axW.equals(set)) {
            } else {
                this.axW.clear();
                this.axW.addAll(set);
                this.z = true;
            }
        }

        public boolean a(int i) {
            if (this.t != i) {
                this.t = i;
                this.z = true;
                return true;
            }
            return false;
        }

        boolean a(long j, long j2) {
            if (this.axV.d(j, j2)) {
                this.z = true;
                return true;
            }
            return false;
        }

        public boolean a(boolean z) {
            return a(z ? 1L : 2L, 3L);
        }

        public int b() {
            return this.t;
        }

        public boolean b(long j) {
            if (this.u != j) {
                this.u = j;
                this.z = true;
                return true;
            }
            return false;
        }

        public long c() {
            return this.u;
        }

        public long d() {
            return this.v;
        }

        public long e() {
            return this.x;
        }

        public long f() {
            return this.w;
        }

        public boolean h() {
            if (this.z) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME, this.u);
                    jSONObject.put("version_code", this.t);
                    jSONObject.put("trust_priority", this.v);
                    jSONObject.put("quick_config_version", this.w);
                    jSONObject.put("config_version", this.x);
                    jSONObject.put("flags", this.axV.Ae());
                    if (this.axW.size() > 0) {
                        JSONArray jSONArray = new JSONArray();
                        for (String str : this.axW) {
                            jSONArray.put(str);
                        }
                        jSONObject.put("pkg_sigs", jSONArray);
                    }
                    TrustSubject.this.axS.d("ts_info", jSONObject.toString(), true);
                    this.z = false;
                    return true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }

        public void i() {
            String q = TrustSubject.this.axS.q("ts_info", true);
            if (TextUtils.isEmpty(q)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(q);
                this.u = jSONObject.getLong(TableDefine.UserInfoColumns.COLUMN_UPDATE_TIME);
                this.t = jSONObject.getInt("version_code");
                this.v = jSONObject.getLong("trust_priority");
                this.w = jSONObject.getLong("quick_config_version");
                this.x = jSONObject.getLong("config_version");
                this.axV.S(jSONObject.getLong("flags"));
                this.axW.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("pkg_sigs");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        this.axW.add(optJSONArray.getString(i));
                    }
                }
                this.z = false;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public static class b implements FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return file.isDirectory() && file.getName().startsWith("pkg-");
        }
    }

    public TrustSubject(String str, Context context, a.C0148a c0148a) {
        this.e = context;
        this.packageName = str;
        this.axS = c0148a.fv(a(str));
        n();
    }

    static String a(String str) {
        return "pkg-" + Base64.encodeToString(str.getBytes(), 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() > "pkg-".length()) {
            try {
                return new String(Base64.decode(str.substring("pkg-".length()), 3));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private void n() {
        this.axQ.a(this.packageName, this.e);
        this.axR.a(this.packageName, this.e, this.axS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a Aq() {
        return this.axT;
    }

    public boolean Ar() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = this.e.getPackageManager().getPackageInfo(this.packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        return packageInfo != null;
    }

    public long As() {
        return this.axT.x;
    }

    public long At() {
        return this.axT.d();
    }

    public boolean Au() {
        return this.axT.a(12L) == 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<String> Av() {
        return new HashSet(this.axT.Aw());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.baidu.helios.common.a.b.a aVar) {
        this.axQ.a(aVar, true);
        this.axT.a(this.axQ.a());
        this.axT.Q(this.axQ.b());
        this.axT.a(this.axQ.Az());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        long a2 = this.axR.a();
        if (a2 > -1) {
            this.axT.a(128L, 384L);
        } else {
            this.axT.a(256L, 384L);
        }
        this.axT.V(a2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        switch (this.axR.b()) {
            case 0:
                this.axT.a(16L, 48L);
                this.axT.a(64L, 64L);
                this.axT.a(4L, 12L);
                d();
                this.axT.U(this.axR.g());
                return true;
            case 1:
            case 2:
            default:
                this.axT.a(32L, 48L);
                this.axT.a(0L, 64L);
                return false;
            case 3:
                this.axT.a(32L, 48L);
                this.axT.a(8L, 12L);
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.axR.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.axR.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.packageName.equals(((TrustSubject) obj).packageName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.axR.c();
        this.axT.a(0L, 64L);
    }

    public String fx(String str) {
        this.axR.e();
        return this.axR.a(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.axR.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.axT.f() == this.axT.e();
    }

    public int hashCode() {
        return this.packageName.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(this.packageName, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            this.axT.b(j);
            this.axT.a(i);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        try {
            PackageInfo packageInfo = this.e.getPackageManager().getPackageInfo(this.packageName, 0);
            long j = packageInfo.lastUpdateTime;
            int i = packageInfo.versionCode;
            if (this.axT.c() == j) {
                return this.axT.b() == i;
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        this.axT.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        return this.axT.h();
    }
}
