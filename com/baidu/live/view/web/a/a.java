package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes3.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.e aGN;

    public a(com.baidu.live.view.web.e eVar) {
        this.aGN = eVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void ej(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.aGN != null) {
            this.aGN.cY(-1);
        }
    }
}
