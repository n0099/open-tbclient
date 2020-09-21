package com.baidu.helios.ids.a;

import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.b.a.f;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import com.baidu.helios.trusts.zone.TrustSubject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes16.dex */
public class a extends com.baidu.helios.ids.a {
    private a.C0149a awa;
    private b axL;

    /* renamed from: com.baidu.helios.ids.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    static class C0151a {
        private HashSet<String> axM = new HashSet<>();
        private HashSet<String> e = new HashSet<>();

        C0151a() {
        }

        public static C0151a b(TrustSubject trustSubject) {
            try {
                String fA = trustSubject.fA("config-aid");
                if (!TextUtils.isEmpty(fA)) {
                    try {
                        C0151a c0151a = new C0151a();
                        JSONObject jSONObject = new JSONObject(fA);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                c0151a.axM.add(optJSONArray.getString(i));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                c0151a.e.add(optJSONArray2.getString(i2));
                            }
                            return c0151a;
                        }
                        return c0151a;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (TrustSubject.ConfigNotFoundException e2) {
                e2.printStackTrace();
            }
            return null;
        }

        public boolean a(String str) {
            return this.axM.contains(str);
        }

        public boolean b(String str) {
            return this.e.contains(str);
        }
    }

    /* loaded from: classes16.dex */
    class b {
        private byte[] f;
        private String g;
        private String h;
        private long i;
        private String k;
        private long m;
        private int n;
        private boolean j = true;
        private e axN = new e();

        b() {
        }

        public void a(long j) {
            if (j != this.i) {
                this.i = j;
                this.j = true;
            }
        }

        public void a(long j, long j2) {
            if (this.axN.d(j, j2)) {
                this.j = true;
            }
        }

        public void a(String str) {
            if (str == this.g) {
                return;
            }
            if (str == null || !str.equals(this.g)) {
                this.g = str;
                this.j = true;
            }
        }

        public void a(byte[] bArr) {
            if (Arrays.equals(bArr, this.f)) {
                return;
            }
            this.f = bArr;
            this.j = true;
        }

        public byte[] a() {
            return this.f;
        }

        public long b(long j) {
            return this.axN.S(j);
        }

        public String b() {
            return this.g;
        }

        public void b(String str) {
            if (this.h == str) {
                return;
            }
            if (str == null || !str.equals(this.h)) {
                this.h = str;
                this.j = true;
            }
        }

        String c() {
            return this.h;
        }

        public void c(long j) {
            if (this.m != j) {
                this.m = j;
                this.j = true;
            }
        }

        public void c(String str) {
            if (str == this.k) {
                return;
            }
            if (str == null || !str.equals(this.k)) {
                this.k = str;
                this.j = true;
            }
        }

        public long d() {
            return this.m;
        }

        public boolean e() {
            String q = a.this.awa.q("aid.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.i = jSONObject.getLong("gen_ts");
                    this.h = jSONObject.getString("form_id");
                    this.g = jSONObject.getString("and_id");
                    this.k = jSONObject.optString("ran_id", null);
                    this.axN.R(jSONObject.getLong("flags"));
                    this.m = jSONObject.getLong("lst_conf_ver");
                    this.n = jSONObject.getInt("c_form_ver");
                    this.j = false;
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean f() {
            if (this.j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("and_id", this.g);
                    jSONObject.put("form_id", this.h);
                    jSONObject.put("gen_ts", this.i);
                    jSONObject.put("flags", this.axN.As());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.k)) {
                        jSONObject.put("ran_id", this.k);
                    }
                    if (this.f != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.m);
                    a.this.awa.d("aid.dat", jSONObject.toString(), true);
                    this.j = false;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }
    }

    public a() {
        super("aid");
        this.axL = new b();
    }

    public static String D(byte[] bArr) {
        return ad("A00", new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(bArr));
    }

    @Override // com.baidu.helios.ids.a
    public String AA() {
        return this.axL.c();
    }

    @Override // com.baidu.helios.ids.a
    public byte[] AB() {
        return this.axL.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        long j;
        boolean z;
        String str = null;
        boolean z2 = false;
        boolean z3 = true;
        this.awa = this.axE.fy("aid");
        this.axL.e();
        TrustSubject trustSubject = this.axF.axI.ayG;
        if (trustSubject != null) {
            j = trustSubject.AG();
            z = j != this.axL.d();
        } else {
            j = 0;
            z = false;
        }
        boolean z4 = TextUtils.isEmpty(this.axL.c()) || this.axL.a() == null || TextUtils.isEmpty(this.axL.b());
        if (z4 || z) {
            C0151a b2 = trustSubject != null ? C0151a.b(trustSubject) : null;
            try {
                str = Settings.Secure.getString(this.axF.applicationContext.getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(str)) {
                str = "000000000";
            }
            if (z4) {
                if (b2 != null && b2.a(str)) {
                    z2 = true;
                }
            } else if (b2 != null && this.axL.b(1L) == 0 && b2.b(str)) {
                z2 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                String str2 = "com.helios" + str;
                if (z2) {
                    String uuid = UUID.randomUUID().toString();
                    this.axL.c(uuid);
                    str2 = str2 + uuid;
                    this.axL.a(1L, 1L);
                }
                byte[] ac = f.ac(str2, "utf-8");
                String D = D(ac);
                this.axL.a(ac);
                this.axL.a(System.currentTimeMillis());
                this.axL.a(str);
                this.axL.b(D);
            }
            this.axL.c(j);
            this.axL.f();
        }
    }
}
