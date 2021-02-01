package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes9.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d eje;
    private HashMap<String, com.baidu.swan.games.network.a> ejf = new HashMap<>();

    private d() {
    }

    public static d aXC() {
        if (eje == null) {
            synchronized (d.class) {
                if (eje == null) {
                    eje = new d();
                }
            }
        }
        return eje;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.eih != null && bVar2.eih.ekb != null) {
            release();
            if (com.baidu.swan.apps.t.a.awZ().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.eih.ekb.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String ag = ag(str, aVar.eiR);
            if (!TextUtils.isEmpty(ag)) {
                this.ejf.put(ag, aVar);
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
                String ag = ag(optString, i);
                if (!TextUtils.isEmpty(ag)) {
                    aVar = this.ejf.remove(ag);
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
        this.ejf.clear();
    }

    private String ag(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aWb() != null && !TextUtils.isEmpty(str)) {
            bVar.aWb().log(str);
        }
    }
}
