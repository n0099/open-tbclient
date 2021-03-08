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
/* loaded from: classes5.dex */
public abstract class d {
    private static String eaB = "ug_";
    private static String eaC = "ug_business";
    private static String eaD = "ctkey";
    private static String eaE = "CTK";
    private static String eaF = "eqid";
    private static String eaG = "sid_eid";
    private static String eaH = "exps";
    private String dYk;
    private String eaI;
    private String eaJ;
    public b eaN;
    private String eaO;
    protected Context mContext;
    private String eaA = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String eaK = "1";
    private String eaL = "2";
    private String eaM = "8.800201";

    protected abstract String aSj();

    protected abstract HashMap<String, String> aSk();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.eaN = bVar;
        if (this.eaN != null) {
            this.dYk = this.eaN.getAdPlaceId();
            this.eaI = this.eaN.getAppSid();
            this.eaJ = this.eaN.aSh();
        }
        if (!ak.aOs()) {
            this.eaO = com.baidu.swan.game.ad.d.e.aSp();
        }
    }

    public String aSl() {
        HashMap<String, String> aSm = aSm();
        aSm.putAll(aSk());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.eaA, aSm);
    }

    protected String aDf() {
        return com.baidu.swan.apps.t.a.axy().aiB().getCookie(".baidu.com");
    }

    private HashMap<String, String> aSm() {
        String str;
        b.a aIR;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aQb());
            hashMap.put("n", this.eaK);
            hashMap.put("pk", this.eaJ);
            hashMap.put("appid", this.eaI);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put("sh", "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put("apid", "" + this.dYk);
            hashMap.put("chid", "0");
            String aOr = ak.aOr();
            if (aOr.equals("0")) {
                aOr = "";
            }
            hashMap.put("imei", aOr);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.axe().ca(com.baidu.swan.apps.t.a.awZ()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.alK());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put("app_ver", ak.getVersionName());
            String cookieValue = ai.getCookieValue(aDf(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.eaM);
            hashMap.put("rpt", this.eaL);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
            String aSj = aSj();
            hashMap.put(eaH, aSj);
            if (aIO != null && (aIR = aIO.aIR()) != null) {
                hashMap.put("scene", aIR.azd());
                JSONObject ayM = aIR.ayM();
                if (ayM != null) {
                    hashMap.put("eqid", ayM.optString(eaF, ""));
                }
                JSONObject azv = aIR.azv();
                if (azv != null) {
                    if (azv.has(eaC) && (jSONObject = azv.getJSONObject(eaC)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (eaE.equals(next)) {
                                    hashMap.put(eaD, optString);
                                    this.eaO = optString;
                                } else {
                                    hashMap.put(eaB + next, optString);
                                }
                            }
                        }
                    }
                    if (azv.has(eaG) && (optJSONArray = azv.optJSONArray(eaG)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aSj)) {
                            sb.append(aSj + ",");
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
                            hashMap.put(eaH, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(eaE) && !TextUtils.isEmpty(this.eaO)) {
                hashMap.put(eaE, this.eaO);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.axL().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aQb() {
        switch (SwanAppNetworkUtils.aDi()) {
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
            String aOr = ak.aOr();
            return TextUtils.isEmpty(aOr) ? ak.getWifiInfo(this.mContext) : aOr;
        } catch (Exception e) {
            return "";
        }
    }

    public String aSn() {
        return this.eaO;
    }
}
