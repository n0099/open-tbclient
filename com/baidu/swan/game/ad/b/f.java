package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class f extends d {
    private String dmT;
    private String dmU;
    private String dmV;
    private String dmW;
    private String dno;
    private String dnp;
    private String dnq;
    private String dnr;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dmT = "rvideo";
        this.dmU = "10";
        this.dmV = "MSSP,ANTI,VIDEO,NMON";
        this.dmW = "LP,DL";
        this.dno = "70300";
        this.dnp = "70301";
        this.dnq = "70302";
        this.dnr = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJT() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aRh()) {
            str = this.dnp;
        } else if (com.baidu.swan.games.view.a.c.aRi()) {
            str = this.dno;
        }
        if (com.baidu.swan.game.ad.downloader.a.aIZ()) {
            str2 = this.dnr;
        } else if (com.baidu.swan.game.ad.downloader.a.aJa()) {
            str2 = this.dnq;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJU() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dmW);
        hashMap.put("prod", this.dmT);
        hashMap.put("at", this.dmU);
        hashMap.put(IXAdRequestInfo.FET, this.dmV);
        return hashMap;
    }
}
