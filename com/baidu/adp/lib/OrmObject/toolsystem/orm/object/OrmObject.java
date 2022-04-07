package com.baidu.adp.lib.OrmObject.toolsystem.orm.object;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.yb;
import com.repackage.zb;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OrmObject extends zb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public OrmObject() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ormObject)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bundle, cls)) == null) {
            OrmObject ormObject = (OrmObject) yb.f(cls);
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
            OrmObject ormObject = (OrmObject) yb.f(cls);
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
            OrmObject ormObject = (OrmObject) yb.f(cls);
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
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithMap(Map<String, Object> map, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, map, cls)) == null) {
            OrmObject ormObject = (OrmObject) yb.f(cls);
            if (ormObject == null || !ormObject.fillByMap(map)) {
                return null;
            }
            return ormObject;
        }
        return (OrmObject) invokeLL.objValue;
    }
}
