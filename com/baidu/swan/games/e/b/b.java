package com.baidu.swan.games.e.b;

import com.baidu.searchbox.v8engine.V8Engine;
/* loaded from: classes2.dex */
public class b {
    private V8Engine mV8Engine;

    public void aS(String str, String str2) {
        this.mV8Engine.requireJSFileForOpenData(str, str2);
    }

    public void Of() {
        this.mV8Engine.destroyOpenDataContext();
    }
}
