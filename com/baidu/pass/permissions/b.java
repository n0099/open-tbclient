package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9691a;

    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9691a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.f9691a.f9688e;
        SharedPreferencesUtil.put(sb.toString(), Boolean.TRUE);
        PermissionsHelperActivity permissionsHelperActivity = this.f9691a;
        permissionsDTO = permissionsHelperActivity.f9686c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, PermissionsHelperActivity.f9685b);
    }
}
