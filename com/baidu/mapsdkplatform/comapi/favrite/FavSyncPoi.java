package com.baidu.mapsdkplatform.comapi.favrite;

import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class FavSyncPoi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f26636b;

    /* renamed from: c  reason: collision with root package name */
    public Point f26637c;

    /* renamed from: d  reason: collision with root package name */
    public String f26638d;

    /* renamed from: e  reason: collision with root package name */
    public String f26639e;

    /* renamed from: f  reason: collision with root package name */
    public String f26640f;

    /* renamed from: g  reason: collision with root package name */
    public int f26641g;

    /* renamed from: h  reason: collision with root package name */
    public String f26642h;
    public boolean i;
    public String j;

    public FavSyncPoi() {
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
