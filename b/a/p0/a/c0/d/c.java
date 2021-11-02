package b.a.p0.a.c0.d;

import android.text.TextUtils;
import android.util.ArrayMap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import b.a.p0.a.e0.d;
import b.a.p0.a.k;
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
    public static final boolean f4121d;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.w2.g.a f4122a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public ArrayMap<String, b.a.p0.a.c0.b.a> f4123b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public ArrayMap<String, List<b.a.p0.a.c0.b.a>> f4124c;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1454762415, "Lb/a/p0/a/c0/d/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1454762415, "Lb/a/p0/a/c0/d/c;");
                return;
            }
        }
        f4121d = k.f6397a;
    }

    public c(@NonNull b.a.p0.a.w2.g.a aVar) {
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
        this.f4122a = aVar;
        this.f4123b = new ArrayMap<>();
        this.f4124c = new ArrayMap<>();
    }

    @Nullable
    public SwanAppComponentContainerView a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            b.a.p0.a.c0.b.a aVar = this.f4123b.get(str);
            if (aVar == null) {
                d.b("Component-Container", "getContainerView : get a null  component#" + str);
                return null;
            }
            return aVar.m();
        }
        return (SwanAppComponentContainerView) invokeL.objValue;
    }

    @UiThread
    public boolean b(b.a.p0.a.c0.b.a aVar) {
        InterceptResult invokeL;
        boolean b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "insert component with a null component");
                return false;
            }
            b.a.p0.a.c0.b.b n = aVar.n();
            String str = n.f4055e;
            String str2 = n.f4056f;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null container view");
                return false;
            }
            if (this.f4123b.containsKey(str2)) {
                d.l("Component-Container", o + " repeat insert: " + str2);
            }
            if (TextUtils.isEmpty(str2)) {
                b.a.p0.a.c0.g.a.a("Component-Container", "insert " + o + " with a empty component id");
                return false;
            }
            b.a.p0.a.l1.e.a.a aVar2 = n.l;
            if (aVar2 == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "insert " + o + " with a null position");
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
                b.a.p0.a.c0.g.a.a("Component-Container", sb.toString());
                n.l = new b.a.p0.a.l1.e.a.a();
            }
            if (!b.c(n)) {
                if (TextUtils.isEmpty(n.f4058h)) {
                    b2 = this.f4122a.c(m, n.l);
                } else {
                    SwanAppComponentContainerView a2 = a(n.f4058h);
                    if (a2 == null) {
                        d.b("Component-Container", "insert " + o + " to parent with a null parent container view");
                        return false;
                    }
                    if (a2.indexOfChild(m) >= 0) {
                        b.a.p0.a.c0.g.a.a("Component-Container", o + " repeat insert view!");
                        a2.removeView(m);
                    }
                    a2.addView(m, n.b());
                    b2 = true;
                }
            } else {
                b2 = b.b(this, n, m);
                if (!b2) {
                    b.a.p0.a.c0.g.a.a("Component-Container", o + " insertComponentForScroll fail");
                }
            }
            if (b2) {
                this.f4123b.put(n.f4056f, aVar);
                if (aVar.s(2)) {
                    d.l("Component-Container", o + " insert with FLAG_CAN_NO_COMPONENT_ID");
                    List<b.a.p0.a.c0.b.a> list = this.f4124c.get(str);
                    if (list == null) {
                        list = new ArrayList<>();
                        this.f4124c.put(str, list);
                    }
                    list.add(aVar);
                }
            }
            return b2;
        }
        return invokeL.booleanValue;
    }

    public void c() {
        b.a.p0.a.c0.b.a value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            boolean z = f4121d;
            for (Map.Entry<String, b.a.p0.a.c0.b.a> entry : this.f4123b.entrySet()) {
                if (entry != null && (value = entry.getValue()) != null) {
                    value.y();
                }
            }
            this.f4123b.clear();
            this.f4124c.clear();
        }
    }

    public final boolean d(@NonNull b.a.p0.a.c0.b.a aVar, @NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull b.a.p0.a.c0.b.b bVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, aVar, swanAppComponentContainerView, bVar)) == null) {
            String o = aVar.o();
            if (f4121d) {
                r0 = o + " perform position update";
            }
            b.a.p0.a.l1.e.a.a aVar2 = bVar.l;
            if (aVar2 != null && aVar2.i()) {
                if (b.c(bVar) && !b.e(this, bVar, swanAppComponentContainerView)) {
                    b.a.p0.a.c0.g.a.a("Component-Container", o + " performPositionUpdateForScroll fail");
                }
                String str = bVar.f4058h;
                if (TextUtils.isEmpty(str)) {
                    return this.f4122a.a(swanAppComponentContainerView, bVar.l);
                }
                SwanAppComponentContainerView a2 = a(str);
                if (a2 == null) {
                    d.b("Component-Container", "update " + o + " to parent with a null parent container view");
                    return false;
                } else if (swanAppComponentContainerView.getParent() == a2) {
                    a2.updateViewLayout(swanAppComponentContainerView, bVar.b());
                    return true;
                } else {
                    b.a.p0.a.c0.g.a.a("Component-Container", "update " + o + " to parent with a illegal parent view");
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
            b.a.p0.a.c0.g.a.a("Component-Container", sb.toString());
            return false;
        }
        return invokeLLL.booleanValue;
    }

    @UiThread
    public boolean e(b.a.p0.a.c0.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            boolean z = false;
            if (aVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "remove component with a null component");
                return false;
            }
            b.a.p0.a.c0.b.b n = aVar.n();
            String str = n.f4055e;
            String str2 = n.f4056f;
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "remove " + o + " with a null container view");
                return false;
            } else if (TextUtils.isEmpty(str2)) {
                b.a.p0.a.c0.g.a.a("Component-Container", "remove " + o + " with a empty component id");
                return false;
            } else {
                if (!b.c(n)) {
                    if (TextUtils.isEmpty(n.f4058h)) {
                        z = this.f4122a.removeView(m);
                    } else {
                        SwanAppComponentContainerView a2 = a(n.f4058h);
                        if (a2 == null) {
                            d.b("Component-Container", "remove " + o + " to parent with a null parent container view");
                        } else if (a2 == m.getParent()) {
                            a2.removeView(m);
                            z = true;
                        } else {
                            b.a.p0.a.c0.g.a.a("Component-Container", "remove " + o + " to parent with a illegal parent view");
                        }
                    }
                } else {
                    z = b.g(this, n, m);
                    if (!z) {
                        b.a.p0.a.c0.g.a.a("Component-Container", o + " removeComponentForScroll fail");
                    }
                }
                if (z || aVar.s(1)) {
                    this.f4123b.remove(str2);
                    if (aVar.s(2)) {
                        d.l("Component-Container", o + " remove with FLAG_CAN_NO_COMPONENT_ID");
                        List<b.a.p0.a.c0.b.a> list = this.f4124c.get(str);
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
    public boolean f(b.a.p0.a.c0.b.a aVar, @NonNull b.a.p0.a.c0.f.b bVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, aVar, bVar)) == null) {
            if (aVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "update component with a null component");
                return false;
            }
            b.a.p0.a.c0.b.b n = aVar.n();
            String o = aVar.o();
            SwanAppComponentContainerView m = aVar.m();
            if (m == null) {
                b.a.p0.a.c0.g.a.a("Component-Container", "update " + o + " with a null container view");
                return false;
            }
            if (!this.f4123b.containsKey(n.f4056f)) {
                d.b("Component-Container", "don't insert" + o);
            }
            if (aVar instanceof b.a.p0.a.c0.c.e.c.a) {
                if (bVar.a(7)) {
                    boolean d2 = b.d(this, aVar, n, m, bVar);
                    if (!d2) {
                        b.a.p0.a.c0.g.a.a("Component-Container", o + " perform scroll type update fail");
                    }
                    return d2;
                } else if (bVar.a(8)) {
                    b.f(this, aVar, n, m, bVar);
                }
            }
            if (bVar.a(3) && !d(aVar, m, n)) {
                d.b("Component-Container", o + " perform position update fail");
                return false;
            } else if (aVar instanceof b.a.p0.a.c0.a.d.a) {
                b.a.p0.a.c0.a.d.a aVar2 = (b.a.p0.a.c0.a.d.a) aVar;
                if (aVar2.J()) {
                    if (f4121d) {
                        String str = o + "perform position update with animation";
                    }
                    if (aVar2.M()) {
                        return true;
                    }
                    d.b("Component-Container", o + " perform position update with animation fail");
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
