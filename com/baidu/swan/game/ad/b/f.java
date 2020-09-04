package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes19.dex */
public class f extends d {
    private String dkR;
    private String dkS;
    private String dkT;
    private String dkU;
    private String dlm;
    private String dln;
    private String dlo;
    private String dlp;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dkR = "rvideo";
        this.dkS = "10";
        this.dkT = "MSSP,ANTI,VIDEO,NMON";
        this.dkU = "LP,DL";
        this.dlm = "70300";
        this.dln = "70301";
        this.dlo = "70302";
        this.dlp = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJi() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aQv()) {
            str = this.dln;
        } else if (com.baidu.swan.games.view.a.c.aQw()) {
            str = this.dlm;
        }
        if (com.baidu.swan.game.ad.downloader.a.aIo()) {
            str2 = this.dlp;
        } else if (com.baidu.swan.game.ad.downloader.a.aIp()) {
            str2 = this.dlo;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJj() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dkU);
        hashMap.put("prod", this.dkR);
        hashMap.put("at", this.dkS);
        hashMap.put(IXAdRequestInfo.FET, this.dkT);
        return hashMap;
    }
}
