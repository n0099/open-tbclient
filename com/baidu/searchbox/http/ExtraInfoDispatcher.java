package com.baidu.searchbox.http;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.callback.ExtraInfoCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public final class ExtraInfoDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List mExtraCallbacks;

    public ExtraInfoDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtraCallbacks = new CopyOnWriteArrayList();
    }

    public void clearCallback() {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (list = this.mExtraCallbacks) != null) {
            list.clear();
        }
    }

    public List getAllCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mExtraCallbacks;
        }
        return (List) invokeV.objValue;
    }

    public void addCallback(ExtraInfoCallback extraInfoCallback) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, extraInfoCallback) == null) && !this.mExtraCallbacks.contains(extraInfoCallback) && (list = this.mExtraCallbacks) != null) {
            list.add(extraInfoCallback);
        }
    }

    public void removeCallback(ExtraInfoCallback extraInfoCallback) {
        List list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, extraInfoCallback) == null) && extraInfoCallback != null && (list = this.mExtraCallbacks) != null) {
            list.remove(extraInfoCallback);
        }
    }
}
