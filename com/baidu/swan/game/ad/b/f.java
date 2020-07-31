package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class f extends d {
    private String daD;
    private String daE;
    private String daF;
    private String daG;
    private String daY;
    private String daZ;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.daD = "rvideo";
        this.daE = "10";
        this.daF = "MSSP,ANTI,VIDEO,NMON";
        this.daG = "LP,DL";
        this.daY = "70300";
        this.daZ = "70301";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aAy() {
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            return "";
        }
        if (com.baidu.swan.games.view.a.c.aHF()) {
            return this.daZ;
        }
        if (com.baidu.swan.games.view.a.c.aHG()) {
            return this.daY;
        }
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aAz() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.daG);
        hashMap.put("prod", this.daD);
        hashMap.put("at", this.daE);
        hashMap.put(IXAdRequestInfo.FET, this.daF);
        return hashMap;
    }
}
