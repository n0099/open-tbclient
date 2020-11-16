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
/* loaded from: classes8.dex */
public class a extends com.baidu.helios.ids.a {
    private a.C0151a auZ;
    private b awK;

    /* renamed from: com.baidu.helios.ids.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    static class C0153a {
        private HashSet<String> awL = new HashSet<>();
        private HashSet<String> e = new HashSet<>();

        C0153a() {
        }

        public static C0153a b(TrustSubject trustSubject) {
            try {
                String fz = trustSubject.fz("config-aid");
                if (!TextUtils.isEmpty(fz)) {
                    try {
                        C0153a c0153a = new C0153a();
                        JSONObject jSONObject = new JSONObject(fz);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                c0153a.awL.add(optJSONArray.getString(i));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                c0153a.e.add(optJSONArray2.getString(i2));
                            }
                            return c0153a;
                        }
                        return c0153a;
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
            return this.awL.contains(str);
        }

        public boolean b(String str) {
            return this.e.contains(str);
        }
    }

    /* loaded from: classes8.dex */
    class b {
        private byte[] f;
        private String g;
        private String h;
        private long i;
        private String k;
        private long m;
        private int n;
        private boolean j = true;
        private e awM = new e();

        b() {
        }

        public void a(long j) {
            if (j != this.i) {
                this.i = j;
                this.j = true;
            }
        }

        public void a(long j, long j2) {
            if (this.awM.d(j, j2)) {
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
            return this.awM.S(j);
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
            String q = a.this.auZ.q("aid.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.i = jSONObject.getLong("gen_ts");
                    this.h = jSONObject.getString("form_id");
                    this.g = jSONObject.getString("and_id");
                    this.k = jSONObject.optString("ran_id", null);
                    this.awM.R(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.awM.zR());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.k)) {
                        jSONObject.put("ran_id", this.k);
                    }
                    if (this.f != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.m);
                    a.this.auZ.d("aid.dat", jSONObject.toString(), true);
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
        this.awK = new b();
    }

    public static String D(byte[] bArr) {
        return af("A00", new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(bArr));
    }

    @Override // com.baidu.helios.ids.a
    public byte[] Aa() {
        return this.awK.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        long j;
        boolean z;
        String str = null;
        boolean z2 = false;
        boolean z3 = true;
        this.auZ = this.awD.fx("aid");
        this.awK.e();
        TrustSubject trustSubject = this.awE.awH.axF;
        if (trustSubject != null) {
            j = trustSubject.Af();
            z = j != this.awK.d();
        } else {
            j = 0;
            z = false;
        }
        boolean z4 = TextUtils.isEmpty(this.awK.c()) || this.awK.a() == null || TextUtils.isEmpty(this.awK.b());
        if (z4 || z) {
            C0153a b2 = trustSubject != null ? C0153a.b(trustSubject) : null;
            try {
                str = Settings.Secure.getString(this.awE.applicationContext.getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(str)) {
                str = "000000000";
            }
            if (z4) {
                if (b2 != null && b2.a(str)) {
                    z2 = true;
                }
            } else if (b2 != null && this.awK.b(1L) == 0 && b2.b(str)) {
                z2 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                String str2 = "com.helios" + str;
                if (z2) {
                    String uuid = UUID.randomUUID().toString();
                    this.awK.c(uuid);
                    str2 = str2 + uuid;
                    this.awK.a(1L, 1L);
                }
                byte[] ad = f.ad(str2, "utf-8");
                String D = D(ad);
                this.awK.a(ad);
                this.awK.a(System.currentTimeMillis());
                this.awK.a(str);
                this.awK.b(D);
            }
            this.awK.c(j);
            this.awK.f();
        }
    }

    @Override // com.baidu.helios.ids.a
    public String zZ() {
        return this.awK.c();
    }
}
