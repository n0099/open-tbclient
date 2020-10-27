package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes10.dex */
public final class a extends EventTargetImpl {
    private b dLd;
    private c dNj;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.dLd = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.dLd.aSp() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.dLd.aSp()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.dNj == null) {
            this.dNj = new c(this.dLd);
        }
        this.dNj.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.dNj == null) {
            this.dNj = new c(this.dLd);
        }
        this.dNj.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.dNj == null) {
            this.dNj = new c(this.dLd);
        }
        this.dNj.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.dNj == null) {
            this.dNj = new c(this.dLd);
        }
        this.dNj.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.dNj == null) {
            this.dNj = new c(this.dLd);
        }
        this.dNj.setUserCloudStorage(jsObject);
    }
}
