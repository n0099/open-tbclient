package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class f extends d {
    private String dSD;
    private String dSE;
    private String dSF;
    private String dSG;
    private String dSY;
    private String dSZ;
    private String dTa;
    private String dTb;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dSD = "rvideo";
        this.dSE = "10";
        this.dSF = "MSSP,ANTI,VIDEO,NMON";
        this.dSG = "LP,DL";
        this.dSY = "70300";
        this.dSZ = "70301";
        this.dTa = "70302";
        this.dTb = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aTt() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.baH()) {
            str = this.dSZ;
        } else if (com.baidu.swan.games.view.a.c.baI()) {
            str = this.dSY;
        }
        if (com.baidu.swan.game.ad.downloader.a.aSz()) {
            str2 = this.dTb;
        } else if (com.baidu.swan.game.ad.downloader.a.aSA()) {
            str2 = this.dTa;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + "," + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aTu() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dSG);
        hashMap.put("prod", this.dSD);
        hashMap.put("at", this.dSE);
        hashMap.put(IXAdRequestInfo.FET, this.dSF);
        return hashMap;
    }
}
