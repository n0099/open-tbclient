package com.baidu.fsg.face.liveness.livenessrouter;

import android.content.Context;
import com.baidu.fsg.base.router.BaseApplicationLogic;
import com.baidu.fsg.base.router.RouterManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class LivenessApplicationLogic extends BaseApplicationLogic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String actionName_liveness_recognize = "startLivenessRecognize";
    public static final String providerName = "LivenessProvider";
    public transient /* synthetic */ FieldHolder $fh;

    public LivenessApplicationLogic() {
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

    @Override // com.baidu.fsg.base.router.BaseApplicationLogic
    public void onCreate(Context context, HashMap<String, Object> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, hashMap) == null) {
            super.onCreate(context, hashMap);
            RouterManager.getInstance().registerProvider(providerName, new a());
        }
    }
}
