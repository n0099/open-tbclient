package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {
    public final /* synthetic */ PermissionsHelperActivity a;

    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.a.d;
        permissionsCallback.onFailure(-1);
        this.a.finish();
    }
}
