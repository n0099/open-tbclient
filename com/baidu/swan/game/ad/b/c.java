package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c extends d {
    private String dmT;
    private String dmU;
    private String dmV;
    private String dmW;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dmT = "banner";
        this.dmU = "32";
        this.dmV = "MSSP,ANTI,NMON";
        this.dmW = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJT() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJU() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dmW);
        hashMap.put("prod", this.dmT);
        hashMap.put("at", this.dmU);
        hashMap.put(IXAdRequestInfo.FET, this.dmV);
        if (this.dnk != null) {
            hashMap.put("w", "" + this.dnk.aJO());
            hashMap.put("h", "" + this.dnk.aJP());
        }
        return hashMap;
    }
}
