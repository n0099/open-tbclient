package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes11.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cYK;
    private HashMap<String, c> cYJ = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b cYL = com.baidu.swan.games.network.b.aCe();

    public b(String str) {
        this.cYK = str;
    }

    private boolean rk(String str) {
        return this.cYJ.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.mObject) {
            if (!rk(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                rl(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void rl(String str) {
        if (DEBUG) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.cYL, this.cYK, str, this);
        this.cYJ.put(str, cVar);
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
    public void cg(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (rk(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).cg(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.cYJ.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void ad(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (rk(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).ad(i, str);
                }
                this.cYJ.remove(str);
            }
        }
    }
}
