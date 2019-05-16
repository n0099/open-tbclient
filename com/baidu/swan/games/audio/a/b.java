package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bem;
    private HashMap<String, c> bel = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object beo = new Object();
    private com.baidu.swan.games.network.b ben = com.baidu.swan.games.network.b.RI();

    public b(String str) {
        this.bem = str;
    }

    private boolean iK(String str) {
        return this.bel.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.beo) {
            if (!iK(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                iL(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void iL(String str) {
        c cVar = new c(this.ben, this.bem, str, this);
        this.bel.put(str, cVar);
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
    public void aQ(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.beo) {
            if (iK(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aQ(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bel.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void t(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.beo) {
            if (iK(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).t(i, str);
                }
                this.bel.remove(str);
            }
        }
    }
}
