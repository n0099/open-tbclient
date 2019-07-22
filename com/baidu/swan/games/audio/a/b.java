package com.baidu.swan.games.audio.a;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String beZ;
    private HashMap<String, c> beY = new HashMap<>();
    private HashMap<String, ArrayList<a>> mCallbackMap = new HashMap<>();
    private final Object bfc = new Object();
    private com.baidu.swan.games.network.b bfa = com.baidu.swan.games.network.b.SB();

    public b(String str) {
        this.beZ = str;
    }

    private boolean iQ(String str) {
        return this.beY.containsKey(str);
    }

    public void a(String str, a aVar) {
        synchronized (this.bfc) {
            if (!iQ(str)) {
                if (DEBUG) {
                    Log.e("AudioDownloadManager", "start load url = " + str);
                }
                iR(str);
            } else if (DEBUG) {
                Log.e("AudioDownloadManager", "re load url = " + str);
            }
            b(str, aVar);
        }
    }

    public void iR(String str) {
        c cVar = new c(this.bfa, this.beZ, str, this);
        this.beY.put(str, cVar);
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
        synchronized (this.bfc) {
            if (iQ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).aQ(str, str2);
                    if (DEBUG) {
                        Log.e("AudioDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.beY.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.audio.a.a
    public void t(int i, String str) {
        ArrayList<a> arrayList;
        synchronized (this.bfc) {
            if (iQ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).t(i, str);
                }
                this.beY.remove(str);
            }
        }
    }
}
