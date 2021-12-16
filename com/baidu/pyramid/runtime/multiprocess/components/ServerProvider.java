package com.baidu.pyramid.runtime.multiprocess.components;

import c.a.j0.b.a.e;
import c.a.j0.b.a.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class ServerProvider extends DispatchableContentProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ServerProvider() {
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

    public static String getCoreProviderAuthority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return e.a().getPackageName() + ".provider.ipc.server";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public String getAuthority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? getCoreProviderAuthority() : (String) invokeV.objValue;
    }

    @Override // com.baidu.pyramid.runtime.multiprocess.components.DispatchableContentProvider
    public List<a> getContentProviderDelegates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<a> a = c.a.j0.b.a.k.a.a(getAuthority());
            if (a == null) {
                a = new ArrayList<>();
            }
            a.add(0, new c.a.j0.b.a.j.a());
            return a;
        }
        return (List) invokeV.objValue;
    }
}
