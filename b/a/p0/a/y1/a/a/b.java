package b.a.p0.a.y1.a.a;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import b.a.p0.a.k;
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
    public static final boolean f9437a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1585095338, "Lb/a/p0/a/y1/a/a/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1585095338, "Lb/a/p0/a/y1/a/a/b;");
                return;
            }
        }
        f9437a = k.f6863a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static void a(int i2, String str, String str2, @Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), str, str2, bundle}) == null) {
            a b2 = b(str);
            if (b2 == null) {
                if (!f9437a) {
                    c(i2, str2, null);
                    return;
                }
                throw new RuntimeException("Messenger创建代理类失败");
            }
            if (f9437a) {
                String str3 = "exec call messenger delegation: " + str;
            }
            if (bundle == null) {
                bundle = new Bundle();
            }
            b2.f9433a = bundle;
            b2.f9434b = i2;
            b2.f9435c = str2;
            b2.b(bundle);
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public static a b(@Nullable String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                boolean z = f9437a;
                return null;
            }
            try {
                Class<?> cls = Class.forName(str);
                if (cls == null) {
                    if (f9437a) {
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
                        if (f9437a) {
                            throw new RuntimeException("Messenger代理类不是:" + a.class.getName());
                        }
                        return null;
                    }
                    return (a) newInstance;
                }
                if (f9437a) {
                    throw new RuntimeException("Messenger代理类不合法：" + str);
                }
                return null;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                if (f9437a) {
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
        if (!(interceptable == null || interceptable.invokeILL(65539, null, i2, str, bundle) == null) || b.a.p0.a.y1.a.b.d.a.a(str)) {
            return;
        }
        if (f9437a) {
            String str2 = "send result to client: " + i2 + " observer: " + str;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_observer_id", str);
        if (bundle != null) {
            bundle2.putBundle("key_result_data", bundle);
        }
        if (i2 == -1000) {
            b.a.p0.a.y1.c.d.a.f(bundle2);
        } else {
            b.a.p0.a.y1.c.d.a.e(i2, bundle2);
        }
    }
}
