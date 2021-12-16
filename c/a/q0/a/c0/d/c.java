package c.a.q0.a.c0.d;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import c.a.q0.a.e0.d;
import c.a.q0.a.k;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f4752d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public c.a.q0.a.a3.g.a a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ArrayMap<String, c.a.q0.a.c0.b.a> f4753b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public ArrayMap<String, List<c.a.q0.a.c0.b.a>> f4754c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1073310957, "Lc/a/q0/a/c0/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1073310957, "Lc/a/q0/a/c0/d/c;");
                return;
            }
        }
        f4752d = k.a;
    }

    public c(@NonNull c.a.q0.a.a3.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f4753b = new ArrayMap<>();
        this.f4754c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c.a.q0.a.c0.b.a aVar = this.f4753b.get(str);
            if (aVar == null) {
                d.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return aVar.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(c.a.q0.a.c0.b.a aVar) {
        InterceptResult invokeL;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "insert component with a null component");
                return false;
            }
            c.a.q0.a.c0.b.b n = aVar.n();
            String str = n.f4685e;
            String str2 = n.f4686f;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.f4753b.containsKey(str2)) {
                d.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                c.a.q0.a.c0.g.a.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            c.a.q0.a.m1.e.a.a aVar2 = n.l;
            if (aVar2 == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!aVar2.i()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.l;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                c.a.q0.a.c0.g.a.a("Component-Container", sb.toString());
                n.l = new c.a.q0.a.m1.e.a.a();
            }
            if (!b.c(n)) {
                if (TextUtils.isEmpty(n.f4688h)) {
                    b2 = this.a.c(m, n.l);
                } else {
                    SwanAppComponentContainerView a = a(n.f4688h);
                    if (a == null) {
                        d.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        c.a.q0.a.c0.g.a.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b2 = true;
                }
            } else {
                b2 = b.b(this, n, m);
                if (!b2) {
                    c.a.q0.a.c0.g.a.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b2) {
                this.f4753b.put(n.f4686f, aVar);
                if (aVar.s(2)) {
                    d.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<c.a.q0.a.c0.b.a> list = this.f4754c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.f4754c.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return b2;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        c.a.q0.a.c0.b.a value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = f4752d;
            for (Map.Entry<String, c.a.q0.a.c0.b.a> entry : this.f4753b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.f4753b.clear();
            this.f4754c.clear();
        }
    }

    public final boolean d(@NonNull c.a.q0.a.c0.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull c.a.q0.a.c0.b.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aVar, swanAppComponentContainerView, bVar)) == null) {
            String o = aVar.o();
            if (f4752d) {
                r0 = o + " perform position update";
            }
            c.a.q0.a.m1.e.a.a aVar2 = bVar.l;
            if (aVar2 != null && aVar2.i()) {
                if (b.c(bVar) && !b.e(this, bVar, swanAppComponentContainerView)) {
                    c.a.q0.a.c0.g.a.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = bVar.f4688h;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, bVar.l);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    d.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, bVar.b());
                    return true;
                } else {
                    c.a.q0.a.c0.g.a.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = bVar.l;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            c.a.q0.a.c0.g.a.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(c.a.q0.a.c0.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            boolean z = false;
            if (aVar == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "remove component with a null component");
                return false;
            }
            c.a.q0.a.c0.b.b n = aVar.n();
            String str = n.f4685e;
            String str2 = n.f4686f;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                c.a.q0.a.c0.g.a.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!b.c(n)) {
                    if (TextUtils.isEmpty(n.f4688h)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.f4688h);
                        if (a == null) {
                            d.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            c.a.q0.a.c0.g.a.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = b.g(this, n, m);
                    if (!z) {
                        c.a.q0.a.c0.g.a.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || aVar.s(1)) {
                    this.f4753b.remove(str2);
                    if (aVar.s(2)) {
                        d.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<c.a.q0.a.c0.b.a> list = this.f4754c.get(str);
                        if (list != null) {
                            list.remove(aVar);
                        }
                    }
                }
                return z;
            }
        }
        return invokeL.booleanValue;
    }

    @UiThread
    public boolean f(c.a.q0.a.c0.b.a aVar, @NonNull c.a.q0.a.c0.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, bVar)) == null) {
            if (aVar == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "update component with a null component");
                return false;
            }
            c.a.q0.a.c0.b.b n = aVar.n();
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.q0.a.c0.g.a.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.f4753b.containsKey(n.f4686f)) {
                d.c("Component-Container", "don't insert" + o);
            }
            if (aVar instanceof c.a.q0.a.c0.c.e.c.a) {
                if (bVar.a(7)) {
                    boolean d2 = b.d(this, aVar, n, m, bVar);
                    if (!d2) {
                        c.a.q0.a.c0.g.a.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (bVar.a(8)) {
                    b.f(this, aVar, n, m, bVar);
                }
            }
            if (bVar.a(3) && !d(aVar, m, n)) {
                d.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (aVar instanceof c.a.q0.a.c0.a.d.a) {
                c.a.q0.a.c0.a.d.a aVar2 = (c.a.q0.a.c0.a.d.a) aVar;
                if (aVar2.J()) {
                    if (f4752d) {
                        String str = o + "perform position update with animation";
                    }
                    if (aVar2.M()) {
                        return true;
                    }
                    d.c("Component-Container", o + " perform position update with animation fail");
                    return false;
                }
                return true;
            } else {
                return true;
            }
        }
        return invokeLL.booleanValue;
    }
}
