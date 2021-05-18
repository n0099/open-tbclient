package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9311a;

    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9311a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9311a.f9308d;
        permissionsCallback.onFailure(-2);
        this.f9311a.finish();
    }
}
