package com.baidu.swan.games.v;

import android.support.annotation.NonNull;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.searchbox.v8engine.JsSerializeValue;
import com.baidu.swan.games.v.a.d;
/* loaded from: classes11.dex */
public class a extends c {
    public a(com.baidu.swan.games.e.b bVar) {
        super(bVar);
    }

    public void getStorage(JsObject jsObject) {
        String a = a(jsObject, "getStorage");
        if (a != null) {
            d pF = pF(a);
            if (pF.isSuccess()) {
                com.baidu.swan.games.v.a.b bVar = new com.baidu.swan.games.v.a.b();
                bVar.errMsg = com.baidu.swan.games.v.a.a.pH("getStorage");
                bVar.data = pF.getData();
                if (bVar.data instanceof JsSerializeValue) {
                    ((JsSerializeValue) bVar.data).setAutoRelease(false);
                }
                com.baidu.swan.games.utils.b.a(i(jsObject), true, bVar);
                return;
            }
            a(jsObject, "getStorage", a, pF);
        }
    }

    public void setStorage(JsObject jsObject) {
        String a = a(jsObject, "setStorage");
        if (a != null) {
            a(jsObject, "setStorage", a, a(a, k(jsObject)));
        }
    }

    public void removeStorage(JsObject jsObject) {
        String a = a(jsObject, "removeStorage");
        if (a != null) {
            a(jsObject, "removeStorage", a, pG(a));
        }
    }

    public void clearStorage(JsObject jsObject) {
        a(jsObject, "clearStorage", "", apQ());
    }

    public void getStorageInfo(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        com.baidu.swan.games.v.a.c storageInfoSync = getStorageInfoSync();
        storageInfoSync.errMsg = com.baidu.swan.games.v.a.a.pH("getStorageInfo");
        com.baidu.swan.games.utils.b.a(i, true, storageInfoSync);
    }

    @NonNull
    private com.baidu.swan.games.binding.model.c i(JsObject jsObject) {
        com.baidu.swan.games.binding.model.c c = com.baidu.swan.games.binding.model.c.c(jsObject);
        return c == null ? new com.baidu.swan.games.binding.model.c() : c;
    }

    private String a(JsObject jsObject, String str) {
        d j = j(jsObject);
        if (j.isSuccess()) {
            return (String) j.getData();
        }
        a(jsObject, str, "", j);
        return null;
    }

    private d j(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("key".equals(jsObject.getPropertyName(i))) {
                int propertyType = jsObject.getPropertyType(i);
                if (propertyType == 7) {
                    return d.X(jsObject.toString(i));
                }
                return d.pI(String.format("parameter error: the key must be string instead of %s.", d.hW(propertyType)));
            }
        }
        return d.pI("parameter error: the parameter key is necessary.");
    }

    private JsSerializeValue k(JsObject jsObject) {
        for (int i = 0; i < jsObject.length(); i++) {
            if ("data".equals(jsObject.getPropertyName(i))) {
                return jsObject.toSerializeValue(i);
            }
        }
        return null;
    }

    private void a(JsObject jsObject, String str, String str2, d dVar) {
        com.baidu.swan.games.binding.model.c i = i(jsObject);
        com.baidu.swan.games.binding.model.b bVar = new com.baidu.swan.games.binding.model.b();
        boolean isSuccess = dVar.isSuccess();
        bVar.errMsg = dVar.bT(str, str2);
        com.baidu.swan.games.utils.b.a(i, isSuccess, bVar);
        if (!isSuccess) {
            com.baidu.swan.games.u.c.bS(str2, bVar.errMsg);
        }
    }
}
