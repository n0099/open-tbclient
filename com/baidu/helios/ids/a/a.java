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
/* loaded from: classes6.dex */
public class a extends com.baidu.helios.ids.a {
    private a.C0141a apk;
    private b aqW;

    /* renamed from: com.baidu.helios.ids.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    static class C0143a {
        private HashSet<String> aqX = new HashSet<>();
        private HashSet<String> e = new HashSet<>();

        C0143a() {
        }

        public static C0143a b(TrustSubject trustSubject) {
            try {
                String ed = trustSubject.ed("config-aid");
                if (!TextUtils.isEmpty(ed)) {
                    try {
                        C0143a c0143a = new C0143a();
                        JSONObject jSONObject = new JSONObject(ed);
                        JSONArray optJSONArray = jSONObject.optJSONArray("blist");
                        if (optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i = 0; i < length; i++) {
                                c0143a.aqX.add(optJSONArray.getString(i));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("reset_blist");
                        if (optJSONArray2 != null) {
                            int length2 = optJSONArray2.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                c0143a.e.add(optJSONArray2.getString(i2));
                            }
                            return c0143a;
                        }
                        return c0143a;
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
            return this.aqX.contains(str);
        }

        public boolean b(String str) {
            return this.e.contains(str);
        }
    }

    /* loaded from: classes6.dex */
    class b {
        private byte[] f;
        private String g;
        private String h;
        private long i;
        private String k;
        private long m;
        private int n;
        private boolean j = true;
        private e aqY = new e();

        b() {
        }

        public void a(long j) {
            if (j != this.i) {
                this.i = j;
                this.j = true;
            }
        }

        public void a(long j, long j2) {
            if (this.aqY.d(j, j2)) {
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
            return this.aqY.S(j);
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
            String q = a.this.apk.q("aid.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = Base64.decode(jSONObject.getString("raw_id"), 2);
                    this.i = jSONObject.getLong("gen_ts");
                    this.h = jSONObject.getString("form_id");
                    this.g = jSONObject.getString("and_id");
                    this.k = jSONObject.optString("ran_id", null);
                    this.aqY.R(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.aqY.up());
                    jSONObject.put("c_form_ver", 1);
                    if (!TextUtils.isEmpty(this.k)) {
                        jSONObject.put("ran_id", this.k);
                    }
                    if (this.f != null) {
                        jSONObject.put("raw_id", Base64.encodeToString(this.f, 2));
                    }
                    jSONObject.put("lst_conf_ver", this.m);
                    a.this.apk.d("aid.dat", jSONObject.toString(), true);
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
        this.aqW = new b();
    }

    public static String A(byte[] bArr) {
        return aa("A00", new com.baidu.helios.common.b.a.b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(bArr));
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        long j;
        boolean z;
        String str = null;
        boolean z2 = false;
        boolean z3 = true;
        this.apk = this.aqP.eb("aid");
        this.aqW.e();
        TrustSubject trustSubject = this.aqQ.aqT.arR;
        if (trustSubject != null) {
            j = trustSubject.uD();
            z = j != this.aqW.d();
        } else {
            j = 0;
            z = false;
        }
        boolean z4 = TextUtils.isEmpty(this.aqW.c()) || this.aqW.a() == null || TextUtils.isEmpty(this.aqW.b());
        if (z4 || z) {
            C0143a b2 = trustSubject != null ? C0143a.b(trustSubject) : null;
            try {
                str = Settings.Secure.getString(this.aqQ.applicationContext.getContentResolver(), "android_id");
            } catch (Throwable th) {
            }
            if (TextUtils.isEmpty(str)) {
                str = "000000000";
            }
            if (z4) {
                if (b2 != null && b2.a(str)) {
                    z2 = true;
                }
            } else if (b2 != null && this.aqW.b(1L) == 0 && b2.b(str)) {
                z2 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                String str2 = "com.helios" + str;
                if (z2) {
                    String uuid = UUID.randomUUID().toString();
                    this.aqW.c(uuid);
                    str2 = str2 + uuid;
                    this.aqW.a(1L, 1L);
                }
                byte[] Z = f.Z(str2, "utf-8");
                String A = A(Z);
                this.aqW.a(Z);
                this.aqW.a(System.currentTimeMillis());
                this.aqW.a(str);
                this.aqW.b(A);
            }
            this.aqW.c(j);
            this.aqW.f();
        }
    }

    @Override // com.baidu.helios.ids.a
    public String ux() {
        return this.aqW.c();
    }

    @Override // com.baidu.helios.ids.a
    public byte[] uy() {
        return this.aqW.a();
    }
}
