package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.tencent.open.SocialConstants;
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
        hashMap.put(SocialConstants.PARAM_ACT, this.f);
        hashMap.put("prod", this.c);
        hashMap.put("at", this.d);
        hashMap.put("fet", this.e);
        if (this.bdg != null) {
            hashMap.put(Config.DEVICE_WIDTH, "" + this.bdg.a());
            hashMap.put("h", "" + this.bdg.b());
        }
        return hashMap;
    }
}
