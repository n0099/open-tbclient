package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String chK;
    private String chL;
    private String chM;
    private String chN;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.chK = "banner";
        this.chL = "32";
        this.chM = "MSSP,ANTI,NMON";
        this.chN = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> akA() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chN);
        hashMap.put("prod", this.chK);
        hashMap.put("at", this.chL);
        hashMap.put(IXAdRequestInfo.FET, this.chM);
        if (this.cib != null) {
            hashMap.put("w", "" + this.cib.akv());
            hashMap.put("h", "" + this.cib.akw());
        }
        return hashMap;
    }
}
