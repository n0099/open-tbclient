package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0148a avw;
    private C0156a axO;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0156a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e axx = new e();

        C0156a() {
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
            String q = a.this.avw.q("cache.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.axx.S(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.axx.Ae());
                    jSONObject.put("ssaid", this.g);
                    a.this.avw.d("cache.dat", jSONObject.toString(), true);
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
        this.axO = new C0156a();
    }

    @Override // com.baidu.helios.ids.a
    public String Am() {
        return this.axO.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.avw = this.axa.fv(getName());
        String string = Settings.Secure.getString(this.axb.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.axO.d();
        if (TextUtils.isEmpty(this.axO.a()) || !TextUtils.equals(string, this.axO.b())) {
            this.axO.b(string);
            try {
                this.axO.a(com.baidu.helios.ids.a.ad("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.axO.b(System.currentTimeMillis());
        }
        this.axO.e();
    }
}
