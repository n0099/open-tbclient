package com.baidu.nadcore.webarch.permission;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.appframework.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j11;
import com.repackage.m11;
import com.repackage.n11;
/* loaded from: classes2.dex */
public class NadPermissionActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int u;
    public String[] v;

    public NadPermissionActivity() {
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

    private void requestPermissions() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, this) == null) || (strArr = this.v) == null || strArr.length == 0) {
            return;
        }
        boolean z = false;
        for (String str : strArr) {
            z = z || j11.a(this, str);
        }
        if (z) {
            j11.requestPermissions(this, this.v, this.u);
        } else if (n11.a(this, this.u)) {
            j11.requestPermissions(this, this.v, this.u);
        } else {
            onRequestPermissionsResult(this.u, this.v, new int[0]);
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void P0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.P0(bundle);
            q1();
        }
    }

    @Override // com.baidu.nadcore.appframework.BaseActivity
    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.Z0();
            requestPermissions();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            j11.b c = m11.b().c(this.u);
            if (c != null) {
                c.onRequestPermissionsResult(i, strArr, iArr);
            }
            finish();
        }
    }

    public final void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Intent intent = getIntent();
            this.u = intent.getIntExtra("request_code", 0);
            this.v = intent.getStringArrayExtra("permissions");
        }
    }
}
