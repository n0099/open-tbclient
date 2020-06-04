package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bkg;

    public a(com.baidu.live.view.web.f fVar) {
        this.bkg = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fO(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bkg != null) {
            this.bkg.dv(-1);
        }
    }
}
