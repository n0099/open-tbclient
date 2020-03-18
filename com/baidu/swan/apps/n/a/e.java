package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String bow;
    public String buH;
    public String buI;
    public String buJ;
    public String buK;

    public e() {
        this.buG = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hI(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.buH) + com.baidu.swan.apps.n.a.s(str, "toId", this.buI)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.buK);
        if (!TextUtils.isEmpty(this.bow)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.bow);
        }
        if (!TextUtils.isEmpty(this.buJ)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.buJ);
        }
        return str2;
    }
}
