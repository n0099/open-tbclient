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
    private static String chO = "ug_";
    private static String chP = "ug_business";
    private static String chQ = "ctkey";
    private static String chR = "CTK";
    private static String chS = "eqid";
    private static String chT = "sid_eid";
    private static String chU = "exps";
    private String cgA;
    private String chV;
    private String chW;
    public b cia;
    protected Context mContext;
    private String chN = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String chX = "1";
    private String chY = "2";
    private String chZ = "8.800201";

    protected abstract HashMap<String, String> akA();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cia = bVar;
        if (this.cia != null) {
            this.cgA = this.cia.akx();
            this.chV = this.cia.getAppSid();
            this.chW = this.cia.aky();
        }
    }

    public String akB() {
        HashMap<String, String> akC = akC();
        akC.putAll(akA());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.chN, akC);
    }

    private HashMap<String, String> akC() {
        b.a acI;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + aiz());
            hashMap.put("n", this.chX);
            hashMap.put("pk", this.chW);
            hashMap.put("appid", this.chV);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.cgA);
            hashMap.put("chid", "0");
            String ahh = ai.ahh();
            if (ahh.equals("0")) {
                ahh = "";
            }
            hashMap.put("imei", ahh);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW()));
            hashMap.put(IXAdRequestInfo.P_VER, this.chZ);
            hashMap.put("rpt", this.chY);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
            if (acG != null && (acI = acG.acI()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, acI.VJ());
                JSONObject Vt = acI.Vt();
                if (Vt != null) {
                    hashMap.put("eqid", Vt.optString(chS, ""));
                }
                JSONObject Wb = acI.Wb();
                if (Wb != null) {
                    if (Wb.has(chP) && (jSONObject = Wb.getJSONObject(chP)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (chR.equals(next)) {
                                    hashMap.put(chQ, optString);
                                } else {
                                    hashMap.put(chO + next, optString);
                                }
                            }
                        }
                    }
                    if (Wb.has(chT) && (optJSONArray = Wb.optJSONArray(chT)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(chU, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.UH().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aiz() {
        switch (SwanAppNetworkUtils.YZ()) {
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
            String ahh = ai.ahh();
            return TextUtils.isEmpty(ahh) ? ai.getWifiInfo(this.mContext) : ahh;
        } catch (Exception e) {
            return "";
        }
    }
}
