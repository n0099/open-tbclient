package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final /* synthetic */ d a;
    public final /* synthetic */ SearchResult b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ a d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, searchResult, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = aVar;
        this.a = dVar;
        this.b = searchResult;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a != null) {
            this.d.a.lock();
            try {
                this.a.a(this.b, this.c);
            } finally {
                this.d.a.unlock();
            }
        }
    }
}
