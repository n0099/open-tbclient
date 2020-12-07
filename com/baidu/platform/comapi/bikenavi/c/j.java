package com.baidu.platform.comapi.bikenavi.c;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2841a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f2841a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2841a.I();
    }
}
