package com.baidu.searchbox.util;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.bdutil.cuid.sdk.AppCuidManager;
import com.baidu.android.common.logging.Log;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.CommonParam;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.android.util.io.Closeables;
import com.baidu.android.util.io.FileUtils;
import com.baidu.browser.BrowserType;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.mobstat.Config;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.searchbox.abtest.AbTestManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tbadk.core.util.ApiReplaceUtil;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tieba.b9;
import com.baidu.tieba.c20;
import com.baidu.tieba.d20;
import com.baidu.tieba.t10;
import com.baidu.tieba.u10;
import com.baidu.tieba.u20;
import com.baidu.tieba.v10;
import com.baidu.tieba.z10;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class BaiduIdentityManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CSRC = "csrc";
    public static final boolean DEBUG;
    public static final String DEFAULT_BD_FRAMEWORK = "1";
    public static final String KEY_LAST_TN = "lasttn";
    public static final String KEY_TN_TRACE = "tntrace";
    public static final int LIGHTAPP_TS_PARAM_LEN = 7;
    public static final String LOCINFO_STRING = "colinfo";
    public static final int MAX_LOC_WIFI_NUMBER = 15;
    public static final int MIN_LOC_WIFI_NUMBER = 6;
    public static final String PARAM_BDOS = "bdos";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_BD_FRAMEWORK = "bd_framework";
    public static final String PARAM_BD_VIP = "bd_vip";
    public static final String PARAM_BRNACH_NAME = "branchname";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CEN = "cen";
    public static final String PARAM_CMODE = "cmode";
    public static final String PARAM_CTV = "ctv";
    public static final String PARAM_CUA = "cua";
    public static final String PARAM_CUID = "cuid";
    public static final String PARAM_CUT = "cut";
    public static final String PARAM_IID = "iid";
    public static final String PARAM_LIGHTAPP_DEBUG = "debug";
    public static final String PARAM_MAPPING_SIGN = "mps";
    public static final String PARAM_MAPPING_VERSION = "mpv";
    public static final String PARAM_MATRIXSTYLE = "matrixstyle";
    public static final String PARAM_NETWORK = "network";
    public static final String PARAM_NETWORK_MODE = "p_nw";
    public static final String PARAM_OSBRANCH = "osbranch";
    public static final String PARAM_OSNAME = "osname";
    public static final String PARAM_PASSUID = "puid";
    public static final String PARAM_PU = "pu";
    public static final String PARAM_SDK_VERSION = "p_sv";
    public static final String PARAM_SERVICE = "bdbox";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_TIME_STAMP = "ts";
    public static final String PARAM_TYPE_ID = "typeid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static final String PREFS_NAME = "identity";
    public static final int PRIVACY_VERSION_V1 = 1;
    public static final Set<String> SEARCHBOX_CUSTOM_PARAMS;
    public static final int SUGGESTION_VERSION = 3;
    public static final String TAG = "BaiduIdentityManager";
    public static final String VALUE_OSNAME = "baiduboxapp";
    public static BaiduIdentityManager sIdentityManager;
    public transient /* synthetic */ FieldHolder $fh;
    public u10 customOSParam;
    public String mAndroidId;
    public volatile String mC3Aid;
    public CT mCT;
    @SuppressLint({"StaticFieldLeak"})
    public Context mContext;
    public v10 mDeviceInfoParam;
    public String mEnAndroidId;
    public String mEnUa;
    public IBaiduIdentityContext mIdentityContextImpl;
    public String mLastTn;
    public HashMap<String, String> mProcessedUa;
    public SharedPreferences mSettings;
    public String mTn;
    public String mUa;
    public String mVersionName;

    @SuppressLint({"HardwareIds"})
    @Deprecated
    public String getImsiInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? "" : (String) invokeV.objValue;
    }

    /* renamed from: com.baidu.searchbox.util.BaiduIdentityManager$3  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$browser$BrowserType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1408283547, "Lcom/baidu/searchbox/util/BaiduIdentityManager$3;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1408283547, "Lcom/baidu/searchbox/util/BaiduIdentityManager$3;");
                    return;
                }
            }
            int[] iArr = new int[BrowserType.values().length];
            $SwitchMap$com$baidu$browser$BrowserType = iArr;
            try {
                iArr[BrowserType.LIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.RABBIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.RABBIT_LITE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_MASTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_SLAVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_WEBVIEW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$baidu$browser$BrowserType[BrowserType.SWAN_APP_ADLANDING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1848811860, "Lcom/baidu/searchbox/util/BaiduIdentityManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1848811860, "Lcom/baidu/searchbox/util/BaiduIdentityManager;");
                return;
            }
        }
        DEBUG = LibBLCConfig.GLOBAL_DEBUG;
        HashSet hashSet = new HashSet();
        SEARCHBOX_CUSTOM_PARAMS = hashSet;
        hashSet.add("uid");
        SEARCHBOX_CUSTOM_PARAMS.add("from");
        SEARCHBOX_CUSTOM_PARAMS.add("ua");
        SEARCHBOX_CUSTOM_PARAMS.add("ut");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_OSNAME);
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_OSBRANCH);
        SEARCHBOX_CUSTOM_PARAMS.add("pkgname");
        SEARCHBOX_CUSTOM_PARAMS.add("network");
        SEARCHBOX_CUSTOM_PARAMS.add("cfrom");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_CTV);
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_CEN);
        SEARCHBOX_CUSTOM_PARAMS.add("apinfo");
        SEARCHBOX_CUSTOM_PARAMS.add(PARAM_PU);
    }

    public void checkTnTrace() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            Context context = this.mContext;
            if (DEBUG) {
                Log.e(TAG, "mLastTn: " + getLastTn());
                Log.e(TAG, "TnTrace: " + getTnTrace());
            }
            if (this.mIdentityContextImpl.isSelfUpdateInstalled(context)) {
                return;
            }
            this.mLastTn = getLastTn(context);
            if (DEBUG) {
                Log.e(TAG, "update mLastTn: " + this.mLastTn);
                Log.e(TAG, "update TnTrace: " + getTnTrace());
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r3.getHostAddress().toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getIpInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            String str = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                loop0: while (true) {
                    if (!networkInterfaces.hasMoreElements()) {
                        break;
                    }
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress()) {
                            break loop0;
                        }
                    }
                }
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "getIpInfo fail!" + e.toString());
                }
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public BaiduIdentityManager(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mEnAndroidId = null;
        this.mC3Aid = null;
        this.mProcessedUa = new HashMap<>(2);
        init(context);
    }

    @SuppressLint({"ApplySharedPref"})
    private void addTnTrace(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, str) == null) {
            String string = this.mSettings.getString(KEY_TN_TRACE, "");
            if (!TextUtils.isEmpty(string)) {
                str = string + "_" + str;
            }
            SharedPreferences.Editor edit = this.mSettings.edit();
            edit.putString(KEY_TN_TRACE, str);
            edit.commit();
        }
    }

    private String getApkTn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, context)) == null) {
            String tn = this.mIdentityContextImpl.getTn(context);
            if (DEBUG) {
                Log.d(TAG, "load tn from R.raw.tnconfig, tn = " + tn);
            }
            if (TextUtils.isEmpty(tn)) {
                return "757b";
            }
            return tn;
        }
        return (String) invokeL.objValue;
    }

    public String getVersionCode(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, context)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo.versionCode + "";
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "-1";
            }
        }
        return (String) invokeL.objValue;
    }

    public String processAppSearchUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, str)) == null) {
            String addFromParam = addFromParam(str);
            if (DEBUG) {
                Log.d(TAG, "url: " + addFromParam);
            }
            return addFromParam;
        }
        return (String) invokeL.objValue;
    }

    private String addFromParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            return addParam(str, "from", getTn());
        }
        return (String) invokeL.objValue;
    }

    private String addPackageNameParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) {
            return addParam(str, "pkgname", this.mIdentityContextImpl.getPkgName());
        }
        return (String) invokeL.objValue;
    }

    public static String clearCustomParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            return UrlUtil.deleteParam(str, SEARCHBOX_CUSTOM_PARAMS);
        }
        return (String) invokeL.objValue;
    }

    private String generateUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, context)) == null) {
            return CommonParam.getCUID(context);
        }
        return (String) invokeL.objValue;
    }

    @Deprecated
    public static synchronized BaiduIdentityManager getInstance(Context context) {
        InterceptResult invokeL;
        BaiduIdentityManager baiduIdentityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, context)) == null) {
            synchronized (BaiduIdentityManager.class) {
                baiduIdentityManager = getInstance();
            }
            return baiduIdentityManager;
        }
        return (BaiduIdentityManager) invokeL.objValue;
    }

    private String getVersionName(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, this, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return "0.8";
            }
        }
        return (String) invokeL.objValue;
    }

    private String reverseString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public String addBDVC(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String bDVCInfo = this.mIdentityContextImpl.getBDVCInfo();
            if (TextUtils.isEmpty(bDVCInfo)) {
                return str;
            }
            return addParam(str, "bdvc", bDVCInfo);
        }
        return (String) invokeL.objValue;
    }

    public String addCfromParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return addParam(str, "cfrom", getLastTn());
        }
        return (String) invokeL.objValue;
    }

    public String addLightAppFrameworkParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            return addParam(str, PARAM_BD_FRAMEWORK, "1");
        }
        return (String) invokeL.objValue;
    }

    public String addLocStringIfJoinUserExperience(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (this.mIdentityContextImpl.getJoinUserExperiencePreference(this.mContext)) {
                return addLocString(str, true);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String addTsParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, str)) == null) {
            return addParam(str, "ts", getLightAppTsParam());
        }
        return (String) invokeL.objValue;
    }

    public String addVipLightAppParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, str)) == null) {
            return addParam(str, PARAM_BD_VIP, "1");
        }
        return (String) invokeL.objValue;
    }

    public String addZid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, str)) == null) {
            String zid = this.mIdentityContextImpl.getZid();
            if (TextUtils.isEmpty(zid)) {
                return str;
            }
            return addParam(str, "zid", c20.a(zid));
        }
        return (String) invokeL.objValue;
    }

    public String getApInfo(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048601, this, z)) == null) {
            return getApInfo(z, 6);
        }
        return (String) invokeZ.objValue;
    }

    public String processTypeSuggestionUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, str)) == null) {
            return addParam(str, "v", Integer.toString(3));
        }
        return (String) invokeL.objValue;
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, str)) == null) {
            return processUrl(str, true, true, 0);
        }
        return (String) invokeL.objValue;
    }

    public String processUrlWithoutNetwork(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, str)) == null) {
            return processUrl(str, false, true, 0);
        }
        return (String) invokeL.objValue;
    }

    public String processUrlWithoutSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, str)) == null) {
            return processUrl(str, true, false, 0);
        }
        return (String) invokeL.objValue;
    }

    private String addKey2Cen(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str2.replace("_", "-");
            }
            return str + "_" + str2.replace("_", "-");
        }
        return (String) invokeLL.objValue;
    }

    private String addUAParamNoEncode(String str, String str2) {
        InterceptResult invokeLL;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, str2)) == null) {
            if (TextUtils.isEmpty(str)) {
                str3 = "";
            } else {
                str3 = str + "/";
            }
            return str3 + str2;
        }
        return (String) invokeLL.objValue;
    }

    public String addParams(HashMap<String, String> hashMap, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, hashMap, str)) == null) {
            if (hashMap != null) {
                for (String str2 : hashMap.keySet()) {
                    str = addParam(str, str2, hashMap.get(str2));
                }
            }
            return str;
        }
        return (String) invokeLL.objValue;
    }

    public String processUserAgent(String str, BrowserType browserType) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048638, this, str, browserType)) == null) {
            int i = AnonymousClass3.$SwitchMap$com$baidu$browser$BrowserType[browserType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            str2 = null;
                        } else {
                            str2 = "rabbit/1.0_lite";
                        }
                    } else {
                        str2 = "rabbit/1.0";
                    }
                } else {
                    str2 = "search/1.0";
                }
            } else {
                str2 = "light/1.0";
            }
            return d20.f().c(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    private String addParamByEncode(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65541, this, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return str;
            }
            return UrlUtil.addParam(str, str2, c20.a(str3));
        }
        return (String) invokeLLL.objValue;
    }

    public String addParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, str3)) == null) {
            return UrlUtil.addParam(str, str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    public String addParamWithUrlEncode(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048585, this, str, str2, str3)) == null) {
            return UrlUtil.addParam(str, str2, c20.a(str3));
        }
        return (String) invokeLLL.objValue;
    }

    public String replaceParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048642, this, str, str2, str3)) == null) {
            HashSet hashSet = new HashSet();
            hashSet.add(str2);
            return addParam(UrlUtil.deleteParam(str, hashSet), str2, str3);
        }
        return (String) invokeLLL.objValue;
    }

    private String addUserAgentParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, str, str2)) == null) {
            try {
                str2 = URLEncoder.encode(str2, IMAudioTransRequest.CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return addUAParamNoEncode(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    private String crcSign(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            return CommonUrlParamManager.crcSign(str, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String addDebugParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2)) == null) {
            return addParam(str, "debug", str2);
        }
        return (String) invokeLL.objValue;
    }

    public String addLocString(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048581, this, str, z)) == null) {
            return addLocString(str, z, 6);
        }
        return (String) invokeLZ.objValue;
    }

    public String addSearchSourceParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            return addPuParam(str, CSRC, str2);
        }
        return (String) invokeLL.objValue;
    }

    public String addServiceParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048589, this, str, str2)) == null) {
            return addParam(str, "service", str2);
        }
        return (String) invokeLL.objValue;
    }

    public String appendParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048594, this, str, i)) == null) {
            if (t10.b().h()) {
                return urlAppendParam(str, i);
            }
            return processUrl(str);
        }
        return (String) invokeLI.objValue;
    }

    public String deleteParams(String str, Set<String> set) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, set)) == null) {
            return UrlUtil.deleteParam(str, set);
        }
        return (String) invokeLL.objValue;
    }

    public String getApInfo(boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            return getApInfo(z, i, "UTF-8");
        }
        return (String) invokeCommon.objValue;
    }

    public String processWebSearchUrl(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048640, this, str, z)) == null) {
            return processWebSearchUrl(str, 0, z);
        }
        return (String) invokeLZ.objValue;
    }

    public String processWidgetUrl(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048641, this, str, str2)) == null) {
            return processUrl(addParam(str, "widget", str2));
        }
        return (String) invokeLL.objValue;
    }

    public String urlAppendParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048645, this, str, i)) == null) {
            return processUrl(str, true, true, i);
        }
        return (String) invokeLI.objValue;
    }

    private v10 getDeviceInfoParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65549, this)) == null) {
            if (this.mDeviceInfoParam == null) {
                synchronized (this) {
                    if (this.mDeviceInfoParam == null) {
                        this.mDeviceInfoParam = new v10();
                    }
                }
            }
            return this.mDeviceInfoParam;
        }
        return (v10) invokeV.objValue;
    }

    public static synchronized BaiduIdentityManager getInstance() {
        InterceptResult invokeV;
        BaiduIdentityManager baiduIdentityManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, null)) == null) {
            synchronized (BaiduIdentityManager.class) {
                if (sIdentityManager == null) {
                    sIdentityManager = new BaiduIdentityManager(AppRuntime.getAppContext());
                }
                baiduIdentityManager = sIdentityManager;
            }
            return baiduIdentityManager;
        }
        return (BaiduIdentityManager) invokeV.objValue;
    }

    @Deprecated
    public long getActiveSuccTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return BaiduActiveManager.getInstance().getActiveSuccTime();
        }
        return invokeV.longValue;
    }

    @Deprecated
    public String getActiveTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return BaiduActiveManager.getInstance().getActiveTime();
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"BDThrowableCheck", "HardwareIds"})
    public String getAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String string = ApiReplaceUtil.Overload.getString(this.mContext.getContentResolver(), HttpRequest.ANDROID_ID);
            if (TextUtils.isEmpty(string)) {
                return "0";
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    @Deprecated
    public String getCurrentNetTypeId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return new z10().a();
        }
        return (String) invokeV.objValue;
    }

    public String getDeviceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return getDeviceInfoParam().a();
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getEnUA() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            synchronized (this) {
                str = this.mEnUa;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getEnUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return AppCuidManager.getInstance().getEnCuid();
        }
        return (String) invokeV.objValue;
    }

    public String getLastTn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (this.mLastTn == null) {
                this.mLastTn = getLastTn(this.mContext);
            }
            return this.mLastTn;
        }
        return (String) invokeV.objValue;
    }

    public String getLocationInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            String locationInfo = this.mIdentityContextImpl.getLocationInfo(this.mContext);
            if (TextUtils.isEmpty(locationInfo)) {
                return "0.000000,0.000000,---";
            }
            return locationInfo;
        }
        return (String) invokeV.objValue;
    }

    public String getManufacturer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return getDeviceInfoParam().c();
        }
        return (String) invokeV.objValue;
    }

    public String getModel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return getDeviceInfoParam().d();
        }
        return (String) invokeV.objValue;
    }

    public String getOSVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return getDeviceInfoParam().e();
        }
        return (String) invokeV.objValue;
    }

    public String getOriginUserAgent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return d20.f().g();
        }
        return (String) invokeV.objValue;
    }

    public String getOsBranch() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.mIdentityContextImpl.getOsBranch();
        }
        return (String) invokeV.objValue;
    }

    public String getSwanNativeVersionGroup() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (SwanDataRuntime.getISwanData() != null) {
                return SwanDataRuntime.getISwanData().getSwanNativeVersionGroup();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getTn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.mTn == null) {
                this.mTn = getTn(this.mContext);
            }
            return this.mTn;
        }
        return (String) invokeV.objValue;
    }

    public String getTnTrace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            String string = this.mSettings.getString(KEY_TN_TRACE, "");
            if (TextUtils.isEmpty(string)) {
                return getLastTn();
            }
            return string;
        }
        return (String) invokeV.objValue;
    }

    public synchronized String getUA() {
        InterceptResult invokeV;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            synchronized (this) {
                str = this.mUa;
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return AppCuidManager.getInstance().getCuid();
        }
        return (String) invokeV.objValue;
    }

    public String getVersionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mVersionName;
        }
        return (String) invokeV.objValue;
    }

    public String getZid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mIdentityContextImpl.getZid();
        }
        return (String) invokeV.objValue;
    }

    public synchronized void initUAS() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            synchronized (this) {
                this.mUa = getUA(this.mContext);
                this.mEnUa = new String(Base64Encoder.B64Encode(this.mUa.getBytes()));
            }
        }
    }

    @Deprecated
    public boolean isActiveSucc() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return BaiduActiveManager.getInstance().isActiveSucc();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void setCUIDCookie() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048643, this) == null) {
            new CuidCookieSync().setCUIDCookie();
        }
    }

    @SuppressLint({"ApplySharedPref"})
    private String getLastTn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, this, context)) == null) {
            String string = this.mSettings.getString(KEY_LAST_TN, "");
            String apkTn = getApkTn(context);
            if (!(!TextUtils.equals(string, apkTn)) && !TextUtils.isEmpty(string)) {
                if (DEBUG) {
                    Log.d(TAG, "load tn from local, lastTn = " + string);
                    return string;
                }
                return string;
            }
            SharedPreferences.Editor edit = this.mSettings.edit();
            edit.putString(KEY_LAST_TN, apkTn);
            edit.commit();
            addTnTrace(apkTn);
            if (DEBUG) {
                Log.d(TAG, "load tn from apk, lastTn = " + apkTn);
            }
            return apkTn;
        }
        return (String) invokeL.objValue;
    }

    private String getUA(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, this, context)) == null) {
            int displayWidth = DeviceUtil.ScreenInfo.getDisplayWidth(context);
            int displayHeight = DeviceUtil.ScreenInfo.getDisplayHeight(context);
            int densityDpi = DeviceUtil.ScreenInfo.getDensityDpi(context);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(displayWidth);
            stringBuffer.append("_");
            stringBuffer.append(displayHeight);
            stringBuffer.append("_");
            stringBuffer.append("android");
            stringBuffer.append("_");
            stringBuffer.append(this.mVersionName);
            stringBuffer.append("_");
            stringBuffer.append(densityDpi);
            String stringBuffer2 = stringBuffer.toString();
            if (DEBUG) {
                Log.d(TAG, "ua = " + stringBuffer2);
            }
            return stringBuffer2;
        }
        return (String) invokeL.objValue;
    }

    public String addLocParam(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (!this.mIdentityContextImpl.getPrivacySwitch(this.mContext)) {
                return str;
            }
            String apInfo = getApInfo(false, 6);
            if (!TextUtils.isEmpty(apInfo)) {
                HashSet hashSet = new HashSet();
                hashSet.add(LOCINFO_STRING);
                String deleteParam = UrlUtil.deleteParam(str, hashSet);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("time", System.currentTimeMillis());
                    jSONObject.put("apinfo", apInfo);
                    return addParam(deleteParam, LOCINFO_STRING, c20.a(jSONObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return deleteParam;
                }
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public String addSid(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            ArrayList<b9> experimentInfoList = AbTestManager.getInstance().getExperimentInfoList();
            if (experimentInfoList != null && !experimentInfoList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (b9 b9Var : experimentInfoList) {
                    sb.append(b9Var.c());
                    sb.append("_");
                    sb.append(b9Var.b());
                    sb.append("-");
                }
                return addParam(str, "sid", sb.substring(0, sb.length() - 1));
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    private String getLightAppTsParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65553, this)) == null) {
            try {
                String valueOf = String.valueOf(System.currentTimeMillis());
                return valueOf.substring(valueOf.length() - 7);
            } catch (Exception unused) {
                if (DEBUG) {
                    Log.d(TAG, "format lightapp ts error.");
                }
                return "";
            }
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalFileSystemInfo() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        Closeable closeable;
        DataOutputStream dataOutputStream;
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            String str = null;
            try {
                try {
                    listFiles = Environment.getExternalStorageDirectory().listFiles(new FileFilter(this) { // from class: com.baidu.searchbox.util.BaiduIdentityManager.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaiduIdentityManager this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        @Override // java.io.FileFilter
                        public boolean accept(File file) {
                            InterceptResult invokeL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, file)) == null) {
                                if (file != null && !TextUtils.isEmpty(file.getName())) {
                                    return true;
                                }
                                return false;
                            }
                            return invokeL.booleanValue;
                        }
                    });
                    Arrays.sort(listFiles, new Comparator<File>(this) { // from class: com.baidu.searchbox.util.BaiduIdentityManager.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ BaiduIdentityManager this$0;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i = newInitContext.flag;
                                if ((i & 1) != 0) {
                                    int i2 = i & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.this$0 = this;
                        }

                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // java.util.Comparator
                        public int compare(File file, File file2) {
                            InterceptResult invokeLL;
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, file, file2)) == null) {
                                return (int) (file.lastModified() - file2.lastModified());
                            }
                            return invokeLL.intValue;
                        }
                    });
                    byteArrayOutputStream = new ByteArrayOutputStream(1024);
                } catch (Throwable th) {
                    th = th;
                    Closeables.closeSafely(closeable);
                    Closeables.closeSafely(byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e) {
                e = e;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
                closeable = null;
            }
            try {
                dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    for (File file : listFiles) {
                        dataOutputStream.writeUTF(file.getName());
                    }
                    dataOutputStream.flush();
                    str = Util.toMd5(byteArrayOutputStream.toByteArray(), true);
                } catch (Exception e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.e(TAG, "getLocalFileSystemInfo fail!" + e.toString());
                    }
                    Closeables.closeSafely(dataOutputStream);
                    Closeables.closeSafely(byteArrayOutputStream);
                    if (!TextUtils.isEmpty(str)) {
                    }
                }
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                closeable = null;
                th = th;
                Closeables.closeSafely(closeable);
                Closeables.closeSafely(byteArrayOutputStream);
                throw th;
            }
            Closeables.closeSafely(dataOutputStream);
            Closeables.closeSafely(byteArrayOutputStream);
            if (!TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0045, code lost:
        r1 = r6.getColumnIndex("title");
        r0 = r6.getColumnIndex("_size");
        r5 = new java.io.ByteArrayOutputStream(1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
        r7 = new java.io.DataOutputStream(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        r8 = r6.getString(r1);
        r9 = r6.getString(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
        if (com.baidu.searchbox.util.BaiduIdentityManager.DEBUG == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0065, code lost:
        com.baidu.android.common.logging.Log.d(com.baidu.searchbox.util.BaiduIdentityManager.TAG, "title: " + r8 + " size: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0082, code lost:
        r7.writeUTF(r8 + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0098, code lost:
        if (r6.moveToNext() != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x009a, code lost:
        r7.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00a5, code lost:
        r0 = com.baidu.searchbox.util.Util.toMd5(r5.toByteArray(), true);
        r17 = r6;
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00aa, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ac, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ae, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00af, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b1, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b2, code lost:
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
        r17 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e9, code lost:
        if (com.baidu.searchbox.util.BaiduIdentityManager.DEBUG != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00eb, code lost:
        com.baidu.android.common.logging.Log.e(com.baidu.searchbox.util.BaiduIdentityManager.TAG, "getLocalPhotoInfo fail!" + r0.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0103, code lost:
        com.baidu.android.util.io.Closeables.closeSafely(r17);
        com.baidu.android.util.io.Closeables.closeSafely(r7);
        com.baidu.android.util.io.Closeables.closeSafely(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0115, code lost:
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0112 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getLocalPhotoInfo() {
        InterceptResult invokeV;
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        Cursor cursor;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65555, this)) == null) {
            Cursor cursor2 = null;
            String str2 = null;
            DataOutputStream dataOutputStream2 = null;
            try {
                ContentResolver contentResolver = this.mContext.getContentResolver();
                Uri[] uriArr = {MediaStore.Images.Media.EXTERNAL_CONTENT_URI, MediaStore.Images.Media.INTERNAL_CONTENT_URI};
                String[] strArr = {"title", "_size"};
                cursor = null;
                int i = 0;
                while (true) {
                    if (i < 2) {
                        try {
                            int i2 = i;
                            Cursor query = contentResolver.query(uriArr[i], strArr, null, null, "date_modified DESC LIMIT 10");
                            if (query != null) {
                                try {
                                    if (query.moveToFirst()) {
                                        break;
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    byteArrayOutputStream = null;
                                    dataOutputStream = null;
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                    dataOutputStream = null;
                                }
                            }
                            Closeables.closeSafely(query);
                            i = i2 + 1;
                            cursor = query;
                        } catch (Exception e2) {
                            e = e2;
                            byteArrayOutputStream = null;
                            dataOutputStream = null;
                        } catch (Throwable th2) {
                            th = th2;
                            byteArrayOutputStream = null;
                            dataOutputStream = null;
                            cursor2 = cursor;
                            Closeables.closeSafely(cursor2);
                            Closeables.closeSafely(dataOutputStream);
                            Closeables.closeSafely(byteArrayOutputStream);
                            throw th;
                        }
                    } else {
                        str = null;
                        byteArrayOutputStream = null;
                        break;
                    }
                }
                Closeables.closeSafely(cursor);
                Closeables.closeSafely(dataOutputStream2);
                Closeables.closeSafely(byteArrayOutputStream);
                str2 = str;
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                dataOutputStream = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"ApplySharedPref"})
    private String getTn(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, this, context)) == null) {
            String string = this.mSettings.getString("tnconfig", "");
            boolean isEmpty = TextUtils.isEmpty(string);
            boolean isNeedReloadTN = TNRuntime.INSTANCE.getTNContext().isNeedReloadTN();
            if (!isEmpty && !isNeedReloadTN) {
                if (DEBUG) {
                    Log.d(TAG, " load tn from local, tn = " + string);
                }
            } else {
                string = loadTn("tnconfig", string, isEmpty, isNeedReloadTN);
            }
            if (TextUtils.isEmpty(string)) {
                return "757b";
            }
            return string;
        }
        return (String) invokeL.objValue;
    }

    @SuppressLint({"BDThrowableCheck"})
    private void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65559, this, context) == null) {
            this.mContext = context;
            this.mSettings = context.getSharedPreferences("identity", 0);
            this.mVersionName = getVersionName(context);
            initUAS();
            this.mCT = new CT();
            this.customOSParam = new u10();
            IBaiduIdentityContext baiduIdentityContext = BaiduIdentityRuntime.getBaiduIdentityContext();
            this.mIdentityContextImpl = baiduIdentityContext;
            if (DEBUG && baiduIdentityContext == null) {
                throw new RuntimeException("BaiduIdentityContext obtain Failed !!");
            }
        }
    }

    public String processUrlInJson(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, str)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String string = jSONObject.getString("mode");
                    String string2 = jSONObject.getString("url");
                    if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                        if (string.equals("search")) {
                            return processWebSearchUrl(string2, true);
                        }
                        if (!string.equals(FileUtils.SEARCHBOX_FOLDER)) {
                            return null;
                        }
                        return processUrl(string2);
                    }
                    return null;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private String loadTn(String str, String str2, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65560, this, new Object[]{str, str2, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            String oEMChannel = this.mIdentityContextImpl.getOEMChannel(AppRuntime.getAppContext());
            if (!TextUtils.isEmpty(oEMChannel)) {
                if (DEBUG && z2) {
                    Log.d(TAG, "load tn from new clone device, tn = " + oEMChannel);
                }
                str2 = oEMChannel;
            } else if (z) {
                str2 = getLastTn();
            }
            SharedPreferences.Editor edit = this.mSettings.edit();
            edit.putString(str, str2);
            edit.commit();
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    private String processUrl(String str, boolean z, boolean z2, int i) {
        InterceptResult invokeCommon;
        String b;
        String c;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String addParamByEncode;
        String f;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65561, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)})) == null) {
            String a = c20.a(getEnUA());
            String str8 = null;
            String addKey2Cen = addKey2Cen(null, "ua");
            v10 deviceInfoParam = getDeviceInfoParam();
            String addServiceParam = addServiceParam(str, PARAM_SERVICE);
            if (this.mIdentityContextImpl.isAgreePrivacy()) {
                String a2 = c20.a(getEnUid());
                addKey2Cen = addKey2Cen(addKey2Cen, "uid");
                addServiceParam = addParam(addServiceParam, "uid", a2);
            }
            String addFromParam = addFromParam(addServiceParam);
            String appName = AppIdentityManager.getInstance().getAppName();
            z10 z10Var = new z10();
            boolean z3 = true;
            z10Var.g(true);
            if (i == 1) {
                boolean z4 = false;
                if (deviceInfoParam.j()) {
                    String b2 = deviceInfoParam.b();
                    addKey2Cen = addKey2Cen(addKey2Cen, "ut");
                    b = b2;
                    f = null;
                } else {
                    b = null;
                    f = deviceInfoParam.f();
                    z4 = true;
                }
                if (z10Var.e()) {
                    str4 = null;
                    boolean z5 = z4;
                    c = z10Var.c();
                    z3 = z5;
                } else {
                    str4 = String.valueOf(z10Var.d());
                    c = null;
                }
                if (z3) {
                    if (TextUtils.isEmpty(b)) {
                        str2 = crcSign(deviceInfoParam.a(), z10Var.b());
                    } else {
                        str2 = crcSign(deviceInfoParam.b(), z10Var.c());
                    }
                    str7 = String.valueOf(i);
                } else {
                    str2 = null;
                    str7 = null;
                }
                if (t10.b().e()) {
                    if (this.customOSParam.b()) {
                        str7 = String.valueOf(i);
                    } else {
                        str8 = this.customOSParam.a();
                    }
                }
                String str9 = str7;
                str3 = str8;
                str5 = addKey2Cen;
                str6 = str9;
                str8 = f;
            } else {
                b = deviceInfoParam.b();
                c = z10Var.c();
                String addKey2Cen2 = addKey2Cen(addKey2Cen, "ut");
                if (t10.b().e()) {
                    str4 = null;
                    str5 = addKey2Cen2;
                    str3 = this.customOSParam.a();
                    str6 = null;
                    str2 = null;
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    str5 = addKey2Cen2;
                    str6 = null;
                }
            }
            String addParam = addParam(addCfromParam(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addPackageNameParam(addParamByEncode(addParam(addParam(addParamByEncode(addParam(addFromParam, "ua", a), "ut", b), PARAM_OSNAME, VALUE_OSNAME), PARAM_OSBRANCH, getOsBranch()), PARAM_BRNACH_NAME, appName)), "p_sv", str8), "mps", str2), "mpv", str6), "p_nw", str4), "network", c)), PARAM_CTV, this.mCT.getVersion());
            if (!TextUtils.isEmpty(str5) && !this.mCT.isDefaultCtv()) {
                addParam = addParam(addParam, PARAM_CEN, str5);
            }
            String addParam2 = addParam(addParam, "typeid", this.mIdentityContextImpl.getSearchBoxTypeId(this.mContext));
            if (this.mIdentityContextImpl.isAgreePrivacy()) {
                String passUid = this.mIdentityContextImpl.getPassUid(this.mContext);
                if (!TextUtils.isEmpty(passUid)) {
                    addParam2 = addParam(addParam2, "puid", c20.a(new String(Base64Encoder.B64Encode(passUid.getBytes()))));
                }
            }
            if (z2) {
                addParam2 = addSid(addParam2);
            }
            String addBDVC = addBDVC(addParam2);
            if (this.mIdentityContextImpl.isAgreePrivacy()) {
                if (TextUtils.isEmpty(this.mC3Aid)) {
                    this.mC3Aid = getC3Aid();
                }
                if (!TextUtils.isEmpty(this.mC3Aid)) {
                    addBDVC = addParam(addBDVC, "c3_aid", c20.a(this.mC3Aid));
                }
                addParamByEncode = addZid(addBDVC);
            } else {
                addParamByEncode = addParamByEncode(addBDVC, "iid", this.mIdentityContextImpl.getIid());
            }
            String addParam3 = addParam(addParamByEncode, "matrixstyle", this.mIdentityContextImpl.getMatrixstyle());
            String appMode = this.mIdentityContextImpl.getAppMode();
            if (!TextUtils.isEmpty(appMode)) {
                addParam3 = addParam(addParam3, "cmode", appMode);
            }
            return this.mIdentityContextImpl.processUrlExternal(addParamByEncode(addParam3, "bdos", str3), z);
        }
        return (String) invokeCommon.objValue;
    }

    private void saveApinfoToFileForDebug(String str) {
        File file;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65563, this, str) != null) || !DEBUG) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    file = new File(this.mContext.getFilesDir(), "apinfo.txt");
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
            } catch (IOException e3) {
                e = e3;
            }
            if (file.length() > Config.FULL_TRACE_LOG_LIMIT) {
                file.delete();
                return;
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, true);
            try {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
                fileOutputStream2.write((simpleDateFormat.format(date) + ", apinfo: " + str).getBytes());
                fileOutputStream2.flush();
                fileOutputStream2.close();
            } catch (FileNotFoundException e4) {
                e = e4;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e5) {
                e = e5;
                fileOutputStream = fileOutputStream2;
                e.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String addLocString(String str, boolean z, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, Boolean.valueOf(z), Integer.valueOf(i)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (!this.mIdentityContextImpl.getPrivacySwitch(this.mContext)) {
                return str;
            }
            String apInfo = getApInfo(z, i);
            if (!TextUtils.isEmpty(apInfo)) {
                return addParam(str, "apinfo", apInfo);
            }
            return str;
        }
        return (String) invokeCommon.objValue;
    }

    public String addPuParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048587, this, str, str2, str3)) == null) {
            String urlField = UrlUtil.getUrlField(str, PARAM_PU);
            if (TextUtils.isEmpty(urlField)) {
                return addParam(str, PARAM_PU, Uri.encode(str2 + "@" + str3));
            }
            String str4 = str2 + "@";
            if (urlField.indexOf(Uri.encode(str4)) < 0 && urlField.indexOf(str4) < 0) {
                String str5 = "," + str4 + str3;
                return str.replace("pu=" + urlField, "pu=" + urlField + Uri.encode(str5));
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public String appendParam(String str, int i, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (t10.b().h()) {
                return processUrl(str, z, z2, i);
            }
            return processUrl(str, z, z2, 0);
        }
        return (String) invokeCommon.objValue;
    }

    public String getApInfo(boolean z, int i, String str) {
        InterceptResult invokeCommon;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), str})) == null) {
            if (!this.mIdentityContextImpl.isDataFlowPopDialog(this.mContext)) {
                if (i < 6) {
                    i = 6;
                } else if (i > 15) {
                    i = 15;
                }
                str2 = this.mIdentityContextImpl.getLocString(this.mContext, i);
            } else {
                str2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                if (z) {
                    return "0";
                }
            } else if (!TextUtils.isEmpty(str)) {
                try {
                    str2 = URLEncoder.encode(str2, str);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (DEBUG) {
                saveApinfoToFileForDebug(str2);
            }
            return str2;
        }
        return (String) invokeCommon.objValue;
    }

    public String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.mContext != null && TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = BlcSharedPrefsWrapper.getInstance().getString("cthreekey", "");
                if (TextUtils.isEmpty(this.mC3Aid)) {
                    this.mC3Aid = u20.f(this.mContext.getApplicationContext()).c();
                    if (!TextUtils.isEmpty(this.mC3Aid)) {
                        BlcSharedPrefsWrapper.getInstance().putString("cthreekey", this.mC3Aid);
                    }
                }
            }
            return this.mC3Aid;
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"HardwareIds"})
    public String getEnAndroidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.mEnAndroidId == null) {
                synchronized (this) {
                    if (this.mEnAndroidId == null) {
                        String string = ApiReplaceUtil.Overload.getString(this.mContext.getContentResolver(), HttpRequest.ANDROID_ID);
                        this.mAndroidId = string;
                        if (TextUtils.isEmpty(string)) {
                            this.mAndroidId = "0";
                        }
                        this.mEnAndroidId = new String(Base64Encoder.B64Encode(this.mAndroidId.getBytes()));
                    }
                }
            }
            return this.mEnAndroidId;
        }
        return (String) invokeV.objValue;
    }

    public String getSid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            ArrayList<b9> experimentInfoList = AbTestManager.getInstance().getExperimentInfoList();
            if (experimentInfoList != null && !experimentInfoList.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (b9 b9Var : experimentInfoList) {
                    sb.append(b9Var.c());
                    sb.append("_");
                    sb.append(b9Var.b());
                    sb.append("-");
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @SuppressLint({"WifiManagerPotentialLeak", "HardwareIds"})
    @Deprecated
    public String getWifiInfo() {
        String str;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            try {
                str = ApiReplaceUtil.getMacAddress(((WifiManager) this.mContext.getSystemService("wifi")).getConnectionInfo());
            } catch (Exception e) {
                if (DEBUG) {
                    Log.e(TAG, "getWifiInfo fail!" + e.toString());
                }
                str = null;
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public String processUrlWithParams(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048635, this, str, map)) == null) {
            String processUrl = processUrl(str, true, true, 0);
            if (map != null) {
                for (String str2 : map.keySet()) {
                    if (!TextUtils.isEmpty(map.get(str2))) {
                        processUrl = addParam(processUrl, str2, map.get(str2));
                    }
                }
            }
            return processUrl;
        }
        return (String) invokeLL.objValue;
    }

    public String processWebSearchUrl(String str, int i, boolean z) {
        InterceptResult invokeCommon;
        z10 z10Var;
        String a;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String f;
        boolean z2;
        String str7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048639, this, new Object[]{str, Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            String a2 = c20.a(getEnUid());
            String str8 = null;
            String addKey2Cen = addKey2Cen(null, "cuid");
            String a3 = c20.a(getEnUA());
            String addKey2Cen2 = addKey2Cen(addKey2Cen, PARAM_CUA);
            String appName = AppIdentityManager.getInstance().getAppName();
            boolean z3 = true;
            if (z) {
                z10Var = new z10();
                z10Var.g(true);
            } else {
                z10Var = null;
            }
            v10 deviceInfoParam = getDeviceInfoParam();
            if (i == 1) {
                if (deviceInfoParam.j()) {
                    a = c20.a(deviceInfoParam.b());
                    addKey2Cen2 = addKey2Cen(addKey2Cen2, PARAM_CUT);
                    f = null;
                    z2 = false;
                } else {
                    f = deviceInfoParam.f();
                    z2 = true;
                    a = null;
                }
                if (z10Var != null) {
                    if (z10Var.e()) {
                        str7 = z10Var.c();
                        z3 = z2;
                        str4 = null;
                    } else {
                        str4 = String.valueOf(z10Var.d());
                        str7 = null;
                    }
                } else {
                    str7 = null;
                    z3 = z2;
                    str4 = null;
                }
                if (z3) {
                    str8 = String.valueOf(i);
                }
                str2 = str;
                str3 = str7;
                str5 = addKey2Cen2;
                str6 = str8;
                str8 = f;
            } else {
                a = c20.a(deviceInfoParam.b());
                String addKey2Cen3 = addKey2Cen(addKey2Cen2, PARAM_CUT);
                if (z10Var != null) {
                    str3 = z10Var.c();
                    str2 = str;
                    str4 = null;
                } else {
                    str2 = str;
                    str3 = null;
                    str4 = null;
                }
                str5 = addKey2Cen3;
                str6 = str4;
            }
            String addPuParam = addPuParam(addPuParam(str2, "cuid", a2), PARAM_CUA, a3);
            if (a != null) {
                addPuParam = addPuParam(addPuParam, PARAM_CUT, a);
            }
            String addPackageNameParam = addPackageNameParam(addFromParam(addPuParam(addPuParam(addPuParam(addPuParam, PARAM_OSNAME, VALUE_OSNAME), PARAM_CTV, this.mCT.getVersion()), "cfrom", getLastTn())));
            if (!this.mCT.isDefaultCtv()) {
                addPackageNameParam = addPuParam(addPackageNameParam, PARAM_CEN, str5);
            }
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = getC3Aid();
            }
            if (!TextUtils.isEmpty(this.mC3Aid)) {
                addPackageNameParam = addPuParam(addPackageNameParam, "c3_aid", c20.a(this.mC3Aid));
            }
            String processUrlExternal = this.mIdentityContextImpl.processUrlExternal(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addParamByEncode(addPackageNameParam, "p_sv", str8), "mpv", str6), "p_nw", str4), "network", str3), PARAM_BRNACH_NAME, appName), z);
            if (DEBUG) {
                Log.d(TAG, "url: " + processUrlExternal);
            }
            return processUrlExternal;
        }
        return (String) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return "BaiduIdentityManager [mUid=" + AppCuidManager.getInstance().getCuid() + ", mEnUid=" + AppCuidManager.getInstance().getEnCuid() + ", mUa=" + this.mUa + ", mEnUa=" + this.mEnUa + ", mTn=" + getTn() + ", mLastTn=" + getLastTn() + ", mModel=" + getDeviceInfoParam().d() + ", mManufacturer=" + getDeviceInfoParam().c() + ", mOSVersion=" + getDeviceInfoParam().e() + ", mDeviceInfo=" + getDeviceInfoParam().a() + ", mEnDeviceInfo=" + getDeviceInfoParam().b() + ", mSettings=" + this.mSettings + ", mVersionName=" + this.mVersionName + ", mCtv=" + this.mCT.getVersion() + ", mProcessedUa=" + this.mProcessedUa + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }
}
