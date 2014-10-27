package com.baidu.android.procmo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class ProcessMonitor {
    private Context mContext;
    private String wZ;
    private String xa;
    private String xb;

    static {
        System.loadLibrary("procmoi_v1_4");
    }

    public ProcessMonitor(Context context, String str, String str2, String str3, int i) {
        String str4;
        this.wZ = "";
        this.xa = "";
        this.xb = "";
        this.mContext = context;
        this.wZ = str;
        this.xa = str2;
        this.xb = str3;
        if (TextUtils.isEmpty(this.xb)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.baidu.com"));
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && resolveActivity.activityInfo != null && resolveActivity.activityInfo.packageName.equals("android") && resolveActivity.activityInfo.name.equals("com.android.internal.app.ResolverActivity")) {
                for (ResolveInfo resolveInfo : this.mContext.getPackageManager().queryIntentActivities(intent, AccessibilityEventCompat.TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED)) {
                    if ((resolveInfo.activityInfo.applicationInfo.flags & 1) != 0) {
                        str4 = resolveInfo.activityInfo.packageName + "/" + resolveInfo.activityInfo.name;
                        break;
                    }
                }
            }
            str4 = "";
            this.xb = str4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(String str) {
        if (str == null) {
            return;
        }
        try {
            String r = r(this.mContext);
            String str2 = this.xa;
            Runtime.getRuntime().exec(str + " " + this.mContext.getApplicationInfo().dataDir + " " + r + " " + this.wZ + " " + str2 + " " + (Build.VERSION.SDK_INT >= 17 ? 1 : 0) + " " + this.xb);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void exitIfRunning(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public String iH() {
        int i = 0;
        try {
            File file = new File(this.mContext.getFilesDir(), "libprocmox_v1_4.so");
            File file2 = new File(r(this.mContext), "libprocmox_v1_4.so");
            if (file.exists() && file.length() == file2.length()) {
                return file.getAbsolutePath();
            }
            FileInputStream fileInputStream = new FileInputStream(file2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream.write(bArr, 0, i);
                    }
                }
                setPermissions(file.getAbsolutePath(), 493, -1, -1);
                String absolutePath = file.getAbsolutePath();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return absolutePath;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                    return absolutePath;
                }
                return absolutePath;
            } catch (IOException e2) {
                e2.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                        return null;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return null;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static String r(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return Build.VERSION.SDK_INT >= 9 ? packageInfo.applicationInfo.nativeLibraryDir : new File(packageInfo.applicationInfo.dataDir, "lib").getAbsolutePath();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private static native int setPermissions(String str, int i, int i2, int i3);

    public void start() {
        Thread thread = new Thread(new a(this));
        thread.setName("ProcessMonitor-init");
        thread.start();
    }
}
