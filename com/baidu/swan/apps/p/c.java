package com.baidu.swan.apps.p;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.p.d;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
/* loaded from: classes11.dex */
public final class c<W extends d> {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final HashMap<String, a<W>> cfo = new HashMap<>();

    public void a(a<W> aVar) {
        if (DEBUG) {
            Log.v("CommandDispatcher", aVar.aek() + " command added to supported command list");
        }
        this.cfo.put(aVar.aek(), aVar);
    }

    public void b(@Nullable ZeusPlugin.Command command, @Nullable W w) {
        if (command == null || TextUtils.isEmpty(command.what)) {
            if (DEBUG) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't dispatched");
            }
        } else if (w == null) {
            if (DEBUG) {
                Log.e("CommandDispatcher", "inlineWidget is null, haven't dispatched");
            }
        } else {
            a<W> aVar = this.cfo.get(command.what);
            if (aVar == null) {
                if (DEBUG) {
                    Log.e("CommandDispatcher", command.what + " command is not supported, haven't dispatched");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d("CommandDispatcher", command.what + " command dispatched");
            }
            aVar.a(command, w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable ZeusPlugin.Command command) {
        if (command == null || TextUtils.isEmpty(command.what)) {
            if (DEBUG) {
                Log.e("CommandDispatcher", "command or command.what is null, haven't mocked");
                return;
            }
            return;
        }
        a<W> aVar = this.cfo.get(command.what);
        if (aVar == null) {
            if (DEBUG) {
                Log.e("CommandDispatcher", command.what + " command is not supported, haven't mocked");
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("CommandDispatcher", command.what + " cached command return value processed");
        }
        aVar.a(command);
    }
}
