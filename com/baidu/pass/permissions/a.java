package com.baidu.pass.permissions;

import android.view.View;
/* loaded from: classes2.dex */
public class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9268a;

    public a(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9268a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PermissionsCallback permissionsCallback;
        permissionsCallback = this.f9268a.f9265d;
        permissionsCallback.onFailure(-2);
        this.f9268a.finish();
    }
}
