package com.baidu.searchbox.dns.b;

import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class b {
    public static List<String> d(String str) {
        return DnsUtil.parseRawAddressList(Arrays.asList(InetAddress.getAllByName(str)));
    }
}
