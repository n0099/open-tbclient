package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.q.c;
/* loaded from: classes11.dex */
public final class a extends EventTargetImpl {
    private b ckb;
    private c clY;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.ckb = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.ckb.anw() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.ckb.anw()).b(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.clY == null) {
            this.clY = new c(this.ckb);
        }
        this.clY.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.clY == null) {
            this.clY = new c(this.ckb);
        }
        this.clY.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.clY == null) {
            this.clY = new c(this.ckb);
        }
        this.clY.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.clY == null) {
            this.clY = new c(this.ckb);
        }
        this.clY.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.clY == null) {
            this.clY = new c(this.ckb);
        }
        this.clY.setUserCloudStorage(jsObject);
    }
}
