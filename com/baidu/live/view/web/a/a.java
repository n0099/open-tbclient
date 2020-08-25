package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes7.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bvr;

    public a(com.baidu.live.view.web.f fVar) {
        this.bvr = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void hq(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bvr != null) {
            this.bvr.fA(-1);
        }
    }
}
