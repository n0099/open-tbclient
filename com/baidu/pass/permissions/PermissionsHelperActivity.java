package com.baidu.pass.permissions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mytransformapp.util.LogUtil;
import com.baidu.pass.common.Log;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.pass.view.CommonDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PermissionsHelperActivity extends Activity {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int a = 8000;

    /* renamed from: b  reason: collision with root package name */
    public static final int f28150b = 8001;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public PermissionsDTO f28151c;

    /* renamed from: d  reason: collision with root package name */
    public PermissionsCallback f28152d;

    /* renamed from: e  reason: collision with root package name */
    public StringBuilder f28153e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28154f;

    public PermissionsHelperActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048576, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i == 8000) {
                if (PassPermissions.getInstance().a(PassPermissions.getInstance().getPermissionsDTO().permissions)) {
                    this.f28152d.onSuccess();
                } else {
                    this.f28152d.onFailure(-1);
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
            this.f28151c = PassPermissions.getInstance().getPermissionsDTO();
            PermissionsCallback permissionsCallback = PassPermissions.getInstance().getPermissionsCallback();
            this.f28152d = permissionsCallback;
            if (this.f28151c == null) {
                if (permissionsCallback != null) {
                    permissionsCallback.onFailure(-1);
                }
                finish();
                LogUtil.logActivity(this, "onCreate");
                return;
            }
            this.f28153e = new StringBuilder();
            for (String str : this.f28151c.permissions) {
                this.f28153e.append(str);
            }
            SharedPreferencesUtil.getInstance(this);
            if (!((Boolean) SharedPreferencesUtil.get(this.f28153e.toString(), Boolean.FALSE)).booleanValue() && !TextUtils.isEmpty(this.f28151c.dialogTitle)) {
                new CommonDialog.Builder(this).setTitle(this.f28151c.dialogTitle).setMessage(this.f28151c.dialogMsg).setDarkMode(this.f28151c.isDarkMode).setPositiveBtn(this.f28151c.okBtnTxt, new b(this)).setNegativeButton(this.f28151c.cancleBtnTxt, new a(this)).build().show();
                this.f28154f = true;
            } else {
                requestPermissions(this.f28151c.permissions, 8001);
            }
            LogUtil.logActivity(this, "onCreate");
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            if (i != 8001) {
                return;
            }
            boolean z = false;
            boolean z2 = true;
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (iArr[i2] == 0) {
                    Log.i(PassPermissions.TAG, "Permission check result is permission granted");
                } else if (TextUtils.isEmpty(this.f28151c.dialogMsg)) {
                    this.f28152d.onFailure(-1);
                    finish();
                    return;
                } else {
                    if (!shouldShowRequestPermissionRationale(strArr[i2])) {
                        z = true;
                    }
                    z2 = false;
                }
            }
            if (z && !this.f28154f && this.f28151c.showExplainDialogAfterForbid) {
                new CommonDialog.Builder(this).setTitle(this.f28151c.dialogTitle).setMessage(this.f28151c.dialogMsg).setPositiveBtn(this.f28151c.okBtnTxt, new d(this)).setNegativeButton(this.f28151c.cancleBtnTxt, new c(this)).build().show();
            } else if (z2) {
                this.f28152d.onSuccess();
                finish();
            } else {
                this.f28152d.onFailure(-1);
                finish();
            }
        }
    }
}
