package com.baidu.adp.lib.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.service.AsyncService;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.ui.animview.praise.NetworkMonitor;
import com.baidu.tieba.of;
import com.baidu.tieba.qi;
import com.baidu.tieba.rk;
import com.baidu.tieba.ti;
import com.baidu.tieba.zk8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Pattern;
@Keep
/* loaded from: classes.dex */
public class BdNetTypeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String NATION_CODE = "460";
    public static final int NETWORK_CLASS_2_G = 1;
    public static final int NETWORK_CLASS_3_G = 2;
    public static final int NETWORK_CLASS_4_G = 3;
    public static final int NETWORK_CLASS_5_G = 4;
    public static final int NETWORK_CLASS_UNKNOWN = 0;
    public static final int NETWORK_OPERATOR_MOBILE = 1;
    public static final int NETWORK_OPERATOR_TELECOM = 3;
    public static final int NETWORK_OPERATOR_UNICOM = 2;
    public static final int NETWORK_OPERATOR_UNKOWN = 0;
    public static final int NETWORK_TYPE_1xRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_GSM = 16;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_IWLAN = 18;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_LTE_CA = 19;
    public static final int NETWORK_TYPE_NR = 20;
    public static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final int NET_TPYE_UNAVAILABLE = 0;
    public static final String NET_TYPENAME_2G = "2g";
    public static final String NET_TYPENAME_3G = "3g";
    public static final String NET_TYPENAME_4G = "4g";
    public static final String NET_TYPENAME_5G = "5g";
    public static final String NET_TYPENAME_UNAVAILABLE = "unreachable";
    public static final String NET_TYPENAME_WIFI = "wifi";
    public static final int NET_TYPE_2G = 2;
    public static final int NET_TYPE_3G = 3;
    public static final int NET_TYPE_4G = 4;
    public static final int NET_TYPE_5G = 5;
    public static final int NET_TYPE_WIFI = 1;
    public static BdNetTypeUtil mInstance;
    public static Pattern mPattern;
    public static boolean mSupportWap;
    public transient /* synthetic */ FieldHolder $fh;
    public int curMobileNetClassify;
    public int curMobileNetDetailType;
    public NetworkInfo curNetworkInfo;
    public boolean isMobile;
    public boolean isNetAvailable;
    public boolean isOpenNetChangedMessage;
    public boolean isWifi;
    public Runnable mNetChangeRunnable;
    public long mNetChangedTime;
    public String mProxyHost;
    public int mProxyPort;
    public int operatorType;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(BdNetTypeUtil bdNetTypeUtil) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdNetTypeUtil};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    int netType = BdNetTypeUtil.netType();
                    long netChangedTime = BdNetTypeUtil.getNetChangedTime();
                    BdNetTypeUtil.curNetState();
                    if (!BdNetTypeUtil.isOpenNetChangedMsg()) {
                        return;
                    }
                    NetworkState networkState = new NetworkState();
                    networkState.mLastNetState = netType;
                    networkState.mCurNetState = BdNetTypeUtil.netType();
                    networkState.mlastChangedTime = netChangedTime;
                    long currentTimeMillis = System.currentTimeMillis();
                    networkState.mCurChangedTime = currentTimeMillis;
                    BdNetTypeUtil.setNetWorkChangedTime(currentTimeMillis);
                    MessageManager.getInstance().dispatchResponsedMessage(new NetWorkChangedMessage(networkState));
                    zk8 a = rk.a();
                    a.c(Config.DEVICE_PART, "net status: " + networkState.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public /* synthetic */ b(a aVar) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                AsyncService.INSTANCE.sendRunnable(BdNetTypeUtil.access$100().mNetChangeRunnable);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1895436873, "Lcom/baidu/adp/lib/util/BdNetTypeUtil;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1895436873, "Lcom/baidu/adp/lib/util/BdNetTypeUtil;");
                return;
            }
        }
        mPattern = Pattern.compile("^[0]{0,1}10\\.[0]{1,3}\\.[0]{1,3}\\.(172|200)$", 8);
        mSupportWap = true;
        try {
            b bVar = new b(null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.setPriority(1000);
            intentFilter.addAction(NetworkMonitor.NET_CHANGE_ACTION);
            BdBaseApplication.getInst().getApp().registerReceiver(bVar, intentFilter);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
        mInstance = null;
    }

    public static String getNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            if (!isNetWorkAvailable()) {
                return "N";
            }
            if (isWifiNet()) {
                return "WIFI";
            }
            if (is5GNet()) {
                return "5G";
            }
            if (is4GNet()) {
                return "4G";
            }
            if (is3GNet()) {
                return "3G";
            }
            if (!is2GNet()) {
                return "N";
            }
            return "2G";
        }
        return (String) invokeV.objValue;
    }

    public static int readNetworkOperatorType() {
        InterceptResult invokeV;
        String substring;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65570, null)) == null) {
            String j = ti.j();
            if (j.length() < 4 || qi.isEmptyStringAfterTrim(j) || (substring = j.substring(0, 3)) == null || !substring.equals(NATION_CODE)) {
                return 0;
            }
            try {
                i = Integer.parseInt(j.substring(3));
            } catch (NumberFormatException unused) {
                i = 0;
            }
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3 && i != 5) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 11) {
                                        return 0;
                                    }
                                }
                            }
                        }
                        return 3;
                    }
                }
                return 2;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public BdNetTypeUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.curNetworkInfo = null;
        this.isWifi = true;
        this.isMobile = false;
        this.isNetAvailable = true;
        this.curMobileNetDetailType = 0;
        this.curMobileNetClassify = 0;
        this.operatorType = -1;
        this.mProxyHost = null;
        this.mProxyPort = -1;
        this.isOpenNetChangedMessage = true;
        this.mNetChangeRunnable = new a(this);
    }

    public static boolean isNetworkAvailableForImmediately() {
        InterceptResult invokeV;
        NetworkInfo[] allNetworkInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65560, null)) == null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity");
                if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
                    for (NetworkInfo networkInfo : allNetworkInfo) {
                        if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                            return true;
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isWap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65564, null)) == null) {
            NetworkInfo activeNetworkInfo = getInstance().getActiveNetworkInfo();
            if (activeNetworkInfo == null || activeNetworkInfo.getExtraInfo() == null || !activeNetworkInfo.getExtraInfo().contains("wap")) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static int netType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65567, null)) == null) {
            if (isWifiNet()) {
                return 1;
            }
            if (is2GNet()) {
                return 2;
            }
            if (is3GNet()) {
                return 3;
            }
            if (is4GNet()) {
                return 4;
            }
            if (is5GNet()) {
                return 5;
            }
            if (isNetWorkAvailable()) {
                return 4;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static String netTypeNameInLowerCase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65568, null)) == null) {
            int netType = netType();
            if (netType != 1) {
                if (netType != 2) {
                    if (netType != 3) {
                        if (netType != 4) {
                            if (netType != 5) {
                                return NET_TYPENAME_UNAVAILABLE;
                            }
                            return "5g";
                        }
                        return "4g";
                    }
                    return "3g";
                }
                return "2g";
            }
            return "wifi";
        }
        return (String) invokeV.objValue;
    }

    public static /* synthetic */ BdNetTypeUtil access$100() {
        return getInstance();
    }

    public static String curMobileProxyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return getInstance().getProxyHost();
        }
        return (String) invokeV.objValue;
    }

    public static int curMobileProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return getInstance().getProxyPort();
        }
        return invokeV.intValue;
    }

    public static void curNetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, null) == null) {
            getInstance().getCurNetState();
        }
    }

    public static int curOperatorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return getInstance().getOperatorType();
        }
        return invokeV.intValue;
    }

    private long geNetworkChangedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            return this.mNetChangedTime;
        }
        return invokeV.longValue;
    }

    private NetworkInfo getActiveNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            try {
                return ((ConnectivityManager) BdBaseApplication.getInst().getContext().getSystemService("connectivity")).getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public static int getCurrentMobileNetType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return getInstance().getCurMobileNetDetailType();
        }
        return invokeV.intValue;
    }

    public static synchronized BdNetTypeUtil getInstance() {
        InterceptResult invokeV;
        BdNetTypeUtil bdNetTypeUtil;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) {
            synchronized (BdNetTypeUtil.class) {
                if (mInstance == null) {
                    mInstance = new BdNetTypeUtil();
                }
                bdNetTypeUtil = mInstance;
            }
            return bdNetTypeUtil;
        }
        return (BdNetTypeUtil) invokeV.objValue;
    }

    public static long getNetChangedTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, null)) == null) {
            return getInstance().geNetworkChangedTime();
        }
        return invokeV.longValue;
    }

    public static void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, null) == null) {
            init(true);
        }
    }

    public static boolean is2GNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, null)) == null) {
            if (1 == getInstance().getCurMobileNetClassify()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean is3GNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) {
            if (2 == getInstance().getCurMobileNetClassify()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean is4GNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, null)) == null) {
            if (3 == getInstance().getCurMobileNetClassify()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean is5GNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, null)) == null) {
            if (4 == getInstance().getCurMobileNetClassify()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean isMobileNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65558, null)) == null) {
            return getInstance().isMobile();
        }
        return invokeV.booleanValue;
    }

    public static boolean isNetWorkAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65559, null)) == null) {
            return getInstance().isNetAvailable();
        }
        return invokeV.booleanValue;
    }

    public static boolean isOpenNetChangedMsg() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65561, null)) == null) {
            return getInstance().isOpenNetChangedMessage();
        }
        return invokeV.booleanValue;
    }

    public static boolean isPorxyUsed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65562, null)) == null) {
            if (getInstance().isWifi || readNetworkOperatorType() == 1 || qi.isEmptyStringAfterTrim(Proxy.getDefaultHost())) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean isSupportWap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, null)) == null) {
            return mSupportWap;
        }
        return invokeV.booleanValue;
    }

    public static boolean isWifiNet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65566, null)) == null) {
            return getInstance().isWifi();
        }
        return invokeV.booleanValue;
    }

    public static String netTypeNameInUpperCase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65569, null)) == null) {
            String netTypeNameInLowerCase = netTypeNameInLowerCase();
            if (netTypeNameInLowerCase != null) {
                return netTypeNameInLowerCase.toUpperCase();
            }
            return netTypeNameInLowerCase;
        }
        return (String) invokeV.objValue;
    }

    public int getCurMobileNetClassify() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.curMobileNetClassify;
        }
        return invokeV.intValue;
    }

    public int getCurMobileNetDetailType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.curMobileNetDetailType;
        }
        return invokeV.intValue;
    }

    public NetworkInfo getCurNetworkInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.curNetworkInfo;
        }
        return (NetworkInfo) invokeV.objValue;
    }

    public int getOperatorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.operatorType == -1) {
                try {
                    this.operatorType = readNetworkOperatorType();
                } catch (Exception unused) {
                    this.operatorType = 0;
                }
            }
            return this.operatorType;
        }
        return invokeV.intValue;
    }

    public String getProxyHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mProxyHost == null) {
                this.mProxyHost = Proxy.getDefaultHost();
            }
            return this.mProxyHost;
        }
        return (String) invokeV.objValue;
    }

    public int getProxyPort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (-1 == this.mProxyPort) {
                this.mProxyPort = Proxy.getDefaultPort();
            }
            return this.mProxyPort;
        }
        return invokeV.intValue;
    }

    public boolean isMobile() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.isMobile;
        }
        return invokeV.booleanValue;
    }

    public boolean isNetAvailable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.isNetAvailable;
        }
        return invokeV.booleanValue;
    }

    public boolean isOpenNetChangedMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.isOpenNetChangedMessage;
        }
        return invokeV.booleanValue;
    }

    public boolean isWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.curNetworkInfo == null) {
                getCurNetState();
            }
            return this.isWifi;
        }
        return invokeV.booleanValue;
    }

    public static void init(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65553, null, z) == null) {
            getInstance().setOpenNetChangedMessage(z);
            getInstance().getCurNetState();
        }
    }

    public static boolean isWap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65565, null, str)) == null) {
            return mPattern.matcher(str).find();
        }
        return invokeL.booleanValue;
    }

    private void setNetChangedTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65571, this, j) == null) {
            this.mNetChangedTime = j;
        }
    }

    public static void setNetWorkChangedTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65572, null, j) == null) {
            getInstance().setNetChangedTime(j);
        }
    }

    public static void setSupportWap(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65573, null, z) == null) {
            mSupportWap = z;
        }
    }

    public void setOpenNetChangedMessage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.isOpenNetChangedMessage = z;
        }
    }

    private void getCurNetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            NetworkInfo activeNetworkInfo = getActiveNetworkInfo();
            this.curNetworkInfo = activeNetworkInfo;
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == 1) {
                    this.isWifi = true;
                    this.isMobile = false;
                } else if (activeNetworkInfo.getType() == 0) {
                    this.isWifi = false;
                    this.isMobile = true;
                } else {
                    this.isWifi = false;
                    this.isMobile = false;
                }
                this.isNetAvailable = true;
                int subtype = activeNetworkInfo.getSubtype();
                this.curMobileNetDetailType = subtype;
                if (this.isMobile) {
                    this.curMobileNetClassify = getNetworkClass(subtype);
                } else {
                    this.curMobileNetClassify = 0;
                }
            } else {
                this.isWifi = false;
                this.isMobile = false;
                this.isNetAvailable = false;
                this.curMobileNetDetailType = 0;
                this.curMobileNetDetailType = 0;
            }
            this.operatorType = readNetworkOperatorType();
            this.mProxyHost = Proxy.getDefaultHost();
            this.mProxyPort = Proxy.getDefaultPort();
        }
    }

    public static int getNetworkClass(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65551, null, i)) == null) {
            boolean netBdABTest = ((of) ServiceManager.getService(of.a)).netBdABTest();
            switch (i) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return 1;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return 2;
                case 13:
                    return 3;
                case 16:
                    if (!netBdABTest) {
                        return 1;
                    }
                    return 0;
                case 17:
                    if (!netBdABTest) {
                        return 2;
                    }
                    return 0;
                case 18:
                case 19:
                    if (!netBdABTest) {
                        return 3;
                    }
                    return 0;
                case 20:
                    if (netBdABTest) {
                        return 0;
                    }
                    return 4;
                default:
                    return 0;
            }
        }
        return invokeI.intValue;
    }
}
