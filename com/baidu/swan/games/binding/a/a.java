package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.n.c;
/* loaded from: classes2.dex */
public final class a extends EventTargetImpl {
    private b aZZ;
    private c baW;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.aZZ = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.aZZ.NV() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.aZZ.NV()).a(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.getFollowCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.baW == null) {
            this.baW = new c(this.aZZ);
        }
        this.baW.setUserCloudStorage(jsObject);
    }
}
