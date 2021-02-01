package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class e extends a {
    public String cSD;
    public String daT;
    public String daU;
    public String daV;
    public String daW;

    public e() {
        this.cIt = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String nK(String str) {
        String str2 = (com.baidu.swan.apps.event.a.O(str, "fromId", this.daT) + com.baidu.swan.apps.event.a.O(str, "toId", this.daU)) + com.baidu.swan.apps.event.a.O(str, "toTabIndex", this.daW);
        if (!TextUtils.isEmpty(this.cSD)) {
            str2 = str2 + com.baidu.swan.apps.event.a.O(str, "routeType", this.cSD);
        }
        if (!TextUtils.isEmpty(this.daV)) {
            return str2 + com.baidu.swan.apps.event.a.O(str, "toPage", this.daV);
        }
        return str2;
    }
}
