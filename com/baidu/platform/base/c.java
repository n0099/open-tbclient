package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f9386a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f9387b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f9388c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f9389d;

    public c(a aVar, d dVar, SearchResult searchResult, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, dVar, searchResult, obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f9389d = aVar;
        this.f9386a = dVar;
        this.f9387b = searchResult;
        this.f9388c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f9386a == null) {
            return;
        }
        this.f9389d.f9377a.lock();
        try {
            this.f9386a.a(this.f9387b, this.f9388c);
        } finally {
            this.f9389d.f9377a.unlock();
        }
    }
}
