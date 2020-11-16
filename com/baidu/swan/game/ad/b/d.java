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
/* loaded from: classes12.dex */
public abstract class d {
    private static String dLL = "ug_";
    private static String dLM = "ug_business";
    private static String dLN = "ctkey";
    private static String dLO = "CTK";
    private static String dLP = "eqid";
    private static String dLQ = "sid_eid";
    private static String dLR = "exps";
    private String dJu;
    private String dLS;
    private String dLT;
    public b dLX;
    private String dLY;
    protected Context mContext;
    private String dLK = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dLU = "1";
    private String dLV = "2";
    private String dLW = "8.800201";

    protected abstract String aQo();

    protected abstract HashMap<String, String> aQp();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dLX = bVar;
        if (this.dLX != null) {
            this.dJu = this.dLX.aQl();
            this.dLS = this.dLX.getAppSid();
            this.dLT = this.dLX.aQm();
        }
        if (!ak.aMs()) {
            this.dLY = com.baidu.swan.game.ad.d.e.aQu();
        }
    }

    public String aQq() {
        HashMap<String, String> aQr = aQr();
        aQr.putAll(aQp());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dLK, aQr);
    }

    protected String aBW() {
        return com.baidu.swan.apps.t.a.awr().ahB().getCookie(".baidu.com");
    }

    private HashMap<String, String> aQr() {
        String str;
        b.a aGQ;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aNY());
            hashMap.put("n", this.dLU);
            hashMap.put("pk", this.dLT);
            hashMap.put("appid", this.dLS);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dJu);
            hashMap.put("chid", "0");
            String aMr = ak.aMr();
            if (aMr.equals("0")) {
                aMr = "";
            }
            hashMap.put("imei", aMr);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.avX().bq(com.baidu.swan.apps.t.a.avS()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.akJ());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aBW(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dLW);
            hashMap.put("rpt", this.dLV);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
            String aQo = aQo();
            hashMap.put(dLR, aQo);
            if (aGN != null && (aGQ = aGN.aGQ()) != null) {
                hashMap.put("scene", aGQ.axV());
                JSONObject axE = aGQ.axE();
                if (axE != null) {
                    hashMap.put("eqid", axE.optString(dLP, ""));
                }
                JSONObject ayn = aGQ.ayn();
                if (ayn != null) {
                    if (ayn.has(dLM) && (jSONObject = ayn.getJSONObject(dLM)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dLO.equals(next)) {
                                    hashMap.put(dLN, optString);
                                    this.dLY = optString;
                                } else {
                                    hashMap.put(dLL + next, optString);
                                }
                            }
                        }
                    }
                    if (ayn.has(dLQ) && (optJSONArray = ayn.optJSONArray(dLQ)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aQo)) {
                            sb.append(aQo + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(dLR, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dLO) && !TextUtils.isEmpty(this.dLY)) {
                hashMap.put(dLO, this.dLY);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.awE().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aNY() {
        switch (SwanAppNetworkUtils.aBZ()) {
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
            String aMr = ak.aMr();
            return TextUtils.isEmpty(aMr) ? ak.getWifiInfo(this.mContext) : aMr;
        } catch (Exception e) {
            return "";
        }
    }

    public String aQs() {
        return this.dLY;
    }
}
