package com.baidu.swan.games.w;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes8.dex */
public class c {
    protected com.baidu.swan.games.f.b eee;
    protected b emI = new b();

    public c(com.baidu.swan.games.f.b bVar) {
        this.eee = bVar;
    }

    @NonNull
    public d xv(String str) {
        Object obj = null;
        if (str == null) {
            return d.xy("parameter error: the key cannot be null.");
        }
        String string = this.emI.getString(str, null);
        if (string != null) {
            obj = this.eee.d(Base64.decode(string, 2), true);
        }
        if (obj == null) {
            obj = d.aYA();
        }
        return d.ak(obj);
    }

    @NonNull
    public d a(String str, JsSerializeValue jsSerializeValue) {
        if (str == null) {
            a(jsSerializeValue);
            return d.xy("parameter error: the key cannot be null.");
        } else if (jsSerializeValue == null) {
            return d.ak(null);
        } else {
            byte[] a2 = this.eee.a(jsSerializeValue, true);
            a(jsSerializeValue);
            if (a2 == null) {
                return d.xy("parameter error: the data parse failed.");
            }
            String encodeToString = Base64.encodeToString(a2, 2);
            String string = this.emI.getString(str, null);
            int length = str.getBytes().length;
            if (this.emI.aLX() - this.emI.aLW() < (encodeToString.length() + length) - (string == null ? 0 : string.length() + length)) {
                return d.xy("storage error: the storage space insufficient.");
            }
            boolean putString = this.emI.putString(str, encodeToString);
            e.dPF.update();
            return putString ? d.ak(null) : d.xy("storage error: the storage is invalid.");
        }
    }

    @NonNull
    public d xw(String str) {
        if (str == null) {
            return d.xy("parameter error: the key cannot be null.");
        }
        this.emI.remove(str);
        e.dPF.update();
        return d.ak(null);
    }

    @NonNull
    public d aYy() {
        this.emI.aYv();
        e.dPF.update();
        return d.ak(null);
    }

    @NonNull
    public com.baidu.swan.games.w.a.c getStorageInfoSync() {
        String[] aYu = this.emI.aYu();
        com.baidu.swan.games.w.a.c cVar = new com.baidu.swan.games.w.a.c();
        cVar.keys = aYu;
        cVar.currentSize = this.emI.aLW() / 1024;
        cVar.limitSize = this.emI.aLX() / 1024;
        cVar.errMsg = com.baidu.swan.games.w.a.a.xx("getStorageInfoSync");
        return cVar;
    }

    private void a(JsSerializeValue jsSerializeValue) {
        if (jsSerializeValue != null) {
            jsSerializeValue.release();
        }
    }
}
