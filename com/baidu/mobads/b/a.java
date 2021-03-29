package com.baidu.mobads.b;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.constants.XAdSDKProxyVersion;
import com.baidu.mobads.g.g;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.openad.b.b;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.l;
import com.baidu.mobads.utils.q;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final IXAdLogger f8167a = XAdSDKFoundationFacade.getInstance().getAdLogger();

    /* renamed from: e  reason: collision with root package name */
    public Context f8168e;

    /* renamed from: d  reason: collision with root package name */
    public static a f8166d = new a();

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f8164b = "";

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f8165c = "";

    public static a a() {
        return f8166d;
    }

    private String b() {
        String str = com.baidu.mobads.constants.a.f8206c;
        if ("0.0".equals(str)) {
            try {
                double a2 = g.a(this.f8168e, g.a(this.f8168e));
                return a2 > 0.0d ? String.valueOf(a2) : str;
            } catch (Throwable th) {
                this.f8167a.d(th);
                return str;
            }
        }
        return str;
    }

    public void a(Context context) {
        if (this.f8168e == null) {
            this.f8168e = context;
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ad", str3);
            hashMap.put("stacktrace", str2);
            a(str, "404", hashMap);
        } catch (Exception e2) {
            this.f8167a.d(e2);
        }
    }

    private void a(String str, String str2, HashMap<String, String> hashMap) {
        String str3;
        String str4;
        l adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        Uri.Builder builder = new Uri.Builder();
        try {
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            Context applicationContext = XAdSDKFoundationFacade.getInstance().getApplicationContext();
            if (applicationContext != null) {
                str4 = systemUtils.getEncodedSN(applicationContext);
                str3 = commonUtils.base64Encode(systemUtils.getCUID(applicationContext));
            } else {
                str3 = "";
                str4 = str3;
            }
            Uri.Builder appendQueryParameter = builder.appendQueryParameter("type", str2).appendQueryParameter(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG).appendQueryParameter("appsid", adConstants.getAppSid());
            Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("v", "android_" + b() + "_4.1.30").appendQueryParameter("pack", adConstants.getAppPackageNameOfPublisher()).appendQueryParameter(IXAdRequestInfo.SN, str4).appendQueryParameter("cuid", str3).appendQueryParameter(IXAdRequestInfo.OS, "android").appendQueryParameter(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(Build.VERSION.SDK_INT);
            Uri.Builder appendQueryParameter3 = appendQueryParameter2.appendQueryParameter(IXAdRequestInfo.BDR, sb.toString());
            appendQueryParameter3.appendQueryParameter(IXAdRequestInfo.BRAND, "" + commonUtils.getTextEncoder(Build.BRAND));
            if (str != null && str.length() > 128) {
                int indexOf = str.indexOf(10);
                if (indexOf <= 0) {
                    indexOf = 127;
                }
                str = str.substring(0, indexOf);
            }
            builder.appendQueryParameter("reason", str);
            if (hashMap != null) {
                for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                    builder.appendQueryParameter(entry.getKey(), entry.getValue());
                }
            }
        } catch (Throwable th) {
            this.f8167a.d(th);
        }
        b bVar = new b("https://mobads-logs.baidu.com/brwhis.log", "");
        bVar.a(builder);
        bVar.a(0);
        new com.baidu.mobads.openad.b.a().a(bVar);
    }

    public void a(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        a(0.1d, context, str, iXAdInstanceInfo, iXAdProdInfo, objArr);
    }

    public void a(double d2, Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < objArr.length; i++) {
            try {
                hashMap.put("custom_" + i, String.valueOf(objArr[i]));
            } catch (Exception e2) {
                q.a().e(e2);
                return;
            }
        }
        a(d2, context, str, iXAdInstanceInfo, iXAdProdInfo, hashMap);
    }

    public void a(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        a(1.0d, context, str, iXAdInstanceInfo, iXAdProdInfo, hashMap);
    }

    public void a(double d2, Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, HashMap<String, String> hashMap) {
        try {
            if (d2 > new Random().nextDouble()) {
                if (hashMap == null) {
                    hashMap = new HashMap<>();
                }
                hashMap.put("probability", String.valueOf(d2));
                a(new com.baidu.mobads.vo.a.b(str, iXAdInstanceInfo, iXAdProdInfo, hashMap).a(context));
            }
        } catch (Exception e2) {
            q.a().e(e2);
        }
    }

    public void a(Context context, int i, IXAdInstanceInfo iXAdInstanceInfo, HashMap<String, String> hashMap) {
        try {
            IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            if (hashMap == null) {
                hashMap = new HashMap<>();
            }
            hashMap.put("type", String.valueOf(i));
            hashMap.put(IXAdRequestInfo.OS, "android");
            hashMap.put(IXAdRequestInfo.OSV, Build.VERSION.RELEASE);
            hashMap.put("brand", systemUtils.getPhoneOSBrand());
            hashMap.put(IXAdRequestInfo.BDR, systemUtils.getPhoneOSBuildVersionSdk());
            hashMap.put("model", Build.MODEL);
            hashMap.put("v", b());
            hashMap.put(IXAdRequestInfo.P_VER, XAdSDKProxyVersion.RELEASE_TAG);
            hashMap.put("pack", commonUtils.getAppPackage(context));
            hashMap.put("appsid", commonUtils.getAppId(context));
            hashMap.put("net", systemUtils.getNetworkType(context));
            hashMap.put("cuid", systemUtils.getCUID(context));
            hashMap.put(IXAdRequestInfo.SN, systemUtils.getEncodedSN(context));
            if (iXAdInstanceInfo != null) {
                hashMap.put("act", "" + iXAdInstanceInfo.getActionType());
                hashMap.put("buyer", a(iXAdInstanceInfo.getOriginJsonObject()));
                hashMap.put("qk", iXAdInstanceInfo.getQueryKey());
                hashMap.put("adid", iXAdInstanceInfo.getAdId());
                hashMap.put("pk", iXAdInstanceInfo.getAppPackageName());
                hashMap.put("autoOpen", "" + iXAdInstanceInfo.isAutoOpen());
            }
            a(a(context, String.valueOf(i), hashMap));
        } catch (Throwable th) {
            this.f8167a.d(th);
        }
    }

    private void a(String str) {
        a(1, str);
    }

    private void a(int i, String str) {
        com.baidu.mobads.openad.b.a aVar = new com.baidu.mobads.openad.b.a();
        b bVar = new b(str, "");
        bVar.f8414e = i;
        aVar.a(bVar, Boolean.TRUE);
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder("type=" + str + "&");
            StringBuilder sb2 = new StringBuilder();
            map.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis() + "");
            h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str2 != null && str3 != null) {
                    String encodeURIComponent = commonUtils.encodeURIComponent(str2);
                    String encodeURIComponent2 = commonUtils.encodeURIComponent(str3);
                    sb.append(encodeURIComponent);
                    sb.append("=");
                    sb.append(encodeURIComponent2);
                    sb.append("&");
                    sb2.append(encodeURIComponent2);
                    sb2.append(",");
                }
            }
            sb2.append("mobads,");
            String md5 = commonUtils.getMD5(sb2.toString());
            IXAdLogger iXAdLogger = this.f8167a;
            iXAdLogger.d("ExtraQuery.allValue:" + ((Object) sb2));
            sb.append("vd=" + md5 + "&");
            IXAdLogger iXAdLogger2 = this.f8167a;
            iXAdLogger2.d("ExtraQuery.params:" + ((Object) sb));
            return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
        } catch (Exception e2) {
            this.f8167a.d(e2);
            return "";
        }
    }

    private String a(JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("buyer", "");
            return TextUtils.isEmpty(optString) ? jSONObject.optString("buyer_id", "") : optString;
        }
        return "";
    }
}
