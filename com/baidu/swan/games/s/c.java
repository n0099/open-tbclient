package com.baidu.swan.games.s;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.s.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b bft;
    protected b blJ = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.bft = bVar;
    }

    @NonNull
    public d jZ(String str) {
        Object obj = null;
        if (str == null) {
            return d.kc("parameter error: the key cannot be null.");
        }
        String string = this.blJ.getString(str, null);
        if (string != null) {
            obj = this.bft.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.Ts();
        }
        return d.Q(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.kc("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.Q(null);
        }
        byte[] a = this.bft.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.kc("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.blJ.getString(str, null);
        int length = str.getBytes().length;
        if (this.blJ.NY() - this.blJ.NX() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.kc("storage error: the storage space insufficient.");
        }
        boolean bh = this.blJ.bh(str, encodeToString);
        e.bab.update();
        return bh ? d.Q(null) : d.kc("storage error: the storage is invalid.");
    }

    @NonNull
    public d ka(String str) {
        if (str == null) {
            return d.kc("parameter error: the key cannot be null.");
        }
        this.blJ.remove(str);
        e.bab.update();
        return d.Q(null);
    }

    @NonNull
    public d Tq() {
        this.blJ.To();
        e.bab.update();
        return d.Q(null);
    }

    @NonNull
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        String[] Tn = this.blJ.Tn();
        com.baidu.swan.games.s.a.c cVar = new com.baidu.swan.games.s.a.c();
        cVar.keys = Tn;
        cVar.currentSize = this.blJ.NX() / 1024;
        cVar.limitSize = this.blJ.NY() / 1024;
        cVar.errMsg = com.baidu.swan.games.s.a.a.kb("getStorageInfoSync");
        return cVar;
    }
}
