package com.baidu.swan.games.f.b;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes9.dex */
public class b {
    private V8Engine mV8Engine;

    public b(V8Engine v8Engine) {
        this.mV8Engine = v8Engine;
    }

    public void da(String str, String str2) {
        this.mV8Engine.requireJSFileForOpenData(str, str2);
    }

    public void aZR() {
        this.mV8Engine.destroyOpenDataContext();
    }
}
