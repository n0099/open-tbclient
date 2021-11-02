package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40174a;

    /* renamed from: b  reason: collision with root package name */
    public String f40175b;

    /* renamed from: c  reason: collision with root package name */
    public String f40176c;

    /* renamed from: d  reason: collision with root package name */
    public String f40177d;

    /* renamed from: e  reason: collision with root package name */
    public int f40178e;

    /* renamed from: f  reason: collision with root package name */
    public int f40179f;

    /* renamed from: g  reason: collision with root package name */
    public GeoPoint f40180g;

    /* renamed from: h  reason: collision with root package name */
    public int f40181h;

    /* renamed from: i  reason: collision with root package name */
    public int f40182i;
    public boolean j;
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
