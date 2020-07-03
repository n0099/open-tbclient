package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.v.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class d {
    private static String cVW = "ug_";
    private static String cVX = "ug_business";
    private static String cVY = "ctkey";
    private static String cVZ = "CTK";
    private static String cWa = "eqid";
    private static String cWb = "sid_eid";
    private static String cWc = "exps";
    private String cUK;
    private String cWd;
    private String cWe;
    public b cWi;
    protected Context mContext;
    private String cVV = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cWf = "1";
    private String cWg = "2";
    private String cWh = "8.800201";

    protected abstract HashMap<String, String> axB();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cWi = bVar;
        if (this.cWi != null) {
            this.cUK = this.cWi.axy();
            this.cWd = this.cWi.getAppSid();
            this.cWe = this.cWi.axz();
        }
    }

    public String axC() {
        HashMap<String, String> axD = axD();
        axD.putAll(axB());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cVV, axD);
    }

    private HashMap<String, String> axD() {
        b.a apQ;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ag.getDisplayWidth(this.mContext) / ag.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ag.getDisplayHeight(this.mContext) / ag.getDensity(this.mContext))));
            hashMap.put("net", "" + avW());
            hashMap.put("n", this.cWf);
            hashMap.put("pk", this.cWe);
            hashMap.put("appid", this.cWd);
            hashMap.put("sw", "" + ag.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ag.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + axE());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.cUK);
            hashMap.put("chid", "0");
            String auX = aj.auX();
            if (auX.equals("0")) {
                auX = "";
            }
            hashMap.put("imei", auX);
            hashMap.put("cuid", com.baidu.swan.apps.u.a.agc().bd(com.baidu.swan.apps.u.a.afX()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cWh);
            hashMap.put("rpt", this.cWg);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
            if (apN != null && (apQ = apN.apQ()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, apQ.ahQ());
                JSONObject ahA = apQ.ahA();
                if (ahA != null) {
                    hashMap.put("eqid", ahA.optString(cWa, ""));
                }
                JSONObject aii = apQ.aii();
                if (aii != null) {
                    if (aii.has(cVX) && (jSONObject = aii.getJSONObject(cVX)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cVZ.equals(next)) {
                                    hashMap.put(cVY, optString);
                                } else {
                                    hashMap.put(cVW + next, optString);
                                }
                            }
                        }
                    }
                    if (aii.has(cWb) && (optJSONArray = aii.optJSONArray(cWb)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
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
                            hashMap.put(cWc, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.u.a.agH().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int avW() {
        switch (SwanAppNetworkUtils.alG()) {
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

    private String axE() {
        try {
            String auX = aj.auX();
            return TextUtils.isEmpty(auX) ? aj.getWifiInfo(this.mContext) : auX;
        } catch (Exception e) {
            return "";
        }
    }
}
