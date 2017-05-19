package com.baidu.a.a;

import android.app.Activity;
import android.content.pm.PackageManager;
import com.baidu.a.a.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    private final /* synthetic */ String[] PW;
    private final /* synthetic */ Activity PX;
    private final /* synthetic */ a.InterfaceC0000a PY;
    private final /* synthetic */ int PZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(String[] strArr, Activity activity, a.InterfaceC0000a interfaceC0000a, int i) {
        this.PW = strArr;
        this.PX = activity;
        this.PY = interfaceC0000a;
        this.PZ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int[] iArr = new int[this.PW.length];
        PackageManager packageManager = this.PX.getPackageManager();
        String packageName = this.PX.getPackageName();
        int length = this.PW.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = packageManager.checkPermission(this.PW[i], packageName);
        }
        this.PY.onRequestPermissionsResult(this.PZ, this.PW, iArr);
    }
}
