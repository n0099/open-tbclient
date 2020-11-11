package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class f extends d {
    private String dNJ;
    private String dNK;
    private String dNL;
    private String dNM;
    private String dNo;
    private String dNp;
    private String dNq;
    private String dNr;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dNo = "rvideo";
        this.dNp = "10";
        this.dNq = "MSSP,ANTI,VIDEO,NMON";
        this.dNr = "LP,DL";
        this.dNJ = "70300";
        this.dNK = "70301";
        this.dNL = "70302";
        this.dNM = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aQW() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aYk()) {
            str = this.dNK;
        } else if (com.baidu.swan.games.view.a.c.aYl()) {
            str = this.dNJ;
        }
        if (com.baidu.swan.game.ad.downloader.a.aQc()) {
            str2 = this.dNM;
        } else if (com.baidu.swan.game.ad.downloader.a.aQd()) {
            str2 = this.dNL;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aQX() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dNr);
        hashMap.put("prod", this.dNo);
        hashMap.put("at", this.dNp);
        hashMap.put(IXAdRequestInfo.FET, this.dNq);
        return hashMap;
    }
}
