package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class d {
    private static String ebF = "ug_";
    private static String ebG = "ug_business";
    private static String ebH = "ctkey";
    private static String ebI = "CTK";
    private static String ebJ = "eqid";
    private static String ebK = "sid_eid";
    private static String ebL = "exps";
    private String dZp;
    private String ebM;
    private String ebN;
    public b ebR;
    private String ebS;
    protected Context mContext;
    private String ebE = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String ebO = "1";
    private String ebP = "2";
    private String ebQ = "8.800201";

    protected abstract String aVO();

    protected abstract HashMap<String, String> aVP();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.ebR = bVar;
        if (this.ebR != null) {
            this.dZp = this.ebR.aVL();
            this.ebM = this.ebR.getAppSid();
            this.ebN = this.ebR.aVM();
        }
        if (!ak.aRQ()) {
            this.ebS = com.baidu.swan.game.ad.d.e.aVU();
        }
    }

    public String aVQ() {
        HashMap<String, String> aVR = aVR();
        aVR.putAll(aVP());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.ebE, aVR);
    }

    protected String aGA() {
        return com.baidu.swan.apps.t.a.aAR().alU().getCookie(".baidu.com");
    }

    private HashMap<String, String> aVR() {
        String str;
        b.a aMp;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aTz());
            hashMap.put("n", this.ebO);
            hashMap.put("pk", this.ebN);
            hashMap.put("appid", this.ebM);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put("apid", "" + this.dZp);
            hashMap.put("chid", "0");
            String aRP = ak.aRP();
            if (aRP.equals("0")) {
                aRP = "";
            }
            hashMap.put("imei", aRP);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.aAx().cd(com.baidu.swan.apps.t.a.aAs()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.apd());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aGA(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.ebQ);
            hashMap.put("rpt", this.ebP);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
            String aVO = aVO();
            hashMap.put(ebL, aVO);
            if (aMm != null && (aMp = aMm.aMp()) != null) {
                hashMap.put("scene", aMp.aCw());
                JSONObject aCf = aMp.aCf();
                if (aCf != null) {
                    hashMap.put("eqid", aCf.optString(ebJ, ""));
                }
                JSONObject aCO = aMp.aCO();
                if (aCO != null) {
                    if (aCO.has(ebG) && (jSONObject = aCO.getJSONObject(ebG)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (ebI.equals(next)) {
                                    hashMap.put(ebH, optString);
                                    this.ebS = optString;
                                } else {
                                    hashMap.put(ebF + next, optString);
                                }
                            }
                        }
                    }
                    if (aCO.has(ebK) && (optJSONArray = aCO.optJSONArray(ebK)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aVO)) {
                            sb.append(aVO + ",");
                        }
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            String optString2 = optJSONArray.optString(i);
                            if (!TextUtils.isEmpty(optString2)) {
                                sb.append(optString2);
                                if (i >= 0 && i < optJSONArray.length() - 1) {
                                    sb.append(",");
                                }
                            }
                        }
                        if (sb.length() > 0) {
                            hashMap.put(ebL, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(ebI) && !TextUtils.isEmpty(this.ebS)) {
                hashMap.put(ebI, this.ebS);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.aBe().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aTz() {
        switch (SwanAppNetworkUtils.aGD()) {
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
            String aRP = ak.aRP();
            return TextUtils.isEmpty(aRP) ? ak.getWifiInfo(this.mContext) : aRP;
        } catch (Exception e) {
            return "";
        }
    }

    public String aVS() {
        return this.ebS;
    }
}
