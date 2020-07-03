package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes11.dex */
public final class a extends EventTargetImpl {
    private b cYE;
    private c daL;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.cYE = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.cYE.aAH() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.cYE.aAH()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.daL == null) {
            this.daL = new c(this.cYE);
        }
        this.daL.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.daL == null) {
            this.daL = new c(this.cYE);
        }
        this.daL.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.daL == null) {
            this.daL = new c(this.cYE);
        }
        this.daL.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.daL == null) {
            this.daL = new c(this.cYE);
        }
        this.daL.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.daL == null) {
            this.daL = new c(this.cYE);
        }
        this.daL.setUserCloudStorage(jsObject);
    }
}
