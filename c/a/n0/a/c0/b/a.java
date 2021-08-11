package c.a.n0.a.c0.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.c0.b.b;
import c.a.n0.a.e0.d;
import c.a.n0.a.k;
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
import i.d;
import i.j;
/* loaded from: classes.dex */
public abstract class a<V extends View, M extends c.a.n0.a.c0.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4370h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.c0.e.a f4371a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f4372b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f4373c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f4374d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f4375e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f4376f;

    /* renamed from: g  reason: collision with root package name */
    public int f4377g;

    /* renamed from: c.a.n0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0114a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4378e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4379f;

        public C0114a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4379f = aVar;
            this.f4378e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.n0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.n0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4379f;
                aVar.f4372b = aVar.v(aVar.f4371a.b());
                a aVar2 = this.f4379f;
                aVar2.B(aVar2.f4372b);
                this.f4379f.f4375e.setTargetView(this.f4379f.f4372b, 0);
                a aVar3 = this.f4379f;
                aVar3.D(aVar3.f4372b, this.f4379f.f4373c, new c.a.n0.a.c0.f.b(true));
                if (a.f4370h) {
                    String str = this.f4378e + " insert delayed（view）: success";
                }
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.l("Component-Base", this.f4378e + " insert delayed（view）: fail");
                if (a.f4370h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f4379f.C();
            }
        }

        @Override // i.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.l("Component-Base", this.f4378e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4381f;

        public b(a aVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4381f = aVar;
            this.f4380e = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f4370h) {
                    String str = "insert delayed => save thread: " + Thread.currentThread().getName();
                }
                if (this.f4380e != Thread.currentThread().getId()) {
                    c.a.n0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f4381f.f4376f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.n0.a.w2.g.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.n = z;
        }

        @Override // c.a.n0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(686003156, "Lc/a/n0/a/c0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(686003156, "Lc/a/n0/a/c0/b/a;");
                return;
            }
        }
        f4370h = k.f6803a;
    }

    public a(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j2 = j(m);
        this.f4373c = j2;
        c.a.n0.a.c0.e.a c2 = c.a.n0.a.c0.d.a.c(j2);
        this.f4371a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        c.a.n0.a.e0.d.b("Component-Base", o() + " context is null !");
    }

    @CallSuper
    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            F();
        }
    }

    public void B(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final c.a.n0.a.c0.b.c C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String o = o();
            if (f4370h) {
                String str = "=====================" + o + " start remove=====================";
            }
            c.a.n0.a.c0.e.a aVar = this.f4371a;
            if (aVar == null) {
                c.a.n0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new c.a.n0.a.c0.b.c(202, "component context is null");
            } else if (this.f4375e == null) {
                c.a.n0.a.e0.d.b("Component-Base", o + " remove must after insert");
                return new c.a.n0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str2 = o + " remove fail";
                c.a.n0.a.e0.d.b("Component-Base", str2);
                return new c.a.n0.a.c0.b.c(1001, str2);
            } else {
                A();
                if (f4370h) {
                    String str3 = o + " remove: success";
                }
                return new c.a.n0.a.c0.b.c(0, "success");
            }
        }
        return (c.a.n0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull c.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, v, m, bVar) == null) {
            E(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull c.a.n0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m, bVar) == null) {
            if (this.f4375e == null) {
                c.a.n0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f4375e.setHidden(m.f4387j);
            }
            if (bVar.a(2)) {
                r(this.f4375e, m);
            }
        }
    }

    public final void F() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f4376f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f4376f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final c.a.n0.a.c0.b.c G(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m)) == null) {
            String o = o();
            c.a.n0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                c.a.n0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f4389b);
                return i2;
            }
            if (f4370h) {
                String str = "=====================" + o + " start update=====================";
            }
            M m2 = this.f4373c;
            if (m2 == m) {
                String str2 = o + " update with the same model";
                c.a.n0.a.c0.g.a.a("Component-Base", str2);
                return new c.a.n0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(m2.f4383f, m.f4383f)) {
                String str3 = o + " update with different id: " + this.f4373c.f4383f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4383f;
                c.a.n0.a.c0.g.a.a("Component-Base", str3);
                return new c.a.n0.a.c0.b.c(202, str3);
            } else if (!TextUtils.equals(this.f4373c.f4384g, m.f4384g)) {
                String str4 = o + " update with different slave id: " + this.f4373c.f4384g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4384g;
                c.a.n0.a.c0.g.a.a("Component-Base", str4);
                return new c.a.n0.a.c0.b.c(202, str4);
            } else if (this.f4372b != null && this.f4375e != null) {
                if (this.f4371a == null) {
                    c.a.n0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new c.a.n0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f4373c;
                this.f4374d = m3;
                c.a.n0.a.c0.f.b k = k(m3, m);
                M j2 = j(m);
                this.f4373c = j2;
                D(this.f4372b, j2, k);
                boolean f2 = this.f4371a.a().f(this, k);
                this.f4374d = null;
                if (!f2) {
                    String str5 = o + " update component fail";
                    c.a.n0.a.e0.d.b("Component-Base", str5);
                    return new c.a.n0.a.c0.b.c(1001, str5);
                }
                if (f4370h) {
                    String str6 = o + " component update: success";
                }
                return new c.a.n0.a.c0.b.c(0, "success");
            } else {
                String str7 = o + " update must after insert succeeded";
                c.a.n0.a.c0.g.a.a("Component-Base", str7);
                return new c.a.n0.a.c0.b.c(202, str7);
            }
        }
        return (c.a.n0.a.c0.b.c) invokeL.objValue;
    }

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f4377g = i2 | this.f4377g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull c.a.n0.a.c0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) {
            boolean b2 = aVar.a().b(this);
            y(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final c.a.n0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            if (m == null) {
                return new c.a.n0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f4384g)) {
                return new c.a.n0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new c.a.n0.a.c0.b.c(202, "model is invalid");
            }
            return new c.a.n0.a.c0.b.c(0, "model is valid");
        }
        return (c.a.n0.a.c0.b.c) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        c.a.n0.a.c0.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, m)) == null) {
            try {
                bVar = (c.a.n0.a.c0.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                c.a.n0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                c.a.n0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                c.a.n0.a.c0.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public c.a.n0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, m, m2)) == null) {
            c.a.n0.a.c0.f.b bVar = new c.a.n0.a.c0.f.b();
            c.a.n0.a.l1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.e(m.l)) {
                bVar.b(3);
            }
            if (m.f4387j != m2.f4387j) {
                bVar.b(1);
            }
            if (m.k != m2.k) {
                bVar.b(2);
            }
            return bVar;
        }
        return (c.a.n0.a.c0.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j(this.f4373c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f4375e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f4373c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.n0.a.c0.b.c i2 = i(this.f4373c);
            if (i2.a()) {
                return this.f4373c.f();
            }
            return "【illegal component#" + i2.f4389b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f4374d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f4372b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f4384g, m.f4383f, m.f4382e, m.k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? (this.f4377g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f4374d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @NonNull
    @UiThread
    public final c.a.n0.a.c0.b.c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String o = o();
            c.a.n0.a.c0.b.c i2 = i(this.f4373c);
            if (!i2.a()) {
                c.a.n0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f4389b);
                return i2;
            }
            if (f4370h) {
                String str = "=====================" + o + " start insert=====================";
            }
            c.a.n0.a.c0.e.a aVar = this.f4371a;
            if (aVar == null) {
                c.a.n0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
                return new c.a.n0.a.c0.b.c(202, "component context is null");
            }
            Context b2 = aVar.b();
            if (this.f4375e != null || this.f4372b != null) {
                c.a.n0.a.e0.d.l("Component-Base", o + " repeat insert");
            }
            V v = v(this.f4371a.b());
            this.f4372b = v;
            B(v);
            SwanAppComponentContainerView u = u(b2);
            this.f4375e = u;
            u.setTargetView(this.f4372b);
            D(this.f4372b, this.f4373c, new c.a.n0.a.c0.f.b(true));
            if (h(this.f4371a)) {
                if (f4370h) {
                    r0 = o + " insert: success";
                }
                return new c.a.n0.a.c0.b.c(0, "success");
            }
            c.a.n0.a.e0.d.b("Component-Base", o + " insert: attach fail");
            return new c.a.n0.a.c0.b.c(1001, "attach fail");
        }
        return (c.a.n0.a.c0.b.c) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final j x() {
        InterceptResult invokeV;
        c.a.n0.a.c0.b.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            if (!i(this.f4373c).a()) {
                c.a.n0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f4389b);
                return null;
            }
            if (f4370h) {
                String str = "=====================" + o + " start insertDelayed=====================";
            }
            if (this.f4371a == null) {
                c.a.n0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f4375e != null) {
                c.a.n0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f4376f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f4376f.unsubscribe();
                this.f4376f = null;
                c.a.n0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f4375e = u(this.f4371a.b());
            E(this.f4373c, new c.a.n0.a.c0.f.b(true));
            if (h(this.f4371a)) {
                if (f4370h) {
                    r0 = o + " insert delayed（container view）: success";
                }
                i.d.b(new b(this, Thread.currentThread().getId())).z(new C0114a(this, o));
                return this.f4376f;
            }
            c.a.n0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (j) invokeV.objValue;
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (f4370h) {
                String str = o() + " onDestroy";
            }
            F();
        }
    }
}
