package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] PE;
    private final /* synthetic */ Activity PF;
    private final /* synthetic */ a.InterfaceC0000a PG;
    private final /* synthetic */ int PH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.PE = strArr;
        this.PF = activity;
        this.PG = interfaceC0000a;
        this.PH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.PE.length];
        PackageManager packageManager = this.PF.getPackageManager();
        String packageName = this.PF.getPackageName();
        int length = this.PE.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.PE[i], packageName);
        }
        this.PG.onRequestPermissionsResult(this.PH, this.PE, iArr);
    }
}
