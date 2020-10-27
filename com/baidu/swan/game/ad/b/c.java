package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class c extends d {
    private String dHw;
    private String dHx;
    private String dHy;
    private String dHz;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dHw = "banner";
        this.dHx = "32";
        this.dHy = "MSSP,ANTI,NMON";
        this.dHz = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aOw() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aOx() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dHz);
        hashMap.put("prod", this.dHw);
        hashMap.put("at", this.dHx);
        hashMap.put(IXAdRequestInfo.FET, this.dHy);
        if (this.dHN != null) {
            hashMap.put("w", "" + this.dHN.aOr());
            hashMap.put("h", "" + this.dHN.aOs());
        }
        return hashMap;
    }
}
