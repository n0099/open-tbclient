package com.baidu.adp.lib.a.b.a.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends a {
    public static final i objectWithBundle(Bundle bundle, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.a(cls);
        if (iVar.fillByBundle(bundle)) {
            return iVar;
        }
        return null;
    }

    public static final Bundle bundleWithObject(i iVar) {
        Bundle bundle = new Bundle();
        if (iVar.fillInBundle(bundle)) {
            return bundle;
        }
        return null;
    }

    public static final i objectWithIntent(Intent intent, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.a(cls);
        if (iVar.fillByIntent(intent)) {
            return iVar;
        }
        return null;
    }

    public static final Intent intentWithObject(i iVar) {
        Intent intent = new Intent();
        if (iVar.fillByIntent(intent)) {
            return intent;
        }
        return null;
    }

    public static final i objectWithJson(JSONObject jSONObject, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.a(cls);
        if (iVar.fillByJsonObject(jSONObject)) {
            return iVar;
        }
        return null;
    }

    public static final i objectWithJsonStr(String str, Class<?> cls) {
        try {
            return objectWithJson(new JSONObject(str), cls);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final JSONObject jsonWithObject(i iVar) {
        JSONObject jSONObject = new JSONObject();
        if (iVar.fillInJsonObject(jSONObject)) {
            return jSONObject;
        }
        return null;
    }

    public static final String jsonStrWithObject(i iVar) {
        JSONObject jsonWithObject = jsonWithObject(iVar);
        if (jsonWithObject != null) {
            return jsonWithObject.toString();
        }
        return null;
    }

    public static final i objectWithMap(Map<String, Object> map, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.a(cls);
        if (iVar.fillByMap(map)) {
            return iVar;
        }
        return null;
    }

    public static final Map<String, Object> mapWithObject(i iVar) {
        HashMap hashMap = new HashMap();
        if (iVar.fillInMap(hashMap)) {
            return hashMap;
        }
        return null;
    }
}
