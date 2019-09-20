package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bfy;
    private HashMap<String, c> bfx = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object bfA = new Object();
    private com.baidu.swan.games.network.b bfz = com.baidu.swan.games.network.b.SF();

    public b(String str) {
        this.bfy = str;
    }

    private boolean iS(String str) {
        return this.bfx.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.bfA) {
            if (!iS(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                iT(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void iT(String str) {
        c cVar = new c(this.bfz, this.bfy, str, this);
        this.bfx.put(str, cVar);
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
        synchronized (this.bfA) {
            if (iS(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aQ(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bfx.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void t(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.bfA) {
            if (iS(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).t(i, str);
                }
                this.bfx.remove(str);
            }
        }
    }
}
