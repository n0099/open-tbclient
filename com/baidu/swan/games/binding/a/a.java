package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.q.c;
/* loaded from: classes11.dex */
public final class a extends EventTargetImpl {
    private b cka;
    private c clX;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.cka = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.cka.anw() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.cka.anw()).b(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new c(this.cka);
        }
        this.clX.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new c(this.cka);
        }
        this.clX.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new c(this.cka);
        }
        this.clX.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new c(this.cka);
        }
        this.clX.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.clX == null) {
            this.clX = new c(this.cka);
        }
        this.clX.setUserCloudStorage(jsObject);
    }
}
