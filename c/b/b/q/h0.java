package c.b.b.q;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
/* loaded from: classes9.dex */
public class h0 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static h0 f27442c;
    public transient /* synthetic */ FieldHolder $fh;
    public l0 a;

    /* renamed from: b  reason: collision with root package name */
    public g f27443b;

    public h0() {
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

    public static h0 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (f27442c == null) {
                f27442c = new h0();
            }
            return f27442c;
        }
        return (h0) invokeV.objValue;
    }

    public void b(Object[] objArr, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048576, this, objArr, i2, i3) == null) {
            if (this.f27443b == null) {
                this.f27443b = new g();
            }
            this.f27443b.c(objArr, i2, i3);
        }
    }

    public <T> void c(T[] tArr, Comparator<? super T> comparator, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tArr, comparator, i2, i3) == null) {
            if (this.a == null) {
                this.a = new l0();
            }
            this.a.c(tArr, comparator, i2, i3);
        }
    }
}
