package com.baidu.platform.comapi.bikenavi.c;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f4159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f4159a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4159a.H();
    }
}
