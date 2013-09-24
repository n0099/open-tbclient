package com.baidu.android.defense.b;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import java.io.File;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ File f536a;
    final /* synthetic */ Context b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, String str, File file, Context context, String str2) {
        super(str);
        this.d = bVar;
        this.f536a = file;
        this.b = context;
        this.c = str2;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        File a2;
        File file = this.f536a;
        e eVar = new e(this.b, this.c);
        a2 = this.d.a(this.b, file);
        if (a2 != null) {
            this.d.a(Uri.fromFile(a2), eVar, 0, this.b.getPackageName());
            return;
        }
        try {
            eVar.a(this.c, -4);
        } catch (RemoteException e) {
        }
    }
}
