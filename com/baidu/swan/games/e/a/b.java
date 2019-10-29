package com.baidu.swan.games.e.a;

import android.util.Log;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.games.c.f;
/* loaded from: classes2.dex */
public class b implements V8Engine.V8EngineConsole {
    private com.baidu.swan.games.e.a aMq;
    private boolean bzM = true;

    public b(com.baidu.swan.games.e.a aVar) {
        this.aMq = aVar;
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onLogConsole(String str) {
        if (this.bzM) {
            Log.v("V8Console", this.aMq.MD() + str);
        }
        f.y(1, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onDebugConsole(String str) {
        if (this.bzM) {
            Log.d("V8Console", this.aMq.MD() + str);
        }
        f.y(2, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onInfoConsole(String str) {
        if (this.bzM) {
            Log.i("V8Console", this.aMq.MD() + str);
        }
        f.y(3, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onErrorConsole(String str) {
        Log.e("V8Console", this.aMq.MD() + str);
        f.y(4, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onWarnConsole(String str) {
        Log.w("V8Console", this.aMq.MD() + str);
        f.y(5, str);
    }

    @Override // com.baidu.searchbox.v8engine.V8Engine.V8EngineConsole
    public void onTraceConsole(String str) {
        if (this.bzM) {
            Log.d("V8Console", this.aMq.MD() + str);
        }
        f.y(6, str);
    }
}
