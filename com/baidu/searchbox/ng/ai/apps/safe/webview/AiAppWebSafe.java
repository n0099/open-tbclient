package com.baidu.searchbox.ng.ai.apps.safe.webview;

import android.text.TextUtils;
import com.baidu.searchbox.ng.ai.apps.safe.webview.WebSafeWhiteListMgr;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class AiAppWebSafe {
    public static final boolean DEBUG = false;
    public static final String TAG = "AiAppWebSafe";
    private WebSafeWhiteListMgr.WebSafeData sWebActions;
    private WebSafeWhiteListMgr.WebSafeData sWebDomains;

    public void preLoadDataAsync(String str) {
        if (!TextUtils.isEmpty(str)) {
            getWebActions(true);
            getWebDomains(str, true);
        }
    }

    public ArrayList<String> getWebActions(boolean z) {
        if (this.sWebActions != null && this.sWebActions.data != null && this.sWebActions.data.size() > 0) {
            return this.sWebActions.data;
        }
        if (this.sWebActions != null) {
            this.sWebActions.token = "";
            this.sWebActions.data.clear();
        } else {
            this.sWebActions = new WebSafeWhiteListMgr.WebSafeData();
        }
        WebSafeWhiteListMgr.getWebActions(z, this.sWebActions);
        return this.sWebActions.data;
    }

    public ArrayList<String> getAdLandingWebActions() {
        WebSafeWhiteListMgr.WebSafeData webSafeData = new WebSafeWhiteListMgr.WebSafeData();
        WebSafeWhiteListMgr.getAdLandingWebActions(webSafeData);
        return webSafeData.data;
    }

    public ArrayList<String> getWebDomains(String str, boolean z) {
        if (this.sWebDomains != null && this.sWebDomains.data != null && this.sWebDomains.data.size() > 0) {
            return this.sWebDomains.data;
        }
        if (this.sWebDomains != null) {
            this.sWebDomains.token = "";
            this.sWebDomains.data.clear();
        } else {
            this.sWebDomains = new WebSafeWhiteListMgr.WebSafeData();
        }
        WebSafeWhiteListMgr.getWebDomains(z, str, this.sWebDomains);
        return this.sWebDomains.data;
    }

    public void release() {
        if (this.sWebDomains != null) {
            this.sWebDomains.data.clear();
        }
        if (this.sWebActions != null) {
            this.sWebActions.data.clear();
        }
        this.sWebDomains = null;
        this.sWebActions = null;
    }
}
