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
    public int f2595b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.o.f.a f2596c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2597d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2598e;

    /* renamed from: f  reason: collision with root package name */
    public b f2599f;

    /* renamed from: g  reason: collision with root package name */
    public int f2600g;

    /* renamed from: h  reason: collision with root package name */
    public View f2601h;
    public Handler i;
    public Runnable j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f a;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.a.f2599f) == null) {
                return;
            }
            bVar.b();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public Scroller f2602b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ f f2603c;

        public b(f fVar, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2603c = fVar;
            this.f2602b = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f2603c;
                fVar.i.removeCallbacks(fVar.j);
                Scroller scroller = this.f2602b;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f2602b.forceFinished(true);
                }
                View view = this.f2603c.f2601h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f2603c.f2596c != null) {
                    this.f2603c.f2596c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f2603c;
                Handler handler = fVar.i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.j);
                }
                View view = this.f2603c.f2601h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) || this.f2603c.f2601h == null || this.f2602b == null) {
                return;
            }
            if (i == 0) {
                i--;
            }
            c();
            this.a = 0;
            this.f2602b.startScroll(0, 0, 0, i, i2);
            this.f2603c.f2601h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2603c.f2601h == null || (scroller = this.f2602b) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f2602b.timePassed() >= this.f2603c.f2600g) {
                computeScrollOffset = false;
            }
            int currY = this.f2602b.getCurrY();
            int i = currY - this.a;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i != 0) {
                    z = !this.f2603c.c(i);
                    this.a = currY;
                }
                if (!z) {
                    this.f2603c.f2601h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f2603c;
                fVar.i.removeCallbacks(fVar.j);
                f fVar2 = this.f2603c;
                fVar2.i.post(fVar2.j);
            }
        }
    }

    public f(Context context, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.f2598e = true;
        this.i = new Handler();
        this.j = new a(this);
        int abs = Math.abs(i - i2);
        this.f2595b = i2;
        if (abs < this.a) {
            this.f2598e = false;
        }
        this.f2599f = new b(this, context);
        this.f2600g = i3;
    }

    public final boolean c(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int paddingTop = this.f2601h.getPaddingTop() - Math.abs(i);
            int i2 = this.f2595b;
            if (paddingTop <= i2) {
                paddingTop = i2;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2601h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2601h.getPaddingRight(), this.f2601h.getPaddingBottom());
            c.a aVar = this.f2597d;
            if (aVar != null) {
                aVar.a(null, this.f2601h.getPaddingLeft(), this.f2601h.getPaddingRight(), this.f2601h.getPaddingTop() - this.f2595b, this.f2601h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.d.o.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2596c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2597d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2598e && (bVar = this.f2599f) != null) {
            this.f2601h = view;
            bVar.d(Math.abs(this.f2595b), this.f2600g);
            this.i.postDelayed(this.j, this.f2600g);
        }
    }
}
