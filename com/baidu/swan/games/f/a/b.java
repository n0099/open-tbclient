package com.baidu.swan.games.f.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes7.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.f.a bYi;
    private boolean dhd = true;

    public b(com.baidu.swan.games.f.a aVar) {
        this.bYi = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.dhd) {
            Log.v("V8Console", this.bYi.getLogTag() + str);
        }
        i.af(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.dhd) {
            Log.d("V8Console", this.bYi.getLogTag() + str);
        }
        i.af(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.dhd) {
            Log.i("V8Console", this.bYi.getLogTag() + str);
        }
        i.af(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.bYi.getLogTag() + str);
        i.af(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.bYi.getLogTag() + str);
        i.af(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.dhd) {
            Log.d("V8Console", this.bYi.getLogTag() + str);
        }
        i.af(6, str);
    }
}
