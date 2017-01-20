package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Lq;
    private final /* synthetic */ Activity Lr;
    private final /* synthetic */ a.InterfaceC0000a Ls;
    private final /* synthetic */ int Lt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Lq = strArr;
        this.Lr = activity;
        this.Ls = interfaceC0000a;
        this.Lt = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Lq.length];
        PackageManager packageManager = this.Lr.getPackageManager();
        String packageName = this.Lr.getPackageName();
        int length = this.Lq.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Lq[i], packageName);
        }
        this.Ls.onRequestPermissionsResult(this.Lt, this.Lq, iArr);
    }
}
