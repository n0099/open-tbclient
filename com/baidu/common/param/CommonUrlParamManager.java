package com.baidu.common.param;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import com.repackage.a10;
import com.repackage.b10;
import com.repackage.c10;
import com.repackage.d10;
import com.repackage.f10;
import com.repackage.g10;
import com.repackage.h10;
import com.repackage.v00;
import com.repackage.z00;
/* loaded from: classes.dex */
public final class CommonUrlParamManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDOS = "bdos";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
    public static final String PARAM_CMODE = "cmode";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_IID = "iid";
    public static final String PARAM_MATRIXSTYLE = "matrixstyle";
    public static final String PARAM_SCHEME_HEADER = "scheme";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static CommonUrlParamManager sCommonUrlParamManager;
    public transient /* synthetic */ FieldHolder $fh;
    public a10 customOSParam;
    public volatile String mC3Aid;
    public b10 mDeviceInfoParam;
    public String mEnuid;
    public f10 mNetworkParam;
    public g10 mUaParam;

    public CommonUrlParamManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mC3Aid = null;
        init();
    }

    private String addParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) ? !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, h10.a(str3)) : str : (String) invokeLLL.objValue;
    }

    private String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = z00.a().getC3Aid();
            }
            return this.mC3Aid;
        }
        return (String) invokeV.objValue;
    }

    private String getEnuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (TextUtils.isEmpty(this.mEnuid)) {
                String deviceId = z00.a().getDeviceId();
                if (!TextUtils.isEmpty(deviceId)) {
                    this.mEnuid = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
                }
            }
            return this.mEnuid;
        }
        return (String) invokeV.objValue;
    }

    public static CommonUrlParamManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (sCommonUrlParamManager == null) {
                synchronized (CommonUrlParamManager.class) {
                    if (sCommonUrlParamManager == null) {
                        sCommonUrlParamManager = new CommonUrlParamManager();
                    }
                }
            }
            return sCommonUrlParamManager;
        }
        return (CommonUrlParamManager) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mNetworkParam = new f10();
            this.mDeviceInfoParam = new b10();
            this.mUaParam = new g10();
            this.customOSParam = new a10();
        }
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c10 a = z00.a();
            String enuid = getEnuid();
            String c3Aid = getC3Aid();
            String zid = a.getZid();
            d10 b = z00.b();
            String b2 = b.b();
            if (b.d()) {
                return processUrl(enuid, zid, c3Aid, null, str);
            }
            return processUrl(null, null, null, b2, str);
        }
        return (String) invokeL.objValue;
    }

    public String spliceNoPrivacyParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? processUrl(null, null, null, z00.b().b(), str) : (String) invokeL.objValue;
    }

    private String processUrl(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, this, str, str2, str3, str4, str5)) == null) {
            c10 a = z00.a();
            String a2 = this.mUaParam.a();
            String appName = AppIdentityManager.getInstance().getAppName();
            String sid = a.getSid();
            String bDVCInfo = a.getBDVCInfo();
            String a3 = this.mDeviceInfoParam.a();
            String from = a.getFrom();
            String cfrom = a.getCfrom();
            String schemeHeader = a.getSchemeHeader();
            String c = z00.b().c();
            String a4 = z00.b().a();
            if (TextUtils.isEmpty(from)) {
                from = v00.b().a();
            }
            if (TextUtils.isEmpty(cfrom)) {
                cfrom = v00.b().c();
            }
            String addParam = addParam(addParam(this.mNetworkParam.a(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str5, "appname", appName), "sid", sid), "ut", a3), "ua", a2), "bdvc", bDVCInfo), "zid", str2), "uid", str), "iid", str4), "cfrom", cfrom), "from", from), "scheme", schemeHeader), true), "c3_aid", str3), PARAM_MATRIXSTYLE, c);
            if (!TextUtils.isEmpty(a4)) {
                addParam = addParam(addParam, PARAM_CMODE, a4);
            }
            if (z00.b().e()) {
                addParam = addParam(addParam, PARAM_BDOS, this.customOSParam.a());
            }
            a.a(addParam, true);
            return addParam;
        }
        return (String) invokeLLLLL.objValue;
    }
}
