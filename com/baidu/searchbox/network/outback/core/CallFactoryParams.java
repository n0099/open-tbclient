package com.baidu.searchbox.network.outback.core;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.cookie.CookieManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class CallFactoryParams {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CookieManager cookieManager;
    public int mConnectTimeoutMs;
    public long mConnectionPoolKeepAliveDurationNs;
    public int mConnectionPoolMaxIdleConnections;
    public TimeUnit mConnectionPoolTimeUnit;
    public ProxySelector mProxySelector;
    public int mReadTimeoutMs;
    public int mWriteTimeoutMs;

    /* loaded from: classes4.dex */
    public static class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CookieManager cookieManager;
        public int mConnectTimeoutMs;
        public long mConnectionPoolKeepAliveDurationNs;
        public int mConnectionPoolMaxIdleConnections;
        public TimeUnit mConnectionPoolTimeUnit;
        public ProxySelector mProxySelector;
        public int mReadTimeoutMs;
        public int mWriteTimeoutMs;

        public Builder() {
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
            this.mConnectTimeoutMs = 30000;
            this.mReadTimeoutMs = 30000;
            this.mWriteTimeoutMs = 30000;
            this.mConnectionPoolMaxIdleConnections = -1;
            this.mConnectionPoolKeepAliveDurationNs = -1L;
            this.mConnectionPoolTimeUnit = TimeUnit.MINUTES;
        }

        public CallFactoryParams build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new CallFactoryParams(this) : (CallFactoryParams) invokeV.objValue;
        }

        public Builder setConnectTimeoutMs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                this.mConnectTimeoutMs = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setCookieManager(CookieManager cookieManager) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cookieManager)) == null) {
                this.cookieManager = cookieManager;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setOkHttpConnectionPool(int i, long j, TimeUnit timeUnit) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Long.valueOf(j), timeUnit})) == null) {
                this.mConnectionPoolMaxIdleConnections = i;
                this.mConnectionPoolKeepAliveDurationNs = j;
                this.mConnectionPoolTimeUnit = timeUnit;
                return this;
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setProxySelector(ProxySelector proxySelector) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, proxySelector)) == null) {
                this.mProxySelector = proxySelector;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setReadTimeoutMs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                this.mReadTimeoutMs = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public Builder setWriteTimeoutMs(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                this.mWriteTimeoutMs = i;
                return this;
            }
            return (Builder) invokeI.objValue;
        }
    }

    public CallFactoryParams(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mConnectTimeoutMs = 30000;
        this.mReadTimeoutMs = 30000;
        this.mWriteTimeoutMs = 30000;
        this.mConnectionPoolMaxIdleConnections = -1;
        this.mConnectionPoolKeepAliveDurationNs = -1L;
        this.mConnectionPoolTimeUnit = TimeUnit.MINUTES;
        this.mConnectTimeoutMs = builder.mConnectTimeoutMs;
        this.mReadTimeoutMs = builder.mReadTimeoutMs;
        this.mWriteTimeoutMs = builder.mWriteTimeoutMs;
        this.mConnectionPoolMaxIdleConnections = builder.mConnectionPoolMaxIdleConnections;
        this.mConnectionPoolKeepAliveDurationNs = builder.mConnectionPoolKeepAliveDurationNs;
        this.mConnectionPoolTimeUnit = builder.mConnectionPoolTimeUnit;
        this.mProxySelector = builder.mProxySelector;
        this.cookieManager = builder.cookieManager;
    }

    public int getConnectTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mConnectTimeoutMs : invokeV.intValue;
    }

    public long getConnectionPoolKeepAliveDurationNs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mConnectionPoolKeepAliveDurationNs : invokeV.longValue;
    }

    public int getConnectionPoolMaxIdleConnections() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mConnectionPoolMaxIdleConnections : invokeV.intValue;
    }

    public TimeUnit getConnectionPoolTimeUnit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mConnectionPoolTimeUnit : (TimeUnit) invokeV.objValue;
    }

    public CookieManager getCookieManager() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cookieManager : (CookieManager) invokeV.objValue;
    }

    public ProxySelector getProxySelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mProxySelector : (ProxySelector) invokeV.objValue;
    }

    public int getReadTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mReadTimeoutMs : invokeV.intValue;
    }

    public int getWriteTimeoutMs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mWriteTimeoutMs : invokeV.intValue;
    }
}
