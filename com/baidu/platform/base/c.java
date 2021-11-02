package com.baidu.platform.base;

import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f42036a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f42037b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f42038c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f42039d;

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
        this.f42039d = aVar;
        this.f42036a = dVar;
        this.f42037b = searchResult;
        this.f42038c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42036a == null) {
            return;
        }
        this.f42039d.f42027a.lock();
        try {
            this.f42036a.a(this.f42037b, this.f42038c);
        } finally {
            this.f42039d.f42027a.unlock();
        }
    }
}
