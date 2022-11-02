package com.baidu.searchbox.net.update.v2;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.gson.TypeAdapter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.json.JSONException;
/* loaded from: classes2.dex */
public abstract class AbstractCommandListener<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void addPostData(Context context, String str, String str2, CommandPostData commandPostData) throws JSONException;

    public abstract boolean executeCommand(Context context, String str, String str2, ActionData<T> actionData);

    public abstract String getLocalVersion(Context context, String str, String str2);

    public TypeAdapter<T> getTypeAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (TypeAdapter) invokeV.objValue;
    }

    public AbstractCommandListener() {
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

    public final ActionData<T> createDataObject() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new ActionData<>();
        }
        return (ActionData) invokeV.objValue;
    }

    public final Type getDataType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            for (Class<?> cls = getClass(); cls != null; cls = cls.getSuperclass()) {
                Type genericSuperclass = cls.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
                }
            }
            return null;
        }
        return (Type) invokeV.objValue;
    }
}
