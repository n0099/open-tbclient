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
    public static final boolean f4644h;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public c.a.p0.a.c0.e.a f4645a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public V f4646b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public M f4647c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public M f4648d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public SwanAppComponentContainerView f4649e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public j f4650f;

    /* renamed from: g  reason: collision with root package name */
    public int f4651g;

    /* renamed from: c.a.p0.a.c0.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0124a extends j<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f4652e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4653f;

        public C0124a(a aVar, String str) {
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
            this.f4653f = aVar;
            this.f4652e = str;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: c.a.p0.a.c0.b.a */
        /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: c.a.p0.a.c0.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i.e
        public void onCompleted() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                a aVar = this.f4653f;
                aVar.f4646b = aVar.v(aVar.f4645a.b());
                a aVar2 = this.f4653f;
                aVar2.B(aVar2.f4646b);
                this.f4653f.f4649e.setTargetView(this.f4653f.f4646b, 0);
                a aVar3 = this.f4653f;
                aVar3.D(aVar3.f4646b, this.f4653f.f4647c, new c.a.p0.a.c0.f.b(true));
                if (a.f4644h) {
                    String str = this.f4652e + " insert delayed（view）: success";
                }
            }
        }

        @Override // i.e
        public void onError(Throwable th) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, th) == null) {
                d.l("Component-Base", this.f4652e + " insert delayed（view）: fail");
                if (a.f4644h && th != null && TextUtils.equals(th.getMessage(), "save subscriber and return subscriber: nolinear !")) {
                    throw new RuntimeException("save subscriber and return subscriber: nolinear !");
                }
                this.f4653f.C();
            }
        }

        @Override // i.e
        public void onNext(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj) == null) {
                d.l("Component-Base", this.f4652e + " success should call onCompleted");
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ long f4654e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f4655f;

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
            this.f4655f = aVar;
            this.f4654e = j2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // i.n.b
        /* renamed from: a */
        public void call(j<? super Object> jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jVar) == null) {
                if (a.f4644h) {
                    String str = "insert delayed => save thread: " + Thread.currentThread().getName();
                }
                if (this.f4654e != Thread.currentThread().getId()) {
                    c.a.p0.a.c0.g.a.a("Component-Base", "save subscriber and return subscriber: nolinear !");
                }
                this.f4655f.f4650f = jVar;
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends c.a.p0.a.w2.g.b.b {
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

        @Override // c.a.p0.a.w2.g.b.b, android.view.View.OnTouchListener
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
        f4644h = k.f7077a;
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
        this.f4647c = j2;
        c.a.p0.a.c0.e.a c2 = c.a.p0.a.c0.d.a.c(j2);
        this.f4645a = c2;
        if (c2 != null) {
            if (context != null) {
                c2.d(context);
                return;
            }
            return;
        }
        c.a.p0.a.e0.d.b("Component-Base", o() + " context is null !");
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
    public final c.a.p0.a.c0.b.c C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            String o = o();
            if (f4644h) {
                String str = "=====================" + o + " start remove=====================";
            }
            c.a.p0.a.c0.e.a aVar = this.f4645a;
            if (aVar == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", o + " remove with a null component context!");
                return new c.a.p0.a.c0.b.c(202, "component context is null");
            } else if (this.f4649e == null) {
                c.a.p0.a.e0.d.b("Component-Base", o + " remove must after insert");
                return new c.a.p0.a.c0.b.c(202, "component remove must after insert");
            } else if (!aVar.a().e(this)) {
                String str2 = o + " remove fail";
                c.a.p0.a.e0.d.b("Component-Base", str2);
                return new c.a.p0.a.c0.b.c(1001, str2);
            } else {
                A();
                if (f4644h) {
                    String str3 = o + " remove: success";
                }
                return new c.a.p0.a.c0.b.c(0, "success");
            }
        }
        return (c.a.p0.a.c0.b.c) invokeV.objValue;
    }

    @CallSuper
    public void D(@NonNull V v, @NonNull M m, @NonNull c.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048579, this, v, m, bVar) == null) {
            E(m, bVar);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void E(@NonNull M m, @NonNull c.a.p0.a.c0.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, m, bVar) == null) {
            if (this.f4649e == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", "renderContainerView with a null container view");
                return;
            }
            if (bVar.a(1)) {
                this.f4649e.setHidden(m.f4661j);
            }
            if (bVar.a(2)) {
                r(this.f4649e, m);
            }
        }
    }

    public final void F() {
        j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (jVar = this.f4650f) == null || jVar.isUnsubscribed()) {
            return;
        }
        this.f4650f.unsubscribe();
    }

    @NonNull
    @UiThread
    public final c.a.p0.a.c0.b.c G(@NonNull M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, m)) == null) {
            String o = o();
            c.a.p0.a.c0.b.c i2 = i(m);
            if (!i2.a()) {
                c.a.p0.a.e0.d.b("Component-Base", o + " update with a invalid model => " + i2.f4663b);
                return i2;
            }
            if (f4644h) {
                String str = "=====================" + o + " start update=====================";
            }
            M m2 = this.f4647c;
            if (m2 == m) {
                String str2 = o + " update with the same model";
                c.a.p0.a.c0.g.a.a("Component-Base", str2);
                return new c.a.p0.a.c0.b.c(202, str2);
            } else if (!TextUtils.equals(m2.f4657f, m.f4657f)) {
                String str3 = o + " update with different id: " + this.f4647c.f4657f + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4657f;
                c.a.p0.a.c0.g.a.a("Component-Base", str3);
                return new c.a.p0.a.c0.b.c(202, str3);
            } else if (!TextUtils.equals(this.f4647c.f4658g, m.f4658g)) {
                String str4 = o + " update with different slave id: " + this.f4647c.f4658g + StringUtil.ARRAY_ELEMENT_SEPARATOR + m.f4658g;
                c.a.p0.a.c0.g.a.a("Component-Base", str4);
                return new c.a.p0.a.c0.b.c(202, str4);
            } else if (this.f4646b != null && this.f4649e != null) {
                if (this.f4645a == null) {
                    c.a.p0.a.c0.g.a.a("Component-Base", o + " update with a null component context!");
                    return new c.a.p0.a.c0.b.c(202, "component context is null");
                }
                M m3 = this.f4647c;
                this.f4648d = m3;
                c.a.p0.a.c0.f.b k = k(m3, m);
                M j2 = j(m);
                this.f4647c = j2;
                D(this.f4646b, j2, k);
                boolean f2 = this.f4645a.a().f(this, k);
                this.f4648d = null;
                if (!f2) {
                    String str5 = o + " update component fail";
                    c.a.p0.a.e0.d.b("Component-Base", str5);
                    return new c.a.p0.a.c0.b.c(1001, str5);
                }
                if (f4644h) {
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

    @NonNull
    public final a g(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            this.f4651g = i2 | this.f4651g;
            return this;
        }
        return (a) invokeI.objValue;
    }

    public final boolean h(@NonNull c.a.p0.a.c0.e.a aVar) {
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
    public final c.a.p0.a.c0.b.c i(M m) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, m)) == null) {
            if (m == null) {
                return new c.a.p0.a.c0.b.c(202, "model is null");
            }
            if (TextUtils.isEmpty(m.f4658g)) {
                return new c.a.p0.a.c0.b.c(202, "slave id is empty");
            }
            if (!m.isValid()) {
                return new c.a.p0.a.c0.b.c(202, "model is invalid");
            }
            return new c.a.p0.a.c0.b.c(0, "model is valid");
        }
        return (c.a.p0.a.c0.b.c) invokeL.objValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, m)) == null) {
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, m, m2)) == null) {
            c.a.p0.a.c0.f.b bVar = new c.a.p0.a.c0.f.b();
            c.a.p0.a.l1.e.a.a aVar = m2.l;
            if (aVar != null && aVar.e(m.l)) {
                bVar.b(3);
            }
            if (m.f4661j != m2.f4661j) {
                bVar.b(1);
            }
            if (m.k != m2.k) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? j(this.f4647c) : (M) invokeV.objValue;
    }

    @Nullable
    public final SwanAppComponentContainerView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.f4649e : (SwanAppComponentContainerView) invokeV.objValue;
    }

    @NonNull
    public final M n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f4647c : (M) invokeV.objValue;
    }

    @NonNull
    public final String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.p0.a.c0.b.c i2 = i(this.f4647c);
            if (i2.a()) {
                return this.f4647c.f();
            }
            return "【illegal component#" + i2.f4663b + "】";
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public final M p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.f4648d : (M) invokeV.objValue;
    }

    @Nullable
    public final V q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.f4646b : (V) invokeV.objValue;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void r(@NonNull SwanAppComponentContainerView swanAppComponentContainerView, @NonNull M m) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, swanAppComponentContainerView, m) == null) {
            swanAppComponentContainerView.setOnTouchListener(new c(this, m.f4658g, m.f4657f, m.f4656e, m.k));
        }
    }

    public final boolean s(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? (this.f4651g & i2) == i2 : invokeI.booleanValue;
    }

    public final boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f4648d != null : invokeV.booleanValue;
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
    public final c.a.p0.a.c0.b.c w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            String o = o();
            c.a.p0.a.c0.b.c i2 = i(this.f4647c);
            if (!i2.a()) {
                c.a.p0.a.e0.d.b("Component-Base", o + " insert with a invalid model => " + i2.f4663b);
                return i2;
            }
            if (f4644h) {
                String str = "=====================" + o + " start insert=====================";
            }
            c.a.p0.a.c0.e.a aVar = this.f4645a;
            if (aVar == null) {
                c.a.p0.a.e0.d.b("Component-Base", o + " insert with a null component context!");
                return new c.a.p0.a.c0.b.c(202, "component context is null");
            }
            Context b2 = aVar.b();
            if (this.f4649e != null || this.f4646b != null) {
                c.a.p0.a.e0.d.l("Component-Base", o + " repeat insert");
            }
            V v = v(this.f4645a.b());
            this.f4646b = v;
            B(v);
            SwanAppComponentContainerView u = u(b2);
            this.f4649e = u;
            u.setTargetView(this.f4646b);
            D(this.f4646b, this.f4647c, new c.a.p0.a.c0.f.b(true));
            if (h(this.f4645a)) {
                if (f4644h) {
                    r0 = o + " insert: success";
                }
                return new c.a.p0.a.c0.b.c(0, "success");
            }
            c.a.p0.a.e0.d.b("Component-Base", o + " insert: attach fail");
            return new c.a.p0.a.c0.b.c(1001, "attach fail");
        }
        return (c.a.p0.a.c0.b.c) invokeV.objValue;
    }

    @Nullable
    @UiThread
    public final j x() {
        InterceptResult invokeV;
        c.a.p0.a.c0.b.c i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String o = o();
            if (!i(this.f4647c).a()) {
                c.a.p0.a.e0.d.b("Component-Base", o + " insert delayed with a invalid model => " + i2.f4663b);
                return null;
            }
            if (f4644h) {
                String str = "=====================" + o + " start insertDelayed=====================";
            }
            if (this.f4645a == null) {
                c.a.p0.a.c0.g.a.a("Component-Base", o + " insert delayed with a null component context!");
                return null;
            }
            if (this.f4649e != null) {
                c.a.p0.a.e0.d.l("Component-Base", o + " repeat insert delayed: container view repeat");
            }
            j jVar = this.f4650f;
            if (jVar != null && !jVar.isUnsubscribed()) {
                this.f4650f.unsubscribe();
                this.f4650f = null;
                c.a.p0.a.e0.d.l("Component-Base", o + " insert delayed repeat: subscriber repeat");
            }
            this.f4649e = u(this.f4645a.b());
            E(this.f4647c, new c.a.p0.a.c0.f.b(true));
            if (h(this.f4645a)) {
                if (f4644h) {
                    r0 = o + " insert delayed（container view）: success";
                }
                i.d.b(new b(this, Thread.currentThread().getId())).z(new C0124a(this, o));
                return this.f4650f;
            }
            c.a.p0.a.e0.d.b("Component-Base", o + " insert delayed: attach fail");
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
            if (f4644h) {
                String str = o() + " onDestroy";
            }
            F();
        }
    }
}
