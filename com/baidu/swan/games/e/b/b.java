package com.baidu.swan.games.e.b;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class b {
    private V8Engine mV8Engine;

    public b(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void aV(String str, String str2) {
        this.mV8Engine.requireJSFileForOpenData(str, str2);
    }

    public void QY() {
        this.mV8Engine.destroyOpenDataContext();
    }
}
