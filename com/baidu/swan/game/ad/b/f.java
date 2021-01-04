package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f extends d {
    private String ebA;
    private String ebB;
    private String ebC;
    private String ebD;
    private String ebV;
    private String ebW;
    private String ebX;
    private String ebY;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.ebA = "rvideo";
        this.ebB = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        this.ebC = "MSSP,ANTI,VIDEO,NMON";
        this.ebD = "LP,DL";
        this.ebV = "70300";
        this.ebW = "70301";
        this.ebX = "70302";
        this.ebY = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aVN() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.bcZ()) {
            str = this.ebW;
        } else if (com.baidu.swan.games.view.a.c.bda()) {
            str = this.ebV;
        }
        if (com.baidu.swan.game.ad.downloader.a.aUT()) {
            str2 = this.ebY;
        } else if (com.baidu.swan.game.ad.downloader.a.aUU()) {
            str2 = this.ebX;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + "," + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aVO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.ebD);
        hashMap.put("prod", this.ebA);
        hashMap.put("at", this.ebB);
        hashMap.put(IXAdRequestInfo.FET, this.ebC);
        return hashMap;
    }
}
