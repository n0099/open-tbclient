package c.a.j.l.h.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.j.l.g;
import c.a.j.l.h.d.b;
import c.a.j.l.h.d.c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class d extends c.a.j.l.h.d.c {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<e> a;

    /* renamed from: b  reason: collision with root package name */
    public static Toast f4193b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f4194c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4195e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4196f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4197g;

        /* renamed from: c.a.j.l.h.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0198a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f4198e;

            public RunnableC0198a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4198e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f4193b = new Toast(this.f4198e.f4195e);
                    d.f4193b.setView(this.f4198e.f4196f);
                    d.f4193b.setGravity(81, 0, this.f4198e.f4197g);
                    c.a.j.m.c.m(d.f4193b, g.toast_animation);
                    d.f4193b.show();
                }
            }
        }

        public a(Context context, ViewGroup viewGroup, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4195e = context;
            this.f4196f = viewGroup;
            this.f4197g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f4194c.post(new RunnableC0198a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f4199e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f4200f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f4201g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a f4202h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f4203e;

            /* renamed from: c.a.j.l.h.d.d$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class View$OnClickListenerC0199a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f4204e;

                public View$OnClickListenerC0199a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f4204e = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.a aVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f4204e.f4203e.f4202h) == null) {
                        return;
                    }
                    aVar.a();
                }
            }

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f4203e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f4193b = new Toast(this.f4203e.f4199e);
                    d.f4193b.setView(this.f4203e.f4200f);
                    d.f4193b.setGravity(81, 0, this.f4203e.f4201g);
                    c.a.j.m.c.m(d.f4193b, g.toast_animation);
                    this.f4203e.f4200f.setOnClickListener(new View$OnClickListenerC0199a(this));
                    d.f4193b.show();
                }
            }
        }

        public b(Context context, ViewGroup viewGroup, int i2, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i2), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4199e = context;
            this.f4200f = viewGroup;
            this.f4201g = i2;
            this.f4202h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f4194c.post(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f4205b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f4206c;

        public c(Context context, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f4205b = i2;
            this.f4206c = i3;
        }

        @Override // c.a.j.l.h.d.c.e
        public void a(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                e eVar = new e(this.a);
                d.j(eVar);
                if (c.a.j.m.c.d()) {
                    eVar.n(2003);
                }
                eVar.f(viewGroup);
                eVar.e(81, 0, this.f4205b);
                eVar.d(this.f4206c);
                eVar.j(g.toast_animation);
                eVar.c();
            }
        }
    }

    /* renamed from: c.a.j.l.h.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0200d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        public C0200d(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // c.a.j.l.h.d.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a aVar = this.a;
                if (aVar != null) {
                    aVar.a();
                }
                d.e();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1396917737, "Lc/a/j/l/h/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1396917737, "Lc/a/j/l/h/d/d;");
                return;
            }
        }
        f4194c = new Handler(Looper.getMainLooper());
    }

    public static void e() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            WeakReference<e> weakReference = a;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.i();
            }
            Toast toast = f4193b;
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, int i2, String str, CharSequence charSequence2, int i3, int i4, String str2, String str3, String str4, String str5, String str6, b.a aVar, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Integer.valueOf(i2), str, charSequence2, Integer.valueOf(i3), Integer.valueOf(i4), str2, str3, str4, str5, str6, aVar, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(c.a.j.l.c.sdk_toast_view_margin_bottom);
            if (cVar != null) {
                dimension = cVar.a();
            }
            if (c.a.j.m.c.p(context)) {
                ViewGroup a2 = c.a.j.l.h.d.c.a(context, charSequence, str2, str3);
                c.a.j.l.h.d.c.c(str, a2, new b(applicationContext, a2, dimension, aVar));
                return;
            }
            c.a.j.l.h.d.c.b(context, charSequence, i2, charSequence2, i3, str2, str, str3, str4, str5, str6, new c(applicationContext, dimension, i4), new C0200d(aVar));
        }
    }

    public static void g(Context context, CharSequence charSequence, int i2, String str, String str2, String str3, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, charSequence, Integer.valueOf(i2), str, str2, str3, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(c.a.j.l.c.sdk_toast_view_margin_bottom);
            if (cVar != null) {
                dimension = cVar.a();
            }
            ViewGroup a2 = c.a.j.l.h.d.c.a(context, charSequence, str, str3);
            c.a.j.l.h.d.c.c(str2, a2, new a(applicationContext, a2, dimension));
        }
    }

    public static void j(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, eVar) == null) {
            WeakReference<e> weakReference = a;
            if (weakReference != null) {
                weakReference.clear();
            }
            a = new WeakReference<>(eVar);
        }
    }
}
