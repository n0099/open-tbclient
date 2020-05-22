package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String cRh;
    private String cRi;
    private String cRj;
    private String cRk;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.cRh = "banner";
        this.cRi = "32";
        this.cRj = "MSSP,ANTI,NMON";
        this.cRk = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> awv() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cRk);
        hashMap.put("prod", this.cRh);
        hashMap.put("at", this.cRi);
        hashMap.put(IXAdRequestInfo.FET, this.cRj);
        if (this.cRy != null) {
            hashMap.put("w", "" + this.cRy.awq());
            hashMap.put("h", "" + this.cRy.awr());
        }
        return hashMap;
    }
}
