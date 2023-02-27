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
    public static final int a = 8000;
    public static final int b = 8001;
    public PermissionsDTO c;
    public PermissionsCallback d;
    public StringBuilder e;
    public boolean f;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
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
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.c = PassPermissions.getInstance().getPermissionsDTO();
        PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
        this.d = permissionsCallback;
        if (this.c == null) {
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
        if (!((Boolean) SharedPreferencesUtil.get(this.e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.c.dialogTitle)) {
            new CommonDialog.Builder(this).setTitle(this.c.dialogTitle).setMessage(this.c.dialogMsg).setDarkMode(this.c.isDarkMode).setPositiveBtn(this.c.okBtnTxt, new b(this)).setNegativeButton(this.c.cancleBtnTxt, new a(this)).build().show();
            this.f = true;
            return;
        }
        requestPermissions(this.c.permissions, 8001);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i != 8001) {
            return;
        }
        boolean z = false;
        boolean z2 = true;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (iArr[i2] == 0) {
                Log.i(PassPermissions.TAG, "Permission check result is permission granted");
            } else if (TextUtils.isEmpty(this.c.dialogMsg)) {
                this.d.onFailure(-1);
                finish();
                return;
            } else {
                if (!shouldShowRequestPermissionRationale(strArr[i2])) {
                    z = true;
                }
                z2 = false;
            }
        }
        if (z && !this.f && this.c.showExplainDialogAfterForbid) {
            new CommonDialog.Builder(this).setTitle(this.c.dialogTitle).setMessage(this.c.dialogMsg).setPositiveBtn(this.c.okBtnTxt, new d(this)).setNegativeButton(this.c.cancleBtnTxt, new c(this)).build().show();
        } else if (z2) {
            this.d.onSuccess();
            finish();
        } else {
            this.d.onFailure(-1);
            finish();
        }
    }
}
