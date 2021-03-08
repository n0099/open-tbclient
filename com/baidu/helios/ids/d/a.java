package com.baidu.helios.ids.d;

import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0139a asY;
    private C0147a avk;

    /* renamed from: com.baidu.helios.ids.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0147a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e auU = new e();

        C0147a() {
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
            String p = a.this.asY.p("cache.dat", true);
            if (!TextUtils.isEmpty(p)) {
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("ssaid");
                    this.auU.O(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.auU.vh());
                    jSONObject.put("ssaid", this.g);
                    a.this.asY.c("cache.dat", jSONObject.toString(), true);
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
        this.avk = new C0147a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.asY = this.auy.eg(getName());
        String string = Settings.Secure.getString(this.auz.applicationContext.getContentResolver(), "android_id");
        if (string == null) {
            string = "0";
        }
        this.avk.d();
        if (TextUtils.isEmpty(this.avk.a()) || !TextUtils.equals(string, this.avk.b())) {
            this.avk.b(string);
            try {
                this.avk.a(com.baidu.helios.ids.a.aa("A30", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(string.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.avk.b(System.currentTimeMillis());
        }
        this.avk.e();
    }

    @Override // com.baidu.helios.ids.a
    public String vp() {
        return this.avk.a();
    }
}
