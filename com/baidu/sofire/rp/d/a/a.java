package com.baidu.sofire.rp.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.b;
import com.baidu.sofire.b.e;
import com.baidu.sofire.b.h;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    private Context a;

    public a(Context context) {
        this.a = context;
    }

    public boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        b.a("sj report data : " + str);
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(str2)) {
                str3 = "&topic=" + str2;
            }
            String str4 = e.e(this.a) + "p/1/r";
            b.a("sj-trigger report " + str4);
            String a = h.a(this.a, str4, str, false, true, str3);
            if (TextUtils.isEmpty(a)) {
                return false;
            }
            return new JSONObject(a).getInt("response") == 1;
        } catch (Throwable th) {
            e.a(th);
            return true;
        }
    }

    public void a() {
        try {
            String a = h.a(this.a, e.e(this.a) + "p/1/rs", false, true);
            b.a("response policy : " + a);
            JSONObject jSONObject = new JSONObject(a).getJSONObject("c");
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(this.a);
            int optInt = jSONObject.optInt("n");
            if (optInt > 0) {
                eVar.q(optInt);
            }
            int optInt2 = jSONObject.optInt("i");
            if (optInt2 > 0) {
                eVar.r(optInt2);
            }
            int optInt3 = jSONObject.optInt("i2");
            if (optInt3 > 0) {
                eVar.s(optInt3);
            }
            int optInt4 = jSONObject.optInt(Config.DEVICE_WIDTH);
            if (optInt4 > 0) {
                eVar.t(optInt4);
            }
            if (jSONObject.optInt("s1") > 0) {
                eVar.x(jSONObject.optInt("s1"));
            }
            int optInt5 = jSONObject.optInt(Config.SESSTION_TRACK_START_TIME);
            if (optInt5 > 0) {
                eVar.y(optInt5);
            }
            int optInt6 = jSONObject.optInt("t");
            if (optInt6 > 0) {
                eVar.u(optInt6);
            }
            int optInt7 = jSONObject.optInt("l1");
            if (optInt7 > 0) {
                eVar.w(optInt7);
            }
            int optInt8 = jSONObject.optInt("l2");
            if (optInt8 > 0) {
                eVar.v(optInt8);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }
}
