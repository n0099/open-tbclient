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
import androidx.core.content.FileProvider;
import com.baidu.fsg.base.router.RouterCallback;
import com.baidu.mobads.MobadsPermissionSettings;
import com.baidu.mobads.interfaces.utils.IBase64;
import com.baidu.mobads.interfaces.utils.IXAdPackageUtils;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.mobads.interfaces.utils.IXAdURIUitls;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class r implements IXAdPackageUtils {
    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        if (a(context) && !c(context)) {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                if (b(context, p.a(externalFilesDir.getPath()))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static Uri c(Context context, File file) {
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".bd.provider", file);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int d(Context context) {
        try {
            return context.getApplicationContext().getApplicationInfo().targetSdkVersion;
        } catch (Exception unused) {
            return 0;
        }
    }

    public Intent a(Context context, File file) {
        Uri c2;
        if (file != null) {
            try {
                if (file.exists()) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.DEFAULT");
                    if (!a(context)) {
                        intent.addFlags(268435456);
                        c2 = Uri.fromFile(file);
                    } else {
                        intent.addFlags(RouterCallback.CODE_ERROR);
                        c2 = c(context, file);
                    }
                    if (c2 == null) {
                        return null;
                    }
                    intent.setDataAndType(c2, "application/vnd.android.package-archive");
                    return intent;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public int getAppVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
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
            } catch (Exception unused) {
                return intent;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public IXAdPackageUtils.ApkInfo getLocalApkFileInfo(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
            if (packageArchiveInfo != null) {
                return new IXAdPackageUtils.ApkInfo(context, packageArchiveInfo);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
        if (r1.importance != 100) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        return true;
     */
    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isForeground(Context context, String str) {
        try {
            Iterator<ActivityManager.RunningAppProcessInfo> it = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.equals(str)) {
                    break;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean isInstalled(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
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
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public boolean sendAPOInfo(Context context, String str, String str2, int i, int i2, int i3) {
        String str3;
        boolean z;
        int i4;
        int i5;
        String str4 = str2;
        PackageManager packageManager = context.getPackageManager();
        IXAdSystemUtils systemUtils = XAdSDKFoundationFacade.getInstance().getSystemUtils();
        IXAdURIUitls uRIUitls = XAdSDKFoundationFacade.getInstance().getURIUitls();
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        String encodeUrl = uRIUitls.encodeUrl(str);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        StringBuilder sb = new StringBuilder();
        sb.append("&sn=");
        sb.append(systemUtils.getEncodedSN(context));
        sb.append("&fb_act=");
        sb.append(i2);
        sb.append("&pack=");
        sb.append(context.getPackageName());
        sb.append("&v=");
        sb.append("android_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30");
        sb.append("&targetscheme=");
        sb.append(encodeUrl);
        sb.append("&pk=");
        sb.append(str4);
        String sb2 = sb.toString();
        if (queryIntentActivities.size() > 0) {
            str3 = ("&open=true") + "&n=" + queryIntentActivities.size();
            String str5 = "";
            int i6 = 0;
            boolean z2 = true;
            while (i6 < queryIntentActivities.size()) {
                ResolveInfo resolveInfo = queryIntentActivities.get(i6);
                if (i6 == 0) {
                    str3 = str3 + "&p=" + resolveInfo.activityInfo.packageName;
                } else {
                    str3 = str3 + "," + resolveInfo.activityInfo.packageName;
                }
                if (str4.equals(resolveInfo.activityInfo.packageName)) {
                    try {
                        i5 = packageManager.getPackageInfo(resolveInfo.activityInfo.packageName, 0).versionCode;
                        if (i5 < i3) {
                            z2 = false;
                        }
                    } catch (Exception unused) {
                        i4 = -1;
                    }
                    try {
                        str5 = str5 + "&installedVersion=" + i5 + "&requiredVersion=" + i3 + "&realopen=" + z2;
                    } catch (Exception unused2) {
                        i4 = i5;
                        str5 = str5 + "&exception=true&installedVersion=" + i4 + "&requiredVersion=" + i3 + "&realopen=" + z2;
                        i6++;
                        str4 = str2;
                    }
                }
                i6++;
                str4 = str2;
            }
            if (!str5.equals("")) {
                str3 = str3 + str5;
            }
            z = z2;
        } else {
            str3 = "&open=false";
            z = false;
        }
        try {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(commonUtils.vdUrl(sb2 + str3, i), null), "");
            bVar.f8414e = 1;
            new com.baidu.mobads.openad.b.a().a(bVar);
            return z;
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e2.getMessage());
            return z;
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public void sendAPOIsSuccess(Context context, boolean z, int i, String str, String str2) {
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
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
        sb.append("&cuid=" + base64.encode(systemUtils.getCUID(context)));
        sb.append("&pack=" + context.getPackageName());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("&v=");
        sb2.append("android_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("&targetscheme=");
        sb3.append(encodeUrl);
        sb.append(sb3.toString());
        sb.append("&pk=" + str2);
        try {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(commonUtils.vdUrl(sb.toString(), 369), null), "");
            bVar.f8414e = 1;
            new com.baidu.mobads.openad.b.a().a(bVar);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e2.getMessage());
        }
    }

    @Override // com.baidu.mobads.interfaces.utils.IXAdPackageUtils
    public void sendDialerIsSuccess(Context context, boolean z, int i, String str) {
        h commonUtils = XAdSDKFoundationFacade.getInstance().getCommonUtils();
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
        sb.append("&cuid=" + base64.encode(systemUtils.getCUID(context)));
        sb.append("&pack=" + context.getPackageName());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("&v=");
        sb2.append("android_" + com.baidu.mobads.constants.a.f8206c + "_4.1.30");
        sb.append(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("&pk=");
        sb3.append(str);
        sb.append(sb3.toString());
        try {
            com.baidu.mobads.openad.b.b bVar = new com.baidu.mobads.openad.b.b(uRIUitls.addParameters(commonUtils.vdUrl(sb.toString(), 372), null), "");
            bVar.f8414e = 1;
            new com.baidu.mobads.openad.b.a().a(bVar);
        } catch (Exception e2) {
            XAdSDKFoundationFacade.getInstance().getAdLogger().d("XAdPackageUtils", e2.getMessage());
        }
    }

    public static boolean c(Context context) {
        File externalStorageDirectory;
        return Build.VERSION.SDK_INT <= 28 && XAdSDKFoundationFacade.getInstance().getCommonUtils().checkSelfPermission(context, StorageUtils.EXTERNAL_STORAGE_PERMISSION) && MobadsPermissionSettings.hasPermissionGranted("permission_storage") && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && b(context, p.a(externalStorageDirectory.getPath()));
    }

    public static boolean b(Context context, String str) {
        if (a(context)) {
            try {
                File file = new File(str + "t");
                if (!file.exists()) {
                    file.mkdir();
                }
                return c(context, file) != null;
            } catch (Exception e2) {
                q.a().e(e2);
                return false;
            }
        }
        return true;
    }

    public static boolean a(Context context) {
        return Build.VERSION.SDK_INT >= 24 && d(context) >= 24;
    }

    public Intent a(Context context, String str) {
        try {
            return a(context, new File(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public void b(Context context, File file) {
        try {
            context.startActivity(a(context, file));
        } catch (Exception unused) {
        }
    }
}
