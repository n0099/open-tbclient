package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.j.a.c;
import c.a.e.e.j.a.d;
import c.a.e.e.n.a;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.d1.r;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class ImageLogger {
    public static /* synthetic */ Interceptable $ic;
    public static long connBaiduCost;
    public static long connBaiduNum;
    public static int mCWImgFialedCnt;
    public static Object syncLock;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class IMG extends TiebaStatic.LogFields {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String ACTION = "act";
        public static final String TYPE = "type";
        public static final String TYPE_VALUE = "img";
        public transient /* synthetic */ FieldHolder $fh;

        public IMG() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1326186064, "Lcom/baidu/tbadk/core/util/ImageLogger;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1326186064, "Lcom/baidu/tbadk/core/util/ImageLogger;");
                return;
            }
        }
        syncLock = new Object();
    }

    public ImageLogger() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void assistant(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, str) == null) {
            a logItem = getLogItem();
            logItem.b("act", "assistant");
            logItem.b("content", str);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long connBaidu() {
        InterceptResult invokeV;
        long j2;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
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
                j2 = System.currentTimeMillis() - currentTimeMillis;
                c.a.e.e.m.a.e(httpURLConnection);
            } catch (SocketTimeoutException unused3) {
                httpURLConnection2 = httpURLConnection;
                j2 = TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
                c.a.e.e.m.a.e(httpURLConnection2);
                if (j2 > 0) {
                }
                return j2;
            } catch (Exception unused4) {
                httpURLConnection2 = httpURLConnection;
                c.a.e.e.m.a.e(httpURLConnection2);
                j2 = -1;
                if (j2 > 0) {
                }
                return j2;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                c.a.e.e.m.a.e(httpURLConnection2);
                throw th;
            }
            if (j2 > 0) {
                long j3 = connBaiduNum;
                if (j3 > -1) {
                    connBaiduCost = ((connBaiduCost * j3) + j2) / (j3 + 1);
                } else {
                    connBaiduCost = j2;
                }
                connBaiduNum++;
            }
            return j2;
        }
        return invokeV.longValue;
    }

    public static void eventStatForHttpSwitch(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i2, i3, i4) == null) {
            if (i2 == -1) {
                i2 = 0;
            }
            if (i3 == -1) {
                i3 = 0;
            }
            BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i2), "2nderrcode", String.valueOf(i3), "2imgFailed", String.valueOf(i4));
        }
    }

    public static void getCDNListError(boolean z, boolean z2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
            a logItem = getLogItem();
            logItem.b("act", "getCDNList");
            logItem.b("errorNum", str);
            logItem.b("errorMsg", str2);
            logItem.b("isShortNetError", z2 ? "1" : "0");
            logItem.b("isSuccess", z ? "1" : "0");
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static String getDnsIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) {
            DhcpInfo dhcpInfo = TbadkCoreApplication.getInst().getDhcpInfo();
            if (dhcpInfo != null) {
                return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static a getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) ? BdStatisticsManager.getInstance().getStatsItem("dbg") : (a) invokeV.objValue;
    }

    public static void getMobileCDNListError(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(65544, null, z, str) == null) {
            a logItem = getLogItem();
            logItem.b("act", "getCDNList");
            logItem.b("isSuccess", z ? "1" : "0");
            logItem.b("errorMsg", str);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static void imagePerfNetLog(String str, boolean z, String str2, Boolean bool, d dVar, String str3, long j2, boolean z2, int i2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, Boolean.valueOf(z), str2, bool, dVar, str3, Long.valueOf(j2), Boolean.valueOf(z2), Integer.valueOf(i2)}) == null) && l.D() && dVar != null) {
            String str4 = "";
            boolean b2 = r.b(str2);
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
                    ICDNProblemUploader.getInstance().insertNormalData(j2, str);
                } else {
                    str4 = ImageLoggerHelper.getInstance().getTiebaIp();
                    if (!TextUtils.isEmpty(str4)) {
                        ICDNProblemUploader.getInstance().insertErrorData(dVar.f2314i, str);
                    }
                }
            }
            synchronized (syncLock) {
                if (z) {
                    mCWImgFialedCnt = 0;
                } else if (j.z()) {
                    int i3 = mCWImgFialedCnt + 1;
                    mCWImgFialedCnt = i3;
                    if (i3 >= c.a.e.e.n.m.a.o().q("alert_img", 5)) {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.alert("alert_img", "imgFailedCnt_" + String.valueOf(mCWImgFialedCnt) + "_url=" + str2);
                    }
                }
            }
            if (z && z3) {
                if (H && j2 < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f13640d) {
                    return;
                }
                if (!H && j.t() && j2 < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f13642f) {
                    return;
                }
                if (!H && j2 < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f13641e) {
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
            logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j2));
            logItem.b("connTime", String.valueOf(dVar.f2308c));
            logItem.b("rspTime", String.valueOf(dVar.f2309d));
            logItem.b(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(dVar.f2310e));
            logItem.b("clientIp", CommonHelper.getIp());
            logItem.b("tiebaIp", str4);
            String domainIp = ImageLoggerHelper.getInstance().getDomainIp(str);
            if (!TextUtils.isEmpty(domainIp)) {
                logItem.b("domainIp", domainIp);
            }
            logItem.b("wifiDnsIp", dnsIp);
            long j3 = dVar.f2308c;
            if (j3 > 1500 || j3 < 0) {
                logItem.b("connBaidu", String.valueOf(connBaidu()));
            }
            logItem.b("memory", memoryUsage());
            logItem.b("task", taskStatus());
            logItem.b("status", String.valueOf(dVar.f2315j));
            logItem.b("up", String.valueOf(dVar.f2306a));
            logItem.b("down", String.valueOf(dVar.f2307b));
            logItem.b("isCDN", b2 ? "1" : "0");
            logItem.b("isWebp", bool.booleanValue() ? "1" : "0");
            logItem.b("isMobileProxy", z2 ? "1" : "0");
            logItem.b("exception", dVar.f2313h);
            logItem.b("reason", str3);
            if (i2 != 0) {
                logItem.c("procType", Integer.valueOf(i2));
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
            logItem.c("dnsSwitch1", Boolean.valueOf(c.f2300f));
            logItem.c("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            logItem.b("httpDnsIpList", dVar.p);
            logItem.c("dnsResolveType", dVar.m);
            logItem.c("dnsResolveStatus", dVar.o);
            logItem.c("isUseIpDirectConnect", Boolean.valueOf(dVar.n));
            logItem.b("redirectUrl", dVar.r);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static String intToIp(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i2)) == null) {
            return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
        }
        return (String) invokeI.objValue;
    }

    public static void loadWithDnsIpFail(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, null, aVar) == null) {
            aVar.b("act", "tiebaPic");
            BdStatisticsManager.getInstance().debug("img", aVar);
        }
    }

    public static String memoryUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.q0.c0.c.k().v() : (String) invokeV.objValue;
    }

    public static void mobileTachometerLoger(ArrayList<String> arrayList, long j2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65549, null, arrayList, j2) == null) || arrayList == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(arrayList.get(i2));
        }
        a logItem = getLogItem();
        logItem.b("act", "mobileTachometerCDN");
        logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j2));
        logItem.b("ipList", sb.toString());
        BdStatisticsManager.getInstance().debug("img", logItem);
    }

    public static void tachometerCdnIpLog(boolean z, String str, String str2, String str3, String str4, String str5, long j2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, str5, Long.valueOf(j2), Boolean.valueOf(z2)}) == null) {
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
            logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j2));
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static String taskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c.a.e.e.c.a.e().z() : (String) invokeV.objValue;
    }
}
