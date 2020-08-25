package com.baidu.swan.games.network.websocket;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes8.dex */
public class e {

    /* loaded from: classes8.dex */
    public static class b extends com.baidu.swan.games.binding.model.b {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.errMsg = str;
        }
    }

    /* loaded from: classes8.dex */
    public static class c extends com.baidu.swan.games.binding.model.b {
        @V8JavascriptField
        public String socketTaskId;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(String str, String str2) {
            this.socketTaskId = str;
            this.errMsg = str2;
        }
    }

    /* renamed from: com.baidu.swan.games.network.websocket.e$e  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0499e {
        @V8JavascriptField
        public Object header;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0499e(Object obj) {
            this.header = obj;
        }
    }

    /* loaded from: classes8.dex */
    public static class d {
        @V8JavascriptField
        public Object data;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Object obj) {
            this.data = obj;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        @V8JavascriptField
        public int code;
        @V8JavascriptField
        public String reason;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i, String str) {
            this.code = i;
            this.reason = str;
        }
    }
}
