package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c extends d {
    private String dYU;
    private String dYV;
    private String dYW;
    private String dYX;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dYU = "banner";
        this.dYV = "32";
        this.dYW = "MSSP,ANTI,NMON";
        this.dYX = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aSg() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aSh() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dYX);
        hashMap.put("prod", this.dYU);
        hashMap.put("at", this.dYV);
        hashMap.put(IXAdRequestInfo.FET, this.dYW);
        if (this.dZl != null) {
            hashMap.put("w", "" + this.dZl.getAdWidth());
            hashMap.put("h", "" + this.dZl.getAdHeight());
        }
        return hashMap;
    }
}
