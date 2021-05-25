package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9212a;

    public b(PermissionsHelperActivity permissionsHelperActivity) {
        this.f9212a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        sb = this.f9212a.f9209e;
        SharedPreferencesUtil.put(sb.toString(), Boolean.TRUE);
        PermissionsHelperActivity permissionsHelperActivity = this.f9212a;
        permissionsDTO = permissionsHelperActivity.f9207c;
        permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, PermissionsHelperActivity.f9206b);
    }
}
