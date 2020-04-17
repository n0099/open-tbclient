package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes11.dex */
public class a {
    private V8Engine mEngine;

    public a(V8Engine v8Engine) {
        this.mEngine = v8Engine;
    }

    public void log(String str) {
        Z(1, str);
    }

    public void error(String str) {
        Z(4, str);
    }

    private void Z(int i, String str) {
        this.mEngine.onConsoleCallBack(i, str);
    }
}
