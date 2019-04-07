package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.q.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b bac;
    protected b bfm = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.bac = bVar;
    }

    @NonNull
    public d iX(String str) {
        Object obj = null;
        if (str == null) {
            return d.ja("parameter error: the key cannot be null.");
        }
        String string = this.bfm.getString(str, null);
        if (string != null) {
            obj = this.bac.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.Pc();
        }
        return d.Q(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.ja("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.Q(null);
        }
        byte[] a = this.bac.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.ja("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bfm.getString(str, null);
        int length = str.getBytes().length;
        if (this.bfm.KG() - this.bfm.KF() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.ja("storage error: the storage space insufficient.");
        }
        boolean be = this.bfm.be(str, encodeToString);
        e.aVS.update();
        return be ? d.Q(null) : d.ja("storage error: the storage is invalid.");
    }

    @NonNull
    public d iY(String str) {
        if (str == null) {
            return d.ja("parameter error: the key cannot be null.");
        }
        this.bfm.remove(str);
        e.aVS.update();
        return d.Q(null);
    }

    @NonNull
    public d Pa() {
        this.bfm.OY();
        e.aVS.update();
        return d.Q(null);
    }

    @NonNull
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        String[] OX = this.bfm.OX();
        com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
        cVar.keys = OX;
        cVar.currentSize = this.bfm.KF() / 1024;
        cVar.limitSize = this.bfm.KG() / 1024;
        cVar.errMsg = com.baidu.swan.games.q.a.a.iZ("getStorageInfoSync");
        return cVar;
    }
}
