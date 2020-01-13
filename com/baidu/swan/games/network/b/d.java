package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.k.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cmo;
    private HashMap<String, com.baidu.swan.games.network.a> cmp = new HashMap<>();

    private d() {
    }

    public static d amE() {
        if (cmo == null) {
            synchronized (d.class) {
                if (cmo == null) {
                    cmo = new d();
                }
            }
        }
        return cmo;
    }

    public void a(com.baidu.swan.games.e.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.clo != null && bVar2.clo.cnk != null) {
            release();
            if (com.baidu.swan.apps.w.a.RJ().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.clo.cnk.a(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String P = P(str, aVar.cma);
            if (!TextUtils.isEmpty(P)) {
                this.cmp.put(P, aVar);
                if (DEBUG) {
                    Log.d("SwanGamePreloadManager", "addRequestTask url:" + str);
                }
            }
        }
    }

    public synchronized com.baidu.swan.games.network.a a(com.baidu.swan.games.e.b bVar, com.baidu.swan.games.binding.model.c cVar, int i) {
        com.baidu.swan.games.network.a aVar = null;
        synchronized (this) {
            if (cVar != null) {
                String optString = cVar.optString("url");
                String P = P(optString, i);
                if (!TextUtils.isEmpty(P)) {
                    aVar = this.cmp.remove(P);
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
        this.cmp.clear();
    }

    private String P(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.e.b bVar, String str) {
        if (bVar != null && bVar.ali() != null && !TextUtils.isEmpty(str)) {
            bVar.ali().log(str);
        }
    }
}
