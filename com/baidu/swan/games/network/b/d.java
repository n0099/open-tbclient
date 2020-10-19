package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dJg;
    private HashMap<String, com.baidu.swan.games.network.a> dJh = new HashMap<>();

    private d() {
    }

    public static d aRY() {
        if (dJg == null) {
            synchronized (d.class) {
                if (dJg == null) {
                    dJg = new d();
                }
            }
        }
        return dJg;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.dIk != null && bVar2.dIk.dKd != null) {
            release();
            if (com.baidu.swan.apps.t.a.asi().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.dIk.dKd.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String Z = Z(str, aVar.requestType);
            if (!TextUtils.isEmpty(Z)) {
                this.dJh.put(Z, aVar);
                if (DEBUG) {
                    Log.d("SwanGamePreloadManager", "addRequestTask url:" + str);
                }
            }
        }
    }

    public synchronized com.baidu.swan.games.network.a a(com.baidu.swan.games.f.b bVar, com.baidu.swan.games.binding.model.c cVar, int i) {
        com.baidu.swan.games.network.a aVar = null;
        synchronized (this) {
            if (cVar != null) {
                String optString = cVar.optString("url");
                String Z = Z(optString, i);
                if (!TextUtils.isEmpty(Z)) {
                    aVar = this.dJh.remove(Z);
                    if (aVar != null) {
                        a(bVar, "preload used, url = " + optString);
                    }
                    if (DEBUG) {
                        Log.d("SwanGamePreloadManager", "obtainRequestTask requestType:" + i + ";url:" + optString + ";task:" + aVar);
                    }
                }
            }
        }
        return aVar;
    }

    public synchronized void release() {
        this.dJh.clear();
    }

    private String Z(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aQx() != null && !TextUtils.isEmpty(str)) {
            bVar.aQx().log(str);
        }
    }
}
