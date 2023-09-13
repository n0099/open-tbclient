package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.al1;
import com.baidu.tieba.uk1;
import com.baidu.tieba.yk1;
import com.baidu.tieba.zk1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ServerProvider() {
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

    public static String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return uk1.a().getPackageName() + ".provider.ipc.server";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return f();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public List<yk1> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<yk1> a = al1.a(b());
            if (a == null) {
                a = new ArrayList<>();
            }
            a.add(0, new zk1());
            return a;
        }
        return (List) invokeV.objValue;
    }
}
