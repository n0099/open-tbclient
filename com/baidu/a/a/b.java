package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Qs;
    private final /* synthetic */ Activity Qt;
    private final /* synthetic */ a.InterfaceC0000a Qu;
    private final /* synthetic */ int Qv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Qs = strArr;
        this.Qt = activity;
        this.Qu = interfaceC0000a;
        this.Qv = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Qs.length];
        PackageManager packageManager = this.Qt.getPackageManager();
        String packageName = this.Qt.getPackageName();
        int length = this.Qs.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Qs[i], packageName);
        }
        this.Qu.onRequestPermissionsResult(this.Qv, this.Qs, iArr);
    }
}
