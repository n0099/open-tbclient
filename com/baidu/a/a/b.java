package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Mh;
    private final /* synthetic */ Activity Mi;
    private final /* synthetic */ a.InterfaceC0000a Mj;
    private final /* synthetic */ int Mk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Mh = strArr;
        this.Mi = activity;
        this.Mj = interfaceC0000a;
        this.Mk = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Mh.length];
        PackageManager packageManager = this.Mi.getPackageManager();
        String packageName = this.Mi.getPackageName();
        int length = this.Mh.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Mh[i], packageName);
        }
        this.Mj.onRequestPermissionsResult(this.Mk, this.Mh, iArr);
    }
}
