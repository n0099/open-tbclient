package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9784a;

    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9784a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9784a.f9779d;
        permissionsCallback.onFailure(-1);
        this.f9784a.finish();
    }
}
