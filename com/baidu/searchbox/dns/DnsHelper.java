package com.baidu.searchbox.dns;

import android.content.Context;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class DnsHelper {
    private boolean j;

    public DnsHelper(Context context) {
        this(context, false);
    }

    public DnsHelper(Context context, boolean z) {
        com.baidu.searchbox.dns.a.a.b(context);
        a.a(context);
        this.j = z;
    }

    public boolean isHttpDnsEnable() {
        return this.j;
    }

    public void setHttpDnsEnable(boolean z) {
        this.j = z;
        if (this.j) {
            a.b().a();
        } else {
            a.b().exit();
        }
    }

    public void forceUpdateDomain(String str) {
        if (this.j) {
            b.forceUpdateDomain(str);
        }
    }

    public List<String> getIpList(String str) {
        if (this.j) {
            DnsParseResult parseResult = b.getParseResult(str);
            if (parseResult != null) {
                return parseResult.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return com.baidu.searchbox.dns.b.b.d(str);
    }

    public List<String> getIpListForceHttp(String str) {
        if (this.j) {
            DnsParseResult b = b.b(str, true);
            if (b != null) {
                return b.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return com.baidu.searchbox.dns.b.b.d(str);
    }

    public List<String> getIpListOnlyCache(String str) {
        if (this.j) {
            DnsParseResult a = b.a(str, true);
            if (a != null) {
                return a.getIpList();
            }
            return new ArrayList();
        }
        return null;
    }

    public DnsParseResult getParseResult(String str) {
        if (this.j) {
            return b.getParseResult(str);
        }
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.d(str), 0, 1);
    }

    public DnsParseResult getParseResultForceHttp(String str) {
        if (this.j) {
            return b.b(str, true);
        }
        return new DnsParseResult(com.baidu.searchbox.dns.b.b.d(str), 0, 1);
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        return this.j ? b.a(str, true) : new DnsParseResult(new ArrayList(), 0, 1);
    }
}
