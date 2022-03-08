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
    public String f34423b;

    /* renamed from: c  reason: collision with root package name */
    public Point f34424c;

    /* renamed from: d  reason: collision with root package name */
    public String f34425d;

    /* renamed from: e  reason: collision with root package name */
    public String f34426e;

    /* renamed from: f  reason: collision with root package name */
    public String f34427f;

    /* renamed from: g  reason: collision with root package name */
    public int f34428g;

    /* renamed from: h  reason: collision with root package name */
    public String f34429h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f34430i;

    /* renamed from: j  reason: collision with root package name */
    public String f34431j;

    public FavSyncPoi() {
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
}
