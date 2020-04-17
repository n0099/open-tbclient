package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.q.c;
/* loaded from: classes11.dex */
public final class a extends EventTargetImpl {
    private b cJh;
    private c cLg;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.cJh = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.cJh.avM() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.cJh.avM()).b(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.cLg == null) {
            this.cLg = new c(this.cJh);
        }
        this.cLg.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.cLg == null) {
            this.cLg = new c(this.cJh);
        }
        this.cLg.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.cLg == null) {
            this.cLg = new c(this.cJh);
        }
        this.cLg.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.cLg == null) {
            this.cLg = new c(this.cJh);
        }
        this.cLg.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.cLg == null) {
            this.cLg = new c(this.cJh);
        }
        this.cLg.setUserCloudStorage(jsObject);
    }
}
