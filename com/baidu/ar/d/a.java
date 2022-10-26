package com.baidu.ar.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.databasic.AlgoHandleAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes.dex */
public abstract class a implements k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CopyOnWriteArrayList mu;
    public e mv;
    public e mw;
    public l mx;

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
                return;
            }
        }
        this.mu = new CopyOnWriteArrayList();
    }

    @Override // com.baidu.ar.d.k
    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.mw = eVar;
            this.mv = new e(this) { // from class: com.baidu.ar.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a my;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.my = this;
                }

                @Override // com.baidu.ar.d.e
                public void a(b bVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, bVar) == null) {
                        if (this.my.mu != null && this.my.mu.size() > 0) {
                            Iterator it = this.my.mu.iterator();
                            while (it.hasNext()) {
                                e eVar2 = (e) it.next();
                                if (bVar.de() > 0) {
                                    AlgoHandleAdapter.increaseHandleReference(bVar.de());
                                }
                                eVar2.a(bVar);
                            }
                        }
                        if (this.my.mw != null) {
                            this.my.mw.a(bVar);
                        }
                    }
                }

                @Override // com.baidu.ar.d.e
                public void a(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lVar) == null) {
                        this.my.mx = lVar;
                        if (this.my.mw != null) {
                            this.my.mw.a(lVar);
                        }
                        if (this.my.mu == null || this.my.mu.size() <= 0) {
                            return;
                        }
                        Iterator it = this.my.mu.iterator();
                        while (it.hasNext()) {
                            ((e) it.next()).a(lVar);
                        }
                    }
                }

                @Override // com.baidu.ar.d.e
                public void b(l lVar) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, lVar) == null) {
                        if (this.my.mw != null) {
                            this.my.mw.b(lVar);
                        }
                        if (this.my.mu == null || this.my.mu.size() <= 0) {
                            return;
                        }
                        Iterator it = this.my.mu.iterator();
                        while (it.hasNext()) {
                            ((e) it.next()).b(lVar);
                        }
                    }
                }
            };
        }
    }

    public void b(e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, eVar) == null) || (copyOnWriteArrayList = this.mu) == null) {
            return;
        }
        copyOnWriteArrayList.add(eVar);
        l lVar = this.mx;
        if (lVar != null) {
            eVar.a(lVar);
        }
    }

    public void c(e eVar) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || (copyOnWriteArrayList = this.mu) == null) {
            return;
        }
        copyOnWriteArrayList.remove(eVar);
    }

    public void d(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, eVar) == null) {
            this.mw = eVar;
        }
    }

    public boolean db() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.mu;
            return copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.ar.d.k
    public void release() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (copyOnWriteArrayList = this.mu) == null) {
            return;
        }
        copyOnWriteArrayList.clear();
        this.mu = null;
    }
}
