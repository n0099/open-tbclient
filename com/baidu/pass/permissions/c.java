package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9313a;

    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9313a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9313a.f9308d;
        permissionsCallback.onFailure(-1);
        this.f9313a.finish();
    }
}
