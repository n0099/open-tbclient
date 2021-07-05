package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.common.Log;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.pass.view.CommonDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PermissionsHelperActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final int f9344a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9345b = 8001;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f9346c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f9347d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f9348e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f9349f;

    public PermissionsHelperActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i2 == 8000) {
                if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                    this.f9347d.onSuccess();
                } else {
                    this.f9347d.onFailure(-1);
                }
                finish();
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            this.f9346c = PassPermissions.getInstance().getPermissionsDTO();
            PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
            this.f9347d = permissionsCallback;
            if (this.f9346c == null) {
                if (permissionsCallback != null) {
                    permissionsCallback.onFailure(-1);
                }
                finish();
                return;
            }
            this.f9348e = new StringBuilder();
            for (String str : this.f9346c.permissions) {
                this.f9348e.append(str);
            }
            SharedPreferencesUtil.getInstance(this);
            if (!((Boolean) SharedPreferencesUtil.get(this.f9348e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f9346c.dialogTitle)) {
                new CommonDialog.Builder(this).setTitle(this.f9346c.dialogTitle).setMessage(this.f9346c.dialogMsg).setDarkMode(this.f9346c.isDarkMode).setPositiveBtn(this.f9346c.okBtnTxt, new b(this)).setNegativeButton(this.f9346c.cancleBtnTxt, new a(this)).build().show();
                this.f9349f = true;
                return;
            }
            requestPermissions(this.f9346c.permissions, f9345b);
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i2, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i2, strArr, iArr);
            if (i2 != 8001) {
                return;
            }
            boolean z = false;
            boolean z2 = true;
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (iArr[i3] == 0) {
                    Log.i(PassPermissions.TAG, "Permission check result is permission granted");
                } else if (TextUtils.isEmpty(this.f9346c.dialogMsg)) {
                    this.f9347d.onFailure(-1);
                    finish();
                    return;
                } else {
                    if (!shouldShowRequestPermissionRationale(strArr[i3])) {
                        z = true;
                    }
                    z2 = false;
                }
            }
            if (z && !this.f9349f && this.f9346c.showExplainDialogAfterForbid) {
                new CommonDialog.Builder(this).setTitle(this.f9346c.dialogTitle).setMessage(this.f9346c.dialogMsg).setPositiveBtn(this.f9346c.okBtnTxt, new d(this)).setNegativeButton(this.f9346c.cancleBtnTxt, new c(this)).build().show();
            } else if (z2) {
                this.f9347d.onSuccess();
                finish();
            } else {
                this.f9347d.onFailure(-1);
                finish();
            }
        }
    }
}
