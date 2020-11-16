package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes12.dex */
public class c extends d {
    private String dLG;
    private String dLH;
    private String dLI;
    private String dLJ;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dLG = "banner";
        this.dLH = "32";
        this.dLI = "MSSP,ANTI,NMON";
        this.dLJ = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aQo() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aQp() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dLJ);
        hashMap.put("prod", this.dLG);
        hashMap.put("at", this.dLH);
        hashMap.put(IXAdRequestInfo.FET, this.dLI);
        if (this.dLX != null) {
            hashMap.put("w", "" + this.dLX.aQj());
            hashMap.put("h", "" + this.dLX.aQk());
        }
        return hashMap;
    }
}
