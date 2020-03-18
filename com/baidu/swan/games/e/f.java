package com.baidu.swan.games.e;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes11.dex */
public class f extends com.baidu.swan.games.e.a {
    public f(@NonNull String str) {
        super("worker", new a(str), null);
    }

    @Override // com.baidu.swan.games.e.a
    public EventTarget ans() {
        return null;
    }

    @Override // com.baidu.swan.games.e.a
    public EventTarget ant() {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }

    /* loaded from: classes11.dex */
    private static class a extends com.baidu.swan.games.e.d.a {
        private String mBasePath;

        public a(String str) {
            this.mBasePath = str;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Pi() {
            return "swan-game-worker.js";
        }
    }
}
