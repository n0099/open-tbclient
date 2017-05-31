package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] PK;
    private final /* synthetic */ Activity PL;
    private final /* synthetic */ a.InterfaceC0000a PM;
    private final /* synthetic */ int PN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.PK = strArr;
        this.PL = activity;
        this.PM = interfaceC0000a;
        this.PN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.PK.length];
        PackageManager packageManager = this.PL.getPackageManager();
        String packageName = this.PL.getPackageName();
        int length = this.PK.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.PK[i], packageName);
        }
        this.PM.onRequestPermissionsResult(this.PN, this.PK, iArr);
    }
}
