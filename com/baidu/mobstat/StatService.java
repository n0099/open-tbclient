package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobstat.BaiduStatJSInterface;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.ad;
import com.baidu.mobstat.au;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class StatService {
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;
    public static boolean a;
    public static boolean b;
    public static boolean c;

    /* loaded from: classes2.dex */
    public interface OnZidReceiveListener {
        String getZid();
    }

    /* loaded from: classes2.dex */
    public interface WearListener {
        boolean onSendLogData(String str);
    }

    public static void closeTrace() {
        CooperService.instance().closeTrace();
    }

    public static String getSdkVersion() {
        if (CooperService.instance().isCloseTrace()) {
            return "";
        }
        return CooperService.instance().getMTJSDKVersion();
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void a(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        if (context == null) {
            bb.c().c("[WARNING] context is null, invalid");
        } else if (webView == null) {
            bb.c().c("[WARNING] webview is null, invalid");
        } else if (a(context)) {
        } else {
            a(webView);
            WebSettings settings = webView.getSettings();
            if (b) {
                settings.setAllowFileAccess(false);
                settings.setAllowFileAccessFromFileURLs(false);
                settings.setAllowUniversalAccessFromFileURLs(false);
            }
            settings.setJavaScriptEnabled(true);
            settings.setDefaultTextEncodingName("UTF-8");
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            if (!z) {
                webView.setWebViewClient(new BaiduStatJSInterface.CustomWebViewClient(context, webViewClient, null, null));
            } else {
                bk bkVar = new bk();
                webView.addJavascriptInterface(bkVar, "WebViewInterface");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new ad.b());
                arrayList.add(new au.b());
                WebChromeClient customWebChromeViewClient = new BaiduStatJSInterface.CustomWebChromeViewClient(context, webChromeClient, arrayList, bkVar);
                webView.setWebChromeClient(customWebChromeViewClient);
                webView.setTag(-96001, customWebChromeViewClient);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static synchronized void a(Context context, String str, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (CooperService.instance().isCloseTrace()) {
                        return;
                    }
                    if (a(context)) {
                        return;
                    }
                    BDStatCore.instance().onPageEnd(context, str, extraInfo);
                    return;
                }
            }
            bb.c().c("[WARNING] onPageEnd parameter invalid");
        }
    }

    public static void a(Context context, String str, String str2, int i, ExtraInfo extraInfo, Map<String, String> map) {
        if (!a(context, "onEvent(...)") || TextUtils.isEmpty(str) || CooperService.instance().isCloseTrace()) {
            return;
        }
        boolean a2 = bx.a(Application.class, "onCreate");
        if (a2) {
            bb.c().c("[WARNING] onEvent 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
        }
        if (a(context)) {
            return;
        }
        BDStatCore.instance().onEvent(context.getApplicationContext(), str, str2, i, extraInfo, bx.a(map), a2);
    }

    public static void a(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map) {
        if (!a(context, "onEventDuration(...)") || CooperService.instance().isCloseTrace() || TextUtils.isEmpty(str)) {
            return;
        }
        if (j <= 0) {
            bb.c().b("[WARNING] onEventDuration duration must be greater than zero");
            return;
        }
        boolean a2 = bx.a(Application.class, "onCreate");
        if (a2) {
            bb.c().c("[WARNING] onEventDuration 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
        }
        if (a(context)) {
            return;
        }
        BDStatCore.instance().onEventDuration(context.getApplicationContext(), str, str2, j, extraInfo, bx.a(map), a2);
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo) {
        a(context, str, str2, 1, extraInfo, (Map<String, String>) null);
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        if (CooperService.instance().isCloseTrace() || !a(context, "onErised(...)")) {
            return;
        }
        if (str != null && !"".equals(str)) {
            BDStatCore.instance().onErised(context, str, str2, str3);
        } else {
            bb.c().c("[WARNING] AppKey is invalid");
        }
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        a(context, str, str2, i, (ExtraInfo) null, (Map<String, String>) null);
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        a(context, str, str2, j, (ExtraInfo) null, (Map<String, String>) null);
    }

    public static void onEventEnd(Context context, String str, String str2, Map<String, String> map) {
        a(context.getApplicationContext(), str, str2, (ExtraInfo) null, map);
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        if (!a(context, "onEventEnd(...)") || CooperService.instance().isCloseTrace() || TextUtils.isEmpty(str) || a(context)) {
            return;
        }
        BDStatCore.instance().onEventEnd(context.getApplicationContext(), str, str2, extraInfo, bx.a(map));
    }

    public static void a(Context context, boolean z) {
        if (!a(context, "onError(...)") || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        BDStatCore.instance().init(context);
        ExceptionAnalysis.getInstance().openExceptionAnalysis(context.getApplicationContext(), z);
    }

    public static void bindJSInterface(Context context, WebView webView) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        bindJSInterface(context, webView, null);
    }

    public static void enableAppList(Context context, boolean z) {
        CooperService.instance().setEnableBplus(context, z);
    }

    public static void enableDeviceMac(Context context, boolean z) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        CooperService.instance().enableDeviceMac(context, z);
        BDStatCore.instance().init(context);
    }

    public static synchronized void onPageEnd(Context context, String str) {
        synchronized (StatService.class) {
            a(context, str, null);
        }
    }

    public static void recordException(Context context, Throwable th) {
        if (context == null || CooperService.instance().isCloseTrace() || th == null) {
            return;
        }
        ExceptionAnalysis.getInstance().saveCrashInfo(context, th, false);
    }

    public static void sendLogData(Context context, String str) {
        if (!CooperService.instance().isCloseTrace() && context != null && !TextUtils.isEmpty(str)) {
            LogSender.instance().sendLogData(context.getApplicationContext(), str, false);
        }
    }

    public static void setAppVersionName(Context context, String str) {
        if (CooperService.instance().isCloseTrace() || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        CooperService.instance().setAppVersionName(context, str);
    }

    public static void setAttributes(View view2, Map<String, String> map) {
        if (CooperService.instance().isCloseTrace() || view2 == null) {
            return;
        }
        view2.setTag(-96000, map);
    }

    public static void setAuthorizedState(Context context, boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        bu.a().b(z);
    }

    public static void setAutoEventProperty(Context context, Map<String, String> map) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        DataCore.instance().setPydProperty(context, bx.a(map), "3", "3");
        BDStatCore.instance().init(context);
    }

    public static void setContentId(View view2, String str) {
        if (view2 == null || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view2.setTag(-97004, str);
    }

    public static void setContentTitle(View view2, String str) {
        if (view2 == null || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view2.setTag(-97003, str);
    }

    public static void setEnableBackgroundSendLog(Context context, boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        BDStatCore.instance().setAutoSendLog(context, z);
    }

    public static void setForTv(Context context, boolean z) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        bp.a().c(context, z);
        BDStatCore.instance().init(context);
    }

    public static synchronized void setGlobalExtraInfo(Context context, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context == null) {
                return;
            }
            if (CooperService.instance().isCloseTrace()) {
                return;
            }
            if (a(context)) {
                return;
            }
            CooperService.instance().setHeaderExt(context, extraInfo);
            BDStatCore.instance().init(context);
        }
    }

    public static void setListName(View view2, String str) {
        if (view2 == null || CooperService.instance().isCloseTrace()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view2.setTag(-97001, str);
    }

    public static void setOaid(Context context, String str) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        bp.a().n(context, str);
    }

    public static void setPageProperty(Context context, Map<String, String> map) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        DataCore.instance().setPydProperty(context, bx.a(map), "3", "4");
        BDStatCore.instance().init(context);
    }

    public static void setSessionProperty(Context context, Map<String, String> map) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        DataCore.instance().setPydProperty(context, bx.a(map), "2", "2");
        BDStatCore.instance().init(context);
    }

    @SuppressLint({"NewApi"})
    public static void a(WebView webView) {
        int i;
        if (!CooperService.instance().isCloseTrace() && (i = Build.VERSION.SDK_INT) >= 11 && i <= 18) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }

    public static void autoTrace(Context context) {
        autoTrace(context, true, false);
    }

    public static void browseMode(boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        bu.a().c(!z);
    }

    public static void crashEnableSendLog(boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        ExceptionAnalysis.getInstance().setEnableSend(z);
    }

    public static void enableListTrack(View view2) {
        if (CooperService.instance().isCloseTrace() || view2 == null) {
            return;
        }
        view2.setTag(-97002, Boolean.TRUE);
    }

    public static String getAppKey(Context context) {
        if (CooperService.instance().isCloseTrace()) {
            return "";
        }
        return PrefOperate.getAppKey(context);
    }

    public static String getCuid(Context context) {
        if (CooperService.instance().isCloseTrace()) {
            return "";
        }
        return CooperService.instance().getCUID(context, false);
    }

    public static String getTestDeviceId(Context context) {
        if (CooperService.instance().isCloseTrace()) {
            return "";
        }
        return bw.b(context);
    }

    public static synchronized void onPause(Activity activity) {
        synchronized (StatService.class) {
            onPause(activity, null);
        }
    }

    public static void platformType(int i) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        CooperService.instance().setPlatformType(i);
    }

    @Deprecated
    public static void setAppChannel(String str) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        PrefOperate.setAppChannel(str);
    }

    public static void setAppKey(String str) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        PrefOperate.setAppKey(str);
    }

    public static void setCrashExtraInfo(String str) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        ExceptionAnalysis.getInstance().setCrashExtraInfo(str);
    }

    public static void setDebugOn(boolean z) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        bb.c().a(z);
    }

    public static void setFeedTrack(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        au.a(feedTrackStrategy);
        c = true;
    }

    public static void setLogSenderDelayed(int i) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        LogSender.instance().setLogSenderDelayed(i);
    }

    public static void setOnAppBackgroundListener(OnAppBackgroundListener onAppBackgroundListener) {
        if (CooperService.instance().isCloseTrace() || onAppBackgroundListener == null) {
            return;
        }
        bu.a().a(onAppBackgroundListener);
    }

    public static void setSessionTimeOut(int i) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        BDStatCore.instance().setSessionTimeOut(i);
    }

    public static synchronized void setStartType(boolean z) {
        synchronized (StatService.class) {
            if (CooperService.instance().isCloseTrace()) {
                return;
            }
            CooperService.instance().setStartType(z);
        }
    }

    public static void setWearListener(WearListener wearListener) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        DataCore.instance().a(wearListener);
    }

    public static void setWebViewDisableFileUrls(boolean z) {
        b = z;
    }

    public static boolean a(Context context) {
        String s = bw.s(context);
        if (!TextUtils.isEmpty(s) && s.contains("helios")) {
            return true;
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            bb c2 = bb.c();
            c2.b("[WARNING] " + str + ", context is null, invalid");
            return false;
        }
        return true;
    }

    public static boolean a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        for (int i = 2; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getMethodName().equals(str)) {
                try {
                    for (Class<?> cls2 = Class.forName(stackTraceElement.getClassName()); cls2.getSuperclass() != null && cls2.getSuperclass() != cls; cls2 = cls2.getSuperclass()) {
                    }
                    z = true;
                } catch (Exception unused) {
                }
            }
        }
        return z;
    }

    public static synchronized void onPageStart(Context context, String str) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    if (CooperService.instance().isCloseTrace()) {
                        return;
                    }
                    if (a(context)) {
                        return;
                    }
                    BDStatCore.instance().onPageStart(context, str);
                    return;
                }
            }
            bb.c().c("[WARNING] onPageStart parameter invalid");
        }
    }

    public static synchronized void onPause(Activity activity, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (!a(activity, "onPause(...)")) {
                return;
            }
            if (CooperService.instance().isCloseTrace()) {
                return;
            }
            if (!a(Activity.class, MissionEvent.MESSAGE_PAUSE)) {
                bb.c().c("[WARNING] onPause must be called in Activity.onPause");
            } else if (a(activity)) {
            } else {
                BDStatCore.instance().onPause(activity, false, extraInfo);
            }
        }
    }

    public static void setOn(Context context, int i) {
        if (!a(context, "setOn(...)") || CooperService.instance().isCloseTrace() || a || a(context)) {
            return;
        }
        a = true;
        if ((i & 1) != 0) {
            a(context, false);
        } else if ((i & 16) != 0) {
            a(context, true);
        }
        BDStatCore.instance().init(context);
    }

    public static void setUserId(Context context, String str) {
        if (CooperService.instance().isCloseTrace() || context == null || a(context)) {
            return;
        }
        CooperService.instance().setUserId(context, str);
        HashMap hashMap = new HashMap();
        hashMap.put("uid_", str);
        if (TextUtils.isEmpty(str)) {
            hashMap = null;
        }
        DataCore.instance().setPydProperty(context, bx.a(hashMap), "1", "0");
        BDStatCore.instance().init(context);
    }

    public static void setUserProperty(Context context, Map<String, String> map) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        CooperService.instance().setUserProperty(context, bx.a(map));
        DataCore.instance().setPydProperty(context, bx.a(map), "1", "1");
        BDStatCore.instance().init(context);
    }

    public static void autoTrace(Context context, boolean z, boolean z2) {
        if (!z || CooperService.instance().isCloseTrace() || !a(context, "autoTrace(...)") || a(context)) {
            return;
        }
        String appKey = CooperService.instance().getAppKey(context);
        if (TextUtils.isEmpty(appKey)) {
            bb.c().c("[WARNING] AppKey is invalid, auto trace will do not take effect");
            return;
        }
        ad.a(appKey);
        ad.a(z2);
        if (!c) {
            setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_ALL);
        }
        BDStatCore.instance().init(context);
    }

    public static synchronized void setPushId(Context context, MtjConfig.PushPlatform pushPlatform, String str) {
        synchronized (StatService.class) {
            if (context == null) {
                return;
            }
            if (CooperService.instance().isCloseTrace()) {
                return;
            }
            if (pushPlatform == null) {
                return;
            }
            if (a(context)) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 1024) {
                str = str.substring(0, 1024);
            }
            CooperService.instance().setPushId(context, pushPlatform.value(), pushPlatform.showName(), str);
            BDStatCore.instance().init(context);
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        a(context, webView, webViewClient, (WebChromeClient) null, false);
    }

    public static void onEvent(Context context, String str, String str2) {
        a(context, str, str2, null);
    }

    public static void onEventEnd(Context context, String str, String str2) {
        a(context, str, str2, (ExtraInfo) null, (Map<String, String>) null);
    }

    public static void onEventStart(Context context, String str, String str2) {
        if (!a(context, "onEventStart(...)") || CooperService.instance().isCloseTrace() || TextUtils.isEmpty(str) || a(context)) {
            return;
        }
        BDStatCore.instance().onEventStart(context.getApplicationContext(), str, str2, false);
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        if (context == null || CooperService.instance().isCloseTrace() || a(context)) {
            return;
        }
        PrefOperate.setAppChannel(context, str, z);
        BDStatCore.instance().init(context);
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i) {
        setSendLogStrategy(context, sendStrategyEnum, i, false);
    }

    public static void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        if (CooperService.instance().isCloseTrace()) {
            return;
        }
        a(context, webView, (WebViewClient) null, webChromeClient, true);
    }

    public static void onEvent(Context context, String str, String str2, int i, Map<String, String> map) {
        a(context, str, str2, i, (ExtraInfo) null, map);
    }

    public static void onEventDuration(Context context, String str, String str2, long j, Map<String, String> map) {
        a(context, str, str2, j, (ExtraInfo) null, map);
    }

    public static synchronized void onResume(Activity activity) {
        synchronized (StatService.class) {
            if (!a(activity, "onResume(...)")) {
                return;
            }
            if (CooperService.instance().isCloseTrace()) {
                return;
            }
            if (!a(Activity.class, "onResume")) {
                bb.c().c("[WARNING] onResume must be called in Activity.onResume()");
            } else if (a(activity)) {
            } else {
                BDStatCore.instance().onResume(activity, false);
            }
        }
    }

    public static void start(Context context) {
        if (!a(context, "start(...)") || CooperService.instance().isCloseTrace()) {
            return;
        }
        boolean a2 = bx.a(Application.class, "onCreate");
        if (a2) {
            bb.c().c("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
        }
        if (a(context)) {
            return;
        }
        BDStatCore.instance().onSessionStart(context, a2);
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (!a(context, "setSendLogStrategy(...)") || CooperService.instance().isCloseTrace()) {
            return;
        }
        boolean a2 = bx.a(Application.class, "onCreate");
        if (a2) {
            bb.c().c("[WARNING] setSendLogStrategy 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
        }
        if (a(context)) {
            return;
        }
        BDStatCore.instance().onSessionStart(context, a2);
        LogSender.instance().setSendLogStrategy(context.getApplicationContext(), sendStrategyEnum, i, z);
    }
}
