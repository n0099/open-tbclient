package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import d.b.c.e.j.a.c;
import d.b.c.e.j.a.d;
import d.b.c.e.n.a;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.i0.z0.o;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class ImageLogger {
    public static long connBaiduCost;
    public static long connBaiduNum;
    public static int mCWImgFialedCnt;
    public static Object syncLock = new Object();

    /* loaded from: classes3.dex */
    public static class IMG extends TiebaStatic.LogFields {
        public static final String ACTION = "act";
        public static final String TYPE = "type";
        public static final String TYPE_VALUE = "img";
    }

    public static void assistant(String str) {
        a logItem = getLogItem();
        logItem.b("act", "assistant");
        logItem.b("content", str);
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long connBaidu() {
        long j;
        HttpURLConnection httpURLConnection;
        if (connBaiduNum >= 3) {
            return connBaiduCost;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(TbDomainConfig.DOMAIN_HTTPS_BAIDU).openConnection();
        } catch (SocketTimeoutException unused) {
        } catch (Exception unused2) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            httpURLConnection.setConnectTimeout(2500);
            httpURLConnection.connect();
            j = System.currentTimeMillis() - currentTimeMillis;
            d.b.c.e.m.a.e(httpURLConnection);
        } catch (SocketTimeoutException unused3) {
            httpURLConnection2 = httpURLConnection;
            j = TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
            d.b.c.e.m.a.e(httpURLConnection2);
            if (j > 0) {
            }
            return j;
        } catch (Exception unused4) {
            httpURLConnection2 = httpURLConnection;
            d.b.c.e.m.a.e(httpURLConnection2);
            j = -1;
            if (j > 0) {
            }
            return j;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection2 = httpURLConnection;
            d.b.c.e.m.a.e(httpURLConnection2);
            throw th;
        }
        if (j > 0) {
            long j2 = connBaiduNum;
            if (j2 > -1) {
                connBaiduCost = ((connBaiduCost * j2) + j) / (j2 + 1);
            } else {
                connBaiduCost = j;
            }
            connBaiduNum++;
        }
        return j;
    }

    public static void eventStatForHttpSwitch(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }

    public static void getCDNListError(boolean z, boolean z2, String str, String str2) {
        a logItem = getLogItem();
        logItem.b("act", "getCDNList");
        logItem.b("errorNum", str);
        logItem.b("errorMsg", str2);
        logItem.b("isShortNetError", z2 ? "1" : "0");
        logItem.b("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static String getDnsIp() {
        try {
            if (PermissionUtil.isAgreePrivacyPolicy()) {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static a getLogItem() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void getMobileCDNListError(boolean z, String str) {
        a logItem = getLogItem();
        logItem.b("act", "getCDNList");
        logItem.b("isSuccess", z ? "1" : "0");
        logItem.b("errorMsg", str);
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static void imagePerfNetLog(String str, boolean z, String str2, Boolean bool, d dVar, String str3, long j, boolean z2, int i) {
        boolean z3;
        if (!l.C() || dVar == null) {
            return;
        }
        String str4 = "";
        boolean b2 = o.b(str2);
        if (ICDNIPDirectConnect.getInstance() != null) {
            if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                ICDNIPDirectConnect.getInstance().init();
            }
            z3 = true;
        } else {
            z3 = false;
        }
        boolean H = j.H();
        boolean isShouldCDNFallBack = (b2 && z3) ? ICDNIPDirectConnect.getInstance().isShouldCDNFallBack() : false;
        if (b2 && H && isShouldCDNFallBack) {
            if (z) {
                ICDNProblemUploader.getInstance().insertNormalData(j, str);
            } else {
                str4 = ImageLoggerHelper.getInstance().getTiebaIp();
                if (!TextUtils.isEmpty(str4)) {
                    ICDNProblemUploader.getInstance().insertErrorData(dVar.i, str);
                }
            }
        }
        synchronized (syncLock) {
            if (z) {
                mCWImgFialedCnt = 0;
            } else if (j.z()) {
                int i2 = mCWImgFialedCnt + 1;
                mCWImgFialedCnt = i2;
                if (i2 >= d.b.c.e.n.k.a.o().q("alert_img", 5)) {
                    BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                    bdStatisticsManager.alert("alert_img", "imgFailedCnt_" + String.valueOf(mCWImgFialedCnt) + "_url=" + str2);
                }
            }
        }
        if (z && z3) {
            if (H && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f51109d) {
                return;
            }
            if (!H && j.t() && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f51111f) {
                return;
            }
            if (!H && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f51110e) {
                return;
            }
        }
        a logItem = getLogItem();
        if (TextUtils.isEmpty(str4)) {
            str4 = ImageLoggerHelper.getInstance().getTiebaIp();
        }
        String dnsIp = TextUtils.isEmpty("") ? getDnsIp() : "";
        logItem.b("url", str);
        logItem.b("act", "dl");
        logItem.b("result", z ? "1" : "0");
        logItem.b("requrl", str2);
        logItem.b("netlib", dVar.v == 0 ? "Apache" : "HttpManager");
        logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j));
        logItem.b("connTime", String.valueOf(dVar.f42517c));
        logItem.b("rspTime", String.valueOf(dVar.f42518d));
        logItem.b(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(dVar.f42519e));
        logItem.b("clientIp", CommonHelper.getIp());
        logItem.b("tiebaIp", str4);
        String domainIp = ImageLoggerHelper.getInstance().getDomainIp(str);
        if (!TextUtils.isEmpty(domainIp)) {
            logItem.b("domainIp", domainIp);
        }
        logItem.b("wifiDnsIp", dnsIp);
        long j2 = dVar.f42517c;
        if (j2 > 1500 || j2 < 0) {
            logItem.b("connBaidu", String.valueOf(connBaidu()));
        }
        logItem.b("memory", memoryUsage());
        logItem.b("task", taskStatus());
        logItem.b("status", String.valueOf(dVar.j));
        logItem.b("up", String.valueOf(dVar.f42515a));
        logItem.b("down", String.valueOf(dVar.f42516b));
        logItem.b("isCDN", b2 ? "1" : "0");
        logItem.b("isWebp", bool.booleanValue() ? "1" : "0");
        logItem.b("isMobileProxy", z2 ? "1" : "0");
        logItem.b("exception", dVar.f42522h);
        logItem.b("reason", str3);
        if (i != 0) {
            logItem.c("procType", Integer.valueOf(i));
        }
        String str5 = dVar.t;
        if (str5 != null) {
            logItem.b("tracecode1", str5);
        }
        String str6 = dVar.u;
        if (str6 != null) {
            logItem.b("tracecode2", str6);
        }
        if (!k.isEmpty(dVar.k)) {
            logItem.b("httpDnsIp", dVar.k);
        } else {
            logItem.b("httpDnsIp", dVar.l);
        }
        logItem.c("ipIndex", Integer.valueOf(dVar.q));
        logItem.c("dnsSwitch1", Boolean.valueOf(c.f42509f));
        logItem.c("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
        logItem.b("httpDnsIpList", dVar.p);
        logItem.c("dnsResolveType", dVar.m);
        logItem.c("dnsResolveStatus", dVar.o);
        logItem.c("isUseIpDirectConnect", Boolean.valueOf(dVar.n));
        logItem.b("redirectUrl", dVar.r);
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    public static void loadWithDnsIpFail(a aVar) {
        aVar.b("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
    }

    public static String memoryUsage() {
        return d.b.i0.a0.c.k().v();
    }

    public static void mobileTachometerLoger(ArrayList<String> arrayList, long j) {
        if (arrayList == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i));
        }
        a logItem = getLogItem();
        logItem.b("act", "mobileTachometerCDN");
        logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j));
        logItem.b("ipList", sb.toString());
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static void tachometerCdnIpLog(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String hiphotosIp = str != null ? ImageLoggerHelper.getInstance().getHiphotosIp(str) : "";
        String dnsIp = getDnsIp();
        String ip = CommonHelper.getIp();
        a logItem = getLogItem();
        logItem.b("act", "tachometerCDN");
        logItem.b("errorNum", str3);
        logItem.b("execption", str4);
        logItem.b("size", str5);
        logItem.b("isScuess", z ? "1" : "0");
        logItem.b("url", str);
        logItem.b("localIp", ip);
        logItem.b("cdnIp", hiphotosIp);
        logItem.b("dnsIP", dnsIp);
        logItem.b("usedIp", str2);
        logItem.b("isUsedIp", z2 ? "0" : "1");
        logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static String taskStatus() {
        return d.b.c.e.c.a.e().z();
    }
}
