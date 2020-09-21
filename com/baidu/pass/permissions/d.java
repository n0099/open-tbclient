package com.baidu.pass.permissions;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
/* loaded from: classes6.dex */
class d implements View.OnClickListener {
    final /* synthetic */ PermissionsHelperActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.a.getPackageName(), null));
        this.a.startActivityForResult(intent, CoolPraiseGuideLottieView.ANIM_DURATION);
    }
}
