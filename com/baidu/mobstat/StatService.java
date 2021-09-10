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
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.BaiduStatJSInterface;
import com.baidu.mobstat.MtjConfig;
import com.baidu.mobstat.af;
import com.baidu.mobstat.av;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Map;
/* loaded from: classes5.dex */
public class StatService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f43158a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f43159b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public interface WearListener {
        boolean onSendLogData(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(402028451, "Lcom/baidu/mobstat/StatService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(402028451, "Lcom/baidu/mobstat/StatService;");
        }
    }

    public StatService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a(Class<?> cls, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, cls, str)) == null) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z = false;
            for (int i2 = 2; i2 < stackTrace.length; i2++) {
                StackTraceElement stackTraceElement = stackTrace[i2];
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
        return invokeLL.booleanValue;
    }

    public static void autoTrace(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, null, context) == null) {
            autoTrace(context, true, false);
        }
    }

    public static void bindJSInterface(Context context, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65550, null, context, webView) == null) {
            bindJSInterface(context, webView, null);
        }
    }

    public static void enableDeviceMac(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65552, null, context, z) == null) {
            CooperService.instance().enableDeviceMac(context, z);
            BDStatCore.instance().init(context);
        }
    }

    public static void enableListTrack(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65553, null, view) == null) || view == null) {
            return;
        }
        view.setTag(-97002, Boolean.TRUE);
    }

    public static String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? PrefOperate.getAppKey(context) : (String) invokeL.objValue;
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65555, null)) == null) ? CooperService.instance().getMTJSDKVersion() : (String) invokeV.objValue;
    }

    public static String getTestDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65556, null, context)) == null) ? bw.b(context) : (String) invokeL.objValue;
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65557, null, context, str, str2, str3) == null) && a(context, "onErised(...)")) {
            if (str != null && !"".equals(str)) {
                BDStatCore.instance().onErised(context, str, str2, str3);
            } else {
                bc.c().c("[WARNING] AppKey is invalid");
            }
        }
    }

    public static void onEvent(Context context, String str, String str2, int i2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65560, null, new Object[]{context, str, str2, Integer.valueOf(i2), map}) == null) {
            a(context, str, str2, i2, (ExtraInfo) null, map);
        }
    }

    public static void onEventDuration(Context context, String str, String str2, long j2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65562, null, new Object[]{context, str, str2, Long.valueOf(j2), map}) == null) {
            a(context, str, str2, j2, (ExtraInfo) null, map);
        }
    }

    public static void onEventEnd(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65563, null, context, str, str2) == null) {
            a(context, str, str2, (ExtraInfo) null, (Map<String, String>) null);
        }
    }

    public static void onEventStart(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65565, null, context, str, str2) == null) && a(context, "onEventStart(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventStart(context.getApplicationContext(), str, str2, false);
        }
    }

    public static synchronized void onPageEnd(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65566, null, context, str) == null) {
            synchronized (StatService.class) {
                a(context, str, null);
            }
        }
    }

    public static synchronized void onPageStart(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65567, null, context, str) == null) {
            synchronized (StatService.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        BDStatCore.instance().onPageStart(context, str);
                        return;
                    }
                }
                bc.c().c("[WARNING] onPageStart parameter invalid");
            }
        }
    }

    public static synchronized void onPause(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65568, null, activity) == null) {
            synchronized (StatService.class) {
                onPause(activity, null);
            }
        }
    }

    public static synchronized void onResume(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65570, null, activity) == null) {
            synchronized (StatService.class) {
                if (a(activity, "onResume(...)")) {
                    if (!a(Activity.class, "onResume")) {
                        bc.c().c("[WARNING] onResume must be called in Activity.onResume()");
                    } else {
                        BDStatCore.instance().onResume(activity, false);
                    }
                }
            }
        }
    }

    public static void recordException(Context context, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65571, null, context, th) == null) || context == null || th == null) {
            return;
        }
        ExceptionAnalysis.getInstance().saveCrashInfo(context, th, false);
    }

    @Deprecated
    public static void setAppChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65573, null, str) == null) {
            PrefOperate.setAppChannel(str);
        }
    }

    public static void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, str) == null) {
            PrefOperate.setAppKey(str);
        }
    }

    public static void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65575, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        CooperService.instance().setAppVersionName(context, str);
    }

    public static void setAttributes(View view, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65576, null, view, map) == null) || view == null) {
            return;
        }
        view.setTag(-96000, map);
    }

    public static void setContentId(View view, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65577, null, view, str) == null) || view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view.setTag(-97004, str);
    }

    public static void setContentTitle(View view, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65578, null, view, str) == null) || view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view.setTag(-97003, str);
    }

    public static void setCrashExtraInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65579, null, str) == null) {
            ExceptionAnalysis.getInstance().setCrashExtraInfo(str);
        }
    }

    public static void setDebugOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65580, null, z) == null) {
            bc.c().a(z);
        }
    }

    public static void setFeedTrack(MtjConfig.FeedTrackStrategy feedTrackStrategy) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65581, null, feedTrackStrategy) == null) {
            av.a(feedTrackStrategy);
            f43159b = true;
        }
    }

    public static void setForTv(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65582, null, context, z) == null) {
            bq.a().c(context, z);
            BDStatCore.instance().init(context);
        }
    }

    public static synchronized void setGlobalExtraInfo(Context context, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65583, null, context, extraInfo) == null) {
            synchronized (StatService.class) {
                if (context == null) {
                    return;
                }
                CooperService.instance().setHeaderExt(context, extraInfo);
                BDStatCore.instance().init(context);
            }
        }
    }

    public static void setListName(View view, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65584, null, view, str) == null) || view == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        view.setTag(-97001, str);
    }

    public static void setLogSenderDelayed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65585, null, i2) == null) {
            LogSender.instance().setLogSenderDelayed(i2);
        }
    }

    public static void setOn(Context context, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(65586, null, context, i2) == null) && a(context, "setOn(...)") && !f43158a) {
            f43158a = true;
            if ((i2 & 1) != 0) {
                a(context, false);
            } else if ((i2 & 16) != 0) {
                a(context, true);
            }
            BDStatCore.instance().init(context);
        }
    }

    public static synchronized void setPushId(Context context, MtjConfig.PushPlatform pushPlatform, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65587, null, context, pushPlatform, str) == null) {
            synchronized (StatService.class) {
                if (context == null) {
                    return;
                }
                if (pushPlatform == null) {
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
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65589, null, new Object[]{context, sendStrategyEnum, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && a(context, "setSendLogStrategy(...)")) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] setSendLogStrategy 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
            LogSender.instance().setSendLogStrategy(context.getApplicationContext(), sendStrategyEnum, i2, z);
        }
    }

    public static void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65590, null, i2) == null) {
            BDStatCore.instance().setSessionTimeOut(i2);
        }
    }

    public static synchronized void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65591, null, z) == null) {
            synchronized (StatService.class) {
                CooperService.instance().setStartType(z);
            }
        }
    }

    public static void setUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65592, null, context, str) == null) || context == null) {
            return;
        }
        CooperService.instance().setUserId(context, str);
        BDStatCore.instance().init(context);
    }

    public static void start(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65593, null, context) == null) && a(context, "start(...)")) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onSessionStart(context, a2);
        }
    }

    public static void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65594, null, context, webView, webChromeClient) == null) {
            a(context, webView, (WebViewClient) null, webChromeClient, true);
        }
    }

    public static void autoTrace(Context context, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{context, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && z && a(context, "autoTrace(...)")) {
            String appKey = CooperService.instance().getAppKey(context);
            if (TextUtils.isEmpty(appKey)) {
                bc.c().c("[WARNING] AppKey is invalid, auto trace will do not take effect");
                return;
            }
            af.a(appKey);
            af.a(z2);
            if (!f43159b) {
                setFeedTrack(MtjConfig.FeedTrackStrategy.TRACK_ALL);
            }
            BDStatCore.instance().init(context);
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65551, null, context, webView, webViewClient) == null) {
            a(context, webView, webViewClient, (WebChromeClient) null, false);
        }
    }

    public static void onEvent(Context context, String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(65559, null, context, str, str2, i2) == null) {
            a(context, str, str2, i2, (ExtraInfo) null, (Map<String, String>) null);
        }
    }

    public static void onEventDuration(Context context, String str, String str2, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65561, null, new Object[]{context, str, str2, Long.valueOf(j2)}) == null) {
            a(context, str, str2, j2, (ExtraInfo) null, (Map<String, String>) null);
        }
    }

    public static void onEventEnd(Context context, String str, String str2, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65564, null, context, str, str2, map) == null) {
            a(context.getApplicationContext(), str, str2, (ExtraInfo) null, map);
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65572, null, context, str, z) == null) {
            PrefOperate.setAppChannel(context, str, z);
            BDStatCore.instance().init(context);
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65558, null, context, str, str2) == null) {
            a(context, str, str2, null);
        }
    }

    public static synchronized void onPause(Activity activity, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65569, null, activity, extraInfo) == null) {
            synchronized (StatService.class) {
                if (a(activity, "onPause(...)")) {
                    if (!a(Activity.class, MissionEvent.MESSAGE_PAUSE)) {
                        bc.c().c("[WARNING] onPause must be called in Activity.onPause");
                    } else {
                        BDStatCore.instance().onPause(activity, false, extraInfo);
                    }
                }
            }
        }
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65588, null, context, sendStrategyEnum, i2) == null) {
            setSendLogStrategy(context, sendStrategyEnum, i2, false);
        }
    }

    public static synchronized void a(Context context, String str, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65539, null, context, str, extraInfo) == null) {
            synchronized (StatService.class) {
                if (context != null) {
                    if (!TextUtils.isEmpty(str)) {
                        BDStatCore.instance().onPageEnd(context, str, extraInfo);
                        return;
                    }
                }
                bc.c().c("[WARNING] onPageEnd parameter invalid");
            }
        }
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65544, null, context, z) == null) && a(context, "onError(...)")) {
            BDStatCore.instance().init(context);
            ExceptionAnalysis.getInstance().openExceptionAnalysis(context.getApplicationContext(), z);
        }
    }

    public static void a(Context context, String str, String str2, int i2, ExtraInfo extraInfo, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, str, str2, Integer.valueOf(i2), extraInfo, map}) == null) && a(context, "onEvent(...)") && !TextUtils.isEmpty(str)) {
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] onEvent 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onEvent(context.getApplicationContext(), str, str2, i2, extraInfo, bx.a(map), a2);
        }
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, str, str2, extraInfo) == null) {
            a(context, str, str2, 1, extraInfo, (Map<String, String>) null);
        }
    }

    public static void a(Context context, String str, String str2, ExtraInfo extraInfo, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLLL(65543, null, context, str, str2, extraInfo, map) == null) && a(context, "onEventEnd(...)") && !TextUtils.isEmpty(str)) {
            BDStatCore.instance().onEventEnd(context.getApplicationContext(), str, str2, extraInfo, bx.a(map));
        }
    }

    public static void a(Context context, String str, String str2, long j2, ExtraInfo extraInfo, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, str, str2, Long.valueOf(j2), extraInfo, map}) == null) && a(context, "onEventDuration(...)") && !TextUtils.isEmpty(str)) {
            if (j2 <= 0) {
                bc.c().b("[WARNING] onEventDuration duration must be greater than zero");
                return;
            }
            boolean a2 = bx.a(Application.class, "onCreate");
            if (a2) {
                bc.c().c("[WARNING] onEventDuration 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            BDStatCore.instance().onEventDuration(context.getApplicationContext(), str, str2, j2, extraInfo, bx.a(map), a2);
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, context, str)) == null) {
            if (context == null) {
                bc c2 = bc.c();
                c2.b("[WARNING] " + str + ", context is null, invalid");
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @SuppressLint({"NewApi"})
    public static void a(WebView webView) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, null, webView) == null) || (i2 = Build.VERSION.SDK_INT) < 11 || i2 > 18) {
            return;
        }
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void a(Context context, WebView webView, WebViewClient webViewClient, WebChromeClient webChromeClient, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, webView, webViewClient, webChromeClient, Boolean.valueOf(z)}) == null) {
            if (context == null) {
                bc.c().c("[WARNING] context is null, invalid");
            } else if (webView == null) {
                bc.c().c("[WARNING] webview is null, invalid");
            } else {
                a(webView);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDefaultTextEncodingName("UTF-8");
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                if (!z) {
                    webView.setWebViewClient(new BaiduStatJSInterface.CustomWebViewClient(context, webViewClient, null, null));
                } else {
                    bl blVar = new bl();
                    webView.addJavascriptInterface(blVar, "WebViewInterface");
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new af.b());
                    arrayList.add(new av.b());
                    BaiduStatJSInterface.CustomWebChromeViewClient customWebChromeViewClient = new BaiduStatJSInterface.CustomWebChromeViewClient(context, webChromeClient, arrayList, blVar);
                    webView.setWebChromeClient(customWebChromeViewClient);
                    webView.setTag(-96001, customWebChromeViewClient);
                }
                BDStatCore.instance().init(context);
            }
        }
    }
}
