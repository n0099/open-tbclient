package b.a.k.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.LongSparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.browser.core.BdCore;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static g f3125b;

    /* renamed from: c  reason: collision with root package name */
    public static HashMap<String, b.a.k.a.q.f<String, Integer>> f3126c;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f3127a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1132244467, "Lb/a/k/a/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1132244467, "Lb/a/k/a/g;");
                return;
            }
        }
        f3126c = new HashMap<>();
    }

    public g() {
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
        new LongSparseArray();
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, str, str2) == null) {
        }
    }

    public static synchronized g b() {
        InterceptResult invokeV;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            synchronized (g.class) {
                if (f3125b == null) {
                    f3125b = new g();
                }
                gVar = f3125b;
            }
            return gVar;
        }
        return (g) invokeV.objValue;
    }

    @Deprecated
    public static int c(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            a(str2, str);
            b.a.k.a.q.f<String, Integer> fVar = f3126c.get(str);
            if (fVar == null) {
                fVar = new b.a.k.a.q.f<>(100);
                f3126c.put(str, fVar);
            }
            Integer c2 = fVar.c(str2);
            if (c2 == null) {
                try {
                    int identifier = b().getContext().getResources().getIdentifier(str2, str, b().getContext().getPackageName());
                    fVar.d(str2, Integer.valueOf(identifier));
                    return identifier;
                } catch (Error e2) {
                    e2.printStackTrace();
                    return 0;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    return 0;
                }
            }
            return c2.intValue();
        }
        return invokeLL.intValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            if (this.f3127a == null) {
                this.f3127a = BdCore.a().getContext();
            }
            Context context = this.f3127a;
            if (context != null) {
                return context;
            }
            throw new RuntimeException("context is null!");
        }
        return (Context) invokeV.objValue;
    }
}
