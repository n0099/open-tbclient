package com.baidu.swan.game.ad.c;

import android.content.Context;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class e extends d {
    private String chV;
    private String chW;
    private String chX;
    private String chY;

    public e(Context context, b bVar) {
        super(context, bVar);
        this.chV = "rvideo";
        this.chW = "10";
        this.chX = "MSSP,ANTI,VIDEO,NMON";
        this.chY = "LP,DL";
    }

    @Override // com.baidu.swan.game.ad.c.d
    protected HashMap<String, String> akD() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.chY);
        hashMap.put("prod", this.chV);
        hashMap.put("at", this.chW);
        hashMap.put(IXAdRequestInfo.FET, this.chX);
        return hashMap;
    }
}
