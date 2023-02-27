package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    public final /* synthetic */ PermissionsHelperActivity a;

    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.a.e;
        SharedPreferencesUtil.put(sb.toString(), Boolean.TRUE);
        PermissionsHelperActivity permissionsHelperActivity = this.a;
        permissionsDTO = permissionsHelperActivity.c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, 8001);
    }
}
