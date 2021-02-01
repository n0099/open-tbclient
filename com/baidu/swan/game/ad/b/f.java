package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class f extends d {
    private String dYU;
    private String dYV;
    private String dYW;
    private String dYX;
    private String dZp;
    private String dZq;
    private String dZr;
    private String dZs;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dYU = "rvideo";
        this.dYV = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        this.dYW = "MSSP,ANTI,VIDEO,NMON";
        this.dYX = "LP,DL";
        this.dZp = "70300";
        this.dZq = "70301";
        this.dZr = "70302";
        this.dZs = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aSg() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aZs()) {
            str = this.dZq;
        } else if (com.baidu.swan.games.view.a.c.aZt()) {
            str = this.dZp;
        }
        if (com.baidu.swan.game.ad.downloader.a.aRq()) {
            str2 = this.dZs;
        } else if (com.baidu.swan.game.ad.downloader.a.aRr()) {
            str2 = this.dZr;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + "," + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aSh() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dYX);
        hashMap.put("prod", this.dYU);
        hashMap.put("at", this.dYV);
        hashMap.put(IXAdRequestInfo.FET, this.dYW);
        return hashMap;
    }
}
