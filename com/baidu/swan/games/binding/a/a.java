package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes9.dex */
public final class a extends EventTargetImpl {
    @V8JavascriptField
    public final String domain;
    private b efi;
    private c eho;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.efi = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.efi.aZH() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.efi.aZH()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.eho == null) {
            this.eho = new c(this.efi);
        }
        this.eho.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.eho == null) {
            this.eho = new c(this.efi);
        }
        this.eho.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.eho == null) {
            this.eho = new c(this.efi);
        }
        this.eho.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.eho == null) {
            this.eho = new c(this.efi);
        }
        this.eho.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.eho == null) {
            this.eho = new c(this.efi);
        }
        this.eho.setUserCloudStorage(jsObject);
    }
}
