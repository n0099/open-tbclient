package c.f.a.c;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.eventbus.EventBus;
import com.dxmpay.apollon.eventbus.EventBusException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Map<Class<?>, Method> f32277a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1490872848, "Lc/f/a/c/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1490872848, "Lc/f/a/c/f;");
                return;
            }
        }
        f32277a = new HashMap();
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0070, code lost:
        r1 = c.f.a.c.f.f32277a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0072, code lost:
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0073, code lost:
        c.f.a.c.f.f32277a.put(r12, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Method a(Class<?> cls) {
        InterceptResult invokeL;
        Method method;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            synchronized (f32277a) {
                method = f32277a.get(cls);
            }
            if (method != null) {
                return method;
            }
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                String name = cls2.getName();
                if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                    break;
                }
                Method[] methods = cls2.getMethods();
                int length = methods.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Method method2 = methods[i2];
                        if (method2.getName().equals("onModuleEvent")) {
                            int modifiers = method2.getModifiers();
                            if ((modifiers & 1) != 0 && (modifiers & 1032) == 0) {
                                Class<?>[] parameterTypes = method2.getParameterTypes();
                                if (parameterTypes.length == 1 && parameterTypes[0] == EventBus.Event.class) {
                                    method = method2;
                                    break;
                                }
                            }
                        }
                        i2++;
                    }
                }
            }
            throw new EventBusException("Subscriber " + cls + " has no public methods called onModuleEvent");
        }
        return (Method) invokeL.objValue;
    }
}
