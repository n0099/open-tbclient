package com.baidu.swan.apps.event.a;

import android.text.TextUtils;
/* loaded from: classes10.dex */
public class e extends a {
    public String cKW;
    public String cTs;
    public String cTt;
    public String cTu;
    public String cTv;

    public e() {
        this.cAM = "route";
    }

    @Override // com.baidu.swan.apps.event.a.a
    public String ok(String str) {
        String str2 = (com.baidu.swan.apps.event.a.I(str, "fromId", this.cTs) + com.baidu.swan.apps.event.a.I(str, "toId", this.cTt)) + com.baidu.swan.apps.event.a.I(str, "toTabIndex", this.cTv);
        if (!TextUtils.isEmpty(this.cKW)) {
            str2 = str2 + com.baidu.swan.apps.event.a.I(str, "routeType", this.cKW);
        }
        if (!TextUtils.isEmpty(this.cTu)) {
            return str2 + com.baidu.swan.apps.event.a.I(str, "toPage", this.cTu);
        }
        return str2;
    }
}
