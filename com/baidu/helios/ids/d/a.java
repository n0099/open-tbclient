package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes18.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0141a aqz;
    private C0149a asT;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    class C0149a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e asB = new e();

        C0149a() {
        }

        public String a() {
            return this.f;
        }

        public void a(String str) {
            if (this.f == str) {
                return;
            }
            if (str == null || !str.equals(this.f)) {
                this.f = str;
                this.d = true;
            }
        }

        public String b() {
            return this.g;
        }

        public void b(long j) {
            if (this.c != j) {
                this.c = j;
                this.d = true;
            }
        }

        public void b(String str) {
            if (this.g == str) {
                return;
            }
            if (str == null || !str.equals(this.g)) {
                this.g = str;
                this.d = true;
            }
        }

        public boolean d() {
            String q = a.this.aqz.q("cache.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.asB.R(jSONObject.getLong("flags"));
                    return true;
                } catch (Exception e) {
                }
            }
            return false;
        }

        public boolean e() {
            if (this.d) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("form_id", this.f);
                    jSONObject.put("lst_fe_ts", this.c);
                    jSONObject.put("c_form_ver", 1);
                    jSONObject.put("flags", this.asB.uH());
                    jSONObject.put("ssaid", this.g);
                    a.this.aqz.d("cache.dat", jSONObject.toString(), true);
                    this.d = false;
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        }
    }

    public a() {
        super("ssaid");
        this.asT = new C0149a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.aqz = this.asd.ec(getName());
        String string = Settings.Secure.getString(this.ase.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.asT.d();
        if (TextUtils.isEmpty(this.asT.a()) || !TextUtils.equals(string, this.asT.b())) {
            this.asT.b(string);
            try {
                this.asT.a(com.baidu.helios.ids.a.Z("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.asT.b(System.currentTimeMillis());
        }
        this.asT.e();
    }

    @Override // com.baidu.helios.ids.a
    public String uP() {
        return this.asT.a();
    }
}
