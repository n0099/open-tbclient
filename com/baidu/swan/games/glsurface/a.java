package com.baidu.swan.games.glsurface;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.swan.games.u.d;
/* loaded from: classes10.dex */
public class a implements DebugConsole {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long ckp;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i, String str) {
        if (DEBUG && !d.anp()) {
            switch (i) {
                case 0:
                    Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
                    return;
                case 1:
                    this.ckp = System.currentTimeMillis();
                    Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
                    return;
                case 2:
                    Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.ckp), str));
                    return;
                default:
                    return;
            }
        }
    }
}
