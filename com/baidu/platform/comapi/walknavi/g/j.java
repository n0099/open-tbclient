package com.baidu.platform.comapi.walknavi.g;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f3065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f3065a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f3065a.Q();
    }
}
