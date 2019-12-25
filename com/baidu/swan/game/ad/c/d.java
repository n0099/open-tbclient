package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.searchbox.ui.animview.praise.PraiseDataPassUtil;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.x.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class d {
    private String cci;
    private String cdE;
    private String cdF;
    public b cdJ;
    protected Context mContext;
    private static String cdx = "ug_";
    private static String cdy = "ug_business";
    private static String cdz = "ctkey";
    private static String cdA = "CTK";
    private static String cdB = "eqid";
    private static String cdC = "sid_eid";
    private static String cdD = "exps";
    private String cdw = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cdG = "1";
    private String cdH = "2";
    private String cdI = "8.800201";

    protected abstract HashMap<String, String> ahR();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cdJ = bVar;
        if (this.cdJ != null) {
            this.cci = this.cdJ.ahO();
            this.cdE = this.cdJ.getAppSid();
            this.cdF = this.cdJ.ahP();
        }
    }

    public String ahS() {
        HashMap<String, String> ahT = ahT();
        ahT.putAll(ahR());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cdw, ahT);
    }

    private HashMap<String, String> ahT() {
        b.a ZV;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + afQ());
            hashMap.put("n", this.cdG);
            hashMap.put("pk", this.cdF);
            hashMap.put("appid", this.cdE);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.cci);
            hashMap.put("chid", "0");
            String aey = ai.aey();
            if (aey.equals("0")) {
                aey = "";
            }
            hashMap.put("imei", aey);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.Rp().bn(com.baidu.swan.apps.w.a.Rk()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cdI);
            hashMap.put("rpt", this.cdH);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e ZT = com.baidu.swan.apps.runtime.e.ZT();
            if (ZT != null && (ZV = ZT.ZV()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, ZV.SW());
                JSONObject SG = ZV.SG();
                if (SG != null) {
                    hashMap.put("eqid", SG.optString(cdB, ""));
                }
                JSONObject To = ZV.To();
                if (To != null) {
                    if (To.has(cdy) && (jSONObject = To.getJSONObject(cdy)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cdA.equals(next)) {
                                    hashMap.put(cdz, optString);
                                } else {
                                    hashMap.put(cdx + next, optString);
                                }
                            }
                        }
                    }
                    if (To.has(cdC) && (optJSONArray = To.optJSONArray(cdC)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cdD, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.RV().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int afQ() {
        switch (SwanAppNetworkUtils.Wm()) {
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
            String aey = ai.aey();
            return TextUtils.isEmpty(aey) ? ai.getWifiInfo(this.mContext) : aey;
        } catch (Exception e) {
            return "";
        }
    }
}
