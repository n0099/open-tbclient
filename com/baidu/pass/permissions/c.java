package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes4.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f4154a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f4154a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f4154a.d;
        permissionsCallback.onFailure(-1);
        this.f4154a.finish();
    }
}
