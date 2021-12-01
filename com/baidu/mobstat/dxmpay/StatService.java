package com.baidu.mobstat.dxmpay;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobstat.dxmpay.BaiduStatJSInterface;
import com.baidu.mobstat.dxmpay.MtjConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes8.dex */
public class StatService {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int EXCEPTION_LOG = 1;
    public static final int JAVA_EXCEPTION_LOG = 16;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public interface OnZidReceiveListener {
        String getZid();
    }

    /* loaded from: classes8.dex */
    public interface WearListener {
        boolean onSendLogData(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1678189551, "Lcom/baidu/mobstat/dxmpay/StatService;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1678189551, "Lcom/baidu/mobstat/dxmpay/StatService;");
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

    public static boolean a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            String k2 = w.k(context);
            return !TextUtils.isEmpty(k2) && k2.contains("helios");
        }
        return invokeL.booleanValue;
    }

    public static void bindJSInterface(Context context, WebView webView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, context, webView) == null) {
            bindJSInterface(context, webView, null);
        }
    }

    public static void crashEnableSendLog(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65545, null, z) == null) {
            ExceptionAnalysis.getInstance().setEnableSend(z);
        }
    }

    public static String getAppKey(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) ? PrefOperate.getAppKey(context) : (String) invokeL.objValue;
    }

    public static String getCuid(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) ? CooperService.instance().getCUID(context, false) : (String) invokeL.objValue;
    }

    public static String getSdkVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? CooperService.instance().getMTJSDKVersion() : (String) invokeV.objValue;
    }

    public static String getTestDeviceId(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, context)) == null) ? w.b(context) : (String) invokeL.objValue;
    }

    public static void onErised(Context context, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(65550, null, context, str, str2, str3) == null) && a(context, "onErised(...)")) {
            if (str != null && !"".equals(str)) {
                BDStatCore.instance().onErised(context, str, str2, str3);
            } else {
                h.c().c("[WARNING] AppKey is invalid");
            }
        }
    }

    public static void recordException(Context context, Throwable th) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65551, null, context, th) == null) || context == null || th == null) {
            return;
        }
        ExceptionAnalysis.getInstance().saveCrashInfo(context, th, false);
    }

    public static void sendLogData(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65552, null, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        LogSender.instance().sendLogData(context.getApplicationContext(), str, false);
    }

    @Deprecated
    public static void setAppChannel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, null, str) == null) {
            PrefOperate.setAppChannel(str);
        }
    }

    public static void setAppKey(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, null, str) == null) {
            PrefOperate.setAppKey(str);
        }
    }

    public static void setAppVersionName(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65556, null, context, str) == null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.length() > 256) {
            str = str.substring(0, 256);
        }
        CooperService.instance().setAppVersionName(context, str);
    }

    public static void setAuthorizedState(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65557, null, context, z) == null) {
            CooperService.instance().setAuthorizedState(z);
            BDStatCore.instance().setAuthorizedState(context, z);
        }
    }

    public static void setCrashExtraInfo(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, null, str) == null) {
            ExceptionAnalysis.getInstance().setCrashExtraInfo(str);
        }
    }

    public static void setDebugOn(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65559, null, z) == null) {
            h.c().a(z);
        }
    }

    public static void setEnableBackgroundSendLog(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65560, null, context, z) == null) {
            BDStatCore.instance().setAutoSendLog(context, z);
        }
    }

    public static void setFilterPackageList(List<String> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65561, null, list) == null) || list == null || list.size() <= 0) {
            return;
        }
        ExceptionAnalysis.getInstance().setFilterPackageList(list);
    }

    public static void setForTv(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(65562, null, context, z) == null) || context == null || a(context)) {
            return;
        }
        q.a().c(context, z);
        BDStatCore.instance().init(context);
    }

    public static synchronized void setGlobalExtraInfo(Context context, ExtraInfo extraInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65563, null, context, extraInfo) == null) {
            synchronized (StatService.class) {
                if (context == null) {
                    return;
                }
                if (a(context)) {
                    return;
                }
                CooperService.instance().setHeaderExt(context, extraInfo);
                BDStatCore.instance().init(context);
            }
        }
    }

    public static void setLogSenderDelayed(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65564, null, i2) == null) {
            LogSender.instance().setLogSenderDelayed(i2);
        }
    }

    public static void setOaid(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65565, null, context, str) == null) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            q.a().k(context, str);
        }
    }

    public static void setOn(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65566, null, context, i2) == null) || !a(context, "setOn(...)") || a || a(context)) {
            return;
        }
        a = true;
        if ((i2 & 1) != 0) {
            a(context, false);
        } else if ((i2 & 16) != 0) {
            a(context, true);
        }
        BDStatCore.instance().init(context);
    }

    public static synchronized void setPushId(Context context, MtjConfig.PushPlatform pushPlatform, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65567, null, context, pushPlatform, str) == null) {
            synchronized (StatService.class) {
                if (context == null) {
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
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65569, null, new Object[]{context, sendStrategyEnum, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && a(context, "setSendLogStrategy(...)")) {
            boolean a2 = x.a(Application.class, "onCreate");
            if (a2) {
                h.c().c("[WARNING] setSendLogStrategy 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            if (a(context)) {
                return;
            }
            BDStatCore.instance().onSessionStart(context, a2);
            LogSender.instance().setSendLogStrategy(context.getApplicationContext(), sendStrategyEnum, i2, z);
        }
    }

    public static void setSessionTimeOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65570, null, i2) == null) {
            BDStatCore.instance().setSessionTimeOut(i2);
        }
    }

    public static synchronized void setStartType(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65571, null, z) == null) {
            synchronized (StatService.class) {
                CooperService.instance().setStartType(z);
            }
        }
    }

    public static void setUserId(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65572, null, context, str) == null) || context == null || a(context)) {
            return;
        }
        CooperService.instance().setUserId(context, str);
        BDStatCore.instance().init(context);
    }

    public static void setUserProperty(Context context, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65573, null, context, map) == null) || context == null || a(context)) {
            return;
        }
        CooperService.instance().setUserProperty(context, x.a(map));
        BDStatCore.instance().init(context);
    }

    public static void setWearListener(WearListener wearListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65574, null, wearListener) == null) {
            DataCore.instance().a(wearListener);
        }
    }

    public static void start(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65575, null, context) == null) && a(context, "start(...)")) {
            boolean a2 = x.a(Application.class, "onCreate");
            if (a2) {
                h.c().c("[WARNING] start 方法被 Application.onCreate()调用，not a good practice; 可能由于多进程反复重启等原因造成Application.onCreate() 方法多次被执行，导致启动次数高；建议埋点在统计路径触发的第一个页面中，比如APP主页面中");
            }
            if (a(context)) {
                return;
            }
            BDStatCore.instance().onSessionStart(context, a2);
        }
    }

    public static void trackWebView(Context context, WebView webView, WebChromeClient webChromeClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65576, null, context, webView, webChromeClient) == null) {
        }
    }

    @SuppressLint({"NewApi", "SetJavaScriptEnabled"})
    public static void bindJSInterface(Context context, WebView webView, WebViewClient webViewClient) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65544, null, context, webView, webViewClient) == null) {
            a(context, webView, webViewClient, null, false);
        }
    }

    public static void setAppChannel(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65553, null, context, str, z) == null) || context == null || a(context)) {
            return;
        }
        PrefOperate.setAppChannel(context, str, z);
        BDStatCore.instance().init(context);
    }

    public static void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65539, null, context, z) == null) && a(context, "onError(...)") && !a(context)) {
            BDStatCore.instance().init(context);
            ExceptionAnalysis.getInstance().openExceptionAnalysis(context.getApplicationContext(), z);
        }
    }

    public static boolean a(Context context, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, context, str)) == null) {
            if (context == null) {
                h c2 = h.c();
                c2.b("[WARNING] " + str + ", context is null, invalid");
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Deprecated
    public static void setSendLogStrategy(Context context, SendStrategyEnum sendStrategyEnum, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65568, null, context, sendStrategyEnum, i2) == null) {
            setSendLogStrategy(context, sendStrategyEnum, i2, false);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(WebView webView) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, webView) == null) || (i2 = Build.VERSION.SDK_INT) < 11 || i2 > 18) {
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
                h.c().c("[WARNING] context is null, invalid");
            } else if (webView == null) {
                h.c().c("[WARNING] webview is null, invalid");
            } else if (a(context)) {
            } else {
                a(webView);
                WebSettings settings = webView.getSettings();
                settings.setJavaScriptEnabled(true);
                settings.setDefaultTextEncodingName("UTF-8");
                settings.setJavaScriptCanOpenWindowsAutomatically(true);
                if (!z) {
                    webView.setWebViewClient(new BaiduStatJSInterface.CustomWebViewClient(context, webViewClient, null, null));
                } else {
                    l lVar = new l();
                    webView.addJavascriptInterface(lVar, "WebViewInterface");
                    BaiduStatJSInterface.CustomWebChromeViewClient customWebChromeViewClient = new BaiduStatJSInterface.CustomWebChromeViewClient(context, webChromeClient, new ArrayList(), lVar);
                    webView.setWebChromeClient(customWebChromeViewClient);
                    webView.setTag(-96001, customWebChromeViewClient);
                }
                BDStatCore.instance().init(context);
            }
        }
    }
}
