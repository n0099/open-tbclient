package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes11.dex */
public class c extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bVY;

    public c(com.baidu.live.view.web.f fVar) {
        this.bVY = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void is(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bVY != null) {
            this.bVY.fp(-1);
        }
    }
}
