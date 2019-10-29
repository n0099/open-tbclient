package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.tencent.connect.common.Constants;
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
        hashMap.put("act", this.f);
        hashMap.put("prod", this.c);
        hashMap.put("at", this.d);
        hashMap.put(IXAdRequestInfo.FET, this.e);
        return hashMap;
    }
}
