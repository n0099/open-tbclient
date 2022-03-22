package com.baidu.ar.vo.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e extends a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.vo.a.b zb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar, com.baidu.ar.vo.a.b bVar, int i, int i2) {
        super(dVar, i, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bVar, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zb = bVar;
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fArr)) == null) {
            String[] split = this.zb.he().split(",");
            String a = this.yw.a(this.zb);
            int i3 = this.mPreviewWidth / 2;
            int i4 = this.mPreviewHeight / 2;
            try {
                int[] b2 = this.yw.b(Float.parseFloat(split[0].trim()), Float.parseFloat(split[1].trim()));
                i3 = b2[0];
                i2 = b2[1];
                i = i3;
            } catch (NumberFormatException unused) {
                com.baidu.ar.h.b.aS("model position is not number !!!");
                i = i3;
                i2 = i4;
            }
            this.yw.a(a, i, i2, a.yY, this.zb.hf());
            return true;
        }
        return invokeL.booleanValue;
    }
}
