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
    private static String dkW = "ug_";
    private static String dkX = "ug_business";
    private static String dkY = "ctkey";
    private static String dkZ = "CTK";
    private static String dla = "eqid";
    private static String dlb = "sid_eid";
    private static String dlc = "exps";
    private String diF;
    private String dld;
    private String dle;
    public b dli;
    private String dlj;
    protected Context mContext;
    private String dkV = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dlf = "1";
    private String dlg = "2";
    private String dlh = "8.800201";

    protected abstract String aJi();

    protected abstract HashMap<String, String> aJj();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dli = bVar;
        if (this.dli != null) {
            this.diF = this.dli.aJf();
            this.dld = this.dli.getAppSid();
            this.dle = this.dli.aJg();
        }
        if (!ak.aFn()) {
            this.dlj = com.baidu.swan.game.ad.d.e.aJo();
        }
    }

    public String aJk() {
        HashMap<String, String> aJl = aJl();
        aJl.putAll(aJj());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dkV, aJl);
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
            hashMap.put("n", this.dlf);
            hashMap.put("pk", this.dle);
            hashMap.put("appid", this.dld);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.diF);
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
            hashMap.put(IXAdRequestInfo.P_VER, this.dlh);
            hashMap.put("rpt", this.dlg);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
            String aJi = aJi();
            hashMap.put(dlc, aJi);
            if (azJ != null && (azM = azJ.azM()) != null) {
                hashMap.put("scene", azM.aqN());
                JSONObject aqw = azM.aqw();
                if (aqw != null) {
                    hashMap.put("eqid", aqw.optString(dla, ""));
                }
                JSONObject arf = azM.arf();
                if (arf != null) {
                    if (arf.has(dkX) && (jSONObject = arf.getJSONObject(dkX)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dkZ.equals(next)) {
                                    hashMap.put(dkY, optString);
                                    this.dlj = optString;
                                } else {
                                    hashMap.put(dkW + next, optString);
                                }
                            }
                        }
                    }
                    if (arf.has(dlb) && (optJSONArray = arf.optJSONArray(dlb)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(dlc, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dkZ) && !TextUtils.isEmpty(this.dlj)) {
                hashMap.put(dkZ, this.dlj);
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
        return this.dlj;
    }
}
