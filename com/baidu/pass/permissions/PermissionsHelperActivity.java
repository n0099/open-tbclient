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
    public static final int f9776a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9777b = 8001;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f9778c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f9779d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f9780e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9781f;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.f9779d.onSuccess();
            } else {
                this.f9779d.onFailure(-1);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9778c = PassPermissions.getInstance().getPermissionsDTO();
        PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
        this.f9779d = permissionsCallback;
        if (this.f9778c == null) {
            if (permissionsCallback != null) {
                permissionsCallback.onFailure(-1);
            }
            finish();
            return;
        }
        this.f9780e = new StringBuilder();
        for (String str : this.f9778c.permissions) {
            this.f9780e.append(str);
        }
        SharedPreferencesUtil.getInstance(this);
        if (!((Boolean) SharedPreferencesUtil.get(this.f9780e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f9778c.dialogTitle)) {
            new CommonDialog.Builder(this).setTitle(this.f9778c.dialogTitle).setMessage(this.f9778c.dialogMsg).setDarkMode(this.f9778c.isDarkMode).setPositiveBtn(this.f9778c.okBtnTxt, new b(this)).setNegativeButton(this.f9778c.cancleBtnTxt, new a(this)).build().show();
            this.f9781f = true;
            return;
        }
        requestPermissions(this.f9778c.permissions, f9777b);
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
            } else if (TextUtils.isEmpty(this.f9778c.dialogMsg)) {
                this.f9779d.onFailure(-1);
                finish();
                return;
            } else {
                if (!shouldShowRequestPermissionRationale(strArr[i2])) {
                    z = true;
                }
                z2 = false;
            }
        }
        if (z && !this.f9781f && this.f9778c.showExplainDialogAfterForbid) {
            new CommonDialog.Builder(this).setTitle(this.f9778c.dialogTitle).setMessage(this.f9778c.dialogMsg).setPositiveBtn(this.f9778c.okBtnTxt, new d(this)).setNegativeButton(this.f9778c.cancleBtnTxt, new c(this)).build().show();
        } else if (z2) {
            this.f9779d.onSuccess();
            finish();
        } else {
            this.f9779d.onFailure(-1);
            finish();
        }
    }
}
