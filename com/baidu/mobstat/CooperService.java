package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.bm;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class CooperService implements ICooperService {

    /* renamed from: a  reason: collision with root package name */
    public static CooperService f8774a;

    /* renamed from: b  reason: collision with root package name */
    public HeadObject f8775b = new HeadObject();

    public static String a(Context context) {
        String l = bw.l(context);
        return !TextUtils.isEmpty(l) ? l.replaceAll(":", "") : l;
    }

    public static String b(Context context) {
        String k = bw.k(context);
        return !TextUtils.isEmpty(k) ? k.replaceAll(":", "") : k;
    }

    public static String c(Context context) {
        String n = bw.n(context);
        return !TextUtils.isEmpty(n) ? n.replaceAll(":", "") : n;
    }

    private String d(Context context) {
        String e2 = bq.a().e(context);
        if (TextUtils.isEmpty(e2) || e2.equals("000000000000000")) {
            String str = new Date().getTime() + "";
            String str2 = "hol" + str.hashCode() + "mes";
            bq.a().a(context, str2);
            return str2;
        }
        return e2;
    }

    private String e(Context context) {
        try {
            if (this.f8775b.l == null || this.f8775b.l.equals("")) {
                boolean g2 = bq.a().g(context);
                if (g2) {
                    this.f8775b.l = bq.a().f(context);
                }
                if (!g2 || this.f8775b.l == null || this.f8775b.l.equals("")) {
                    this.f8775b.l = bw.a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Exception unused) {
        }
        return this.f8775b.l;
    }

    public static synchronized CooperService instance() {
        CooperService cooperService;
        synchronized (CooperService.class) {
            if (f8774a == null) {
                f8774a = new CooperService();
            }
            cooperService = f8774a;
        }
        return cooperService;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkCellLocationSetting(Context context) {
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_CELL_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkGPSLocationSetting(Context context) {
        return "true".equals(bw.a(context, Config.GET_GPS_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        return "true".equalsIgnoreCase(bw.a(context, Config.GET_WIFI_LOCATION));
    }

    public void enableDeviceMac(Context context, boolean z) {
        bq.a().d(context, z);
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppChannel(Context context) {
        return e(context);
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        HeadObject headObject = this.f8775b;
        if (headObject.f8806e == null) {
            headObject.f8806e = bw.a(context, Config.APPKEY_META_NAME);
        }
        return this.f8775b.f8806e;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        HeadObject headObject = this.f8775b;
        if (headObject.f8808g == -1) {
            headObject.f8808g = bw.f(context);
        }
        return this.f8775b.f8808g;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppVersionName(Context context) {
        if (TextUtils.isEmpty(this.f8775b.f8809h)) {
            this.f8775b.f8809h = bw.g(context);
        }
        return this.f8775b.f8809h;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        bq.a().b(context, "");
        String str = this.f8775b.f8807f;
        if (str == null || "".equalsIgnoreCase(str)) {
            try {
                this.f8775b.f8807f = bx.a(context);
                Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.f8775b.f8807f);
                this.f8775b.f8807f = matcher.replaceAll("");
                this.f8775b.f8807f = getSecretValue(this.f8775b.f8807f);
            } catch (Exception unused) {
            }
        }
        if (z) {
            return this.f8775b.f8807f;
        }
        try {
            String str2 = this.f8775b.f8807f;
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return new String(bm.b.b(1, bp.a(str2.getBytes())));
        } catch (Exception unused2) {
            return null;
        }
    }

    public String getDevicImei(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        if (!TextUtils.isEmpty(this.f8775b.i)) {
            return this.f8775b.i;
        }
        if (bq.a().i(context)) {
            this.f8775b.i = getMacIdForTv(context);
            return this.f8775b.i;
        }
        String s = bq.a().s(context);
        if (!TextUtils.isEmpty(s)) {
            this.f8775b.i = s;
            return s;
        } else if (telephonyManager == null) {
            return this.f8775b.i;
        } else {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    s = compile.matcher(deviceId).replaceAll("");
                }
            } catch (Exception unused) {
            }
            if (s == null || s.equals("000000000000000")) {
                s = a(context);
            }
            if (bw.w(context) && (TextUtils.isEmpty(s) || s.equals("000000000000000"))) {
                try {
                    s = c(context);
                } catch (Exception unused2) {
                }
            }
            if (TextUtils.isEmpty(s) || s.equals("000000000000000")) {
                s = d(context);
            }
            HeadObject headObject = this.f8775b;
            headObject.i = s;
            headObject.i = getSecretValue(s);
            return this.f8775b.i;
        }
    }

    public HeadObject getHeadObject() {
        return this.f8775b;
    }

    public JSONObject getHeaderExt(Context context) {
        String k = bq.a().k(context);
        if (!TextUtils.isEmpty(k)) {
            try {
                return new JSONObject(k);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.f8775b.r)) {
            this.f8775b.r = bw.r(context);
        }
        return this.f8775b.r;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        return "3.9.5.1";
    }

    public String getMacAddress(Context context, boolean z) {
        String replace = Config.DEF_MAC_ID.replace(":", "");
        if (!z && Build.VERSION.SDK_INT >= 23) {
            return getSecretValue(replace);
        }
        if (!TextUtils.isEmpty(this.f8775b.s)) {
            return this.f8775b.s;
        }
        String h2 = bq.a().h(context);
        if (!TextUtils.isEmpty(h2)) {
            this.f8775b.s = h2;
            return h2;
        }
        String a2 = a(context, z);
        if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
            this.f8775b.s = getSecretValue(a2);
            bq.a().e(context, this.f8775b.s);
            return this.f8775b.s;
        }
        this.f8775b.s = "";
        return "";
    }

    public String getMacIdForTv(Context context) {
        if (!TextUtils.isEmpty(this.f8775b.t)) {
            return this.f8775b.t;
        }
        String j = bq.a().j(context);
        if (!TextUtils.isEmpty(j)) {
            this.f8775b.t = j;
            return j;
        }
        String c2 = bw.c(1, context);
        if (!TextUtils.isEmpty(c2)) {
            this.f8775b.t = c2;
            bq.a().f(context, c2);
            return this.f8775b.t;
        }
        this.f8775b.t = "";
        return "";
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.f8775b.o)) {
            this.f8775b.o = android.os.Build.MANUFACTURER;
        }
        return this.f8775b.o;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.f8775b.f8804c)) {
            this.f8775b.f8804c = Build.VERSION.RELEASE;
        }
        return this.f8775b.f8804c;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOSVersion() {
        if (TextUtils.isEmpty(this.f8775b.f8803b)) {
            this.f8775b.f8803b = Integer.toString(Build.VERSION.SDK_INT);
        }
        return this.f8775b.f8803b;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.f8775b.m)) {
            this.f8775b.m = telephonyManager.getNetworkOperator();
        }
        return this.f8775b.m;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.f8775b.n)) {
            this.f8775b.n = android.os.Build.MODEL;
        }
        return this.f8775b.n;
    }

    public String getPlainDeviceIdForCar(Context context) {
        String optUUID = CarUUID.optUUID(context);
        if (TextUtils.isEmpty(optUUID)) {
            optUUID = d(context);
        }
        return TextUtils.isEmpty(optUUID) ? "" : optUUID;
    }

    public JSONObject getPushId(Context context) {
        String l = bq.a().l(context);
        if (!TextUtils.isEmpty(l)) {
            try {
                return new JSONObject(l);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getSecretValue(String str) {
        return bm.b.c(1, str.getBytes());
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getTagValue() {
        return 1;
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public String getUserId(Context context) {
        return bq.a().q(context);
    }

    @Override // com.baidu.mobstat.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        this.f8775b.installHeader(context, jSONObject);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return bq.a().m(context);
    }

    public void resetHeadSign() {
        this.f8775b.z = instance().getUUID();
    }

    public void setAppVersionName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8775b.f8809h = str;
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.f8775b.setHeaderExt(jSONObject);
        bq.a().g(context, jSONObject.toString());
        if (extraInfo != null) {
            str = "Set global ExtraInfo: " + jSONObject;
        } else {
            str = "Clear global ExtraInfo";
        }
        bc.c().a(str);
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
        } catch (Exception unused) {
        }
        this.f8775b.setPushInfo(pushId);
        bq.a().h(context, pushId.toString());
        if (str3 != null) {
            str4 = "Set platform:" + str2 + " pushId: " + str3;
        } else {
            str4 = "Clear platform:" + str2 + " pushId";
        }
        bc.c().a(str4);
    }

    public void setStartType(boolean z) {
        this.f8775b.setStartType(z);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        bq.a().i(context, str);
        this.f8775b.setUserId(str);
        bc.c().a("Set user id " + str);
    }

    private String a(Context context, boolean z) {
        String a2;
        if (z) {
            a2 = b(context);
        } else {
            a2 = a(context);
        }
        return TextUtils.isEmpty(a2) ? "" : a2;
    }
}
