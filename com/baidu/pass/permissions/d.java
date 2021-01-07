package com.baidu.pass.permissions;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
/* loaded from: classes4.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f4155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PermissionsHelperActivity permissionsHelperActivity) {
        this.f4155a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f4155a.getPackageName(), null));
        this.f4155a.startActivityForResult(intent, 8000);
    }
}
