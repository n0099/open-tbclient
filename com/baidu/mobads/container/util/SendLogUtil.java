package com.baidu.mobads.container.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.adrequest.IXAdInstanceInfo;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.service.PluginLoader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class SendLogUtil {
    public static String END_REQUEST_TIME = "";
    public static String START_REQUEST_TIME = "";
    public static int SUBTYPE_READ_SP = 2;
    public static int SUBTYPE_READ_SP_REPLACE = 3;
    public static int SUBTYPE_SAVE_TO_SP = 1;
    public static int TYPE_SEND_COOKIE = 425;

    /* loaded from: classes2.dex */
    public static class Builder {
        public static HashMap<String, String> mCommon = new HashMap<>();
        public HashMap<String, String> mArgs = new HashMap<>();
        public Context mContext;
        public int mType;

        public Builder(Context context) {
            this.mContext = context;
            initCommonArgs();
            mCommon.put("appsid", DeviceUtils.getInstance().getAppId(this.mContext));
            mCommon.put(IAdRequestParam.NCUID, Base64.encode(PluginLoader.getCuidFromGalaxy(this.mContext)));
            mCommon.put("zd", PluginLoader.getZid(this.mContext));
        }

        public static Builder create(Context context) {
            return new Builder(context);
        }

        private StringBuffer fill(HashMap<String, String> hashMap) {
            StringBuffer stringBuffer = new StringBuffer();
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    try {
                        String encode = URLEncoder.encode(entry.getValue().trim(), "utf-8");
                        stringBuffer.append(entry.getKey());
                        stringBuffer.append("=");
                        stringBuffer.append(encode);
                        stringBuffer.append("&");
                    } catch (Exception unused) {
                    }
                }
            }
            return stringBuffer;
        }

        private void initCommonArgs() {
            if (mCommon.isEmpty()) {
                mCommon.put("cuid", Base64.encode(DeviceUtils.getInstance().getCUID(this.mContext)));
                mCommon.put(IAdRequestParam.SN, DeviceUtils.getInstance().getEncodedSN(this.mContext));
                mCommon.put(IAdRequestParam.OS, "android");
                mCommon.put(IAdRequestParam.OSV, Build.VERSION.RELEASE);
                mCommon.put("model", Build.MODEL);
                mCommon.put("brand", DeviceUtils.getInstance().getPhoneOSBrand());
                mCommon.put(IAdRequestParam.BDR, DeviceUtils.getInstance().getPhoneOSBuildVersionSdk());
                mCommon.put("v", "android_9.041");
                mCommon.put("p_ver", XAdRemoteCommonUtils.getProxyVer());
                mCommon.put("a_ver", XAdRemoteCommonUtils.getAdServVersion());
                mCommon.put("pack", AppUtils.getAppPackage(this.mContext));
            }
        }

        private void sendUnderSecurity(StringBuffer stringBuffer) {
            try {
                XAdRemoteCommonUtils.makeRequest(AdURIUtils.addParameters("https://mobads-logs.baidu.com/dz.zb?" + stringBuffer.toString(), null), 2);
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th.getMessage());
            }
        }

        public Builder append(String str, String str2) {
            this.mArgs.put(str, str2);
            return this;
        }

        public Builder appendAdInfo(IXAdInstanceInfo iXAdInstanceInfo) {
            this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.QK, iXAdInstanceInfo.getQueryKey());
            this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.ADID, iXAdInstanceInfo.getAdId());
            this.mArgs.put("act", String.valueOf(iXAdInstanceInfo.getActionType()));
            try {
                this.mArgs.put(XAdRemoteAPKDownloadExtraInfo.BUYER, iXAdInstanceInfo.getOriginJsonObject().optString(XAdRemoteAPKDownloadExtraInfo.BUYER));
            } catch (Exception unused) {
            }
            return this;
        }

        public Builder appendApId(String str) {
            mCommon.put("apid", str);
            return this;
        }

        public Builder appendAppSid(String str) {
            mCommon.put("appsid", str);
            return this;
        }

        public Builder appendProdType(String str) {
            mCommon.put("prod", str);
            return this;
        }

        public Builder appendType(int i2) {
            this.mType = i2;
            return this;
        }

        public StringBuffer getAllParameters() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("type=");
            stringBuffer.append(this.mType);
            stringBuffer.append(Typography.amp);
            stringBuffer.append(fill(mCommon));
            stringBuffer.append(fill(this.mArgs));
            stringBuffer.append("ts=");
            stringBuffer.append(String.valueOf(System.currentTimeMillis()));
            return stringBuffer;
        }

        public void send() {
            sendUnderSecurity(getAllParameters());
        }

        public void sendWithVd() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("type=");
            stringBuffer.append(this.mType);
            stringBuffer.append(Typography.amp);
            try {
                TreeMap treeMap = new TreeMap();
                StringBuilder sb = new StringBuilder();
                treeMap.putAll(mCommon);
                treeMap.putAll(this.mArgs);
                treeMap.put("ts", String.valueOf(System.currentTimeMillis()));
                RemoteCommonUtils.getInstance();
                for (String str : treeMap.keySet()) {
                    String str2 = (String) treeMap.get(str);
                    if (str != null && str2 != null) {
                        if (!str.equals("targetscheme")) {
                            str = AdURIUtils.encodeURIComponent(str);
                            str2 = AdURIUtils.encodeURIComponent(str2);
                        }
                        stringBuffer.append(str);
                        stringBuffer.append("=");
                        stringBuffer.append(str2);
                        stringBuffer.append("&");
                        sb.append(str2);
                        sb.append(",");
                    }
                }
                sb.append(XAdSDKRemoteConfig.SED);
                stringBuffer.append("vd=");
                stringBuffer.append(EncryptUtils.getMD5(sb.toString()));
            } catch (Throwable th) {
                RemoteXAdLogger.getInstance().d(th.getMessage());
            }
            sendUnderSecurity(stringBuffer);
        }

        public Builder append(String str, boolean z) {
            this.mArgs.put(str, z ? "true" : "false");
            return this;
        }

        public Builder append(String str, int i2) {
            String str2;
            try {
                str2 = String.valueOf(i2);
            } catch (Exception unused) {
                str2 = "-1";
            }
            this.mArgs.put(str, str2);
            return this;
        }

        public Builder append(HashMap<String, String> hashMap) {
            if (hashMap != null) {
                this.mArgs.putAll(hashMap);
            }
            return this;
        }
    }

    public static String addParameters(String str, HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder(str);
        if (hashMap != null && !hashMap.isEmpty()) {
            sb.append("?");
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                try {
                    sb.append(entry.getKey());
                    sb.append("=");
                    sb.append(entry.getValue());
                    sb.append("&");
                } catch (Exception unused) {
                }
            }
            String sb2 = sb.toString();
            return sb2.substring(0, sb2.length() - 1);
        }
        return sb.toString();
    }

    public static void fireAdMetrics(String str, HashMap<String, String> hashMap) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new OAdURLConnection(1, addParameters(str, hashMap)).asynLoad();
    }

    public static void sendCookieLog(Context context, int i2, int i3, String str, String str2) {
        try {
            Builder.create(context).appendType(i2).append("subtype", i3).append("spbaiduid", str).append("cookiebaiduid", str2).append("logversion", "1").send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
        }
    }

    public static void sendExpLpLog(Context context, int i2, HashMap<String, String> hashMap) {
        try {
            Builder.create(context).appendType(i2).append(hashMap).send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
        }
    }

    public static void sendLog(Context context, int i2, String str, String str2) {
        try {
            Builder.create(context).appendType(i2).append("reason", str).append("url", str2).append("m_start_request", START_REQUEST_TIME).append("m_end_request", END_REQUEST_TIME).send();
        } catch (Exception e2) {
            RemoteXAdLogger.getInstance().d(e2.getMessage());
        }
    }

    public static void fireAdMetrics(String str) {
        fireAdMetrics(str, null);
    }
}
