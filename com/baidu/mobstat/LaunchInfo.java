package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8397a;

    /* renamed from: b  reason: collision with root package name */
    public String f8398b;

    /* renamed from: c  reason: collision with root package name */
    public String f8399c;

    public static JSONObject getConvertedJson(int i2, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", String.valueOf(i2));
            if (str == null) {
                str = "";
            }
            jSONObject.put(Config.LAUNCH_REFERER, str);
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("info", str2);
            jSONObject.put("content", "");
            return jSONObject;
        } catch (Exception unused2) {
            jSONObject2 = jSONObject;
            return jSONObject2;
        }
    }

    public static String getLauncherHomePkgName(Context context) {
        String a2 = bj.a(context);
        return !TextUtils.isEmpty(a2) ? a2 : "";
    }

    public int getLaunchType(Context context) {
        if (TextUtils.isEmpty(this.f8397a)) {
            String packageName = context != null ? context.getPackageName() : "";
            if (TextUtils.isEmpty(this.f8399c) || this.f8399c.equals(packageName)) {
                return 0;
            }
            String a2 = bj.a(context);
            return !TextUtils.isEmpty(a2) ? !this.f8399c.equals(a2) ? 1 : 0 : !bj.a(context, this.f8399c) ? 1 : 0;
        }
        return 2;
    }

    public String getPushContent() {
        return !TextUtils.isEmpty(this.f8398b) ? this.f8398b : "";
    }

    public String getPushLandingPage() {
        return !TextUtils.isEmpty(this.f8397a) ? this.f8397a : "";
    }

    public String getRefererPkgName() {
        return !TextUtils.isEmpty(this.f8399c) ? this.f8399c : "";
    }

    public void setPushInfo(String str, String str2) {
        this.f8397a = str;
        this.f8398b = bx.a(str2, 1024);
    }

    public void setRefererPkgName(String str) {
        this.f8399c = str;
    }
}
