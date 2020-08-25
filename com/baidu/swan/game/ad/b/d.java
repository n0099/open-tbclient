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
/* loaded from: classes19.dex */
public abstract class d {
    private static String dkS = "ug_";
    private static String dkT = "ug_business";
    private static String dkU = "ctkey";
    private static String dkV = "CTK";
    private static String dkW = "eqid";
    private static String dkX = "sid_eid";
    private static String dkY = "exps";
    private String diB;
    private String dkZ;
    private String dla;
    public b dle;
    private String dlf;
    protected Context mContext;
    private String dkR = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dlb = "1";
    private String dlc = "2";
    private String dld = "8.800201";

    protected abstract String aJi();

    protected abstract HashMap<String, String> aJj();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dle = bVar;
        if (this.dle != null) {
            this.diB = this.dle.aJf();
            this.dkZ = this.dle.getAppSid();
            this.dla = this.dle.aJg();
        }
        if (!ak.aFn()) {
            this.dlf = com.baidu.swan.game.ad.d.e.aJo();
        }
    }

    public String aJk() {
        HashMap<String, String> aJl = aJl();
        aJl.putAll(aJj());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dkR, aJl);
    }

    protected String auQ() {
        return com.baidu.swan.apps.t.a.apj().aau().getCookie(".baidu.com");
    }

    private HashMap<String, String> aJl() {
        String str;
        b.a azM;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aGT());
            hashMap.put("n", this.dlb);
            hashMap.put("pk", this.dla);
            hashMap.put("appid", this.dkZ);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.diB);
            hashMap.put("chid", "0");
            String aFm = ak.aFm();
            if (aFm.equals("0")) {
                aFm = "";
            }
            hashMap.put("imei", aFm);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.aoO().bl(com.baidu.swan.apps.t.a.aoJ()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.adC());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(auQ(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dld);
            hashMap.put("rpt", this.dlc);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            String aJi = aJi();
            hashMap.put(dkY, aJi);
            if (azJ != null && (azM = azJ.azM()) != null) {
                hashMap.put("scene", azM.aqN());
                JSONObject aqw = azM.aqw();
                if (aqw != null) {
                    hashMap.put("eqid", aqw.optString(dkW, ""));
                }
                JSONObject arf = azM.arf();
                if (arf != null) {
                    if (arf.has(dkT) && (jSONObject = arf.getJSONObject(dkT)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dkV.equals(next)) {
                                    hashMap.put(dkU, optString);
                                    this.dlf = optString;
                                } else {
                                    hashMap.put(dkS + next, optString);
                                }
                            }
                        }
                    }
                    if (arf.has(dkX) && (optJSONArray = arf.optJSONArray(dkX)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aJi)) {
                            sb.append(aJi + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(dkY, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dkV) && !TextUtils.isEmpty(this.dlf)) {
                hashMap.put(dkV, this.dlf);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.apw().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aGT() {
        switch (SwanAppNetworkUtils.auT()) {
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
            String aFm = ak.aFm();
            return TextUtils.isEmpty(aFm) ? ak.getWifiInfo(this.mContext) : aFm;
        } catch (Exception e) {
            return "";
        }
    }

    public String aJm() {
        return this.dlf;
    }
}
