package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes3.dex */
public class e extends a {
    public String ckp;
    public String csS;
    public String csT;
    public String csU;
    public String csV;

    public e() {
        this.bZZ = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mQ(String str) {
        String str2 = (com.baidu.swan.apps.event.a.A(str, "fromId", this.csS) + com.baidu.swan.apps.event.a.A(str, "toId", this.csT)) + com.baidu.swan.apps.event.a.A(str, "toTabIndex", this.csV);
        if (!TextUtils.isEmpty(this.ckp)) {
            str2 = str2 + com.baidu.swan.apps.event.a.A(str, "routeType", this.ckp);
        }
        if (!TextUtils.isEmpty(this.csU)) {
            return str2 + com.baidu.swan.apps.event.a.A(str, "toPage", this.csU);
        }
        return str2;
    }
}
