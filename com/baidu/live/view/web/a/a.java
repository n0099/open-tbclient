package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes7.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bvu;

    public a(com.baidu.live.view.web.f fVar) {
        this.bvu = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void hr(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bvu != null) {
            this.bvu.fA(-1);
        }
    }
}
