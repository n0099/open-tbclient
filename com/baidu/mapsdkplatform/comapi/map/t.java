package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f26746b;

    /* renamed from: c  reason: collision with root package name */
    public String f26747c;

    /* renamed from: d  reason: collision with root package name */
    public String f26748d;

    /* renamed from: e  reason: collision with root package name */
    public int f26749e;

    /* renamed from: f  reason: collision with root package name */
    public int f26750f;

    /* renamed from: g  reason: collision with root package name */
    public GeoPoint f26751g;

    /* renamed from: h  reason: collision with root package name */
    public int f26752h;
    public int i;
    public boolean j;
    public int k;
    public int l;

    public t() {
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
}
