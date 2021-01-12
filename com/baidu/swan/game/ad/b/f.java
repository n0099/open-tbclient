package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class f extends d {
    private String dWO;
    private String dWP;
    private String dWQ;
    private String dWR;
    private String dXj;
    private String dXk;
    private String dXl;
    private String dXm;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dWO = "rvideo";
        this.dWP = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        this.dWQ = "MSSP,ANTI,VIDEO,NMON";
        this.dWR = "LP,DL";
        this.dXj = "70300";
        this.dXk = "70301";
        this.dXl = "70302";
        this.dXm = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aRU() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aZg()) {
            str = this.dXk;
        } else if (com.baidu.swan.games.view.a.c.aZh()) {
            str = this.dXj;
        }
        if (com.baidu.swan.game.ad.downloader.a.aRa()) {
            str2 = this.dXm;
        } else if (com.baidu.swan.game.ad.downloader.a.aRb()) {
            str2 = this.dXl;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + "," + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aRV() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dWR);
        hashMap.put("prod", this.dWO);
        hashMap.put("at", this.dWP);
        hashMap.put(IXAdRequestInfo.FET, this.dWQ);
        return hashMap;
    }
}
