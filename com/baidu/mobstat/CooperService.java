package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CooperService implements ICooperService {

    /* renamed from: a  reason: collision with root package name */
    private static CooperService f2541a;
    private HeadObject b = new HeadObject();

    public static synchronized CooperService instance() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f2541a == null) {
                f2541a = new CooperService();
            }
            cooperService = f2541a;
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
        String k = bq.a().k(context);
        if (TextUtils.isEmpty(k)) {
            return null;
        }
        try {
            return new JSONObject(k);
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
        bq.a().g(context, jSONObject.toString());
        if (extraInfo != null) {
            str = "Set global ExtraInfo: " + jSONObject;
        } else {
            str = "Clear global ExtraInfo";
        }
        bc.c().a(str);
    }

    public JSONObject getPushId(Context context) {
        String l = bq.a().l(context);
        if (TextUtils.isEmpty(l)) {
            return null;
        }
        try {
            return new JSONObject(l);
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
        bq.a().h(context, pushId.toString());
        if (str3 != null) {
            str4 = "Set platform:" + str2 + " pushId: " + str3;
        } else {
            str4 = "Clear platform:" + str2 + " pushId";
        }
        bc.c().a(str4);
    }

    public void setStartType(boolean z) {
        this.b.setStartType(z);
    }

    private static String a(Context context) {
        String l = bw.l(context);
        if (!TextUtils.isEmpty(l)) {
            return l.replaceAll(":", "");
        }
        return l;
    }

    private static String b(Context context) {
        String k = bw.k(context);
        if (!TextUtils.isEmpty(k)) {
            return k.replaceAll(":", "");
        }
        return k;
    }

    private static String c(Context context) {
        String n = bw.n(context);
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
        String h = bq.a().h(context);
        if (!TextUtils.isEmpty(h)) {
            this.b.s = h;
            return this.b.s;
        }
        String a2 = a(context, z);
        if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
            this.b.s = getSecretValue(a2);
            bq.a().e(context, this.b.s);
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
        String j = bq.a().j(context);
        if (!TextUtils.isEmpty(j)) {
            this.b.t = j;
            return this.b.t;
        }
        String c = bw.c(1, context);
        if (!TextUtils.isEmpty(c)) {
            this.b.t = c;
            bq.a().f(context, c);
            return this.b.t;
        }
        this.b.t = "";
        return this.b.t;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        bq.a().b(context, "");
        if (this.b.f == null || "".equalsIgnoreCase(this.b.f)) {
            try {
                this.b.f = bx.a(context);
                Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.f);
                this.b.f = matcher.replaceAll("");
                this.b.f = getSecretValue(this.b.f);
            } catch (Exception e) {
            }
        }
        if (z) {
            return this.b.f;
        }
        try {
            String str = this.b.f;
            if (!TextUtils.isEmpty(str)) {
                return new String(bm.b.b(1, bp.a(str.getBytes())));
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
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            return "";
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        if (!TextUtils.isEmpty(this.b.i)) {
            return this.b.i;
        }
        if (bq.a().i(context)) {
            this.b.i = getMacIdForTv(context);
            return this.b.i;
        }
        String s = bq.a().s(context);
        if (!TextUtils.isEmpty(s)) {
            this.b.i = s;
            return this.b.i;
        } else if (telephonyManager == null) {
            return this.b.i;
        } else {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    s = compile.matcher(deviceId).replaceAll("");
                }
            } catch (Exception e) {
            }
            if (s == null || s.equals(Config.NULL_DEVICE_ID)) {
                s = a(context);
            }
            if (bw.w(context) && (TextUtils.isEmpty(s) || s.equals(Config.NULL_DEVICE_ID))) {
                try {
                    s = c(context);
                } catch (Exception e2) {
                }
            }
            if (TextUtils.isEmpty(s) || s.equals(Config.NULL_DEVICE_ID)) {
                s = d(context);
            }
            this.b.i = s;
            this.b.i = getSecretValue(this.b.i);
            return this.b.i;
        }
    }

    private String d(Context context) {
        String e = bq.a().e(context);
        if (TextUtils.isEmpty(e) || e.equals(Config.NULL_DEVICE_ID)) {
            String str = "hol" + (new Date().getTime() + "").hashCode() + "mes";
            bq.a().a(context, str);
            return str;
        }
        return e;
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
                boolean g = bq.a().g(context);
                if (g) {
                    this.b.l = bq.a().f(context);
                }
                if (!g || this.b.l == null || this.b.l.equals("")) {
                    this.b.l = bw.a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Exception e) {
        }
        return this.b.l;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        if (this.b.e == null) {
            this.b.e = bw.a(context, Config.APPKEY_META_NAME);
        }
        return this.b.e;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        return "3.9.5.1";
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        if (this.b.g == -1) {
            this.b.g = bw.f(context);
        }
        return this.b.g;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.b.h)) {
            this.b.h = bw.g(context);
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
            this.b.r = bw.r(context);
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
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_WIFI_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(bw.a(context, Config.GET_GPS_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_CELL_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getSecretValue(String str) {
        return bm.b.c(1, str.getBytes());
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public void resetHeadSign() {
        this.b.z = instance().getUUID();
    }

    public void enableDeviceMac(Context context, boolean z) {
        bq.a().d(context, z);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return bq.a().m(context);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        bq.a().i(context, str);
        this.b.setUserId(str);
        bc.c().a("Set user id " + str);
    }

    public String getUserId(Context context) {
        return bq.a().q(context);
    }
}
