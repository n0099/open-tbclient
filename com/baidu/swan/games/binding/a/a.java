package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes8.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;
    private b dox;
    private c dqD;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.dox = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.dox.aNb() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.dox.aNb()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.dqD == null) {
            this.dqD = new c(this.dox);
        }
        this.dqD.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.dqD == null) {
            this.dqD = new c(this.dox);
        }
        this.dqD.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.dqD == null) {
            this.dqD = new c(this.dox);
        }
        this.dqD.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.dqD == null) {
            this.dqD = new c(this.dox);
        }
        this.dqD.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.dqD == null) {
            this.dqD = new c(this.dox);
        }
        this.dqD.setUserCloudStorage(jsObject);
    }
}
