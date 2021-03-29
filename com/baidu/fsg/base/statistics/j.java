package com.baidu.fsg.base.statistics;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.beans.business.core.utils.NetUtils;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.PhoneUtils;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5315a = "cu";

    /* renamed from: b  reason: collision with root package name */
    public static final String f5316b = "cu2";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5317c = "ua";

    /* renamed from: d  reason: collision with root package name */
    public static final String f5318d = "op";

    /* renamed from: e  reason: collision with root package name */
    public static final String f5319e = "bs";

    /* renamed from: f  reason: collision with root package name */
    public static final String f5320f = "bk";

    /* renamed from: g  reason: collision with root package name */
    public static final String f5321g = "lc";

    /* renamed from: h  reason: collision with root package name */
    public static final String f5322h = "sd";
    public static final String i = "j";
    public Pattern j;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static j f5323a = new j();
    }

    public static j c() {
        return a.f5323a;
    }

    private String d(Context context) {
        String str;
        try {
            try {
                return this.j.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    private String e(Context context) {
        try {
            return BussinessUtils.getUA(context);
        } catch (Exception unused) {
            return null;
        }
    }

    private String f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return null;
        }
    }

    private String g(Context context) {
        return null;
    }

    private String h(Context context) {
        return RimArmor.getInstance().getpwProxy();
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ua", e(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("cu", c(RimStatisticsUtil.getAppContext()));
            jSONObject.put("cu2", d(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("op", f(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("bs", g(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("bk", h(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("sd", b(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("lc", a(RimStatisticsUtil.getAppContext()));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String b() {
        try {
            return new JSONObject().toString();
        } catch (Throwable th) {
            LogUtil.d(i, th.toString());
            return null;
        }
    }

    public j() {
        this.j = Pattern.compile("\\s*|\t|\r|\n");
    }

    private String c(Context context) {
        String str;
        try {
            try {
                return this.j.matcher(PhoneUtils.getCUID(context)).replaceAll("");
            } catch (Exception unused) {
                return str;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public String b(Context context) {
        JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
        if (connectedWifi != null) {
            String optString = connectedWifi.optString("ssid", null);
            return optString != null ? RimArmor.getInstance().encryptProxy(optString) : optString;
        }
        return null;
    }

    public String a(Context context) {
        String gPSLocation = PhoneUtils.getGPSLocation(context);
        if (TextUtils.isEmpty(gPSLocation)) {
            return null;
        }
        return RimArmor.getInstance().encryptProxy(gPSLocation);
    }
}
