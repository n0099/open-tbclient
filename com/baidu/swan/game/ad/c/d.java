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
    private static String cRm = "ug_";
    private static String cRn = "ug_business";
    private static String cRo = "ctkey";
    private static String cRp = "CTK";
    private static String cRq = "eqid";
    private static String cRr = "sid_eid";
    private static String cRs = "exps";
    private String cQa;
    private String cRt;
    private String cRu;
    public b cRy;
    protected Context mContext;
    private String cRl = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cRv = "1";
    private String cRw = "2";
    private String cRx = "8.800201";

    protected abstract HashMap<String, String> awv();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cRy = bVar;
        if (this.cRy != null) {
            this.cQa = this.cRy.aws();
            this.cRt = this.cRy.getAppSid();
            this.cRu = this.cRy.awt();
        }
    }

    public String aww() {
        HashMap<String, String> awx = awx();
        awx.putAll(awv());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cRl, awx);
    }

    private HashMap<String, String> awx() {
        b.a aoJ;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ag.getDisplayWidth(this.mContext) / ag.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ag.getDisplayHeight(this.mContext) / ag.getDensity(this.mContext))));
            hashMap.put("net", "" + auQ());
            hashMap.put("n", this.cRv);
            hashMap.put("pk", this.cRu);
            hashMap.put("appid", this.cRt);
            hashMap.put("sw", "" + ag.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ag.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + awy());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.cQa);
            hashMap.put("chid", "0");
            String atR = aj.atR();
            if (atR.equals("0")) {
                atR = "";
            }
            hashMap.put("imei", atR);
            hashMap.put("cuid", com.baidu.swan.apps.u.a.aeW().bc(com.baidu.swan.apps.u.a.aeR()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cRx);
            hashMap.put("rpt", this.cRw);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
            if (aoG != null && (aoJ = aoG.aoJ()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, aoJ.agK());
                JSONObject agu = aoJ.agu();
                if (agu != null) {
                    hashMap.put("eqid", agu.optString(cRq, ""));
                }
                JSONObject ahc = aoJ.ahc();
                if (ahc != null) {
                    if (ahc.has(cRn) && (jSONObject = ahc.getJSONObject(cRn)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cRp.equals(next)) {
                                    hashMap.put(cRo, optString);
                                } else {
                                    hashMap.put(cRm + next, optString);
                                }
                            }
                        }
                    }
                    if (ahc.has(cRr) && (optJSONArray = ahc.optJSONArray(cRr)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cRs, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.u.a.afB().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int auQ() {
        switch (SwanAppNetworkUtils.akA()) {
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

    private String awy() {
        try {
            String atR = aj.atR();
            return TextUtils.isEmpty(atR) ? aj.getWifiInfo(this.mContext) : atR;
        } catch (Exception e) {
            return "";
        }
    }
}
