package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class FaceLoginStatusResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_AVAILABLE = 1;
    public static final int STATUS_UNREGISTER = 2;
    public static final int STATUS_UNREGISTER_NO_MOBILE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public String authWidgetURL;
    public String authsid;
    public boolean faceLoginSwitch;
    public String livingUname;
    public int status;

    public FaceLoginStatusResult() {
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
}
