package com.baidu.searchbox.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import okhttp3.EventListener;
import okhttp3.Request;
/* loaded from: classes2.dex */
public interface IHttpContext {
    public static final IHttpContext EMPTY = new IHttpContext() { // from class: com.baidu.searchbox.http.IHttpContext.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, httpRequest)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public CookieManager getCookieManager(boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? CookieManager.WEBKIT_COOKIES : (CookieManager) invokeCommon.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public EventListener getEventListener() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (EventListener) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public int getFallbackConnectDelayMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, httpRequest)) == null) {
                return null;
            }
            return (IHttpDns) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewHttpDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return null;
            }
            return (IHttpDns) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public NetworkStat<Request> getNewNetworkStat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (NetworkStat) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void prefetchDnsResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, networkInfoRecord) == null) {
            }
        }
    };

    boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest);

    CookieManager getCookieManager(boolean z, boolean z2);

    EventListener getEventListener();

    int getFallbackConnectDelayMs();

    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    NetworkStat<Request> getNewNetworkStat();

    void init();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);
}
