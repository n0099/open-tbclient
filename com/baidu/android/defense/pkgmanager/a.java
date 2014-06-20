package com.baidu.android.defense.pkgmanager;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a extends Thread {
    final /* synthetic */ File a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ d d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d dVar, String str, File file, Context context, String str2) {
        super(str);
        this.d = dVar;
        this.a = file;
        this.b = context;
        this.c = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File a;
        File file = this.a;
        SilentPackageInstallObserver silentPackageInstallObserver = new SilentPackageInstallObserver(this.b, this.c);
        a = this.d.a(this.b, file);
        if (a != null) {
            this.d.a(Uri.fromFile(a), silentPackageInstallObserver, 0, this.b.getPackageName());
            return;
        }
        try {
            silentPackageInstallObserver.packageInstalled(this.c, -4);
        } catch (RemoteException e) {
        }
    }
}
