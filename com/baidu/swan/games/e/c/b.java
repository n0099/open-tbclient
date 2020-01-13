package com.baidu.swan.games.e.c;

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
    private static volatile b ciG;
    private HashMap<String, c> cga = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object mObject = new Object();
    private com.baidu.swan.games.network.b cgc = com.baidu.swan.games.network.b.amC();
    private String cgb = f.ajf();

    public static b als() {
        if (ciG == null) {
            synchronized (b.class) {
                if (ciG == null) {
                    ciG = new b();
                }
            }
        }
        return ciG;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String ob = ob(str);
            File file = new File(ob(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(ob);
                    return;
                }
                return;
            }
            synchronized (this.mObject) {
                if (!nZ(str)) {
                    oa(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean nZ(String str) {
        return this.cga.containsKey(str);
    }

    private void oa(String str) {
        if (DEBUG) {
            Log.d("ImageDownloadManager", "ImageDownloadManager SwanGamePreloadManager url:" + str);
        }
        c cVar = new c(this.cgc, this.cgb, str, this);
        this.cga.put(str, cVar);
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
    public void br(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (nZ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.cga.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void E(int i, String str) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.mObject) {
            if (nZ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.get(i2).onReceiveValue("");
                }
                this.cga.remove(str);
            }
        }
    }

    private String ob(String str) throws MalformedURLException {
        return this.cgb + f.nW(str);
    }
}
