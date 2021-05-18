package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.common.Log;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.pass.view.CommonDialog;
/* loaded from: classes2.dex */
public class PermissionsHelperActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9305a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9306b = 8001;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f9307c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f9308d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f9309e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9310f;

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.f9308d.onSuccess();
            } else {
                this.f9308d.onFailure(-1);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9307c = PassPermissions.getInstance().getPermissionsDTO();
        PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
        this.f9308d = permissionsCallback;
        if (this.f9307c == null) {
            if (permissionsCallback != null) {
                permissionsCallback.onFailure(-1);
            }
            finish();
            return;
        }
        this.f9309e = new StringBuilder();
        for (String str : this.f9307c.permissions) {
            this.f9309e.append(str);
        }
        SharedPreferencesUtil.getInstance(this);
        if (!((Boolean) SharedPreferencesUtil.get(this.f9309e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f9307c.dialogTitle)) {
            new CommonDialog.Builder(this).setTitle(this.f9307c.dialogTitle).setMessage(this.f9307c.dialogMsg).setDarkMode(this.f9307c.isDarkMode).setPositiveBtn(this.f9307c.okBtnTxt, new b(this)).setNegativeButton(this.f9307c.cancleBtnTxt, new a(this)).build().show();
            this.f9310f = true;
            return;
        }
        requestPermissions(this.f9307c.permissions, f9306b);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        if (i2 != 8001) {
            return;
        }
        boolean z = false;
        boolean z2 = true;
        for (int i3 = 0; i3 < strArr.length; i3++) {
            if (iArr[i3] == 0) {
                Log.i(PassPermissions.TAG, "Permission check result is permission granted");
            } else if (TextUtils.isEmpty(this.f9307c.dialogMsg)) {
                this.f9308d.onFailure(-1);
                finish();
                return;
            } else {
                if (!shouldShowRequestPermissionRationale(strArr[i3])) {
                    z = true;
                }
                z2 = false;
            }
        }
        if (z && !this.f9310f && this.f9307c.showExplainDialogAfterForbid) {
            new CommonDialog.Builder(this).setTitle(this.f9307c.dialogTitle).setMessage(this.f9307c.dialogMsg).setPositiveBtn(this.f9307c.okBtnTxt, new d(this)).setNegativeButton(this.f9307c.cancleBtnTxt, new c(this)).build().show();
        } else if (z2) {
            this.f9308d.onSuccess();
            finish();
        } else {
            this.f9308d.onFailure(-1);
            finish();
        }
    }
}
