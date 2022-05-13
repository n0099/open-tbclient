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
import com.repackage.e20;
import com.repackage.i20;
import com.repackage.j20;
import com.repackage.k20;
import com.repackage.l20;
import com.repackage.m20;
import com.repackage.o20;
import com.repackage.p20;
import com.repackage.q20;
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
    public j20 customOSParam;
    public volatile String mC3Aid;
    public k20 mDeviceInfoParam;
    public String mEnuid;
    public o20 mNetworkParam;
    public p20 mUaParam;

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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) ? !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, q20.a(str3)) : str : (String) invokeLLL.objValue;
    }

    private String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = i20.a().getC3Aid();
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
                String deviceId = i20.a().getDeviceId();
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
            this.mNetworkParam = new o20();
            this.mDeviceInfoParam = new k20();
            this.mUaParam = new p20();
            this.customOSParam = new j20();
        }
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            l20 a = i20.a();
            String enuid = getEnuid();
            String c3Aid = getC3Aid();
            String zid = a.getZid();
            m20 b = i20.b();
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
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? processUrl(null, null, null, i20.b().b(), str) : (String) invokeL.objValue;
    }

    private String processUrl(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65542, this, str, str2, str3, str4, str5)) == null) {
            l20 a = i20.a();
            String a2 = this.mUaParam.a();
            String appName = AppIdentityManager.getInstance().getAppName();
            String sid = a.getSid();
            String bDVCInfo = a.getBDVCInfo();
            String a3 = this.mDeviceInfoParam.a();
            String from = a.getFrom();
            String cfrom = a.getCfrom();
            String schemeHeader = a.getSchemeHeader();
            String c = i20.b().c();
            String a4 = i20.b().a();
            if (TextUtils.isEmpty(from)) {
                from = e20.b().a();
            }
            if (TextUtils.isEmpty(cfrom)) {
                cfrom = e20.b().c();
            }
            String addParam = addParam(addParam(this.mNetworkParam.a(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str5, "appname", appName), "sid", sid), "ut", a3), "ua", a2), "bdvc", bDVCInfo), "zid", str2), "uid", str), "iid", str4), "cfrom", cfrom), "from", from), "scheme", schemeHeader), true), "c3_aid", str3), PARAM_MATRIXSTYLE, c);
            if (!TextUtils.isEmpty(a4)) {
                addParam = addParam(addParam, PARAM_CMODE, a4);
            }
            if (i20.b().e()) {
                addParam = addParam(addParam, PARAM_BDOS, this.customOSParam.a());
            }
            a.a(addParam, true);
            return addParam;
        }
        return (String) invokeLLLLL.objValue;
    }
}
