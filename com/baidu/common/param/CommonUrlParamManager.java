package com.baidu.common.param;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.common.config.AppIdentityManager;
import com.baidu.tieba.a20;
import com.baidu.tieba.b20;
import com.baidu.tieba.o10;
import com.baidu.tieba.s10;
import com.baidu.tieba.t10;
import com.baidu.tieba.u10;
import com.baidu.tieba.v10;
import com.baidu.tieba.w10;
import com.baidu.tieba.y10;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.util.zip.CRC32;
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
    public static final String PARAM_MAPPING_SIGN = "mps";
    public static final String PARAM_MAPPING_VERSION = "mpv";
    public static final String PARAM_MATRIXSTYLE = "matrixstyle";
    public static final String PARAM_NETWORK = "network";
    public static final String PARAM_NETWORK_MODE = "p_nw";
    public static final String PARAM_SCHEME_HEADER = "scheme";
    public static final String PARAM_SDK_VERSION = "p_sv";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static final int PRIVACY_VERSION_V1 = 1;
    public static CommonUrlParamManager sCommonUrlParamManager;
    public transient /* synthetic */ FieldHolder $fh;
    public t10 customOSParam;
    public volatile String mC3Aid;
    public u10 mDeviceInfoParam;
    public String mEnuid;
    public a20 mUaParam;

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

    private String getC3Aid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = s10.a().getC3Aid();
            }
            return this.mC3Aid;
        }
        return (String) invokeV.objValue;
    }

    public static CommonUrlParamManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
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
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mDeviceInfoParam = new u10();
            this.mUaParam = new a20();
            this.customOSParam = new t10();
        }
    }

    private String addParam(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) {
            if (!TextUtils.isEmpty(str3)) {
                return UrlUtil.addParam(str, str2, b20.a(str3));
            }
            return str;
        }
        return (String) invokeLLL.objValue;
    }

    public static String crcSign(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            CRC32 crc32 = new CRC32();
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(str)) {
                sb.append("ut");
                sb.append("=");
                sb.append(str);
                if (!TextUtils.isEmpty(str2)) {
                    sb.append("&");
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                sb.append("network");
                sb.append("=");
                sb.append(str2);
            }
            crc32.update(sb.toString().getBytes());
            return String.valueOf(crc32.getValue());
        }
        return (String) invokeLL.objValue;
    }

    private String getEnuid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            if (TextUtils.isEmpty(this.mEnuid)) {
                String deviceId = s10.a().getDeviceId();
                if (!TextUtils.isEmpty(deviceId)) {
                    this.mEnuid = new String(Base64Encoder.B64Encode(deviceId.getBytes()));
                }
            }
            return this.mEnuid;
        }
        return (String) invokeV.objValue;
    }

    private String processUrl(String str, String str2, String str3, String str4, String str5, int i) {
        InterceptResult invokeCommon;
        String a;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String f;
        String b;
        boolean z;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, this, new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i)})) == null) {
            v10 a2 = s10.a();
            String a3 = this.mUaParam.a();
            String appName = AppIdentityManager.getInstance().getAppName();
            String sid = a2.getSid();
            String bDVCInfo = a2.getBDVCInfo();
            y10 y10Var = new y10();
            y10Var.g(true);
            String str16 = null;
            if (i == 1) {
                boolean z2 = false;
                if (this.mDeviceInfoParam.j()) {
                    a = this.mDeviceInfoParam.a();
                    f = null;
                } else {
                    a = null;
                    f = this.mDeviceInfoParam.f();
                    z2 = true;
                }
                if (y10Var.e()) {
                    b = y10Var.c();
                    str8 = null;
                    z = z2;
                    str11 = b;
                } else {
                    String valueOf = String.valueOf(y10Var.d());
                    b = y10Var.b();
                    str8 = valueOf;
                    z = true;
                    str11 = null;
                }
                if (z) {
                    str12 = crcSign(this.mDeviceInfoParam.a(), b);
                    str13 = String.valueOf(i);
                } else {
                    str12 = null;
                    str13 = null;
                }
                if (s10.b().e()) {
                    if (this.customOSParam.b()) {
                        str14 = null;
                        str15 = String.valueOf(i);
                        String str17 = str14;
                        str7 = str12;
                        str6 = str15;
                        str16 = f;
                        str9 = str11;
                        str10 = str17;
                    } else {
                        str16 = this.customOSParam.a();
                    }
                }
                str14 = str16;
                str15 = str13;
                String str172 = str14;
                str7 = str12;
                str6 = str15;
                str16 = f;
                str9 = str11;
                str10 = str172;
            } else {
                a = this.mDeviceInfoParam.a();
                String c = y10Var.c();
                if (s10.b().e()) {
                    str7 = null;
                    str8 = null;
                    str9 = c;
                    str10 = this.customOSParam.a();
                    str6 = null;
                } else {
                    str6 = null;
                    str7 = null;
                    str8 = null;
                    str9 = c;
                    str10 = null;
                }
            }
            String from = a2.getFrom();
            String cfrom = a2.getCfrom();
            String schemeHeader = a2.getSchemeHeader();
            String c2 = s10.b().c();
            String str18 = str10;
            String a4 = s10.b().a();
            if (TextUtils.isEmpty(from)) {
                from = o10.b().a();
            }
            if (TextUtils.isEmpty(cfrom)) {
                cfrom = o10.b().c();
            }
            String addParam = addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(addParam(str5, "appname", appName), "sid", sid), "ut", a), "ua", a3), "bdvc", bDVCInfo), "zid", str2), "uid", str), "iid", str4), "cfrom", cfrom), "from", from), "scheme", schemeHeader), "network", str9), "p_sv", str16), "mps", str7), "mpv", str6), "p_nw", str8), "c3_aid", str3), "matrixstyle", c2);
            if (!TextUtils.isEmpty(a4)) {
                addParam = addParam(addParam, "cmode", a4);
            }
            String addParam2 = addParam(addParam, "bdos", str18);
            a2.processUrlExternal(addParam2, true);
            return addParam2;
        }
        return (String) invokeCommon.objValue;
    }

    private String urlAppendParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, str, i)) == null) {
            v10 a = s10.a();
            String enuid = getEnuid();
            String c3Aid = getC3Aid();
            String zid = a.getZid();
            w10 b = s10.b();
            String b2 = b.b();
            if (b.d()) {
                return processUrl(enuid, zid, c3Aid, null, str, i);
            }
            return processUrl(null, null, null, b2, str, i);
        }
        return (String) invokeLI.objValue;
    }

    public String appendParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, str, i)) == null) {
            if (s10.b().h()) {
                return urlAppendParam(str, i);
            }
            return processUrl(str);
        }
        return (String) invokeLI.objValue;
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            return urlAppendParam(str, 0);
        }
        return (String) invokeL.objValue;
    }

    public String spliceNoPrivacyParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            return processUrl(null, null, null, s10.b().b(), str, 0);
        }
        return (String) invokeL.objValue;
    }
}
