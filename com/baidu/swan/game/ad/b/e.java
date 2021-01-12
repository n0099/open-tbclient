package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.fsg.base.statistics.j;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.mobstat.Config;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.kwai.video.player.KsMediaMeta;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class e extends d {
    private int dXi;
    private int mPos;
    private int mType;
    private String mUa;

    public e(Context context, b bVar, int i, int i2) {
        super(context, bVar);
        this.dXi = 1;
        this.mType = 1;
        this.mPos = 1;
        this.mType = i;
        this.mPos = i2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    public String aRW() {
        return "https://powerful.xdplt.com/api/v1/front/ltc";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aRV() {
        return null;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aRU() {
        return null;
    }

    public JSONObject aRZ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.dXf.getAppSid());
            jSONObject2.put("name", com.baidu.swan.apps.t.a.axk().getHostName());
            jSONObject2.put("bundle", com.baidu.swan.apps.t.a.awy().getPackageName());
            jSONObject2.put("version", ak.getVersionName());
            jSONObject.put("app", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(j.c, getUserAgent());
            jSONObject3.put("imei", ak.aNV());
            jSONObject3.put("android_id", getAndroidId());
            jSONObject3.put(TableDefine.UserInfoColumns.COLUMN_IP, hP(true));
            jSONObject3.put("type", 1);
            jSONObject3.put("os", 1);
            jSONObject3.put("os_version", com.baidu.swan.apps.i.c.alj());
            jSONObject3.put("make", com.baidu.swan.apps.i.c.ali());
            jSONObject3.put("model", com.baidu.swan.apps.i.c.getDeviceModel());
            jSONObject3.put(KsMediaMeta.KSM_KEY_LANGUAGE, this.mContext.getResources().getConfiguration().locale.getLanguage());
            jSONObject3.put("connection_type", aPF());
            jSONObject3.put("carrier", er(this.mContext));
            jSONObject3.put("mac", ak.getWifiInfo(this.mContext));
            jSONObject3.put("screen_width", ah.getDisplayWidth(this.mContext));
            jSONObject3.put("screen_height", ah.getDisplayHeight(this.mContext));
            jSONObject3.put("screen_orientation", this.mContext.getResources().getConfiguration().orientation);
            jSONObject.put(Config.DEVICE_PART, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(UbcStatConstant.KEY_CONTENT_EXT_SID, this.dXf.aRR());
            jSONObject4.put("ad_count", this.dXi);
            jSONObject4.put("ad_type", this.mType);
            jSONObject4.put("pos", this.mPos);
            jSONObject4.put("width", this.dXf.aRP());
            jSONObject4.put("height", this.dXf.aRQ());
            jSONObject4.put(ClientCookie.SECURE_ATTR, 1);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject4);
            jSONObject.put("imps", jSONArray);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private int aPF() {
        switch (SwanAppNetworkUtils.aCJ()) {
            case WIFI:
                return 1;
            case _2G:
                return 2;
            case _3G:
                return 3;
            case _4G:
                return 4;
            case _5G:
                return 5;
            default:
                return 0;
        }
    }

    public int er(Context context) {
        TelephonyManager telephonyManager;
        String simOperator;
        if (context != null && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null && (simOperator = telephonyManager.getSimOperator()) != null) {
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46007".equals(simOperator)) {
                return 1;
            }
            if ("46001".equals(simOperator)) {
                return 2;
            }
            return "46003".equals(simOperator) ? 3 : 0;
        }
        return 0;
    }

    private String getAndroidId() {
        try {
            String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (TextUtils.isEmpty(string)) {
                return UUID.randomUUID().toString();
            }
            return string;
        } catch (Exception e) {
            return "";
        }
    }

    private String getUserAgent() {
        if (TextUtils.isEmpty(this.mUa)) {
            try {
                this.mUa = WebSettings.getDefaultUserAgent(this.mContext);
            } catch (Exception e) {
                try {
                    this.mUa = System.getProperty("http.agent");
                } catch (Exception e2) {
                    this.mUa = "";
                }
            }
        }
        return this.mUa;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        r0 = r0.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String hP(boolean z) {
        String str;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            loop0: while (true) {
                if (!networkInterfaces.hasMoreElements()) {
                    str = null;
                    break;
                }
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!z || !(nextElement instanceof Inet6Address)) {
                        if (!nextElement.isLoopbackAddress()) {
                            break loop0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }
}
