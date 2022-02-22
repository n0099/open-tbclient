package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f36145b;

    /* renamed from: c  reason: collision with root package name */
    public String f36146c;

    /* renamed from: d  reason: collision with root package name */
    public String f36147d;

    /* renamed from: e  reason: collision with root package name */
    public int f36148e;

    /* renamed from: f  reason: collision with root package name */
    public int f36149f;

    /* renamed from: g  reason: collision with root package name */
    public GeoPoint f36150g;

    /* renamed from: h  reason: collision with root package name */
    public int f36151h;

    /* renamed from: i  reason: collision with root package name */
    public int f36152i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36153j;
    public int k;
    public int l;

    public t() {
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
