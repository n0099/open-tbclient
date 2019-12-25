package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class e extends d {
    private String cds;
    private String cdt;
    private String cdu;
    private String cdv;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.cds = "rvideo";
        this.cdt = "10";
        this.cdu = "MSSP,ANTI,VIDEO,NMON";
        this.cdv = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> ahR() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cdv);
        hashMap.put("prod", this.cds);
        hashMap.put("at", this.cdt);
        hashMap.put(IXAdRequestInfo.FET, this.cdu);
        return hashMap;
    }
}
