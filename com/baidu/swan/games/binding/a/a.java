package com.baidu.swan.games.binding.a;

import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.V8JavascriptField;
import com.baidu.searchbox.v8engine.event.EventTargetImpl;
import com.baidu.swan.games.e.b;
import com.baidu.swan.games.n.c;
/* loaded from: classes2.dex */
public final class a extends EventTargetImpl {
    private c baZ;
    private b bac;
    @V8JavascriptField
    public final String domain;

    public a(b bVar) {
        super(bVar);
        this.domain = "openData";
        this.bac = bVar;
    }

    @JavascriptInterface
    public void initSharedCanvas(JsObject jsObject) {
        if (this.bac.NT() instanceof com.baidu.swan.games.binding.c) {
            ((com.baidu.swan.games.binding.c) this.bac.NT()).a(jsObject);
        }
    }

    @JavascriptInterface
    public a getOpenData() {
        return this;
    }

    @JavascriptInterface
    public void getFriendCloudStorage(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.getFriendCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getFollowCloudStorage(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.getFollowCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserCloudStorage(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.getUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void getUserInfo(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.getUserInfo(jsObject);
    }

    @JavascriptInterface
    public void removeUserCloudStorage(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.removeUserCloudStorage(jsObject);
    }

    @JavascriptInterface
    public void setUserCloudStorage(JsObject jsObject) {
        if (this.baZ == null) {
            this.baZ = new c(this.bac);
        }
        this.baZ.setUserCloudStorage(jsObject);
    }
}
