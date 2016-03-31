package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] Pf;
    private final /* synthetic */ Activity Pg;
    private final /* synthetic */ a.InterfaceC0000a Ph;
    private final /* synthetic */ int Pi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.Pf = strArr;
        this.Pg = activity;
        this.Ph = interfaceC0000a;
        this.Pi = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.Pf.length];
        PackageManager packageManager = this.Pg.getPackageManager();
        String packageName = this.Pg.getPackageName();
        int length = this.Pf.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.Pf[i], packageName);
        }
        this.Ph.a(this.Pi, this.Pf, iArr);
    }
}
