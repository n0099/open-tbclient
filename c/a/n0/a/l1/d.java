package c.a.n0.a.l1;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public interface d {
    public static final d a = new a();

    /* loaded from: classes.dex */
    public static class a implements d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.n0.a.l1.d
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            }
        }

        @Override // c.a.n0.a.l1.d
        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // c.a.n0.a.l1.d
        public Object c(Activity activity, String str, b bVar, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{activity, str, bVar, Boolean.valueOf(z)})) == null) {
                return null;
            }
            return invokeCommon.objValue;
        }

        @Override // c.a.n0.a.l1.d
        public void d(Activity activity, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048579, this, activity, obj) == null) {
            }
        }

        @Override // c.a.n0.a.l1.d
        public boolean e(Activity activity, int i, String[] strArr, int[] iArr, Object obj) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{activity, Integer.valueOf(i), strArr, iArr, obj})) == null) {
                return false;
            }
            return invokeCommon.booleanValue;
        }

        @Override // c.a.n0.a.l1.d
        public void f(Activity activity, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048581, this, activity, obj) == null) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    void a(String str);

    boolean b();

    Object c(Activity activity, String str, b bVar, boolean z);

    void d(Activity activity, Object obj);

    boolean e(Activity activity, int i, String[] strArr, int[] iArr, Object obj);

    void f(Activity activity, Object obj);
}
