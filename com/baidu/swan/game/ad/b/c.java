package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class c extends d {
    private String daD;
    private String daE;
    private String daF;
    private String daG;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.daD = "banner";
        this.daE = "32";
        this.daF = "MSSP,ANTI,NMON";
        this.daG = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aAy() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aAz() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.daG);
        hashMap.put("prod", this.daD);
        hashMap.put("at", this.daE);
        hashMap.put(IXAdRequestInfo.FET, this.daF);
        if (this.daU != null) {
            hashMap.put("w", "" + this.daU.aAt());
            hashMap.put("h", "" + this.daU.aAu());
        }
        return hashMap;
    }
}
