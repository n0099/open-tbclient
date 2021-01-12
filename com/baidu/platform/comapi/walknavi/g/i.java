package com.baidu.platform.comapi.walknavi.g;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class i implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f4339a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        this.f4339a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f4339a.R();
    }
}
