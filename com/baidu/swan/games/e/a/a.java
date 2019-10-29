package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine bzL;

    public a(V8Engine v8Engine) {
        this.bzL = v8Engine;
    }

    public void log(String str) {
        z(1, str);
    }

    public void jI(String str) {
        z(4, str);
    }

    private void z(int i, String str) {
        this.bzL.onConsoleCallBack(i, str);
    }
}
