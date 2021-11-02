package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.beans.ApollonBean;
import com.baidu.fsg.base.restnet.beans.IBeanResponseCallback;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.NetUtils;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.Crypto;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public abstract class NetworkBean extends ApollonBean {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String PARAM_APPID = "appid";
    public static final String PARAM_CUID_2 = "cuid_2";
    public static final String PARAM_ENCODE = "encode";
    public static final String PARAM_FKWCP = "fk_wcp";
    public static final String PARAM_IMEI_NEW = "wimei";
    public static final String PARAM_IMSI_NEW = "wimsi";
    public static final String PARAM_LOCATION = "wloc";
    public static final String PARAM_MOBILE_IP = "wmip";
    public static final String PARAM_NETTYPE = "nettype";
    public static final String PARAM_SIM_PHONE_NUM = "wpn";
    public static final String PARAM_SIM_SERIAL_NUM = "wssn";
    public static final String PARAM_UA = "ua";
    public static final String PARAM_WIFI_SSID = "wssid";
    public static final String REQID = "reqid";
    public static final String SING_SHA1 = "s1";
    public static final String SP_PARAMETER = "sp_params";
    public static final String TAG = "NetworkBean";
    public transient /* synthetic */ FieldHolder $fh;
    public String reqId;
    public String spParameter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkBean(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.spParameter = "";
    }

    private void appendCertification(Context context, List<RestNameValuePair> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, context, list) == null) {
            list.add("gbk".equals(getEncode()) ? new RestNameValuePair("encode", "gbk") : new RestNameValuePair("encode", "utf-8"));
            list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
            String hostAppId = ChannelUtils.getHostAppId();
            if (TextUtils.isEmpty(hostAppId)) {
                list.add(new RestNameValuePair("appid", ""));
            } else {
                list.add(new RestNameValuePair("appid", RimArmor.getInstance().encrypt(hostAppId)));
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("cuid_2", PayUtils.encrypt("phone_number", PhoneUtils.getCUID2(context)));
                StringBuilder sb = new StringBuilder();
                sb.append("fp=");
                sb.append(BdWalletUtils.getDeviceFP(this.mContext));
                String sb2 = sb.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(sb2);
                sb3.append("&lastModify=");
                sb3.append(BdWalletUtils.getFPFileLastModified(this.mContext));
                String sb4 = sb3.toString();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(sb4);
                sb5.append("&cpuInfo=");
                sb5.append(PhoneUtils.getSystemCPUInfo().getCpuPath());
                sb5.append("_");
                sb5.append(PhoneUtils.getNumCores());
                String sb6 = sb5.toString();
                StringBuilder sb7 = new StringBuilder();
                sb7.append(sb6);
                sb7.append("&diskCapacity=");
                sb7.append(PhoneUtils.getTotalInternalMemorySize());
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(sb8);
                sb9.append("&upTime=");
                sb9.append(SystemClock.elapsedRealtime() / 1000);
                jSONObject.put("fk_wcp", PayUtils.encrypt("phone_number", sb9.toString()));
                jSONObject.put(PARAM_IMEI_NEW, PayUtils.encrypt("phone_number", PhoneUtils.getImei(context)));
                jSONObject.put("wmip", PayUtils.encrypt("phone_number", PhoneUtils.getIpInfo()));
                jSONObject.put("wloc", PayUtils.encrypt("phone_number", PhoneUtils.getGPSLocation(context)));
                jSONObject.put(PARAM_IMSI_NEW, PayUtils.encrypt("phone_number", PhoneUtils.getImsi(context)));
                jSONObject.put("wssn", PayUtils.encrypt("phone_number", PhoneUtils.getSimSerialNum(context)));
                jSONObject.put(PARAM_SIM_PHONE_NUM, PayUtils.encrypt("phone_number", PhoneUtils.getLineNum(context)));
                jSONObject.put(PARAM_WIFI_SSID, PayUtils.encrypt("phone_number", getSsid(context)));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
            String str = RimArmor.getInstance().getpwProxy();
            boolean z = false;
            Iterator<RestNameValuePair> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if ("key".equals(it.next().getName())) {
                    z = true;
                    break;
                }
            }
            if (z) {
                return;
            }
            list.add(new RestNameValuePair("key", str));
        }
    }

    private List<RestNameValuePair> appendUriParameter(Context context, List<RestNameValuePair> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, this, context, list)) == null) {
            if (list == null) {
                list = new ArrayList<>();
            }
            appendCertification(context, list);
            String md5 = Md5Utils.toMD5(PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
            this.reqId = md5;
            list.add(new RestNameValuePair("reqid", PayUtils.encrypt("phone_number", md5)));
            list.add(new RestNameValuePair("sp_params", PayUtils.encrypt("phone_number", this.spParameter)));
            list.add(new RestNameValuePair("s1", RimArmor.getInstance().encryptProxy(getAppSignatureSha1(context, context.getPackageName()))));
            if (needNonce()) {
                try {
                    list.add(new RestNameValuePair("nonce", PayUtils.getNonce(this.mContext, list)));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return list;
        }
        return (List) invokeLL.objValue;
    }

    public static String getAppSignatureSha1(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, context, str)) == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
                return (packageInfo == null || packageInfo.signatures == null) ? "" : Crypto.sha1(packageInfo.signatures[0].toByteArray());
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                return "";
            } catch (Exception e3) {
                e3.printStackTrace();
                return "";
            }
        }
        return (String) invokeLL.objValue;
    }

    public abstract List<RestNameValuePair> generateRequestParam();

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? appendUriParameter(this.mContext, generateRequestParam()) : (List) invokeV.objValue;
    }

    public String getSsid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context)) == null) {
            JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
            if (connectedWifi != null) {
                String optString = connectedWifi.optString("ssid", null);
                return optString != null ? RimArmor.getInstance().encryptProxy(optString) : optString;
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void handleCommonErrors(Exception exc) {
        IBeanResponseCallback iBeanResponseCallback;
        int beanId;
        String str;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, exc) == null) {
            LogUtil.d("NetworkBean", "execBean. exception = " + exc);
            if (exc instanceof RestRuntimeException) {
                if (this.mRspCallback != null) {
                    RestRuntimeException restRuntimeException = (RestRuntimeException) exc;
                    if (restRuntimeException.contains(SocketTimeoutException.class)) {
                        iBeanResponseCallback = this.mRspCallback;
                        beanId = getBeanId();
                        str = BeanConstants.rim_timeout_error;
                        i2 = -5;
                    } else if (restRuntimeException.contains(SSLPeerUnverifiedException.class) || restRuntimeException.contains(CertificateException.class)) {
                        iBeanResponseCallback = this.mRspCallback;
                        beanId = getBeanId();
                        str = BeanConstants.rim_ssl;
                        i2 = -16;
                    } else if (restRuntimeException.contains(IllegalArgumentException.class)) {
                        iBeanResponseCallback = this.mRspCallback;
                        if (iBeanResponseCallback == null) {
                            return;
                        }
                    } else {
                        iBeanResponseCallback = this.mRspCallback;
                        beanId = getBeanId();
                        str = BeanConstants.rim_resolve_error;
                        i2 = -15;
                    }
                    iBeanResponseCallback.onBeanExecFailure(beanId, i2, str);
                }
                return;
            } else if (!(exc instanceof IllegalArgumentException)) {
                exc.printStackTrace();
                return;
            } else {
                iBeanResponseCallback = this.mRspCallback;
                if (iBeanResponseCallback == null) {
                    return;
                }
            }
            beanId = getBeanId();
            str = BeanConstants.rim_resolve_error;
            i2 = -2;
            iBeanResponseCallback.onBeanExecFailure(beanId, i2, str);
        }
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public void handleNetworkFailureError() {
        IBeanResponseCallback iBeanResponseCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (iBeanResponseCallback = this.mRspCallback) == null) {
            return;
        }
        iBeanResponseCallback.onBeanExecFailure(getBeanId(), -8, BeanConstants.rim_no_network);
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, restResponseEntity) == null) {
        }
    }

    public abstract boolean needNonce();

    public void setSpParameter(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.spParameter = str;
        }
    }
}
