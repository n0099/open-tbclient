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
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public abstract class d {
    private static String dSI = "ug_";
    private static String dSJ = "ug_business";
    private static String dSK = "ctkey";
    private static String dSL = "CTK";
    private static String dSM = "eqid";
    private static String dSN = "sid_eid";
    private static String dSO = "exps";
    private String dQs;
    private String dSP;
    private String dSQ;
    public b dSU;
    private String dSV;
    protected Context mContext;
    private String dSH = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dSR = "1";
    private String dSS = "2";
    private String dST = "8.800201";

    protected abstract String aTt();

    protected abstract HashMap<String, String> aTu();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dSU = bVar;
        if (this.dSU != null) {
            this.dQs = this.dSU.aTq();
            this.dSP = this.dSU.getAppSid();
            this.dSQ = this.dSU.aTr();
        }
        if (!ak.aPy()) {
            this.dSV = com.baidu.swan.game.ad.d.e.aTz();
        }
    }

    public String aTv() {
        HashMap<String, String> aTw = aTw();
        aTw.putAll(aTu());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dSH, aTw);
    }

    protected String aFf() {
        return com.baidu.swan.apps.t.a.azz().akJ().getCookie(".baidu.com");
    }

    private HashMap<String, String> aTw() {
        String str;
        b.a aJY;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aRd());
            hashMap.put("n", this.dSR);
            hashMap.put("pk", this.dSQ);
            hashMap.put("appid", this.dSP);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dQs);
            hashMap.put("chid", "0");
            String aPx = ak.aPx();
            if (aPx.equals("0")) {
                aPx = "";
            }
            hashMap.put("imei", aPx);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.azf().bW(com.baidu.swan.apps.t.a.aza()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.anR());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aFf(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dST);
            hashMap.put("rpt", this.dSS);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
            String aTt = aTt();
            hashMap.put(dSO, aTt);
            if (aJV != null && (aJY = aJV.aJY()) != null) {
                hashMap.put("scene", aJY.aBe());
                JSONObject aAN = aJY.aAN();
                if (aAN != null) {
                    hashMap.put("eqid", aAN.optString(dSM, ""));
                }
                JSONObject aBw = aJY.aBw();
                if (aBw != null) {
                    if (aBw.has(dSJ) && (jSONObject = aBw.getJSONObject(dSJ)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dSL.equals(next)) {
                                    hashMap.put(dSK, optString);
                                    this.dSV = optString;
                                } else {
                                    hashMap.put(dSI + next, optString);
                                }
                            }
                        }
                    }
                    if (aBw.has(dSN) && (optJSONArray = aBw.optJSONArray(dSN)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aTt)) {
                            sb.append(aTt + ",");
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
                            hashMap.put(dSO, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dSL) && !TextUtils.isEmpty(this.dSV)) {
                hashMap.put(dSL, this.dSV);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.azM().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aRd() {
        switch (SwanAppNetworkUtils.aFi()) {
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
            String aPx = ak.aPx();
            return TextUtils.isEmpty(aPx) ? ak.getWifiInfo(this.mContext) : aPx;
        } catch (Exception e) {
            return "";
        }
    }

    public String aTx() {
        return this.dSV;
    }
}
