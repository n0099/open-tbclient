package com.baidu.mobads.container.util;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.view.InputDeviceCompat;
import com.baidu.down.manage.DownloadConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebViewFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes7.dex */
public class OpenAppUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SCHEME_WTAI_MC = "wtai://wp/mc;";
    public static String[] browserArr;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(698250003, "Lcom/baidu/mobads/container/util/OpenAppUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(698250003, "Lcom/baidu/mobads/container/util/OpenAppUtils;");
                return;
            }
        }
        browserArr = new String[]{"com.android.chrome", "com.UCMobile", "com.uc.browser", "com.uc.browser.hd", "com.tencent.mtt", "com.tencent.padbrowser", WebViewFactory.CHROMIUM_HOST_APP, "com.android.browser", "com.oupeng.mini.android", "com.oupeng.mobile", "com.oupeng.browser", "com.opera.mini.android", "com.opera.browser", "com.opera.browser.beta", "com.mediawoz.xbrowser", "com.mx.browser", "com.mx.browser.tablet", "org.mozilla.firefox", "com.tiantianmini.android.browser", "com.ijinshan.browser_fast", "sogou.mobile.explorer", "com.dolphin.browser.cn", "com.qihoo.browser", "com.baidu.searchbox"};
    }

    public OpenAppUtils() {
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

    @TargetApi(3)
    public static void browserOutside(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, context, str) == null) {
            if (str.startsWith("wtai://wp/mc;")) {
                str = "tel:" + str.substring(13);
            }
            try {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    if (AdURIUtils.isHttpProtocol(str).booleanValue()) {
                        String bestBrowser = getBestBrowser(context);
                        if (!bestBrowser.equals("")) {
                            intent = context.getPackageManager().getLaunchIntentForPackage(bestBrowser);
                            intent.setData(Uri.parse(str));
                            intent.setAction("android.intent.action.VIEW");
                        }
                    } else if (AdURIUtils.isMessageProtocol(str).booleanValue()) {
                        intent.setType("vnd.android-dir/mms-sms");
                        intent.putExtra("address", str.substring(4, str.indexOf(63) > 0 ? str.indexOf(63) : str.length()));
                        int indexOf = str.indexOf("body=") + 5;
                        if (indexOf > 5) {
                            int indexOf2 = str.indexOf(38, indexOf);
                            if (indexOf2 <= 0) {
                                indexOf2 = str.length();
                            }
                            intent.putExtra("sms_body", Uri.decode(str.substring(indexOf, indexOf2)));
                        }
                    }
                    if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
                        context.startActivity(intent);
                    }
                } catch (Exception e2) {
                    RemoteXAdLogger.getInstance().d("XAdCommonUtils.browserOutside 2", str, e2);
                }
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
        }
    }

    @TargetApi(3)
    public static String getBestBrowser(Context context) {
        int i2;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65539, null, context)) != null) {
            return (String) invokeL.objValue;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            packageManager.getPreferredActivities(arrayList, arrayList2, null);
            Iterator<ComponentName> it = arrayList2.iterator();
            while (true) {
                if (it.hasNext()) {
                    ComponentName next = it.next();
                    for (int i3 = 0; i3 < browserArr.length; i3++) {
                        String str = browserArr[i3];
                        if (str.equals(next.getPackageName())) {
                            return str;
                        }
                    }
                } else {
                    try {
                        i2 = -1;
                        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                            try {
                                if (packageManager.getLaunchIntentForPackage(runningAppProcessInfo.processName) != null && packageManager.getApplicationInfo(runningAppProcessInfo.processName, 128) != null) {
                                    for (int i4 = 0; i4 < browserArr.length; i4++) {
                                        if (runningAppProcessInfo.processName.equals(browserArr[i4]) && (i2 == -1 || i4 < i2)) {
                                            i2 = i4;
                                        }
                                    }
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception unused2) {
                        i2 = -1;
                    }
                    if (i2 != -1) {
                        return browserArr[i2];
                    }
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(DownloadConstants.REFER));
                    List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 64);
                    if (queryIntentActivities != null) {
                        for (int i5 = 0; i5 < browserArr.length; i5++) {
                            for (int i6 = 0; i6 < queryIntentActivities.size(); i6++) {
                                String str2 = queryIntentActivities.get(i6).activityInfo.packageName;
                                String str3 = browserArr[i5];
                                if (str3.equals(str2)) {
                                    return str3;
                                }
                            }
                        }
                    }
                    return (queryIntentActivities == null || queryIntentActivities.size() <= 0) ? "" : queryIntentActivities.get(0).activityInfo.packageName;
                }
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    public static void openApp(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, str) == null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
                launchIntentForPackage.addFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } catch (Exception unused) {
            }
        }
    }
}
