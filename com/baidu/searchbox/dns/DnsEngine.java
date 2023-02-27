package com.baidu.searchbox.dns;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.dns.cache.DnsCacheHelper;
import com.baidu.searchbox.dns.policy.HttpDnsPolicy;
import com.baidu.searchbox.dns.policy.LocalDnsPolicy;
import com.baidu.searchbox.dns.stratege.DnsStrategy;
import com.baidu.searchbox.dns.transmit.DnsTransmitTask;
import com.baidu.searchbox.dns.transmit.DnsTransmitTaskManager;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.dns.util.DnsUtil;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class DnsEngine {
    public static List<String> domains;

    public static synchronized void forceUpdateDomain() {
        synchronized (DnsEngine.class) {
            if (domains != null && domains.size() > 0) {
                for (String str : domains) {
                    startUpdateDomain(str);
                }
            }
        }
    }

    public static synchronized void addDomain(String str) {
        synchronized (DnsEngine.class) {
            if (domains == null) {
                domains = new ArrayList(4);
            }
            if (!domains.contains(str)) {
                domains.add(str);
            }
        }
    }

    public static String dumpIpList(List<String> list) {
        if (DnsUtil.DEBUG && list != null && !list.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str);
                sb.append(" | ");
            }
            return sb.toString();
        }
        return "";
    }

    public static void forceUpdateDomain(String str) {
        addDomain(str);
        startUpdateDomain(str);
    }

    public static List<String> getDNSIpListFromCache(DnsModel dnsModel) {
        ArrayList arrayList = new ArrayList();
        List<String> ipList = dnsModel.getIpList();
        List<String> ipv6List = dnsModel.getIpv6List();
        if (ipv6List != null) {
            arrayList.addAll(ipv6List);
        }
        if (ipList != null) {
            arrayList.addAll(ipList);
        }
        return arrayList;
    }

    public static DnsParseResult getParseResult(String str) throws UnknownHostException {
        return getParseResult(str, false);
    }

    public static void startUpdateDomain(String str) {
        DnsTransmitTask task = DnsTransmitTaskManager.getInstance().getTask(str, true, 1);
        if (task != null) {
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, " start update domain task: " + str);
            }
            task.start();
        }
    }

    public static DnsParseResult getCacheResult(String str, boolean z) {
        return getCacheResult(str, z, DnsUtil.useExpire);
    }

    public static List<String> getDNSIpList(DnsModel dnsModel, int i) {
        DnsUtil.initNetworkStackType();
        if (i == 3) {
            return getDNSIpListFromCache(dnsModel);
        }
        if (i == 1) {
            return getDNSIpListFromCache(dnsModel);
        }
        if (i == 2) {
            return getDNSIpListFromCache(dnsModel);
        }
        return getDNSIpListFromCache(dnsModel);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DnsParseResult getCacheResult(String str, boolean z, boolean z2) {
        String str2;
        String str3;
        String str4;
        int i;
        boolean z3;
        List<String> list = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 0;
        DnsStrategy dnsStrategy = new DnsStrategy.Factory(System.currentTimeMillis(), DnsTransmitTaskManager.getInstance().getTask(str, false, 2), DnsCacheHelper.getCacheHelper().get(str), z2).get();
        DnsTransmitTask dnsTransmitTask = dnsStrategy.getDnsTransmitTask();
        DnsModel cacheDnsModel = dnsStrategy.getCacheDnsModel();
        int parseSubType = dnsStrategy.getParseSubType();
        if (cacheDnsModel != null) {
            List<String> dNSIpList = getDNSIpList(cacheDnsModel, DnsUtil.stackType);
            if (dNSIpList != null && !dNSIpList.isEmpty()) {
                String area = cacheDnsModel.getArea();
                String clientIp = cacheDnsModel.getClientIp();
                String httpdnsIp = cacheDnsModel.getHttpdnsIp();
                int addressType = cacheDnsModel.getAddressType();
                boolean idcToBgp = cacheDnsModel.getIdcToBgp();
                z = (parseSubType == 1001 || parseSubType == 2009) ? true : true;
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "DnsEngine getIplist -> cache response hit: " + str + " ip: " + dumpIpList(dNSIpList));
                }
                z3 = idcToBgp;
                str4 = httpdnsIp;
                i = addressType;
                str2 = area;
                str3 = clientIp;
                list = dNSIpList;
                i2 = 2000;
                if (dnsTransmitTask == null && z) {
                    if (i2 != 2000) {
                        i2 = 1000;
                    }
                    dnsTransmitTask.start();
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, " DnsEngine getIplist -> trasmitTask start: " + str);
                    }
                } else if (dnsTransmitTask == null) {
                    if (DnsUtil.DEBUG) {
                        Log.d(DnsUtil.TAG, " DnsEngine getIplist -> no need start transmitTask: " + str);
                    }
                    if (i2 == 0) {
                        parseSubType = 4;
                    }
                }
                DnsParseResult dnsParseResult = new DnsParseResult(list, i2, parseSubType, DnsUtil.stackType);
                dnsParseResult.setHttpdnsInfo(str2, str3, str4, i, z3);
                return dnsParseResult;
            }
            parseSubType = 1006;
            str2 = null;
            str3 = null;
            str4 = null;
            list = dNSIpList;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
        }
        i = 0;
        z3 = false;
        if (dnsTransmitTask == null) {
        }
        if (dnsTransmitTask == null) {
        }
        DnsParseResult dnsParseResult2 = new DnsParseResult(list, i2, parseSubType, DnsUtil.stackType);
        dnsParseResult2.setHttpdnsInfo(str2, str3, str4, i, z3);
        return dnsParseResult2;
    }

    public static DnsParseResult getOnlyForceHttpResult(String str) throws UnknownHostException {
        String str2;
        String str3;
        String str4;
        int i;
        boolean z;
        List<String> list = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = 2000;
        int i3 = 2002;
        DnsModel ipListByHost = HttpDnsPolicy.getIpListByHost(str);
        if (ipListByHost != null) {
            list = getDNSIpList(ipListByHost, DnsUtil.stackType);
            String area = ipListByHost.getArea();
            String clientIp = ipListByHost.getClientIp();
            String httpdnsIp = ipListByHost.getHttpdnsIp();
            int addressType = ipListByHost.getAddressType();
            boolean idcToBgp = ipListByHost.getIdcToBgp();
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + dumpIpList(list));
            }
            z = idcToBgp;
            i = addressType;
            str4 = httpdnsIp;
            str3 = clientIp;
            str2 = area;
        } else {
            str2 = null;
            str3 = null;
            str4 = null;
            i = 0;
            z = false;
        }
        if (list == null || list.size() <= 0) {
            int i4 = 3;
            Map<String, List<String>> ipListByHost2 = LocalDnsPolicy.getIpListByHost(str);
            List<String> ipListFromMapResult = LocalDnsPolicy.getIpListFromMapResult(ipListByHost2);
            if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost2)) {
                i4 = 5;
            }
            if (DnsUtil.DEBUG) {
                Log.d(DnsUtil.TAG, "DnsEngine getIplist -> use local dns:" + str + " ip: " + dumpIpList(ipListFromMapResult));
            }
            list = ipListFromMapResult;
            i3 = i4;
            i2 = 0;
        }
        DnsParseResult dnsParseResult = new DnsParseResult(list, i2, i3, DnsUtil.stackType);
        dnsParseResult.setHttpdnsInfo(str2, str3, str4, i, z);
        return dnsParseResult;
    }

    public static DnsParseResult getParseResult(String str, boolean z) throws UnknownHostException {
        if (!TextUtils.isEmpty(str)) {
            DnsParseResult cacheResult = getCacheResult(str, !z);
            if (cacheResult != null) {
                List<String> ipList = cacheResult.getIpList();
                int type = cacheResult.getType();
                int subType = cacheResult.getSubType();
                int stackType = cacheResult.getStackType();
                String area = cacheResult.getArea();
                String clientIp = cacheResult.getClientIp();
                String httpdnsIp = cacheResult.getHttpdnsIp();
                int addressType = cacheResult.getAddressType();
                if (ipList == null || ipList.isEmpty()) {
                    if (z) {
                        int i = 2000;
                        int i2 = 2002;
                        DnsModel ipListByHost = HttpDnsPolicy.getIpListByHost(str);
                        if (ipListByHost != null) {
                            ipList = getDNSIpList(ipListByHost, DnsUtil.stackType);
                            if (ipList == null || ipList.isEmpty()) {
                                i2 = 3;
                                i = 0;
                            }
                            if (DnsUtil.DEBUG) {
                                Log.d(DnsUtil.TAG, "DnsEngine getIplist -> wait http dns request: " + str + " ip: " + dumpIpList(ipList));
                            }
                            subType = i2;
                            type = i;
                        } else {
                            type = 2000;
                            subType = 2002;
                        }
                    }
                    if (ipList == null || ipList.isEmpty()) {
                        Map<String, List<String>> ipListByHost2 = LocalDnsPolicy.getIpListByHost(str);
                        ipList = LocalDnsPolicy.getIpListFromMapResult(ipListByHost2);
                        if (LocalDnsPolicy.isBackUpIpFromMapResult(ipListByHost2)) {
                            subType = 5;
                        }
                        if (DnsUtil.DEBUG) {
                            Log.d(DnsUtil.TAG, "DnsEngine getIplist -> use local dns:" + str + " ip: " + dumpIpList(ipList));
                        }
                    }
                }
                if (DnsUtil.DEBUG) {
                    Log.d(DnsUtil.TAG, "Dns parse result type: " + type + " subtype: " + subType);
                }
                DnsParseResult dnsParseResult = new DnsParseResult(ipList, type, subType, stackType);
                dnsParseResult.setHttpdnsInfo(area, clientIp, httpdnsIp, addressType, false);
                return dnsParseResult;
            }
            return cacheResult;
        }
        return null;
    }
}
