package com.baidu.swan.games.network.b;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.games.l.a;
import java.util.HashMap;
import okhttp3.HttpUrl;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile d egX;
    private HashMap<String, com.baidu.swan.games.network.a> egY = new HashMap<>();

    private d() {
    }

    public static d aXq() {
        if (egX == null) {
            synchronized (d.class) {
                if (egX == null) {
                    egX = new d();
                }
            }
        }
        return egX;
    }

    public void a(com.baidu.swan.games.f.b bVar, a.b bVar2) {
        if (bVar != null && bVar2 != null && bVar2.efZ != null && bVar2.efZ.ehU != null) {
            release();
            if (com.baidu.swan.apps.t.a.awB().getSwitch("swan_game_resource_preload", 0) == 1) {
                bVar2.efZ.ehU.b(bVar);
            }
        }
    }

    public synchronized void a(String str, com.baidu.swan.games.network.a aVar) {
        if (aVar != null) {
            String ae = ae(str, aVar.egK);
            if (!TextUtils.isEmpty(ae)) {
                this.egY.put(ae, aVar);
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
                String ae = ae(optString, i);
                if (!TextUtils.isEmpty(ae)) {
                    aVar = this.egY.remove(ae);
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
        this.egY.clear();
    }

    private String ae(String str, int i) {
        HttpUrl parse;
        if (TextUtils.isEmpty(str) || (parse = HttpUrl.parse(str)) == null) {
            return null;
        }
        return parse.url().toString() + i;
    }

    private static void a(com.baidu.swan.games.f.b bVar, String str) {
        if (bVar != null && bVar.aVP() != null && !TextUtils.isEmpty(str)) {
            bVar.aVP().log(str);
        }
    }
}
