package com.baidu.swan.games.s;

import com.baidu.searchbox.v8engine.V8JavascriptField;
/* loaded from: classes11.dex */
public class c {
    @V8JavascriptField
    public boolean cancel;
    @V8JavascriptField
    public boolean confirm;

    public c(boolean z) {
        this.confirm = z;
        this.cancel = !z;
    }

    public String toString() {
        return "SwanGameReloadResult{confirm=" + this.confirm + ", cancel=" + this.cancel + '}';
    }
}
