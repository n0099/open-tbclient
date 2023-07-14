package com.baidu.tbadk.core.util.resourceLoaderProc;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.imageManager.TbImageMemoryCache;
import com.baidu.tieba.jn;
import com.baidu.tieba.pg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SimpleForeverMemoryLoaderProc extends SimpleLoaderProc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleForeverMemoryLoaderProc(boolean z, boolean z2, boolean z3, int i) {
        super(z, z2, z3, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Boolean) objArr2[0]).booleanValue(), ((Boolean) objArr2[1]).booleanValue(), ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.tg
    public jn getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            jn E = TbImageMemoryCache.v().E(str);
            if (z) {
                if (E != null) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                pg.i(z2, System.currentTimeMillis() - currentTimeMillis);
            }
            return E;
        }
        return (jn) invokeCommon.objValue;
    }

    @Override // com.baidu.tbadk.core.util.resourceLoaderProc.AbstractImageLoaderProc, com.baidu.tieba.tg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) && (obj instanceof jn)) {
            jn jnVar = (jn) obj;
            if (jnVar.u()) {
                long currentTimeMillis = System.currentTimeMillis();
                jnVar.A(i);
                jnVar.z(i2);
                TbImageMemoryCache.v().o(str, jnVar);
                pg.l(true, System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }
}
