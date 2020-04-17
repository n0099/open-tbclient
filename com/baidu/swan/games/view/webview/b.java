package com.baidu.swan.games.view.webview;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class b {

    /* loaded from: classes11.dex */
    public static class a {
        @V8JavascriptField
        public String url;

        public a(String str) {
            this.url = str;
        }

        @NonNull
        public String toString() {
            return "GameWebViewCommonResult{url='" + this.url + "'}";
        }
    }

    /* renamed from: com.baidu.swan.games.view.webview.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0385b extends a {
        @V8JavascriptField
        public String errCode;
        @V8JavascriptField
        public String errMsg;

        public C0385b(String str, String str2, String str3) {
            super(str);
            this.errCode = str2;
            this.errMsg = str3;
        }

        @Override // com.baidu.swan.games.view.webview.b.a
        @NonNull
        public String toString() {
            return "GameWebViewErrorResult{url=" + this.url + ", errMsg='" + this.errMsg + "'}";
        }
    }
}
