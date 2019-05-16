package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.bt;
import com.baidu.sapi2.passhost.pluginsdk.service.ISapiAccount;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class CooperService implements ICooperService {
    private static CooperService a;
    private HeadObject b = new HeadObject();

    public static synchronized CooperService instance() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (a == null) {
                a = new CooperService();
            }
            cooperService = a;
        }
        return cooperService;
    }

    public HeadObject getHeadObject() {
        return this.b;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    @Override // com.baidu.mobstat.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        this.b.installHeader(context, jSONObject);
    }

    public JSONObject getHeaderExt(Context context) {
        String headerExt = BasicStoreTools.getInstance().getHeaderExt(context);
        if (TextUtils.isEmpty(headerExt)) {
            return null;
        }
        try {
            return new JSONObject(headerExt);
        } catch (JSONException e) {
            return null;
        }
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.b.setHeaderExt(jSONObject);
        BasicStoreTools.getInstance().setHeaderExt(context, jSONObject.toString());
        if (extraInfo != null) {
            str = "Set global ExtraInfo: " + jSONObject;
        } else {
            str = "Clear global ExtraInfo";
        }
        bj.c().a(str);
    }

    public JSONObject getPushId(Context context) {
        String pushId = BasicStoreTools.getInstance().getPushId(context);
        if (TextUtils.isEmpty(pushId)) {
            return null;
        }
        try {
            return new JSONObject(pushId);
        } catch (JSONException e) {
            return null;
        }
    }

    public void setPushId(Context context, String str, String str2, String str3) {
        String str4;
        JSONObject pushId = getPushId(context);
        if (pushId == null) {
            pushId = new JSONObject();
        }
        try {
            if (!TextUtils.isEmpty(str3)) {
                pushId.put(str, str3);
            } else {
                pushId.remove(str);
            }
        } catch (Exception e) {
        }
        this.b.setPushInfo(pushId);
        BasicStoreTools.getInstance().setPushId(context, pushId.toString());
        if (str3 != null) {
            str4 = "Set platform:" + str2 + " pushId: " + str3;
        } else {
            str4 = "Clear platform:" + str2 + " pushId";
        }
        bj.c().a(str4);
    }

    private static String a(Context context) {
        String l = cc.l(context);
        if (!TextUtils.isEmpty(l)) {
            return l.replaceAll(":", "");
        }
        return l;
    }

    private static String b(Context context) {
        String k = cc.k(context);
        if (!TextUtils.isEmpty(k)) {
            return k.replaceAll(":", "");
        }
        return k;
    }

    private static String c(Context context) {
        String n = cc.n(context);
        if (!TextUtils.isEmpty(n)) {
            return n.replaceAll(":", "");
        }
        return n;
    }

    public String getMacAddress(Context context, boolean z) {
        String replace = Config.DEF_MAC_ID.replace(":", "");
        if (!z && Build.VERSION.SDK_INT >= 23) {
            return getSecretValue(replace);
        }
        if (!TextUtils.isEmpty(this.b.s)) {
            return this.b.s;
        }
        String appDeviceMac = BasicStoreTools.getInstance().getAppDeviceMac(context);
        if (!TextUtils.isEmpty(appDeviceMac)) {
            this.b.s = appDeviceMac;
            return this.b.s;
        }
        String a2 = a(context, z);
        if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
            this.b.s = getSecretValue(a2);
            BasicStoreTools.getInstance().setAppDeviceMac(context, this.b.s);
            return this.b.s;
        }
        this.b.s = "";
        return this.b.s;
    }

    private String a(Context context, boolean z) {
        String a2;
        if (z) {
            a2 = b(context);
        } else {
            a2 = a(context);
        }
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        return a2;
    }

    public String getMacIdForTv(Context context) {
        if (!TextUtils.isEmpty(this.b.t)) {
            return this.b.t;
        }
        String appDeviceMacTv = BasicStoreTools.getInstance().getAppDeviceMacTv(context);
        if (!TextUtils.isEmpty(appDeviceMacTv)) {
            this.b.t = appDeviceMacTv;
            return this.b.t;
        }
        String c = cc.c(1, context);
        if (!TextUtils.isEmpty(c)) {
            this.b.t = c;
            BasicStoreTools.getInstance().setAppDeviceMacTv(context, c);
            return this.b.t;
        }
        this.b.t = "";
        return this.b.t;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        if (this.b.f == null) {
            this.b.f = BasicStoreTools.getInstance().getGenerateDeviceCUID(context);
            if (this.b.f == null || "".equalsIgnoreCase(this.b.f)) {
                try {
                    this.b.f = cd.a(context);
                    Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.f);
                    this.b.f = matcher.replaceAll("");
                    this.b.f = getSecretValue(this.b.f);
                    BasicStoreTools.getInstance().setGenerateDeviceCUID(context, this.b.f);
                } catch (Exception e) {
                }
            }
        }
        if (z) {
            return this.b.f;
        }
        try {
            String str = this.b.f;
            if (!TextUtils.isEmpty(str)) {
                return new String(bt.b.b(1, bw.a(str.getBytes())));
            }
        } catch (Exception e2) {
        }
        return null;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getTagValue() {
        return 1;
    }

    public String getDevicImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(ISapiAccount.SAPI_ACCOUNT_PHONE)).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        String str = this.b.i;
        if (!TextUtils.isEmpty(str)) {
            return this.b.i;
        }
        if (BasicStoreTools.getInstance().getForTV(context)) {
            this.b.i = getMacIdForTv(context);
            return this.b.i;
        } else if (telephonyManager == null) {
            return this.b.i;
        } else {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    str = compile.matcher(deviceId).replaceAll("");
                }
            } catch (Exception e) {
            }
            if (str == null || str.equals(Config.NULL_DEVICE_ID)) {
                str = a(context);
            }
            if (cc.w(context) && (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID))) {
                try {
                    str = c(context);
                } catch (Exception e2) {
                }
            }
            if (TextUtils.isEmpty(str) || str.equals(Config.NULL_DEVICE_ID)) {
                str = d(context);
            }
            this.b.i = str;
            this.b.i = getSecretValue(this.b.i);
            return this.b.i;
        }
    }

    private String d(Context context) {
        String generateDeviceId = BasicStoreTools.getInstance().getGenerateDeviceId(context);
        if (TextUtils.isEmpty(generateDeviceId) || generateDeviceId.equals(Config.NULL_DEVICE_ID)) {
            String str = "hol" + (new Date().getTime() + "").hashCode() + "mes";
            BasicStoreTools.getInstance().setGenerateDeviceId(context, str);
            return str;
        }
        return generateDeviceId;
    }

    public String getPlainDeviceIdForCar(Context context) {
        String optUUID = CarUUID.optUUID(context);
        if (TextUtils.isEmpty(optUUID)) {
            optUUID = d(context);
        }
        return TextUtils.isEmpty(optUUID) ? "" : optUUID;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppChannel(Context context) {
        return e(context);
    }

    private String e(Context context) {
        try {
            if (this.b.l == null || this.b.l.equals("")) {
                boolean appChannelWithCode = BasicStoreTools.getInstance().getAppChannelWithCode(context);
                if (appChannelWithCode) {
                    this.b.l = BasicStoreTools.getInstance().getAppChannelWithPreference(context);
                }
                if (!appChannelWithCode || this.b.l == null || this.b.l.equals("")) {
                    this.b.l = cc.a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Exception e) {
        }
        return this.b.l;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        if (this.b.e == null) {
            this.b.e = cc.a(context, Config.APPKEY_META_NAME);
        }
        return this.b.e;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        return "3.9.2.0";
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        if (this.b.g == -1) {
            this.b.g = cc.f(context);
        }
        return this.b.g;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.b.h)) {
            this.b.h = cc.g(context);
        }
        return this.b.h;
    }

    public void setAppVersionName(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.h = str;
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.b.m)) {
            this.b.m = telephonyManager.getNetworkOperator();
        }
        return this.b.m;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.b.r)) {
            this.b.r = cc.r(context);
        }
        return this.b.r;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOSVersion() {
        if (TextUtils.isEmpty(this.b.b)) {
            this.b.b = Integer.toString(Build.VERSION.SDK_INT);
        }
        return this.b.b;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.b.c)) {
            this.b.c = Build.VERSION.RELEASE;
        }
        return this.b.c;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.b.n)) {
            this.b.n = android.os.Build.MODEL;
        }
        return this.b.n;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.b.o)) {
            this.b.o = android.os.Build.MANUFACTURER;
        }
        return this.b.o;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase(cc.a(context, Config.GET_WIFI_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(cc.a(context, Config.GET_GPS_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(cc.a(context, Config.GET_CELL_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getSecretValue(String str) {
        return bt.b.c(1, str.getBytes());
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public void resetHeadSign() {
        this.b.z = instance().getUUID();
    }

    public void enableDeviceMac(Context context, boolean z) {
        BasicStoreTools.getInstance().setMacEnabledTrick(context, z);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return BasicStoreTools.getInstance().getMacEnabledTrick(context);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        BasicStoreTools.getInstance().setUserId(context, str);
        this.b.setUserId(str);
        bj.c().a("Set user id " + str);
    }

    public String getUserId(Context context) {
        return BasicStoreTools.getInstance().getUserId(context);
    }
}
