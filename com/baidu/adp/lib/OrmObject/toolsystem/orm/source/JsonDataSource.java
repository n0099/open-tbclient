package com.baidu.adp.lib.OrmObject.toolsystem.orm.source;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.fe;
import com.baidu.tieba.hd;
import com.baidu.tieba.je;
import com.baidu.tieba.pd;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class JsonDataSource implements hd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public JSONObject jo;

    public JsonDataSource(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.jo = jSONObject;
    }

    public Object getObject(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return this.jo.opt(str);
        }
        return invokeL.objValue;
    }

    @Override // com.baidu.tieba.hd
    public Set<String> getKeys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Iterator<String> keys = this.jo.keys();
            if (keys != null) {
                HashSet hashSet = new HashSet();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next != null) {
                        hashSet.add(next.toString());
                    }
                }
                return hashSet;
            }
            return null;
        }
        return (Set) invokeV.objValue;
    }

    @Override // com.baidu.tieba.hd
    public Object getObjectByType(String str, Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, type)) == null) {
            Object object = getObject(str);
            if (object != null) {
                fe feVar = new fe(type);
                pd a = je.a(object);
                if (a != null) {
                    return a.a(feVar);
                }
                return object;
            }
            return object;
        }
        return invokeLL.objValue;
    }

    @Override // com.baidu.tieba.hd
    public void set(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, obj) == null) {
            try {
                this.jo.putOpt(str, obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
