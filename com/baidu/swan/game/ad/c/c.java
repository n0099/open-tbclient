package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String chI;
    private String chJ;
    private String chK;
    private String chL;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.chI = "banner";
        this.chJ = "32";
        this.chK = "MSSP,ANTI,NMON";
        this.chL = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> aky() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chL);
        hashMap.put("prod", this.chI);
        hashMap.put("at", this.chJ);
        hashMap.put(IXAdRequestInfo.FET, this.chK);
        if (this.chZ != null) {
            hashMap.put("w", "" + this.chZ.akt());
            hashMap.put("h", "" + this.chZ.aku());
        }
        return hashMap;
    }
}
