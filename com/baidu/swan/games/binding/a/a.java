package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.n.c;
/* loaded from: classes2.dex */
public final class a extends EventTargetImpl {
    private b bad;
    private c bba;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.bad = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.bad.NT() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.bad.NT()).a(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.getFollowCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.bba == null) {
            this.bba = new c(this.bad);
        }
        this.bba.setUserCloudStorage(jsObject);
    }
}
