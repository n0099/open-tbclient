package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d ekF;
    private HashMap<String, com.baidu.swan.games.network.a> ekG = new HashMap<>();

    private d() {
    }

    public static d aXF() {
        if (ekF == null) {
            synchronized (d.class) {
                if (ekF == null) {
                    ekF = new d();
                }
            }
        }
        return ekF;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.ejI != null && bVar2.ejI.elC != null) {
            release();
            if (com.baidu.swan.apps.t.a.axc().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.ejI.elC.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String ah = ah(str, aVar.eks);
            if (!TextUtils.isEmpty(ah)) {
                this.ekG.put(ah, aVar);
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
                String ah = ah(optString, i);
                if (!TextUtils.isEmpty(ah)) {
                    aVar = this.ekG.remove(ah);
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
        this.ekG.clear();
    }

    private String ah(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aWe() != null && !TextUtils.isEmpty(str)) {
            bVar.aWe().log(str);
        }
    }
}
