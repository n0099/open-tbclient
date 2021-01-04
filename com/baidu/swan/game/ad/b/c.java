package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends d {
    private String ebA;
    private String ebB;
    private String ebC;
    private String ebD;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.ebA = "banner";
        this.ebB = "32";
        this.ebC = "MSSP,ANTI,NMON";
        this.ebD = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aVN() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aVO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.ebD);
        hashMap.put("prod", this.ebA);
        hashMap.put("at", this.ebB);
        hashMap.put(IXAdRequestInfo.FET, this.ebC);
        if (this.ebR != null) {
            hashMap.put("w", "" + this.ebR.aVI());
            hashMap.put("h", "" + this.ebR.aVJ());
        }
        return hashMap;
    }
}
