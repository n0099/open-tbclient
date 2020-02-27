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
    private static String chN = "ug_";
    private static String chO = "ug_business";
    private static String chP = "ctkey";
    private static String chQ = "CTK";
    private static String chR = "eqid";
    private static String chS = "sid_eid";
    private static String chT = "exps";
    private String cgz;
    private String chU;
    private String chV;
    public b chZ;
    protected Context mContext;
    private String chM = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String chW = "1";
    private String chX = "2";
    private String chY = "8.800201";

    protected abstract HashMap<String, String> aky();

    public d(Context context, b bVar) {
        this.mContext = context;
        this.chZ = bVar;
        if (this.chZ != null) {
            this.cgz = this.chZ.akv();
            this.chU = this.chZ.getAppSid();
            this.chV = this.chZ.akw();
        }
    }

    public String akz() {
        HashMap<String, String> akA = akA();
        akA.putAll(aky());
        return com.baidu.swan.game.ad.e.c.getRequestAdUrl(this.chM, akA);
    }

    private HashMap<String, String> akA() {
        b.a acG;
        JSONArray optJSONArray;
        JSONObject jSONObject;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(af.getDisplayWidth(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(af.getDisplayHeight(this.mContext) / af.getDensity(this.mContext))));
            hashMap.put("net", "" + aix());
            hashMap.put("n", this.chW);
            hashMap.put("pk", this.chV);
            hashMap.put("appid", this.chU);
            hashMap.put("sw", "" + af.getDisplayWidth(this.mContext));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + af.getDisplayHeight(this.mContext));
            hashMap.put(IXAdRequestInfo.SN, "" + getSn());
            hashMap.put("os", PraiseDataPassUtil.KEY_FROM_OS);
            hashMap.put("apid", "" + this.cgz);
            hashMap.put("chid", "0");
            String ahf = ai.ahf();
            if (ahf.equals("0")) {
                ahf = "";
            }
            hashMap.put("imei", ahf);
            hashMap.put("cuid", com.baidu.swan.apps.w.a.TZ().br(com.baidu.swan.apps.w.a.TU()));
            hashMap.put(IXAdRequestInfo.P_VER, this.chY);
            hashMap.put("rpt", this.chX);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.runtime.e acE = com.baidu.swan.apps.runtime.e.acE();
            if (acE != null && (acG = acE.acG()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, acG.VH());
                JSONObject Vr = acG.Vr();
                if (Vr != null) {
                    hashMap.put("eqid", Vr.optString(chR, ""));
                }
                JSONObject VZ = acG.VZ();
                if (VZ != null) {
                    if (VZ.has(chO) && (jSONObject = VZ.getJSONObject(chO)) != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys != null && keys.hasNext()) {
                            String next = keys.next();
                            if (!TextUtils.isEmpty(next)) {
                                String optString = jSONObject.optString(next, "none");
                                if (chQ.equals(next)) {
                                    hashMap.put(chP, optString);
                                } else {
                                    hashMap.put(chN + next, optString);
                                }
                            }
                        }
                    }
                    if (VZ.has(chS) && (optJSONArray = VZ.optJSONArray(chS)) != null && optJSONArray.length() > 0) {
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
                            hashMap.put(chT, sb.toString());
                        }
                    }
                }
            }
            hashMap.put("con_name", com.baidu.swan.apps.w.a.UF().getHostName());
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    private int aix() {
        switch (SwanAppNetworkUtils.YX()) {
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
            String ahf = ai.ahf();
            return TextUtils.isEmpty(ahf) ? ai.getWifiInfo(this.mContext) : ahf;
        } catch (Exception e) {
            return "";
        }
    }
}
