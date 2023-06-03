package com.baidu.adp.lib.OrmObject.toolsystem.orm.object;

import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.lc;
import com.baidu.tieba.mc;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class OrmObject extends mc {
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
            if (ormObject != null && ormObject.fillInBundle(bundle)) {
                return bundle;
            }
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    public static final Intent intentWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ormObject)) == null) {
            Intent intent = new Intent();
            if (ormObject != null && ormObject.fillByIntent(intent)) {
                return intent;
            }
            return null;
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
            if (ormObject != null && ormObject.fillInJsonObject(jSONObject)) {
                return jSONObject;
            }
            return null;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static final Map<String, Object> mapWithObject(OrmObject ormObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, ormObject)) == null) {
            HashMap hashMap = new HashMap();
            if (ormObject != null && ormObject.fillInMap(hashMap)) {
                return hashMap;
            }
            return null;
        }
        return (Map) invokeL.objValue;
    }

    public static final OrmObject objectWithBundle(Bundle bundle, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, bundle, cls)) == null) {
            OrmObject ormObject = (OrmObject) lc.g(cls);
            if (ormObject != null && ormObject.fillByBundle(bundle)) {
                return ormObject;
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithIntent(Intent intent, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, intent, cls)) == null) {
            OrmObject ormObject = (OrmObject) lc.g(cls);
            if (ormObject != null && ormObject.fillByIntent(intent)) {
                return ormObject;
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }

    public static final OrmObject objectWithJson(JSONObject jSONObject, Class<?> cls) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, jSONObject, cls)) == null) {
            OrmObject ormObject = (OrmObject) lc.g(cls);
            if (ormObject != null && ormObject.fillByJsonObject(jSONObject)) {
                return ormObject;
            }
            return null;
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
            OrmObject ormObject = (OrmObject) lc.g(cls);
            if (ormObject != null && ormObject.fillByMap(map)) {
                return ormObject;
            }
            return null;
        }
        return (OrmObject) invokeLL.objValue;
    }
}
