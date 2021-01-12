package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    private static long eXt = 0;
    private static long eXu = 0;
    private static int eXv = 0;
    private static Object eXw = new Object();

    public static com.baidu.adp.lib.stats.a pi() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(String str, boolean z, String str2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z2, int i) {
        String str4;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str5 = "";
            boolean isCdn = com.baidu.tbadk.util.m.isCdn(str2);
            boolean z3 = false;
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                z3 = true;
                if (!com.baidu.tbadk.core.util.b.e.getInstance().eZB) {
                    com.baidu.tbadk.core.util.b.e.getInstance().init();
                }
            }
            boolean isWifiNet = com.baidu.adp.lib.util.j.isWifiNet();
            boolean z4 = false;
            if (isCdn && z3) {
                z4 = com.baidu.tbadk.core.util.b.e.getInstance().isShouldCDNFallBack();
            }
            if (isCdn && isWifiNet && z4) {
                if (z) {
                    r.getInstance().insertNormalData(j, str);
                } else {
                    str5 = u.brS().brT();
                    if (!TextUtils.isEmpty(str5)) {
                        r.getInstance().insertErrorData(dVar.Me, str);
                    }
                }
            }
            synchronized (eXw) {
                if (z) {
                    eXv = 0;
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    int i2 = eXv + 1;
                    eXv = i2;
                    if (i2 >= com.baidu.adp.lib.stats.switchs.a.nt().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                        BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(eXv) + "_url=" + str2);
                    }
                }
            }
            if (z && z3) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eHc) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eHf) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eHe) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            com.baidu.adp.lib.stats.a pi = pi();
            if (TextUtils.isEmpty(str5)) {
                str5 = u.brS().brT();
            }
            if (!TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = brO();
            }
            pi.append("url", str);
            pi.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            pi.append("result", z ? "1" : "0");
            pi.append("requrl", str2);
            pi.append("netlib", dVar.Mo == 0 ? "Apache" : "HttpManager");
            pi.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            pi.append("connTime", String.valueOf(dVar.connectTime));
            pi.append("rspTime", String.valueOf(dVar.Mc));
            pi.append("retry", String.valueOf(dVar.retry));
            pi.append("clientIp", d.getIp());
            pi.append("tiebaIp", str5);
            String AG = u.brS().AG(str);
            if (!TextUtils.isEmpty(AG)) {
                pi.append("domainIp", AG);
            }
            pi.append("wifiDnsIp", str4);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                pi.append("connBaidu", String.valueOf(brP()));
            }
            pi.append("memory", brQ());
            pi.append("task", brR());
            pi.append("status", String.valueOf(dVar.Mf));
            pi.append("up", String.valueOf(dVar.Mb));
            pi.append("down", String.valueOf(dVar.downloadSize));
            pi.append("isCDN", isCdn ? "1" : "0");
            pi.append("isWebp", bool.booleanValue() ? "1" : "0");
            pi.append("isMobileProxy", z2 ? "1" : "0");
            pi.append("exception", dVar.exception);
            pi.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                pi.append("procType", Integer.valueOf(i));
            }
            if (dVar.Mm != null) {
                pi.append("tracecode1", dVar.Mm);
            }
            if (dVar.Mn != null) {
                pi.append("tracecode2", dVar.Mn);
            }
            if (!at.isEmpty(dVar.Mg)) {
                pi.append("httpDnsIp", dVar.Mg);
            } else {
                pi.append("httpDnsIp", dVar.Mh);
            }
            pi.append("ipIndex", Integer.valueOf(dVar.Ml));
            pi.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.LR));
            pi.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            pi.append("httpDnsIpList", dVar.Mk);
            pi.append("dnsResolveType", dVar.Mi);
            pi.append("dnsResolveStatus", dVar.Mj);
            pi.append("isUseIpDirectConnect", Boolean.valueOf(dVar.LO));
            pi.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", pi);
        }
    }

    public static void AF(String str) {
        com.baidu.adp.lib.stats.a pi = pi();
        pi.append("act", "assistant");
        pi.append("content", str);
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    private static String brO() {
        try {
            if (ad.bsf()) {
                DhcpInfo dhcpInfo = ((WifiManager) BdBaseApplication.getInst().getApplicationContext().getSystemService("wifi")).getDhcpInfo();
                return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String intToIp(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [231=5] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static long brP() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        long j;
        if (eXt >= 3) {
            return eXu;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HttpURLConnection httpURLConnection3 = null;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL("http://www.baidu.com/").openConnection();
        } catch (SocketTimeoutException e) {
            httpURLConnection2 = null;
        } catch (Exception e2) {
        } catch (Throwable th2) {
            th = th2;
            httpURLConnection = null;
        }
        try {
            httpURLConnection2.setConnectTimeout(TbConfig.NOTIFY_YUN_PUSH);
            httpURLConnection2.connect();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            j = currentTimeMillis2;
        } catch (SocketTimeoutException e3) {
            com.baidu.adp.lib.f.a.close(httpURLConnection2);
            j = 2500;
            if (j > 0) {
            }
        } catch (Exception e4) {
            httpURLConnection3 = httpURLConnection2;
            com.baidu.adp.lib.f.a.close(httpURLConnection3);
            j = -1;
            if (j > 0) {
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = httpURLConnection2;
            com.baidu.adp.lib.f.a.close(httpURLConnection);
            throw th;
        }
        if (j > 0) {
            if (eXt > -1) {
                eXu = ((eXu * eXt) + j) / (eXt + 1);
            } else {
                eXu = j;
            }
            eXt++;
            return j;
        }
        return j;
    }

    private static String brQ() {
        return com.baidu.tbadk.imageManager.c.bCx().toLogString();
    }

    private static String brR() {
        return com.baidu.adp.lib.asyncTask.a.lp().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a pi = pi();
        pi.append("act", "getCDNList");
        pi.append("errorNum", str);
        pi.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        pi.append("isShortNetError", z2 ? "1" : "0");
        pi.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = u.brS().AH(str);
        }
        String brO = brO();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a pi = pi();
        pi.append("act", "tachometerCDN");
        pi.append("errorNum", str3);
        pi.append("execption", str4);
        pi.append(TiebaInitialize.LogFields.SIZE, str5);
        pi.append("isScuess", z ? "1" : "0");
        pi.append("url", str);
        pi.append("localIp", ip);
        pi.append("cdnIp", str6);
        pi.append("dnsIP", brO);
        pi.append("usedIp", str2);
        pi.append("isUsedIp", z2 ? "0" : "1");
        pi.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    public static void a(ArrayList<String> arrayList, long j) {
        if (arrayList != null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    if (i2 != 0) {
                        sb.append(",");
                    }
                    sb.append(arrayList.get(i2));
                    i = i2 + 1;
                } else {
                    com.baidu.adp.lib.stats.a pi = pi();
                    pi.append("act", "mobileTachometerCDN");
                    pi.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    pi.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", pi);
                    return;
                }
            }
        }
    }

    public static void o(boolean z, String str) {
        com.baidu.adp.lib.stats.a pi = pi();
        pi.append("act", "getCDNList");
        pi.append("isSuccess", z ? "1" : "0");
        pi.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", pi);
    }

    public static void e(com.baidu.adp.lib.stats.a aVar) {
        aVar.append("act", "tiebaPic");
        BdStatisticsManager.getInstance().debug("img", aVar);
    }

    public static void b(String str, int i, int i2, int i3) {
        if (i == -1) {
            i = 0;
        }
        if (i2 == -1) {
            i2 = 0;
        }
        BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
    }
}
