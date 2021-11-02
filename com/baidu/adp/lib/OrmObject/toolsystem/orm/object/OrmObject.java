package com.baidu.adp.lib.OrmObject.toolsystem.orm.object;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.b.b.a.a.a;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class OrmObject extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OrmObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static final Bundle bundleWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ormObject)) == null) {
            Bundle bundle = new Bundle();
            if (ormObject == null || !ormObject.fillInBundle(bundle)) {
                return null;
            }
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    public static final Intent intentWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ormObject)) == null) {
            Intent intent = new Intent();
            if (ormObject == null || !ormObject.fillByIntent(intent)) {
                return null;
            }
            return intent;
        }
        return (Intent) invokeL.objValue;
    }

    public static final String jsonStrWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, ormObject)) == null) {
            JSONObject jsonWithObject = jsonWithObject(ormObject);
            if (jsonWithObject != null) {
                return jsonWithObject.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static final JSONObject jsonWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ormObject)) == null) {
            JSONObject jSONObject = new JSONObject();
            if (ormObject == null || !ormObject.fillInJsonObject(jSONObject)) {
                return null;
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static final Map<String, Object> mapWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, ormObject)) == null) {
            HashMap hashMap = new HashMap();
            if (ormObject == null || !ormObject.fillInMap(hashMap)) {
                return null;
            }
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static final OrmObject objectWithBundle(Bundle bundle, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bundle, cls)) == null) {
            OrmObject ormObject = (OrmObject) b.a.e.e.b.a.a.f(cls);
            if (ormObject == null || !ormObject.fillByBundle(bundle)) {
                return null;
            }
            return ormObject;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithIntent(Intent intent, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, intent, cls)) == null) {
            OrmObject ormObject = (OrmObject) b.a.e.e.b.a.a.f(cls);
            if (ormObject == null || !ormObject.fillByIntent(intent)) {
                return null;
            }
            return ormObject;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithJson(JSONObject jSONObject, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, cls)) == null) {
            OrmObject ormObject = (OrmObject) b.a.e.e.b.a.a.f(cls);
            if (ormObject == null || !ormObject.fillByJsonObject(jSONObject)) {
                return null;
            }
            return ormObject;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithJsonStr(String str, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, cls)) == null) {
            if (str == null) {
                return null;
            }
            try {
                return objectWithJson(new JSONObject(str), cls);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithMap(Map<String, Object> map, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, map, cls)) == null) {
            OrmObject ormObject = (OrmObject) b.a.e.e.b.a.a.f(cls);
            if (ormObject == null || !ormObject.fillByMap(map)) {
                return null;
            }
            return ormObject;
        }
        return (OrmObject) invokeLL.objValue;
    }
}
