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
    private b ecD;
    private c eeI;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.ecD = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.ecD.aVZ() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.ecD.aVZ()).d(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.eeI == null) {
            this.eeI = new c(this.ecD);
        }
        this.eeI.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.eeI == null) {
            this.eeI = new c(this.ecD);
        }
        this.eeI.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.eeI == null) {
            this.eeI = new c(this.ecD);
        }
        this.eeI.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.eeI == null) {
            this.eeI = new c(this.ecD);
        }
        this.eeI.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.eeI == null) {
            this.eeI = new c(this.ecD);
        }
        this.eeI.setUserCloudStorage(jsObject);
    }
}
