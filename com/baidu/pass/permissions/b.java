package com.baidu.pass.permissions;

import android.view.View;
import com.baidu.pass.common.SharedPreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PermissionsHelperActivity f9368a;

    public b(PermissionsHelperActivity permissionsHelperActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {permissionsHelperActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9368a = permissionsHelperActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StringBuilder sb;
        PermissionsDTO permissionsDTO;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            sb = this.f9368a.f9365e;
            SharedPreferencesUtil.put(sb.toString(), Boolean.TRUE);
            PermissionsHelperActivity permissionsHelperActivity = this.f9368a;
            permissionsDTO = permissionsHelperActivity.f9363c;
            permissionsHelperActivity.requestPermissions(permissionsDTO.permissions, PermissionsHelperActivity.f9362b);
        }
    }
}
