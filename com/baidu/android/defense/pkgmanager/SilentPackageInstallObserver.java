package com.baidu.android.defense.pkgmanager;

import android.content.Context;
import android.content.pm.IPackageInstallObserver;
import android.text.TextUtils;
import java.io.File;
/* loaded from: classes.dex */
public class SilentPackageInstallObserver extends IPackageInstallObserver.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "SilentPackageInstallObserver";
    private String mApkPath;
    private Context mContext;

    public SilentPackageInstallObserver(Context context, String str) {
        this.mContext = context;
        this.mApkPath = str;
    }

    @Override // android.content.pm.IPackageInstallObserver
    public void packageInstalled(String str, int i) {
        if (i == 1) {
        }
        if (d.a(this.mContext).a()) {
            d.a(this.mContext).b(this.mContext, this.mApkPath);
        }
        if (TextUtils.isEmpty(this.mApkPath)) {
            return;
        }
        try {
            File file = new File(this.mApkPath);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
        }
    }
}
