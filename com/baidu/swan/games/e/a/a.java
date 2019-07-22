package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine bgv;

    public a(V8Engine v8Engine) {
        this.bgv = v8Engine;
    }

    public void log(String str) {
        v(1, str);
    }

    public void jd(String str) {
        v(4, str);
    }

    private void v(int i, String str) {
        this.bgv.onConsoleCallBack(i, str);
    }
}
