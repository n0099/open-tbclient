package com.baidu.swan.games.f.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes10.dex */
public class a {
    private V8Engine mEngine;

    public a(V8Engine v8Engine) {
        this.mEngine = v8Engine;
    }

    public void log(String str) {
        aw(1, str);
    }

    public void error(String str) {
        aw(4, str);
    }

    private void aw(int i, String str) {
        this.mEngine.onConsoleCallBack(i, str);
    }
}
