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
    private static String chP = "ug_";
    private static String chQ = "ug_business";
    private static String chR = "ctkey";
    private static String chS = "CTK";
    private static String chT = "eqid";
    private static String chU = "sid_eid";
    private static String chV = "exps";
    private String cgB;
    private String chW;
    private String chX;
    public b cib;
    protected Context mContext;
    private String chO = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String chY = "1";
    private String chZ = "2";
    private String cia = "8.800201";

    protected abstract HashMap<String, String> akA();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.cib = bVar;
        if (this.cib != null) {
            this.cgB = this.cib.akx();
            this.chW = this.cib.getAppSid();
            this.chX = this.cib.aky();
        }
    }

    public String akB() {
        HashMap<String, String> akC = akC();
        akC.putAll(akA());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.chO, akC);
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
            hashMap.put("n", this.chY);
            hashMap.put("pk", this.chX);
            hashMap.put("appid", this.chW);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.cgB);
            hashMap.put("chid", "0");
            String ahh = ai.ahh();
            if (ahh.equals("0")) {
                ahh = "";
            }
            hashMap.put("imei", ahh);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.Ub().br(com.baidu.swan.apps.w.a.TW()));
            hashMap.put(IXAdRequestInfo.P_VER, this.cia);
            hashMap.put("rpt", this.chZ);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
            if (acG != null && (acI = acG.acI()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, acI.VJ());
                JSONObject Vt = acI.Vt();
                if (Vt != null) {
                    hashMap.put("eqid", Vt.optString(chT, ""));
                }
                JSONObject Wb = acI.Wb();
                if (Wb != null) {
                    if (Wb.has(chQ) && (jSONObject = Wb.getJSONObject(chQ)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (chS.equals(next)) {
                                    hashMap.put(chR, optString);
                                } else {
                                    hashMap.put(chP + next, optString);
                                }
                            }
                        }
                    }
                    if (Wb.has(chU) && (optJSONArray = Wb.optJSONArray(chU)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(chV, sb.toString());
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
