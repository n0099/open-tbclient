package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes19.dex */
public class f extends d {
    private String dkN;
    private String dkO;
    private String dkP;
    private String dkQ;
    private String dli;
    private String dlj;
    private String dlk;
    private String dll;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dkN = "rvideo";
        this.dkO = "10";
        this.dkP = "MSSP,ANTI,VIDEO,NMON";
        this.dkQ = "LP,DL";
        this.dli = "70300";
        this.dlj = "70301";
        this.dlk = "70302";
        this.dll = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJi() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aQv()) {
            str = this.dlj;
        } else if (com.baidu.swan.games.view.a.c.aQw()) {
            str = this.dli;
        }
        if (com.baidu.swan.game.ad.downloader.a.aIo()) {
            str2 = this.dll;
        } else if (com.baidu.swan.game.ad.downloader.a.aIp()) {
            str2 = this.dlk;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJj() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dkQ);
        hashMap.put("prod", this.dkN);
        hashMap.put("at", this.dkO);
        hashMap.put(IXAdRequestInfo.FET, this.dkP);
        return hashMap;
    }
}
