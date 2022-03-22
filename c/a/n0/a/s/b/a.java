package c.a.n0.a.s.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s.b.b;
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
import g.d;
import g.j;
/* loaded from: classes.dex */
public abstract class a<V extends View, M extends c.a.n0.a.s.b.b> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f6086h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public c.a.n0.a.s.e.a a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f6087b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f6088c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f6089d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f6090e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f6091f;

    /* renamed from: g  reason: collision with root package name */
    public int f6092g;

    /* renamed from: c.a.n0.a.s.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0438a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6093e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f6094f;

        public C0438a(a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6094f = aVar;
            this.f6093e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.n0.a.s.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.n0.a.s.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // g.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f6094f;
                aVar.f6087b = aVar.v(aVar.a.getContext());
                a aVar2 = this.f6094f;
                aVar2.A(aVar2.f6087b);
                this.f6094f.f6090e.setTargetView(this.f6094f.f6087b, 0);
                a aVar3 = this.f6094f;
                aVar3.C(aVar3.f6087b, this.f6094f.f6088c, new c.a.n0.a.s.f.b(true));
                if (a.f6086h) {
                    Log.d("Component-Base", this.f6093e + " insert delayed（view）: success");
                }
            }
        }

        @Override // g.e
        @SuppressLint({"BDThrowableCheck"})
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.o("Component-Base", this.f6093e + " insert delayed（view）: fail");
                if (a.f6086h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f6094f.B();
            }
        }

        @Override // g.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.o("Component-Base", this.f6093e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f6095b;

        public b(a aVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6095b = aVar;
            this.a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // g.d.a, g.n.b
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f6086h) {
                    Log.d("Component-Base", "insert delayed => save thread: " + Thread.currentThread().getName());
                }
                if (this.a != Thread.currentThread().getId()) {
                    c.a.n0.a.s.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f6095b.f6091f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.n0.a.q2.g.b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar, String str, String str2, String str3, boolean z) {
            super(str, str2, str3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, str2, str3, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (String) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = z;
        }

        @Override // c.a.n0.a.q2.g.b.b, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) ? this.j && super.onTouch(view, motionEvent) : invokeLL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-766182120, "Lc/a/n0/a/s/b/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-766182120, "Lc/a/n0/a/s/b/a;");
                return;
            }
        }
        f6086h = c.a.n0.a.a.a;
    }

    public a(@Nullable Context context, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, m};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        M j = j(m);
        this.f6088c = j;
        c.a.n0.a.s.e.a c2 = c.a.n0.a.s.d.a.c(j);
        this.a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.c(context);
                return;
            }
            return;
        }
        c.a.n0.a.u.d.c("Component-Base", o() + " context is null !");
    }

    public void A(@NonNull V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, v) == null) {
        }
    }

    @NonNull
    @UiThread
    public final c.a.n0.a.s.b.c B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String o = o();
            if (f6086h) {
                Log.i("Component-Base", "=====================" + o + " start remove=====================");
            }
            c.a.n0.a.s.e.a aVar = this.a;
            if (aVar == null) {
                c.a.n0.a.s.g.a.a("Component-Base", o + " remove with a null component context!");
                return new c.a.n0.a.s.b.c(202, "component context is null");
            } else if (this.f6090e == null) {
                c.a.n0.a.u.d.c("Component-Base", o + " remove must after insert");
                return new c.a.n0.a.s.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str = o + " remove fail";
                c.a.n0.a.u.d.c("Component-Base", str);
                return new c.a.n0.a.s.b.c(1001, str);
            } else {
                z();
                if (f6086h) {
                    Log.d("Component-Base", o + " remove: success");
                }
                return new c.a.n0.a.s.b.c(0, "success");
            }
        }
        return (c.a.n0.a.s.b.c) invokeV.objValue;
    }

    @CallSuper
    public void C(@NonNull V v, @NonNull M m, @NonNull c.a.n0.a.s.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, v, m, bVar) == null) {
            D(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void D(@NonNull M m, @NonNull c.a.n0.a.s.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, m, bVar) == null) {
            if (this.f6090e == null) {
                c.a.n0.a.s.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f6090e.setHidden(m.f6100f);
            }
            if (bVar.a(2)) {
                r(this.f6090e, m);
            }
        }
    }

    public final void E() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (jVar = this.f6091f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f6091f.unsubscribe();
    }

    @NonNull
    public final a g(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.f6092g = i | this.f6092g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull c.a.n0.a.s.e.a aVar) {
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
    public final c.a.n0.a.s.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, m)) == null) {
            if (m == null) {
                return new c.a.n0.a.s.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f6097c)) {
                return new c.a.n0.a.s.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new c.a.n0.a.s.b.c(202, "model is invalid");
            }
            return new c.a.n0.a.s.b.c(0, "model is valid");
        }
        return (c.a.n0.a.s.b.c) invokeL.objValue;
    }

    @NonNull
    @UiThread
    public final c.a.n0.a.s.b.c insert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            String o = o();
            c.a.n0.a.s.b.c i = i(this.f6088c);
            if (!i.a()) {
                c.a.n0.a.u.d.c("Component-Base", o + " insert with a invalid model => " + i.f6103b);
                return i;
            }
            if (f6086h) {
                Log.i("Component-Base", "=====================" + o + " start insert=====================");
            }
            c.a.n0.a.s.e.a aVar = this.a;
            if (aVar == null) {
                c.a.n0.a.u.d.c("Component-Base", o + " insert with a null component context!");
                return new c.a.n0.a.s.b.c(202, "component context is null");
            }
            Context context = aVar.getContext();
            if (this.f6090e != null || this.f6087b != null) {
                c.a.n0.a.u.d.o("Component-Base", o + " repeat insert");
            }
            V v = v(this.a.getContext());
            this.f6087b = v;
            A(v);
            SwanAppComponentContainerView u = u(context);
            this.f6090e = u;
            u.setTargetView(this.f6087b);
            C(this.f6087b, this.f6088c, new c.a.n0.a.s.f.b(true));
            if (h(this.a)) {
                if (f6086h) {
                    Log.d("Component-Base", o + " insert: success");
                }
                return new c.a.n0.a.s.b.c(0, "success");
            }
            c.a.n0.a.u.d.c("Component-Base", o + " insert: attach fail");
            return new c.a.n0.a.s.b.c(1001, "attach fail");
        }
        return (c.a.n0.a.s.b.c) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final M j(@NonNull M m) {
        InterceptResult invokeL;
        c.a.n0.a.s.b.b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            try {
                bVar = (c.a.n0.a.s.b.b) m.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                c.a.n0.a.s.g.a.b("Component-Base", "model must implement cloneable", e2);
                bVar = null;
                if (bVar == null) {
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                c.a.n0.a.s.g.a.b("Component-Base", "clone model fail ！", e3);
                bVar = null;
                if (bVar == null) {
                }
            }
            if (bVar == null) {
                c.a.n0.a.s.g.a.a("Component-Base", "clone model fail ！");
                return m;
            }
            return (M) bVar;
        }
        return (M) invokeL.objValue;
    }

    @NonNull
    @CallSuper
    public c.a.n0.a.s.f.b k(@NonNull M m, @NonNull M m2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, m, m2)) == null) {
            c.a.n0.a.s.f.b bVar = new c.a.n0.a.s.f.b();
            c.a.n0.a.c1.e.a.a aVar = m2.f6102h;
            if (aVar != null && aVar.b(m.f6102h)) {
                bVar.b(3);
            }
            if (m.f6100f != m2.f6100f) {
                bVar.b(1);
            }
            if (m.f6101g != m2.f6101g) {
                bVar.b(2);
            }
            return bVar;
        }
        return (c.a.n0.a.s.f.b) invokeLL.objValue;
    }

    @NonNull
    public final M l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? j(this.f6088c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.f6090e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f6088c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.n0.a.s.b.c i = i(this.f6088c);
            if (i.a()) {
                return this.f6088c.d();
            }
            return "【illegal component#" + i.f6103b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f6089d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f6087b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f6097c, m.f6096b, m.a, m.f6101g));
        }
    }

    public final boolean s(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i)) == null) ? (this.f6092g & i) == i : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.f6089d != null : invokeV.booleanValue;
    }

    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, context)) == null) ? new SwanAppComponentContainerView(context) : (SwanAppComponentContainerView) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: c.a.n0.a.s.b.a<V extends android.view.View, M extends c.a.n0.a.s.b.b> */
    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    @UiThread
    public /* bridge */ /* synthetic */ c.a.n0.a.s.b.c update(@NonNull c.a.n0.a.s.b.d.a aVar) {
        return update((a<V, M>) ((c.a.n0.a.s.b.b) aVar));
    }

    @NonNull
    public abstract V v(@NonNull Context context);

    @Nullable
    @UiThread
    public final j w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            c.a.n0.a.s.b.c i = i(this.f6088c);
            if (!i.a()) {
                c.a.n0.a.u.d.c("Component-Base", o + " insert delayed with a invalid model => " + i.f6103b);
                return null;
            }
            if (f6086h) {
                Log.i("Component-Base", "=====================" + o + " start insertDelayed=====================");
            }
            if (this.a == null) {
                c.a.n0.a.s.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f6090e != null) {
                c.a.n0.a.u.d.o("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f6091f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f6091f.unsubscribe();
                this.f6091f = null;
                c.a.n0.a.u.d.o("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f6090e = u(this.a.getContext());
            D(this.f6088c, new c.a.n0.a.s.f.b(true));
            if (h(this.a)) {
                if (f6086h) {
                    Log.d("Component-Base", o + " insert delayed（container view）: success");
                }
                g.d.a(new b(this, Thread.currentThread().getId())).u(new C0438a(this, o));
                return this.f6091f;
            }
            c.a.n0.a.u.d.c("Component-Base", o + " insert delayed: attach fail");
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
            if (f6086h) {
                Log.d("Component-Base", o() + " onDestroy");
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
    public final c.a.n0.a.s.b.c update(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, m)) == null) {
            String o = o();
            c.a.n0.a.s.b.c i = i(m);
            if (!i.a()) {
                c.a.n0.a.u.d.c("Component-Base", o + " update with a invalid model => " + i.f6103b);
                return i;
            }
            if (f6086h) {
                Log.i("Component-Base", "=====================" + o + " start update=====================");
            }
            M m2 = this.f6088c;
            if (m2 == m) {
                String str = o + " update with the same model";
                c.a.n0.a.s.g.a.a("Component-Base", str);
                return new c.a.n0.a.s.b.c(202, str);
            } else if (!TextUtils.equals(m2.f6096b, m.f6096b)) {
                String str2 = o + " update with different id: " + this.f6088c.f6096b + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f6096b;
                c.a.n0.a.s.g.a.a("Component-Base", str2);
                return new c.a.n0.a.s.b.c(202, str2);
            } else if (!TextUtils.equals(this.f6088c.f6097c, m.f6097c)) {
                String str3 = o + " update with different slave id: " + this.f6088c.f6097c + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f6097c;
                c.a.n0.a.s.g.a.a("Component-Base", str3);
                return new c.a.n0.a.s.b.c(202, str3);
            } else if (this.f6087b != null && this.f6090e != null) {
                if (this.a == null) {
                    c.a.n0.a.s.g.a.a("Component-Base", o + " update with a null component context!");
                    return new c.a.n0.a.s.b.c(202, "component context is null");
                }
                M m3 = this.f6088c;
                this.f6089d = m3;
                c.a.n0.a.s.f.b k = k(m3, m);
                M j = j(m);
                this.f6088c = j;
                C(this.f6087b, j, k);
                boolean f2 = this.a.a().f(this, k);
                this.f6089d = null;
                if (!f2) {
                    String str4 = o + " update component fail";
                    c.a.n0.a.u.d.c("Component-Base", str4);
                    return new c.a.n0.a.s.b.c(1001, str4);
                }
                if (f6086h) {
                    Log.d("Component-Base", o + " component update: success");
                }
                return new c.a.n0.a.s.b.c(0, "success");
            } else {
                String str5 = o + " update must after insert succeeded";
                c.a.n0.a.s.g.a.a("Component-Base", str5);
                return new c.a.n0.a.s.b.c(202, str5);
            }
        }
        return (c.a.n0.a.s.b.c) invokeL.objValue;
    }
}
