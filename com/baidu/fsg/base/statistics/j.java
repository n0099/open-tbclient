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
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2000a = "cu";

    /* renamed from: b  reason: collision with root package name */
    public static final String f2001b = "cu2";
    public static final String c = "ua";
    public static final String d = "op";
    public static final String e = "bs";
    public static final String f = "bk";
    public static final String g = "lc";
    public static final String h = "sd";
    private static final String i = j.class.getSimpleName();
    private Pattern j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static j f2002a = new j();

        private a() {
        }
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(c, e(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt(f2000a, c(RimStatisticsUtil.getAppContext()));
            jSONObject.put(f2001b, d(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("op", f(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("bs", g(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt(f, h(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt("sd", b(RimStatisticsUtil.getAppContext()));
            jSONObject.putOpt(g, a(RimStatisticsUtil.getAppContext()));
        } catch (JSONException e2) {
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

    private j() {
        this.j = Pattern.compile("\\s*|\t|\r|\n");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j c() {
        return a.f2002a;
    }

    private String c(Context context) {
        try {
            return this.j.matcher(PhoneUtils.getCUID(context)).replaceAll("");
        } catch (Exception e2) {
            return null;
        }
    }

    private String d(Context context) {
        try {
            return this.j.matcher(PhoneUtils.getCUID2(context)).replaceAll("");
        } catch (Exception e2) {
            return null;
        }
    }

    private String e(Context context) {
        try {
            return BussinessUtils.getUA(context);
        } catch (Exception e2) {
            return null;
        }
    }

    private String f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception e2) {
            return null;
        }
    }

    private String g(Context context) {
        return null;
    }

    private String h(Context context) {
        return RimArmor.getInstance().getpwProxy();
    }

    String a(Context context) {
        String gPSLocation = PhoneUtils.getGPSLocation(context);
        if (TextUtils.isEmpty(gPSLocation)) {
            return null;
        }
        return RimArmor.getInstance().encryptProxy(gPSLocation);
    }

    String b(Context context) {
        JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
        if (connectedWifi != null) {
            String optString = connectedWifi.optString("ssid", null);
            if (optString != null) {
                return RimArmor.getInstance().encryptProxy(optString);
            }
            return optString;
        }
        return null;
    }
}
