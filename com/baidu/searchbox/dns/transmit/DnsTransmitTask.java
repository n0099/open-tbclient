package com.baidu.searchbox.dns.transmit;

import android.text.TextUtils;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import com.baidu.searchbox.dns.transmit.task.AsyncTask;
import java.util.Map;
/* loaded from: classes2.dex */
public class DnsTransmitTask extends AsyncTask {
    public static final String TASK_TYPE = "DNS_TASK";
    public int mAddressType;
    public String mHost;
    public boolean mIsBatch;
    public DnsTransmitter mTransmitter;

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public String getTaskType() {
        return TASK_TYPE;
    }

    public DnsTransmitTask(String str, boolean z, String str2) {
        super(str);
        this.mIsBatch = z;
        this.mHost = str2;
    }

    public DnsTransmitTask(boolean z, String str, int i) {
        this.mIsBatch = z;
        this.mHost = str;
        this.mAddressType = i;
    }

    private void addCache(DnsResponse dnsResponse) {
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

    private synchronized DnsTransmitter getTransmitter() {
        if (this.mTransmitter == null) {
            this.mTransmitter = new DnsTransmitter(this.mIsBatch, this.mHost, this.mAddressType);
        }
        return this.mTransmitter;
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void onCancel() {
        getTransmitter().cancel();
        DnsTransmitTaskManager.getInstance().removeTask(this.mHost);
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void onExecute() {
        DnsResponse sendRequest = getTransmitter().sendRequest();
        if (sendRequest != null) {
            addCache(sendRequest);
        }
        DnsTransmitTaskManager.getInstance().removeTask(this.mHost);
    }

    @Override // com.baidu.searchbox.dns.transmit.task.AsyncTask
    public void start() {
        DnsTransmitTaskManager.getInstance().addTask(this.mHost, this);
        super.start();
    }
}
