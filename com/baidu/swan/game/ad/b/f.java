package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class f extends d {
    private String dHR;
    private String dHS;
    private String dHT;
    private String dHU;
    private String dHw;
    private String dHx;
    private String dHy;
    private String dHz;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dHw = "rvideo";
        this.dHx = "10";
        this.dHy = "MSSP,ANTI,VIDEO,NMON";
        this.dHz = "LP,DL";
        this.dHR = "70300";
        this.dHS = "70301";
        this.dHT = "70302";
        this.dHU = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aOw() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aVK()) {
            str = this.dHS;
        } else if (com.baidu.swan.games.view.a.c.aVL()) {
            str = this.dHR;
        }
        if (com.baidu.swan.game.ad.downloader.a.aNC()) {
            str2 = this.dHU;
        } else if (com.baidu.swan.game.ad.downloader.a.aND()) {
            str2 = this.dHT;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aOx() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dHz);
        hashMap.put("prod", this.dHw);
        hashMap.put("at", this.dHx);
        hashMap.put(IXAdRequestInfo.FET, this.dHy);
        return hashMap;
    }
}
