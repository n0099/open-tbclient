package com.baidu.kirin.c;

import android.content.Context;
import android.location.LocationManager;
import com.baidu.kirin.KirinConfig;
import com.baidu.kirin.d.d;
import com.baidu.kirin.d.f;
import com.baidu.mobstat.CooperService;
import com.baidu.tbadk.TbConfig;
import java.io.IOException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends a {
    private String g;
    private JSONObject h;
    private JSONObject i;
    private JSONObject j;
    private boolean k;

    public b(Context context, String str) {
        super(context, str);
        this.c = getClass().getName();
    }

    private JSONObject a(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkey", com.baidu.kirin.a.a.b(context));
            jSONObject.put("channel", com.baidu.kirin.a.a.a(this.a));
            jSONObject.put("os_version", com.baidu.kirin.a.a.e(context));
            jSONObject.put("manufacturer", com.baidu.kirin.a.a.g(context));
            jSONObject.put("phone_type", com.baidu.kirin.a.a.j(context));
            jSONObject.put("deviceid", com.baidu.kirin.a.a.h(context));
            jSONObject.put("imei", com.baidu.kirin.a.a.l(context));
            jSONObject.put("resolution", com.baidu.kirin.a.a.n(context));
            jSONObject.put("platform", "android");
            jSONObject.put("is_mobile_device", true);
            jSONObject.put("language", Locale.getDefault().getLanguage());
            jSONObject.put("modulename", CooperService.getPhoneModel());
            jSONObject.put("wifimac", com.baidu.kirin.a.a.i(context));
            jSONObject.put("havegps", locationManager != null);
            jSONObject.put("os_sdk", com.baidu.kirin.a.a.f(context));
            jSONObject.put("tg", CooperService.getTagValue());
            jSONObject.put("cuid", com.baidu.kirin.a.a.k(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
        d.a("Satic Data : " + jSONObject.toString());
        return jSONObject;
    }

    private JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", com.baidu.kirin.a.a.a());
            jSONObject.put("version_name", com.baidu.kirin.a.a.c(context));
            jSONObject.put("version_code", com.baidu.kirin.a.a.d(context));
            jSONObject.put("network_type", com.baidu.kirin.a.a.m(context));
            jSONObject.put("latlongitude", com.baidu.kirin.a.a.a(context, CooperService.checkGPSLocationSetting(context)));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        d.a("Dyna Data : " + jSONObject.toString());
        return jSONObject;
    }

    private boolean g() {
        this.g = KirinConfig.CLIENT_STATIC_DATA_FILE + this.a.getPackageName();
        this.i = com.baidu.kirin.d.b.a(this.a, this.g);
        if (this.i != null) {
            this.h = a(this.a);
            return !f.a(com.baidu.kirin.d.c.a(this.i.toString())).equals(f.a(com.baidu.kirin.d.c.a(this.h.toString())));
        }
        d.a("Static file is empty, need collect static data!");
        this.h = a(this.a);
        return true;
    }

    @Override // com.baidu.kirin.c.a
    protected void b() {
        this.k = g();
        try {
            this.j = b(this.a);
            this.d = com.baidu.kirin.d.c.a(this.d, this.h);
            this.d = com.baidu.kirin.d.c.a(this.d, this.j);
            if (this.k) {
                d.a("send new static data!");
                this.d.put("isUpdateClientData", TbConfig.ST_PARAM_TAB_MSG_PERSONAL_CHAT_CLICK);
            } else {
                d.a("send cache static data!");
                this.d.put("isUpdateClientData", "0");
            }
        } catch (Exception e) {
            d.a("what's going on?? : " + e.toString());
            e.printStackTrace();
        }
    }

    @Override // com.baidu.kirin.c.a
    protected void e() {
        d.a("isInfoChanged : " + this.k + "  dump static data after success!!");
        if (this.k) {
            try {
                com.baidu.kirin.d.b.a(this.a, this.g, this.h);
            } catch (IOException e) {
                d.c("Dump static file has exception!!");
                e.printStackTrace();
            }
        }
        try {
            com.baidu.kirin.b.a.a(this.a).a(true, new JSONObject(this.e.getString("updateConfig")));
            com.baidu.kirin.b.a.a(this.a).b(this.e.getString("logID"));
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.baidu.kirin.b.a.a(this.a).a(false, (JSONObject) null);
            com.baidu.kirin.b.a.a(this.a).b("0");
        }
    }

    @Override // com.baidu.kirin.c.a
    protected void f() {
        if (com.baidu.kirin.a.a.p(this.a)) {
            com.baidu.kirin.b.a.a(this.a).a(false, (JSONObject) null);
        }
    }
}
