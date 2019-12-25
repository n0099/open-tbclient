package com.baidu.searchbox.dns;

import android.content.Context;
import com.baidu.searchbox.dns.d.c;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
public class DnsHelper {
    private boolean k;

    public DnsHelper(Context context) {
        this(context, true);
    }

    public DnsHelper(Context context, boolean z) {
        this.k = true;
        com.baidu.searchbox.dns.a.a.b(context);
        a.a(context);
        this.k = z;
    }

    public boolean isHttpDnsEnable() {
        return this.k;
    }

    public void setHttpDnsEnable(boolean z) {
        this.k = z;
        if (this.k) {
            a.b().a();
        } else {
            a.b().exit();
        }
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
            DnsParseResult b = b.b(str, true);
            if (b != null) {
                return b.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return com.baidu.searchbox.dns.b.b.a(com.baidu.searchbox.dns.b.b.h(str));
    }

    public List<String> getIpListOnlyCache(String str) {
        if (this.k) {
            DnsParseResult a = b.a(str, true);
            if (a != null) {
                return a.getIpList();
            }
            return new ArrayList();
        }
        return null;
    }

    public DnsParseResult getParseResult(String str) {
        if (this.k) {
            return b.getParseResult(str);
        }
        Map<String, List<String>> h = com.baidu.searchbox.dns.b.b.h(str);
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h), 0, com.baidu.searchbox.dns.b.b.b(h) ? 5 : 1, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultForceHttp(String str) {
        if (this.k) {
            return b.b(str, true);
        }
        Map<String, List<String>> h = com.baidu.searchbox.dns.b.b.h(str);
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.a(h), 0, com.baidu.searchbox.dns.b.b.b(h) ? 5 : 1, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        return this.k ? b.a(str, true) : new DnsParseResult(new ArrayList(), 0, 1, DnsUtil.stackType);
    }

    public void setHttpDnsState(boolean z, HttpDNSStat httpDNSStat, boolean z2) {
        c.b(z);
        c.a(httpDNSStat);
        c.a(z2);
        com.baidu.searchbox.dns.b.b.v = z2;
    }
}
