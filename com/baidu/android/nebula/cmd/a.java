package com.baidu.android.nebula.cmd;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Process;
import java.io.File;
import java.util.Timer;
import org.json.JSONArray;
/* loaded from: classes.dex */
class a extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ScanDownloadFile f543a;
    private File b = null;
    private Timer c;
    private JSONArray d;
    private String e;
    private File f;

    public a(ScanDownloadFile scanDownloadFile, JSONArray jSONArray) {
        String str;
        String str2;
        String str3;
        this.f543a = scanDownloadFile;
        str = this.f543a.mFileName;
        this.e = str;
        this.f = null;
        StringBuilder sb = new StringBuilder();
        str2 = scanDownloadFile.mFileName;
        setName(sb.append(str2).append("_moplus_findapkfromsdcard_thread").toString());
        this.d = jSONArray;
        StringBuilder append = new StringBuilder().append("^");
        str3 = scanDownloadFile.mFileName;
        this.e = append.append(str3).append("(.*)?\\.apk$").toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
            intent.setFlags(268435456);
            intent.putExtra("android.intent.extra.INSTALLER_PACKAGE_NAME", context.getPackageName());
            intent.setComponent(new ComponentName("com.android.packageinstaller", "com.android.packageinstaller.PackageInstallerActivity"));
            context.startActivity(intent);
        } catch (Exception e) {
            intent.setComponent(null);
            try {
                context.startActivity(intent);
            } catch (Exception e2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        long j;
        long j2;
        long j3;
        String str2;
        String str3;
        long j4;
        Context context;
        j = this.f543a.mTotalRetryTime;
        j2 = this.f543a.mTotalExpiredTime;
        if (j > j2) {
            if (this.c != null) {
                this.c.cancel();
                return;
            }
            return;
        }
        File file = new File(str);
        ScanDownloadFile scanDownloadFile = this.f543a;
        j3 = this.f543a.mScanedOneTime;
        ScanDownloadFile.access$914(scanDownloadFile, j3);
        if (file.exists()) {
            long length = file.length();
            str2 = this.f543a.mFileLength;
            if (length <= Long.parseLong(str2)) {
                if (this.c == null) {
                    this.c = new Timer();
                }
                long length2 = file.length();
                str3 = this.f543a.mFileLength;
                if (length2 >= Integer.parseInt(str3)) {
                    this.c.cancel();
                    context = this.f543a.mContext;
                    a(context, file);
                    return;
                }
                Timer timer = this.c;
                c cVar = new c(this, file, str);
                j4 = this.f543a.mScanedOneTime;
                timer.schedule(cVar, j4);
                return;
            }
        }
        this.c.cancel();
    }

    protected void a(File file) {
        long j;
        if (file == null || !file.exists() || System.currentTimeMillis() - file.lastModified() < 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - file.lastModified();
        j = this.f543a.mExpiredTime;
        if (currentTimeMillis <= j) {
            a(file.getAbsolutePath());
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Process.setThreadPriority(19);
        for (int i = 0; i < this.d.length(); i++) {
            try {
                new File(Environment.getExternalStorageDirectory(), this.d.get(i).toString()).listFiles(new b(this));
            } catch (Exception e) {
            }
        }
        a(this.f);
    }
}
