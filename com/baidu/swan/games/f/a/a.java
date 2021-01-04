package com.baidu.swan.games.f.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes9.dex */
public class a {
    private V8Engine mEngine;

    public a(V8Engine v8Engine) {
        this.mEngine = v8Engine;
    }

    public void log(String str) {
        ay(1, str);
    }

    public void error(String str) {
        ay(4, str);
    }

    private void ay(int i, String str) {
        this.mEngine.onConsoleCallBack(i, str);
    }
}
