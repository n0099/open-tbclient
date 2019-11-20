package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes6.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.e atC;

    public a(com.baidu.live.view.web.e eVar) {
        this.atC = eVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void cZ(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.atC != null) {
            this.atC.cs(-1);
        }
    }
}
