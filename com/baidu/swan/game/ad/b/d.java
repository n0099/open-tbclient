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
/* loaded from: classes14.dex */
public abstract class d {
    private static String dze = "ug_";
    private static String dzf = "ug_business";
    private static String dzg = "ctkey";
    private static String dzh = "CTK";
    private static String dzi = "eqid";
    private static String dzj = "sid_eid";
    private static String dzk = "exps";
    private String dwN;
    private String dzl;
    private String dzm;
    public b dzq;
    private String dzr;
    protected Context mContext;
    private String dzd = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dzn = "1";
    private String dzo = "2";
    private String dzp = "8.800201";

    protected abstract String aMC();

    protected abstract HashMap<String, String> aMD();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dzq = bVar;
        if (this.dzq != null) {
            this.dwN = this.dzq.aMz();
            this.dzl = this.dzq.getAppSid();
            this.dzm = this.dzq.aMA();
        }
        if (!ak.aIG()) {
            this.dzr = com.baidu.swan.game.ad.d.e.aMI();
        }
    }

    public String aME() {
        HashMap<String, String> aMF = aMF();
        aMF.putAll(aMD());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dzd, aMF);
    }

    protected String ayk() {
        return com.baidu.swan.apps.t.a.asF().adP().getCookie(".baidu.com");
    }

    private HashMap<String, String> aMF() {
        String str;
        b.a aDe;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aKm());
            hashMap.put("n", this.dzn);
            hashMap.put("pk", this.dzm);
            hashMap.put("appid", this.dzl);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dwN);
            hashMap.put("chid", "0");
            String aIF = ak.aIF();
            if (aIF.equals("0")) {
                aIF = "";
            }
            hashMap.put("imei", aIF);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.ask().bq(com.baidu.swan.apps.t.a.asf()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.agX());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(ayk(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dzp);
            hashMap.put("rpt", this.dzo);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
            String aMC = aMC();
            hashMap.put(dzk, aMC);
            if (aDb != null && (aDe = aDb.aDe()) != null) {
                hashMap.put("scene", aDe.auj());
                JSONObject atS = aDe.atS();
                if (atS != null) {
                    hashMap.put("eqid", atS.optString(dzi, ""));
                }
                JSONObject auB = aDe.auB();
                if (auB != null) {
                    if (auB.has(dzf) && (jSONObject = auB.getJSONObject(dzf)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dzh.equals(next)) {
                                    hashMap.put(dzg, optString);
                                    this.dzr = optString;
                                } else {
                                    hashMap.put(dze + next, optString);
                                }
                            }
                        }
                    }
                    if (auB.has(dzj) && (optJSONArray = auB.optJSONArray(dzj)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aMC)) {
                            sb.append(aMC + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(dzk, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dzh) && !TextUtils.isEmpty(this.dzr)) {
                hashMap.put(dzh, this.dzr);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.asS().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aKm() {
        switch (SwanAppNetworkUtils.ayn()) {
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
            String aIF = ak.aIF();
            return TextUtils.isEmpty(aIF) ? ak.getWifiInfo(this.mContext) : aIF;
        } catch (Exception e) {
            return "";
        }
    }

    public String aMG() {
        return this.dzr;
    }
}
