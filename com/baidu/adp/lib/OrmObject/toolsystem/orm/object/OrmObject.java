package com.baidu.adp.lib.OrmObject.toolsystem.orm.object;

import android.content.Intent;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OrmObject extends a {
    public static final OrmObject objectWithBundle(Bundle bundle, Class<?> cls) {
        OrmObject ormObject = (OrmObject) com.baidu.adp.lib.OrmObject.a.a.f(cls);
        if (ormObject == null || !ormObject.fillByBundle(bundle)) {
            return null;
        }
        return ormObject;
    }

    public static final Bundle bundleWithObject(OrmObject ormObject) {
        Bundle bundle = new Bundle();
        if (ormObject == null || !ormObject.fillInBundle(bundle)) {
            return null;
        }
        return bundle;
    }

    public static final OrmObject objectWithIntent(Intent intent, Class<?> cls) {
        OrmObject ormObject = (OrmObject) com.baidu.adp.lib.OrmObject.a.a.f(cls);
        if (ormObject == null || !ormObject.fillByIntent(intent)) {
            return null;
        }
        return ormObject;
    }

    public static final Intent intentWithObject(OrmObject ormObject) {
        Intent intent = new Intent();
        if (ormObject == null || !ormObject.fillByIntent(intent)) {
            return null;
        }
        return intent;
    }

    public static final OrmObject objectWithJson(JSONObject jSONObject, Class<?> cls) {
        OrmObject ormObject = (OrmObject) com.baidu.adp.lib.OrmObject.a.a.f(cls);
        if (ormObject == null || !ormObject.fillByJsonObject(jSONObject)) {
            return null;
        }
        return ormObject;
    }

    public static final OrmObject objectWithJsonStr(String str, Class<?> cls) {
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

    public static final JSONObject jsonWithObject(OrmObject ormObject) {
        JSONObject jSONObject = new JSONObject();
        if (ormObject == null || !ormObject.fillInJsonObject(jSONObject)) {
            return null;
        }
        return jSONObject;
    }

    public static final String jsonStrWithObject(OrmObject ormObject) {
        JSONObject jsonWithObject = jsonWithObject(ormObject);
        if (jsonWithObject != null) {
            return jsonWithObject.toString();
        }
        return null;
    }

    public static final OrmObject objectWithMap(Map<String, Object> map, Class<?> cls) {
        OrmObject ormObject = (OrmObject) com.baidu.adp.lib.OrmObject.a.a.f(cls);
        if (ormObject == null || !ormObject.fillByMap(map)) {
            return null;
        }
        return ormObject;
    }

    public static final Map<String, Object> mapWithObject(OrmObject ormObject) {
        HashMap hashMap = new HashMap();
        if (ormObject == null || !ormObject.fillInMap(hashMap)) {
            return null;
        }
        return hashMap;
    }
}
