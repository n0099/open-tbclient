package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes4.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f4116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f4116a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f4116a.d;
        permissionsCallback.onFailure(-1);
        this.f4116a.finish();
    }
}
