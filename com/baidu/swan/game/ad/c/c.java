package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class c extends d {
    private String cdF;
    private String cdG;
    private String cdH;
    private String cdI;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.cdF = "banner";
        this.cdG = "32";
        this.cdH = "MSSP,ANTI,NMON";
        this.cdI = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> aik() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cdI);
        hashMap.put("prod", this.cdF);
        hashMap.put("at", this.cdG);
        hashMap.put(IXAdRequestInfo.FET, this.cdH);
        if (this.cdW != null) {
            hashMap.put("w", "" + this.cdW.aif());
            hashMap.put("h", "" + this.cdW.aig());
        }
        return hashMap;
    }
}
