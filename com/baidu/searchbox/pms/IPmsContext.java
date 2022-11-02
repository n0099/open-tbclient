package com.baidu.searchbox.pms;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.statistic.StatisticCallback;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public interface IPmsContext {
    public static final IPmsContext EMPTY = new IPmsContext() { // from class: com.baidu.searchbox.pms.IPmsContext.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.searchbox.pms.IPmsContext
        public boolean checkChannelAllow(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, str2)) == null) {
                return true;
            }
            return invokeLL.booleanValue;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public List<RequestParams.Channel> getLongConnectParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public RequestParams getRegisterParams(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                return null;
            }
            return (RequestParams) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public RequestParams getRegisterParams(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
                return null;
            }
            return (RequestParams) invokeLL.objValue;
        }

        @Override // com.baidu.searchbox.pms.IPmsContext
        public StatisticCallback getStatisticCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (StatisticCallback) invokeV.objValue;
        }

        {
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
    };

    boolean checkChannelAllow(String str, String str2);

    List<RequestParams.Channel> getLongConnectParams();

    RequestParams getRegisterParams(String str);

    RequestParams getRegisterParams(String str, String str2);

    StatisticCallback getStatisticCallback();
}
