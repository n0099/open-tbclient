package c.a.d.m.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import c.a.d.m.e.c;
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
    public int f2900b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.m.f.a f2901c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2902d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2903e;

    /* renamed from: f  reason: collision with root package name */
    public b f2904f;

    /* renamed from: g  reason: collision with root package name */
    public int f2905g;

    /* renamed from: h  reason: collision with root package name */
    public View f2906h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2907i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f2908j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2909e;

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
            this.f2909e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f2909e.f2904f) == null) {
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
        public int f2910e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f2911f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f2912g;

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
            this.f2912g = fVar;
            this.f2911f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f2912g;
                fVar.f2907i.removeCallbacks(fVar.f2908j);
                Scroller scroller = this.f2911f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f2911f.forceFinished(true);
                }
                View view = this.f2912g.f2906h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f2912g.f2901c != null) {
                    this.f2912g.f2901c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f2912g;
                Handler handler = fVar.f2907i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f2908j);
                }
                View view = this.f2912g.f2906h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f2912g.f2906h == null || this.f2911f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f2910e = 0;
            this.f2911f.startScroll(0, 0, 0, i2, i3);
            this.f2912g.f2906h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f2912g.f2906h == null || (scroller = this.f2911f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f2911f.timePassed() >= this.f2912g.f2905g) {
                computeScrollOffset = false;
            }
            int currY = this.f2911f.getCurrY();
            int i2 = currY - this.f2910e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f2912g.c(i2);
                    this.f2910e = currY;
                }
                if (!z) {
                    this.f2912g.f2906h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f2912g;
                fVar.f2907i.removeCallbacks(fVar.f2908j);
                f fVar2 = this.f2912g;
                fVar2.f2907i.post(fVar2.f2908j);
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
        this.f2903e = true;
        this.f2907i = new Handler();
        this.f2908j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2900b = i3;
        if (abs < this.a) {
            this.f2903e = false;
        }
        this.f2904f = new b(this, context);
        this.f2905g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f2906h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2900b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2906h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2906h.getPaddingRight(), this.f2906h.getPaddingBottom());
            c.a aVar = this.f2902d;
            if (aVar != null) {
                aVar.a(null, this.f2906h.getPaddingLeft(), this.f2906h.getPaddingRight(), this.f2906h.getPaddingTop() - this.f2900b, this.f2906h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.d.m.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2901c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2902d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2903e && (bVar = this.f2904f) != null) {
            this.f2906h = view;
            bVar.d(Math.abs(this.f2900b), this.f2905g);
            this.f2907i.postDelayed(this.f2908j, this.f2905g);
        }
    }
}
