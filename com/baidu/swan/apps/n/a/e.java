package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String bMD;
    public String bSN;
    public String bSO;
    public String bSP;
    public String bSQ;

    public e() {
        this.bSM = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String iW(String str) {
        String str2 = (com.baidu.swan.apps.n.a.s(str, "fromId", this.bSN) + com.baidu.swan.apps.n.a.s(str, "toId", this.bSO)) + com.baidu.swan.apps.n.a.s(str, "toTabIndex", this.bSQ);
        if (!TextUtils.isEmpty(this.bMD)) {
            str2 = str2 + com.baidu.swan.apps.n.a.s(str, "routeType", this.bMD);
        }
        if (!TextUtils.isEmpty(this.bSP)) {
            return str2 + com.baidu.swan.apps.n.a.s(str, "toPage", this.bSP);
        }
        return str2;
    }
}
