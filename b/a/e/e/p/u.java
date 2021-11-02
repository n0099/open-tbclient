package b.a.e.e.p;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class u {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Field f2059a;

    /* renamed from: b  reason: collision with root package name */
    public static Field f2060b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Handler f2061a;

        public a(Handler handler) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {handler};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2061a = handler;
        }

        @Override // android.os.Handler
        public void dispatchMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                try {
                    super.dispatchMessage(message);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                try {
                    if (this.f2061a != null) {
                        this.f2061a.handleMessage(message);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1082609856, "Lb/a/e/e/p/u;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1082609856, "Lb/a/e/e/p/u;");
                return;
            }
        }
        try {
            if (Build.VERSION.SDK_INT < 28) {
                Field declaredField = Toast.class.getDeclaredField("mTN");
                f2059a = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = f2059a.getType().getDeclaredField("mHandler");
                f2060b = declaredField2;
                declaredField2.setAccessible(true);
            }
        } catch (Exception unused) {
        }
    }

    public static void a(Toast toast) {
        Object obj;
        Handler handler;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, toast) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 28 || f2059a == null || f2060b == null || (obj = f2059a.get(toast)) == null || (handler = (Handler) f2060b.get(obj)) == null) {
                    return;
                }
                f2060b.set(obj, new a(handler));
            } catch (Exception unused) {
            }
        }
    }
}
