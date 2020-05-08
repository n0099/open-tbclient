package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.x.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class d {
    private static String cHc = "ug_";
    private static String cHd = "ug_business";
    private static String cHe = "ctkey";
    private static String cHf = "CTK";
    private static String cHg = "eqid";
    private static String cHh = "sid_eid";
    private static String cHi = "exps";
    private String cFQ;
    private String cHj;
    private String cHk;
    public b cHo;
    protected Context mContext;
    private String cHb = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cHl = "1";
    private String cHm = "2";
    private String cHn = "8.800201";

    protected abstract HashMap<String, String> asO();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cHo = bVar;
        if (this.cHo != null) {
            this.cFQ = this.cHo.asL();
            this.cHj = this.cHo.getAppSid();
            this.cHk = this.cHo.asM();
        }
    }

    public String asP() {
        HashMap<String, String> asQ = asQ();
        asQ.putAll(asO());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cHb, asQ);
    }

    private HashMap<String, String> asQ() {
        b.a akP;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + aqJ());
            hashMap.put("n", this.cHl);
            hashMap.put("pk", this.cHk);
            hashMap.put("appid", this.cHj);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + asR());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.cFQ);
            hashMap.put("chid", "0");
            String apr = ai.apr();
            if (apr.equals("0")) {
                apr = "";
            }
            hashMap.put("imei", apr);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.abS().aS(com.baidu.swan.apps.w.a.abN()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cHn);
            hashMap.put("rpt", this.cHm);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
            if (akN != null && (akP = akN.akP()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, akP.adA());
                JSONObject adk = akP.adk();
                if (adk != null) {
                    hashMap.put("eqid", adk.optString(cHg, ""));
                }
                JSONObject adS = akP.adS();
                if (adS != null) {
                    if (adS.has(cHd) && (jSONObject = adS.getJSONObject(cHd)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cHf.equals(next)) {
                                    hashMap.put(cHe, optString);
                                } else {
                                    hashMap.put(cHc + next, optString);
                                }
                            }
                        }
                    }
                    if (adS.has(cHh) && (optJSONArray = adS.optJSONArray(cHh)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cHi, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.acy().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aqJ() {
        switch (SwanAppNetworkUtils.ahh()) {
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

    private String asR() {
        try {
            String apr = ai.apr();
            return TextUtils.isEmpty(apr) ? ai.getWifiInfo(this.mContext) : apr;
        } catch (Exception e) {
            return "";
        }
    }
}
