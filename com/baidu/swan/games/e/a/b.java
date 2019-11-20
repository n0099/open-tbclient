package com.baidu.swan.games.e.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.f;
/* loaded from: classes2.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a aLY;
    private boolean byV = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.aLY = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.byV) {
            Log.v("V8Console", this.aLY.ME() + str);
        }
        f.x(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.byV) {
            Log.d("V8Console", this.aLY.ME() + str);
        }
        f.x(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.byV) {
            Log.i("V8Console", this.aLY.ME() + str);
        }
        f.x(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.aLY.ME() + str);
        f.x(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.aLY.ME() + str);
        f.x(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.byV) {
            Log.d("V8Console", this.aLY.ME() + str);
        }
        f.x(6, str);
    }
}
