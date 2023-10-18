package com.baidu.mobads.sdk.internal.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.concrete.RLRecyclerViewDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVAdapterDelegate;
import com.baidu.mobads.sdk.internal.concrete.RVViewHolderDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewCompatDelegate;
import com.baidu.mobads.sdk.internal.concrete.ViewPager2Delegate;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class c implements com.baidu.mobads.sdk.internal.a.a {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "ViewPager2";
    public static final String b = "RVAdapter";
    public static final String c = "RVViewHolder";
    public static final String d = "ViewCompat";
    public static final String e = "Fragment";
    public static final String f = "FragmentV4";
    public static final String g = "RLRecyclerView";
    public static final String h = "p_e";
    public static final String i = "p_init";
    public static final String j = "p_set_class";
    public static final String k = "e_t";
    public static final String l = "e_n";
    public static final String m = "e_a";
    public static final String n = "e_r";
    public static final String o = "e_d";
    public transient /* synthetic */ FieldHolder $fh;
    public final IAdInterListener p;

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public final Object handleEvent(String str, String str2, Object[] objArr) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, str2, objArr)) == null) {
            return null;
        }
        return invokeLLL.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, obj) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public static class a implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        private com.baidu.mobads.sdk.internal.a.a a(String str, @NonNull IAdInterListener iAdInterListener, Object[] objArr) {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, this, str, iAdInterListener, objArr)) == null) {
                if (c.a.equals(str) && c.a(objArr, Context.class)) {
                    return new ViewPager2Delegate(iAdInterListener, (Context) objArr[0]);
                }
                if (c.b.equals(str)) {
                    return new RVAdapterDelegate(iAdInterListener);
                }
                if (c.c.equals(str) && c.a(objArr, View.class)) {
                    return new RVViewHolderDelegate(iAdInterListener, (View) objArr[0]);
                }
                if ("ViewCompat".equals(str)) {
                    return new ViewCompatDelegate(iAdInterListener);
                }
                if (c.e.equals(str)) {
                    return new FragmentDelegate().setDispatcher(iAdInterListener);
                }
                if (c.f.equals(str)) {
                    return new FragmentV4Delegate().setDispatcher(iAdInterListener);
                }
                if (c.g.equals(str)) {
                    return new RLRecyclerViewDelegate(iAdInterListener, objArr);
                }
                return null;
            }
            return (com.baidu.mobads.sdk.internal.a.a) invokeLLL.objValue;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            com.baidu.mobads.sdk.internal.a.a a;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) && iOAdEvent != null) {
                try {
                    if (c.h.equals(iOAdEvent.getType()) && (data = iOAdEvent.getData()) != null && !data.isEmpty()) {
                        Object obj = data.get(c.k);
                        Object obj2 = data.get(c.l);
                        Object obj3 = data.get(c.m);
                        Object[] objArr = null;
                        if (obj3 instanceof Object[]) {
                            objArr = (Object[]) obj3;
                        }
                        if ((obj2 instanceof String) && (obj instanceof String)) {
                            if (c.i.equals((String) obj2)) {
                                Object obj4 = data.get(c.o);
                                if ((obj4 instanceof IAdInterListener) && (a = a((String) obj, (IAdInterListener) obj4, objArr)) != null) {
                                    data.put(c.n, a);
                                }
                            } else if (c.j.equals((String) obj2) && (obj3 instanceof Map)) {
                                Map map = (Map) obj3;
                                map.put(c.a, ViewPager2.class);
                                map.put(c.b, RecyclerView.Adapter.class);
                                map.put(c.c, RecyclerView.ViewHolder.class);
                            }
                        }
                    }
                } catch (Throwable th) {
                    br.a().b(th.getMessage());
                }
            }
        }
    }

    public c(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iAdInterListener, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = iAdInterListener;
        iAdInterListener.addEventListener(h, new d(this, aVar));
    }

    public static c a(@NonNull IAdInterListener iAdInterListener, @NonNull com.baidu.mobads.sdk.internal.a.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, iAdInterListener, aVar)) == null) {
            return new c(iAdInterListener, aVar);
        }
        return (c) invokeLL.objValue;
    }

    public static boolean a(Object[] objArr, Class<?>... clsArr) {
        InterceptResult invokeLL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, objArr, clsArr)) == null) {
            if (objArr != null && objArr.length != 0) {
                z = false;
            } else {
                z = true;
            }
            if (clsArr != null && clsArr.length != 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z && z2) {
                return true;
            }
            if (z || z2 || clsArr == null || objArr == null || clsArr.length != objArr.length) {
                return false;
            }
            for (int i2 = 0; i2 < clsArr.length; i2++) {
                if (!clsArr[i2].isInstance(objArr[i2])) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final Object a(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, objArr)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(m, objArr);
            this.p.onAdTaskProcess(str, hashMap);
            return hashMap.get(n);
        }
        return invokeLL.objValue;
    }

    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.p.onAdTaskProcess(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    @NonNull
    public IAdInterListener getDelegator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.p;
        }
        return (IAdInterListener) invokeV.objValue;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.p;
        }
        return invokeV.objValue;
    }
}
