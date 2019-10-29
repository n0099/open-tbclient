package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class c extends d {
    private String c;
    private String d;
    private String e;
    private String f;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.c = "banner";
        this.d = "32";
        this.e = "MSSP,ANTI,NMON";
        this.f = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.f);
        hashMap.put("prod", this.c);
        hashMap.put("at", this.d);
        hashMap.put(IXAdRequestInfo.FET, this.e);
        if (this.bxm != null) {
            hashMap.put("w", "" + this.bxm.a());
            hashMap.put("h", "" + this.bxm.b());
        }
        return hashMap;
    }
}
