package com.baidu.android.procmo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.plugin.Plugin;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes.dex */
public class ProcessMonitor {
    private static final boolean DEBUG = false;
    private static final String EXE_FILE_NAME = "libprocmox_v1_4.so";
    private static final String LIB_NAME = "procmoi_v1_4";
    private static final String TAG = "procmo";
    public static final int TYPE_URL = 0;
    private String mAppId;
    private String mBrowser;
    private Context mContext;
    private String mFeedbackUrl;

    static {
        System.loadLibrary(LIB_NAME);
    }

    private ProcessMonitor() {
        this.mAppId = "";
        this.mFeedbackUrl = "";
        this.mBrowser = "";
    }

    public ProcessMonitor(Context context, String str, String str2, String str3, int i) {
        String str4;
        this.mAppId = "";
        this.mFeedbackUrl = "";
        this.mBrowser = "";
        this.mContext = context;
        this.mAppId = str;
        this.mFeedbackUrl = str2;
        this.mBrowser = str3;
        if (TextUtils.isEmpty(this.mBrowser)) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.baidu.com"));
            ResolveInfo resolveActivity = this.mContext.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity != null && resolveActivity.activityInfo != null && resolveActivity.activityInfo.packageName.equals("android") && resolveActivity.activityInfo.name.equals("com.android.internal.app.ResolverActivity")) {
                for (ResolveInfo resolveInfo : this.mContext.getPackageManager().queryIntentActivities(intent, 65536)) {
                    if ((resolveInfo.activityInfo.applicationInfo.flags & 1) != 0) {
                        str4 = resolveInfo.activityInfo.packageName + "/" + resolveInfo.activityInfo.name;
                        break;
                    }
                }
            }
            str4 = "";
            this.mBrowser = str4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executeMonitorProcess(String str) {
        if (str == null) {
            return;
        }
        try {
            String nativeLibraryDir = getNativeLibraryDir(this.mContext);
            String str2 = this.mFeedbackUrl;
            Runtime.getRuntime().exec(str + " " + this.mContext.getApplicationInfo().dataDir + " " + nativeLibraryDir + " " + this.mAppId + " " + str2 + " " + (Build.VERSION.SDK_INT >= 17 ? 1 : 0) + " " + this.mBrowser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void exitIfRunning(String str);

    private static String getNativeLibraryDir(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return Build.VERSION.SDK_INT >= 9 ? packageInfo.applicationInfo.nativeLibraryDir : new File(packageInfo.applicationInfo.dataDir, Plugin.SO_LIB_DIR_NAME).getAbsolutePath();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String iniExeFile() {
        int i = 0;
        try {
            File file = new File(this.mContext.getFilesDir(), EXE_FILE_NAME);
            File file2 = new File(getNativeLibraryDir(this.mContext), EXE_FILE_NAME);
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

    private static native int setPermissions(String str, int i, int i2, int i3);

    public static void stop(String str) {
        new ProcessMonitor().exitIfRunning(str);
    }

    public void start() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.android.procmo.ProcessMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                ProcessMonitor.this.exitIfRunning(ProcessMonitor.this.mAppId);
                ProcessMonitor.this.executeMonitorProcess(ProcessMonitor.this.iniExeFile());
            }
        });
        thread.setName("ProcessMonitor-init");
        thread.start();
    }

    public void stopSelf() {
        exitIfRunning(this.mAppId);
    }
}
