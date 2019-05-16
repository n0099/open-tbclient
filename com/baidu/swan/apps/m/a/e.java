package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aqX;
    public String avI;
    public String avJ;
    public String avK;
    public String avL;

    public e() {
        this.avG = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String er(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.avI) + com.baidu.swan.apps.m.a.n(str, "toId", this.avJ)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.avL);
        if (!TextUtils.isEmpty(this.aqX)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.aqX);
        }
        if (!TextUtils.isEmpty(this.avK)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.avK);
        }
        return str2;
    }
}
