package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes8.dex */
public class e extends a {
    public String cio;
    public String cqP;
    public String cqQ;
    public String cqR;
    public String cqS;

    public e() {
        this.bXY = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String mx(String str) {
        String str2 = (com.baidu.swan.apps.event.a.A(str, "fromId", this.cqP) + com.baidu.swan.apps.event.a.A(str, "toId", this.cqQ)) + com.baidu.swan.apps.event.a.A(str, "toTabIndex", this.cqS);
        if (!TextUtils.isEmpty(this.cio)) {
            str2 = str2 + com.baidu.swan.apps.event.a.A(str, "routeType", this.cio);
        }
        if (!TextUtils.isEmpty(this.cqR)) {
            return str2 + com.baidu.swan.apps.event.a.A(str, "toPage", this.cqR);
        }
        return str2;
    }
}
