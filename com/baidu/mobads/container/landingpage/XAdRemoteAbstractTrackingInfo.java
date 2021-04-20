package com.baidu.mobads.container.landingpage;

import android.content.Context;
import com.baidu.mobads.container.XAdRemoteCommonUtils;
import com.baidu.mobads.container.XAdSDKRemoteConfig;
import com.baidu.mobads.container.XAdSDKRemoteVersion;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.components.command.XAdRemoteAPKDownloadExtraInfo;
import com.baidu.mobads.container.util.Base64;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.EncryptUtils;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.xiaomi.mipush.sdk.Constants;
import java.net.URLEncoder;
import java.util.HashMap;
/* loaded from: classes2.dex */
public abstract class XAdRemoteAbstractTrackingInfo {
    public static final String COUNTLY_AD_TYPE = "adt";
    public String adid;
    public String appsec;
    public String appsid;
    public String cuid;
    public Context mApplicationContext;
    public String os;
    public String packageNameOfPubliser;
    public String prod;
    public String qk;
    public String sn;
    public long ts;
    public String v;

    public XAdRemoteAbstractTrackingInfo(XAdRemoteCommandExtraInfo xAdRemoteCommandExtraInfo) {
        this(xAdRemoteCommandExtraInfo.getAdInstanceInfo().getAdId(), xAdRemoteCommandExtraInfo.getAdInstanceInfo().getQueryKey(), xAdRemoteCommandExtraInfo.mProdType, xAdRemoteCommandExtraInfo.appsid, xAdRemoteCommandExtraInfo.appsec);
    }

    public String encodeURIComponent(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20").replaceAll("\\%21", "!").replaceAll("\\%27", "'").replaceAll("\\%28", "(").replaceAll("\\%29", SmallTailInfo.EMOTION_SUFFIX).replaceAll("\\%7E", Constants.WAVE_SEPARATOR);
        } catch (Exception unused) {
            return str;
        }
    }

    public String mapToString(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        try {
            StringBuilder sb2 = new StringBuilder();
            for (String str : hashMap.keySet()) {
                String str2 = hashMap.get(str);
                if (str != null && str2 != null) {
                    String encodeURIComponent = encodeURIComponent(str);
                    String encodeURIComponent2 = encodeURIComponent(str2);
                    sb.append(encodeURIComponent + "=" + encodeURIComponent2 + "&");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(encodeURIComponent2);
                    sb3.append(",");
                    sb2.append(sb3.toString());
                }
            }
            sb2.append(XAdSDKRemoteConfig.SED);
            String md5 = EncryptUtils.getMD5(sb2.toString());
            sb.append("vd=" + md5 + "&");
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public abstract HashMap<String, String> toAdditionalHashMap();

    public HashMap<String, String> toFixedHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(XAdRemoteAPKDownloadExtraInfo.ADID, this.adid);
        hashMap.put("appsec", this.appsec);
        hashMap.put("appsid", this.appsid);
        hashMap.put("pack", this.packageNameOfPubliser);
        hashMap.put(XAdRemoteAPKDownloadExtraInfo.QK, this.qk);
        hashMap.put(IAdRequestParam.SN, this.sn);
        hashMap.put("ts", "" + this.ts);
        hashMap.put("v", this.v);
        hashMap.put(IAdRequestParam.OS, this.os);
        hashMap.put("prod", this.prod);
        hashMap.put("cuid", this.cuid);
        hashMap.put("p_ver", XAdRemoteCommonUtils.getProxyVer());
        return hashMap;
    }

    public HashMap<String, String> toHashMap() {
        HashMap<String, String> fixedHashMap = toFixedHashMap();
        HashMap<String, String> additionalHashMap = toAdditionalHashMap();
        if (additionalHashMap != null) {
            fixedHashMap.putAll(additionalHashMap);
        }
        return fixedHashMap;
    }

    public String toString() {
        return mapToString(toHashMap());
    }

    @Deprecated
    public XAdRemoteAbstractTrackingInfo(String str, String str2, String str3, String str4, String str5) {
        this.adid = "-1";
        this.qk = "";
        this.packageNameOfPubliser = "";
        this.appsec = "";
        this.appsid = "";
        this.v = "";
        this.sn = "";
        this.prod = "";
        this.cuid = "";
        this.mApplicationContext = XAdRemoteCommonUtils.getApplicationContext();
        this.ts = System.currentTimeMillis();
        this.adid = str;
        this.qk = str2;
        this.appsec = str5;
        Context context = this.mApplicationContext;
        if (context != null) {
            this.packageNameOfPubliser = context.getPackageName();
        }
        this.appsid = str4;
        this.sn = DeviceUtils.getInstance().getEncodedSN(this.mApplicationContext);
        this.os = "android";
        this.v = "android_" + XAdSDKRemoteVersion.getVersion() + "_4.1.30";
        this.prod = str3;
        this.cuid = Base64.encode(DeviceUtils.getInstance().getCUID(this.mApplicationContext));
    }
}
