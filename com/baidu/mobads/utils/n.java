package com.baidu.mobads.utils;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.baidu.mobads.openad.FileProvider;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.List;
/* loaded from: classes3.dex */
public class n implements IXAdPackageUtils {
    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean isInstalled(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean isSystemPackage(PackageInfo packageInfo) {
        return (packageInfo.applicationInfo.flags & 1) != 0;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    @TargetApi(3)
    public void openApp(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            launchIntentForPackage.addFlags(268435456);
            context.startActivity(launchIntentForPackage);
        } catch (Exception e) {
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    @Deprecated
    public Intent getInstallIntent(String str) {
        try {
            Uri fromFile = Uri.fromFile(new File(str));
            Intent intent = new Intent("android.intent.action.VIEW");
            try {
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addFlags(268435456);
                intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
                return intent;
            } catch (Exception e) {
                return intent;
            }
        } catch (Exception e2) {
            return null;
        }
    }

    public Intent a(Context context, File file) {
        Intent intent;
        Uri c;
        if (file != null) {
            try {
                if (file.exists()) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    if (!a(context)) {
                        intent.addFlags(268435456);
                        c = Uri.fromFile(file);
                    } else {
                        intent.addFlags(RouterCallback.CODE_ERROR);
                        c = c(context, file);
                    }
                    if (c == null) {
                        return null;
                    }
                    intent.setDataAndType(c, "application/vnd.android.package-archive");
                    return intent;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        intent = null;
        return intent;
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 && d(context) >= 24;
    }

    private static Uri c(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (a(context) && !c(context)) {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    return c(context, l.a(externalFilesDir.getPath()));
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean c(Context context) {
        return XAdSDKFoundationFacade.getInstance().getCommonUtils().checkSelfPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE") && c(context, l.a(Environment.getExternalStorageDirectory().getPath()));
    }

    private static boolean c(Context context, String str) {
        if (a(context)) {
            try {
                File file = new File(str + "t");
                if (!file.exists()) {
                    file.mkdir();
                }
                return c(context, file) != null;
            } catch (Exception e) {
                m.a().e(e);
                return false;
            }
        }
        return true;
    }

    public Intent a(Context context, String str) {
        try {
            return a(context, new File(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void b(Context context, File file) {
        try {
            context.startActivity(a(context, file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(Context context, String str) {
        try {
            context.startActivity(a(context, str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public IXAdPackageUtils.ApkInfo getLocalApkFileInfo(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo == null) {
                return null;
            }
            return new IXAdPackageUtils.ApkInfo(context, packageArchiveInfo);
        } catch (Exception e) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean isForeground(Context context, String str) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(PushConstants.INTENT_ACTIVITY_NAME)).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    return runningAppProcessInfo.importance == 100;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public void sendAPOIsSuccess(Context context, boolean z, int i, String str, String str2) {
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
        String encodeUrl = uRIUitls.encodeUrl(str);
        StringBuilder sb = new StringBuilder();
        sb.append("aposuccess=" + z);
        if (!z) {
            sb.append("&failtime=" + i);
        }
        sb.append("&sn=" + systemUtils.getEncodedSN(context));
        sb.append("&mac=" + base64.encode(systemUtils.getMacAddress(context)));
        sb.append("&cuid=" + systemUtils.getCUID(context));
        sb.append("&pack=" + context.getPackageName());
        sb.append("&v=" + ("android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30"));
        sb.append("&targetscheme=" + encodeUrl);
        sb.append("&pk=" + str2);
        try {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(commonUtils.vdUrl(sb.toString(), 369), null), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e.getMessage());
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean sendAPOInfo(Context context, String str, String str2, int i, int i2, int i3) {
        boolean z;
        String str3;
        String str4;
        PackageManager packageManager = context.getPackageManager();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        String encodeUrl = uRIUitls.encodeUrl(str);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        String str5 = "&sn=" + systemUtils.getEncodedSN(context) + "&fb_act=" + i2 + "&pack=" + context.getPackageName() + "&v=" + ("android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30") + "&targetscheme=" + encodeUrl + "&pk=" + str2;
        if (queryIntentActivities.size() > 0) {
            String str6 = "";
            str3 = ("&open=true") + "&n=" + queryIntentActivities.size();
            z = true;
            int i4 = 0;
            while (i4 < queryIntentActivities.size()) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i4);
                if (i4 == 0) {
                    str3 = str3 + "&p=" + resolveInfo.activityInfo.packageName;
                } else {
                    str3 = str3 + Constants.ACCEPT_TIME_SEPARATOR_SP + resolveInfo.activityInfo.packageName;
                }
                if (str2.equals(resolveInfo.activityInfo.packageName)) {
                    int i5 = -1;
                    try {
                        i5 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode;
                        if (i5 < i3) {
                            z = false;
                        }
                        str4 = str6 + "&installedVersion=" + i5 + "&requiredVersion=" + i3 + "&realopen=" + z;
                    } catch (Exception e) {
                        str4 = str6 + "&exception=true&installedVersion=" + i5 + "&requiredVersion=" + i3 + "&realopen=" + z;
                        e.printStackTrace();
                    }
                } else {
                    str4 = str6;
                }
                i4++;
                z = z;
                str6 = str4;
            }
            if (!str6.equals("")) {
                str3 = str3 + str6;
            }
        } else {
            z = false;
            str3 = "&open=false";
        }
        try {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(commonUtils.vdUrl(str5 + str3, i), null), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e2.getMessage());
        }
        return z;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public void sendDialerIsSuccess(Context context, boolean z, int i, String str) {
        e commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IBase64 base64 = XAdSDKFoundationFacade.getInstance().getBase64();
        StringBuilder sb = new StringBuilder();
        sb.append("callstate=" + z);
        if (!z) {
            sb.append("&duration=" + i);
        }
        sb.append("&sn=" + systemUtils.getEncodedSN(context));
        sb.append("&mac=" + base64.encode(systemUtils.getMacAddress(context)));
        sb.append("&bdr=" + Build.VERSION.SDK_INT);
        sb.append("&cuid=" + systemUtils.getCUID(context));
        sb.append("&pack=" + context.getPackageName());
        sb.append("&v=" + ("android_" + com.baidu.mobads.a.a.c + PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS + "4.1.30"));
        sb.append("&pk=" + str);
        try {
            com.baidu.mobads.openad.d.c cVar = new com.baidu.mobads.openad.d.c(uRIUitls.addParameters(commonUtils.vdUrl(sb.toString(), 372), null), "");
            cVar.e = 1;
            new com.baidu.mobads.openad.d.a().a(cVar);
        } catch (Exception e) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e.getMessage());
        }
    }

    public static int d(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
