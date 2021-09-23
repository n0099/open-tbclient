package c.a.p0.a.v1.a.a;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import c.a.p0.a.k;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f9212a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1454771598, "Lc/a/p0/a/v1/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1454771598, "Lc/a/p0/a/v1/a/a/b;");
                return;
            }
        }
        f9212a = k.f7085a;
    }

    public static void a(int i2, String str, String str2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, str2, bundle}) == null) {
            a b2 = b(str);
            if (b2 == null) {
                if (!f9212a) {
                    c(i2, str2, null);
                    return;
                }
                throw new RuntimeException("Messenger创建代理类失败");
            }
            if (f9212a) {
                String str3 = "exec call messenger delegation: " + str;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            b2.f9208a = bundle;
            b2.f9209b = i2;
            b2.f9210c = str2;
            b2.b(bundle);
        }
    }

    public static a b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f9212a;
                return null;
            }
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null) {
                    if (f9212a) {
                        throw new RuntimeException("Messenger代理类不存在：" + str);
                    }
                    return null;
                }
                int modifiers = cls.getModifiers();
                if (a.class.isAssignableFrom(cls) && !cls.isInterface() && !Modifier.isAbstract(modifiers)) {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    Object newInstance = declaredConstructor.newInstance(new Object[0]);
                    if (!(newInstance instanceof a)) {
                        if (f9212a) {
                            throw new RuntimeException("Messenger代理类不是:" + a.class.getName());
                        }
                        return null;
                    }
                    return (a) newInstance;
                }
                if (f9212a) {
                    throw new RuntimeException("Messenger代理类不合法：" + str);
                }
                return null;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                if (f9212a) {
                    e2.printStackTrace();
                    throw new RuntimeException(e2);
                }
                return null;
            }
        }
        return (a) invokeL.objValue;
    }

    public static void c(int i2, String str, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(65539, null, i2, str, bundle) == null) || c.a.p0.a.v1.a.b.d.a.a(str)) {
            return;
        }
        if (f9212a) {
            String str2 = "send result to client: " + i2 + " observer: " + str;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_observer_id", str);
        if (bundle != null) {
            bundle2.putBundle("key_result_data", bundle);
        }
        if (i2 == -1000) {
            c.a.p0.a.v1.c.d.a.f(bundle2);
        } else {
            c.a.p0.a.v1.c.d.a.e(i2, bundle2);
        }
    }
}
