package com.baidu.mobads.c;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.IXAdInstanceInfo;
import com.baidu.mobads.interfaces.IXAdProdInfo;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobads.interfaces.download.activate.IXAppInfo;
import com.baidu.mobads.interfaces.utils.IXAdLogger;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;
import com.baidu.mobads.utils.e;
import com.baidu.mobads.utils.h;
import com.baidu.mobads.utils.m;
import com.baidu.mobads.vo.a.d;
import com.baidu.webkit.internal.ETAG;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
/* loaded from: classes8.dex */
public class a {
    protected final IXAdLogger a = XAdSDKFoundationFacade.getInstance().getAdLogger();
    private Context e;
    private static a d = new a();
    public static volatile String b = "";
    public static volatile String c = "";
    private static boolean f = false;

    public static a a() {
        return d;
    }

    private a() {
        new Handler(Looper.getMainLooper()).postDelayed(new b(this), 2000L);
    }

    public void a(Context context) {
        if (this.e == null) {
            this.e = context;
        }
    }

    public void a(Context context, com.baidu.mobads.command.a aVar) {
        a(context, "9", aVar);
    }

    public void a(com.baidu.mobads.command.a aVar) {
    }

    public void a(Context context, IXAppInfo iXAppInfo) {
        a(context, "11", iXAppInfo);
    }

    public void b(Context context, IXAppInfo iXAppInfo) {
        a(context, "10", iXAppInfo);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("temp_for_feed_response_html")) {
            if (!f) {
                a("temp_for_feed_response_html", TbEnum.SystemMessage.EVENT_ID_DELETE_FRIEND, b + "___" + c);
                f = true;
                return;
            }
            return;
        }
        a(str, "400", (Uri.Builder) null);
    }

    public void a(String str, String str2, String str3) {
        try {
            Uri.Builder appendQueryParameter = new Uri.Builder().appendQueryParameter("stacktrace", str2);
            appendQueryParameter.appendQueryParameter("ad", str3);
            for (Map.Entry<String, String> entry : new com.baidu.mobads.vo.a.b().c().entrySet()) {
                appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            a(str, "404", appendQueryParameter);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
    }

    private void a(String str, String str2, Uri.Builder builder) {
        h adConstants = XAdSDKFoundationFacade.getInstance().getAdConstants();
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        if (builder == null) {
            builder = new Uri.Builder();
        }
        try {
            builder.appendQueryParameter("type", str2).appendQueryParameter(IXAdRequestInfo.P_VER, "8.8146").appendQueryParameter("appsid", adConstants.getAppSid()).appendQueryParameter("v", "android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30").appendQueryParameter(TiebaInitialize.LogFields.REASON, str).appendQueryParameter(IXAdRequestInfo.OSV, Build.VERSION.RELEASE).appendQueryParameter(IXAdRequestInfo.BDR, "" + Build.VERSION.SDK_INT).appendQueryParameter(IXAdRequestInfo.BRAND, "" + commonUtils.getTextEncoder(Build.BRAND)).appendQueryParameter("pack", adConstants.getAppPackageNameOfPublisher());
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().e(e);
        }
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c("https://mobads-logs.baidu.com/brwhis.log", "");
        cVar.a(builder);
        cVar.a(0);
        new com.baidu.mobads.openad.d.a().a(cVar);
    }

    private void a(Context context, String str, com.baidu.mobads.command.a aVar) {
        IXAppInfo a = com.baidu.mobads.command.a.a.a(aVar);
        if (a != null) {
            a(context, str, a);
        }
    }

    private void a(Context context, String str, IXAppInfo iXAppInfo) {
        com.baidu.mobads.vo.a.c cVar = new com.baidu.mobads.vo.a.c(context, iXAppInfo);
        cVar.b = iXAppInfo.getAdId();
        b(a(context, str, cVar.c()));
    }

    public void a(Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        a(0.1d, context, str, iXAdInstanceInfo, iXAdProdInfo, objArr);
    }

    public void a(double d2, Context context, String str, IXAdInstanceInfo iXAdInstanceInfo, IXAdProdInfo iXAdProdInfo, Object... objArr) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i = 0; i < objArr.length; i++) {
            try {
                hashMap.put("custom_" + i, String.valueOf(objArr[i]));
            } catch (Exception e) {
                m.a().e(e);
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
                b(new d(str, iXAdInstanceInfo, iXAdProdInfo, hashMap).a(context));
            }
        } catch (Exception e) {
            m.a().e(e);
        }
    }

    private void b(String str) {
        a(1, str);
    }

    private void a(int i, String str) {
        com.baidu.mobads.openad.d.a aVar = new com.baidu.mobads.openad.d.a();
        com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(str, "");
        cVar.e = i;
        aVar.a(cVar, (Boolean) true);
    }

    private String a(Context context, String str, Map<String, String> map) {
        try {
            StringBuilder sb = new StringBuilder("type=" + str + ETAG.ITEM_SEPARATOR);
            StringBuilder sb2 = new StringBuilder();
            map.put(TimeDisplaySetting.TIME_DISPLAY_SETTING, System.currentTimeMillis() + "");
            e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                if (str2 != null && str3 != null) {
                    String encodeURIComponent = commonUtils.encodeURIComponent(str2);
                    String encodeURIComponent2 = commonUtils.encodeURIComponent(str3);
                    sb.append(encodeURIComponent);
                    sb.append(ETAG.EQUAL);
                    sb.append(encodeURIComponent2);
                    sb.append(ETAG.ITEM_SEPARATOR);
                    sb2.append(encodeURIComponent2);
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb2.append("mobads,");
            String md5 = commonUtils.getMD5(sb2.toString());
            this.a.d("ExtraQuery.allValue:" + ((Object) sb2));
            sb.append("vd=" + md5 + ETAG.ITEM_SEPARATOR);
            this.a.d("ExtraQuery.params:" + ((Object) sb));
            return "https://mobads-logs.baidu.com/dz.zb?" + sb.toString();
        } catch (Exception e) {
            this.a.d(e);
            return "";
        }
    }
}
