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
    private static volatile b bbM;
    private HashMap<String, c> bag = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object baj = new Object();
    private com.baidu.swan.games.network.b bai = com.baidu.swan.games.network.b.OD();
    private String bah = e.Nl();

    public static b Oe() {
        if (bbM == null) {
            synchronized (b.class) {
                if (bbM == null) {
                    bbM = new b();
                }
            }
        }
        return bbM;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String hZ = hZ(str);
            File file = new File(hZ(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(hZ);
                    return;
                }
                return;
            }
            synchronized (this.baj) {
                if (!hY(str)) {
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

    private boolean hY(String str) {
        return this.bag.containsKey(str);
    }

    private void download(String str) {
        c cVar = new c(this.bai, this.bah, str, this);
        this.bag.put(str, cVar);
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
        synchronized (this.baj) {
            if (hY(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bag.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void s(int i, String str) {
        synchronized (this.baj) {
            if (hY(str) && this.mCallbackMap.get(str) != null) {
                this.bag.remove(str);
            }
        }
    }

    private String hZ(String str) throws MalformedURLException {
        return this.bah + e.hW(str);
    }
}
