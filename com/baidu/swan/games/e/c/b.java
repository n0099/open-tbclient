package com.baidu.swan.games.e.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bfN;
    private HashMap<String, c> bel = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object beo = new Object();
    private com.baidu.swan.games.network.b ben = com.baidu.swan.games.network.b.RI();
    private String bem = f.Qf();

    public static b QZ() {
        if (bfN == null) {
            synchronized (b.class) {
                if (bfN == null) {
                    bfN = new b();
                }
            }
        }
        return bfN;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String iM = iM(str);
            File file = new File(iM(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(iM);
                    return;
                }
                return;
            }
            synchronized (this.beo) {
                if (!iK(str)) {
                    iL(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean iK(String str) {
        return this.bel.containsKey(str);
    }

    private void iL(String str) {
        c cVar = new c(this.ben, this.bem, str, this);
        this.bel.put(str, cVar);
        cVar.load();
    }

    private void b(String str, ValueCallback<String> valueCallback) {
        if (this.mCallbackMap.containsKey(str)) {
            this.mCallbackMap.get(str).add(valueCallback);
            return;
        }
        ArrayList<ValueCallback<String>> arrayList = new ArrayList<>();
        arrayList.add(valueCallback);
        this.mCallbackMap.put(str, arrayList);
    }

    @Override // com.baidu.swan.games.e.c.a
    public void aQ(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.beo) {
            if (iK(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bel.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void t(int i, String str) {
        synchronized (this.beo) {
            if (iK(str) && this.mCallbackMap.get(str) != null) {
                this.bel.remove(str);
            }
        }
    }

    private String iM(String str) throws MalformedURLException {
        return this.bem + f.iI(str);
    }
}
