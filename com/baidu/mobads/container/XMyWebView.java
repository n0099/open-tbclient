package com.baidu.mobads.container;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.ReflectionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class XMyWebView extends XSafeWebView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String curUrl;
    public boolean isDestroy;
    public boolean isScrollX;
    public boolean isScrollY;
    public KeyDownListener mKeyDownListener;

    /* loaded from: classes5.dex */
    public static class C {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String SEP = ",";
        public static String[] audios = null;
        public static String[] downloads = null;
        public static final String http = "http,https";
        public static String[] httpSchemes = null;
        public static final String[] mailSchemes;
        public static String[] schemes = null;
        public static final String sms = "sms,smsto,mms";
        public static String[] smsSchemes;
        public static final String[] telSchemes;
        public static String[] videos;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1834139176, "Lcom/baidu/mobads/container/XMyWebView$C;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1834139176, "Lcom/baidu/mobads/container/XMyWebView$C;");
                    return;
                }
            }
            downloads = "zip,rar,7z,tar.gz,bz".split(",");
            videos = "mp4,3gp,3g2,avi,rm,rmvb,wmv,flv,mkv,mov,asf,asx".split(",");
            audios = "mp3,ra,wma,m4a,wav,aac,mmf,amr,ogg,adp".split(",");
            smsSchemes = sms.split(",");
            telSchemes = new String[]{"tel"};
            mailSchemes = new String[]{"mailto"};
            httpSchemes = http.split(",");
            schemes = "http,https,sms,smsto,mms,tel,fax,ftp,mailto,gopher,news,telnet,file".split(",");
        }

        public C() {
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

        public static void out(RemoteXAdLogger remoteXAdLogger) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65553, null, remoteXAdLogger) == null) {
                remoteXAdLogger.d(u(downloads));
                remoteXAdLogger.d(u(videos));
                remoteXAdLogger.d(u(audios));
                remoteXAdLogger.d(u(smsSchemes));
                remoteXAdLogger.d(u(httpSchemes));
                remoteXAdLogger.d(u(schemes));
            }
        }

        public static String u(String[] strArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65554, null, strArr)) == null) {
                StringBuilder sb = new StringBuilder();
                for (String str : strArr) {
                    sb.append(str);
                    sb.append(',');
                }
                return sb.toString();
            }
            return (String) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public interface KeyDownListener {
        boolean onKeyDown(int i2, KeyEvent keyEvent);
    }

    /* loaded from: classes5.dex */
    public static class ParameterInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCloseHardwareAccelerated;

        public ParameterInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mCloseHardwareAccelerated = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(19)
    public XMyWebView(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2, ParameterInfo parameterInfo) {
        super(context, remoteXAdLogger);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, remoteXAdLogger, Boolean.valueOf(z), Boolean.valueOf(z2), parameterInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (RemoteXAdLogger) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.curUrl = "";
        this.isDestroy = false;
        this.isScrollY = true;
        this.isScrollX = true;
        setClickable(true);
        setBackgroundColor(0);
        setFocusable(z2);
        setScrollBarStyle(0);
        WebSettings settings = getSettings();
        if (Build.VERSION.SDK_INT >= 17) {
            settings.setMediaPlaybackRequiresUserGesture(false);
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                settings.setSafeBrowsingEnabled(false);
            }
        } catch (Throwable unused) {
        }
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setNeedInitialFocus(false);
        settings.setSavePassword(false);
        settings.setAllowFileAccess(true);
        String path = context.getApplicationContext().getDir("database", 0).getPath();
        try {
            settings.setDomStorageEnabled(true);
            settings.setDatabaseEnabled(true);
            settings.setDatabasePath(path);
            this.mAdLogger.d("MyWebView", "setDomStorageEnabled");
        } catch (Exception unused2) {
            this.mAdLogger.d("API 7, LocalStorage/SessionStorage");
        }
        try {
            settings.setAppCacheEnabled(true);
            settings.setAppCachePath(path);
            settings.setAppCacheMaxSize(5242880L);
            this.mAdLogger.d("MyWebView", "Application Storage");
        } catch (Exception unused3) {
            this.mAdLogger.d("API 7, Application Storage");
        }
        try {
            settings.setGeolocationEnabled(true);
            settings.setGeolocationDatabasePath(path);
            this.mAdLogger.d("MyWebView", "Geolocation");
        } catch (Exception unused4) {
            this.mAdLogger.d("API 5, Geolocation");
        }
        try {
            WebView.setWebContentsDebuggingEnabled(true);
            if (Build.VERSION.SDK_INT >= 19) {
                String userAgentString = settings.getUserAgentString();
                settings.setUserAgentString(userAgentString + " Mobads");
            }
        } catch (Exception unused5) {
            this.mAdLogger.d("API 19, open debug");
        }
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                settings.setMixedContentMode(0);
            }
        } catch (Throwable unused6) {
            this.mAdLogger.d("API 21, setMix");
        }
        setWebViewClient(new XMyWebViewClient());
        setWebChromeClient(new WebChromeClient());
        try {
            if (Build.VERSION.SDK_INT >= 14 && parameterInfo.mCloseHardwareAccelerated) {
                setLayerType(1, null);
            }
        } catch (Exception e2) {
            this.mAdLogger.d(e2);
        }
        try {
            if (Build.VERSION.SDK_INT < 21 || AppUtils.getTargetSdkVersion(context) < 21) {
                return;
            }
            ReflectionUtils.invoke(CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, new Object[]{this, Boolean.TRUE});
        } catch (Throwable th) {
            this.mAdLogger.e(th);
        }
    }

    public static boolean canOpenByIntent(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) ? !isHttpScheme(str) || isDownloadFile(str) || isVideoFile(str) || isAudioFile(str) : invokeL.booleanValue;
    }

    public static XMyWebView create(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2, ParameterInfo parameterInfo) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, remoteXAdLogger, Boolean.valueOf(z), Boolean.valueOf(z2), parameterInfo})) == null) {
            setDataDirectorySuffixForPie(context);
            return new XMyWebView(context, remoteXAdLogger, z, z2, parameterInfo);
        }
        return (XMyWebView) invokeCommon.objValue;
    }

    public static boolean hitExt(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, strArr, str)) == null) {
            if (str == null) {
                return false;
            }
            Uri parse = Uri.parse(str);
            String lowerCase = parse.getPath() == null ? "" : parse.getPath().toLowerCase(Locale.getDefault());
            for (String str2 : strArr) {
                if (lowerCase.trim().endsWith("." + str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean hitScheme(String[] strArr, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, strArr, str)) == null) {
            if (str == null) {
                return false;
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            for (String str2 : strArr) {
                if (lowerCase.trim().startsWith(str2 + ":")) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static boolean isAudioFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str)) == null) ? hitExt(C.audios, str) : invokeL.booleanValue;
    }

    public static boolean isDownloadFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) ? hitExt(C.downloads, str) : invokeL.booleanValue;
    }

    public static boolean isHttpScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) ? hitScheme(C.httpSchemes, str) : invokeL.booleanValue;
    }

    public static boolean isMailScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) ? hitScheme(C.mailSchemes, str) : invokeL.booleanValue;
    }

    public static boolean isSmsScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, null, str)) == null) ? hitScheme(C.smsSchemes, str) : invokeL.booleanValue;
    }

    public static boolean isTelScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) ? hitScheme(C.telSchemes, str) : invokeL.booleanValue;
    }

    public static boolean isValidExtScheme(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? hitScheme(C.schemes, str) : invokeL.booleanValue;
    }

    public static boolean isVideoFile(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) ? hitExt(C.videos, str) : invokeL.booleanValue;
    }

    public static boolean needExternalBrowser(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? isSmsScheme(str) || isTelScheme(str) || isMailScheme(str) || (isValidExtScheme(str) && (!isHttpScheme(str) || isDownloadFile(str) || isVideoFile(str) || isAudioFile(str))) : invokeL.booleanValue;
    }

    public static void setDataDirectorySuffixForPie(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65551, null, context) == null) || Build.VERSION.SDK_INT < 28) {
            return;
        }
        String str = null;
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == Process.myPid()) {
                    str = next.processName;
                    break;
                }
            }
            if (TextUtils.isEmpty(str) || TextUtils.equals(context.getApplicationInfo().packageName, str)) {
                return;
            }
            WebView.setDataDirectorySuffix(str);
        } catch (Throwable unused) {
        }
    }

    @Override // android.webkit.WebView
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(this);
                }
                if (this.isDestroy) {
                    return;
                }
                super.destroy();
                this.isDestroy = true;
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    public boolean isDestroy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.isDestroy : invokeV.booleanValue;
    }

    public boolean isScrollX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.isScrollX : invokeV.booleanValue;
    }

    public boolean isScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.isScrollY : invokeV.booleanValue;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLLL(1048580, this, str, str2, str3, str4, str5) == null) || this.isDestroy) {
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            try {
                if (this.isDestroy) {
                    return;
                }
                super.loadUrl(str);
            } catch (Exception e2) {
                this.mAdLogger.e(e2);
            }
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048582, this, i2, keyEvent)) == null) {
            KeyDownListener keyDownListener = this.mKeyDownListener;
            if (keyDownListener == null) {
                return false;
            }
            return keyDownListener.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            boolean z3 = true;
            this.isScrollY = z2 && i3 == 0;
            this.isScrollX = (z && i2 == 0) ? false : false;
            super.onOverScrolled(i2, i3, z, z2);
        }
    }

    public void setConfigs(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jSONObject) == null) {
            try {
                String[] unused = C.downloads = jSONObject.getString("DOWNLOADS").split(",");
                String[] unused2 = C.videos = jSONObject.getString("VIDEOS").split(",");
                String[] unused3 = C.audios = jSONObject.getString("AUDIOS").split(",");
                String[] unused4 = C.httpSchemes = jSONObject.getString("HTTPSCHEMES").split(",");
                String[] unused5 = C.smsSchemes = jSONObject.getString("SMSSCHEMES").split(",");
                String[] unused6 = C.schemes = jSONObject.getString("SCHEMES").split(",");
                C.out(this.mAdLogger);
            } catch (JSONException e2) {
                this.mAdLogger.d(e2);
            }
        }
    }

    public void setKeyDownListener(KeyDownListener keyDownListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, keyDownListener) == null) {
            this.mKeyDownListener = keyDownListener;
        }
    }

    public void setScrollY(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.isScrollY = z;
        }
    }

    public static XMyWebView create(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, remoteXAdLogger, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? create(context, remoteXAdLogger, z, z2, new ParameterInfo()) : (XMyWebView) invokeCommon.objValue;
    }
}
