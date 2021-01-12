package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes4.dex */
class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f4114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f4114a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f4114a.d;
        permissionsCallback.onFailure(-2);
        this.f4114a.finish();
    }
}
