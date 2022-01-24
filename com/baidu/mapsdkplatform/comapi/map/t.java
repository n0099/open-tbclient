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
    public String f35939b;

    /* renamed from: c  reason: collision with root package name */
    public String f35940c;

    /* renamed from: d  reason: collision with root package name */
    public String f35941d;

    /* renamed from: e  reason: collision with root package name */
    public int f35942e;

    /* renamed from: f  reason: collision with root package name */
    public int f35943f;

    /* renamed from: g  reason: collision with root package name */
    public GeoPoint f35944g;

    /* renamed from: h  reason: collision with root package name */
    public int f35945h;

    /* renamed from: i  reason: collision with root package name */
    public int f35946i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35947j;
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
