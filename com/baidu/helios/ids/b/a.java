package com.baidu.helios.ids.b;

import android.text.TextUtils;
import com.baidu.helios.common.b.a.b;
import com.baidu.helios.common.b.a.e;
import com.baidu.helios.common.c.a;
import com.baidu.helios.ids.a;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends com.baidu.helios.ids.a {
    a.C0153a awJ;
    private C0156a ayJ;

    /* renamed from: com.baidu.helios.ids.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    class C0156a {
        private long c;
        private String f;
        private String g;
        private int h;
        private boolean d = true;
        private e ayK = new e();

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
            String q = a.this.awJ.q("cache.dat", true);
            if (!TextUtils.isEmpty(q)) {
                try {
                    JSONObject jSONObject = new JSONObject(q);
                    this.f = jSONObject.optString("form_id");
                    this.c = jSONObject.getLong("lst_fe_ts");
                    this.h = jSONObject.getInt("c_form_ver");
                    this.g = jSONObject.getString("uuid");
                    this.ayK.R(jSONObject.getLong("flags"));
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
                    jSONObject.put("flags", this.ayK.AA());
                    jSONObject.put("uuid", this.g);
                    a.this.awJ.d("cache.dat", jSONObject.toString(), true);
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
        super("iid");
        this.ayJ = new C0156a();
    }

    @Override // com.baidu.helios.ids.a
    public String AI() {
        return this.ayJ.a();
    }

    @Override // com.baidu.helios.ids.a
    public void a(a.b bVar) {
        this.awJ = this.ayn.fD(getName());
        this.ayJ.d();
        if (TextUtils.isEmpty(this.ayJ.a())) {
            String uuid = UUID.randomUUID().toString();
            this.ayJ.b(uuid);
            try {
                this.ayJ.a(com.baidu.helios.ids.a.ag("A50", new b("ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=", false, false).encode(uuid.getBytes("UTF-8"))));
            } catch (Exception e) {
            }
            this.ayJ.b(System.currentTimeMillis());
        }
        this.ayJ.e();
    }
}
