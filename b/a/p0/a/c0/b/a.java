package b.a.p0.a.c0.b;

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
import b.a.p0.a.c0.b.b;
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
import h.d;
import h.j;
/* loaded from: classes.dex */
public abstract class a<V extends View, M extends b.a.p0.a.c0.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f4044h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public b.a.p0.a.c0.e.a f4045a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f4046b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f4047c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f4048d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f4049e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f4050f;

    /* renamed from: g  reason: collision with root package name */
    public int f4051g;

    /* renamed from: b.a.p0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0119a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f4052i;
        public final /* synthetic */ a j;

        public C0119a(a aVar, String str) {
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
            this.j = aVar;
            this.f4052i = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: b.a.p0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: b.a.p0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // h.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.j;
                aVar.f4046b = aVar.v(aVar.f4045a.getContext());
                a aVar2 = this.j;
                aVar2.A(aVar2.f4046b);
                this.j.f4049e.setTargetView(this.j.f4046b, 0);
                a aVar3 = this.j;
                aVar3.C(aVar3.f4046b, this.j.f4047c, new b.a.p0.a.c0.f.b(true));
                if (a.f4044h) {
                    String str = this.f4052i + " insert delayed（view）: success";
                }
            }
        }

        @Override // h.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.l("Component-Base", this.f4052i + " insert delayed（view）: fail");
                if (a.f4044h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.j.B();
            }
        }

        @Override // h.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.l("Component-Base", this.f4052i + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4054f;

        public b(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4054f = aVar;
            this.f4053e = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.d.a, h.n.b
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f4044h) {
                    String str = "insert delayed => save thread: " + Thread.currentThread().getName();
                }
                if (this.f4053e != Thread.currentThread().getId()) {
                    b.a.p0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f4054f.f4050f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends b.a.p0.a.w2.g.b.b {
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

        @Override // b.a.p0.a.w2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.n && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1454702771, "Lb/a/p0/a/c0/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1454702771, "Lb/a/p0/a/c0/b/a;");
                return;
            }
        }
        f4044h = k.f6397a;
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
        M j = j(m);
        this.f4047c = j;
        b.a.p0.a.c0.e.a c2 = b.a.p0.a.c0.d.a.c(j);
        this.f4045a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.c(context);
                return;
            }
            return;
        }
        b.a.p0.a.e0.d.b("Component-Base", o() + " context is null !");
    }

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final b.a.p0.a.c0.b.c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (f4044h) {
                String str = "=====================" + o + " start remove=====================";
            }
            b.a.p0.a.c0.e.a aVar = this.f4045a;
            if (aVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new b.a.p0.a.c0.b.c(202, "component context is null");
            } else if (this.f4049e == null) {
                b.a.p0.a.e0.d.b("Component-Base", o + " remove must after insert");
                return new b.a.p0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str2 = o + " remove fail";
                b.a.p0.a.e0.d.b("Component-Base", str2);
                return new b.a.p0.a.c0.b.c(1001, str2);
            } else {
                z();
                if (f4044h) {
                    String str3 = o + " remove: success";
                }
                return new b.a.p0.a.c0.b.c(0, "success");
            }
        }
        return (b.a.p0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull b.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, bVar) == null) {
            D(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull b.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, bVar) == null) {
            if (this.f4049e == null) {
                b.a.p0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f4049e.setHidden(m.j);
            }
            if (bVar.a(2)) {
                r(this.f4049e, m);
            }
        }
    }

    public final void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f4050f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f4050f.unsubscribe();
    }

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            this.f4051g = i2 | this.f4051g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull b.a.p0.a.c0.e.a aVar) {
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
    public final b.a.p0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new b.a.p0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f4057g)) {
                return new b.a.p0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new b.a.p0.a.c0.b.c(202, "model is invalid");
            }
            return new b.a.p0.a.c0.b.c(0, "model is valid");
        }
        return (b.a.p0.a.c0.b.c) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final b.a.p0.a.c0.b.c insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            b.a.p0.a.c0.b.c i2 = i(this.f4047c);
            if (!i2.a()) {
                b.a.p0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f4061b);
                return i2;
            }
            if (f4044h) {
                String str = "=====================" + o + " start insert=====================";
            }
            b.a.p0.a.c0.e.a aVar = this.f4045a;
            if (aVar == null) {
                b.a.p0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
                return new b.a.p0.a.c0.b.c(202, "component context is null");
            }
            Context context = aVar.getContext();
            if (this.f4049e != null || this.f4046b != null) {
                b.a.p0.a.e0.d.l("Component-Base", o + " repeat insert");
            }
            V v = v(this.f4045a.getContext());
            this.f4046b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.f4049e = u;
            u.setTargetView(this.f4046b);
            C(this.f4046b, this.f4047c, new b.a.p0.a.c0.f.b(true));
            if (h(this.f4045a)) {
                if (f4044h) {
                    r0 = o + " insert: success";
                }
                return new b.a.p0.a.c0.b.c(0, "success");
            }
            b.a.p0.a.e0.d.b("Component-Base", o + " insert: attach fail");
            return new b.a.p0.a.c0.b.c(1001, "attach fail");
        }
        return (b.a.p0.a.c0.b.c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        b.a.p0.a.c0.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                bVar = (b.a.p0.a.c0.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                b.a.p0.a.c0.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                b.a.p0.a.c0.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                b.a.p0.a.c0.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public b.a.p0.a.c0.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            b.a.p0.a.c0.f.b bVar = new b.a.p0.a.c0.f.b();
            b.a.p0.a.l1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.b(m.l)) {
                bVar.b(3);
            }
            if (m.j != m2.j) {
                bVar.b(1);
            }
            if (m.k != m2.k) {
                bVar.b(2);
            }
            return bVar;
        }
        return (b.a.p0.a.c0.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j(this.f4047c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f4049e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f4047c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            b.a.p0.a.c0.b.c i2 = i(this.f4047c);
            if (i2.a()) {
                return this.f4047c.e();
            }
            return "【illegal component#" + i2.f4061b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f4048d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f4046b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f4057g, m.f4056f, m.f4055e, m.k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) ? (this.f4051g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f4048d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: b.a.p0.a.c0.b.a<V extends android.view.View, M extends b.a.p0.a.c0.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ b.a.p0.a.c0.b.c update(@NonNull b.a.p0.a.c0.b.d.a aVar) {
        return update((a<V, M>) ((b.a.p0.a.c0.b.b) aVar));
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @Nullable
    @UiThread
    public final j w() {
        InterceptResult invokeV;
        b.a.p0.a.c0.b.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            if (!i(this.f4047c).a()) {
                b.a.p0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f4061b);
                return null;
            }
            if (f4044h) {
                String str = "=====================" + o + " start insertDelayed=====================";
            }
            if (this.f4045a == null) {
                b.a.p0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f4049e != null) {
                b.a.p0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f4050f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f4050f.unsubscribe();
                this.f4050f = null;
                b.a.p0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f4049e = u(this.f4045a.getContext());
            D(this.f4047c, new b.a.p0.a.c0.f.b(true));
            if (h(this.f4045a)) {
                if (f4044h) {
                    r0 = o + " insert delayed（container view）: success";
                }
                h.d.a(new b(this, Thread.currentThread().getId())).u(new C0119a(this, o));
                return this.f4050f;
            }
            b.a.p0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
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
            if (f4044h) {
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
    public final b.a.p0.a.c0.b.c update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            b.a.p0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                b.a.p0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f4061b);
                return i2;
            }
            if (f4044h) {
                String str = "=====================" + o + " start update=====================";
            }
            M m2 = this.f4047c;
            if (m2 == m) {
                String str2 = o + " update with the same model";
                b.a.p0.a.c0.g.a.a("Component-Base", str2);
                return new b.a.p0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(m2.f4056f, m.f4056f)) {
                String str3 = o + " update with different id: " + this.f4047c.f4056f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4056f;
                b.a.p0.a.c0.g.a.a("Component-Base", str3);
                return new b.a.p0.a.c0.b.c(202, str3);
            } else if (!TextUtils.equals(this.f4047c.f4057g, m.f4057g)) {
                String str4 = o + " update with different slave id: " + this.f4047c.f4057g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4057g;
                b.a.p0.a.c0.g.a.a("Component-Base", str4);
                return new b.a.p0.a.c0.b.c(202, str4);
            } else if (this.f4046b != null && this.f4049e != null) {
                if (this.f4045a == null) {
                    b.a.p0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new b.a.p0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f4047c;
                this.f4048d = m3;
                b.a.p0.a.c0.f.b k = k(m3, m);
                M j = j(m);
                this.f4047c = j;
                C(this.f4046b, j, k);
                boolean f2 = this.f4045a.a().f(this, k);
                this.f4048d = null;
                if (!f2) {
                    String str5 = o + " update component fail";
                    b.a.p0.a.e0.d.b("Component-Base", str5);
                    return new b.a.p0.a.c0.b.c(1001, str5);
                }
                if (f4044h) {
                    String str6 = o + " component update: success";
                }
                return new b.a.p0.a.c0.b.c(0, "success");
            } else {
                String str7 = o + " update must after insert succeeded";
                b.a.p0.a.c0.g.a.a("Component-Base", str7);
                return new b.a.p0.a.c0.b.c(202, str7);
            }
        }
        return (b.a.p0.a.c0.b.c) invokeL.objValue;
    }
}
