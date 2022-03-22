package com.baidu.ar.d;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public static final i mY;
    public static final i mZ;
    public static final i na;
    public static final i nb;
    public static final i nc;
    public static final i nd;
    public static final i ne;
    public static final i nf;
    public static final i ng;
    public static final i nh;
    public static final i ni;
    public static final /* synthetic */ i[] nj;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1921023693, "Lcom/baidu/ar/d/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1921023693, "Lcom/baidu/ar/d/i;");
                return;
            }
        }
        mY = new i("TRACK2D", 0);
        mZ = new i("TRACK3D", 1);
        na = new i("RECG", 2);
        nb = new i("SEG", 3);
        nc = new i("SLAM", 4);
        nd = new i("GESTURE", 5);
        ne = new i("FACE", 6);
        nf = new i("STRETCH", 7);
        ng = new i("POSE", 8);
        nh = new i("CLOUD", 9);
        i iVar = new i("LOGO", 10);
        ni = iVar;
        nj = new i[]{mY, mZ, na, nb, nc, nd, ne, nf, ng, nh, iVar};
    }

    public i(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static i valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (i) Enum.valueOf(i.class, str) : (i) invokeL.objValue;
    }

    public static i[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (i[]) nj.clone() : (i[]) invokeV.objValue;
    }
}
