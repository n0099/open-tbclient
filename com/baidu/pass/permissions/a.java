package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes4.dex */
class a implements View.OnClickListener {
    final /* synthetic */ PermissionsHelperActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.a.d;
        permissionsCallback.onFailure(-2);
        this.a.finish();
    }
}
