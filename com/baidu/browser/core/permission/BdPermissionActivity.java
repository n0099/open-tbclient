package com.baidu.browser.core.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.permissionhelper.app.ActivityCompat;
import com.baidu.tieba.aw;
import com.baidu.tieba.zv;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class BdPermissionActivity extends Activity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public String[] b;

    public BdPermissionActivity() {
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

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Intent intent = getIntent();
            this.a = intent.getIntExtra("request_code", 0);
            this.b = intent.getStringArrayExtra("permissions");
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onResume();
            requestPermissions();
        }
    }

    private void requestPermissions() {
        String[] strArr;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, this) == null) && (strArr = this.b) != null && strArr.length != 0) {
            boolean z = false;
            for (String str : strArr) {
                if (!z && !ActivityCompat.shouldShowRequestPermissionRationale(this, str)) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (z) {
                ActivityCompat.requestPermissions(this, this.b, this.a);
            } else if (aw.c(this, this.a)) {
                ActivityCompat.requestPermissions(this, this.b, this.a);
            } else {
                onRequestPermissionsResult(this.a, this.b, new int[0]);
            }
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            a();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, strArr, iArr) == null) {
            ActivityCompat.OnRequestPermissionsResultCallback c = zv.b().c(this.a);
            if (c != null) {
                c.onRequestPermissionsResult(i, strArr, iArr);
            }
            finish();
        }
    }
}
