package com.baidu.swan.games.f.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes9.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.f.a cQM;
    private boolean ehX = true;

    public b(com.baidu.swan.games.f.a aVar) {
        this.cQM = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.ehX) {
            Log.v("V8Console", this.cQM.getLogTag() + str);
        }
        i.ax(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.ehX) {
            Log.d("V8Console", this.cQM.getLogTag() + str);
        }
        i.ax(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.ehX) {
            Log.i("V8Console", this.cQM.getLogTag() + str);
        }
        i.ax(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.cQM.getLogTag() + str);
        i.ax(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.cQM.getLogTag() + str);
        i.ax(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.ehX) {
            Log.d("V8Console", this.cQM.getLogTag() + str);
        }
        i.ax(6, str);
    }
}
