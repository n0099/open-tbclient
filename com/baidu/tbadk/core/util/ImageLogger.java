package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.bi;
import com.baidu.tieba.ch;
import com.baidu.tieba.dj;
import com.baidu.tieba.eg;
import com.baidu.tieba.ej;
import com.baidu.tieba.gg;
import com.baidu.tieba.lh;
import com.baidu.tieba.u75;
import com.baidu.tieba.we;
import com.baidu.tieba.wg5;
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
/* loaded from: classes3.dex */
public class ImageLogger {
    public static /* synthetic */ Interceptable $ic;
    public static long connBaiduCost;
    public static long connBaiduNum;
    public static int mCWImgFialedCnt;
    public static Object syncLock;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long connBaidu() {
        InterceptResult invokeV;
        long j;
        HttpURLConnection httpURLConnection;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
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
                ch.f(httpURLConnection);
            } catch (SocketTimeoutException unused3) {
                httpURLConnection2 = httpURLConnection;
                j = TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
                ch.f(httpURLConnection2);
                if (j > 0) {
                }
                return j;
            } catch (Exception unused4) {
                httpURLConnection2 = httpURLConnection;
                ch.f(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                ch.f(httpURLConnection2);
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
        return invokeV.longValue;
    }

    public static void eventStatForHttpSwitch(String str, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65539, null, str, i, i2, i3) == null) {
            if (i == -1) {
                i = 0;
            }
            if (i2 == -1) {
                i2 = 0;
            }
            BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
        }
    }

    public static String getDnsIp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            DhcpInfo dhcpInfo = TbadkCoreApplication.getInst().getDhcpInfo();
            if (dhcpInfo != null) {
                return intToIp(dhcpInfo.dns1) + "," + intToIp(dhcpInfo.dns2);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static lh getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? BdStatisticsManager.getInstance().getStatsItem("dbg") : (lh) invokeV.objValue;
    }

    public static void imagePerfNetLog(String str, boolean z, String str2, Boolean bool, gg ggVar, String str3, long j, boolean z2, int i) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), str2, bool, ggVar, str3, Long.valueOf(j), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) && ej.D() && ggVar != null) {
            String str4 = "";
            boolean a = wg5.a(str2);
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                z3 = true;
            } else {
                z3 = false;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            boolean isShouldCDNFallBack = (a && z3) ? ICDNIPDirectConnect.getInstance().isShouldCDNFallBack() : false;
            if (a && isWifiNet && isShouldCDNFallBack) {
                if (z) {
                    ICDNProblemUploader.getInstance().insertNormalData(j, str);
                } else {
                    str4 = ImageLoggerHelper.getInstance().getTiebaIp();
                    if (!TextUtils.isEmpty(str4)) {
                        ICDNProblemUploader.getInstance().insertErrorData(ggVar.i, str);
                    }
                }
            }
            synchronized (syncLock) {
                if (z) {
                    mCWImgFialedCnt = 0;
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    int i2 = mCWImgFialedCnt + 1;
                    mCWImgFialedCnt = i2;
                    if (i2 >= bi.o().q("alert_img", 5)) {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.alert("alert_img", "imgFailedCnt_" + String.valueOf(mCWImgFialedCnt) + "_url=" + str2);
                    }
                }
            }
            if (z && z3) {
                if (isWifiNet && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().a) {
                    return;
                }
                if (!isWifiNet && BdNetTypeUtil.is2GNet() && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().c) {
                    return;
                }
                if (!isWifiNet && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().b) {
                    return;
                }
            }
            lh logItem = getLogItem();
            if (TextUtils.isEmpty(str4)) {
                str4 = ImageLoggerHelper.getInstance().getTiebaIp();
            }
            String dnsIp = TextUtils.isEmpty("") ? getDnsIp() : "";
            logItem.b("url", str);
            logItem.b("act", "dl");
            logItem.b(TiebaStatic.LogFields.RESULT, z ? "1" : "0");
            logItem.b("requrl", str2);
            logItem.b("netlib", ggVar.v == 0 ? "Apache" : "HttpManager");
            logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j));
            logItem.b("connTime", String.valueOf(ggVar.c));
            logItem.b("rspTime", String.valueOf(ggVar.d));
            logItem.b(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(ggVar.e));
            logItem.b("clientIp", CommonHelper.getIp());
            logItem.b("tiebaIp", str4);
            String domainIp = ImageLoggerHelper.getInstance().getDomainIp(str);
            if (!TextUtils.isEmpty(domainIp)) {
                logItem.b("domainIp", domainIp);
            }
            logItem.b("wifiDnsIp", dnsIp);
            long j2 = ggVar.c;
            if (j2 > 1500 || j2 < 0) {
                logItem.b("connBaidu", String.valueOf(connBaidu()));
            }
            logItem.b("memory", memoryUsage());
            logItem.b("task", taskStatus());
            logItem.b("status", String.valueOf(ggVar.j));
            logItem.b("up", String.valueOf(ggVar.a));
            logItem.b("down", String.valueOf(ggVar.b));
            logItem.b("isCDN", a ? "1" : "0");
            logItem.b("isWebp", bool.booleanValue() ? "1" : "0");
            logItem.b("isMobileProxy", z2 ? "1" : "0");
            logItem.b("exception", ggVar.h);
            logItem.b("reason", str3);
            if (i != 0) {
                logItem.c("procType", Integer.valueOf(i));
            }
            String str5 = ggVar.t;
            if (str5 != null) {
                logItem.b("tracecode1", str5);
            }
            String str6 = ggVar.u;
            if (str6 != null) {
                logItem.b("tracecode2", str6);
            }
            if (!dj.isEmpty(ggVar.k)) {
                logItem.b("httpDnsIp", ggVar.k);
            } else {
                logItem.b("httpDnsIp", ggVar.l);
            }
            logItem.c("ipIndex", Integer.valueOf(ggVar.q));
            logItem.c("dnsSwitch1", Boolean.valueOf(eg.e));
            logItem.c("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            logItem.b("httpDnsIpList", ggVar.p);
            logItem.c("dnsResolveType", ggVar.m);
            logItem.c("dnsResolveStatus", ggVar.o);
            logItem.c("isUseIpDirectConnect", Boolean.valueOf(ggVar.n));
            logItem.b("redirectUrl", ggVar.r);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static String intToIp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
        }
        return (String) invokeI.objValue;
    }

    public static String memoryUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? u75.k().v() : (String) invokeV.objValue;
    }

    public static String taskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) ? we.e().z() : (String) invokeV.objValue;
    }
}
