package com.baidu.mobstat;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LaunchInfo {

    /* renamed from: a  reason: collision with root package name */
    public String f8810a;

    /* renamed from: b  reason: collision with root package name */
    public String f8811b;

    /* renamed from: c  reason: collision with root package name */
    public String f8812c;

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
        String a2 = bj.a(context);
        return !TextUtils.isEmpty(a2) ? a2 : "";
    }

    public int getLaunchType(Context context) {
        if (TextUtils.isEmpty(this.f8810a)) {
            String packageName = context != null ? context.getPackageName() : "";
            if (TextUtils.isEmpty(this.f8812c) || this.f8812c.equals(packageName)) {
                return 0;
            }
            String a2 = bj.a(context);
            return !TextUtils.isEmpty(a2) ? !this.f8812c.equals(a2) ? 1 : 0 : !bj.a(context, this.f8812c) ? 1 : 0;
        }
        return 2;
    }

    public String getPushContent() {
        return !TextUtils.isEmpty(this.f8811b) ? this.f8811b : "";
    }

    public String getPushLandingPage() {
        return !TextUtils.isEmpty(this.f8810a) ? this.f8810a : "";
    }

    public String getRefererPkgName() {
        return !TextUtils.isEmpty(this.f8812c) ? this.f8812c : "";
    }

    public void setPushInfo(String str, String str2) {
        this.f8810a = str;
        this.f8811b = bx.a(str2, 1024);
    }

    public void setRefererPkgName(String str) {
        this.f8812c = str;
    }
}
