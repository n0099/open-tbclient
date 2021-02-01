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
    private static String dYZ = "ug_";
    private static String dZa = "ug_business";
    private static String dZb = "ctkey";
    private static String dZc = "CTK";
    private static String dZd = "eqid";
    private static String dZe = "sid_eid";
    private static String dZf = "exps";
    private String dWJ;
    private String dZg;
    private String dZh;
    public b dZl;
    private String dZm;
    protected Context mContext;
    private String dYY = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dZi = "1";
    private String dZj = "2";
    private String dZk = "8.800201";

    protected abstract String aSg();

    protected abstract HashMap<String, String> aSh();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dZl = bVar;
        if (this.dZl != null) {
            this.dWJ = this.dZl.getAdPlaceId();
            this.dZg = this.dZl.getAppSid();
            this.dZh = this.dZl.aSe();
        }
        if (!ak.aOp()) {
            this.dZm = com.baidu.swan.game.ad.d.e.aSm();
        }
    }

    public String aSi() {
        HashMap<String, String> aSj = aSj();
        aSj.putAll(aSh());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dYY, aSj);
    }

    protected String aDc() {
        return com.baidu.swan.apps.t.a.axv().aiy().getCookie(".baidu.com");
    }

    private HashMap<String, String> aSj() {
        String str;
        b.a aIO;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aPY());
            hashMap.put("n", this.dZi);
            hashMap.put("pk", this.dZh);
            hashMap.put("appid", this.dZg);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put("sh", "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put("apid", "" + this.dWJ);
            hashMap.put("chid", "0");
            String aOo = ak.aOo();
            if (aOo.equals("0")) {
                aOo = "";
            }
            hashMap.put("imei", aOo);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.axb().cb(com.baidu.swan.apps.t.a.awW()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.alH());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put("app_ver", ak.getVersionName());
            String cookieValue = ai.getCookieValue(aDc(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dZk);
            hashMap.put("rpt", this.dZj);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
            String aSg = aSg();
            hashMap.put(dZf, aSg);
            if (aIL != null && (aIO = aIL.aIO()) != null) {
                hashMap.put("scene", aIO.aza());
                JSONObject ayJ = aIO.ayJ();
                if (ayJ != null) {
                    hashMap.put("eqid", ayJ.optString(dZd, ""));
                }
                JSONObject azs = aIO.azs();
                if (azs != null) {
                    if (azs.has(dZa) && (jSONObject = azs.getJSONObject(dZa)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dZc.equals(next)) {
                                    hashMap.put(dZb, optString);
                                    this.dZm = optString;
                                } else {
                                    hashMap.put(dYZ + next, optString);
                                }
                            }
                        }
                    }
                    if (azs.has(dZe) && (optJSONArray = azs.optJSONArray(dZe)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aSg)) {
                            sb.append(aSg + ",");
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
                            hashMap.put(dZf, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dZc) && !TextUtils.isEmpty(this.dZm)) {
                hashMap.put(dZc, this.dZm);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.axI().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aPY() {
        switch (SwanAppNetworkUtils.aDf()) {
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
            String aOo = ak.aOo();
            return TextUtils.isEmpty(aOo) ? ak.getWifiInfo(this.mContext) : aOo;
        } catch (Exception e) {
            return "";
        }
    }

    public String aSk() {
        return this.dZm;
    }
}
