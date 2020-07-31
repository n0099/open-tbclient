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
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.util.HashMap;
import java.util.UUID;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class e extends d {
    private String alk;
    private int daX;
    private int mPos;
    private int mType;

    public e(Context context, b bVar, int i, int i2) {
        super(context, bVar);
        this.daX = 1;
        this.mType = 1;
        this.mPos = 1;
        this.mType = i;
        this.mPos = i2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    public String aAA() {
        return "https://powerful.xdplt.com/api/v1/front/ltc";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aAz() {
        return null;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aAy() {
        return null;
    }

    public JSONObject aAE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", String.valueOf(System.currentTimeMillis()));
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", this.daU.getAppSid());
            jSONObject2.put("name", com.baidu.swan.apps.t.a.ahU().getHostName());
            jSONObject2.put("bundle", com.baidu.swan.apps.t.a.ahj().getPackageName());
            jSONObject2.put("version", al.getVersionName());
            jSONObject.put("app", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(j.c, getUserAgent());
            jSONObject3.put("imei", al.axd());
            jSONObject3.put("android_id", getAndroidId());
            jSONObject3.put(TableDefine.UserInfoColumns.COLUMN_IP, al.cI(this.mContext));
            jSONObject3.put("type", 1);
            jSONObject3.put("os", 1);
            jSONObject3.put("os_version", com.baidu.swan.apps.h.c.Xw());
            jSONObject3.put("make", com.baidu.swan.apps.h.c.Xv());
            jSONObject3.put("model", com.baidu.swan.apps.h.c.getDeviceModel());
            jSONObject3.put("language", this.mContext.getResources().getConfiguration().locale.getLanguage());
            jSONObject3.put("connection_type", ayK());
            jSONObject3.put("carrier", di(this.mContext));
            jSONObject3.put("mac", al.getWifiInfo(this.mContext));
            jSONObject3.put("screen_width", ai.getDisplayWidth(this.mContext));
            jSONObject3.put("screen_height", ai.getDisplayHeight(this.mContext));
            jSONObject3.put("screen_orientation", this.mContext.getResources().getConfiguration().orientation);
            jSONObject.put(Config.DEVICE_PART, jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(UbcStatConstant.KEY_CONTENT_EXT_SID, this.daU.aAv());
            jSONObject4.put("ad_count", this.daX);
            jSONObject4.put("ad_type", this.mType);
            jSONObject4.put("pos", this.mPos);
            jSONObject4.put("width", this.daU.aAt());
            jSONObject4.put("height", this.daU.aAu());
            jSONObject4.put(ClientCookie.SECURE_ATTR, 1);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject4);
            jSONObject.put("imps", jSONArray);
            return jSONObject;
        } catch (Exception e) {
            return null;
        }
    }

    private int ayK() {
        switch (SwanAppNetworkUtils.amW()) {
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

    public int di(Context context) {
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
        if (TextUtils.isEmpty(this.alk)) {
            try {
                this.alk = WebSettings.getDefaultUserAgent(this.mContext);
            } catch (Exception e) {
                try {
                    this.alk = System.getProperty("http.agent");
                } catch (Exception e2) {
                    this.alk = "";
                }
            }
        }
        return this.alk;
    }
}
