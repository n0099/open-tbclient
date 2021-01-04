package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class LaunchInfo {

    /* renamed from: a  reason: collision with root package name */
    private String f3640a;

    /* renamed from: b  reason: collision with root package name */
    private String f3641b;
    private String c;

    public String getPushLandingPage() {
        if (TextUtils.isEmpty(this.f3640a)) {
            return "";
        }
        return this.f3640a;
    }

    public String getPushContent() {
        if (TextUtils.isEmpty(this.f3641b)) {
            return "";
        }
        return this.f3641b;
    }

    public String getRefererPkgName() {
        if (TextUtils.isEmpty(this.c)) {
            return "";
        }
        return this.c;
    }

    public void setPushInfo(String str, String str2) {
        this.f3640a = str;
        this.f3641b = bx.a(str2, 1024);
    }

    public void setRefererPkgName(String str) {
        this.c = str;
    }

    public int getLaunchType(Context context) {
        if (!TextUtils.isEmpty(this.f3640a)) {
            return 2;
        }
        String str = "";
        if (context != null) {
            str = context.getPackageName();
        }
        if (!TextUtils.isEmpty(this.c) && !this.c.equals(str)) {
            String a2 = bj.a(context);
            if (!TextUtils.isEmpty(a2)) {
                if (!this.c.equals(a2)) {
                    return 1;
                }
            } else if (!bj.a(context, this.c)) {
                return 1;
            }
        }
        return 0;
    }

    public static JSONObject getConvertedJson(int i, String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
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
            } catch (Exception e) {
                return jSONObject;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public static String getLauncherHomePkgName(Context context) {
        String a2 = bj.a(context);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }
}
