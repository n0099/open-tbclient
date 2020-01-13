package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes2.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.e aCq;

    public a(com.baidu.live.view.web.e eVar) {
        this.aCq = eVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void dV(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.aCq != null) {
            this.aCq.cI(-1);
        }
    }
}
