package com.baidu.swan.games.s;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.s.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b beh;
    protected b bky = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.beh = bVar;
    }

    @NonNull
    public d jQ(String str) {
        Object obj = null;
        if (str == null) {
            return d.jT("parameter error: the key cannot be null.");
        }
        String string = this.bky.getString(str, null);
        if (string != null) {
            obj = this.beh.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.Sv();
        }
        return d.Q(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.jT("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.Q(null);
        }
        byte[] a = this.beh.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.jT("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bky.getString(str, null);
        int length = str.getBytes().length;
        if (this.bky.Nf() - this.bky.Ne() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.jT("storage error: the storage space insufficient.");
        }
        boolean bh = this.bky.bh(str, encodeToString);
        e.aYT.update();
        return bh ? d.Q(null) : d.jT("storage error: the storage is invalid.");
    }

    @NonNull
    public d jR(String str) {
        if (str == null) {
            return d.jT("parameter error: the key cannot be null.");
        }
        this.bky.remove(str);
        e.aYT.update();
        return d.Q(null);
    }

    @NonNull
    public d St() {
        this.bky.Sr();
        e.aYT.update();
        return d.Q(null);
    }

    @NonNull
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        String[] Sq = this.bky.Sq();
        com.baidu.swan.games.s.a.c cVar = new com.baidu.swan.games.s.a.c();
        cVar.keys = Sq;
        cVar.currentSize = this.bky.Ne() / 1024;
        cVar.limitSize = this.bky.Nf() / 1024;
        cVar.errMsg = com.baidu.swan.games.s.a.a.jS("getStorageInfoSync");
        return cVar;
    }
}
