package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class c extends d {
    private String dyZ;
    private String dza;
    private String dzb;
    private String dzc;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dyZ = "banner";
        this.dza = "32";
        this.dzb = "MSSP,ANTI,NMON";
        this.dzc = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aMC() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aMD() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dzc);
        hashMap.put("prod", this.dyZ);
        hashMap.put("at", this.dza);
        hashMap.put(IXAdRequestInfo.FET, this.dzb);
        if (this.dzq != null) {
            hashMap.put("w", "" + this.dzq.aMx());
            hashMap.put("h", "" + this.dzq.aMy());
        }
        return hashMap;
    }
}
