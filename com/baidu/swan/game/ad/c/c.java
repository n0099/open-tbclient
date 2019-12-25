package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes9.dex */
public class c extends d {
    private String cds;
    private String cdt;
    private String cdu;
    private String cdv;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.cds = "banner";
        this.cdt = "32";
        this.cdu = "MSSP,ANTI,NMON";
        this.cdv = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> ahR() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cdv);
        hashMap.put("prod", this.cds);
        hashMap.put("at", this.cdt);
        hashMap.put(IXAdRequestInfo.FET, this.cdu);
        if (this.cdJ != null) {
            hashMap.put("w", "" + this.cdJ.ahM());
            hashMap.put("h", "" + this.cdJ.ahN());
        }
        return hashMap;
    }
}
