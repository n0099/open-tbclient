package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dqI;
    private com.baidu.swan.games.network.b dqJ;
    private HashMap<String, c> dqH = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();

    public b(String str) {
        this.dqI = str;
    }

    private boolean uU(String str) {
        return this.dqH.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.mObject) {
            if (!uU(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                uV(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void uV(String str) {
        if (DEBUG) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.dqJ == null) {
            this.dqJ = com.baidu.swan.games.network.b.aPn();
        }
        c cVar = new c(this.dqJ, this.dqI, str, this);
        this.dqH.put(str, cVar);
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
    public void cA(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (uU(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).cA(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.dqH.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void ad(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (uU(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).ad(i, str);
                }
                this.dqH.remove(str);
            }
        }
    }
}
