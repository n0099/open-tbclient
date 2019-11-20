package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine byU;

    public a(V8Engine v8Engine) {
        this.byU = v8Engine;
    }

    public void log(String str) {
        y(1, str);
    }

    public void jI(String str) {
        y(4, str);
    }

    private void y(int i, String str) {
        this.byU.onConsoleCallBack(i, str);
    }
}
