package com.baidu.swan.games.e.a;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class a {
    private V8Engine bbC;

    public void log(String str) {
        u(1, str);
    }

    public void im(String str) {
        u(4, str);
    }

    private void u(int i, String str) {
        this.bbC.onConsoleCallBack(i, str);
    }
}
