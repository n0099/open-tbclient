package com.baidu.tbadk.core.diskCache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import b.a.e.f.m.f;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class ImagesInvalidReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String SUCCESS = "success";
    public transient /* synthetic */ FieldHolder $fh;

    public ImagesInvalidReceiver() {
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

    public static void broadcast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65537, null, z) == null) {
            Intent intent = new Intent(BdBaseApplication.getInst().getContext(), ImagesInvalidReceiver.class);
            intent.putExtra("success", z);
            f.a(BdBaseApplication.getInst().getContext(), intent);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) || intent == null) {
            return;
        }
        ImagesInvalidService.setSuccess(intent.getBooleanExtra("success", false));
    }
}
