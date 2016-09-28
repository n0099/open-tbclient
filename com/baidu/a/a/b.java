package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Mg;
    private final /* synthetic */ Activity Mh;
    private final /* synthetic */ a.InterfaceC0000a Mi;
    private final /* synthetic */ int Mj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Mg = strArr;
        this.Mh = activity;
        this.Mi = interfaceC0000a;
        this.Mj = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Mg.length];
        PackageManager packageManager = this.Mh.getPackageManager();
        String packageName = this.Mh.getPackageName();
        int length = this.Mg.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Mg[i], packageName);
        }
        this.Mi.onRequestPermissionsResult(this.Mj, this.Mg, iArr);
    }
}
