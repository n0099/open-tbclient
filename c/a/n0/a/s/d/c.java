package c.a.n0.a.s.d;

import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import c.a.n0.a.u.d;
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
    public static final boolean f6140d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public c.a.n0.a.q2.g.a a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ArrayMap<String, c.a.n0.a.s.b.a> f6141b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public ArrayMap<String, List<c.a.n0.a.s.b.a>> f6142c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766122476, "Lc/a/n0/a/s/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766122476, "Lc/a/n0/a/s/d/c;");
                return;
            }
        }
        f6140d = c.a.n0.a.a.a;
    }

    public c(@NonNull c.a.n0.a.q2.g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = aVar;
        this.f6141b = new ArrayMap<>();
        this.f6142c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c.a.n0.a.s.b.a aVar = this.f6141b.get(str);
            if (aVar == null) {
                d.c("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return aVar.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(c.a.n0.a.s.b.a aVar) {
        InterceptResult invokeL;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "insert component with a null component");
                return false;
            }
            c.a.n0.a.s.b.b n = aVar.n();
            String str = n.a;
            String str2 = n.f6096b;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.f6141b.containsKey(str2)) {
                d.o("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                c.a.n0.a.s.g.a.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            c.a.n0.a.c1.e.a.a aVar2 = n.f6102h;
            if (aVar2 == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "insert " + o + " with a null position");
                return false;
            }
            if (!aVar2.h()) {
                StringBuilder sb = new StringBuilder();
                sb.append("insert ");
                sb.append(o);
                sb.append(" with a invalid position: ");
                Object obj = n.f6102h;
                if (obj == null) {
                    obj = StringUtil.NULL_STRING;
                }
                sb.append(obj);
                c.a.n0.a.s.g.a.a("Component-Container", sb.toString());
                n.f6102h = new c.a.n0.a.c1.e.a.a();
            }
            if (!b.c(n)) {
                if (TextUtils.isEmpty(n.f6098d)) {
                    b2 = this.a.c(m, n.f6102h);
                } else {
                    SwanAppComponentContainerView a = a(n.f6098d);
                    if (a == null) {
                        d.c("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a.indexOfChild(m) >= 0) {
                        c.a.n0.a.s.g.a.a("Component-Container", o + " repeat insert view!");
                        a.removeView(m);
                    }
                    a.addView(m, n.b());
                    b2 = true;
                }
            } else {
                b2 = b.b(this, n, m);
                if (!b2) {
                    c.a.n0.a.s.g.a.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b2) {
                this.f6141b.put(n.f6096b, aVar);
                if (aVar.s(2)) {
                    d.o("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<c.a.n0.a.s.b.a> list = this.f6142c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.f6142c.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return b2;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        c.a.n0.a.s.b.a value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f6140d) {
                Log.d("Component-Container", "container destroy");
            }
            for (Map.Entry<String, c.a.n0.a.s.b.a> entry : this.f6141b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.f6141b.clear();
            this.f6142c.clear();
        }
    }

    public final boolean d(@NonNull c.a.n0.a.s.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull c.a.n0.a.s.b.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aVar, swanAppComponentContainerView, bVar)) == null) {
            String o = aVar.o();
            if (f6140d) {
                Log.d("Component-Container", o + " perform position update");
            }
            c.a.n0.a.c1.e.a.a aVar2 = bVar.f6102h;
            if (aVar2 != null && aVar2.h()) {
                if (b.c(bVar) && !b.e(this, bVar, swanAppComponentContainerView)) {
                    c.a.n0.a.s.g.a.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = bVar.f6098d;
                if (TextUtils.isEmpty(str)) {
                    return this.a.a(swanAppComponentContainerView, bVar.f6102h);
                }
                SwanAppComponentContainerView a = a(str);
                if (a == null) {
                    d.c("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a) {
                    a.updateViewLayout(swanAppComponentContainerView, bVar.b());
                    return true;
                } else {
                    c.a.n0.a.s.g.a.a("Component-Container", "update " + o + " to parent with a illegal parent view");
                    return false;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("insert ");
            sb.append(o);
            sb.append(" with a invalid position: ");
            Object obj = bVar.f6102h;
            if (obj == null) {
                obj = StringUtil.NULL_STRING;
            }
            sb.append(obj);
            c.a.n0.a.s.g.a.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(c.a.n0.a.s.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            boolean z = false;
            if (aVar == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "remove component with a null component");
                return false;
            }
            c.a.n0.a.s.b.b n = aVar.n();
            String str = n.a;
            String str2 = n.f6096b;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                c.a.n0.a.s.g.a.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!b.c(n)) {
                    if (TextUtils.isEmpty(n.f6098d)) {
                        z = this.a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a = a(n.f6098d);
                        if (a == null) {
                            d.c("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a == m.getParent()) {
                            a.removeView(m);
                            z = true;
                        } else {
                            c.a.n0.a.s.g.a.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = b.g(this, n, m);
                    if (!z) {
                        c.a.n0.a.s.g.a.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || aVar.s(1)) {
                    this.f6141b.remove(str2);
                    if (aVar.s(2)) {
                        d.o("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<c.a.n0.a.s.b.a> list = this.f6142c.get(str);
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
    public boolean f(c.a.n0.a.s.b.a aVar, @NonNull c.a.n0.a.s.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, bVar)) == null) {
            if (aVar == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "update component with a null component");
                return false;
            }
            c.a.n0.a.s.b.b n = aVar.n();
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                c.a.n0.a.s.g.a.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.f6141b.containsKey(n.f6096b)) {
                d.c("Component-Container", "don't insert" + o);
            }
            if (aVar instanceof c.a.n0.a.s.c.e.c.a) {
                if (bVar.a(7)) {
                    boolean d2 = b.d(this, aVar, n, m, bVar);
                    if (!d2) {
                        c.a.n0.a.s.g.a.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (bVar.a(8)) {
                    b.f(this, aVar, n, m, bVar);
                }
            }
            if (bVar.a(3) && !d(aVar, m, n)) {
                d.c("Component-Container", o + " perform position update fail");
                return false;
            } else if (aVar instanceof c.a.n0.a.s.a.d.a) {
                c.a.n0.a.s.a.d.a aVar2 = (c.a.n0.a.s.a.d.a) aVar;
                if (aVar2.J()) {
                    if (f6140d) {
                        Log.d("Component-Container", o + "perform position update with animation");
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
