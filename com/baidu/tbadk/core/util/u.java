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
public class u {
    private static long fbi = 0;
    private static long fbj = 0;
    private static int fbk = 0;
    private static Object syncLock = new Object();

    public static com.baidu.adp.lib.stats.a pg() {
        return BdStatisticsManager.getInstance().getStatsItem("dbg");
    }

    public static void a(String str, boolean z, String str2, Boolean bool, com.baidu.adp.lib.network.http.d dVar, String str3, long j, boolean z2, int i) {
        String str4;
        if (com.baidu.adp.lib.util.l.isNetOk() && dVar != null) {
            String str5 = "";
            boolean isCdn = com.baidu.tbadk.util.n.isCdn(str2);
            boolean z3 = false;
            if (com.baidu.tbadk.core.util.b.e.getInstance() != null) {
                z3 = true;
                if (!com.baidu.tbadk.core.util.b.e.getInstance().fdq) {
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
                    s.getInstance().insertNormalData(j, str);
                } else {
                    str5 = v.bsp().bsq();
                    if (!TextUtils.isEmpty(str5)) {
                        s.getInstance().insertErrorData(dVar.Nx, str);
                    }
                }
            }
            synchronized (syncLock) {
                if (z) {
                    fbk = 0;
                } else if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                    int i2 = fbk + 1;
                    fbk = i2;
                    if (i2 >= com.baidu.adp.lib.stats.switchs.a.ns().getMaxAlertCount(BdStatsConstant.AlertTypeKey.ALERT_IMG, 5)) {
                        BdStatisticsManager.getInstance().alert(BdStatsConstant.AlertTypeKey.ALERT_IMG, "imgFailedCnt_" + String.valueOf(fbk) + "_url=" + str2);
                    }
                }
            }
            if (z && z3) {
                if (!isWifiNet || j >= com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eKJ) {
                    if (isWifiNet || !com.baidu.adp.lib.util.j.is2GNet() || j >= com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eKM) {
                        if (!isWifiNet && j < com.baidu.tbadk.core.util.b.e.getInstance().getCDNImageTimeData().eKL) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            com.baidu.adp.lib.stats.a pg = pg();
            if (TextUtils.isEmpty(str5)) {
                str5 = v.bsp().bsq();
            }
            if (!TextUtils.isEmpty("")) {
                str4 = "";
            } else {
                str4 = bsl();
            }
            pg.append("url", str);
            pg.append("act", IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS);
            pg.append("result", z ? "1" : "0");
            pg.append("requrl", str2);
            pg.append("netlib", dVar.NK == 0 ? "Apache" : "HttpManager");
            pg.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
            pg.append("connTime", String.valueOf(dVar.connectTime));
            pg.append("rspTime", String.valueOf(dVar.Nv));
            pg.append("retry", String.valueOf(dVar.retry));
            pg.append("clientIp", d.getIp());
            pg.append("tiebaIp", str5);
            String Be = v.bsp().Be(str);
            if (!TextUtils.isEmpty(Be)) {
                pg.append("domainIp", Be);
            }
            pg.append("wifiDnsIp", str4);
            if (dVar.connectTime > 1500 || dVar.connectTime < 0) {
                pg.append("connBaidu", String.valueOf(bsm()));
            }
            pg.append("memory", bsn());
            pg.append("task", bso());
            pg.append("status", String.valueOf(dVar.Ny));
            pg.append("up", String.valueOf(dVar.Nu));
            pg.append("down", String.valueOf(dVar.downloadSize));
            pg.append("isCDN", isCdn ? "1" : "0");
            pg.append("isWebp", bool.booleanValue() ? "1" : "0");
            pg.append("isMobileProxy", z2 ? "1" : "0");
            pg.append("exception", dVar.exception);
            pg.append(TiebaInitialize.LogFields.REASON, str3);
            if (i != 0) {
                pg.append("procType", Integer.valueOf(i));
            }
            if (dVar.NI != null) {
                pg.append("tracecode1", dVar.NI);
            }
            if (dVar.NJ != null) {
                pg.append("tracecode2", dVar.NJ);
            }
            if (!au.isEmpty(dVar.Nz)) {
                pg.append("httpDnsIp", dVar.Nz);
            } else {
                pg.append("httpDnsIp", dVar.NC);
            }
            pg.append("ipIndex", Integer.valueOf(dVar.NH));
            pg.append("dnsSwitch1", Boolean.valueOf(com.baidu.adp.lib.network.http.c.Nl));
            pg.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            pg.append("httpDnsIpList", dVar.NG);
            pg.append("dnsResolveType", dVar.ND);
            pg.append("dnsResolveStatus", dVar.NF);
            pg.append("isUseIpDirectConnect", Boolean.valueOf(dVar.Nj));
            pg.append("redirectUrl", dVar.redirectUrl);
            BdStatisticsManager.getInstance().debug("img", pg);
        }
    }

    public static void Bd(String str) {
        com.baidu.adp.lib.stats.a pg = pg();
        pg.append("act", "assistant");
        pg.append("content", str);
        BdStatisticsManager.getInstance().debug("img", pg);
    }

    private static String bsl() {
        try {
            if (ae.bsC()) {
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
    private static long bsm() {
        Throwable th;
        HttpURLConnection httpURLConnection;
        HttpURLConnection httpURLConnection2;
        long j;
        if (fbi >= 3) {
            return fbj;
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
            if (fbi > -1) {
                fbj = ((fbj * fbi) + j) / (fbi + 1);
            } else {
                fbj = j;
            }
            fbi++;
            return j;
        }
        return j;
    }

    private static String bsn() {
        return com.baidu.tbadk.imageManager.c.bCS().toLogString();
    }

    private static String bso() {
        return com.baidu.adp.lib.asyncTask.a.lo().toLogString();
    }

    public static void a(boolean z, boolean z2, String str, String str2) {
        com.baidu.adp.lib.stats.a pg = pg();
        pg.append("act", "getCDNList");
        pg.append("errorNum", str);
        pg.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str2);
        pg.append("isShortNetError", z2 ? "1" : "0");
        pg.append("isSuccess", z ? "1" : "0");
        BdStatisticsManager.getInstance().debug("img", pg);
    }

    public static void a(boolean z, String str, String str2, String str3, String str4, String str5, long j, boolean z2) {
        String str6 = "";
        if (str != null) {
            str6 = v.bsp().Bf(str);
        }
        String bsl = bsl();
        String ip = d.getIp();
        com.baidu.adp.lib.stats.a pg = pg();
        pg.append("act", "tachometerCDN");
        pg.append("errorNum", str3);
        pg.append("execption", str4);
        pg.append(TiebaInitialize.LogFields.SIZE, str5);
        pg.append("isScuess", z ? "1" : "0");
        pg.append("url", str);
        pg.append("localIp", ip);
        pg.append("cdnIp", str6);
        pg.append("dnsIP", bsl);
        pg.append("usedIp", str2);
        pg.append("isUsedIp", z2 ? "0" : "1");
        pg.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
        BdStatisticsManager.getInstance().debug("img", pg);
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
                    com.baidu.adp.lib.stats.a pg = pg();
                    pg.append("act", "mobileTachometerCDN");
                    pg.append(TiebaInitialize.LogFields.COST_TIME, String.valueOf(j));
                    pg.append("ipList", sb.toString());
                    BdStatisticsManager.getInstance().debug("img", pg);
                    return;
                }
            }
        }
    }

    public static void s(boolean z, String str) {
        com.baidu.adp.lib.stats.a pg = pg();
        pg.append("act", "getCDNList");
        pg.append("isSuccess", z ? "1" : "0");
        pg.append(TiebaInitialize.LogFields.ERROR_MESSAGE, str);
        BdStatisticsManager.getInstance().debug("img", pg);
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
