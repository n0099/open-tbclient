package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.e aGx;

    public a(com.baidu.live.view.web.e eVar) {
        this.aGx = eVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void ek(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.aGx != null) {
            this.aGx.cY(-1);
        }
    }
}
