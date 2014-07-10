package com.baidu.kirin.c;

import android.content.Context;
import com.baidu.kirin.KirinConfig;
import com.baidu.kirin.d.d;
import com.baidu.kirin.d.e;
import com.baidu.kirin.d.g;
import com.baidu.mobstat.CooperService;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {
    protected Context a;
    protected String b;
    protected String c;
    protected JSONObject d;
    protected JSONObject e;
    protected boolean f;
    private int g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        this.a = context;
        this.b = KirinConfig.PREURL + str;
        d.a("PostUrl: " + this.b);
        this.d = new JSONObject();
        try {
            this.d.put("appkey", com.baidu.kirin.a.a.b(this.a));
            this.d.put("version_code", com.baidu.kirin.a.a.d(this.a));
            this.d.put("version_name", com.baidu.kirin.a.a.c(this.a));
            this.d.put("deviceid", com.baidu.kirin.a.a.h(context));
            this.d.put("channel", com.baidu.kirin.a.a.a(context));
            this.d.put("sdk_version", CooperService.getMTJSDKVersion());
            this.d.put("sdk_tag", "mtj");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        b();
    }

    public JSONObject a() {
        return this.d;
    }

    public void a(String str, Object obj) {
        try {
            this.d.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void b() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject c() {
        Exception e;
        e eVar;
        if (com.baidu.kirin.a.a.p(this.a)) {
            try {
                d.a(this.c + " send Content is:" + this.d.toString());
                eVar = g.a(this.b, com.baidu.kirin.d.a.a(this.d.toString()));
            } catch (Exception e2) {
                e = e2;
                eVar = null;
            }
            try {
                this.g = eVar.a();
                if (!eVar.b()) {
                    d.c(this.c + " : " + eVar.c());
                    this.f = false;
                } else if (this.g != 0) {
                    d.c(this.c + "Backend return Code is not zeror, is : " + this.g);
                    this.f = false;
                    this.e = eVar.d();
                    f();
                    return this.e;
                } else {
                    d.a(this.c + " : " + eVar.c());
                    this.f = true;
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                d.c("Fuck, " + this.c + " post Exception!");
                this.f = false;
                if (this.f) {
                }
            }
        } else {
            this.f = false;
            d.a("network has sth wrong!");
            eVar = null;
        }
        if (this.f) {
            f();
            return null;
        }
        this.e = eVar.d();
        e();
        return this.e;
    }

    public int d() {
        return this.g;
    }

    protected void e() {
    }

    protected void f() {
    }
}
