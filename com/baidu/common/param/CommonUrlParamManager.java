package com.baidu.common.param;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import d.a.m.c.a;
import d.a.m.c.b;
import d.a.m.c.c;
import d.a.m.c.d;
import d.a.m.c.f;
import d.a.m.c.h;
import d.a.m.c.i;
/* loaded from: classes3.dex */
public final class CommonUrlParamManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
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
    public volatile String mC3Aid;
    public b mDeviceInfoParam;
    public String mEnuid;
    public f mNetworkParam;
    public h mUaParam;

    public CommonUrlParamManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) ? !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, i.a(str3)) : str : (String) invokeLLL.objValue;
    }

    private String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = a.a().getC3Aid();
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
                String deviceId = a.a().getDeviceId();
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65540, null)) == null) {
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
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.mNetworkParam = new f();
            this.mDeviceInfoParam = new b();
            this.mUaParam = new h();
        }
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            c a2 = a.a();
            String enuid = getEnuid();
            String c3Aid = getC3Aid();
            String zid = a2.getZid();
            d b2 = a.b();
            String a3 = b2.a();
            if (b2.c()) {
                return processUrl(enuid, zid, c3Aid, null, str);
            }
            return processUrl(null, null, null, a3, str);
        }
        return (String) invokeL.objValue;
    }

    public String spliceNoPrivacyParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) ? processUrl(null, null, null, a.b().a(), str) : (String) invokeL.objValue;
    }

    private String processUrl(String str, String str2, String str3, String str4, String str5) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(AdIconUtil.BAIDU_LOGO_ID, this, str, str2, str3, str4, str5)) == null) {
            c a2 = a.a();
            String a3 = this.mUaParam.a();
            String a4 = d.a.m.b.a.b().a();
            String sid = a2.getSid();
            String bDVCInfo = a2.getBDVCInfo();
            String a5 = this.mDeviceInfoParam.a();
            String from = a2.getFrom();
            String cfrom = a2.getCfrom();
            String schemeHeader = a2.getSchemeHeader();
            String b2 = a.b().b();
            if (TextUtils.isEmpty(from)) {
                from = d.a.m.a.a.b().a();
            }
            if (TextUtils.isEmpty(cfrom)) {
                cfrom = d.a.m.a.a.b().c();
            }
            String addParam = addParam(addParam(this.mNetworkParam.a(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str5, "appname", a4), "sid", sid), "ut", a5), "ua", a3), "bdvc", bDVCInfo), "zid", str2), "uid", str), PARAM_IID, str4), "cfrom", cfrom), "from", from), "scheme", schemeHeader), true), "c3_aid", str3), PARAM_MATRIXSTYLE, b2);
            a2.a(addParam, true);
            return addParam;
        }
        return (String) invokeLLLLL.objValue;
    }
}
