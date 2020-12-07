package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class c extends d {
    private String dSD;
    private String dSE;
    private String dSF;
    private String dSG;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dSD = "banner";
        this.dSE = "32";
        this.dSF = "MSSP,ANTI,NMON";
        this.dSG = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aTt() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aTu() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dSG);
        hashMap.put("prod", this.dSD);
        hashMap.put("at", this.dSE);
        hashMap.put(IXAdRequestInfo.FET, this.dSF);
        if (this.dSU != null) {
            hashMap.put("w", "" + this.dSU.aTo());
            hashMap.put("h", "" + this.dSU.aTp());
        }
        return hashMap;
    }
}
