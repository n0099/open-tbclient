package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bdt;

    public a(com.baidu.live.view.web.f fVar) {
        this.bdt = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void fX(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bdt != null) {
            this.bdt.cM(-1);
        }
    }
}
