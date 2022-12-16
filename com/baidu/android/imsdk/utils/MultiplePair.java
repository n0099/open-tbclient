package com.baidu.android.imsdk.utils;

import android.util.Pair;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class MultiplePair<F, S, EX1, EX2> extends Pair<F, S> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EX2 fourth;
    public EX1 third;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiplePair(F f, S s, EX1 ex1, EX2 ex2) {
        super(f, s);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {f, s, ex1, ex2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(objArr2[0], objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.third = ex1;
        this.fourth = ex2;
    }
}
