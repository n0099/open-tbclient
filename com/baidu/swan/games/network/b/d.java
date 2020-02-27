package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.k.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d cqq;
    private HashMap<String, com.baidu.swan.games.network.a> cqr = new HashMap<>();

    private d() {
    }

    public static d aoR() {
        if (cqq == null) {
            synchronized (d.class) {
                if (cqq == null) {
                    cqq = new d();
                }
            }
        }
        return cqq;
    }

    public void a(com.baidu.swan.games.e.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.cpr != null && bVar2.cpr.crn != null) {
            release();
            if (com.baidu.swan.apps.w.a.TX().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.cpr.crn.a(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String N = N(str, aVar.cqd);
            if (!TextUtils.isEmpty(N)) {
                this.cqr.put(N, aVar);
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
                String N = N(optString, i);
                if (!TextUtils.isEmpty(N)) {
                    aVar = this.cqr.remove(N);
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
        this.cqr.clear();
    }

    private String N(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.e.b bVar, String str) {
        if (bVar != null && bVar.anw() != null && !TextUtils.isEmpty(str)) {
            bVar.anw().log(str);
        }
    }
}
