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
    private static String cGW = "ug_";
    private static String cGX = "ug_business";
    private static String cGY = "ctkey";
    private static String cGZ = "CTK";
    private static String cHa = "eqid";
    private static String cHb = "sid_eid";
    private static String cHc = "exps";
    private String cFK;
    private String cHd;
    private String cHe;
    public b cHi;
    protected Context mContext;
    private String cGV = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cHf = "1";
    private String cHg = "2";
    private String cHh = "8.800201";

    protected abstract HashMap<String, String> asP();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cHi = bVar;
        if (this.cHi != null) {
            this.cFK = this.cHi.asM();
            this.cHd = this.cHi.getAppSid();
            this.cHe = this.cHi.asN();
        }
    }

    public String asQ() {
        HashMap<String, String> asR = asR();
        asR.putAll(asP());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cGV, asR);
    }

    private HashMap<String, String> asR() {
        b.a akQ;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + aqK());
            hashMap.put("n", this.cHf);
            hashMap.put("pk", this.cHe);
            hashMap.put("appid", this.cHd);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.cFK);
            hashMap.put("chid", "0");
            String aps = ai.aps();
            if (aps.equals("0")) {
                aps = "";
            }
            hashMap.put("imei", aps);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.abT().be(com.baidu.swan.apps.w.a.abO()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cHh);
            hashMap.put("rpt", this.cHg);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e akO = com.baidu.swan.apps.runtime.e.akO();
            if (akO != null && (akQ = akO.akQ()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, akQ.adB());
                JSONObject adl = akQ.adl();
                if (adl != null) {
                    hashMap.put("eqid", adl.optString(cHa, ""));
                }
                JSONObject adT = akQ.adT();
                if (adT != null) {
                    if (adT.has(cGX) && (jSONObject = adT.getJSONObject(cGX)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cGZ.equals(next)) {
                                    hashMap.put(cGY, optString);
                                } else {
                                    hashMap.put(cGW + next, optString);
                                }
                            }
                        }
                    }
                    if (adT.has(cHb) && (optJSONArray = adT.optJSONArray(cHb)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cHc, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.acz().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aqK() {
        switch (SwanAppNetworkUtils.ahi()) {
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
            String aps = ai.aps();
            return TextUtils.isEmpty(aps) ? ai.getWifiInfo(this.mContext) : aps;
        } catch (Exception e) {
            return "";
        }
    }
}
