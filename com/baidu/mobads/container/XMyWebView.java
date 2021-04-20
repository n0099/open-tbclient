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
import com.baidu.mobads.container.util.AppUtils;
import com.baidu.mobads.container.util.ReflectionUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XMyWebView extends XSafeWebView {
    public String curUrl;
    public boolean isDestroy;
    public boolean isScrollX;
    public boolean isScrollY;
    public KeyDownListener mKeyDownListener;

    /* loaded from: classes2.dex */
    public static class C {
        public static final String SEP = ",";
        public static String[] downloads = "zip,rar,7z,tar.gz,bz".split(",");
        public static String[] videos = "mp4,3gp,3g2,avi,rm,rmvb,wmv,flv,mkv,mov,asf,asx".split(",");
        public static String[] audios = "mp3,ra,wma,m4a,wav,aac,mmf,amr,ogg,adp".split(",");
        public static final String sms = "sms,smsto,mms";
        public static String[] smsSchemes = sms.split(",");
        public static final String[] telSchemes = {"tel"};
        public static final String[] mailSchemes = {"mailto"};
        public static final String http = "http,https";
        public static String[] httpSchemes = http.split(",");
        public static String[] schemes = "http,https,sms,smsto,mms,tel,fax,ftp,mailto,gopher,news,telnet,file".split(",");

        public static void out(RemoteXAdLogger remoteXAdLogger) {
            remoteXAdLogger.d(u(downloads));
            remoteXAdLogger.d(u(videos));
            remoteXAdLogger.d(u(audios));
            remoteXAdLogger.d(u(smsSchemes));
            remoteXAdLogger.d(u(httpSchemes));
            remoteXAdLogger.d(u(schemes));
        }

        public static String u(String[] strArr) {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(',');
            }
            return sb.toString();
        }
    }

    /* loaded from: classes2.dex */
    public interface KeyDownListener {
        boolean onKeyDown(int i, KeyEvent keyEvent);
    }

    /* loaded from: classes2.dex */
    public static class ParameterInfo {
        public boolean mCloseHardwareAccelerated = true;
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    @TargetApi(19)
    public XMyWebView(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2, ParameterInfo parameterInfo) {
        super(context, remoteXAdLogger);
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
        return !isHttpScheme(str) || isDownloadFile(str) || isVideoFile(str) || isAudioFile(str);
    }

    public static XMyWebView create(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2, ParameterInfo parameterInfo) {
        setDataDirectorySuffixForPie(context);
        return new XMyWebView(context, remoteXAdLogger, z, z2, parameterInfo);
    }

    public static boolean hitExt(String[] strArr, String str) {
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

    public static boolean hitScheme(String[] strArr, String str) {
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

    public static boolean isAudioFile(String str) {
        return hitExt(C.audios, str);
    }

    public static boolean isDownloadFile(String str) {
        return hitExt(C.downloads, str);
    }

    public static boolean isHttpScheme(String str) {
        return hitScheme(C.httpSchemes, str);
    }

    public static boolean isMailScheme(String str) {
        return hitScheme(C.mailSchemes, str);
    }

    public static boolean isSmsScheme(String str) {
        return hitScheme(C.smsSchemes, str);
    }

    public static boolean isTelScheme(String str) {
        return hitScheme(C.telSchemes, str);
    }

    public static boolean isValidExtScheme(String str) {
        return hitScheme(C.schemes, str);
    }

    public static boolean isVideoFile(String str) {
        return hitExt(C.videos, str);
    }

    public static boolean needExternalBrowser(String str) {
        return isSmsScheme(str) || isTelScheme(str) || isMailScheme(str) || (isValidExtScheme(str) && (!isHttpScheme(str) || isDownloadFile(str) || isVideoFile(str) || isAudioFile(str)));
    }

    public static void setDataDirectorySuffixForPie(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
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
    }

    @Override // android.webkit.WebView
    public void destroy() {
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

    public boolean isDestroy() {
        return this.isDestroy;
    }

    public boolean isScrollX() {
        return this.isScrollX;
    }

    public boolean isScrollY() {
        return this.isScrollY;
    }

    @Override // android.webkit.WebView
    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (this.isDestroy) {
            return;
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    @Override // android.webkit.WebView
    public void loadUrl(String str) {
        try {
            if (this.isDestroy) {
                return;
            }
            super.loadUrl(str);
        } catch (Exception e2) {
            this.mAdLogger.e(e2);
        }
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        KeyDownListener keyDownListener = this.mKeyDownListener;
        if (keyDownListener == null) {
            return false;
        }
        return keyDownListener.onKeyDown(i, keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        boolean z3 = true;
        this.isScrollY = z2 && i2 == 0;
        this.isScrollX = (z && i == 0) ? false : false;
        super.onOverScrolled(i, i2, z, z2);
    }

    public void setConfigs(JSONObject jSONObject) {
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

    public void setKeyDownListener(KeyDownListener keyDownListener) {
        this.mKeyDownListener = keyDownListener;
    }

    public void setScrollY(boolean z) {
        this.isScrollY = z;
    }

    public static XMyWebView create(Context context, RemoteXAdLogger remoteXAdLogger, boolean z, boolean z2) {
        return create(context, remoteXAdLogger, z, z2, new ParameterInfo());
    }
}
