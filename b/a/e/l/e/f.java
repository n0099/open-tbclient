package b.a.e.l.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import b.a.e.l.e.c;
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

    /* renamed from: a  reason: collision with root package name */
    public int f2447a;

    /* renamed from: b  reason: collision with root package name */
    public int f2448b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.l.f.a f2449c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2450d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2451e;

    /* renamed from: f  reason: collision with root package name */
    public b f2452f;

    /* renamed from: g  reason: collision with root package name */
    public int f2453g;

    /* renamed from: h  reason: collision with root package name */
    public View f2454h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2455i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2456e;

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
            this.f2456e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f2456e.f2452f) == null) {
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
        public int f2457e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f2458f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f2459g;

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
            this.f2459g = fVar;
            this.f2458f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f2459g;
                fVar.f2455i.removeCallbacks(fVar.j);
                Scroller scroller = this.f2458f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f2458f.forceFinished(true);
                }
                View view = this.f2459g.f2454h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f2459g.f2449c != null) {
                    this.f2459g.f2449c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f2459g;
                Handler handler = fVar.f2455i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f2459g.f2454h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f2459g.f2454h == null || this.f2458f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f2457e = 0;
            this.f2458f.startScroll(0, 0, 0, i2, i3);
            this.f2459g.f2454h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2459g.f2454h == null || (scroller = this.f2458f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f2458f.timePassed() >= this.f2459g.f2453g) {
                computeScrollOffset = false;
            }
            int currY = this.f2458f.getCurrY();
            int i2 = currY - this.f2457e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f2459g.c(i2);
                    this.f2457e = currY;
                }
                if (!z) {
                    this.f2459g.f2454h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f2459g;
                fVar.f2455i.removeCallbacks(fVar.j);
                f fVar2 = this.f2459g;
                fVar2.f2455i.post(fVar2.j);
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
        this.f2447a = 1;
        this.f2451e = true;
        this.f2455i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2448b = i3;
        if (abs < this.f2447a) {
            this.f2451e = false;
        }
        this.f2452f = new b(this, context);
        this.f2453g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f2454h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2448b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2454h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2454h.getPaddingRight(), this.f2454h.getPaddingBottom());
            c.a aVar = this.f2450d;
            if (aVar != null) {
                aVar.a(null, this.f2454h.getPaddingLeft(), this.f2454h.getPaddingRight(), this.f2454h.getPaddingTop() - this.f2448b, this.f2454h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(b.a.e.l.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2449c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2450d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2451e && (bVar = this.f2452f) != null) {
            this.f2454h = view;
            bVar.d(Math.abs(this.f2448b), this.f2453g);
            this.f2455i.postDelayed(this.j, this.f2453g);
        }
    }
}
