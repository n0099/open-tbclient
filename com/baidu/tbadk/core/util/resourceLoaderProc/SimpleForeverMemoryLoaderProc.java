package com.baidu.tbadk.core.util.resourceLoaderProc;

import c.a.e.l.d.a;
import c.a.q0.c0.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class SimpleForeverMemoryLoaderProc extends SimpleLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleForeverMemoryLoaderProc(boolean z, boolean z2, boolean z3, int i2) {
        super(z, z2, z3, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, c.a.e.e.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) && (obj instanceof a)) {
            a aVar = (a) obj;
            if (aVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                aVar.A(i2);
                aVar.z(i3);
                c.k().f(str, aVar);
                c.a.e.e.l.a.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, c.a.e.e.l.e
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a o = c.k().o(str);
            if (z) {
                c.a.e.e.l.a.i(o != null, System.currentTimeMillis() - currentTimeMillis);
            }
            return o;
        }
        return (a) invokeCommon.objValue;
    }
}
