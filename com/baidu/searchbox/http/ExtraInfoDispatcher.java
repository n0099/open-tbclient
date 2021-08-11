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
/* loaded from: classes5.dex */
public final class ExtraInfoDispatcher {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ExtraInfoCallback> mExtraCallbacks;

    public ExtraInfoDispatcher() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mExtraCallbacks = new CopyOnWriteArrayList();
    }

    public void addCallback(ExtraInfoCallback extraInfoCallback) {
        List<ExtraInfoCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, extraInfoCallback) == null) || this.mExtraCallbacks.contains(extraInfoCallback) || (list = this.mExtraCallbacks) == null) {
            return;
        }
        list.add(extraInfoCallback);
    }

    public void clearCallback() {
        List<ExtraInfoCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.mExtraCallbacks) == null) {
            return;
        }
        list.clear();
    }

    public List<ExtraInfoCallback> getAllCallbacks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtraCallbacks : (List) invokeV.objValue;
    }

    public void removeCallback(ExtraInfoCallback extraInfoCallback) {
        List<ExtraInfoCallback> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, extraInfoCallback) == null) || extraInfoCallback == null || (list = this.mExtraCallbacks) == null) {
            return;
        }
        list.remove(extraInfoCallback);
    }
}
