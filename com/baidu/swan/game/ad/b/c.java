package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes19.dex */
public class c extends d {
    private String dkR;
    private String dkS;
    private String dkT;
    private String dkU;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dkR = "banner";
        this.dkS = "32";
        this.dkT = "MSSP,ANTI,NMON";
        this.dkU = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aJi() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aJj() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dkU);
        hashMap.put("prod", this.dkR);
        hashMap.put("at", this.dkS);
        hashMap.put(IXAdRequestInfo.FET, this.dkT);
        if (this.dli != null) {
            hashMap.put("w", "" + this.dli.aJd());
            hashMap.put("h", "" + this.dli.aJe());
        }
        return hashMap;
    }
}
