package com.baidu.android.defense.pkgmanager;

import android.content.pm.IPackageDeleteObserver;
/* loaded from: classes.dex */
public class SilentPackageDeleteObserver extends IPackageDeleteObserver.Stub {
    private static final boolean DEBUG = false;
    private static final String TAG = "SilentPackageDeleteObserver";
    private String mPackageName;

    public SilentPackageDeleteObserver(String str) {
        this.mPackageName = null;
        this.mPackageName = str;
    }

    @Override // android.content.pm.IPackageDeleteObserver
    public void packageDeleted(String str, int i) {
    }
}
