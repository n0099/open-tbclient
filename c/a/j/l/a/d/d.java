package c.a.j.l.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.InputDeviceCompat;
import c.a.j.l.a.d.b;
import c.a.j.l.a.d.c;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public final class d extends c.a.j.l.a.d.c {
    public static /* synthetic */ Interceptable $ic;
    public static WeakReference<e> a;

    /* renamed from: b  reason: collision with root package name */
    public static Toast f3810b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f3811c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3812e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3813f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3814g;

        /* renamed from: c.a.j.l.a.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0180a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f3815e;

            public RunnableC0180a(a aVar) {
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
                this.f3815e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f3810b = new Toast(this.f3815e.f3812e);
                    d.f3810b.setView(this.f3815e.f3813f);
                    d.f3810b.setGravity(81, 0, this.f3815e.f3814g);
                    c.a.j.m.c.m(d.f3810b, R.style.toast_animation);
                    d.f3810b.show();
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
            this.f3812e = context;
            this.f3813f = viewGroup;
            this.f3814g = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f3811c.post(new RunnableC0180a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Context f3816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3817f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f3818g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ b.a f3819h;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ b f3820e;

            /* renamed from: c.a.j.l.a.d.d$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class View$OnClickListenerC0181a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ a f3821e;

                public View$OnClickListenerC0181a(a aVar) {
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
                    this.f3821e = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.a aVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.f3821e.f3820e.f3819h) == null) {
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
                this.f3820e = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f3810b = new Toast(this.f3820e.f3816e);
                    d.f3810b.setView(this.f3820e.f3817f);
                    d.f3810b.setGravity(81, 0, this.f3820e.f3818g);
                    c.a.j.m.c.m(d.f3810b, R.style.toast_animation);
                    this.f3820e.f3817f.setOnClickListener(new View$OnClickListenerC0181a(this));
                    d.f3810b.show();
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
            this.f3816e = context;
            this.f3817f = viewGroup;
            this.f3818g = i2;
            this.f3819h = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f3811c.post(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3822b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3823c;

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
            this.f3822b = i2;
            this.f3823c = i3;
        }

        @Override // c.a.j.l.a.d.c.e
        public void a(ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) {
                e eVar = new e(this.a);
                d.j(eVar);
                if (c.a.j.m.c.d()) {
                    eVar.n(2003);
                }
                eVar.f(viewGroup);
                eVar.e(81, 0, this.f3822b);
                eVar.d(this.f3823c);
                eVar.j(R.style.toast_animation);
                eVar.c();
            }
        }
    }

    /* renamed from: c.a.j.l.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0182d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        public C0182d(b.a aVar) {
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

        @Override // c.a.j.l.a.d.b.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1597321794, "Lc/a/j/l/a/d/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1597321794, "Lc/a/j/l/a/d/d;");
                return;
            }
        }
        f3811c = new Handler(Looper.getMainLooper());
    }

    public static void e() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            WeakReference<e> weakReference = a;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.i();
            }
            Toast toast = f3810b;
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, int i2, String str, CharSequence charSequence2, int i3, int i4, String str2, String str3, String str4, String str5, String str6, b.a aVar, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Integer.valueOf(i2), str, charSequence2, Integer.valueOf(i3), Integer.valueOf(i4), str2, str3, str4, str5, str6, aVar, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.sdk_toast_view_margin_bottom);
            if (cVar != null) {
                dimension = cVar.a();
            }
            if (c.a.j.m.c.p(context)) {
                ViewGroup a2 = c.a.j.l.a.d.c.a(context, charSequence, str2, str3);
                c.a.j.l.a.d.c.c(str, a2, new b(applicationContext, a2, dimension, aVar));
                return;
            }
            c.a.j.l.a.d.c.b(context, charSequence, i2, charSequence2, i3, str2, str, str3, str4, str5, str6, new c(applicationContext, dimension, i4), new C0182d(aVar));
        }
    }

    public static void g(Context context, CharSequence charSequence, int i2, String str, String str2, String str3, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, charSequence, Integer.valueOf(i2), str, str2, str3, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.sdk_toast_view_margin_bottom);
            if (cVar != null) {
                dimension = cVar.a();
            }
            ViewGroup a2 = c.a.j.l.a.d.c.a(context, charSequence, str, str3);
            c.a.j.l.a.d.c.c(str2, a2, new a(applicationContext, a2, dimension));
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
