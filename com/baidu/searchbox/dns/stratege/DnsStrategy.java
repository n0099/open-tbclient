package com.baidu.searchbox.dns.stratege;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.searchbox.dns.transmit.DnsTransmitTask;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class DnsStrategy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public DnsModel cacheDnsModel;
    public DnsTransmitTask dnsTransmitTask;
    public int parseSubType;

    /* renamed from: com.baidu.searchbox.dns.stratege.DnsStrategy$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Factory {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int DEFAULT_EXPIRE_INTERVAL = 60000;
        public static final int PRE_FETCH_INTERVAL = 180000;
        public static final int STOP_RETRY_INTERVAL = 300000;
        public static final int WARN_RETRY_INTERVAL = 60000;
        public transient /* synthetic */ FieldHolder $fh;
        public long cacheTime;
        public final long currentTime;
        public final DnsModel dnsModel;
        public final DnsTransmitTask dnsTransmitTask;
        public String msg;
        public int ttl;
        public final boolean useExpire;

        public Factory(long j, DnsTransmitTask dnsTransmitTask, DnsModel dnsModel, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Long.valueOf(j), dnsTransmitTask, dnsModel, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.ttl = -1;
            this.cacheTime = -1L;
            this.currentTime = j;
            this.dnsModel = dnsModel;
            this.dnsTransmitTask = dnsTransmitTask;
            this.useExpire = z;
            if (dnsModel != null) {
                this.ttl = dnsModel.ttl;
                this.msg = dnsModel.msg;
                this.cacheTime = dnsModel.cacheTime;
            }
        }

        public DnsStrategy get() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.dnsModel == null) {
                    return new DnsStrategy(this.dnsTransmitTask, null, 1002, null);
                }
                if (TextUtils.isEmpty(this.msg)) {
                    return new DnsStrategy(this.dnsTransmitTask, null, 1005, null);
                }
                if (this.msg.equals(DnsModel.MSG_OK)) {
                    int i = this.ttl;
                    if (i >= 0) {
                        long j = this.cacheTime;
                        if (j > 0) {
                            long j2 = this.currentTime;
                            if (j2 - j > i) {
                                if (this.useExpire) {
                                    return new DnsStrategy(this.dnsTransmitTask, this.dnsModel, 2009, null);
                                }
                                return new DnsStrategy(this.dnsTransmitTask, null, 1003, null);
                            } else if (j2 - j >= LiveFeedPageSdk.REFRESH_TIME) {
                                DnsTransmitTask dnsTransmitTask = this.dnsTransmitTask;
                                if (dnsTransmitTask != null) {
                                    return new DnsStrategy(dnsTransmitTask, this.dnsModel, 1001, null);
                                }
                                return new DnsStrategy(null, this.dnsModel, 2001, null);
                            } else {
                                return new DnsStrategy(null, this.dnsModel, 2001, null);
                            }
                        }
                    }
                    if (this.ttl < 0) {
                        long j3 = this.cacheTime;
                        if (j3 > 0) {
                            if (this.currentTime - j3 > 60000) {
                                return new DnsStrategy(this.dnsTransmitTask, null, 1007, null);
                            }
                            return new DnsStrategy(null, this.dnsModel, 2003, null);
                        }
                    }
                    return new DnsStrategy(this.dnsTransmitTask, null, 1008, null);
                } else if (this.msg.equals("warning")) {
                    if (this.currentTime - this.cacheTime >= 60000) {
                        return new DnsStrategy(this.dnsTransmitTask, null, 1004, null);
                    }
                    return new DnsStrategy(null, null, 2, null);
                } else if (this.msg.equals("stop")) {
                    if (this.currentTime - this.cacheTime >= 300000) {
                        return new DnsStrategy(this.dnsTransmitTask, null, 1004, null);
                    }
                    return new DnsStrategy(null, null, 2, null);
                } else {
                    return new DnsStrategy(this.dnsTransmitTask, null, 1004, null);
                }
            }
            return (DnsStrategy) invokeV.objValue;
        }
    }

    public DnsStrategy(DnsTransmitTask dnsTransmitTask, DnsModel dnsModel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dnsTransmitTask, dnsModel, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.dnsTransmitTask = dnsTransmitTask;
        this.cacheDnsModel = dnsModel;
        this.parseSubType = i;
    }

    public /* synthetic */ DnsStrategy(DnsTransmitTask dnsTransmitTask, DnsModel dnsModel, int i, AnonymousClass1 anonymousClass1) {
        this(dnsTransmitTask, dnsModel, i);
    }

    public DnsModel getCacheDnsModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.cacheDnsModel;
        }
        return (DnsModel) invokeV.objValue;
    }

    public DnsTransmitTask getDnsTransmitTask() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.dnsTransmitTask;
        }
        return (DnsTransmitTask) invokeV.objValue;
    }

    public int getParseSubType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.parseSubType;
        }
        return invokeV.intValue;
    }
}
