package com.baidu.ar.bus;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.text.Typography;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final Map<Class<?>, List<e>> kM;
    public static final a[] kN;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List<e> kO;
        public final Map<Class, Object> kP;
        public final Map<String, Class> kQ;
        public final StringBuilder kR;
        public Class<?> kS;
        public Class<?> kT;
        public boolean kU;

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
                    return;
                }
            }
            this.kO = new ArrayList();
            this.kP = new HashMap();
            this.kQ = new HashMap();
            this.kR = new StringBuilder(128);
        }

        private boolean b(Method method, Class<?> cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, method, cls)) == null) {
                this.kR.setLength(0);
                this.kR.append(method.getName());
                StringBuilder sb = this.kR;
                sb.append(Typography.greater);
                sb.append(cls.getName());
                String sb2 = this.kR.toString();
                Class<?> declaringClass = method.getDeclaringClass();
                Class put = this.kQ.put(sb2, declaringClass);
                if (put == null || put.isAssignableFrom(declaringClass)) {
                    return true;
                }
                this.kQ.put(sb2, put);
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean a(Method method, Class<?> cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, method, cls)) == null) {
                Object put = this.kP.put(cls, method);
                if (put == null) {
                    return true;
                }
                if (put instanceof Method) {
                    if (!b((Method) put, cls)) {
                        throw new IllegalStateException();
                    }
                    this.kP.put(cls, this);
                }
                return b(method, cls);
            }
            return invokeLL.booleanValue;
        }

        public void c(Class<?> cls) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls) == null) {
                this.kT = cls;
                this.kS = cls;
                this.kU = false;
            }
        }

        public void cK() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (!this.kU) {
                    Class<? super Object> superclass = this.kT.getSuperclass();
                    this.kT = superclass;
                    String name = superclass.getName();
                    if (!name.startsWith("java.") && !name.startsWith("javax.") && !name.startsWith("android.") && !name.startsWith("androidx.")) {
                        return;
                    }
                }
                this.kT = null;
            }
        }

        public void recycle() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.kO.clear();
                this.kP.clear();
                this.kQ.clear();
                this.kR.setLength(0);
                this.kS = null;
                this.kT = null;
                this.kU = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724490540, "Lcom/baidu/ar/bus/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-724490540, "Lcom/baidu/ar/bus/f;");
                return;
            }
        }
        kM = new ConcurrentHashMap();
        kN = new a[4];
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

    private List<e> a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            ArrayList arrayList = new ArrayList(aVar.kO);
            aVar.recycle();
            synchronized (kN) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 4) {
                        break;
                    } else if (kN[i2] == null) {
                        kN[i2] = aVar;
                        break;
                    } else {
                        i2++;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List<e> b(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, cls)) == null) {
            a cJ = cJ();
            cJ.c(cls);
            while (cJ.kT != null) {
                b(cJ);
                cJ.cK();
            }
            return a(cJ);
        }
        return (List) invokeL.objValue;
    }

    private void b(a aVar) {
        Method[] methods;
        CallBack callBack;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, aVar) == null) {
            try {
                try {
                    methods = aVar.kT.getDeclaredMethods();
                } catch (LinkageError unused) {
                    com.baidu.ar.h.b.aS(("Could not inspect methods of " + aVar.kT.getName()) + ". Please make this class visible to EventBus annotation processor to avoid reflection.");
                    return;
                }
            } catch (Throwable unused2) {
                methods = aVar.kT.getMethods();
                aVar.kU = true;
            }
            for (Method method : methods) {
                int modifiers = method.getModifiers();
                if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && (callBack = (CallBack) method.getAnnotation(CallBack.class)) != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.kO.add(new e(method, cls, callBack.threadMode()));
                        }
                    }
                }
            }
        }
    }

    private a cJ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            synchronized (kN) {
                for (int i2 = 0; i2 < 4; i2++) {
                    a aVar = kN[i2];
                    if (aVar != null) {
                        kN[i2] = null;
                        return aVar;
                    }
                }
                return new a();
            }
        }
        return (a) invokeV.objValue;
    }

    public List<e> a(Class<?> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            List<e> list = kM.get(cls);
            if (list != null) {
                return list;
            }
            List<e> b2 = b(cls);
            if (!b2.isEmpty()) {
                kM.put(cls, b2);
                return b2;
            }
            com.baidu.ar.h.b.aS("Subscriber " + cls + " and its super classes have no public methods with the @CallBack annotation");
            return null;
        }
        return (List) invokeL.objValue;
    }
}
