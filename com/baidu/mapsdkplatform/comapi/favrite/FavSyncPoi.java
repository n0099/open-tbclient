package com.baidu.mapsdkplatform.comapi.favrite;

import com.baidu.mapapi.model.inner.Point;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class FavSyncPoi {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41918a;

    /* renamed from: b  reason: collision with root package name */
    public String f41919b;

    /* renamed from: c  reason: collision with root package name */
    public Point f41920c;

    /* renamed from: d  reason: collision with root package name */
    public String f41921d;

    /* renamed from: e  reason: collision with root package name */
    public String f41922e;

    /* renamed from: f  reason: collision with root package name */
    public String f41923f;

    /* renamed from: g  reason: collision with root package name */
    public int f41924g;

    /* renamed from: h  reason: collision with root package name */
    public String f41925h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f41926i;

    /* renamed from: j  reason: collision with root package name */
    public String f41927j;

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
