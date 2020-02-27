package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends d {
    private String chI;
    private String chJ;
    private String chK;
    private String chL;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.chI = "rvideo";
        this.chJ = "10";
        this.chK = "MSSP,ANTI,VIDEO,NMON";
        this.chL = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> aky() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chL);
        hashMap.put("prod", this.chI);
        hashMap.put("at", this.chJ);
        hashMap.put(IXAdRequestInfo.FET, this.chK);
        return hashMap;
    }
}
