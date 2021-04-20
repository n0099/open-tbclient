package com.baidu.platform.comapi.walknavi.g;

import android.content.DialogInterface;
/* loaded from: classes2.dex */
public class i implements DialogInterface.OnCancelListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f9694a;

    public i(a aVar) {
        this.f9694a = aVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        this.f9694a.R();
    }
}
