package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dVN;
    private HashMap<String, com.baidu.swan.games.network.a> dVO = new HashMap<>();

    private d() {
    }

    public static d aVK() {
        if (dVN == null) {
            synchronized (d.class) {
                if (dVN == null) {
                    dVN = new d();
                }
            }
        }
        return dVN;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.dUR != null && bVar2.dUR.dWK != null) {
            release();
            if (com.baidu.swan.apps.t.a.avV().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.dUR.dWK.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String ab = ab(str, aVar.requestType);
            if (!TextUtils.isEmpty(ab)) {
                this.dVO.put(ab, aVar);
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
                String ab = ab(optString, i);
                if (!TextUtils.isEmpty(ab)) {
                    aVar = this.dVO.remove(ab);
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
        this.dVO.clear();
    }

    private String ab(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aUj() != null && !TextUtils.isEmpty(str)) {
            bVar.aUj().log(str);
        }
    }
}
