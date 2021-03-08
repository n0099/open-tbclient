package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes5.dex */
class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2850a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2850a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f2850a.d;
        permissionsCallback.onFailure(-2);
        this.f2850a.finish();
    }
}
