package com.baidu.fsg.base.router;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class ErrorAction implements RouterAction {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39508a = "Action not implement";
    public transient /* synthetic */ FieldHolder $fh;

    public ErrorAction() {
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

    @Override // com.baidu.fsg.base.router.RouterAction
    public void invoke(Context context, HashMap hashMap, RouterCallback routerCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048576, this, context, hashMap, routerCallback) == null) || routerCallback == null) {
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("result", f39508a);
        routerCallback.onResult(RouterCallback.CODE_NOT_IMPLEMENT, hashMap2);
    }
}
