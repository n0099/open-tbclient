package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes23.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0149a awa;
    private C0157a ays;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    class C0157a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e ayb = new e();

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
            String q = a.this.awa.q("cache.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.ayb.R(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.ayb.As());
                    jSONObject.put("ssaid", this.g);
                    a.this.awa.d("cache.dat", jSONObject.toString(), true);
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
        this.ays = new C0157a();
    }

    @Override // com.baidu.helios.ids.a
    public String AA() {
        return this.ays.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.awa = this.axE.fy(getName());
        String string = Settings.Secure.getString(this.axF.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.ays.d();
        if (TextUtils.isEmpty(this.ays.a()) || !TextUtils.equals(string, this.ays.b())) {
            this.ays.b(string);
            try {
                this.ays.a(com.baidu.helios.ids.a.ad("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.ays.b(System.currentTimeMillis());
        }
        this.ays.e();
    }
}
