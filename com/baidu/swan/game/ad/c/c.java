package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class c extends d {
    private String cGX;
    private String cGY;
    private String cGZ;
    private String cHa;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.cGX = "banner";
        this.cGY = "32";
        this.cGZ = "MSSP,ANTI,NMON";
        this.cHa = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> asO() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.cHa);
        hashMap.put("prod", this.cGX);
        hashMap.put("at", this.cGY);
        hashMap.put(IXAdRequestInfo.FET, this.cGZ);
        if (this.cHo != null) {
            hashMap.put("w", "" + this.cHo.asJ());
            hashMap.put("h", "" + this.cHo.asK());
        }
        return hashMap;
    }
}
