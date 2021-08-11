package com.baidu.ar.g;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class c extends d implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<a> mj;
    public b xS;

    public c() {
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

    @Override // com.baidu.ar.d
    public void a(com.baidu.ar.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) && (cVar instanceof a)) {
            a aVar = (a) cVar;
            this.mj = new WeakReference<>(aVar);
            b bVar = this.xS;
            if (bVar != null) {
                aVar.a(bVar);
            }
        }
    }

    @Override // com.baidu.ar.g.a
    public void a(b bVar) {
        WeakReference<a> weakReference;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.xS = bVar;
            if (bVar == null || (weakReference = this.mj) == null || weakReference.get() == null) {
                return;
            }
            this.mj.get().a(this.xS);
        }
    }

    @Override // com.baidu.ar.d
    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            WeakReference<a> weakReference = this.mj;
            if (weakReference != null) {
                weakReference.clear();
                this.mj = null;
            }
            this.xS = null;
        }
    }
}
