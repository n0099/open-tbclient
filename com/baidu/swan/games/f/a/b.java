package com.baidu.swan.games.f.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes10.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.f.a cso;
    private boolean dFv = true;

    public b(com.baidu.swan.games.f.a aVar) {
        this.cso = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.dFv) {
            Log.v("V8Console", this.cso.getLogTag() + str);
        }
        i.ap(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.dFv) {
            Log.d("V8Console", this.cso.getLogTag() + str);
        }
        i.ap(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.dFv) {
            Log.i("V8Console", this.cso.getLogTag() + str);
        }
        i.ap(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.cso.getLogTag() + str);
        i.ap(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.cso.getLogTag() + str);
        i.ap(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.dFv) {
            Log.d("V8Console", this.cso.getLogTag() + str);
        }
        i.ap(6, str);
    }
}
