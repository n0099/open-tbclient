package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cgb;
    private HashMap<String, c> cga = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b cgc = com.baidu.swan.games.network.b.amC();

    public b(String str) {
        this.cgb = str;
    }

    private boolean nZ(String str) {
        return this.cga.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.mObject) {
            if (!nZ(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                oa(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void oa(String str) {
        if (DEBUG) {
            Log.d("AudioDownloadManager", "AudioDownloader SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.cgc, this.cgb, str, this);
        this.cga.put(str, cVar);
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
    public void br(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (nZ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).br(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.cga.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void E(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.mObject) {
            if (nZ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).E(i, str);
                }
                this.cga.remove(str);
            }
        }
    }
}
