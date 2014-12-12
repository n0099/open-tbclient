package com.baidu.adp.lib.a.b.a.a;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class i extends a {
    public static final i objectWithBundle(Bundle bundle, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.j(cls);
        if (iVar == null || !iVar.fillByBundle(bundle)) {
            return null;
        }
        return iVar;
    }

    public static final Bundle bundleWithObject(i iVar) {
        Bundle bundle = new Bundle();
        if (iVar == null || !iVar.fillInBundle(bundle)) {
            return null;
        }
        return bundle;
    }

    public static final i objectWithIntent(Intent intent, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.j(cls);
        if (iVar == null || !iVar.fillByIntent(intent)) {
            return null;
        }
        return iVar;
    }

    public static final Intent intentWithObject(i iVar) {
        Intent intent = new Intent();
        if (iVar == null || !iVar.fillByIntent(intent)) {
            return null;
        }
        return intent;
    }

    public static final i objectWithJson(JSONObject jSONObject, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.j(cls);
        if (iVar == null || !iVar.fillByJsonObject(jSONObject)) {
            return null;
        }
        return iVar;
    }

    public static final i objectWithJsonStr(String str, Class<?> cls) {
        if (str == null) {
            return null;
        }
        try {
            return objectWithJson(new JSONObject(str), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final JSONObject jsonWithObject(i iVar) {
        JSONObject jSONObject = new JSONObject();
        if (iVar == null || !iVar.fillInJsonObject(jSONObject)) {
            return null;
        }
        return jSONObject;
    }

    public static final String jsonStrWithObject(i iVar) {
        JSONObject jsonWithObject = jsonWithObject(iVar);
        if (jsonWithObject != null) {
            return jsonWithObject.toString();
        }
        return null;
    }

    public static final i objectWithMap(Map<String, Object> map, Class<?> cls) {
        i iVar = (i) com.baidu.adp.lib.a.a.a.j(cls);
        if (iVar == null || !iVar.fillByMap(map)) {
            return null;
        }
        return iVar;
    }

    public static final Map<String, Object> mapWithObject(i iVar) {
        HashMap hashMap = new HashMap();
        if (iVar == null || !iVar.fillInMap(hashMap)) {
            return null;
        }
        return hashMap;
    }
}
