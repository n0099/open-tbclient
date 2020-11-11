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
    private static String dNt = "ug_";
    private static String dNu = "ug_business";
    private static String dNv = "ctkey";
    private static String dNw = "CTK";
    private static String dNx = "eqid";
    private static String dNy = "sid_eid";
    private static String dNz = "exps";
    private String dLc;
    private String dNA;
    private String dNB;
    public b dNF;
    private String dNG;
    protected Context mContext;
    private String dNs = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dNC = "1";
    private String dND = "2";
    private String dNE = "8.800201";

    protected abstract String aQW();

    protected abstract HashMap<String, String> aQX();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dNF = bVar;
        if (this.dNF != null) {
            this.dLc = this.dNF.aQT();
            this.dNA = this.dNF.getAppSid();
            this.dNB = this.dNF.aQU();
        }
        if (!ak.aNa()) {
            this.dNG = com.baidu.swan.game.ad.d.e.aRc();
        }
    }

    public String aQY() {
        HashMap<String, String> aQZ = aQZ();
        aQZ.putAll(aQX());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dNs, aQZ);
    }

    protected String aCE() {
        return com.baidu.swan.apps.t.a.awZ().aij().getCookie(".baidu.com");
    }

    private HashMap<String, String> aQZ() {
        String str;
        b.a aHy;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aOG());
            hashMap.put("n", this.dNC);
            hashMap.put("pk", this.dNB);
            hashMap.put("appid", this.dNA);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dLc);
            hashMap.put("chid", "0");
            String aMZ = ak.aMZ();
            if (aMZ.equals("0")) {
                aMZ = "";
            }
            hashMap.put("imei", aMZ);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.awF().bq(com.baidu.swan.apps.t.a.awA()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.alr());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aCE(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dNE);
            hashMap.put("rpt", this.dND);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
            String aQW = aQW();
            hashMap.put(dNz, aQW);
            if (aHv != null && (aHy = aHv.aHy()) != null) {
                hashMap.put("scene", aHy.ayD());
                JSONObject aym = aHy.aym();
                if (aym != null) {
                    hashMap.put("eqid", aym.optString(dNx, ""));
                }
                JSONObject ayV = aHy.ayV();
                if (ayV != null) {
                    if (ayV.has(dNu) && (jSONObject = ayV.getJSONObject(dNu)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dNw.equals(next)) {
                                    hashMap.put(dNv, optString);
                                    this.dNG = optString;
                                } else {
                                    hashMap.put(dNt + next, optString);
                                }
                            }
                        }
                    }
                    if (ayV.has(dNy) && (optJSONArray = ayV.optJSONArray(dNy)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aQW)) {
                            sb.append(aQW + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(dNz, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dNw) && !TextUtils.isEmpty(this.dNG)) {
                hashMap.put(dNw, this.dNG);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.axm().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aOG() {
        switch (SwanAppNetworkUtils.aCH()) {
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
            String aMZ = ak.aMZ();
            return TextUtils.isEmpty(aMZ) ? ak.getWifiInfo(this.mContext) : aMZ;
        } catch (Exception e) {
            return "";
        }
    }

    public String aRa() {
        return this.dNG;
    }
}
