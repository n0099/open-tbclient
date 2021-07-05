package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f7157a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f7158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f7159c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f7160d;

    public j(HeatMap heatMap, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {heatMap, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7160d = heatMap;
        this.f7157a = i2;
        this.f7158b = i3;
        this.f7159c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f7160d.b(this.f7157a, this.f7158b, this.f7159c);
        }
    }
}
