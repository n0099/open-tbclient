package com.baidu.swan.apps.n.a;

import android.text.TextUtils;
/* loaded from: classes9.dex */
public class e extends a {
    public String bjj;
    public String bpv;
    public String bpw;
    public String bpx;
    public String bpy;

    public e() {
        this.bpu = "route";
    }

    @Override // com.baidu.swan.apps.n.a.a
    public String hr(String str) {
        String str2 = (com.baidu.swan.apps.n.a.r(str, "fromId", this.bpv) + com.baidu.swan.apps.n.a.r(str, "toId", this.bpw)) + com.baidu.swan.apps.n.a.r(str, "toTabIndex", this.bpy);
        if (!TextUtils.isEmpty(this.bjj)) {
            str2 = str2 + com.baidu.swan.apps.n.a.r(str, "routeType", this.bjj);
        }
        if (!TextUtils.isEmpty(this.bpx)) {
            return str2 + com.baidu.swan.apps.n.a.r(str, "toPage", this.bpx);
        }
        return str2;
    }
}
