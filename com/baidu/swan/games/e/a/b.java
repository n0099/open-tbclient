package com.baidu.swan.games.e.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.e;
/* loaded from: classes2.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a arM;
    private boolean bbD = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.arM = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.bbD) {
            Log.v("V8Console", this.arM.EV() + str);
        }
        e.t(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.bbD) {
            Log.d("V8Console", this.arM.EV() + str);
        }
        e.t(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.bbD) {
            Log.i("V8Console", this.arM.EV() + str);
        }
        e.t(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.arM.EV() + str);
        e.t(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.arM.EV() + str);
        e.t(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.bbD) {
            Log.d("V8Console", this.arM.EV() + str);
        }
        e.t(6, str);
    }
}
