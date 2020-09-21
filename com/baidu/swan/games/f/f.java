package com.baidu.swan.games.f;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
/* loaded from: classes3.dex */
public class f extends com.baidu.swan.games.f.a {
    public f(@NonNull String str) {
        super("worker", new a(str), null);
    }

    @Override // com.baidu.swan.games.f.a
    public EventTarget aNF() {
        return null;
    }

    @Override // com.baidu.swan.games.f.a
    public EventTarget aNG() {
        return null;
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }

    /* loaded from: classes3.dex */
    private static class a extends com.baidu.swan.games.f.d.a {
        private String mBasePath;

        public a(String str) {
            this.mBasePath = str;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aiN() {
            return "swan-game-worker.js";
        }
    }
}
