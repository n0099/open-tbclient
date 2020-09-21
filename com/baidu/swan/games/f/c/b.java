package com.baidu.swan.games.f.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dty;
    private HashMap<String, c> dqH = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b dqJ = com.baidu.swan.games.network.b.aPn();
    private String dqI = f.aLK();

    public static b aNX() {
        if (dty == null) {
            synchronized (b.class) {
                if (dty == null) {
                    dty = new b();
                }
            }
        }
        return dty;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String uW = uW(str);
            File file = new File(uW(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(uW);
                    return;
                }
                return;
            }
            synchronized (this.mObject) {
                if (!uU(str)) {
                    uV(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean uU(String str) {
        return this.dqH.containsKey(str);
    }

    private void uV(String str) {
        if (DEBUG) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.dqJ, this.dqI, str, this);
        this.dqH.put(str, cVar);
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
            if (uU(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.dqH.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.f.c.a
    public void ad(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (uU(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.dqH.remove(str);
            }
        }
    }

    private String uW(String str) throws MalformedURLException {
        return this.dqI + f.uR(str);
    }
}
