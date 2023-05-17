package com.baidu.searchbox.dns;

import android.content.Context;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.policy.LocalDnsPolicy;
import com.baidu.searchbox.dns.statistics.HttpDNSStat;
import com.baidu.searchbox.dns.transmit.DnsTransmitter;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class DnsHelper {
    public boolean mIsEnable;

    /* loaded from: classes3.dex */
    public static class DnsConfig {
        public boolean backUpIPEnable;
        public boolean idcEnable;
        public HttpDNSStat stat;
        public boolean useExpire;

        public DnsConfig(boolean z, boolean z2, boolean z3, HttpDNSStat httpDNSStat) {
            this.idcEnable = false;
            this.backUpIPEnable = false;
            this.useExpire = false;
            this.idcEnable = z;
            this.backUpIPEnable = z2;
            this.useExpire = z3;
            this.stat = httpDNSStat;
        }
    }

    public DnsHelper(Context context) {
        this(context, true);
    }

    public void forceUpdateDomain(String str) {
        if (this.mIsEnable) {
            DnsEngine.forceUpdateDomain(str);
        }
    }

    public List<String> getIpList(String str) throws UnknownHostException {
        if (this.mIsEnable) {
            DnsParseResult parseResult = DnsEngine.getParseResult(str);
            if (parseResult != null) {
                return parseResult.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
    }

    public List<String> getIpListForceHttp(String str) throws UnknownHostException {
        if (this.mIsEnable) {
            DnsParseResult parseResult = DnsEngine.getParseResult(str, true);
            if (parseResult != null) {
                return parseResult.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
    }

    public List<String> getIpListOnlyCache(String str) {
        if (this.mIsEnable) {
            DnsParseResult cacheResult = DnsEngine.getCacheResult(str, true);
            if (cacheResult != null) {
                return cacheResult.getIpList();
            }
            return new ArrayList();
        }
        return null;
    }

    public List<String> getIpListOnlyForceHttp(String str) throws UnknownHostException {
        if (this.mIsEnable) {
            DnsParseResult onlyForceHttpResult = DnsEngine.getOnlyForceHttpResult(str);
            if (onlyForceHttpResult != null) {
                return onlyForceHttpResult.getIpList();
            }
            throw new UnknownHostException(str);
        }
        return LocalDnsPolicy.getIpListFromMapResult(LocalDnsPolicy.getIpListByHost(str));
    }

    public DnsParseResult getParseResult(String str) throws UnknownHostException {
        int i;
        if (this.mIsEnable) {
            return DnsEngine.getParseResult(str);
        }
        Map<String, List<String>> ipListByHost = LocalDnsPolicy.getIpListByHost(str);
        List<String> ipListFromMapResult = LocalDnsPolicy.getIpListFromMapResult(ipListByHost);
        if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost)) {
            i = 5;
        } else {
            i = 1;
        }
        return new DnsParseResult(ipListFromMapResult, 0, i, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultForceHttp(String str) throws UnknownHostException {
        int i = 1;
        if (this.mIsEnable) {
            return DnsEngine.getParseResult(str, true);
        }
        Map<String, List<String>> ipListByHost = LocalDnsPolicy.getIpListByHost(str);
        List<String> ipListFromMapResult = LocalDnsPolicy.getIpListFromMapResult(ipListByHost);
        if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost)) {
            i = 5;
        }
        return new DnsParseResult(ipListFromMapResult, 0, i, DnsUtil.stackType);
    }

    public DnsParseResult getParseResultOnlyCache(String str) {
        if (this.mIsEnable) {
            return DnsEngine.getCacheResult(str, true);
        }
        return new DnsParseResult(new ArrayList(), 0, 1, DnsUtil.stackType);
    }

    public void setHttpDnsConfig(DnsConfig dnsConfig) {
        DnsTransmitter.setIDCEable(dnsConfig.idcEnable);
        DnsTransmitter.setDnsStat(dnsConfig.stat);
        LocalDnsPolicy.backUpIPEnable = dnsConfig.backUpIPEnable;
        DnsUtil.useExpire = dnsConfig.useExpire;
    }

    public void setHttpDnsEnable(boolean z) {
        this.mIsEnable = z;
        if (z) {
            ConnectManager.getInstance().init();
        } else {
            ConnectManager.getInstance().exit();
        }
    }

    public DnsHelper(Context context, boolean z) {
        this.mIsEnable = true;
        DnsCacheHelper.initCacheHelper(context);
        ConnectManager.initInstance(context);
        this.mIsEnable = z;
        if (z) {
            ConnectManager.getInstance().init();
        }
    }

    public List<String> getIpListOnlyCache(String str, boolean z) {
        DnsParseResult cacheResult;
        if (this.mIsEnable && (cacheResult = DnsEngine.getCacheResult(str, true, z)) != null) {
            return cacheResult.getIpList();
        }
        return null;
    }

    public static String getAreaInfo() {
        DnsCacheHelper cacheHelper = DnsCacheHelper.getCacheHelper();
        if (cacheHelper != null) {
            return cacheHelper.getAreaInfo();
        }
        return null;
    }

    public static String getClientIp() {
        DnsCacheHelper cacheHelper = DnsCacheHelper.getCacheHelper();
        if (cacheHelper != null) {
            return cacheHelper.getClientIp();
        }
        return null;
    }

    public static long getLastAreaUpdateTimestamp() {
        if (DnsCacheHelper.getCacheHelper() != null) {
            return DnsCacheHelper.getCacheHelper().getLastAreaInfoUpdateTime();
        }
        return -1L;
    }

    public boolean isHttpDnsEnable() {
        return this.mIsEnable;
    }

    @Deprecated
    public void setHttpDnsState(boolean z, HttpDNSStat httpDNSStat, boolean z2, boolean z3) {
        DnsTransmitter.setIDCEable(z);
        DnsTransmitter.setDnsStat(httpDNSStat);
        LocalDnsPolicy.backUpIPEnable = z2;
    }
}
