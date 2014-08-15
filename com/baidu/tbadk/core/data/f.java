package com.baidu.tbadk.core.data;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.w;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {
    private boolean a;
    private int b;
    private int c;
    private int d;
    private int e = 20;
    private int f = 20;
    private int g = 10;

    public int a() {
        return this.e;
    }

    public int b() {
        return this.f;
    }

    public int c() {
        return this.g;
    }

    public boolean d() {
        return this.a;
    }

    public void a(boolean z) {
        if (this.a != z) {
            com.baidu.adp.lib.stats.q a = w.a();
            a.a("act", "fallback");
            a.a("result", z ? TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK : "0");
            a.a("type", "switch");
            com.baidu.adp.lib.stats.f.c().a("img", a);
        }
        this.a = z;
    }

    public int e() {
        return this.b;
    }

    public int f() {
        return this.c;
    }

    public int g() {
        return this.d;
    }

    public void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                a(new JSONObject(str));
            }
        } catch (Exception e) {
            this.a = false;
            BdLog.e(e.getMessage());
        }
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                if (jSONObject.optInt("switch") == 1) {
                    this.a = true;
                } else {
                    this.a = false;
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("err");
                if (optJSONObject != null) {
                    this.d = optJSONObject.optInt("num");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("slow");
                if (optJSONObject2 != null) {
                    this.c = optJSONObject2.optInt("time");
                    this.b = optJSONObject2.optInt("num");
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("rank");
                if (optJSONObject3 != null) {
                    this.e = optJSONObject3.optInt("succ");
                    this.f = optJSONObject3.optInt("err");
                    this.g = optJSONObject3.optInt("slow");
                }
                if (this.c <= 0 || this.b <= 0 || this.d <= 0) {
                    this.a = false;
                }
            } catch (Exception e) {
                this.a = false;
                BdLog.e(e.getMessage());
            }
        }
    }
}
