package com.baidu.platform.comapi.walknavi.g;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3067a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f3067a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3067a.Q();
    }
}
