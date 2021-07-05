package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.i.a.j.a;
import d.a.i.a.j.b;
/* loaded from: classes.dex */
public class BdPermissionActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String[] mPermissions;
    public int mReqCode;

    public BdPermissionActivity() {
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

    private void getRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            Intent intent = getIntent();
            this.mReqCode = intent.getIntExtra("request_code", 0);
            this.mPermissions = intent.getStringArrayExtra("permissions");
        }
    }

    private void requestPermissions() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (strArr = this.mPermissions) == null || strArr.length == 0) {
            return;
        }
        boolean z = false;
        for (String str : strArr) {
            z = z || ActivityCompat.shouldShowRequestPermissionRationale(this, str);
        }
        if (z) {
            ActivityCompat.requestPermissions(this, this.mPermissions, this.mReqCode);
        } else if (b.c(this, this.mReqCode)) {
            ActivityCompat.requestPermissions(this, this.mPermissions, this.mReqCode);
        } else {
            onRequestPermissionsResult(this.mReqCode, this.mPermissions, new int[0]);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bundle) == null) {
            super.onCreate(bundle);
            getRequest();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, strArr, iArr) == null) {
            ActivityCompat.OnRequestPermissionsResultCallback c2 = a.b().c(this.mReqCode);
            if (c2 != null) {
                c2.onRequestPermissionsResult(i2, strArr, iArr);
            }
            finish();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onResume();
            requestPermissions();
        }
    }
}
