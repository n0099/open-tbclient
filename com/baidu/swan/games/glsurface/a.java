package com.baidu.swan.games.glsurface;

import android.util.Log;
import com.baidu.searchbox.v8engine.console.DebugConsole;
import com.baidu.swan.games.v.d;
/* loaded from: classes8.dex */
public class a implements DebugConsole {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private long mEventTime;

    @Override // com.baidu.searchbox.v8engine.console.DebugConsole
    public void onReceiveInfo(int i, String str) {
        if (DEBUG && !d.aYq()) {
            switch (i) {
                case 0:
                    Log.d("arConsole", String.format("%s: %s %s", "queue event", "", str));
                    return;
                case 1:
                    this.mEventTime = System.currentTimeMillis();
                    Log.d("arConsole", String.format("%s: %s %s", "run event start", "", str));
                    return;
                case 2:
                    Log.d("arConsole", String.format("%s: %s %s", "run event end", Long.valueOf(System.currentTimeMillis() - this.mEventTime), str));
                    return;
                default:
                    return;
            }
        }
    }
}
