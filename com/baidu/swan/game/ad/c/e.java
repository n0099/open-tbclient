package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends d {
    private String cGX;
    private String cGY;
    private String cGZ;
    private String cHa;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.cGX = "rvideo";
        this.cGY = "10";
        this.cGZ = "MSSP,ANTI,VIDEO,NMON";
        this.cHa = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> asO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cHa);
        hashMap.put("prod", this.cGX);
        hashMap.put("at", this.cGY);
        hashMap.put(IXAdRequestInfo.FET, this.cGZ);
        return hashMap;
    }
}
