package com.baidu.searchbox.network.outback.callback;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public abstract class ExtraInfoCallback {
    public static /* synthetic */ Interceptable $ic;
    public static ExtraInfoDispatcher sExtraInfoDispatcher;
    public transient /* synthetic */ FieldHolder $fh;

    public abstract void onReceiveClientIP(String str);

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
            if (interceptable == null || interceptable.invokeL(1048576, this, extraInfoCallback) == null) {
                List list2 = this.mExtraCallbacks;
                if ((list2 == null || !list2.contains(extraInfoCallback)) && (list = this.mExtraCallbacks) != null) {
                    list.add(extraInfoCallback);
                }
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1120870643, "Lcom/baidu/searchbox/network/outback/callback/ExtraInfoCallback;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1120870643, "Lcom/baidu/searchbox/network/outback/callback/ExtraInfoCallback;");
                return;
            }
        }
        sExtraInfoDispatcher = new ExtraInfoDispatcher();
    }

    public ExtraInfoCallback() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return sExtraInfoDispatcher;
        }
        return (ExtraInfoDispatcher) invokeV.objValue;
    }
}
