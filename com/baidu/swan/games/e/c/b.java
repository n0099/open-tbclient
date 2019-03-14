package com.baidu.swan.games.e.c;

import android.text.TextUtils;
import android.util.Log;
import android.webkit.ValueCallback;
import com.baidu.swan.games.audio.e;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class b implements a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile b bbI;
    private HashMap<String, c> bac = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object baf = new Object();
    private com.baidu.swan.games.network.b bae = com.baidu.swan.games.network.b.OF();
    private String bad = e.Nn();

    public static b Og() {
        if (bbI == null) {
            synchronized (b.class) {
                if (bbI == null) {
                    bbI = new b();
                }
            }
        }
        return bbI;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String hY = hY(str);
            File file = new File(hY(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(hY);
                    return;
                }
                return;
            }
            synchronized (this.baf) {
                if (!hX(str)) {
                    download(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean hX(String str) {
        return this.bac.containsKey(str);
    }

    private void download(String str) {
        c cVar = new c(this.bae, this.bad, str, this);
        this.bac.put(str, cVar);
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
    public void aN(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.baf) {
            if (hX(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bac.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void s(int i, String str) {
        synchronized (this.baf) {
            if (hX(str) && this.mCallbackMap.get(str) != null) {
                this.bac.remove(str);
            }
        }
    }

    private String hY(String str) throws MalformedURLException {
        return this.bad + e.hV(str);
    }
}
