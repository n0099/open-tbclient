package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bRk;

    public a(com.baidu.live.view.web.f fVar) {
        this.bRk = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void jm(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bRk != null) {
            this.bRk.fr(-1);
        }
    }
}
