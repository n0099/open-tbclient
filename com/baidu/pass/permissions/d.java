package com.baidu.pass.permissions;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
/* loaded from: classes9.dex */
class d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2804a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2804a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f2804a.getPackageName(), null));
        this.f2804a.startActivityForResult(intent, CoolPraiseGuideLottieView.ANIM_DURATION);
    }
}
