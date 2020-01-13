package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.q.c;
/* loaded from: classes10.dex */
public final class a extends EventTargetImpl {
    private b cfV;
    private c chS;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.cfV = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.cfV.alg() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.cfV.alg()).b(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.chS == null) {
            this.chS = new c(this.cfV);
        }
        this.chS.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.chS == null) {
            this.chS = new c(this.cfV);
        }
        this.chS.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.chS == null) {
            this.chS = new c(this.cfV);
        }
        this.chS.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.chS == null) {
            this.chS = new c(this.cfV);
        }
        this.chS.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.chS == null) {
            this.chS = new c(this.cfV);
        }
        this.chS.setUserCloudStorage(jsObject);
    }
}
