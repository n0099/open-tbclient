package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes9.dex */
class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2797a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f2797a.d;
        permissionsCallback.onFailure(-2);
        this.f2797a.finish();
    }
}
