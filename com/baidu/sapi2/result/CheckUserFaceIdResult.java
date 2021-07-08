package com.baidu.sapi2.result;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class CheckUserFaceIdResult extends SapiResult {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int STATUS_AVAILABLE = 1;
    public static final int STATUS_UNAVAILABLE = 3;
    public static final int STATUS_UNREGISTER = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public String action;
    public String authWidgetURL;
    public String authsid;
    public boolean faceLoginSwitch;
    public String livingUname;
    public int status;

    public CheckUserFaceIdResult() {
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
