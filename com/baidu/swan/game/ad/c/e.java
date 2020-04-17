package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends d {
    private String cGR;
    private String cGS;
    private String cGT;
    private String cGU;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.cGR = "rvideo";
        this.cGS = "10";
        this.cGT = "MSSP,ANTI,VIDEO,NMON";
        this.cGU = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> asP() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cGU);
        hashMap.put("prod", this.cGR);
        hashMap.put("at", this.cGS);
        hashMap.put(IXAdRequestInfo.FET, this.cGT);
        return hashMap;
    }
}
