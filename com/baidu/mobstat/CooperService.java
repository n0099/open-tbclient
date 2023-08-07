package com.baidu.mobstat;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.mobstat.bl;
import com.baidu.searchbox.player.model.YYOption;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class CooperService implements ICooperService {
    public static CooperService a;
    public HeadObject b = new HeadObject();
    public boolean c = true;
    public String d = "0";
    public boolean e = false;
    public boolean f = true;
    public int g = 1;
    public int h = 10;

    @Override // com.baidu.mobstat.ICooperService
    public String getMTJSDKVersion() {
        return "4.0.9.7";
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getTagValue() {
        return 2;
    }

    public void setZid(String str) {
    }

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

    public void closeTrace() {
        this.e = true;
    }

    public int getCollectTitleMaxLevel() {
        return this.g;
    }

    public int getEvAutoSize() {
        return this.h;
    }

    public HeadObject getHeadObject() {
        return this.b;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getHost() {
        return Config.LOG_SEND_URL;
    }

    public String getManufacturer() {
        if (TextUtils.isEmpty(this.b.o)) {
            this.b.o = android.os.Build.MANUFACTURER;
        }
        return this.b.o;
    }

    public String getOSSysVersion() {
        if (TextUtils.isEmpty(this.b.c)) {
            this.b.c = Build.VERSION.RELEASE;
        }
        return this.b.c;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOSVersion() {
        if (TextUtils.isEmpty(this.b.b)) {
            this.b.b = Integer.toString(Build.VERSION.SDK_INT);
        }
        return this.b.b;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getPhoneModel() {
        if (TextUtils.isEmpty(this.b.n)) {
            this.b.n = android.os.Build.MODEL;
        }
        return this.b.n;
    }

    public String getPlatformType() {
        return this.d;
    }

    public String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public boolean isCloseTrace() {
        return this.e;
    }

    public boolean isEnableDownloadJs() {
        return this.f;
    }

    public boolean isEnabledAutoEvent() {
        return this.c;
    }

    public void resetHeadSign() {
        this.b.x = instance().getUUID();
    }

    public static String a(Context context) {
        if (!bu.a().d()) {
            return Config.DEF_MAC_ID;
        }
        String j = bw.j(context);
        if (TextUtils.isEmpty(j)) {
            return Config.DEF_MAC_ID;
        }
        return j.replaceAll(":", "");
    }

    public static String b(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        String i = bw.i(context);
        if (!TextUtils.isEmpty(i)) {
            return i.replaceAll(":", "");
        }
        return i;
    }

    @Override // com.baidu.mobstat.ICooperService
    public boolean checkWifiLocationSetting(Context context) {
        return YYOption.IsLive.VALUE_TRUE.equalsIgnoreCase(bw.a(context, Config.GET_WIFI_LOCATION));
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppChannel(Context context) {
        return d(context);
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getAppKey(Context context) {
        HeadObject headObject = this.b;
        if (headObject.e == null) {
            headObject.e = bw.a(context, Config.APPKEY_META_NAME);
        }
        return this.b.e;
    }

    @Override // com.baidu.mobstat.ICooperService
    public int getAppVersionCode(Context context) {
        HeadObject headObject = this.b;
        if (headObject.g == -1) {
            headObject.g = bw.f(context);
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

    public String getDevicImei(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        try {
            if (!bn.e(context, com.kuaishou.weapon.p0.h.c)) {
                return "";
            }
            return ApiReplaceUtil.getDeviceId((TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            return "";
        }
    }

    public JSONObject getHeaderExt(Context context) {
        String k = bp.a().k(context);
        if (!TextUtils.isEmpty(k)) {
            try {
                return new JSONObject(k);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public String getLastUserId(Context context) {
        return bp.a().r(context);
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getLinkedWay(Context context) {
        if (TextUtils.isEmpty(this.b.p)) {
            this.b.p = bw.p(context);
        }
        return this.b.p;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getOperator(TelephonyManager telephonyManager) {
        if (TextUtils.isEmpty(this.b.m)) {
            this.b.m = telephonyManager.getNetworkOperator();
        }
        return this.b.m;
    }

    public String getPlainDeviceIdForCar(Context context) {
        String optUUID = CarUUID.optUUID(context);
        if (TextUtils.isEmpty(optUUID)) {
            optUUID = c(context);
        }
        if (TextUtils.isEmpty(optUUID)) {
            return "";
        }
        return optUUID;
    }

    public JSONObject getPushId(Context context) {
        String l = bp.a().l(context);
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
        return bl.b.c(2, str.getBytes());
    }

    public String getUserId(Context context) {
        return bp.a().q(context);
    }

    public boolean isDeviceMacEnabled(Context context) {
        return bp.a().m(context);
    }

    public boolean isEnableBplus(Context context) {
        return bp.a().x(context);
    }

    public void setCollectTitleMaxLevel(int i) {
        this.g = i;
    }

    public void setEnableAutoEvent(boolean z) {
        this.c = z;
    }

    public void setEnableDownloadJs(boolean z) {
        this.f = z;
    }

    public void setEvAutoSize(int i) {
        this.h = i;
    }

    public void setHeaderPy(String str) {
        this.b.setHeaderPy(str);
    }

    public void setPlatformType(int i) {
        this.d = i + "";
    }

    public void setStartType(boolean z) {
        this.b.setStartType(z);
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

    public void enableDeviceMac(Context context, boolean z) {
        bp.a().d(context, z);
    }

    @Override // com.baidu.mobstat.ICooperService
    public void installHeader(Context context, JSONObject jSONObject) {
        this.b.installHeader(context, jSONObject);
    }

    public void setAppVersionName(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b.h = str;
    }

    public void setEnableBplus(Context context, boolean z) {
        bp.a().e(context, z);
    }

    public void setLastUserId(Context context, String str) {
        bp.a().j(context, str);
    }

    private String c(Context context) {
        String e = bp.a().e(context);
        if (TextUtils.isEmpty(e) || e.equals("000000000000000")) {
            String str = new Date().getTime() + "";
            String str2 = "hol" + str.hashCode() + "mes";
            bp.a().a(context, str2);
            return str2;
        }
        return e;
    }

    private String d(Context context) {
        try {
            if (this.b.l == null || this.b.l.equals("")) {
                boolean g = bp.a().g(context);
                if (g) {
                    this.b.l = bp.a().f(context);
                }
                if (!g || this.b.l == null || this.b.l.equals("")) {
                    this.b.l = bw.a(context, Config.CHANNEL_META_NAME);
                }
            }
        } catch (Exception unused) {
        }
        return this.b.l;
    }

    public String getMacIdForTv(Context context) {
        if (!bu.a().d()) {
            return "";
        }
        if (!TextUtils.isEmpty(this.b.r)) {
            return this.b.r;
        }
        String j = bp.a().j(context);
        if (!TextUtils.isEmpty(j)) {
            this.b.r = j;
            return j;
        }
        String i = bw.i(2, context);
        if (!TextUtils.isEmpty(i)) {
            this.b.r = i;
            bp.a().f(context, i);
            return this.b.r;
        }
        this.b.r = "";
        return "";
    }

    public void deleteCacheImei(Context context) {
        try {
            String t = bp.a().t(context);
            if (TextUtils.isEmpty(t)) {
                return;
            }
            String str = new String(bl.b.b(2, bo.a(t.getBytes())));
            if (!TextUtils.isEmpty(str) && !str.contains("hol") && !str.contains("0200")) {
                bp.a().l(context, "");
            }
        } catch (Throwable unused) {
        }
    }

    public boolean filterCuid(Context context, String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = "";
            String replace = str.replace(":", "");
            if (replace.equals(Config.DEF_MAC_ID.replace(":", ""))) {
                if (TextUtils.isEmpty(this.b.f)) {
                    this.b.i = getSecretValue(c(context));
                    return true;
                }
                try {
                    str2 = new String(bl.b.b(2, bo.a(this.b.f.getBytes())));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TextUtils.isEmpty(str2)) {
                    this.b.i = getSecretValue(c(context));
                    z = true;
                } else {
                    this.b.i = getSecretValue(replace);
                }
                return z;
            }
            this.b.i = getSecretValue(replace);
            return true;
        }
        return false;
    }

    @Override // com.baidu.mobstat.ICooperService
    public String getCUID(Context context, boolean z) {
        bp.a().b(context, "");
        String str = this.b.f;
        if (str == null || "".equalsIgnoreCase(str)) {
            try {
                this.b.f = bx.a(context);
                Matcher matcher = Pattern.compile("\\s*|\t|\r|\n").matcher(this.b.f);
                this.b.f = matcher.replaceAll("");
                this.b.f = getSecretValue(this.b.f);
            } catch (Exception unused) {
            }
        }
        if (z) {
            return this.b.f;
        }
        try {
            String str2 = this.b.f;
            if (!TextUtils.isEmpty(str2)) {
                return new String(bl.b.b(2, bo.a(str2.getBytes())));
            }
            return null;
        } catch (Exception unused2) {
            return null;
        }
    }

    public String getPhoneAddress(Context context, boolean z) {
        String replace = Config.DEF_MAC_ID.replace(":", "");
        if (!z && Build.VERSION.SDK_INT >= 23) {
            return getSecretValue(replace);
        }
        if (!TextUtils.isEmpty(this.b.q)) {
            return this.b.q;
        }
        String h = bp.a().h(context);
        if (!TextUtils.isEmpty(h)) {
            this.b.q = h;
            return h;
        }
        String a2 = a(context, z);
        if (!TextUtils.isEmpty(a2) && !replace.equals(a2)) {
            this.b.q = getSecretValue(a2);
            bp.a().e(context, this.b.q);
            return this.b.q;
        }
        this.b.q = "";
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0073, code lost:
        if (r4.length() > 30) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a8, code lost:
        if (r4.length() > 30) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b1  */
    @Override // com.baidu.mobstat.ICooperService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getDeviceId(TelephonyManager telephonyManager, Context context) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        if (!TextUtils.isEmpty(this.b.i)) {
            return this.b.i;
        }
        if (bp.a().i(context)) {
            this.b.i = getMacIdForTv(context);
            return this.b.i;
        }
        String t = bp.a().t(context);
        if (!TextUtils.isEmpty(t)) {
            try {
                str2 = new String(bl.b.b(2, bo.a(t.getBytes())));
                z = true;
            } catch (Exception e) {
                e.printStackTrace();
                str2 = "";
                z = false;
            }
            if (z) {
                if (!TextUtils.isEmpty(str2)) {
                    if (!str2.contains(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX)) {
                        if (!str2.contains("=")) {
                        }
                    }
                }
                t = "";
                str2 = t;
                if (!TextUtils.isEmpty(str2)) {
                    filterCuid(context, str2, true);
                    return this.b.i;
                }
            } else {
                try {
                    str2 = new String(bl.b.b(1, bo.a(t.getBytes())));
                    z2 = true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    z2 = false;
                }
                if (z2) {
                    if (!TextUtils.isEmpty(str2)) {
                        if (!str2.contains(BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX)) {
                            if (!str2.contains("=")) {
                            }
                        }
                    }
                    t = "";
                    str2 = t;
                    if (!TextUtils.isEmpty(str2)) {
                    }
                } else {
                    this.b.i = t;
                    return t;
                }
            }
        }
        if (telephonyManager != null && bu.a().d()) {
            Pattern compile = Pattern.compile("\\s*|\t|\r|\n");
            try {
                if (!bn.e(context, com.kuaishou.weapon.p0.h.c)) {
                    str = "";
                } else {
                    str = ApiReplaceUtil.getDeviceId(telephonyManager);
                }
                if (str != null) {
                    t = compile.matcher(str).replaceAll("");
                }
            } catch (Exception unused) {
            }
        }
        if (!TextUtils.isEmpty(t) && !t.equals("000000000000000")) {
            this.b.i = getSecretValue(t);
            return this.b.i;
        } else if (filterCuid(context, a(context), false)) {
            return this.b.i;
        } else {
            return this.b.i;
        }
    }

    public void setHeaderExt(Context context, ExtraInfo extraInfo) {
        String str;
        JSONObject jSONObject = new JSONObject();
        if (extraInfo != null) {
            jSONObject = extraInfo.dumpToJson();
        }
        this.b.setHeaderExt(jSONObject);
        bp.a().g(context, jSONObject.toString());
        if (extraInfo != null) {
            str = "Set global ExtraInfo: " + jSONObject;
        } else {
            str = "Clear global ExtraInfo";
        }
        bb.c().a(str);
    }

    public void setUserId(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        bp.a().i(context, str);
        this.b.setUserId(str);
        bb.c().a("Set user id " + str);
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
        this.b.setPushInfo(pushId);
        bp.a().h(context, pushId.toString());
        if (str3 != null) {
            str4 = "Set platform:" + str2 + " pushId: " + str3;
        } else {
            str4 = "Clear platform:" + str2 + " pushId";
        }
        bb.c().a(str4);
    }

    public void setUserProperty(Context context, Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        boolean z = false;
        try {
        } catch (Exception e) {
            bb c = bb.c();
            c.c("[Exception] " + e.getMessage());
            e.printStackTrace();
        }
        if (map == null) {
            bp.a().m(context, "");
            this.b.setUserProperty("");
        } else if (map.size() > 100) {
            bb.c().c("[WARNING] setUserProperty failed,map size can not over 100 !");
        } else {
            boolean z2 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                JSONArray jSONArray = new JSONArray();
                String key = entry.getKey();
                String value = entry.getValue();
                if (!TextUtils.isEmpty(key) && value != null) {
                    if (key.length() <= 256 && (TextUtils.isEmpty(value) || value.length() <= 256)) {
                        jSONArray.put(value);
                        jSONArray.put("1");
                        jSONObject.put(key, jSONArray);
                    }
                    bb.c().c("[WARNING] setUserProperty failed,key or value can not over 256 bytes !");
                    z2 = false;
                }
                bb.c().c("[WARNING] setUserProperty failed,key or value can not null !");
                z2 = false;
            }
            z = z2;
            if (z) {
                bp.a().m(context, jSONObject.toString());
                this.b.setUserProperty(jSONObject.toString());
            }
        }
    }
}
