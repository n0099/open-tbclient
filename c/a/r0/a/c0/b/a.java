package c.a.r0.a.c0.b;

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
import c.a.r0.a.c0.b.b;
import c.a.r0.a.e0.d;
import c.a.r0.a.k;
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
public abstract class a<V extends View, M extends c.a.r0.a.c0.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f5296h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public c.a.r0.a.c0.e.a a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f5297b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f5298c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f5299d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f5300e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f5301f;

    /* renamed from: g  reason: collision with root package name */
    public int f5302g;

    /* renamed from: c.a.r0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0276a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f5303i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f5304j;

        public C0276a(a aVar, String str) {
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
            this.f5304j = aVar;
            this.f5303i = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.r0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.r0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f5304j;
                aVar.f5297b = aVar.v(aVar.a.getContext());
                a aVar2 = this.f5304j;
                aVar2.A(aVar2.f5297b);
                this.f5304j.f5300e.setTargetView(this.f5304j.f5297b, 0);
                a aVar3 = this.f5304j;
                aVar3.C(aVar3.f5297b, this.f5304j.f5298c, new c.a.r0.a.c0.f.b(true));
                if (a.f5296h) {
                    String str = this.f5303i + " insert delayed（view）: success";
                }
            }
        }

        @Override // i.e
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.o("Component-Base", this.f5303i + " insert delayed（view）: fail");
                if (a.f5296h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f5304j.B();
            }
        }

        @Override // i.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.o("Component-Base", this.f5303i + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f5305e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f5306f;

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
            this.f5306f = aVar;
            this.f5305e = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f5296h) {
                    String str = "insert delayed => save thread: " + Thread.currentThread().getName();
                }
                if (this.f5305e != Thread.currentThread().getId()) {
                    c.a.r0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f5306f.f5301f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.r0.a.a3.g.b.b {
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

        @Override // c.a.r0.a.a3.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1202334032, "Lc/a/r0/a/c0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1202334032, "Lc/a/r0/a/c0/b/a;");
                return;
            }
        }
        f5296h = k.a;
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
        this.f5298c = j2;
        c.a.r0.a.c0.e.a c2 = c.a.r0.a.c0.d.a.c(j2);
        this.a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.c(context);
                return;
            }
            return;
        }
        c.a.r0.a.e0.d.c("Component-Base", o() + " context is null !");
    }

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final c.a.r0.a.c0.b.c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (f5296h) {
                String str = "=====================" + o + " start remove=====================";
            }
            c.a.r0.a.c0.e.a aVar = this.a;
            if (aVar == null) {
                c.a.r0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new c.a.r0.a.c0.b.c(202, "component context is null");
            } else if (this.f5300e == null) {
                c.a.r0.a.e0.d.c("Component-Base", o + " remove must after insert");
                return new c.a.r0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str2 = o + " remove fail";
                c.a.r0.a.e0.d.c("Component-Base", str2);
                return new c.a.r0.a.c0.b.c(1001, str2);
            } else {
                z();
                if (f5296h) {
                    String str3 = o + " remove: success";
                }
                return new c.a.r0.a.c0.b.c(0, "success");
            }
        }
        return (c.a.r0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull c.a.r0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, bVar) == null) {
            D(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull c.a.r0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, bVar) == null) {
            if (this.f5300e == null) {
                c.a.r0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f5300e.setHidden(m.f5312j);
            }
            if (bVar.a(2)) {
                r(this.f5300e, m);
            }
        }
    }

    public final void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f5301f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f5301f.unsubscribe();
    }

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f5302g = i2 | this.f5302g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull c.a.r0.a.c0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            boolean b2 = aVar.a().b(this);
            x(b2);
            return b2;
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public final c.a.r0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new c.a.r0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f5309g)) {
                return new c.a.r0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new c.a.r0.a.c0.b.c(202, "model is invalid");
            }
            return new c.a.r0.a.c0.b.c(0, "model is valid");
        }
        return (c.a.r0.a.c0.b.c) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final c.a.r0.a.c0.b.c insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            c.a.r0.a.c0.b.c i2 = i(this.f5298c);
            if (!i2.a()) {
                c.a.r0.a.e0.d.c("Component-Base", o + " insert with a invalid model => " + i2.f5313b);
                return i2;
            }
            if (f5296h) {
                String str = "=====================" + o + " start insert=====================";
            }
            c.a.r0.a.c0.e.a aVar = this.a;
            if (aVar == null) {
                c.a.r0.a.e0.d.c("Component-Base", o + " insert with a null component context!");
                return new c.a.r0.a.c0.b.c(202, "component context is null");
            }
            Context context = aVar.getContext();
            if (this.f5300e != null || this.f5297b != null) {
                c.a.r0.a.e0.d.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.f5297b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.f5300e = u;
            u.setTargetView(this.f5297b);
            C(this.f5297b, this.f5298c, new c.a.r0.a.c0.f.b(true));
            if (h(this.a)) {
                if (f5296h) {
                    r0 = o + " insert: success";
                }
                return new c.a.r0.a.c0.b.c(0, "success");
            }
            c.a.r0.a.e0.d.c("Component-Base", o + " insert: attach fail");
            return new c.a.r0.a.c0.b.c(1001, "attach fail");
        }
        return (c.a.r0.a.c0.b.c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        c.a.r0.a.c0.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                bVar = (c.a.r0.a.c0.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                c.a.r0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                c.a.r0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                c.a.r0.a.c0.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public c.a.r0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            c.a.r0.a.c0.f.b bVar = new c.a.r0.a.c0.f.b();
            c.a.r0.a.m1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.b(m.l)) {
                bVar.b(3);
            }
            if (m.f5312j != m2.f5312j) {
                bVar.b(1);
            }
            if (m.k != m2.k) {
                bVar.b(2);
            }
            return bVar;
        }
        return (c.a.r0.a.c0.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j(this.f5298c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f5300e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f5298c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.r0.a.c0.b.c i2 = i(this.f5298c);
            if (i2.a()) {
                return this.f5298c.e();
            }
            return "【illegal component#" + i2.f5313b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f5299d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f5297b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f5309g, m.f5308f, m.f5307e, m.k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? (this.f5302g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f5299d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.r0.a.c0.b.a<V extends android.view.View, M extends c.a.r0.a.c0.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ c.a.r0.a.c0.b.c update(@NonNull c.a.r0.a.c0.b.d.a aVar) {
        return update((a<V, M>) ((c.a.r0.a.c0.b.b) aVar));
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @Nullable
    @UiThread
    public final j w() {
        InterceptResult invokeV;
        c.a.r0.a.c0.b.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            if (!i(this.f5298c).a()) {
                c.a.r0.a.e0.d.c("Component-Base", o + " insert delayed with a invalid model => " + i2.f5313b);
                return null;
            }
            if (f5296h) {
                String str = "=====================" + o + " start insertDelayed=====================";
            }
            if (this.a == null) {
                c.a.r0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f5300e != null) {
                c.a.r0.a.e0.d.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f5301f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f5301f.unsubscribe();
                this.f5301f = null;
                c.a.r0.a.e0.d.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f5300e = u(this.a.getContext());
            D(this.f5298c, new c.a.r0.a.c0.f.b(true));
            if (h(this.a)) {
                if (f5296h) {
                    r0 = o + " insert delayed（container view）: success";
                }
                i.d.a(new b(this, Thread.currentThread().getId())).u(new C0276a(this, o));
                return this.f5301f;
            }
            c.a.r0.a.e0.d.c("Component-Base", o + " insert delayed: attach fail");
            return null;
        }
        return (j) invokeV.objValue;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
        }
    }

    @CallSuper
    public void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (f5296h) {
                String str = o() + " onDestroy";
            }
            E();
        }
    }

    @CallSuper
    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            E();
        }
    }

    @NonNull
    @UiThread
    public final c.a.r0.a.c0.b.c update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            c.a.r0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                c.a.r0.a.e0.d.c("Component-Base", o + " update with a invalid model => " + i2.f5313b);
                return i2;
            }
            if (f5296h) {
                String str = "=====================" + o + " start update=====================";
            }
            M m2 = this.f5298c;
            if (m2 == m) {
                String str2 = o + " update with the same model";
                c.a.r0.a.c0.g.a.a("Component-Base", str2);
                return new c.a.r0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(m2.f5308f, m.f5308f)) {
                String str3 = o + " update with different id: " + this.f5298c.f5308f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f5308f;
                c.a.r0.a.c0.g.a.a("Component-Base", str3);
                return new c.a.r0.a.c0.b.c(202, str3);
            } else if (!TextUtils.equals(this.f5298c.f5309g, m.f5309g)) {
                String str4 = o + " update with different slave id: " + this.f5298c.f5309g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f5309g;
                c.a.r0.a.c0.g.a.a("Component-Base", str4);
                return new c.a.r0.a.c0.b.c(202, str4);
            } else if (this.f5297b != null && this.f5300e != null) {
                if (this.a == null) {
                    c.a.r0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new c.a.r0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f5298c;
                this.f5299d = m3;
                c.a.r0.a.c0.f.b k = k(m3, m);
                M j2 = j(m);
                this.f5298c = j2;
                C(this.f5297b, j2, k);
                boolean f2 = this.a.a().f(this, k);
                this.f5299d = null;
                if (!f2) {
                    String str5 = o + " update component fail";
                    c.a.r0.a.e0.d.c("Component-Base", str5);
                    return new c.a.r0.a.c0.b.c(1001, str5);
                }
                if (f5296h) {
                    String str6 = o + " component update: success";
                }
                return new c.a.r0.a.c0.b.c(0, "success");
            } else {
                String str7 = o + " update must after insert succeeded";
                c.a.r0.a.c0.g.a.a("Component-Base", str7);
                return new c.a.r0.a.c0.b.c(202, str7);
            }
        }
        return (c.a.r0.a.c0.b.c) invokeL.objValue;
    }
}
