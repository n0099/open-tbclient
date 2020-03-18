package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cks;
    private HashMap<String, c> ckr = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b ckt = com.baidu.swan.games.network.b.aoU();

    public b(String str) {
        this.cks = str;
    }

    private boolean op(String str) {
        return this.ckr.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.mObject) {
            if (!op(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                oq(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void oq(String str) {
        if (DEBUG) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.ckt, this.cks, str, this);
        this.ckr.put(str, cVar);
        cVar.load();
    }

    private void b(String str, a aVar) {
        if (this.mCallbackMap.containsKey(str)) {
            this.mCallbackMap.get(str).add(aVar);
            return;
        }
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(aVar);
        this.mCallbackMap.put(str, arrayList);
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void bz(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (op(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).bz(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.ckr.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void G(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (op(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).G(i, str);
                }
                this.ckr.remove(str);
            }
        }
    }
}
