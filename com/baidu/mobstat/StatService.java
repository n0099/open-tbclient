package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.baidu.mobstat.BaiduStatJSInterface;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.am;
import com.baidu.mobstat.bc;
import java.util.ArrayList;
import java.util.Map;
import org.apache.http.protocol.HTTP;
/* loaded from: classes6.dex */
public class StatService {
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;
    private static boolean a = false;
    private static boolean b;

    /* loaded from: classes6.dex */
    public interface WearListener {
        boolean onSendLogData(String str);
    }

    private static boolean a(Class<?> cls, String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        for (int i = 2; i < stackTrace.length; i++) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.getMethodName().equals(str)) {
                try {
                    for (Class<?> cls2 = Class.forName(stackTraceElement.getClassName()); cls2.getSuperclass() != null && cls2.getSuperclass() != cls; cls2 = cls2.getSuperclass()) {
                    }
                    z = true;
                } catch (Exception e) {
                }
            }
        }
        return z;
    }

    public static void enableDeviceMac(Context context, boolean z) {
        CooperService.instance().enableDeviceMac(context, z);
        BDStatCore.instance().init(context);
    }

    public static synchronized void setGlobalExtraInfo(Context context, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context != null) {
                CooperService.instance().setHeaderExt(context, extraInfo);
                BDStatCore.instance().init(context);
            }
        }
    }

    public static synchronized void onResume(Activity activity) {
        synchronized (StatService.class) {
            if (a(activity, "onResume(...)")) {
                if (!a(Activity.class, "onResume")) {
                    bj.c().c("[WARNING] onResume must be called in Activity.onResume()");
                } else {
                    BDStatCore.instance().onResume(activity, false);
                }
            }
        }
    }

    @Deprecated
    public static synchronized void onResume(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                bj.c().c("[WARNING] onResume parameter invalid");
            } else if (!a(Fragment.class, "onResume")) {
                bj.c().c("[WARNING] onResume must be called in Fragment.onResume()");
            } else if (fragment.getActivity() == null) {
                bj.c().c("[WARNING] can not get FragmentActivity, fragment may not attached to activity");
            } else {
                BDStatCore.instance().onResume(fragment);
            }
        }
    }

    @TargetApi(11)
    @Deprecated
    public static synchronized void onResume(android.app.Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                bj.c().c("[WARNING] onResume parameter invalid");
            } else if (!a(fragment.getClass(), "onResume")) {
                bj.c().c("[WARNING] onResume must be called in Fragment.onResume()");
            } else if (fragment.getActivity() == null) {
                bj.c().c("[WARNING] can not get Activity, fragment may not attached to activity");
            } else {
                BDStatCore.instance().onResume(fragment);
            }
        }
    }

    public static synchronized void onPageStart(Context context, String str) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    BDStatCore.instance().onPageStart(context, str);
                }
            }
            bj.c().c("[WARNING] onPageStart parameter invalid");
        }
    }

    private static synchronized void a(Context context, String str, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    BDStatCore.instance().onPageEnd(context, str, extraInfo);
                }
            }
            bj.c().c("[WARNING] onPageEnd parameter invalid");
        }
    }

    public static synchronized void onPageEnd(Context context, String str) {
        synchronized (StatService.class) {
            a(context, str, null);
        }
    }

    public static synchronized void onPause(Activity activity, ExtraInfo extraInfo) {
        synchronized (StatService.class) {
            if (a(activity, "onPause(...)")) {
                if (!a(Activity.class, "onPause")) {
                    bj.c().c("[WARNING] onPause must be called in Activity.onPause");
                } else {
                    BDStatCore.instance().onPause(activity, false, extraInfo);
                }
            }
        }
    }

    public static synchronized void onPause(Activity activity) {
        synchronized (StatService.class) {
            onPause(activity, null);
        }
    }

    @Deprecated
    public static synchronized void onPause(Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                bj.c().c("[WARNING] onPause parameter invalid");
            } else if (!a(Fragment.class, "onPause")) {
                bj.c().c("[WARNING] onPause must be called in Fragment.onPause()");
            } else {
                BDStatCore.instance().onPause(fragment);
            }
        }
    }

    @TargetApi(11)
    @Deprecated
    public static synchronized void onPause(android.app.Fragment fragment) {
        synchronized (StatService.class) {
            if (fragment == null) {
                bj.c().c("[WARNING] onPause parameter invalid");
            } else if (!a(fragment.getClass(), "onPause")) {
                bj.c().c("[WARNING] onPause must be called in android.app.Fragment.onPause()");
            } else {
                BDStatCore.instance().onPause(fragment);
            }
        }
    }

    public static void setOn(Context context, int i) {
        if (a(context, "setOn(...)") && !a) {
            a = true;
            if ((i & 1) != 0) {
                a(context, false);
            } else if ((i & 16) != 0) {
                a(context, true);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static void start(Context context) {
        if (a(context, "start(...)")) {
            boolean a2 = cd.a(Application.class, "onCreate");
            if (a2) {
                bj.c().c("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i, boolean z) {
        if (a(context, "setSendLogStrategy(...)")) {
            boolean a2 = cd.a(Application.class, "onCreate");
            if (a2) {
                bj.c().c("[WARNING] setSendLogStrategy 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
            LogSender.instance().setSendLogStrategy(context.getApplicationContext(), sendStrategyEnum, i, z);
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i) {
        setSendLogStrategy(context, sendStrategyEnum, i, false);
    }

    private static void a(Context context, boolean z) {
        if (a(context, "onError(...)")) {
            BDStatCore.instance().init(context);
            ExceptionAnalysis.getInstance().openExceptionAnalysis(context.getApplicationContext(), z);
        }
    }

    private static void a(Context context, String str, String str2, int i, ExtraInfo extraInfo, Map<String, String> map) {
        if (a(context, "onEvent(...)") && !TextUtils.isEmpty(str)) {
            boolean a2 = cd.a(Application.class, "onCreate");
            if (a2) {
                bj.c().c("[WARNING] onEvent 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onEvent(context.getApplicationContext(), str, str2, i, extraInfo, cd.a(map), a2);
        }
    }

    public static void onEvent(Context context, String str, String str2, int i, Map<String, String> map) {
        a(context, str, str2, i, (ExtraInfo) null, map);
    }

    public static void onEvent(Context context, String str, String str2, int i) {
        a(context, str, str2, i, (ExtraInfo) null, (Map<String, String>) null);
    }

    private static void a(Context context, String str, String str2, ExtraInfo extraInfo) {
        a(context, str, str2, 1, extraInfo, (Map<String, String>) null);
    }

    public static void onEvent(Context context, String str, String str2) {
        a(context, str, str2, null);
    }

    public static void onEventStart(Context context, String str, String str2) {
        if (a(context, "onEventStart(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventStart(context.getApplicationContext(), str, str2, false);
        }
    }

    public static void onEventEnd(Context context, String str, String str2) {
        a(context, str, str2, (ExtraInfo) null, (Map<String, String>) null);
    }

    public static void onEventEnd(Context context, String str, String str2, Map<String, String> map) {
        a(context.getApplicationContext(), str, str2, (ExtraInfo) null, map);
    }

    private static void a(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        if (a(context, "onEventEnd(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventEnd(context.getApplicationContext(), str, str2, extraInfo, cd.a(map));
        }
    }

    private static void a(Context context, String str, String str2, long j, ExtraInfo extraInfo, Map<String, String> map) {
        if (a(context, "onEventDuration(...)") && !TextUtils.isEmpty(str)) {
            if (j <= 0) {
                bj.c().b("[WARNING] onEventDuration duration must be greater than zero");
                return;
            }
            boolean a2 = cd.a(Application.class, "onCreate");
            if (a2) {
                bj.c().c("[WARNING] onEventDuration 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onEventDuration(context.getApplicationContext(), str, str2, j, extraInfo, cd.a(map), a2);
        }
    }

    public static void onEventDuration(Context context, String str, String str2, long j, Map<String, String> map) {
        a(context, str, str2, j, (ExtraInfo) null, map);
    }

    public static void onEventDuration(Context context, String str, String str2, long j) {
        a(context, str, str2, j, (ExtraInfo) null, (Map<String, String>) null);
    }

    private static boolean a(Context context, String str) {
        if (context == null) {
            bj.c().b("[WARNING] " + str + ", context is null, invalid");
            return false;
        }
        return true;
    }

    public static void setAppKey(String str) {
        PrefOperate.setAppKey(str);
    }

    public static String getAppKey(Context context) {
        return PrefOperate.getAppKey(context);
    }

    @Deprecated
    public static void setAppChannel(String str) {
        PrefOperate.setAppChannel(str);
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        PrefOperate.setAppChannel(context, str, z);
        BDStatCore.instance().init(context);
    }

    public static void setLogSenderDelayed(int i) {
        LogSender.instance().setLogSenderDelayed(i);
    }

    public static void setSessionTimeOut(int i) {
        BDStatCore.instance().setSessionTimeOut(i);
    }

    public static void setDebugOn(boolean z) {
        bj.c().a(z);
    }

    public static void setForTv(Context context, boolean z) {
        BasicStoreTools.getInstance().setForTV(context, z);
        BDStatCore.instance().init(context);
    }

    @SuppressLint({"NewApi"})
    private static void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 18) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }

    public static void bindJSInterface(Context context, WebView webView) {
        bindJSInterface(context, webView, null);
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        a(context, webView, webViewClient, (WebChromeClient) null, false);
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    private static void a(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z) {
        if (context == null) {
            bj.c().c("[WARNING] context is null, invalid");
        } else if (webView == null) {
            bj.c().c("[WARNING] webview is null, invalid");
        } else {
            a(webView);
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDefaultTextEncodingName(HTTP.UTF_8);
            settings.setJavaScriptCanOpenWindowsAutomatically(true);
            if (!z) {
                webView.setWebViewClient(new BaiduStatJSInterface.CustomWebViewClient(context, webViewClient, null, null));
            } else {
                bs bsVar = new bs();
                webView.addJavascriptInterface(bsVar, "WebViewInterface");
                ArrayList arrayList = new ArrayList();
                arrayList.add(new am.b());
                arrayList.add(new bc.b());
                WebChromeClient customWebChromeViewClient = new BaiduStatJSInterface.CustomWebChromeViewClient(context, webChromeClient, arrayList, bsVar);
                webView.setWebChromeClient(customWebChromeViewClient);
                webView.setTag(-96001, customWebChromeViewClient);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static String getTestDeviceId(Context context) {
        return cc.b(context);
    }

    public static String getSdkVersion() {
        return CooperService.instance().getMTJSDKVersion();
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        if (a(context, "onErised(...)")) {
            if (str == null || "".equals(str)) {
                bj.c().c("[WARNING] AppKey is invalid");
            } else {
                BDStatCore.instance().onErised(context, str, str2, str3);
            }
        }
    }

    public static void autoTrace(Context context) {
        autoTrace(context, true, false);
    }

    public static void autoTrace(Context context, boolean z, boolean z2) {
        if (z && a(context, "autoTrace(...)")) {
            String appKey = CooperService.instance().getAppKey(context);
            if (TextUtils.isEmpty(appKey)) {
                bj.c().c("[WARNING] AppKey is invalid, auto trace will do not take effect");
                return;
            }
            am.a(appKey);
            am.a(z2);
            if (!b) {
                setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_ALL);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static void setAttributes(View view, Map<String, String> map) {
        if (view != null) {
            view.setTag(-96000, map);
        }
    }

    public static void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        a(context, webView, (WebViewClient) null, webChromeClient, true);
    }

    public static void setUserId(Context context, String str) {
        if (context != null) {
            CooperService.instance().setUserId(context, str);
            BDStatCore.instance().init(context);
        }
    }

    public static void recordException(Context context, Throwable th) {
        if (context != null && th != null) {
            ExceptionAnalysis.getInstance().saveCrashInfo(context, th, false);
        }
    }

    public static void setListName(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97001, str);
        }
    }

    public static void setContentTitle(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97003, str);
        }
    }

    public static void setContentId(View view, String str) {
        if (view != null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            view.setTag(-97004, str);
        }
    }

    public static void setFeedTrack(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        bc.a(feedTrackStrategy);
        b = true;
    }

    public static void enableListTrack(View view) {
        if (view != null) {
            view.setTag(-97002, true);
        }
    }

    public static void setAppVersionName(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            CooperService.instance().setAppVersionName(context, str);
        }
    }

    public static synchronized void setPushId(Context context, MtjConfig.PushPlatform pushPlatform, String str) {
        synchronized (StatService.class) {
            if (context != null && pushPlatform != null) {
                String str2 = TextUtils.isEmpty(str) ? "" : str;
                if (str2.length() > 1024) {
                    str2 = str2.substring(0, 1024);
                }
                CooperService.instance().setPushId(context, pushPlatform.value(), pushPlatform.showName(), str2);
                BDStatCore.instance().init(context);
            }
        }
    }
}
