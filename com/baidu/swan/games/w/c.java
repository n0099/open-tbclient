package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.an.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes11.dex */
public class c {
    protected com.baidu.swan.games.f.b cYE;
    protected b dhn = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.cYE = bVar;
    }

    @NonNull
    public d sE(String str) {
        Object obj = null;
        if (str == null) {
            return d.sH("parameter error: the key cannot be null.");
        }
        String string = this.dhn.getString(str, null);
        if (string != null) {
            obj = this.cYE.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aDb();
        }
        return d.ad(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.sH("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ad(null);
        } else {
            byte[] a = this.cYE.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a == null) {
                return d.sH("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a, 2);
            String string = this.dhn.getString(str, null);
            int length = str.getBytes().length;
            if (this.dhn.asI() - this.dhn.asH() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.sH("storage error: the storage space insufficient.");
            }
            boolean putString = this.dhn.putString(str, encodeToString);
            e.cNN.update();
            return putString ? d.ad(null) : d.sH("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d sF(String str) {
        if (str == null) {
            return d.sH("parameter error: the key cannot be null.");
        }
        this.dhn.remove(str);
        e.cNN.update();
        return d.ad(null);
    }

    @NonNull
    public d aCZ() {
        this.dhn.aCW();
        e.cNN.update();
        return d.ad(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aCV = this.dhn.aCV();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aCV;
        cVar.currentSize = this.dhn.asH() / 1024;
        cVar.limitSize = this.dhn.asI() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.sG("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
