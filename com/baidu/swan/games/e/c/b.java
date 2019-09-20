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
    private static volatile b bgY;
    private HashMap<String, c> bfx = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object bfA = new Object();
    private com.baidu.swan.games.network.b bfz = com.baidu.swan.games.network.b.SF();
    private String bfy = f.Rb();

    public static b RW() {
        if (bgY == null) {
            synchronized (b.class) {
                if (bgY == null) {
                    bgY = new b();
                }
            }
        }
        return bgY;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String iU = iU(str);
            File file = new File(iU(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(iU);
                    return;
                }
                return;
            }
            synchronized (this.bfA) {
                if (!iS(str)) {
                    iT(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean iS(String str) {
        return this.bfx.containsKey(str);
    }

    private void iT(String str) {
        c cVar = new c(this.bfz, this.bfy, str, this);
        this.bfx.put(str, cVar);
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
        synchronized (this.bfA) {
            if (iS(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bfx.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void t(int i, String str) {
        synchronized (this.bfA) {
            if (iS(str) && this.mCallbackMap.get(str) != null) {
                this.bfx.remove(str);
            }
        }
    }

    private String iU(String str) throws MalformedURLException {
        return this.bfy + f.iQ(str);
    }
}
