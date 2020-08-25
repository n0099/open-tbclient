package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes4.dex */
class c implements View.OnClickListener {
    final /* synthetic */ PermissionsHelperActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.a.d;
        permissionsCallback.onFailure(-1);
        this.a.finish();
    }
}
