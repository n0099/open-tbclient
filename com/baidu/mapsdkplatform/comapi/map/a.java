package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class a implements com.baidu.platform.comapi.b.b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // com.baidu.platform.comapi.b.b
    public byte[] a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return new byte[]{7, 5, 3, 0, 0, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.platform.comapi.b.b
    public String[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new String[]{"cfg/idrres/ResPackIndoorMap.rs", "cfg/idrres/DVIndoor.cfg", "cfg/idrres/baseindoormap.sty", "cfg/a/DVDirectory.cfg", "cfg/a/DVSDirectory.cfg", "cfg/a/DVHotcity.cfg", "cfg/a/DVVersion_pkg.cfg", "cfg/a/DVHotMap.cfg", "cfg/a/mode_1/map.rs", "cfg/a/mode_1/map.sty", "cfg/a/mode_1/reduct.rs", "cfg/a/mode_1/reduct.sty", "cfg/a/mode_1/traffic.rs", "cfg/a/mode_1/traffic.sty", "cfg/a/mode_1/indoor.rs", "cfg/a/mode_1/indoor.sty", "cfg/a/mode_2/map.sty"};
        }
        return (String[]) invokeV.objValue;
    }
}
