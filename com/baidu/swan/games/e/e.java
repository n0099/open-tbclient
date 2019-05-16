package com.baidu.swan.games.e;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.event.EventTarget;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
/* loaded from: classes2.dex */
public class e extends a {
    public e(@NonNull String str, @NonNull com.baidu.swan.games.e.d.b bVar, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        super(str, bVar, v8ThreadDelegatePolicy);
    }

    @Override // com.baidu.swan.games.e.a
    @NonNull
    public EventTarget QH() {
        return new com.baidu.swan.games.binding.c(this);
    }

    @Override // com.baidu.swan.games.e.a
    public EventTarget QI() {
        return new com.baidu.swan.games.binding.a.a(this);
    }

    @Override // com.baidu.searchbox.unitedscheme.TypedCallbackHandler
    public int getInvokeSourceType() {
        return 1;
    }

    @Override // com.baidu.swan.games.e.a
    protected String QT() {
        return com.baidu.swan.games.i.a.bd(this.bfv.Au(), this.bfv.Av());
    }
}
