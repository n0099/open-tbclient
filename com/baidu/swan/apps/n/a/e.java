package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String bMI;
    public String bST;
    public String bSU;
    public String bSV;
    public String bSW;

    public e() {
        this.bSS = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String iW(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.bST) + com.baidu.swan.apps.n.a.s(str, "toId", this.bSU)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.bSW);
        if (!TextUtils.isEmpty(this.bMI)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.bMI);
        }
        if (!TextUtils.isEmpty(this.bSV)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.bSV);
        }
        return str2;
    }
}
