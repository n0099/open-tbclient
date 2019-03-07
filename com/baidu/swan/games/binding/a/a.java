package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.n.c;
/* loaded from: classes2.dex */
public final class a extends EventTargetImpl {
    private b aZY;
    private c baV;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.aZY = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.aZY.NV() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.aZY.NV()).a(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.getFollowCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.baV == null) {
            this.baV = new c(this.aZY);
        }
        this.baV.setUserCloudStorage(jsObject);
    }
}
