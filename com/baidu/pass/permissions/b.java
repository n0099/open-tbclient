package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes6.dex */
class b implements View.OnClickListener {
    final /* synthetic */ PermissionsHelperActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.a.e;
        SharedPreferencesUtil.put(sb.toString(), true);
        PermissionsHelperActivity permissionsHelperActivity = this.a;
        permissionsDTO = permissionsHelperActivity.c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, 8001);
    }
}
