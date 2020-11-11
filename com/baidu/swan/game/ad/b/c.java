package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class c extends d {
    private String dNo;
    private String dNp;
    private String dNq;
    private String dNr;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.dNo = "banner";
        this.dNp = "32";
        this.dNq = "MSSP,ANTI,NMON";
        this.dNr = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aQW() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aQX() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dNr);
        hashMap.put("prod", this.dNo);
        hashMap.put("at", this.dNp);
        hashMap.put(IXAdRequestInfo.FET, this.dNq);
        if (this.dNF != null) {
            hashMap.put("w", "" + this.dNF.aQR());
            hashMap.put("h", "" + this.dNF.aQS());
        }
        return hashMap;
    }
}
