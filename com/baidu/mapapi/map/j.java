package com.baidu.mapapi.map;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class j implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f41742a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f41743b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f41744c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ HeatMap f41745d;

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
        this.f41745d = heatMap;
        this.f41742a = i2;
        this.f41743b = i3;
        this.f41744c = i4;
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41745d.b(this.f41742a, this.f41743b, this.f41744c);
        }
    }
}
