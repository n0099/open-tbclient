package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String arY;
    public String awL;
    public String awM;
    public String awN;
    public String awO;

    public e() {
        this.awJ = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String ex(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.awL) + com.baidu.swan.apps.m.a.n(str, "toId", this.awM)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.awO);
        if (!TextUtils.isEmpty(this.arY)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.arY);
        }
        if (!TextUtils.isEmpty(this.awN)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.awN);
        }
        return str2;
    }
}
