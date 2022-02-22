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
/* loaded from: classes11.dex */
public abstract class ExtraInfoCallback {
    public static /* synthetic */ Interceptable $ic;
    public static ExtraInfoDispatcher sExtraInfoDispatcher;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes11.dex */
    public static final class ExtraInfoDispatcher {
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
            if (interceptable == null || interceptable.invokeL(1048576, this, extraInfoCallback) == null) {
                List<ExtraInfoCallback> list2 = this.mExtraCallbacks;
                if ((list2 == null || !list2.contains(extraInfoCallback)) && (list = this.mExtraCallbacks) != null) {
                    list.add(extraInfoCallback);
                }
            }
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static ExtraInfoDispatcher getExtraInfoDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? sExtraInfoDispatcher : (ExtraInfoDispatcher) invokeV.objValue;
    }

    public abstract void onReceiveClientIP(String str);
}
