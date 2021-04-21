package com.baidu.searchbox.dns;

import android.content.Context;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DnsHelper {
    public boolean k;

    public DnsHelper(Context context) {
        this(context, true);
    }

    public void forceUpdateDomain(String str) {
        if (this.k) {
            b.forceUpdateDomain(str);
        }
    }

    public List<String> getIpList(String str) {
        if (this.k) {
            DnsParseResult parseResult = b.getParseResult(str);
            if (parseResult != null) {
                return parseResult.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return com.baidu.searchbox.dns.b.b.a(com.baidu.searchbox.dns.b.b.h(str));
    }

    public List<String> getIpListForceHttp(String str) {
        if (this.k) {
            DnsParseResult b2 = b.b(str, true);
            if (b2 != null) {
                return b2.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return com.baidu.searchbox.dns.b.b.a(com.baidu.searchbox.dns.b.b.h(str));
    }

    public List<String> getIpListOnlyCache(String str) {
        if (this.k) {
            DnsParseResult a2 = b.a(str, true);
            if (a2 != null) {
                return a2.getIpList();
            }
            return new ArrayList();
        }
        return null;
    }

    public DnsParseResult getParseResult(String str) {
        if (this.k) {
            return b.getParseResult(str);
        }
        Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h2), 0, com.baidu.searchbox.dns.b.b.b(h2) ? 5 : 1, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultForceHttp(String str) {
        if (this.k) {
            return b.b(str, true);
        }
        Map<String, List<String>> h2 = com.baidu.searchbox.dns.b.b.h(str);
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h2), 0, com.baidu.searchbox.dns.b.b.b(h2) ? 5 : 1, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        if (this.k) {
            return b.a(str, true);
        }
        return new DnsParseResult(new ArrayList(), 0, 1, DnsUtil.stackType);
    }

    public boolean isHttpDnsEnable() {
        return this.k;
    }

    public void setHttpDnsEnable(boolean z) {
        this.k = z;
        if (z) {
            a.b().a();
        } else {
            a.b().exit();
        }
    }

    public void setHttpDnsState(boolean z, HttpDNSStat httpDNSStat, boolean z2) {
        c.b(z);
        c.a(httpDNSStat);
        c.a(z2);
        com.baidu.searchbox.dns.b.b.v = z2;
    }

    public DnsHelper(Context context, boolean z) {
        this.k = true;
        com.baidu.searchbox.dns.a.a.b(context);
        a.a(context);
        this.k = z;
    }
}
