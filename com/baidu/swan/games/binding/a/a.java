package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes3.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;
    private b dqC;
    private c dsK;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.dqC = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.dqC.aNM() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.dqC.aNM()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.dsK == null) {
            this.dsK = new c(this.dqC);
        }
        this.dsK.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.dsK == null) {
            this.dsK = new c(this.dqC);
        }
        this.dsK.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.dsK == null) {
            this.dsK = new c(this.dqC);
        }
        this.dsK.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.dsK == null) {
            this.dsK = new c(this.dqC);
        }
        this.dsK.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.dsK == null) {
            this.dsK = new c(this.dqC);
        }
        this.dsK.setUserCloudStorage(jsObject);
    }
}
