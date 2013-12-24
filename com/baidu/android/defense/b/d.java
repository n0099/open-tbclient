package com.baidu.android.defense.b;

import android.content.pm.IPackageDeleteObserver;
/* loaded from: classes.dex */
public class d extends IPackageDeleteObserver.Stub {
    private String a;

    public d(String str) {
        this.a = null;
        this.a = str;
    }

    @Override // android.content.pm.IPackageDeleteObserver
    public void packageDeleted(String str, int i) {
    }
}
