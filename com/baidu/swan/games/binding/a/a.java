package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes7.dex */
public final class a extends EventTargetImpl {
    private b deo;
    private c dgu;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.deo = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.deo.aEm() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.deo.aEm()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.dgu == null) {
            this.dgu = new c(this.deo);
        }
        this.dgu.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.dgu == null) {
            this.dgu = new c(this.deo);
        }
        this.dgu.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.dgu == null) {
            this.dgu = new c(this.deo);
        }
        this.dgu.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.dgu == null) {
            this.dgu = new c(this.deo);
        }
        this.dgu.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.dgu == null) {
            this.dgu = new c(this.deo);
        }
        this.dgu.setUserCloudStorage(jsObject);
    }
}
