package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine bfI;

    public a(V8Engine v8Engine) {
        this.bfI = v8Engine;
    }

    public void log(String str) {
        v(1, str);
    }

    public void iW(String str) {
        v(4, str);
    }

    private void v(int i, String str) {
        this.bfI.onConsoleCallBack(i, str);
    }
}
