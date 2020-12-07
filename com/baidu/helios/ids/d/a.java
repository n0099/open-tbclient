package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0149a avX;
    private C0157a ayp;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C0157a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e axY = new e();

        C0157a() {
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
            String p = a.this.avX.p("cache.dat", true);
            if (!TextUtils.isEmpty(p)) {
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.axY.P(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.axY.zL());
                    jSONObject.put("ssaid", this.g);
                    a.this.avX.d("cache.dat", jSONObject.toString(), true);
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
        this.ayp = new C0157a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.avX = this.axB.fB(getName());
        String string = Settings.Secure.getString(this.axC.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.ayp.d();
        if (TextUtils.isEmpty(this.ayp.a()) || !TextUtils.equals(string, this.ayp.b())) {
            this.ayp.b(string);
            try {
                this.ayp.a(com.baidu.helios.ids.a.af("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.ayp.b(System.currentTimeMillis());
        }
        this.ayp.e();
    }

    @Override // com.baidu.helios.ids.a
    public String zT() {
        return this.ayp.a();
    }
}
