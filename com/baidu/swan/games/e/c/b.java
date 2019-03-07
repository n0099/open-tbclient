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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile b bbH;
    private HashMap<String, c> bab = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object bae = new Object();
    private com.baidu.swan.games.network.b bad = com.baidu.swan.games.network.b.OF();
    private String bac = e.Nn();

    public static b Og() {
        if (bbH == null) {
            synchronized (b.class) {
                if (bbH == null) {
                    bbH = new b();
                }
            }
        }
        return bbH;
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
            synchronized (this.bae) {
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
        return this.bab.containsKey(str);
    }

    private void download(String str) {
        c cVar = new c(this.bad, this.bac, str, this);
        this.bab.put(str, cVar);
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
        synchronized (this.bae) {
            if (hX(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bab.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void s(int i, String str) {
        synchronized (this.bae) {
            if (hX(str) && this.mCallbackMap.get(str) != null) {
                this.bab.remove(str);
            }
        }
    }

    private String hY(String str) throws MalformedURLException {
        return this.bac + e.hV(str);
    }
}
