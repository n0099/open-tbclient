package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes7.dex */
public class e extends a {
    public String ccm;
    public String cjA;
    public String cjB;
    public String cjy;
    public String cjz;

    public e() {
        this.bSl = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kH(String str) {
        String str2 = (com.baidu.swan.apps.event.a.y(str, "fromId", this.cjy) + com.baidu.swan.apps.event.a.y(str, "toId", this.cjz)) + com.baidu.swan.apps.event.a.y(str, "toTabIndex", this.cjB);
        if (!TextUtils.isEmpty(this.ccm)) {
            str2 = str2 + com.baidu.swan.apps.event.a.y(str, "routeType", this.ccm);
        }
        if (!TextUtils.isEmpty(this.cjA)) {
            return str2 + com.baidu.swan.apps.event.a.y(str, "toPage", this.cjA);
        }
        return str2;
    }
}
