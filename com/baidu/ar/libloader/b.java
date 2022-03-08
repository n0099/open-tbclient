package com.baidu.ar.libloader;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.ARType;
import com.baidu.ar.libloader.ILibLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b implements ILibLoader {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean sM;
    public d sN;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.sM = false;
        this.sN = new d();
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void load(Context context, ILibLoader.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bVar) == null) {
            this.sM = true;
            this.sN.fi();
            this.sN.clearAll();
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void prepareCaseRes(ARType aRType, String str, String str2, ILibLoader.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aRType, str, str2, aVar) == null) || aVar == null) {
            return;
        }
        aVar.a(aRType, str, str2);
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void release() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (dVar = this.sN) == null) {
            return;
        }
        dVar.clearAll();
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void require(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            System.loadLibrary(str);
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibLoadPlugin(ILibLoaderPlugin iLibLoaderPlugin) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iLibLoaderPlugin) == null) {
        }
    }

    @Override // com.baidu.ar.libloader.ILibLoader
    public void setLibReadyListener(String str, ILibLoader.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048581, this, str, cVar) == null) || cVar == null) {
            return;
        }
        if (this.sM) {
            cVar.onReady();
        } else {
            this.sN.a(str, cVar);
        }
    }
}
