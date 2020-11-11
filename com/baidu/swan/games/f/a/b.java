package com.baidu.swan.games.f.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes10.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.f.a cGH;
    private boolean dTK = true;

    public b(com.baidu.swan.games.f.a aVar) {
        this.cGH = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.dTK) {
            Log.v("V8Console", this.cGH.getLogTag() + str);
        }
        i.av(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.dTK) {
            Log.d("V8Console", this.cGH.getLogTag() + str);
        }
        i.av(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.dTK) {
            Log.i("V8Console", this.cGH.getLogTag() + str);
        }
        i.av(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.cGH.getLogTag() + str);
        i.av(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.cGH.getLogTag() + str);
        i.av(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.dTK) {
            Log.d("V8Console", this.cGH.getLogTag() + str);
        }
        i.av(6, str);
    }
}
