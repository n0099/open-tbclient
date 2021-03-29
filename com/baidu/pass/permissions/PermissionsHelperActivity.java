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
    public static final int f9777a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9778b = 8001;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f9779c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f9780d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f9781e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9782f;

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 8000) {
            if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                this.f9780d.onSuccess();
            } else {
                this.f9780d.onFailure(-1);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9779c = PassPermissions.getInstance().getPermissionsDTO();
        PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
        this.f9780d = permissionsCallback;
        if (this.f9779c == null) {
            if (permissionsCallback != null) {
                permissionsCallback.onFailure(-1);
            }
            finish();
            return;
        }
        this.f9781e = new StringBuilder();
        for (String str : this.f9779c.permissions) {
            this.f9781e.append(str);
        }
        SharedPreferencesUtil.getInstance(this);
        if (!((Boolean) SharedPreferencesUtil.get(this.f9781e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f9779c.dialogTitle)) {
            new CommonDialog.Builder(this).setTitle(this.f9779c.dialogTitle).setMessage(this.f9779c.dialogMsg).setDarkMode(this.f9779c.isDarkMode).setPositiveBtn(this.f9779c.okBtnTxt, new b(this)).setNegativeButton(this.f9779c.cancleBtnTxt, new a(this)).build().show();
            this.f9782f = true;
            return;
        }
        requestPermissions(this.f9779c.permissions, f9778b);
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
            } else if (TextUtils.isEmpty(this.f9779c.dialogMsg)) {
                this.f9780d.onFailure(-1);
                finish();
                return;
            } else {
                if (!shouldShowRequestPermissionRationale(strArr[i2])) {
                    z = true;
                }
                z2 = false;
            }
        }
        if (z && !this.f9782f && this.f9779c.showExplainDialogAfterForbid) {
            new CommonDialog.Builder(this).setTitle(this.f9779c.dialogTitle).setMessage(this.f9779c.dialogMsg).setPositiveBtn(this.f9779c.okBtnTxt, new d(this)).setNegativeButton(this.f9779c.cancleBtnTxt, new c(this)).build().show();
        } else if (z2) {
            this.f9780d.onSuccess();
            finish();
        } else {
            this.f9780d.onFailure(-1);
            finish();
        }
    }
}
