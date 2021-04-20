package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9343a;

    public c(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9343a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9343a.f9338d;
        permissionsCallback.onFailure(-1);
        this.f9343a.finish();
    }
}
