package com.baidu.platform.comapi.bikenavi.c;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b bVar) {
        this.f2839a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f2839a.I();
    }
}
