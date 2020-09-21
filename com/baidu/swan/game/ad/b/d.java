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
/* loaded from: classes10.dex */
public abstract class d {
    private static String dmY = "ug_";
    private static String dmZ = "ug_business";
    private static String dna = "ctkey";
    private static String dnb = "CTK";
    private static String dnc = "eqid";
    private static String dnd = "sid_eid";
    private static String dne = "exps";
    private String dkH;
    private String dnf;
    private String dng;
    public b dnk;
    private String dnl;
    protected Context mContext;
    private String dmX = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String dnh = "1";
    private String dni = "2";
    private String dnj = "8.800201";

    protected abstract String aJT();

    protected abstract HashMap<String, String> aJU();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.dnk = bVar;
        if (this.dnk != null) {
            this.dkH = this.dnk.aJQ();
            this.dnf = this.dnk.getAppSid();
            this.dng = this.dnk.aJR();
        }
        if (!ak.aFX()) {
            this.dnl = com.baidu.swan.game.ad.d.e.aJZ();
        }
    }

    public String aJV() {
        HashMap<String, String> aJW = aJW();
        aJW.putAll(aJU());
        return com.baidu.swan.game.ad.d.c.getRequestAdUrl(this.dmX, aJW);
    }

    protected String avz() {
        return com.baidu.swan.apps.t.a.apT().abd().getCookie(".baidu.com");
    }

    private HashMap<String, String> aJW() {
        String str;
        b.a aAv;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(ah.getDisplayWidth(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(ah.getDisplayHeight(this.mContext) / ah.getDensity(this.mContext))));
            hashMap.put("net", "" + aHD());
            hashMap.put("n", this.dnh);
            hashMap.put("pk", this.dng);
            hashMap.put("appid", this.dnf);
            hashMap.put("sw", "" + ah.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + ah.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.dkH);
            hashMap.put("chid", "0");
            String aFW = ak.aFW();
            if (aFW.equals("0")) {
                aFW = "";
            }
            hashMap.put("imei", aFW);
            hashMap.put("cuid", com.baidu.swan.apps.t.a.apz().bk(com.baidu.swan.apps.t.a.apu()));
            hashMap.put(IXAdRequestInfo.OSV, com.baidu.swan.apps.i.c.aem());
            hashMap.put(IXAdRequestInfo.PHONE_TYPE, com.baidu.swan.apps.i.c.getDeviceModel());
            hashMap.put(IXAdRequestInfo.APP_VERSION_NAME, ak.getVersionName());
            String cookieValue = ai.getCookieValue(avz(), "BAIDUID");
            if (!TextUtils.isEmpty(cookieValue) && cookieValue.split(":").length > 0) {
                str = cookieValue.split(":")[0];
            } else {
                str = "";
            }
            hashMap.put(ETAG.KEY_BAIDU_ID, str);
            hashMap.put(IXAdRequestInfo.P_VER, this.dnj);
            hashMap.put("rpt", this.dni);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
            String aJT = aJT();
            hashMap.put(dne, aJT);
            if (aAs != null && (aAv = aAs.aAv()) != null) {
                hashMap.put("scene", aAv.arx());
                JSONObject arg = aAv.arg();
                if (arg != null) {
                    hashMap.put("eqid", arg.optString(dnc, ""));
                }
                JSONObject arP = aAv.arP();
                if (arP != null) {
                    if (arP.has(dmZ) && (jSONObject = arP.getJSONObject(dmZ)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (dnb.equals(next)) {
                                    hashMap.put(dna, optString);
                                    this.dnl = optString;
                                } else {
                                    hashMap.put(dmY + next, optString);
                                }
                            }
                        }
                    }
                    if (arP.has(dnd) && (optJSONArray = arP.optJSONArray(dnd)) != null && optJSONArray.length() > 0) {
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(aJT)) {
                            sb.append(aJT + Constants.ACCEPT_TIME_SEPARATOR_SP);
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
                            hashMap.put(dne, sb.toString());
                        }
                    }
                }
            }
            if (!hashMap.containsKey(dnb) && !TextUtils.isEmpty(this.dnl)) {
                hashMap.put(dnb, this.dnl);
            }
            hashMap.put("con_name", com.baidu.swan.apps.t.a.aqg().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aHD() {
        switch (SwanAppNetworkUtils.avC()) {
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
            String aFW = ak.aFW();
            return TextUtils.isEmpty(aFW) ? ak.getWifiInfo(this.mContext) : aFW;
        } catch (Exception e) {
            return "";
        }
    }

    public String aJX() {
        return this.dnl;
    }
}
