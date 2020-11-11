package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bNP;

    public a(com.baidu.live.view.web.f fVar) {
        this.bNP = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iO(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bNP != null) {
            this.bNP.eX(-1);
        }
    }
}
