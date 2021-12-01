package c.a.p0.a.c0.b;

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
import c.a.p0.a.c0.b.b;
import c.a.p0.a.e0.d;
import c.a.p0.a.k;
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
public abstract class a<V extends View, M extends c.a.p0.a.c0.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4365h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public c.a.p0.a.c0.e.a a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f4366b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f4367c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f4368d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f4369e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f4370f;

    /* renamed from: g  reason: collision with root package name */
    public int f4371g;

    /* renamed from: c.a.p0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0183a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4372i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ a f4373j;

        public C0183a(a aVar, String str) {
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
            this.f4373j = aVar;
            this.f4372i = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.p0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.p0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4373j;
                aVar.f4366b = aVar.v(aVar.a.getContext());
                a aVar2 = this.f4373j;
                aVar2.A(aVar2.f4366b);
                this.f4373j.f4369e.setTargetView(this.f4373j.f4366b, 0);
                a aVar3 = this.f4373j;
                aVar3.C(aVar3.f4366b, this.f4373j.f4367c, new c.a.p0.a.c0.f.b(true));
                if (a.f4365h) {
                    String str = this.f4372i + " insert delayed（view）: success";
                }
            }
        }

        @Override // i.e
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.o("Component-Base", this.f4372i + " insert delayed（view）: fail");
                if (a.f4365h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f4373j.B();
            }
        }

        @Override // i.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.o("Component-Base", this.f4372i + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4375f;

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
            this.f4375f = aVar;
            this.f4374e = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.d.a, i.n.b
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f4365h) {
                    String str = "insert delayed => save thread: " + Thread.currentThread().getName();
                }
                if (this.f4374e != Thread.currentThread().getId()) {
                    c.a.p0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f4375f.f4370f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.p0.a.a3.g.b.b {
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

        @Override // c.a.p0.a.a3.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(944168594, "Lc/a/p0/a/c0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(944168594, "Lc/a/p0/a/c0/b/a;");
                return;
            }
        }
        f4365h = k.a;
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
        this.f4367c = j2;
        c.a.p0.a.c0.e.a c2 = c.a.p0.a.c0.d.a.c(j2);
        this.a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.c(context);
                return;
            }
            return;
        }
        c.a.p0.a.e0.d.c("Component-Base", o() + " context is null !");
    }

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final c.a.p0.a.c0.b.c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (f4365h) {
                String str = "=====================" + o + " start remove=====================";
            }
            c.a.p0.a.c0.e.a aVar = this.a;
            if (aVar == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new c.a.p0.a.c0.b.c(202, "component context is null");
            } else if (this.f4369e == null) {
                c.a.p0.a.e0.d.c("Component-Base", o + " remove must after insert");
                return new c.a.p0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str2 = o + " remove fail";
                c.a.p0.a.e0.d.c("Component-Base", str2);
                return new c.a.p0.a.c0.b.c(1001, str2);
            } else {
                z();
                if (f4365h) {
                    String str3 = o + " remove: success";
                }
                return new c.a.p0.a.c0.b.c(0, "success");
            }
        }
        return (c.a.p0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull c.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, bVar) == null) {
            D(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull c.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, bVar) == null) {
            if (this.f4369e == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f4369e.setHidden(m.f4381j);
            }
            if (bVar.a(2)) {
                r(this.f4369e, m);
            }
        }
    }

    public final void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f4370f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f4370f.unsubscribe();
    }

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f4371g = i2 | this.f4371g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull c.a.p0.a.c0.e.a aVar) {
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
    public final c.a.p0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new c.a.p0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f4378g)) {
                return new c.a.p0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new c.a.p0.a.c0.b.c(202, "model is invalid");
            }
            return new c.a.p0.a.c0.b.c(0, "model is valid");
        }
        return (c.a.p0.a.c0.b.c) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final c.a.p0.a.c0.b.c insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            c.a.p0.a.c0.b.c i2 = i(this.f4367c);
            if (!i2.a()) {
                c.a.p0.a.e0.d.c("Component-Base", o + " insert with a invalid model => " + i2.f4383b);
                return i2;
            }
            if (f4365h) {
                String str = "=====================" + o + " start insert=====================";
            }
            c.a.p0.a.c0.e.a aVar = this.a;
            if (aVar == null) {
                c.a.p0.a.e0.d.c("Component-Base", o + " insert with a null component context!");
                return new c.a.p0.a.c0.b.c(202, "component context is null");
            }
            Context context = aVar.getContext();
            if (this.f4369e != null || this.f4366b != null) {
                c.a.p0.a.e0.d.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.f4366b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.f4369e = u;
            u.setTargetView(this.f4366b);
            C(this.f4366b, this.f4367c, new c.a.p0.a.c0.f.b(true));
            if (h(this.a)) {
                if (f4365h) {
                    r0 = o + " insert: success";
                }
                return new c.a.p0.a.c0.b.c(0, "success");
            }
            c.a.p0.a.e0.d.c("Component-Base", o + " insert: attach fail");
            return new c.a.p0.a.c0.b.c(1001, "attach fail");
        }
        return (c.a.p0.a.c0.b.c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        c.a.p0.a.c0.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                bVar = (c.a.p0.a.c0.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                c.a.p0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                c.a.p0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public c.a.p0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            c.a.p0.a.c0.f.b bVar = new c.a.p0.a.c0.f.b();
            c.a.p0.a.m1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.b(m.l)) {
                bVar.b(3);
            }
            if (m.f4381j != m2.f4381j) {
                bVar.b(1);
            }
            if (m.f4382k != m2.f4382k) {
                bVar.b(2);
            }
            return bVar;
        }
        return (c.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j(this.f4367c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f4369e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f4367c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.p0.a.c0.b.c i2 = i(this.f4367c);
            if (i2.a()) {
                return this.f4367c.e();
            }
            return "【illegal component#" + i2.f4383b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f4368d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f4366b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f4378g, m.f4377f, m.f4376e, m.f4382k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? (this.f4371g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f4368d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.p0.a.c0.b.a<V extends android.view.View, M extends c.a.p0.a.c0.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ c.a.p0.a.c0.b.c update(@NonNull c.a.p0.a.c0.b.d.a aVar) {
        return update((a<V, M>) ((c.a.p0.a.c0.b.b) aVar));
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @Nullable
    @UiThread
    public final j w() {
        InterceptResult invokeV;
        c.a.p0.a.c0.b.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            if (!i(this.f4367c).a()) {
                c.a.p0.a.e0.d.c("Component-Base", o + " insert delayed with a invalid model => " + i2.f4383b);
                return null;
            }
            if (f4365h) {
                String str = "=====================" + o + " start insertDelayed=====================";
            }
            if (this.a == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f4369e != null) {
                c.a.p0.a.e0.d.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f4370f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f4370f.unsubscribe();
                this.f4370f = null;
                c.a.p0.a.e0.d.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f4369e = u(this.a.getContext());
            D(this.f4367c, new c.a.p0.a.c0.f.b(true));
            if (h(this.a)) {
                if (f4365h) {
                    r0 = o + " insert delayed（container view）: success";
                }
                i.d.a(new b(this, Thread.currentThread().getId())).u(new C0183a(this, o));
                return this.f4370f;
            }
            c.a.p0.a.e0.d.c("Component-Base", o + " insert delayed: attach fail");
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
            if (f4365h) {
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
    public final c.a.p0.a.c0.b.c update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            c.a.p0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                c.a.p0.a.e0.d.c("Component-Base", o + " update with a invalid model => " + i2.f4383b);
                return i2;
            }
            if (f4365h) {
                String str = "=====================" + o + " start update=====================";
            }
            M m2 = this.f4367c;
            if (m2 == m) {
                String str2 = o + " update with the same model";
                c.a.p0.a.c0.g.a.a("Component-Base", str2);
                return new c.a.p0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(m2.f4377f, m.f4377f)) {
                String str3 = o + " update with different id: " + this.f4367c.f4377f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4377f;
                c.a.p0.a.c0.g.a.a("Component-Base", str3);
                return new c.a.p0.a.c0.b.c(202, str3);
            } else if (!TextUtils.equals(this.f4367c.f4378g, m.f4378g)) {
                String str4 = o + " update with different slave id: " + this.f4367c.f4378g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4378g;
                c.a.p0.a.c0.g.a.a("Component-Base", str4);
                return new c.a.p0.a.c0.b.c(202, str4);
            } else if (this.f4366b != null && this.f4369e != null) {
                if (this.a == null) {
                    c.a.p0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new c.a.p0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f4367c;
                this.f4368d = m3;
                c.a.p0.a.c0.f.b k2 = k(m3, m);
                M j2 = j(m);
                this.f4367c = j2;
                C(this.f4366b, j2, k2);
                boolean f2 = this.a.a().f(this, k2);
                this.f4368d = null;
                if (!f2) {
                    String str5 = o + " update component fail";
                    c.a.p0.a.e0.d.c("Component-Base", str5);
                    return new c.a.p0.a.c0.b.c(1001, str5);
                }
                if (f4365h) {
                    String str6 = o + " component update: success";
                }
                return new c.a.p0.a.c0.b.c(0, "success");
            } else {
                String str7 = o + " update must after insert succeeded";
                c.a.p0.a.c0.g.a.a("Component-Base", str7);
                return new c.a.p0.a.c0.b.c(202, str7);
            }
        }
        return (c.a.p0.a.c0.b.c) invokeL.objValue;
    }
}
