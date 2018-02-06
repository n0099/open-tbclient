package com.baidu.fsg.base.restnet.beans.business;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.fsg.base.armor.RimArmor;
import com.baidu.fsg.base.restnet.RestNameValuePair;
import com.baidu.fsg.base.restnet.RestResponseEntity;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.beans.ApollonBean;
import com.baidu.fsg.base.restnet.beans.business.core.PayUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.BdWalletUtils;
import com.baidu.fsg.base.restnet.beans.business.core.utils.NetUtils;
import com.baidu.fsg.base.utils.Base64Utils;
import com.baidu.fsg.base.utils.BussinessUtils;
import com.baidu.fsg.base.utils.ChannelUtils;
import com.baidu.fsg.base.utils.LogUtil;
import com.baidu.fsg.base.utils.Md5Utils;
import com.baidu.fsg.base.utils.NetworkUtils;
import com.baidu.fsg.base.utils.PhoneUtils;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class NetworkBean extends ApollonBean {
    private static final boolean DEBUG = false;
    private static final String PARAM_APPID = "appid";
    private static final String PARAM_CUID_2 = "cuid_2";
    private static final String PARAM_ENCODE = "encode";
    private static final String PARAM_FKWCP = "fk_wcp";
    private static final String PARAM_IMEI_NEW = "wimei";
    private static final String PARAM_IMSI_NEW = "wimsi";
    private static final String PARAM_LOCATION = "wloc";
    private static final String PARAM_MOBILE_IP = "wmip";
    private static final String PARAM_NETTYPE = "nettype";
    private static final String PARAM_SIM_PHONE_NUM = "wpn";
    private static final String PARAM_SIM_SERIAL_NUM = "wssn";
    private static final String PARAM_UA = "ua";
    private static final String PARAM_WIFI_SSID = "wssid";
    private static final String REQID = "reqid";
    private static final String SP_PARAMETER = "sp_params";
    private static final String TAG = "NetworkBean";
    protected String reqId;
    private String spParameter;

    public abstract List<RestNameValuePair> generateRequestParam();

    public abstract boolean needNonce();

    public void setSpParameter(String str) {
        this.spParameter = str;
    }

    public NetworkBean(Context context) {
        super(context);
        this.spParameter = "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public List<RestNameValuePair> getRequestParams() {
        return appendUriParameter(this.mContext, generateRequestParam());
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    protected void handleCommonErrors(Exception exc) {
        LogUtil.d(TAG, "execBean. exception = " + exc);
        if (exc instanceof RestRuntimeException) {
            if (this.mRspCallback != null) {
                if (((RestRuntimeException) exc).contains(SocketTimeoutException.class)) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, "网络不给力，请稍后重试");
                } else if (((RestRuntimeException) exc).contains(SSLPeerUnverifiedException.class) || ((RestRuntimeException) exc).contains(CertificateException.class)) {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -16, BeanConstants.rim_ssl);
                } else if (((RestRuntimeException) exc).contains(IllegalArgumentException.class)) {
                    if (this.mRspCallback != null) {
                        this.mRspCallback.onBeanExecFailure(getBeanId(), -2, BeanConstants.rim_resolve_error);
                    }
                } else {
                    this.mRspCallback.onBeanExecFailure(getBeanId(), -15, BeanConstants.rim_resolve_error);
                }
            }
        } else if (exc instanceof IllegalArgumentException) {
            if (this.mRspCallback != null) {
                this.mRspCallback.onBeanExecFailure(getBeanId(), -2, BeanConstants.rim_resolve_error);
            }
        } else {
            exc.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    public <T> void handleResponseHeaders(RestResponseEntity<T> restResponseEntity) {
    }

    private List<RestNameValuePair> appendUriParameter(Context context, List<RestNameValuePair> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        appendCertification(context, list);
        this.reqId = Md5Utils.toMD5(PhoneUtils.getCUID2(context) + System.currentTimeMillis() + UUID.randomUUID());
        list.add(new RestNameValuePair(REQID, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, this.reqId)));
        list.add(new RestNameValuePair(SP_PARAMETER, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, this.spParameter)));
        if (needNonce()) {
            try {
                list.add(new RestNameValuePair("nonce", PayUtils.getNonce(this.mContext, list)));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private void appendCertification(Context context, List<RestNameValuePair> list) {
        boolean z;
        if ("gbk".equals(getEncode())) {
            list.add(new RestNameValuePair(PARAM_ENCODE, "gbk"));
        } else {
            list.add(new RestNameValuePair(PARAM_ENCODE, "utf-8"));
        }
        list.add(new RestNameValuePair("ua", BussinessUtils.getUA(context)));
        String hostAppId = ChannelUtils.getHostAppId();
        if (!TextUtils.isEmpty(hostAppId)) {
            list.add(new RestNameValuePair("appid", RimArmor.getInstance().encrypt(hostAppId)));
        } else {
            list.add(new RestNameValuePair("appid", ""));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PARAM_CUID_2, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getCUID2(context)));
            jSONObject.put(PARAM_FKWCP, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, (((("fp=" + BdWalletUtils.getDeviceFP(this.mContext)) + "&lastModify=" + BdWalletUtils.getFPFileLastModified(this.mContext)) + "&cpuInfo=" + PhoneUtils.getSystemCPUInfo().getCpuPath() + "_" + PhoneUtils.getNumCores()) + "&diskCapacity=" + PhoneUtils.getTotalInternalMemorySize()) + "&upTime=" + (SystemClock.elapsedRealtime() / 1000)));
            jSONObject.put(PARAM_NETTYPE, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, NetworkUtils.getNetworkType(context) + ""));
            jSONObject.put(PARAM_IMEI_NEW, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getImei(context)));
            jSONObject.put(PARAM_MOBILE_IP, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getIpInfo()));
            jSONObject.put(PARAM_LOCATION, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getGPSLocation(context)));
            jSONObject.put(PARAM_IMSI_NEW, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getImsi(context)));
            jSONObject.put(PARAM_SIM_SERIAL_NUM, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getSimSerialNum(context)));
            jSONObject.put(PARAM_SIM_PHONE_NUM, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, PhoneUtils.getLineNum(context)));
            jSONObject.put(PARAM_WIFI_SSID, PayUtils.encrypt(PayUtils.KEY_PHONE_NUMBER, getSsid(context)));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        list.add(new RestNameValuePair("wcp", new String(Base64Utils.encode(jSONObject.toString().getBytes()))));
        String str = RimArmor.getInstance().getpwProxy();
        Iterator<RestNameValuePair> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (RimArmor.KEY.equals(it.next().getName())) {
                z = true;
                break;
            }
        }
        if (!z) {
            list.add(new RestNameValuePair(RimArmor.KEY, str));
        }
    }

    String getSsid(Context context) {
        JSONObject connectedWifi = NetUtils.getConnectedWifi(context);
        if (connectedWifi != null) {
            String optString = connectedWifi.optString("ssid", null);
            if (optString != null) {
                return RimArmor.getInstance().encryptProxy(optString);
            }
            return optString;
        }
        return null;
    }

    @Override // com.baidu.fsg.base.restnet.beans.ApollonBean
    protected void handleNetworkFailureError() {
        if (this.mRspCallback != null) {
            this.mRspCallback.onBeanExecFailure(getBeanId(), -8, "网络不给力，请稍后重试");
        }
    }
}
