package com.baidu.ar.vo.c;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f extends a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.ar.vo.a.b zb;
    public com.baidu.ar.vo.b.a zc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar, com.baidu.ar.vo.a.b bVar, int i2, int i3) {
        super(dVar, i2, i3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, bVar, Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d) objArr2[0], ((Integer) objArr2[1]).intValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.zb = bVar;
    }

    private int b(float[] fArr, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65537, this, fArr, i2)) == null) ? 90.0f - ((float) (((Math.acos((double) (-fArr[10])) * 180.0d) * 1.0d) / 3.141592653589793d)) > ((float) i2) ? 0 : 1 : invokeLI.intValue;
    }

    public void a(com.baidu.ar.vo.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.zc = aVar;
        }
    }

    @Override // com.baidu.ar.vo.c.a, com.baidu.ar.vo.c.c
    public boolean q(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fArr)) == null) {
            float[] a2 = this.zc.a(this.zb.hg(), fArr);
            if (a2 != null) {
                String a3 = this.yw.a(this.zb);
                int i2 = (int) a2[0];
                if (i2 == 0) {
                    int b2 = b(fArr, this.zb.hg());
                    if (b2 == 0) {
                        this.yw.hl();
                    } else if (b2 == 1) {
                        this.yw.hm();
                    }
                    this.yw.r(new float[16]);
                } else if (i2 == 1) {
                    this.yw.a(a3, (int) a2[1], (int) a2[2], a.yY, this.zb.hf());
                    this.yw.hn();
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
