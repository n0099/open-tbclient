package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import com.baidu.searchbox.dns.transmit.task.AsyncTask;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes2.dex */
public class DnsTransmitTask extends AsyncTask {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TASK_TYPE = "DNS_TASK";
    public transient /* synthetic */ FieldHolder $fh;
    public int mAddressType;
    public String mHost;
    public boolean mIsBatch;
    public DnsTransmitter mTransmitter;

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public String getTaskType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? TASK_TYPE : (String) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DnsTransmitTask(String str, boolean z, String str2) {
        super(str);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Boolean.valueOf(z), str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mIsBatch = z;
        this.mHost = str2;
    }

    public DnsTransmitTask(boolean z, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mIsBatch = z;
        this.mHost = str;
        this.mAddressType = i;
    }

    private void addCache(DnsResponse dnsResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, dnsResponse) == null) {
            Map<String, DnsModel> dnsMap = dnsResponse.getDnsMap();
            DnsCacheHelper cacheHelper = DnsCacheHelper.getCacheHelper();
            if (dnsMap != null && !dnsMap.isEmpty()) {
                for (Map.Entry<String, DnsModel> entry : dnsMap.entrySet()) {
                    cacheHelper.put(entry.getKey(), entry.getValue());
                }
            }
            Map<String, DnsModel> backUpDnsMap = dnsResponse.getBackUpDnsMap();
            if (backUpDnsMap != null && !backUpDnsMap.isEmpty()) {
                for (Map.Entry<String, DnsModel> entry2 : backUpDnsMap.entrySet()) {
                    cacheHelper.putBackup(entry2.getKey(), entry2.getValue());
                }
            }
            String backUpString = dnsResponse.getBackUpString();
            if (!TextUtils.isEmpty(backUpString)) {
                cacheHelper.cacheBackUpIp(backUpString);
            }
            String backUpVersion = dnsResponse.getBackUpVersion();
            if (!TextUtils.isEmpty(backUpVersion)) {
                cacheHelper.cacheBackUpIpVersion(backUpVersion);
            }
            if (dnsResponse.hasExtInfo()) {
                cacheHelper.setIsIPv6TestArea(dnsResponse.isIPv6TestArea());
            }
            if (!TextUtils.isEmpty(dnsResponse.getAreaInfo())) {
                cacheHelper.setAreaInfo(dnsResponse.getAreaInfo());
                cacheHelper.setLastAreaInfoUpdateTime(System.currentTimeMillis());
            }
            if (!TextUtils.isEmpty(dnsResponse.getClientIp())) {
                cacheHelper.setClientIp(dnsResponse.getClientIp());
            }
            if (!TextUtils.isEmpty(dnsResponse.getHttpdnsIp())) {
                cacheHelper.setHttpdnsIp(dnsResponse.getClientIp());
            }
            if (dnsResponse.getAddressType() > 0) {
                cacheHelper.setAddressType(dnsResponse.getAddressType());
            }
            cacheHelper.setIdcToBgp(dnsResponse.getIdcToBgp());
        }
    }

    private synchronized DnsTransmitter getTransmitter() {
        InterceptResult invokeV;
        DnsTransmitter dnsTransmitter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            synchronized (this) {
                if (this.mTransmitter == null) {
                    this.mTransmitter = new DnsTransmitter(this.mIsBatch, this.mHost, this.mAddressType);
                }
                dnsTransmitter = this.mTransmitter;
            }
            return dnsTransmitter;
        }
        return (DnsTransmitter) invokeV.objValue;
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void onCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            getTransmitter().cancel();
            DnsTransmitTaskManager.getInstance().removeTask(this.mHost);
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void onExecute() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            DnsResponse sendRequest = getTransmitter().sendRequest();
            if (sendRequest != null) {
                addCache(sendRequest);
            }
            DnsTransmitTaskManager.getInstance().removeTask(this.mHost);
        }
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            DnsTransmitTaskManager.getInstance().addTask(this.mHost, this);
            super.start();
        }
    }
}
