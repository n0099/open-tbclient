package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.k.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cPE;
    private HashMap<String, com.baidu.swan.games.network.a> cPF = new HashMap<>();

    private d() {
    }

    public static d axj() {
        if (cPE == null) {
            synchronized (d.class) {
                if (cPE == null) {
                    cPE = new d();
                }
            }
        }
        return cPE;
    }

    public void a(com.baidu.swan.games.e.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.cOG != null && bVar2.cOG.cQA != null) {
            release();
            if (com.baidu.swan.apps.w.a.abQ().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.cOG.cQA.a(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String V = V(str, aVar.cPr);
            if (!TextUtils.isEmpty(V)) {
                this.cPF.put(V, aVar);
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
                String V = V(optString, i);
                if (!TextUtils.isEmpty(V)) {
                    aVar = this.cPF.remove(V);
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
        this.cPF.clear();
    }

    private String V(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.e.b bVar, String str) {
        if (bVar != null && bVar.avO() != null && !TextUtils.isEmpty(str)) {
            bVar.avO().log(str);
        }
    }
}
