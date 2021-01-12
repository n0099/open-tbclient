package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class c extends d {
    private String dWO;
    private String dWP;
    private String dWQ;
    private String dWR;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dWO = "banner";
        this.dWP = "32";
        this.dWQ = "MSSP,ANTI,NMON";
        this.dWR = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aRU() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aRV() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dWR);
        hashMap.put("prod", this.dWO);
        hashMap.put("at", this.dWP);
        hashMap.put(IXAdRequestInfo.FET, this.dWQ);
        if (this.dXf != null) {
            hashMap.put("w", "" + this.dXf.aRP());
            hashMap.put("h", "" + this.dXf.aRQ());
        }
        return hashMap;
    }
}
