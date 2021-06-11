package com.baidu.pass.permissions;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.tieba.service.AsInstallService;
/* loaded from: classes2.dex */
public class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9271a;

    public d(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9271a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts(AsInstallService.SCHEME_PACKAGE_ADDED, this.f9271a.getPackageName(), null));
        this.f9271a.startActivityForResult(intent, 8000);
    }
}
