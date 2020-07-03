package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String cVR;
    private String cVS;
    private String cVT;
    private String cVU;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.cVR = "banner";
        this.cVS = "32";
        this.cVT = "MSSP,ANTI,NMON";
        this.cVU = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> axB() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cVU);
        hashMap.put("prod", this.cVR);
        hashMap.put("at", this.cVS);
        hashMap.put(IXAdRequestInfo.FET, this.cVT);
        if (this.cWi != null) {
            hashMap.put("w", "" + this.cWi.axw());
            hashMap.put("h", "" + this.cWi.axx());
        }
        return hashMap;
    }
}
