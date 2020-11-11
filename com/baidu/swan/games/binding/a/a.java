package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes10.dex */
public final class a extends EventTargetImpl {
    private b dQV;
    private c dTb;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.dQV = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.dQV.aUP() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.dQV.aUP()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.dTb == null) {
            this.dTb = new c(this.dQV);
        }
        this.dTb.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.dTb == null) {
            this.dTb = new c(this.dQV);
        }
        this.dTb.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.dTb == null) {
            this.dTb = new c(this.dQV);
        }
        this.dTb.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.dTb == null) {
            this.dTb = new c(this.dQV);
        }
        this.dTb.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.dTb == null) {
            this.dTb = new c(this.dQV);
        }
        this.dTb.setUserCloudStorage(jsObject);
    }
}
