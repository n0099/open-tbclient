package com.baidu.pyramid.runtime.multiprocess.components;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ab1;
import com.repackage.bb1;
import com.repackage.cb1;
import com.repackage.wa1;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
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

    public static String getCoreProviderAuthority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return wa1.a().getPackageName() + ".provider.ipc.server";
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
    public List<ab1> getContentProviderDelegates() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            List<ab1> a = cb1.a(getAuthority());
            if (a == null) {
                a = new ArrayList<>();
            }
            a.add(0, new bb1());
            return a;
        }
        return (List) invokeV.objValue;
    }
}
