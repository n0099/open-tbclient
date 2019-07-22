package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.o.c;
/* loaded from: classes2.dex */
public final class a extends EventTargetImpl {
    private b beU;
    private c bfJ;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.beU = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.beU.RG() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.beU.RG()).b(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.getFollowCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.bfJ == null) {
            this.bfJ = new c(this.beU);
        }
        this.bfJ.setUserCloudStorage(jsObject);
    }
}
