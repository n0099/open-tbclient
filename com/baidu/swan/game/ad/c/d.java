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
/* loaded from: classes10.dex */
public abstract class d {
    private static String cdK = "ug_";
    private static String cdL = "ug_business";
    private static String cdM = "ctkey";
    private static String cdN = "CTK";
    private static String cdO = "eqid";
    private static String cdP = "sid_eid";
    private static String cdQ = "exps";
    private String ccv;
    private String cdR;
    private String cdS;
    public b cdW;
    protected Context mContext;
    private String cdJ = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cdT = "1";
    private String cdU = "2";
    private String cdV = "8.800201";

    protected abstract HashMap<String, String> aik();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cdW = bVar;
        if (this.cdW != null) {
            this.ccv = this.cdW.aih();
            this.cdR = this.cdW.getAppSid();
            this.cdS = this.cdW.aii();
        }
    }

    public String ail() {
        HashMap<String, String> aim = aim();
        aim.putAll(aik());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.cdJ, aim);
    }

    private HashMap<String, String> aim() {
        b.a aas;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + agj());
            hashMap.put("n", this.cdT);
            hashMap.put("pk", this.cdS);
            hashMap.put("appid", this.cdR);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.ccv);
            hashMap.put("chid", "0");
            String aeR = ai.aeR();
            if (aeR.equals("0")) {
                aeR = "";
            }
            hashMap.put("imei", aeR);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.RL().bn(com.baidu.swan.apps.w.a.RG()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cdV);
            hashMap.put("rpt", this.cdU);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e aaq = com.baidu.swan.apps.runtime.e.aaq();
            if (aaq != null && (aas = aaq.aas()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, aas.Tt());
                JSONObject Td = aas.Td();
                if (Td != null) {
                    hashMap.put("eqid", Td.optString(cdO, ""));
                }
                JSONObject TL = aas.TL();
                if (TL != null) {
                    if (TL.has(cdL) && (jSONObject = TL.getJSONObject(cdL)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cdN.equals(next)) {
                                    hashMap.put(cdM, optString);
                                } else {
                                    hashMap.put(cdK + next, optString);
                                }
                            }
                        }
                    }
                    if (TL.has(cdP) && (optJSONArray = TL.optJSONArray(cdP)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cdQ, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.Sr().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int agj() {
        switch (SwanAppNetworkUtils.WJ()) {
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
            String aeR = ai.aeR();
            return TextUtils.isEmpty(aeR) ? ai.getWifiInfo(this.mContext) : aeR;
        } catch (Exception e) {
            return "";
        }
    }
}
