package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9783a;

    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9783a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.f9783a.f9780e;
        SharedPreferencesUtil.put(sb.toString(), Boolean.TRUE);
        PermissionsHelperActivity permissionsHelperActivity = this.f9783a;
        permissionsDTO = permissionsHelperActivity.f9778c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, PermissionsHelperActivity.f9777b);
    }
}
