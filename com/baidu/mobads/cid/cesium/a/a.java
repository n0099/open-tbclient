package com.baidu.mobads.cid.cesium.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public g[] f40507a;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f40507a = new g[]{new h(8, 0), new i(0, 1), new i(1, 1), new h(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        f fVar = new f();
        byte[] a2 = c.a(bArr, bArr.length + ((this.f40507a.length + 1) * f.f40513a));
        c.a(a2, fVar.a(), bArr.length);
        int i2 = 0;
        while (true) {
            g[] gVarArr = this.f40507a;
            if (i2 >= gVarArr.length) {
                return Arrays.copyOf(fVar.a(), f.f40513a);
            }
            g gVar = gVarArr[i2];
            i2++;
            int length = bArr.length + (f.f40513a * i2);
            fVar.a(gVar.a(a2, 0, length), gVar.a(), gVar.b(), gVar.c());
            c.a(a2, fVar.a(), length);
        }
    }
}
