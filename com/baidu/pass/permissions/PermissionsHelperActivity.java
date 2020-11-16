package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.pass.common.Log;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.pass.view.ConfirmDialog;
/* loaded from: classes10.dex */
public class PermissionsHelperActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static final int f2798a = 8000;
    private static final int b = 8001;
    private PermissionsDTO c;
    private PermissionsCallback d;
    private StringBuilder e;
    private boolean f;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.d.onSuccess();
            } else {
                this.d.onFailure(-1);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = PassPermissions.getInstance().getPermissionsDTO();
        this.d = PassPermissions.getInstance().getPermissionsCallback();
        if (this.c == null) {
            PermissionsCallback permissionsCallback = this.d;
            if (permissionsCallback != null) {
                permissionsCallback.onFailure(-1);
            }
            finish();
            return;
        }
        this.e = new StringBuilder();
        for (String str : this.c.permissions) {
            this.e.append(str);
        }
        SharedPreferencesUtil.getInstance(this);
        if (!((Boolean) SharedPreferencesUtil.get(this.e.toString(), false)).booleanValue() && !TextUtils.isEmpty(this.c.dialogTitle)) {
            new ConfirmDialog.Builder(this).setTitle(this.c.dialogTitle).setMessage(this.c.dialogMsg).setDarkMode(this.c.isDarkMode).setPositiveBtn(this.c.okBtnTxt, new b(this)).setNegativeButton(this.c.cancleBtnTxt, new a(this)).build().show();
            this.f = true;
            return;
        }
        requestPermissions(this.c.permissions, b);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == b) {
            boolean z = false;
            boolean z2 = true;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] == 0) {
                    Log.i(PassPermissions.TAG, "Permission check result is permission granted");
                } else if (TextUtils.isEmpty(this.c.dialogMsg)) {
                    this.d.onFailure(-1);
                    finish();
                    return;
                } else if (shouldShowRequestPermissionRationale(strArr[i2])) {
                    z2 = false;
                } else {
                    z = true;
                    z2 = false;
                }
            }
            if (z && !this.f && this.c.showExplainDialogAfterForbid) {
                new ConfirmDialog.Builder(this).setTitle(this.c.dialogTitle).setMessage(this.c.dialogMsg).setPositiveBtn(this.c.okBtnTxt, new d(this)).setNegativeButton(this.c.cancleBtnTxt, new c(this)).build().show();
            } else if (z2) {
                this.d.onSuccess();
                finish();
            } else {
                this.d.onFailure(-1);
                finish();
            }
        }
    }
}
