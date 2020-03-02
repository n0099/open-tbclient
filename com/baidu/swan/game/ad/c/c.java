package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String chJ;
    private String chK;
    private String chL;
    private String chM;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.chJ = "banner";
        this.chK = "32";
        this.chL = "MSSP,ANTI,NMON";
        this.chM = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> akA() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chM);
        hashMap.put("prod", this.chJ);
        hashMap.put("at", this.chK);
        hashMap.put(IXAdRequestInfo.FET, this.chL);
        if (this.cia != null) {
            hashMap.put("w", "" + this.cia.akv());
            hashMap.put("h", "" + this.cia.akw());
        }
        return hashMap;
    }
}
