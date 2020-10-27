package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0153a awK;
    private C0161a azc;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0161a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e ayL = new e();

        C0161a() {
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
            String q = a.this.awK.q("cache.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.ayL.R(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.ayL.AA());
                    jSONObject.put("ssaid", this.g);
                    a.this.awK.d("cache.dat", jSONObject.toString(), true);
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
        this.azc = new C0161a();
    }

    @Override // com.baidu.helios.ids.a
    public String AI() {
        return this.azc.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.awK = this.ayo.fD(getName());
        String string = Settings.Secure.getString(this.ayp.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.azc.d();
        if (TextUtils.isEmpty(this.azc.a()) || !TextUtils.equals(string, this.azc.b())) {
            this.azc.b(string);
            try {
                this.azc.a(com.baidu.helios.ids.a.ag("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.azc.b(System.currentTimeMillis());
        }
        this.azc.e();
    }
}
