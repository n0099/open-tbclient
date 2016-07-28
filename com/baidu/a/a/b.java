package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] JV;
    private final /* synthetic */ Activity JW;
    private final /* synthetic */ a.InterfaceC0000a JX;
    private final /* synthetic */ int JY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.JV = strArr;
        this.JW = activity;
        this.JX = interfaceC0000a;
        this.JY = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.JV.length];
        PackageManager packageManager = this.JW.getPackageManager();
        String packageName = this.JW.getPackageName();
        int length = this.JV.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.JV[i], packageName);
        }
        this.JX.onRequestPermissionsResult(this.JY, this.JV, iArr);
    }
}
