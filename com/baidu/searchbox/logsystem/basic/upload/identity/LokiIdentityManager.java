package com.baidu.searchbox.logsystem.basic.upload.identity;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.common.util.DeviceId;
import com.baidu.android.imsdk.chatmessage.request.IMAudioTransRequest;
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
/* loaded from: classes4.dex */
public final class LokiIdentityManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PARAM_APP_NAME = "appname";
    public static final String PARAM_BDVC = "bdvc";
    public static final String PARAM_C3AID = "c3_aid";
    public static final String PARAM_CFROM = "cfrom";
    public static final String PARAM_FROM = "from";
    public static final String PARAM_IID = "iid";
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
    public boolean mHasPrivacy;
    public String mIID;
    public NetworkParam mNetworkParam;
    public UaParam mUaParam;
    public String mUid;

    public LokiIdentityManager() {
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
        this.mHasPrivacy = true;
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
                return URLEncoder.encode(str, IMAudioTransRequest.CHARSET);
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
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mContext = AppRuntime.getAppContext();
            this.mNetworkParam = new NetworkParam();
            this.mDeviceInfoParam = new DeviceInfoParam();
            this.mUaParam = new UaParam();
            boolean hasPrivacyAuthority = LokiRuntime.getIdentityContext().hasPrivacyAuthority();
            this.mHasPrivacy = hasPrivacyAuthority;
            if (hasPrivacyAuthority) {
                String cuid = DeviceId.getCUID(this.mContext);
                this.mUid = cuid;
                if (TextUtils.isEmpty(cuid)) {
                    return;
                }
                this.mEnUid = new String(Base64Encoder.B64Encode(this.mUid.getBytes()));
                return;
            }
            this.mIID = LokiRuntime.getIdentityContext().getIID();
        }
    }

    public String processUrl(String str) {
        InterceptResult invokeL;
        String addParam;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String addParam2 = addParam(addParam(this.mNetworkParam.addNetWorkParam(str, true), "ut", this.mDeviceInfoParam.getDeviceInfo()), "ua", this.mUaParam.getUA());
            if (this.mHasPrivacy) {
                addParam = addParam(addParam2, "uid", this.mEnUid);
            } else {
                addParam = addParam(addParam2, "iid", this.mIID);
            }
            String addParam3 = addParam(addParam, "appname", LokiRuntime.getIdentityNeedContext().getAppName());
            ILokiIdentityContext identityContext = LokiRuntime.getIdentityContext();
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
            String addParam4 = addParam(addParam(addParam(addParam(addParam(addParam3, "bdvc", identityContext.getBDVCInfo()), "sid", sid), "cfrom", cfrom), "from", from), "scheme", schemeHeader);
            if (this.mHasPrivacy) {
                addParam4 = addParam(addParam4, "zid", identityContext.getZid());
            }
            if (this.mHasPrivacy && TextUtils.isEmpty(this.mC3Aid)) {
                this.mC3Aid = identityContext.getC3Aid();
            }
            return (!this.mHasPrivacy || TextUtils.isEmpty(this.mC3Aid)) ? addParam4 : addParam(addParam4, "c3_aid", this.mC3Aid);
        }
        return (String) invokeL.objValue;
    }
}
