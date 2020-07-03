package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dfl;
    private HashMap<String, com.baidu.swan.games.network.a> dfm = new HashMap<>();

    private d() {
    }

    public static d aCg() {
        if (dfl == null) {
            synchronized (d.class) {
                if (dfl == null) {
                    dfl = new d();
                }
            }
        }
        return dfl;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.dem != null && bVar2.dem.dgj != null) {
            release();
            if (com.baidu.swan.apps.u.a.aga().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.dem.dgj.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String W = W(str, aVar.deY);
            if (!TextUtils.isEmpty(W)) {
                this.dfm.put(W, aVar);
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
                String W = W(optString, i);
                if (!TextUtils.isEmpty(W)) {
                    aVar = this.dfm.remove(W);
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
        this.dfm.clear();
    }

    private String W(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aAJ() != null && !TextUtils.isEmpty(str)) {
            bVar.aAJ().log(str);
        }
    }
}
