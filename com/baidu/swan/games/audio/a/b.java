package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private String bac;
    private HashMap<String, c> bab = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object bae = new Object();
    private com.baidu.swan.games.network.b bad = com.baidu.swan.games.network.b.OF();

    public b(String str) {
        this.bac = str;
    }

    private boolean hX(String str) {
        return this.bab.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.bae) {
            if (!hX(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                download(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void download(String str) {
        c cVar = new c(this.bad, this.bac, str, this);
        this.bab.put(str, cVar);
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
    public void aN(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.bae) {
            if (hX(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aN(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bab.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void s(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.bae) {
            if (hX(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).s(i, str);
                }
                this.bab.remove(str);
            }
        }
    }
}
