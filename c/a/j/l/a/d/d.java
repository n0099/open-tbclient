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
    public static Toast f3272b;

    /* renamed from: c  reason: collision with root package name */
    public static Handler f3273c;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3274b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3275c;

        /* renamed from: c.a.j.l.a.d.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0186a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0186a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f3272b = new Toast(this.a.a);
                    d.f3272b.setView(this.a.f3274b);
                    d.f3272b.setGravity(81, 0, this.a.f3275c);
                    c.a.j.m.c.m(d.f3272b, R.style.obfuscated_res_0x7f10040f);
                    d.f3272b.show();
                }
            }
        }

        public a(Context context, ViewGroup viewGroup, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f3274b = viewGroup;
            this.f3275c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f3273c.post(new RunnableC0186a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3276b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3277c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a f3278d;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ b a;

            /* renamed from: c.a.j.l.a.d.d$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class View$OnClickListenerC0187a implements View.OnClickListener {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                public View$OnClickListenerC0187a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    b.a aVar;
                    Interceptable interceptable = $ic;
                    if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (aVar = this.a.a.f3278d) == null) {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && c.a.j.m.c.q()) {
                    Toast unused = d.f3272b = new Toast(this.a.a);
                    d.f3272b.setView(this.a.f3276b);
                    d.f3272b.setGravity(81, 0, this.a.f3277c);
                    c.a.j.m.c.m(d.f3272b, R.style.obfuscated_res_0x7f10040f);
                    this.a.f3276b.setOnClickListener(new View$OnClickListenerC0187a(this));
                    d.f3272b.show();
                }
            }
        }

        public b(Context context, ViewGroup viewGroup, int i, b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, viewGroup, Integer.valueOf(i), aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f3276b = viewGroup;
            this.f3277c = i;
            this.f3278d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.f3273c.post(new a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c implements c.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f3279b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f3280c;

        public c(Context context, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f3279b = i;
            this.f3280c = i2;
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
                eVar.e(81, 0, this.f3279b);
                eVar.d(this.f3280c);
                eVar.j(R.style.obfuscated_res_0x7f10040f);
                eVar.c();
            }
        }
    }

    /* renamed from: c.a.j.l.a.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0188d implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b.a a;

        public C0188d(b.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
        f3273c = new Handler(Looper.getMainLooper());
    }

    public static void e() {
        e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            WeakReference<e> weakReference = a;
            if (weakReference != null && (eVar = weakReference.get()) != null) {
                eVar.i();
            }
            Toast toast = f3272b;
            if (toast != null) {
                toast.cancel();
            }
        }
    }

    public static void f(Context context, CharSequence charSequence, int i, String str, CharSequence charSequence2, int i2, int i3, String str2, String str3, String str4, String str5, String str6, b.a aVar, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, charSequence, Integer.valueOf(i), str, charSequence2, Integer.valueOf(i2), Integer.valueOf(i3), str2, str3, str4, str5, str6, aVar, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705e8);
            if (cVar != null) {
                dimension = cVar.a();
            }
            if (c.a.j.m.c.p(context)) {
                ViewGroup a2 = c.a.j.l.a.d.c.a(context, charSequence, str2, str3);
                c.a.j.l.a.d.c.c(str, a2, new b(applicationContext, a2, dimension, aVar));
                return;
            }
            c.a.j.l.a.d.c.b(context, charSequence, i, charSequence2, i2, str2, str, str3, str4, str5, str6, new c(applicationContext, dimension, i3), new C0188d(aVar));
        }
    }

    public static void g(Context context, CharSequence charSequence, int i, String str, String str2, String str3, c.a.j.h.c.d.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, charSequence, Integer.valueOf(i), str, str2, str3, cVar}) == null) {
            Context applicationContext = context.getApplicationContext();
            int dimension = (int) context.getResources().getDimension(R.dimen.obfuscated_res_0x7f0705e8);
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
