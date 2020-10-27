package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bIj;

    public a(com.baidu.live.view.web.f fVar) {
        this.bIj = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iB(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bIj != null) {
            this.bIj.eX(-1);
        }
    }
}
