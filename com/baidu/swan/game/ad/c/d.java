package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.tbadk.TbConfig;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {
    protected Context a;
    public b bdg;
    private String d;
    private String e;
    private String f;
    private String c = "https://mobads.baidu.com/cpro/ui/mads.php";
    private String g = "1";
    private String h = "2";
    private String i = "8.800201";

    protected abstract HashMap<String, String> a();

    public d(Context context, b bVar) {
        this.a = context;
        this.bdg = bVar;
        if (this.bdg != null) {
            this.d = this.bdg.d();
            this.e = this.bdg.c();
            this.f = this.bdg.e();
        }
    }

    public String b() {
        HashMap<String, String> c = c();
        c.putAll(a());
        return com.baidu.swan.game.ad.e.c.c(this.c, c);
    }

    private HashMap<String, String> c() {
        com.baidu.swan.apps.v.b.b vk;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put("lw", String.valueOf(Math.round(z.getDisplayWidth(this.a) / z.bT(this.a))));
            hashMap.put("lh", String.valueOf(Math.round(z.getDisplayHeight(this.a) / z.bT(this.a))));
            hashMap.put("net", "" + d());
            hashMap.put("n", this.g);
            hashMap.put(PushConstants.URI_PACKAGE_NAME, this.f);
            hashMap.put("appid", this.e);
            hashMap.put(TbConfig.SW_APID, "" + z.getDisplayWidth(this.a));
            hashMap.put("sh", "" + z.getDisplayHeight(this.a));
            hashMap.put("sn", "" + e());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.d);
            hashMap.put("chid", "0");
            String OX = ac.OX();
            if (OX.equals("0")) {
                OX = "";
            }
            hashMap.put("imei", OX);
            hashMap.put("cuid", com.baidu.swan.apps.u.a.DG().bd(com.baidu.swan.apps.u.a.DB()));
            hashMap.put("p_ver", this.i);
            hashMap.put("rpt", this.h);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
            if (Lq != null && (vk = Lq.vk()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, vk.EW());
                JSONObject EJ = vk.EJ();
                if (EJ != null) {
                    hashMap.put("eqid", EJ.optString("eqid", ""));
                }
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    private int d() {
        switch (SwanAppNetworkUtils.Hg()) {
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

    private String e() {
        try {
            String OX = ac.OX();
            return TextUtils.isEmpty(OX) ? ac.getWifiInfo(this.a) : OX;
        } catch (Exception e) {
            return "";
        }
    }
}
