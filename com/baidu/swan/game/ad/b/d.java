package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.u.c.b;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class d {
    private static String daI = "ug_";
    private static String daJ = "ug_business";
    private static String daK = "ctkey";
    private static String daL = "CTK";
    private static String daM = "eqid";
    private static String daN = "sid_eid";
    private static String daO = "exps";
    private String cZn;
    private String daP;
    private String daQ;
    public b daU;
    private String daV;
    protected Context mContext;
    private String daH = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String daR = "1";
    private String daS = "2";
    private String daT = "8.800201";

    protected abstract String aAy();

    protected abstract HashMap<String, String> aAz();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.daU = bVar;
        if (this.daU != null) {
            this.cZn = this.daU.aAv();
            this.daP = this.daU.getAppSid();
            this.daQ = this.daU.aAw();
        }
        if (!al.axe()) {
            this.daV = com.baidu.swan.game.ad.d.e.aAF();
        }
    }

    public String aAA() {
        HashMap<String, String> aAB = aAB();
        aAB.putAll(aAz());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.daH, aAB);
    }

    protected String amT() {
        return com.baidu.swan.apps.t.a.ahH().Us().getCookie(".baidu.com");
    }

    private HashMap<String, String> aAB() {
        String str;
        b.a arz;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ai.getDisplayWidth(this.mContext) / ai.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ai.getDisplayHeight(this.mContext) / ai.getDensity(this.mContext))));
            hashMap.put("net", "" + ayK());
            hashMap.put("n", this.daR);
            hashMap.put("pk", this.daQ);
            hashMap.put("appid", this.daP);
            hashMap.put("sw", "" + ai.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ai.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + aAC());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.cZn);
            hashMap.put("chid", "0");
            String axd = al.axd();
            if (axd.equals("0")) {
                axd = "";
            }
            hashMap.put("imei", axd);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.aho().bf(com.baidu.swan.apps.t.a.ahj()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.h.c.Xw());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.h.c.getDeviceModel());
            hashMap.put("v", al.getVersionName());
            String cookieValue = aj.getCookieValue(amT(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.daT);
            hashMap.put("rpt", this.daS);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
            String aAy = aAy();
            hashMap.put(daO, aAy);
            if (arw != null && (arz = arw.arz()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, arz.ajg());
                JSONObject aiQ = arz.aiQ();
                if (aiQ != null) {
                    hashMap.put("eqid", aiQ.optString(daM, ""));
                }
                JSONObject ajy = arz.ajy();
                if (ajy != null) {
                    if (ajy.has(daJ) && (jSONObject = ajy.getJSONObject(daJ)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (daL.equals(next)) {
                                    hashMap.put(daK, optString);
                                    this.daV = optString;
                                } else {
                                    hashMap.put(daI + next, optString);
                                }
                            }
                        }
                    }
                    if (ajy.has(daN) && (optJSONArray = ajy.optJSONArray(daN)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aAy)) {
                            sb.append(aAy + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(daO, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(daL) && !TextUtils.isEmpty(this.daV)) {
                hashMap.put(daL, this.daV);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.ahU().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int ayK() {
        switch (SwanAppNetworkUtils.amW()) {
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

    private String aAC() {
        try {
            String axd = al.axd();
            return TextUtils.isEmpty(axd) ? al.getWifiInfo(this.mContext) : axd;
        } catch (Exception e) {
            return "";
        }
    }

    public String aAD() {
        return this.daV;
    }
}
