package com.baidu.swan.games.e.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.b.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes11.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a bJA;
    private boolean cLP = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.bJA = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.cLP) {
            Log.v("V8Console", this.bJA.getLogTag() + str);
        }
        i.Y(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.cLP) {
            Log.d("V8Console", this.bJA.getLogTag() + str);
        }
        i.Y(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.cLP) {
            Log.i("V8Console", this.bJA.getLogTag() + str);
        }
        i.Y(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.bJA.getLogTag() + str);
        i.Y(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.bJA.getLogTag() + str);
        i.Y(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.cLP) {
            Log.d("V8Console", this.bJA.getLogTag() + str);
        }
        i.Y(6, str);
    }
}
