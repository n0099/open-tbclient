package com.baidu.ar.statistic;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public final class m extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long wQ;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(d dVar, int i2, e eVar, boolean z) {
        super(dVar, i2, eVar, z);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dVar, Integer.valueOf(i2), eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((d) objArr2[0], ((Integer) objArr2[1]).intValue(), (e) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.wQ = 0L;
    }

    @Override // com.baidu.ar.statistic.i
    public List<List<a>> gn() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.wQ < 1000) {
                return null;
            }
            this.wQ = currentTimeMillis;
            List<List<a>> gn = super.gn();
            return gn.size() > 1 ? gn.subList(0, 1) : gn;
        }
        return (List) invokeV.objValue;
    }
}
