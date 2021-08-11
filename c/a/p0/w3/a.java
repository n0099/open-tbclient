package c.a.p0.w3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f27840a;

    /* renamed from: b  reason: collision with root package name */
    public float f27841b;

    /* renamed from: c  reason: collision with root package name */
    public float f27842c;

    /* renamed from: d  reason: collision with root package name */
    public float f27843d;

    /* renamed from: e  reason: collision with root package name */
    public float f27844e;

    /* renamed from: f  reason: collision with root package name */
    public float f27845f;

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
            }
        }
    }

    public static a a(int i2, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            a aVar = new a();
            aVar.f27840a = i2;
            aVar.f27841b = f2;
            aVar.f27842c = f3;
            aVar.f27843d = f4;
            aVar.f27844e = f5;
            aVar.f27845f = f6;
            return aVar;
        }
        return (a) invokeCommon.objValue;
    }

    public static a b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 != 4) {
                                if (i2 != 5) {
                                    return null;
                                }
                                return a(i2, 0.47f, 3.0f, 2.14f, 1.41f, 1.03f);
                            }
                            return a(i2, 0.53f, 3.0f, 1.64f, 1.08f, 0.62f);
                        }
                        return a(i2, 0.59f, 3.0f, 1.11f, 0.71f, 0.67f);
                    }
                    return a(i2, 0.1f, 2.0f, 0.39f, 0.31f, 0.66f);
                }
                return a(i2, 0.1f, 1.0f, 0.0f, 0.0f, 0.09f);
            }
            return a(i2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        return (a) invokeI.objValue;
    }
}
