package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class f extends d {
    private String eaR;
    private String eaS;
    private String eaT;
    private String eaU;
    private String eaw;
    private String eax;
    private String eay;
    private String eaz;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.eaw = "rvideo";
        this.eax = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        this.eay = "MSSP,ANTI,VIDEO,NMON";
        this.eaz = "LP,DL";
        this.eaR = "70300";
        this.eaS = "70301";
        this.eaT = "70302";
        this.eaU = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aSj() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aZv()) {
            str = this.eaS;
        } else if (com.baidu.swan.games.view.a.c.aZw()) {
            str = this.eaR;
        }
        if (com.baidu.swan.game.ad.downloader.a.aRt()) {
            str2 = this.eaU;
        } else if (com.baidu.swan.game.ad.downloader.a.aRu()) {
            str2 = this.eaT;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + "," + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aSk() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.eaz);
        hashMap.put("prod", this.eaw);
        hashMap.put("at", this.eax);
        hashMap.put(IXAdRequestInfo.FET, this.eay);
        return hashMap;
    }
}
