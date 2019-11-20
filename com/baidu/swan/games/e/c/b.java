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
    private static volatile b byZ;
    private HashMap<String, c> bxz = new HashMap<>();
    private HashMap<String, ArrayList<ValueCallback<String>>> mCallbackMap = new HashMap<>();
    private final Object bxC = new Object();
    private com.baidu.swan.games.network.b bxB = com.baidu.swan.games.network.b.Xu();
    private String bxA = f.VP();

    public static b WL() {
        if (byZ == null) {
            synchronized (b.class) {
                if (byZ == null) {
                    byZ = new b();
                }
            }
        }
        return byZ;
    }

    public void a(String str, ValueCallback<String> valueCallback) {
        if (TextUtils.isEmpty(str)) {
            valueCallback.onReceiveValue(null);
            return;
        }
        try {
            String jx = jx(str);
            File file = new File(jx(str));
            if (file.exists() && !file.isDirectory()) {
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(jx);
                    return;
                }
                return;
            }
            synchronized (this.bxC) {
                if (!jv(str)) {
                    jw(str);
                }
                b(str, valueCallback);
            }
        } catch (Exception e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private boolean jv(String str) {
        return this.bxz.containsKey(str);
    }

    private void jw(String str) {
        c cVar = new c(this.bxB, this.bxA, str, this);
        this.bxz.put(str, cVar);
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
    public void aX(String str, String str2) {
        ArrayList<ValueCallback<String>> arrayList;
        synchronized (this.bxC) {
            if (jv(str) && (arrayList = this.mCallbackMap.get(str)) != null) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    arrayList.get(i).onReceiveValue(str2);
                    if (DEBUG) {
                        Log.e("ImageDownloadManager", i + " load success url = " + str + " path = " + str2);
                    }
                }
                this.bxz.remove(str);
            }
        }
    }

    @Override // com.baidu.swan.games.e.c.a
    public void w(int i, String str) {
        synchronized (this.bxC) {
            if (jv(str) && this.mCallbackMap.get(str) != null) {
                this.bxz.remove(str);
            }
        }
    }

    private String jx(String str) throws MalformedURLException {
        return this.bxA + f.jt(str);
    }
}
