package com.baidu.swan.games.w;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.games.w.a.d;
/* loaded from: classes10.dex */
public class a extends c {
    public a(com.baidu.swan.games.f.b bVar) {
        super(bVar);
    }

    public void getStorage(JsObject jsObject) {
        String a2 = a(jsObject, "getStorage");
        if (a2 != null) {
            d xF = xF(a2);
            if (xF.isSuccess()) {
                com.baidu.swan.games.w.a.b bVar = new com.baidu.swan.games.w.a.b();
                bVar.errMsg = com.baidu.swan.games.w.a.a.xH("getStorage");
                bVar.data = xF.getData();
                if (bVar.data instanceof JsSerializeValue) {
                    ((JsSerializeValue) bVar.data).setAutoRelease(false);
                }
                com.baidu.swan.games.utils.b.a(k(jsObject), true, bVar);
                return;
            }
            a(jsObject, "getStorage", a2, xF);
        }
    }

    public void setStorage(JsObject jsObject) {
        String a2 = a(jsObject, "setStorage");
        if (a2 != null) {
            a(jsObject, "setStorage", a2, a(a2, m(jsObject)));
        }
    }

    public void removeStorage(JsObject jsObject) {
        String a2 = a(jsObject, "removeStorage");
        if (a2 != null) {
            a(jsObject, "removeStorage", a2, xG(a2));
        }
    }

    public void clearStorage(JsObject jsObject) {
        a(jsObject, "clearStorage", "", aXl());
    }

    public void getStorageInfo(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        com.baidu.swan.games.w.a.c storageInfoSync = getStorageInfoSync();
        storageInfoSync.errMsg = com.baidu.swan.games.w.a.a.xH("getStorageInfo");
        com.baidu.swan.games.utils.b.a(k, true, storageInfoSync);
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c k(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c e = com.baidu.swan.games.binding.model.c.e(jsObject);
        return e == null ? new com.baidu.swan.games.binding.model.c() : e;
    }

    private String a(JsObject jsObject, String str) {
        d l = l(jsObject);
        if (l.isSuccess()) {
            return (String) l.getData();
        }
        a(jsObject, str, "", l);
        return null;
    }

    private d l(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("key".equals(jsObject.getPropertyName(i))) {
                int propertyType = jsObject.getPropertyType(i);
                if (propertyType == 7) {
                    return d.ah(jsObject.toString(i));
                }
                return d.xI(String.format("parameter error: the key must be string instead of %s.", d.mk(propertyType)));
            }
        }
        return d.xI("parameter error: the parameter key is necessary.");
    }

    private JsSerializeValue m(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("data".equals(jsObject.getPropertyName(i))) {
                return jsObject.toSerializeValue(i);
            }
        }
        return null;
    }

    private void a(JsObject jsObject, String str, String str2, d dVar) {
        com.baidu.swan.games.binding.model.c k = k(jsObject);
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        boolean isSuccess = dVar.isSuccess();
        bVar.errMsg = dVar.dk(str, str2);
        com.baidu.swan.games.utils.b.a(k, isSuccess, bVar);
        if (!isSuccess) {
            com.baidu.swan.games.v.c.dj(str2, bVar.errMsg);
        }
    }
}
