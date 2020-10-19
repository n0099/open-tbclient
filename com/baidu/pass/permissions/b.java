package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes9.dex */
class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PermissionsHelperActivity f2798a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.f2798a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.f2798a.e;
        SharedPreferencesUtil.put(sb.toString(), true);
        PermissionsHelperActivity permissionsHelperActivity = this.f2798a;
        permissionsDTO = permissionsHelperActivity.c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, 8001);
    }
}
