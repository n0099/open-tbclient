package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class d {
    private static String dHB = "ug_";
    private static String dHC = "ug_business";
    private static String dHD = "ctkey";
    private static String dHE = "CTK";
    private static String dHF = "eqid";
    private static String dHG = "sid_eid";
    private static String dHH = "exps";
    private String dFk;
    private String dHI;
    private String dHJ;
    public b dHN;
    private String dHO;
    protected Context mContext;
    private String dHA = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dHK = "1";
    private String dHL = "2";
    private String dHM = "8.800201";

    protected abstract String aOw();

    protected abstract HashMap<String, String> aOx();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dHN = bVar;
        if (this.dHN != null) {
            this.dFk = this.dHN.aOt();
            this.dHI = this.dHN.getAppSid();
            this.dHJ = this.dHN.aOu();
        }
        if (!ak.aKA()) {
            this.dHO = com.baidu.swan.game.ad.d.e.aOC();
        }
    }

    public String aOy() {
        HashMap<String, String> aOz = aOz();
        aOz.putAll(aOx());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dHA, aOz);
    }

    protected String aAe() {
        return com.baidu.swan.apps.t.a.auz().afJ().getCookie(".baidu.com");
    }

    private HashMap<String, String> aOz() {
        String str;
        b.a aEY;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aMg());
            hashMap.put("n", this.dHK);
            hashMap.put("pk", this.dHJ);
            hashMap.put("appid", this.dHI);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dFk);
            hashMap.put("chid", "0");
            String aKz = ak.aKz();
            if (aKz.equals("0")) {
                aKz = "";
            }
            hashMap.put("imei", aKz);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.auf().bq(com.baidu.swan.apps.t.a.aua()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.aiR());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aAe(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dHM);
            hashMap.put("rpt", this.dHL);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
            String aOw = aOw();
            hashMap.put(dHH, aOw);
            if (aEV != null && (aEY = aEV.aEY()) != null) {
                hashMap.put("scene", aEY.awd());
                JSONObject avM = aEY.avM();
                if (avM != null) {
                    hashMap.put("eqid", avM.optString(dHF, ""));
                }
                JSONObject awv = aEY.awv();
                if (awv != null) {
                    if (awv.has(dHC) && (jSONObject = awv.getJSONObject(dHC)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dHE.equals(next)) {
                                    hashMap.put(dHD, optString);
                                    this.dHO = optString;
                                } else {
                                    hashMap.put(dHB + next, optString);
                                }
                            }
                        }
                    }
                    if (awv.has(dHG) && (optJSONArray = awv.optJSONArray(dHG)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aOw)) {
                            sb.append(aOw + Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString2 = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb.append(optString2);
                                if (i >= 0 && i < optJSONArray.length() - 1) {
                                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                                }
                            }
                        }
                        if (sb.length() > 0) {
                            hashMap.put(dHH, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dHE) && !TextUtils.isEmpty(this.dHO)) {
                hashMap.put(dHE, this.dHO);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.auM().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aMg() {
        switch (SwanAppNetworkUtils.aAh()) {
            case NONE:
            default:
                return 0;
            case WIFI:
                return 100;
            case _2G:
                return 2;
            case _3G:
                return 3;
            case _4G:
                return 4;
            case UNKOWN:
                return 1;
        }
    }

    private String getSn() {
        try {
            String aKz = ak.aKz();
            return TextUtils.isEmpty(aKz) ? ak.getWifiInfo(this.mContext) : aKz;
        } catch (Exception e) {
            return "";
        }
    }

    public String aOA() {
        return this.dHO;
    }
}
