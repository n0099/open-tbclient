package com.baidu.ar.bus;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public static final Map kM;
    public static final a[] kN;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final List kO;
        public final Map kP;
        public final Map kQ;
        public final StringBuilder kR;
        public Class kS;
        public Class kT;
        public boolean kU;

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
                    return;
                }
            }
            this.kO = new ArrayList();
            this.kP = new HashMap();
            this.kQ = new HashMap();
            this.kR = new StringBuilder(128);
        }

        private boolean b(Method method, Class cls) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, method, cls)) == null) {
                this.kR.setLength(0);
                this.kR.append(method.getName());
                StringBuilder sb = this.kR;
                sb.append('>');
                sb.append(cls.getName());
                String sb2 = this.kR.toString();
                Class<?> declaringClass = method.getDeclaringClass();
                Class cls2 = (Class) this.kQ.put(sb2, declaringClass);
                if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                    return true;
                }
                this.kQ.put(sb2, cls2);
                return false;
            }
            return invokeLL.booleanValue;
        }

        public boolean a(Method method, Class cls) {
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

        public void c(Class cls) {
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
                    Class superclass = this.kT.getSuperclass();
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    private List a(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            ArrayList arrayList = new ArrayList(aVar.kO);
            aVar.recycle();
            synchronized (kN) {
                int i = 0;
                while (true) {
                    if (i >= 4) {
                        break;
                    } else if (kN[i] == null) {
                        kN[i] = aVar;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    private List b(Class cls) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            synchronized (kN) {
                for (int i = 0; i < 4; i++) {
                    a aVar = kN[i];
                    if (aVar != null) {
                        kN[i] = null;
                        return aVar;
                    }
                }
                return new a();
            }
        }
        return (a) invokeV.objValue;
    }

    public List a(Class cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) {
            List list = (List) kM.get(cls);
            if (list != null) {
                return list;
            }
            List b = b(cls);
            if (!b.isEmpty()) {
                kM.put(cls, b);
                return b;
            }
            com.baidu.ar.h.b.aS("Subscriber " + cls + " and its super classes have no public methods with the @CallBack annotation");
            return null;
        }
        return (List) invokeL.objValue;
    }
}
