package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends d {
    private String chJ;
    private String chK;
    private String chL;
    private String chM;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.chJ = "rvideo";
        this.chK = "10";
        this.chL = "MSSP,ANTI,VIDEO,NMON";
        this.chM = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> akA() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chM);
        hashMap.put("prod", this.chJ);
        hashMap.put("at", this.chK);
        hashMap.put(IXAdRequestInfo.FET, this.chL);
        return hashMap;
    }
}
