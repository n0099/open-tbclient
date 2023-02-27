package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchInfo {
    public String a;
    public String b;
    public String c;

    public String getPushContent() {
        if (!TextUtils.isEmpty(this.b)) {
            return this.b;
        }
        return "";
    }

    public String getPushLandingPage() {
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        return "";
    }

    public String getRefererPkgName() {
        if (!TextUtils.isEmpty(this.c)) {
            return this.c;
        }
        return "";
    }

    public static JSONObject getConvertedJson(int i, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (Exception unused) {
        }
        try {
            jSONObject.put("type", String.valueOf(i));
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
        String a = bi.a(context);
        if (TextUtils.isEmpty(a)) {
            return "";
        }
        return a;
    }

    public void setRefererPkgName(String str) {
        this.c = str;
    }

    public int getLaunchType(Context context) {
        String str;
        if (!TextUtils.isEmpty(this.a)) {
            return 2;
        }
        if (context != null) {
            str = context.getPackageName();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(this.c) && !this.c.equals(str)) {
            String a = bi.a(context);
            if (!TextUtils.isEmpty(a)) {
                if (!this.c.equals(a)) {
                    return 1;
                }
                return 0;
            } else if (!bi.a(context, this.c)) {
                return 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void setPushInfo(String str, String str2) {
        this.a = str;
        this.b = bx.a(str2, 1024);
    }
}
