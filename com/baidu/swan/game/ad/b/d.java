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
/* loaded from: classes14.dex */
public abstract class d {
    private static String dWT = "ug_";
    private static String dWU = "ug_business";
    private static String dWV = "ctkey";
    private static String dWW = "CTK";
    private static String dWX = "eqid";
    private static String dWY = "sid_eid";
    private static String dWZ = "exps";
    private String dUD;
    private String dXa;
    private String dXb;
    public b dXf;
    private String dXg;
    protected Context mContext;
    private String dWS = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dXc = "1";
    private String dXd = "2";
    private String dXe = "8.800201";

    protected abstract String aRU();

    protected abstract HashMap<String, String> aRV();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dXf = bVar;
        if (this.dXf != null) {
            this.dUD = this.dXf.aRR();
            this.dXa = this.dXf.getAppSid();
            this.dXb = this.dXf.aRS();
        }
        if (!ak.aNW()) {
            this.dXg = com.baidu.swan.game.ad.d.e.aSa();
        }
    }

    public String aRW() {
        HashMap<String, String> aRX = aRX();
        aRX.putAll(aRV());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dWS, aRX);
    }

    protected String aCG() {
        return com.baidu.swan.apps.t.a.awX().aia().getCookie(".baidu.com");
    }

    private HashMap<String, String> aRX() {
        String str;
        b.a aIv;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aPF());
            hashMap.put("n", this.dXc);
            hashMap.put("pk", this.dXb);
            hashMap.put("appid", this.dXa);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", HttpConstants.OS_TYPE_VALUE);
            hashMap.put("apid", "" + this.dUD);
            hashMap.put("chid", "0");
            String aNV = ak.aNV();
            if (aNV.equals("0")) {
                aNV = "";
            }
            hashMap.put("imei", aNV);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.awD().cc(com.baidu.swan.apps.t.a.awy()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.alj());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(aCG(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dXe);
            hashMap.put("rpt", this.dXd);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
            String aRU = aRU();
            hashMap.put(dWZ, aRU);
            if (aIs != null && (aIv = aIs.aIv()) != null) {
                hashMap.put("scene", aIv.ayC());
                JSONObject ayl = aIv.ayl();
                if (ayl != null) {
                    hashMap.put("eqid", ayl.optString(dWX, ""));
                }
                JSONObject ayU = aIv.ayU();
                if (ayU != null) {
                    if (ayU.has(dWU) && (jSONObject = ayU.getJSONObject(dWU)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dWW.equals(next)) {
                                    hashMap.put(dWV, optString);
                                    this.dXg = optString;
                                } else {
                                    hashMap.put(dWT + next, optString);
                                }
                            }
                        }
                    }
                    if (ayU.has(dWY) && (optJSONArray = ayU.optJSONArray(dWY)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aRU)) {
                            sb.append(aRU + ",");
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
                            hashMap.put(dWZ, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dWW) && !TextUtils.isEmpty(this.dXg)) {
                hashMap.put(dWW, this.dXg);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.axk().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aPF() {
        switch (SwanAppNetworkUtils.aCJ()) {
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
            String aNV = ak.aNV();
            return TextUtils.isEmpty(aNV) ? ak.getWifiInfo(this.mContext) : aNV;
        } catch (Exception e) {
            return "";
        }
    }

    public String aRY() {
        return this.dXg;
    }
}
