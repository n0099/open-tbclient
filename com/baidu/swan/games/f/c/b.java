package com.baidu.swan.games.f.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.f;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b dhh;
    private HashMap<String, c> deu = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b dew = com.baidu.swan.games.network.b.aFL();
    private String dev = f.aCk();

    public static b aEx() {
        if (dhh == null) {
            synchronized (b.class) {
                if (dhh == null) {
                    dhh = new b();
                }
            }
        }
        return dhh;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String sk = sk(str);
            File file = new File(sk(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(sk);
                    return;
                }
                return;
            }
            synchronized (this.mObject) {
                if (!si(str)) {
                    sj(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean si(String str) {
        return this.deu.containsKey(str);
    }

    private void sj(String str) {
        if (DEBUG) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.dew, this.dev, str, this);
        this.deu.put(str, cVar);
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
    public void ch(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (si(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.deu.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.f.c.a
    public void ae(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (si(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.deu.remove(str);
            }
        }
    }

    private String sk(String str) throws MalformedURLException {
        return this.dev + f.sf(str);
    }
}
