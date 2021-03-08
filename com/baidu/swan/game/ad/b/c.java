package com.baidu.swan.game.ad.b;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c extends d {
    private String eaw;
    private String eax;
    private String eay;
    private String eaz;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.eaw = "banner";
        this.eax = "32";
        this.eay = "MSSP,ANTI,NMON";
        this.eaz = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aSj() {
        return "";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aSk() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.eaz);
        hashMap.put("prod", this.eaw);
        hashMap.put("at", this.eax);
        hashMap.put(IXAdRequestInfo.FET, this.eay);
        if (this.eaN != null) {
            hashMap.put("w", "" + this.eaN.getAdWidth());
            hashMap.put("h", "" + this.eaN.getAdHeight());
        }
        return hashMap;
    }
}
