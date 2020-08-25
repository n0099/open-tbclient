package com.baidu.swan.games.f.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b drq;
    private HashMap<String, c> doC = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b doE = com.baidu.swan.games.network.b.aOC();
    private String doD = f.aKZ();

    public static b aNm() {
        if (drq == null) {
            synchronized (b.class) {
                if (drq == null) {
                    drq = new b();
                }
            }
        }
        return drq;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String uC = uC(str);
            File file = new File(uC(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(uC);
                    return;
                }
                return;
            }
            synchronized (this.mObject) {
                if (!uA(str)) {
                    uB(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean uA(String str) {
        return this.doC.containsKey(str);
    }

    private void uB(String str) {
        if (DEBUG) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.doE, this.doD, str, this);
        this.doC.put(str, cVar);
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

    @Override // com.baidu.swan.games.f.c.a
    public void cA(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (uA(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.doC.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.f.c.a
    public void ac(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (uA(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.doC.remove(str);
            }
        }
    }

    private String uC(String str) throws MalformedURLException {
        return this.doD + f.ux(str);
    }
}
