package com.baidu.swan.games.e.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.f;
/* loaded from: classes2.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a asB;
    private boolean bgw = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.asB = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.bgw) {
            Log.v("V8Console", this.asB.HF() + str);
        }
        f.u(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.bgw) {
            Log.d("V8Console", this.asB.HF() + str);
        }
        f.u(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.bgw) {
            Log.i("V8Console", this.asB.HF() + str);
        }
        f.u(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.asB.HF() + str);
        f.u(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.asB.HF() + str);
        f.u(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.bgw) {
            Log.d("V8Console", this.asB.HF() + str);
        }
        f.u(6, str);
    }
}
