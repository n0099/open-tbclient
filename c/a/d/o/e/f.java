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
    public int f3103b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.o.f.a f3104c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f3105d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3106e;

    /* renamed from: f  reason: collision with root package name */
    public b f3107f;

    /* renamed from: g  reason: collision with root package name */
    public int f3108g;

    /* renamed from: h  reason: collision with root package name */
    public View f3109h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3110i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f3111j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f3112e;

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
            this.f3112e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f3112e.f3107f) == null) {
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
        public int f3113e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f3114f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f3115g;

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
            this.f3115g = fVar;
            this.f3114f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f3115g;
                fVar.f3110i.removeCallbacks(fVar.f3111j);
                Scroller scroller = this.f3114f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f3114f.forceFinished(true);
                }
                View view = this.f3115g.f3109h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f3115g.f3104c != null) {
                    this.f3115g.f3104c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f3115g;
                Handler handler = fVar.f3110i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f3111j);
                }
                View view = this.f3115g.f3109h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f3115g.f3109h == null || this.f3114f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f3113e = 0;
            this.f3114f.startScroll(0, 0, 0, i2, i3);
            this.f3115g.f3109h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f3115g.f3109h == null || (scroller = this.f3114f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f3114f.timePassed() >= this.f3115g.f3108g) {
                computeScrollOffset = false;
            }
            int currY = this.f3114f.getCurrY();
            int i2 = currY - this.f3113e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f3115g.c(i2);
                    this.f3113e = currY;
                }
                if (!z) {
                    this.f3115g.f3109h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f3115g;
                fVar.f3110i.removeCallbacks(fVar.f3111j);
                f fVar2 = this.f3115g;
                fVar2.f3110i.post(fVar2.f3111j);
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
        this.f3106e = true;
        this.f3110i = new Handler();
        this.f3111j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f3103b = i3;
        if (abs < this.a) {
            this.f3106e = false;
        }
        this.f3107f = new b(this, context);
        this.f3108g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f3109h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f3103b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f3109h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f3109h.getPaddingRight(), this.f3109h.getPaddingBottom());
            c.a aVar = this.f3105d;
            if (aVar != null) {
                aVar.a(null, this.f3109h.getPaddingLeft(), this.f3109h.getPaddingRight(), this.f3109h.getPaddingTop() - this.f3103b, this.f3109h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.d.o.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f3104c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f3105d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f3106e && (bVar = this.f3107f) != null) {
            this.f3109h = view;
            bVar.d(Math.abs(this.f3103b), this.f3108g);
            this.f3110i.postDelayed(this.f3111j, this.f3108g);
        }
    }
}
