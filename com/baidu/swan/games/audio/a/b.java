package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String byr;
    private HashMap<String, c> byq = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object byt = new Object();
    private com.baidu.swan.games.network.b bys = com.baidu.swan.games.network.b.Xw();

    public b(String str) {
        this.byr = str;
    }

    private boolean jv(String str) {
        return this.byq.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.byt) {
            if (!jv(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                jw(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void jw(String str) {
        c cVar = new c(this.bys, this.byr, str, this);
        this.byq.put(str, cVar);
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
    public void aX(String str, String str2) {
        ArrayList<a> arrayList;
        synchronized (this.byt) {
            if (jv(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aX(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.byq.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void x(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.byt) {
            if (jv(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).x(i, str);
                }
                this.byq.remove(str);
            }
        }
    }
}
