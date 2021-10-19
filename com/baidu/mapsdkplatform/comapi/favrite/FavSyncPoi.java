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
    public String f42202a;

    /* renamed from: b  reason: collision with root package name */
    public String f42203b;

    /* renamed from: c  reason: collision with root package name */
    public Point f42204c;

    /* renamed from: d  reason: collision with root package name */
    public String f42205d;

    /* renamed from: e  reason: collision with root package name */
    public String f42206e;

    /* renamed from: f  reason: collision with root package name */
    public String f42207f;

    /* renamed from: g  reason: collision with root package name */
    public int f42208g;

    /* renamed from: h  reason: collision with root package name */
    public String f42209h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f42210i;

    /* renamed from: j  reason: collision with root package name */
    public String f42211j;

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
