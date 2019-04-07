package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bag;
    private HashMap<String, c> baf = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object bai = new Object();
    private com.baidu.swan.games.network.b bah = com.baidu.swan.games.network.b.OD();

    public b(String str) {
        this.bag = str;
    }

    private boolean hY(String str) {
        return this.baf.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.bai) {
            if (!hY(str)) {
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
        c cVar = new c(this.bah, this.bag, str, this);
        this.baf.put(str, cVar);
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
        synchronized (this.bai) {
            if (hY(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aN(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.baf.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void s(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.bai) {
            if (hY(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).s(i, str);
                }
                this.baf.remove(str);
            }
        }
    }
}
