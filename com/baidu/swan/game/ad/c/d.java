package com.baidu.swan.game.ad.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class d {
    protected Context a;
    public b bwv;
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
        this.bwv = bVar;
        if (this.bwv != null) {
            this.d = this.bwv.d();
            this.e = this.bwv.c();
            this.f = this.bwv.e();
        }
    }

    public String b() {
        HashMap<String, String> c = c();
        c.putAll(a());
        return com.baidu.swan.game.ad.e.c.c(this.c, c);
    }

    private HashMap<String, String> c() {
        com.baidu.swan.apps.v.b.b AK;
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            hashMap.put(IXAdRequestInfo.QUERY_WIDTH, String.valueOf(Math.round(z.getDisplayWidth(this.a) / z.getDensity(this.a))));
            hashMap.put(IXAdRequestInfo.QUERY_HEIGHT, String.valueOf(Math.round(z.getDisplayHeight(this.a) / z.getDensity(this.a))));
            hashMap.put("net", "" + d());
            hashMap.put("n", this.g);
            hashMap.put("pk", this.f);
            hashMap.put("appid", this.e);
            hashMap.put("sw", "" + z.getDisplayWidth(this.a));
            hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, "" + z.getDisplayHeight(this.a));
            hashMap.put(IXAdRequestInfo.SN, "" + e());
            hashMap.put("os", "android");
            hashMap.put("apid", "" + this.d);
            hashMap.put("chid", "0");
            String UF = ac.UF();
            if (UF.equals("0")) {
                UF = "";
            }
            hashMap.put("imei", UF);
            hashMap.put("cuid", com.baidu.swan.apps.u.a.Jo().bf(com.baidu.swan.apps.u.a.Jj()));
            hashMap.put(IXAdRequestInfo.P_VER, this.i);
            hashMap.put("rpt", this.h);
            hashMap.put("tab", "2");
            hashMap.put("req_id", "");
            com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
            if (Ra != null && (AK = Ra.AK()) != null) {
                hashMap.put(FaceBaseDTO.KEY_BUSINESS_SCENE, AK.KF());
                JSONObject Ks = AK.Ks();
                if (Ks != null) {
                    hashMap.put("eqid", Ks.optString("eqid", ""));
                }
            }
        } catch (Exception e) {
        }
        return hashMap;
    }

    private int d() {
        switch (SwanAppNetworkUtils.MQ()) {
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
            String UF = ac.UF();
            return TextUtils.isEmpty(UF) ? ac.getWifiInfo(this.a) : UF;
        } catch (Exception e) {
            return "";
        }
    }
}
