package c.a.t0.a.e;

import android.app.Activity;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.Stack;
/* loaded from: classes4.dex */
public final class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Stack<WeakReference<Activity>> f29710a;

    /* loaded from: classes4.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f29711a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(936252511, "Lc/a/t0/a/e/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(936252511, "Lc/a/t0/a/e/d$a;");
                    return;
                }
            }
            f29711a = new d((byte) 0);
        }
    }

    public /* synthetic */ d(byte b2) {
        this();
    }

    public final Stack<WeakReference<Activity>> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f29710a : (Stack) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < this.f29710a.size(); i2++) {
                Activity activity = this.f29710a.get(i2).get();
                if (activity != null) {
                    sb.append(activity.getClass().getSimpleName());
                    sb.append("->");
                }
            }
            return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "没有路径了";
        }
        return (String) invokeV.objValue;
    }

    public final void c(WeakReference<Activity> weakReference) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, weakReference) == null) {
            this.f29710a.add(weakReference);
        }
    }

    public final void d(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, activity) == null) {
            if (this.f29710a != null) {
                for (int i2 = 0; i2 < this.f29710a.size(); i2++) {
                    if (this.f29710a.get(i2).get() == activity) {
                        Stack<WeakReference<Activity>> stack = this.f29710a;
                        stack.remove(stack.get(i2));
                    }
                }
            }
            b();
        }
    }

    public d() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f29710a = new Stack<>();
    }
}
