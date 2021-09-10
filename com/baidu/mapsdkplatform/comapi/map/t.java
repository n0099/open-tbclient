package com.baidu.mapsdkplatform.comapi.map;

import com.baidu.mapapi.model.inner.GeoPoint;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f42286a;

    /* renamed from: b  reason: collision with root package name */
    public String f42287b;

    /* renamed from: c  reason: collision with root package name */
    public String f42288c;

    /* renamed from: d  reason: collision with root package name */
    public String f42289d;

    /* renamed from: e  reason: collision with root package name */
    public int f42290e;

    /* renamed from: f  reason: collision with root package name */
    public int f42291f;

    /* renamed from: g  reason: collision with root package name */
    public GeoPoint f42292g;

    /* renamed from: h  reason: collision with root package name */
    public int f42293h;

    /* renamed from: i  reason: collision with root package name */
    public int f42294i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f42295j;
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
