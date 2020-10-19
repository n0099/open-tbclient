package com.baidu.swan.game.ad.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
/* loaded from: classes14.dex */
public class f extends d {
    private String dyZ;
    private String dza;
    private String dzb;
    private String dzc;
    private String dzu;
    private String dzv;
    private String dzw;
    private String dzx;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.dyZ = "rvideo";
        this.dza = "10";
        this.dzb = "MSSP,ANTI,VIDEO,NMON";
        this.dzc = "LP,DL";
        this.dzu = "70300";
        this.dzv = "70301";
        this.dzw = "70302";
        this.dzx = "70303";
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected String aMC() {
        String str = "";
        String str2 = "";
        if (!com.baidu.swan.games.view.a.c.isLandScape()) {
            str = "";
        } else if (com.baidu.swan.games.view.a.c.aTQ()) {
            str = this.dzv;
        } else if (com.baidu.swan.games.view.a.c.aTR()) {
            str = this.dzu;
        }
        if (com.baidu.swan.game.ad.downloader.a.aLI()) {
            str2 = this.dzx;
        } else if (com.baidu.swan.game.ad.downloader.a.aLJ()) {
            str2 = this.dzw;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str + str2;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SP + str2;
    }

    @Override // com.baidu.swan.game.ad.b.d
    protected HashMap<String, String> aMD() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.dzc);
        hashMap.put("prod", this.dyZ);
        hashMap.put("at", this.dza);
        hashMap.put(IXAdRequestInfo.FET, this.dzb);
        return hashMap;
    }
}
