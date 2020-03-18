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
/* loaded from: classes11.dex */
public abstract class d {
    private static String cia = "ug_";
    private static String cib = "ug_business";
    private static String cic = "ctkey";
    private static String cie = "CTK";
    private static String cif = "eqid";
    private static String cig = "sid_eid";
    private static String cih = "exps";
    private String cgM;
    private String cii;
    private String cij;
    public b cin;
    protected Context mContext;
    private String chZ = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String cik = "1";
    private String cil = "2";
    private String cim = "8.800201";

    protected abstract HashMap<String, String> akD();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cin = bVar;
        if (this.cin != null) {
            this.cgM = this.cin.akA();
            this.cii = this.cin.getAppSid();
            this.cij = this.cin.akB();
        }
    }

    public String akE() {
        HashMap<String, String> akF = akF();
        akF.putAll(akD());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.chZ, akF);
    }

    private HashMap<String, String> akF() {
        b.a acL;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + aiC());
            hashMap.put("n", this.cik);
            hashMap.put("pk", this.cij);
            hashMap.put("appid", this.cii);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.cgM);
            hashMap.put("chid", "0");
            String ahk = ai.ahk();
            if (ahk.equals("0")) {
                ahk = "";
            }
            hashMap.put("imei", ahk);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.Ue().bq(com.baidu.swan.apps.w.a.TZ()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cim);
            hashMap.put("rpt", this.cil);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e acJ = com.baidu.swan.apps.runtime.e.acJ();
            if (acJ != null && (acL = acJ.acL()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, acL.VM());
                JSONObject Vw = acL.Vw();
                if (Vw != null) {
                    hashMap.put("eqid", Vw.optString(cif, ""));
                }
                JSONObject We = acL.We();
                if (We != null) {
                    if (We.has(cib) && (jSONObject = We.getJSONObject(cib)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (cie.equals(next)) {
                                    hashMap.put(cic, optString);
                                } else {
                                    hashMap.put(cia + next, optString);
                                }
                            }
                        }
                    }
                    if (We.has(cig) && (optJSONArray = We.optJSONArray(cig)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(cih, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.UK().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aiC() {
        switch (SwanAppNetworkUtils.Zc()) {
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
            String ahk = ai.ahk();
            return TextUtils.isEmpty(ahk) ? ai.getWifiInfo(this.mContext) : ahk;
        } catch (Exception e) {
            return "";
        }
    }
}
