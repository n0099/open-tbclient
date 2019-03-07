package com.baidu.swan.apps.m.a;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class e extends a {
    public String aqM;
    public String avk;
    public String avl;
    public String avm;
    public String avn;

    public e() {
        this.avi = "route";
    }

    @Override // com.baidu.swan.apps.m.a.a
    public String eB(String str) {
        String str2 = (com.baidu.swan.apps.m.a.n(str, "fromId", this.avk) + com.baidu.swan.apps.m.a.n(str, "toId", this.avl)) + com.baidu.swan.apps.m.a.n(str, "toTabIndex", this.avn);
        if (!TextUtils.isEmpty(this.aqM)) {
            str2 = str2 + com.baidu.swan.apps.m.a.n(str, "routeType", this.aqM);
        }
        if (!TextUtils.isEmpty(this.avm)) {
            return str2 + com.baidu.swan.apps.m.a.n(str, "toPage", this.avm);
        }
        return str2;
    }
}
