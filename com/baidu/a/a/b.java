package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] QE;
    private final /* synthetic */ Activity QF;
    private final /* synthetic */ a.InterfaceC0000a QG;
    private final /* synthetic */ int QH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.QE = strArr;
        this.QF = activity;
        this.QG = interfaceC0000a;
        this.QH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.QE.length];
        PackageManager packageManager = this.QF.getPackageManager();
        String packageName = this.QF.getPackageName();
        int length = this.QE.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.QE[i], packageName);
        }
        this.QG.onRequestPermissionsResult(this.QH, this.QE, iArr);
    }
}
