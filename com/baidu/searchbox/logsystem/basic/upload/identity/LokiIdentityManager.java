package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.logsystem.basic.upload.LokiRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.util.Base64Encoder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
/* loaded from: classes3.dex */
public final class LokiIdentityManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_SCHEME_HEADER = "scheme";
    public static final String PARAM_SID = "sid";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_UID = "uid";
    public static final String PARAM_UT = "ut";
    public static final String PARAM_ZID = "zid";
    public static volatile LokiIdentityManager sLokiIdentityManager;
    public transient /* synthetic */ FieldHolder $fh;
    public volatile String mC3Aid;
    public Context mContext;
    public DeviceInfoParam mDeviceInfoParam;
    public String mEnUid;
    public NetworkParam mNetworkParam;
    public UaParam mUaParam;
    public String mUid;

    public LokiIdentityManager() {
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
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, str2, str3)) == null) ? !TextUtils.isEmpty(str3) ? UrlUtil.addParam(str, str2, getEncodeValue(str3)) : str : (String) invokeLLL.objValue;
    }

    public static String getEncodeValue(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return URLEncoder.encode(str, "utf-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }

    public static LokiIdentityManager getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sLokiIdentityManager == null) {
                synchronized (LokiIdentityManager.class) {
                    if (sLokiIdentityManager == null) {
                        sLokiIdentityManager = new LokiIdentityManager();
                    }
                }
            }
            return sLokiIdentityManager;
        }
        return (LokiIdentityManager) invokeV.objValue;
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65540, this) == null) {
            this.mContext = AppRuntime.getAppContext();
            this.mNetworkParam = new NetworkParam();
            this.mDeviceInfoParam = new DeviceInfoParam();
            this.mUaParam = new UaParam();
            String cuid = DeviceId.getCUID(this.mContext);
            this.mUid = cuid;
            if (TextUtils.isEmpty(cuid)) {
                return;
            }
            this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
        }
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String addParam = addParam(addParam(addParam(addParam(this.mNetworkParam.addNetWorkParam(str, true), "ut", this.mDeviceInfoParam.getDeviceInfo()), "ua", this.mUaParam.getUA()), "uid", this.mEnUid), "appname", LokiRuntime.getIdentityNeedContext().getAppName());
            ILokiIdentityContext identityContext = LokiRuntime.getIdentityContext();
            String zid = identityContext.getZid();
            String sid = identityContext.getSid();
            String from = identityContext.getFrom();
            String cfrom = identityContext.getCfrom();
            String schemeHeader = identityContext.getSchemeHeader();
            if (TextUtils.isEmpty(from)) {
                from = ChannelManager.getInstance().getChannel();
            }
            if (TextUtils.isEmpty(cfrom)) {
                cfrom = ChannelManager.getInstance().getLastChannel();
            }
            String addParam2 = addParam(addParam(addParam(addParam(addParam(addParam(addParam, "bdvc", identityContext.getBDVCInfo()), "sid", sid), "zid", zid), "cfrom", cfrom), "from", from), "scheme", schemeHeader);
            if (TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = identityContext.getC3Aid();
            }
            return !TextUtils.isEmpty(this.mC3Aid) ? addParam(addParam2, "c3_aid", this.mC3Aid) : addParam2;
        }
        return (String) invokeL.objValue;
    }
}
