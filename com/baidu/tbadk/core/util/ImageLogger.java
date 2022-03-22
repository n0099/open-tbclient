package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.j.b.c;
import c.a.d.f.j.b.e;
import c.a.d.f.n.a;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.c1.t;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
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
/* loaded from: classes4.dex */
public class ImageLogger {
    public static /* synthetic */ Interceptable $ic;
    public static long connBaiduCost;
    public static long connBaiduNum;
    public static int mCWImgFialedCnt;
    public static Object syncLock;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
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
        long j;
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
                j = System.currentTimeMillis() - currentTimeMillis;
                c.a.d.f.m.a.e(httpURLConnection);
            } catch (SocketTimeoutException unused3) {
                httpURLConnection2 = httpURLConnection;
                j = TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
                c.a.d.f.m.a.e(httpURLConnection2);
                if (j > 0) {
                }
                return j;
            } catch (Exception unused4) {
                httpURLConnection2 = httpURLConnection;
                c.a.d.f.m.a.e(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                c.a.d.f.m.a.e(httpURLConnection2);
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
        if (interceptable == null || interceptable.invokeLIII(InputDeviceCompat.SOURCE_TRACKBALL, null, str, i, i2, i3) == null) {
            if (i == -1) {
                i = 0;
            }
            if (i2 == -1) {
                i2 = 0;
            }
            BdStatisticsManager.getInstance().eventStat(null, str, "imgHttpSwitch", 1, "1sterrcode", String.valueOf(i), "2nderrcode", String.valueOf(i2), "2imgFailed", String.valueOf(i3));
        }
    }

    public static void getCDNListError(boolean z, boolean z2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2}) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
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

    public static void imagePerfNetLog(String str, boolean z, String str2, Boolean bool, e eVar, String str3, long j, boolean z2, int i) {
        boolean z3;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65545, null, new Object[]{str, Boolean.valueOf(z), str2, bool, eVar, str3, Long.valueOf(j), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) && n.C() && eVar != null) {
            String str4 = "";
            boolean b2 = t.b(str2);
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                z3 = true;
            } else {
                z3 = false;
            }
            boolean H = l.H();
            boolean isShouldCDNFallBack = (b2 && z3) ? ICDNIPDirectConnect.getInstance().isShouldCDNFallBack() : false;
            if (b2 && H && isShouldCDNFallBack) {
                if (z) {
                    ICDNProblemUploader.getInstance().insertNormalData(j, str);
                } else {
                    str4 = ImageLoggerHelper.getInstance().getTiebaIp();
                    if (!TextUtils.isEmpty(str4)) {
                        ICDNProblemUploader.getInstance().insertErrorData(eVar.i, str);
                    }
                }
            }
            synchronized (syncLock) {
                if (z) {
                    mCWImgFialedCnt = 0;
                } else if (l.z()) {
                    int i2 = mCWImgFialedCnt + 1;
                    mCWImgFialedCnt = i2;
                    if (i2 >= c.a.d.f.n.m.a.o().q("alert_img", 5)) {
                        BdStatisticsManager bdStatisticsManager = BdStatisticsManager.getInstance();
                        bdStatisticsManager.alert("alert_img", "imgFailedCnt_" + String.valueOf(mCWImgFialedCnt) + "_url=" + str2);
                    }
                }
            }
            if (z && z3) {
                if (H && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f10451d) {
                    return;
                }
                if (!H && l.t() && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f10453f) {
                    return;
                }
                if (!H && j < ICDNIPDirectConnect.getInstance().getCDNImageTimeData().f10452e) {
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
            logItem.b("netlib", eVar.v == 0 ? "Apache" : "HttpManager");
            logItem.b(TiebaStatic.LogFields.COST_TIME, String.valueOf(j));
            logItem.b("connTime", String.valueOf(eVar.f2147c));
            logItem.b("rspTime", String.valueOf(eVar.f2148d));
            logItem.b(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(eVar.f2149e));
            logItem.b("clientIp", CommonHelper.getIp());
            logItem.b("tiebaIp", str4);
            String domainIp = ImageLoggerHelper.getInstance().getDomainIp(str);
            if (!TextUtils.isEmpty(domainIp)) {
                logItem.b("domainIp", domainIp);
            }
            logItem.b("wifiDnsIp", dnsIp);
            long j2 = eVar.f2147c;
            if (j2 > 1500 || j2 < 0) {
                logItem.b("connBaidu", String.valueOf(connBaidu()));
            }
            logItem.b("memory", memoryUsage());
            logItem.b("task", taskStatus());
            logItem.b("status", String.valueOf(eVar.j));
            logItem.b("up", String.valueOf(eVar.a));
            logItem.b("down", String.valueOf(eVar.f2146b));
            logItem.b("isCDN", b2 ? "1" : "0");
            logItem.b("isWebp", bool.booleanValue() ? "1" : "0");
            logItem.b("isMobileProxy", z2 ? "1" : "0");
            logItem.b("exception", eVar.f2152h);
            logItem.b("reason", str3);
            if (i != 0) {
                logItem.c("procType", Integer.valueOf(i));
            }
            String str5 = eVar.t;
            if (str5 != null) {
                logItem.b("tracecode1", str5);
            }
            String str6 = eVar.u;
            if (str6 != null) {
                logItem.b("tracecode2", str6);
            }
            if (!m.isEmpty(eVar.k)) {
                logItem.b("httpDnsIp", eVar.k);
            } else {
                logItem.b("httpDnsIp", eVar.l);
            }
            logItem.c("ipIndex", Integer.valueOf(eVar.q));
            logItem.c("dnsSwitch1", Boolean.valueOf(c.f2138f));
            logItem.c("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            logItem.b("httpDnsIpList", eVar.p);
            logItem.c("dnsResolveType", eVar.m);
            logItem.c("dnsResolveStatus", eVar.o);
            logItem.c("isUseIpDirectConnect", Boolean.valueOf(eVar.n));
            logItem.b("redirectUrl", eVar.r);
            BdStatisticsManager.getInstance().debug("img", logItem);
        }
    }

    public static String intToIp(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65546, null, i)) == null) {
            return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? c.a.o0.b0.c.k().v() : (String) invokeV.objValue;
    }

    public static void mobileTachometerLoger(ArrayList<String> arrayList, long j) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLJ(65549, null, arrayList, j) == null) || arrayList == null) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65550, null, new Object[]{Boolean.valueOf(z), str, str2, str3, str4, str5, Long.valueOf(j), Boolean.valueOf(z2)}) == null) {
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
    }

    public static String taskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) ? c.a.d.f.c.a.e().z() : (String) invokeV.objValue;
    }
}
