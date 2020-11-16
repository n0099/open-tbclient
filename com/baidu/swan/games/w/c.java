package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.am.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes7.dex */
public class c {
    protected com.baidu.swan.games.f.b dPn;
    protected b dXO = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.dPn = bVar;
    }

    @NonNull
    public d xA(String str) {
        Object obj = null;
        if (str == null) {
            return d.xD("parameter error: the key cannot be null.");
        }
        String string = this.dXO.getString(str, null);
        if (string != null) {
            obj = this.dPn.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aWF();
        }
        return d.ah(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xD("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ah(null);
        } else {
            byte[] a2 = this.dPn.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xD("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.dXO.getString(str, null);
            int length = str.getBytes().length;
            if (this.dXO.aJX() - this.dXO.aJW() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xD("storage error: the storage space insufficient.");
            }
            boolean putString = this.dXO.putString(str, encodeToString);
            e.dBj.update();
            return putString ? d.ah(null) : d.xD("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d xB(String str) {
        if (str == null) {
            return d.xD("parameter error: the key cannot be null.");
        }
        this.dXO.remove(str);
        e.dBj.update();
        return d.ah(null);
    }

    @NonNull
    public d aWD() {
        this.dXO.aWA();
        e.dBj.update();
        return d.ah(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aWz = this.dXO.aWz();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aWz;
        cVar.currentSize = this.dXO.aJW() / 1024;
        cVar.limitSize = this.dXO.aJX() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xC("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
