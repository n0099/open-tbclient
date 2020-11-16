package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class f extends d {
    private String dLG;
    private String dLH;
    private String dLI;
    private String dLJ;
    private String dMb;
    private String dMc;
    private String dMd;
    private String dMe;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dLG = "rvideo";
        this.dLH = "10";
        this.dLI = "MSSP,ANTI,VIDEO,NMON";
        this.dLJ = "LP,DL";
        this.dMb = "70300";
        this.dMc = "70301";
        this.dMd = "70302";
        this.dMe = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aQo() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aXC()) {
            str = this.dMc;
        } else if (com.baidu.swan.games.view.a.c.aXD()) {
            str = this.dMb;
        }
        if (com.baidu.swan.game.ad.downloader.a.aPu()) {
            str2 = this.dMe;
        } else if (com.baidu.swan.game.ad.downloader.a.aPv()) {
            str2 = this.dMd;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aQp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dLJ);
        hashMap.put("prod", this.dLG);
        hashMap.put("at", this.dLH);
        hashMap.put(IXAdRequestInfo.FET, this.dLI);
        return hashMap;
    }
}
