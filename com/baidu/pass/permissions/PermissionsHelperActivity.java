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
    public static final int f9335a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9336b = 8001;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f9337c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f9338d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f9339e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9340f;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.f9338d.onSuccess();
            } else {
                this.f9338d.onFailure(-1);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9337c = PassPermissions.getInstance().getPermissionsDTO();
        PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
        this.f9338d = permissionsCallback;
        if (this.f9337c == null) {
            if (permissionsCallback != null) {
                permissionsCallback.onFailure(-1);
            }
            finish();
            return;
        }
        this.f9339e = new StringBuilder();
        for (String str : this.f9337c.permissions) {
            this.f9339e.append(str);
        }
        SharedPreferencesUtil.getInstance(this);
        if (!((Boolean) SharedPreferencesUtil.get(this.f9339e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f9337c.dialogTitle)) {
            new CommonDialog.Builder(this).setTitle(this.f9337c.dialogTitle).setMessage(this.f9337c.dialogMsg).setDarkMode(this.f9337c.isDarkMode).setPositiveBtn(this.f9337c.okBtnTxt, new b(this)).setNegativeButton(this.f9337c.cancleBtnTxt, new a(this)).build().show();
            this.f9340f = true;
            return;
        }
        requestPermissions(this.f9337c.permissions, f9336b);
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
            } else if (TextUtils.isEmpty(this.f9337c.dialogMsg)) {
                this.f9338d.onFailure(-1);
                finish();
                return;
            } else {
                if (!shouldShowRequestPermissionRationale(strArr[i2])) {
                    z = true;
                }
                z2 = false;
            }
        }
        if (z && !this.f9340f && this.f9337c.showExplainDialogAfterForbid) {
            new CommonDialog.Builder(this).setTitle(this.f9337c.dialogTitle).setMessage(this.f9337c.dialogMsg).setPositiveBtn(this.f9337c.okBtnTxt, new d(this)).setNegativeButton(this.f9337c.cancleBtnTxt, new c(this)).build().show();
        } else if (z2) {
            this.f9338d.onSuccess();
            finish();
        } else {
            this.f9338d.onFailure(-1);
            finish();
        }
    }
}
