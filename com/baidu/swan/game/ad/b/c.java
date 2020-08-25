package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes19.dex */
public class c extends d {
    private String dkN;
    private String dkO;
    private String dkP;
    private String dkQ;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dkN = "banner";
        this.dkO = "32";
        this.dkP = "MSSP,ANTI,NMON";
        this.dkQ = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJi() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJj() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dkQ);
        hashMap.put("prod", this.dkN);
        hashMap.put("at", this.dkO);
        hashMap.put(IXAdRequestInfo.FET, this.dkP);
        if (this.dle != null) {
            hashMap.put("w", "" + this.dle.aJd());
            hashMap.put("h", "" + this.dle.aJe());
        }
        return hashMap;
    }
}
