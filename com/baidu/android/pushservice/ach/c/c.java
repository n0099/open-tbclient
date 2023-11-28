package com.baidu.android.pushservice.ach.c;

import android.graphics.Region;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public Method b;
    public b c;
    public int d;

    /* loaded from: classes.dex */
    public class a implements com.baidu.android.pushservice.ach.c.e.a<Object[], Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.baidu.android.pushservice.ach.c.e.a
        public /* bridge */ /* synthetic */ Object a(Object[] objArr) {
            return Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15896, this, objArr);
        }

        /* renamed from: a  reason: avoid collision after fix types in other method */
        public Object a2(Object[] objArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, objArr)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15895, this, objArr) : invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, Region region);
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = 0;
    }

    public static /* synthetic */ b a(c cVar) {
        return (b) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-15890, null, cVar);
    }

    public boolean a(b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-15889, this, bVar) : invokeL.booleanValue;
    }
}
