package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes9.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2799a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f2799a.d;
        permissionsCallback.onFailure(-1);
        this.f2799a.finish();
    }
}
