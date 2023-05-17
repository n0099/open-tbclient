package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public final /* synthetic */ PermissionsHelperActivity a;

    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.a.d;
        permissionsCallback.onFailure(-2);
        this.a.finish();
    }
}
