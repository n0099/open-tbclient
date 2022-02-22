package c.a.d.o.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import c.a.d.o.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f2474b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.o.f.a f2475c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2476d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2477e;

    /* renamed from: f  reason: collision with root package name */
    public b f2478f;

    /* renamed from: g  reason: collision with root package name */
    public int f2479g;

    /* renamed from: h  reason: collision with root package name */
    public View f2480h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2481i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f2482j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2483e;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2483e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f2483e.f2478f) == null) {
                return;
            }
            bVar.b();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public int f2484e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f2485f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f2486g;

        public b(f fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2486g = fVar;
            this.f2485f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f2486g;
                fVar.f2481i.removeCallbacks(fVar.f2482j);
                Scroller scroller = this.f2485f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f2485f.forceFinished(true);
                }
                View view = this.f2486g.f2480h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f2486g.f2475c != null) {
                    this.f2486g.f2475c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f2486g;
                Handler handler = fVar.f2481i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f2482j);
                }
                View view = this.f2486g.f2480h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f2486g.f2480h == null || this.f2485f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f2484e = 0;
            this.f2485f.startScroll(0, 0, 0, i2, i3);
            this.f2486g.f2480h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2486g.f2480h == null || (scroller = this.f2485f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f2485f.timePassed() >= this.f2486g.f2479g) {
                computeScrollOffset = false;
            }
            int currY = this.f2485f.getCurrY();
            int i2 = currY - this.f2484e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f2486g.c(i2);
                    this.f2484e = currY;
                }
                if (!z) {
                    this.f2486g.f2480h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f2486g;
                fVar.f2481i.removeCallbacks(fVar.f2482j);
                f fVar2 = this.f2486g;
                fVar2.f2481i.post(fVar2.f2482j);
            }
        }
    }

    public f(Context context, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f2477e = true;
        this.f2481i = new Handler();
        this.f2482j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2474b = i3;
        if (abs < this.a) {
            this.f2477e = false;
        }
        this.f2478f = new b(this, context);
        this.f2479g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f2480h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2474b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2480h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2480h.getPaddingRight(), this.f2480h.getPaddingBottom());
            c.a aVar = this.f2476d;
            if (aVar != null) {
                aVar.a(null, this.f2480h.getPaddingLeft(), this.f2480h.getPaddingRight(), this.f2480h.getPaddingTop() - this.f2474b, this.f2480h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.d.o.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2475c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2476d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2477e && (bVar = this.f2478f) != null) {
            this.f2480h = view;
            bVar.d(Math.abs(this.f2474b), this.f2479g);
            this.f2481i.postDelayed(this.f2482j, this.f2479g);
        }
    }
}
