package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9690a;

    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9690a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9690a.f9687d;
        permissionsCallback.onFailure(-2);
        this.f9690a.finish();
    }
}
