package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] JW;
    private final /* synthetic */ Activity JX;
    private final /* synthetic */ a.InterfaceC0000a JY;
    private final /* synthetic */ int JZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.JW = strArr;
        this.JX = activity;
        this.JY = interfaceC0000a;
        this.JZ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.JW.length];
        PackageManager packageManager = this.JX.getPackageManager();
        String packageName = this.JX.getPackageName();
        int length = this.JW.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.JW[i], packageName);
        }
        this.JY.a(this.JZ, this.JW, iArr);
    }
}
