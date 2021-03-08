package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes5.dex */
class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2852a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2852a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f2852a.d;
        permissionsCallback.onFailure(-1);
        this.f2852a.finish();
    }
}
