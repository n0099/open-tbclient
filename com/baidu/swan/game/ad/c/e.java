package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class e extends d {
    private String c;
    private String d;
    private String e;
    private String f;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.c = "rvideo";
        this.d = Constants.VIA_REPORT_TYPE_SHARE_TO_QQ;
        this.e = "MSSP,ANTI,VIDEO,NMON";
        this.f = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(SocialConstants.PARAM_ACT, this.f);
        hashMap.put("prod", this.c);
        hashMap.put("at", this.d);
        hashMap.put("fet", this.e);
        return hashMap;
    }
}
