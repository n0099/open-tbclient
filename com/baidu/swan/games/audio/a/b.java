package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String dRb;
    private com.baidu.swan.games.network.b dRc;
    private HashMap<String, c> dRa = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();

    public b(String str) {
        this.dRb = str;
    }

    private boolean wn(String str) {
        return this.dRa.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.mObject) {
            if (!wn(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                wo(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void wo(String str) {
        if (DEBUG) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        if (this.dRc == null) {
            this.dRc = com.baidu.swan.games.network.b.aWq();
        }
        c cVar = new c(this.dRc, this.dRb, str, this);
        this.dRa.put(str, cVar);
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
    public void cM(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (wn(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).cM(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.dRa.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void au(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (wn(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).au(i, str);
                }
                this.dRa.remove(str);
            }
        }
    }
}
