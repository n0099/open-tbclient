package com.baidu.tbadk.core.util;

import android.net.DhcpInfo;
import android.text.TextUtils;
import androidx.appcompat.widget.TooltipCompatHandler;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.BdCloseHelper;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.searchbox.download.constants.DownloadStatisticConstants;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.ICDNIPDirectConnect;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import com.baidu.tieba.be;
import com.baidu.tieba.di;
import com.baidu.tieba.ex5;
import com.baidu.tieba.lf;
import com.baidu.tieba.nf;
import com.baidu.tieba.zg;
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

    public static BdStatsItem getLogItem() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return BdStatisticsManager.getInstance().getStatsItem("dbg");
        }
        return (BdStatsItem) invokeV.objValue;
    }

    public static String memoryUsage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return TbImageMemoryCache.A().N();
        }
        return (String) invokeV.objValue;
    }

    public static String taskStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return be.e().z();
        }
        return (String) invokeV.objValue;
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
                BdCloseHelper.close(httpURLConnection);
            } catch (SocketTimeoutException unused3) {
                httpURLConnection2 = httpURLConnection;
                j = TooltipCompatHandler.LONG_CLICK_HIDE_TIMEOUT_MS;
                BdCloseHelper.close(httpURLConnection2);
                if (j > 0) {
                }
                return j;
            } catch (Exception unused4) {
                httpURLConnection2 = httpURLConnection;
                BdCloseHelper.close(httpURLConnection2);
                j = -1;
                if (j > 0) {
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection2 = httpURLConnection;
                BdCloseHelper.close(httpURLConnection2);
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

    public static void imagePerfNetLog(String str, boolean z, String str2, Boolean bool, nf nfVar, String str3, long j, boolean z2, int i) {
        boolean z3;
        boolean z4;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{str, Boolean.valueOf(z), str2, bool, nfVar, str3, Long.valueOf(j), Boolean.valueOf(z2), Integer.valueOf(i)}) == null) && BdUtilHelper.isNetOk() && nfVar != null) {
            String str9 = "";
            boolean a = ex5.a(str2);
            if (ICDNIPDirectConnect.getInstance() != null) {
                if (!ICDNIPDirectConnect.getInstance().isAlreadyInit) {
                    ICDNIPDirectConnect.getInstance().init();
                }
                z3 = true;
            } else {
                z3 = false;
            }
            boolean isWifiNet = BdNetTypeUtil.isWifiNet();
            if (a && z3) {
                z4 = ICDNIPDirectConnect.getInstance().isShouldCDNFallBack();
            } else {
                z4 = false;
            }
            if (a && isWifiNet && z4) {
                if (z) {
                    ICDNProblemUploader.getInstance().insertNormalData(j, str);
                } else {
                    str9 = ImageLoggerHelper.getInstance().getTiebaIp();
                    if (!TextUtils.isEmpty(str9)) {
                        ICDNProblemUploader.getInstance().insertErrorData(nfVar.i, str);
                    }
                }
            }
            synchronized (syncLock) {
                if (z) {
                    mCWImgFialedCnt = 0;
                } else if (BdNetTypeUtil.isNetWorkAvailable()) {
                    int i2 = mCWImgFialedCnt + 1;
                    mCWImgFialedCnt = i2;
                    if (i2 >= zg.o().q("alert_img", 5)) {
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
            BdStatsItem logItem = getLogItem();
            if (TextUtils.isEmpty(str9)) {
                str9 = ImageLoggerHelper.getInstance().getTiebaIp();
            }
            logItem.append("url", str);
            logItem.append("act", "dl");
            if (z) {
                str4 = "1";
            } else {
                str4 = "0";
            }
            logItem.append("result", str4);
            logItem.append("requrl", str2);
            if (nfVar.v == 0) {
                str5 = "Apache";
            } else {
                str5 = "HttpManager";
            }
            logItem.append("netlib", str5);
            logItem.append("costTime", String.valueOf(j));
            logItem.append("connTime", String.valueOf(nfVar.c));
            logItem.append("rspTime", String.valueOf(nfVar.d));
            logItem.append(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, String.valueOf(nfVar.e));
            logItem.append("clientIp", CommonHelper.getIp());
            logItem.append("tiebaIp", str9);
            String domainIp = ImageLoggerHelper.getInstance().getDomainIp(str);
            if (!TextUtils.isEmpty(domainIp)) {
                logItem.append("domainIp", domainIp);
            }
            logItem.append("wifiDnsIp", "");
            long j2 = nfVar.c;
            if (j2 > 1500 || j2 < 0) {
                logItem.append("connBaidu", String.valueOf(connBaidu()));
            }
            logItem.append("memory", memoryUsage());
            logItem.append(DownloadStatisticConstants.UBC_VALUE_TASK, taskStatus());
            logItem.append("status", String.valueOf(nfVar.j));
            logItem.append(MapBundleKey.OfflineMapKey.OFFLINE_UPDATE, String.valueOf(nfVar.a));
            logItem.append("down", String.valueOf(nfVar.b));
            if (a) {
                str6 = "1";
            } else {
                str6 = "0";
            }
            logItem.append("isCDN", str6);
            if (bool.booleanValue()) {
                str7 = "1";
            } else {
                str7 = "0";
            }
            logItem.append("isWebp", str7);
            if (z2) {
                str8 = "1";
            } else {
                str8 = "0";
            }
            logItem.append("isMobileProxy", str8);
            logItem.append("exception", nfVar.h);
            logItem.append("reason", str3);
            if (i != 0) {
                logItem.append("procType", Integer.valueOf(i));
            }
            String str10 = nfVar.t;
            if (str10 != null) {
                logItem.append("tracecode1", str10);
            }
            String str11 = nfVar.u;
            if (str11 != null) {
                logItem.append("tracecode2", str11);
            }
            if (!di.isEmpty(nfVar.k)) {
                logItem.append("httpDnsIp", nfVar.k);
            } else {
                logItem.append("httpDnsIp", nfVar.l);
            }
            logItem.append("ipIndex", Integer.valueOf(nfVar.q));
            logItem.append("dnsSwitch1", Boolean.valueOf(lf.e));
            logItem.append("dnsSwitch2", Boolean.valueOf(UseHttpdnsSdkSwitch.isOn()));
            logItem.append("httpDnsIpList", nfVar.p);
            logItem.append("dnsResolveType", nfVar.m);
            logItem.append("dnsResolveStatus", nfVar.o);
            logItem.append("isUseIpDirectConnect", Boolean.valueOf(nfVar.n));
            logItem.append("redirectUrl", nfVar.r);
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
}
