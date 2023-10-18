package com.baidu.platform.comapi.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final a a;
    public static final String b = "com.baidu.platform.comapi.util.a";
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Class<?>, CopyOnWriteArraySet<C0129a>> c;
    public final Map<Class<?>, Object> d;

    /* loaded from: classes3.dex */
    public interface b {
        void a(Object obj);
    }

    /* renamed from: com.baidu.platform.comapi.util.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0129a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final b a;

        @Override // com.baidu.platform.comapi.util.a.b
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.a(obj);
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                return this.a.equals(obj);
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1576658849, "Lcom/baidu/platform/comapi/util/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1576658849, "Lcom/baidu/platform/comapi/util/a;");
                return;
            }
        }
        a = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = new HashMap();
        this.d = new HashMap();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return a;
        }
        return (a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, bVar, obj) == null) {
            bVar.a(obj);
        }
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<C0129a> copyOnWriteArraySet;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && this.c.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.c.get(obj.getClass());
            }
            Iterator<C0129a> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                j.a(new com.baidu.platform.comapi.util.b(this, it.next(), obj), 0L);
            }
        }
    }
}
