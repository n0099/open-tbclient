package b.a.e.m.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import b.a.e.m.e.c;
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
    public int f2449a;

    /* renamed from: b  reason: collision with root package name */
    public int f2450b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.e.m.f.a f2451c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2452d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2453e;

    /* renamed from: f  reason: collision with root package name */
    public b f2454f;

    /* renamed from: g  reason: collision with root package name */
    public int f2455g;

    /* renamed from: h  reason: collision with root package name */
    public View f2456h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2457i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2458e;

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
            this.f2458e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f2458e.f2454f) == null) {
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
        public int f2459e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f2460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f2461g;

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
            this.f2461g = fVar;
            this.f2460f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f2461g;
                fVar.f2457i.removeCallbacks(fVar.j);
                Scroller scroller = this.f2460f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f2460f.forceFinished(true);
                }
                View view = this.f2461g.f2456h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f2461g.f2451c != null) {
                    this.f2461g.f2451c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f2461g;
                Handler handler = fVar.f2457i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f2461g.f2456h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f2461g.f2456h == null || this.f2460f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f2459e = 0;
            this.f2460f.startScroll(0, 0, 0, i2, i3);
            this.f2461g.f2456h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2461g.f2456h == null || (scroller = this.f2460f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f2460f.timePassed() >= this.f2461g.f2455g) {
                computeScrollOffset = false;
            }
            int currY = this.f2460f.getCurrY();
            int i2 = currY - this.f2459e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f2461g.c(i2);
                    this.f2459e = currY;
                }
                if (!z) {
                    this.f2461g.f2456h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f2461g;
                fVar.f2457i.removeCallbacks(fVar.j);
                f fVar2 = this.f2461g;
                fVar2.f2457i.post(fVar2.j);
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
        this.f2449a = 1;
        this.f2453e = true;
        this.f2457i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2450b = i3;
        if (abs < this.f2449a) {
            this.f2453e = false;
        }
        this.f2454f = new b(this, context);
        this.f2455g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f2456h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2450b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2456h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2456h.getPaddingRight(), this.f2456h.getPaddingBottom());
            c.a aVar = this.f2452d;
            if (aVar != null) {
                aVar.a(null, this.f2456h.getPaddingLeft(), this.f2456h.getPaddingRight(), this.f2456h.getPaddingTop() - this.f2450b, this.f2456h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(b.a.e.m.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2451c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2452d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2453e && (bVar = this.f2454f) != null) {
            this.f2456h = view;
            bVar.d(Math.abs(this.f2450b), this.f2455g);
            this.f2457i.postDelayed(this.j, this.f2455g);
        }
    }
}
