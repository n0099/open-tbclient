package com.baidu.apollon.beans;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static a f37876a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public final HashMap<String, ArrayList<ApollonBean<?>>> f37877b;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-561717148, "Lcom/baidu/apollon/beans/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-561717148, "Lcom/baidu/apollon/beans/a;");
        }
    }

    public a() {
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
        this.f37877b = new HashMap<>();
    }

    public static synchronized a a() {
        InterceptResult invokeV;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            synchronized (a.class) {
                if (f37876a == null) {
                    f37876a = new a();
                }
                aVar = f37876a;
            }
            return aVar;
        }
        return (a) invokeV.objValue;
    }

    public synchronized void a(String str, ApollonBean<?> apollonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, apollonBean) == null) {
            synchronized (this) {
                ArrayList<ApollonBean<?>> arrayList = this.f37877b.get(str);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f37877b.put(str, arrayList);
                }
                arrayList.add(apollonBean);
            }
        }
    }

    public synchronized void a(ApollonBean<?> apollonBean) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, apollonBean) == null) {
            synchronized (this) {
                for (String str : this.f37877b.keySet()) {
                    ArrayList<ApollonBean<?>> arrayList = this.f37877b.get(str);
                    Iterator<ApollonBean<?>> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (apollonBean == it.next()) {
                                arrayList.remove(apollonBean);
                                apollonBean.destroyBean();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public synchronized void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            synchronized (this) {
                ArrayList<ApollonBean<?>> arrayList = this.f37877b.get(str);
                if (arrayList != null) {
                    Iterator<ApollonBean<?>> it = arrayList.iterator();
                    while (it.hasNext()) {
                        it.next().destroyBean();
                    }
                    this.f37877b.remove(str);
                }
            }
        }
    }
}
