package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aLp;
    public String aQa;
    public String aQb;
    public String aQc;
    public String aQd;

    public e() {
        this.aPY = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String fe(String str) {
        String str2 = (com.baidu.swan.apps.m.a.r(str, "fromId", this.aQa) + com.baidu.swan.apps.m.a.r(str, "toId", this.aQb)) + com.baidu.swan.apps.m.a.r(str, "toTabIndex", this.aQd);
        if (!TextUtils.isEmpty(this.aLp)) {
            str2 = str2 + com.baidu.swan.apps.m.a.r(str, "routeType", this.aLp);
        }
        if (!TextUtils.isEmpty(this.aQc)) {
            return str2 + com.baidu.swan.apps.m.a.r(str, "toPage", this.aQc);
        }
        return str2;
    }
}
