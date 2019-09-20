package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine bgT;

    public a(V8Engine v8Engine) {
        this.bgT = v8Engine;
    }

    public void log(String str) {
        v(1, str);
    }

    public void jf(String str) {
        v(4, str);
    }

    private void v(int i, String str) {
        this.bgT.onConsoleCallBack(i, str);
    }
}
