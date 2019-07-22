package com.baidu.swan.games.s;

import android.support.annotation.NonNull;
import android.util.Base64;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.games.s.a.d;
/* loaded from: classes2.dex */
public class c {
    protected com.baidu.swan.games.e.b beU;
    protected b bll = new b();

    public c(com.baidu.swan.games.e.b bVar) {
        this.beU = bVar;
    }

    @NonNull
    public d jX(String str) {
        Object obj = null;
        if (str == null) {
            return d.ka("parameter error: the key cannot be null.");
        }
        String string = this.bll.getString(str, null);
        if (string != null) {
            obj = this.beU.c(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.To();
        }
        return d.Q(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            return d.ka("parameter error: the key cannot be null.");
        }
        if (jsSerializeValue == null) {
            return d.Q(null);
        }
        byte[] a = this.beU.a(jsSerializeValue, true);
        jsSerializeValue.release();
        if (a == null) {
            return d.ka("parameter error: the data parse failed.");
        }
        String encodeToString = Base64.encodeToString(a, 2);
        String string = this.bll.getString(str, null);
        int length = str.getBytes().length;
        if (this.bll.NU() - this.bll.NT() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
            return d.ka("storage error: the storage space insufficient.");
        }
        boolean bh = this.bll.bh(str, encodeToString);
        e.aZD.update();
        return bh ? d.Q(null) : d.ka("storage error: the storage is invalid.");
    }

    @NonNull
    public d jY(String str) {
        if (str == null) {
            return d.ka("parameter error: the key cannot be null.");
        }
        this.bll.remove(str);
        e.aZD.update();
        return d.Q(null);
    }

    @NonNull
    public d Tm() {
        this.bll.Tk();
        e.aZD.update();
        return d.Q(null);
    }

    @NonNull
    public com.baidu.swan.games.s.a.c getStorageInfoSync() {
        String[] Tj = this.bll.Tj();
        com.baidu.swan.games.s.a.c cVar = new com.baidu.swan.games.s.a.c();
        cVar.keys = Tj;
        cVar.currentSize = this.bll.NT() / 1024;
        cVar.limitSize = this.bll.NU() / 1024;
        cVar.errMsg = com.baidu.swan.games.s.a.a.jZ("getStorageInfoSync");
        return cVar;
    }
}
