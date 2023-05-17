package com.baidu.pass.permissions;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
/* loaded from: classes3.dex */
public class d implements View.OnClickListener {
    public final /* synthetic */ PermissionsHelperActivity a;

    public d(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
        this.a.startActivityForResult(intent, 8000);
    }
}
