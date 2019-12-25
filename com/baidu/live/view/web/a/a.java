package com.baidu.live.view.web.a;

import android.util.Log;
/* loaded from: classes2.dex */
public class a extends com.baidu.live.view.web.a {
    protected com.baidu.live.view.web.e aBy;

    public a(com.baidu.live.view.web.e eVar) {
        this.aBy = eVar;
    }

    @Override // com.baidu.live.view.web.a
    public String getName() {
        return "closeBridge";
    }

    @Override // com.baidu.live.view.web.a
    public void dT(String str) {
        Log.d("JsInterface", "@@ JsInterface-impl CloseBridgeJsInterface params = " + str);
        if (this.aBy != null) {
            this.aBy.cH(-1);
        }
    }
}
