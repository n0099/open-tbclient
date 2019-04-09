package com.baidu.swan.games.q;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.q.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b bad;
    protected b bfn = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.bad = bVar;
    }

    @NonNull
    public d iX(String str) {
        Object obj = null;
        if (str == null) {
            return d.ja("parameter error: the key cannot be null.");
        }
        String string = this.bfn.getString(str, null);
        if (string != null) {
            obj = this.bad.c(Base64.decode(string, 2), true);
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
        byte[] a = this.bad.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.ja("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bfn.getString(str, null);
        int length = str.getBytes().length;
        if (this.bfn.KG() - this.bfn.KF() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.ja("storage error: the storage space insufficient.");
        }
        boolean be = this.bfn.be(str, encodeToString);
        e.aVT.update();
        return be ? d.Q(null) : d.ja("storage error: the storage is invalid.");
    }

    @NonNull
    public d iY(String str) {
        if (str == null) {
            return d.ja("parameter error: the key cannot be null.");
        }
        this.bfn.remove(str);
        e.aVT.update();
        return d.Q(null);
    }

    @NonNull
    public d Pa() {
        this.bfn.OY();
        e.aVT.update();
        return d.Q(null);
    }

    @NonNull
    public com.baidu.swan.games.q.a.c getStorageInfoSync() {
        String[] OX = this.bfn.OX();
        com.baidu.swan.games.q.a.c cVar = new com.baidu.swan.games.q.a.c();
        cVar.keys = OX;
        cVar.currentSize = this.bfn.KF() / 1024;
        cVar.limitSize = this.bfn.KG() / 1024;
        cVar.errMsg = com.baidu.swan.games.q.a.a.iZ("getStorageInfoSync");
        return cVar;
    }
}
