package com.baidu.searchbox.dns.policy;

import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.transmit.model.DnsResponse;
import java.util.Map;
/* loaded from: classes3.dex */
public class HttpDnsPolicy {
    public static DnsModel getIpListByHost(String str) {
        Map<String, DnsModel> dnsMap;
        DnsModel dnsModel;
        DnsResponse sendRequest = new DnsTransmitter(false, str, 2).sendRequest();
        if (sendRequest != null && sendRequest.getDnsMap() != null && (dnsMap = sendRequest.getDnsMap()) != null && !dnsMap.isEmpty() && (dnsModel = dnsMap.get(str)) != null) {
            DnsCacheHelper.getCacheHelper().put(str, dnsModel);
            return dnsModel;
        }
        return null;
    }
}
