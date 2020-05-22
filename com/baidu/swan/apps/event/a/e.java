package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes11.dex */
public class e extends a {
    public String bVR;
    public String ccL;
    public String ccM;
    public String ccN;
    public String ccO;

    public e() {
        this.bMG = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String kd(String str) {
        String str2 = (com.baidu.swan.apps.event.a.x(str, "fromId", this.ccL) + com.baidu.swan.apps.event.a.x(str, "toId", this.ccM)) + com.baidu.swan.apps.event.a.x(str, "toTabIndex", this.ccO);
        if (!TextUtils.isEmpty(this.bVR)) {
            str2 = str2 + com.baidu.swan.apps.event.a.x(str, "routeType", this.bVR);
        }
        if (!TextUtils.isEmpty(this.ccN)) {
            return str2 + com.baidu.swan.apps.event.a.x(str, "toPage", this.ccN);
        }
        return str2;
    }
}
