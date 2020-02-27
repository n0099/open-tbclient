package com.baidu.swan.games.e.a;

import android.annotation.SuppressLint;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.b.i;
@SuppressLint({"SwanDebugLog"})
/* loaded from: classes11.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a bld;
    private boolean cmG = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.bld = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.cmG) {
            Log.v("V8Console", this.bld.getLogTag() + str);
        }
        i.H(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.cmG) {
            Log.d("V8Console", this.bld.getLogTag() + str);
        }
        i.H(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.cmG) {
            Log.i("V8Console", this.bld.getLogTag() + str);
        }
        i.H(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.bld.getLogTag() + str);
        i.H(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.bld.getLogTag() + str);
        i.H(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.cmG) {
            Log.d("V8Console", this.bld.getLogTag() + str);
        }
        i.H(6, str);
    }
}
