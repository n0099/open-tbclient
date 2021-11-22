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
    public final /* synthetic */ d f42884a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SearchResult f42885b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f42886c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f42887d;

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
        this.f42887d = aVar;
        this.f42884a = dVar;
        this.f42885b = searchResult;
        this.f42886c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f42884a == null) {
            return;
        }
        this.f42887d.f42875a.lock();
        try {
            this.f42884a.a(this.f42885b, this.f42886c);
        } finally {
            this.f42887d.f42875a.unlock();
        }
    }
}
