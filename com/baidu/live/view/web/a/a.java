package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes4.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bFk;

    public a(com.baidu.live.view.web.f fVar) {
        this.bFk = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iq(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bFk != null) {
            this.bFk.eU(-1);
        }
    }
}
