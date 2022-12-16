package com.baidu.searchbox.http;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.http.cookie.CookieManager;
import com.baidu.searchbox.http.model.MultipleConnectParams;
import com.baidu.searchbox.http.model.PreConnectParams;
import com.baidu.searchbox.http.request.HttpRequest;
import com.baidu.searchbox.http.statistics.NetworkInfoRecord;
import com.baidu.searchbox.http.statistics.NetworkStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Request;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public interface IHttpContext {
    public static final IHttpContext EMPTY = new IHttpContext() { // from class: com.baidu.searchbox.http.IHttpContext.1
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
        public List<HttpUrl> getBrAllowlist() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (List) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IClientIPProvider getClientIPProvider() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (IClientIPProvider) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public EventListener getEventListener() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return null;
            }
            return (EventListener) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public int getFallbackConnectDelayMs() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public MultipleConnectParams getMultipleConnectParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return null;
            }
            return (MultipleConnectParams) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewCloneHttpDns(HttpRequest httpRequest) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, httpRequest)) == null) {
                return null;
            }
            return (IHttpDns) invokeL.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public IHttpDns getNewHttpDns() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return null;
            }
            return (IHttpDns) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public NetworkStat<Request> getNewNetworkStat() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return null;
            }
            return (NetworkStat) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public PreConnectParams getPreConnectParams() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return null;
            }
            return (PreConnectParams) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public String getSimOperator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void init() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isBrAllowlistEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isNeedAuthenticateHeader4Tunnel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isOldHttpUseTurbonet(String str, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
                return false;
            }
            return invokeLI.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean isRttLogEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean ok4URLConnectionEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public boolean okHttpPreConnectEnabled() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void prefetchDnsResult(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048596, this, networkInfoRecord) == null) {
            }
        }

        @Override // com.baidu.searchbox.http.IHttpContext
        public void uploadIllegalUrlBy850(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048597, this, jSONObject) == null) {
            }
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

        @Override // com.baidu.searchbox.http.IHttpContext
        public CookieManager getCookieManager(boolean z, boolean z2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
                return CookieManager.WEBKIT_COOKIES;
            }
            return (CookieManager) invokeCommon.objValue;
        }
    };

    boolean forceHttpDnsIPv4OnlyInDualStack(HttpRequest httpRequest);

    List<HttpUrl> getBrAllowlist();

    IClientIPProvider getClientIPProvider();

    CookieManager getCookieManager(boolean z, boolean z2);

    EventListener getEventListener();

    int getFallbackConnectDelayMs();

    MultipleConnectParams getMultipleConnectParams();

    IHttpDns getNewCloneHttpDns(HttpRequest httpRequest);

    IHttpDns getNewHttpDns();

    NetworkStat<Request> getNewNetworkStat();

    PreConnectParams getPreConnectParams();

    String getSimOperator();

    void init();

    boolean isBrAllowlistEnabled();

    boolean isNeedAuthenticateHeader4Tunnel(String str);

    boolean isOldHttpUseTurbonet(String str, int i);

    boolean isRttLogEnabled();

    boolean ok4URLConnectionEnabled();

    boolean okHttpPreConnectEnabled();

    void prefetchDnsResult(String str);

    void setNetworkInfoRecord(NetworkInfoRecord networkInfoRecord);

    void uploadIllegalUrlBy850(JSONObject jSONObject);
}
