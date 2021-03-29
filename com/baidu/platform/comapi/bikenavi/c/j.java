package com.baidu.platform.comapi.bikenavi.c;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
public class j implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f9848a;

    public j(b bVar) {
        this.f9848a = bVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9848a.H();
    }
}
