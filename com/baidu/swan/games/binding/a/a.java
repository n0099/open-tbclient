package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.f.b;
import com.baidu.swan.games.r.c;
/* loaded from: classes11.dex */
public final class a extends EventTargetImpl {
    private b cTU;
    private c cVZ;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.cTU = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.cTU.azB() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.cTU.azB()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.cVZ == null) {
            this.cVZ = new c(this.cTU);
        }
        this.cVZ.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.cVZ == null) {
            this.cVZ = new c(this.cTU);
        }
        this.cVZ.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.cVZ == null) {
            this.cVZ = new c(this.cTU);
        }
        this.cVZ.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.cVZ == null) {
            this.cVZ = new c(this.cTU);
        }
        this.cVZ.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.cVZ == null) {
            this.cVZ = new c(this.cTU);
        }
        this.cVZ.setUserCloudStorage(jsObject);
    }
}
