package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Mj;
    private final /* synthetic */ Activity Mk;
    private final /* synthetic */ a.InterfaceC0000a Ml;
    private final /* synthetic */ int Mm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Mj = strArr;
        this.Mk = activity;
        this.Ml = interfaceC0000a;
        this.Mm = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Mj.length];
        PackageManager packageManager = this.Mk.getPackageManager();
        String packageName = this.Mk.getPackageName();
        int length = this.Mj.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Mj[i], packageName);
        }
        this.Ml.onRequestPermissionsResult(this.Mm, this.Mj, iArr);
    }
}
