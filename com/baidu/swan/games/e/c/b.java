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
    private static volatile b bgA;
    private HashMap<String, c> beY = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object bfc = new Object();
    private com.baidu.swan.games.network.b bfa = com.baidu.swan.games.network.b.SB();
    private String beZ = f.QX();

    public static b RS() {
        if (bgA == null) {
            synchronized (b.class) {
                if (bgA == null) {
                    bgA = new b();
                }
            }
        }
        return bgA;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String iS = iS(str);
            File file = new File(iS(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(iS);
                    return;
                }
                return;
            }
            synchronized (this.bfc) {
                if (!iQ(str)) {
                    iR(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean iQ(String str) {
        return this.beY.containsKey(str);
    }

    private void iR(String str) {
        c cVar = new c(this.bfa, this.beZ, str, this);
        this.beY.put(str, cVar);
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
        synchronized (this.bfc) {
            if (iQ(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.beY.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void t(int i, String str) {
        synchronized (this.bfc) {
            if (iQ(str) && this.mCallbackMap.get(str) != null) {
                this.beY.remove(str);
            }
        }
    }

    private String iS(String str) throws MalformedURLException {
        return this.beZ + f.iO(str);
    }
}
