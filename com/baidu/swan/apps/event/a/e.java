package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String caF;
    public String chA;
    public String chB;
    public String chC;
    public String chz;

    public e() {
        this.bRu = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kl(String str) {
        String str2 = (com.baidu.swan.apps.event.a.y(str, "fromId", this.chz) + com.baidu.swan.apps.event.a.y(str, "toId", this.chA)) + com.baidu.swan.apps.event.a.y(str, "toTabIndex", this.chC);
        if (!TextUtils.isEmpty(this.caF)) {
            str2 = str2 + com.baidu.swan.apps.event.a.y(str, "routeType", this.caF);
        }
        if (!TextUtils.isEmpty(this.chB)) {
            return str2 + com.baidu.swan.apps.event.a.y(str, "toPage", this.chB);
        }
        return str2;
    }
}
