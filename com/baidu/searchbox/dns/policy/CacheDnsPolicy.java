package com.baidu.searchbox.dns.policy;

import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import java.util.List;
/* loaded from: classes3.dex */
public class CacheDnsPolicy {
    public static List<String> getIpListByHost(String str) {
        DnsModel dnsModel = DnsCacheHelper.getCacheHelper().get(str);
        if (dnsModel != null) {
            return dnsModel.getIpList();
        }
        return null;
    }
}
