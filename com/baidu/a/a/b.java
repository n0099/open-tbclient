package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] QC;
    private final /* synthetic */ Activity QD;
    private final /* synthetic */ a.InterfaceC0000a QE;
    private final /* synthetic */ int QF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.QC = strArr;
        this.QD = activity;
        this.QE = interfaceC0000a;
        this.QF = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.QC.length];
        PackageManager packageManager = this.QD.getPackageManager();
        String packageName = this.QD.getPackageName();
        int length = this.QC.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.QC[i], packageName);
        }
        this.QE.onRequestPermissionsResult(this.QF, this.QC, iArr);
    }
}
