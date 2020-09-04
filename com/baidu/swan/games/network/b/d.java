package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d dve;
    private HashMap<String, com.baidu.swan.games.network.a> dvf = new HashMap<>();

    private d() {
    }

    public static d aOE() {
        if (dve == null) {
            synchronized (d.class) {
                if (dve == null) {
                    dve = new d();
                }
            }
        }
        return dve;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.dui != null && bVar2.dui.dwb != null) {
            release();
            if (com.baidu.swan.apps.t.a.aoM().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.dui.dwb.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String Y = Y(str, aVar.requestType);
            if (!TextUtils.isEmpty(Y)) {
                this.dvf.put(Y, aVar);
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
                String Y = Y(optString, i);
                if (!TextUtils.isEmpty(Y)) {
                    aVar = this.dvf.remove(Y);
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
        this.dvf.clear();
    }

    private String Y(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aNd() != null && !TextUtils.isEmpty(str)) {
            bVar.aNd().log(str);
        }
    }
}
