package com.baidu.ar.arplay.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public static volatile d gA;
    public transient /* synthetic */ FieldHolder $fh;
    public List<c> gB;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1109054340, "Lcom/baidu/ar/arplay/d/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1109054340, "Lcom/baidu/ar/arplay/d/d;");
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gB = new ArrayList();
    }

    public static d bp() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (gA == null) {
                synchronized (d.class) {
                    if (gA == null) {
                        gA = new d();
                    }
                }
            }
            return gA;
        }
        return (d) invokeV.objValue;
    }

    public c b(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            List<c> list = this.gB;
            if (list != null) {
                for (c cVar : list) {
                    if (cVar != null && cVar.mTextureId == i2) {
                        cVar.f(i3, i4);
                        return cVar;
                    }
                }
            }
            c cVar2 = new c();
            cVar2.a(i2, i3, i4);
            List<c> list2 = this.gB;
            if (list2 != null) {
                list2.add(cVar2);
            }
            return cVar2;
        }
        return (c) invokeIII.objValue;
    }

    public c p(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            List<c> list = this.gB;
            if (list != null) {
                for (c cVar : list) {
                    if (cVar != null && cVar.mTextureId == i2) {
                        return cVar;
                    }
                }
                return null;
            }
            return null;
        }
        return (c) invokeI.objValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            List<c> list = this.gB;
            if (list != null) {
                for (c cVar : list) {
                    if (cVar != null) {
                        cVar.release();
                    }
                }
                this.gB.clear();
            }
            if (gA != null) {
                gA = null;
            }
        }
    }
}
