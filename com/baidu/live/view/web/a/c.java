package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes10.dex */
public class c extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.f bXy;

    public c(com.baidu.live.view.web.f fVar) {
        this.bXy = fVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void iy(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.bXy != null) {
            this.bXy.fq(-1);
        }
    }
}
