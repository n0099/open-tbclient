package com.baidu.swan.games.f.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes10.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dTO;
    private HashMap<String, c> dRa = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b dRc = com.baidu.swan.games.network.b.aWq();
    private String dRb = f.aSN();

    public static b aVa() {
        if (dTO == null) {
            synchronized (b.class) {
                if (dTO == null) {
                    dTO = new b();
                }
            }
        }
        return dTO;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String wp = wp(str);
            File file = new File(wp(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(wp);
                    return;
                }
                return;
            }
            synchronized (this.mObject) {
                if (!wn(str)) {
                    wo(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean wn(String str) {
        return this.dRa.containsKey(str);
    }

    private void wo(String str) {
        if (DEBUG) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.dRc, this.dRb, str, this);
        this.dRa.put(str, cVar);
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
    public void cM(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (wn(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.dRa.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.f.c.a
    public void au(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (wn(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.dRa.remove(str);
            }
        }
    }

    private String wp(String str) throws MalformedURLException {
        return this.dRb + f.wk(str);
    }
}
