package c.a.e.l.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import c.a.e.l.e.c;
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
    public int f2997a;

    /* renamed from: b  reason: collision with root package name */
    public int f2998b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.l.f.a f2999c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f3000d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3001e;

    /* renamed from: f  reason: collision with root package name */
    public b f3002f;

    /* renamed from: g  reason: collision with root package name */
    public int f3003g;

    /* renamed from: h  reason: collision with root package name */
    public View f3004h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3005i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f3006j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f3007e;

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
            this.f3007e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f3007e.f3002f) == null) {
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
        public int f3008e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f3009f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f3010g;

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
            this.f3010g = fVar;
            this.f3009f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f3010g;
                fVar.f3005i.removeCallbacks(fVar.f3006j);
                Scroller scroller = this.f3009f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f3009f.forceFinished(true);
                }
                View view = this.f3010g.f3004h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f3010g.f2999c != null) {
                    this.f3010g.f2999c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f3010g;
                Handler handler = fVar.f3005i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f3006j);
                }
                View view = this.f3010g.f3004h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f3010g.f3004h == null || this.f3009f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f3008e = 0;
            this.f3009f.startScroll(0, 0, 0, i2, i3);
            this.f3010g.f3004h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f3010g.f3004h == null || (scroller = this.f3009f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f3009f.timePassed() >= this.f3010g.f3003g) {
                computeScrollOffset = false;
            }
            int currY = this.f3009f.getCurrY();
            int i2 = currY - this.f3008e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f3010g.c(i2);
                    this.f3008e = currY;
                }
                if (!z) {
                    this.f3010g.f3004h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f3010g;
                fVar.f3005i.removeCallbacks(fVar.f3006j);
                f fVar2 = this.f3010g;
                fVar2.f3005i.post(fVar2.f3006j);
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
        this.f2997a = 1;
        this.f3001e = true;
        this.f3005i = new Handler();
        this.f3006j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2998b = i3;
        if (abs < this.f2997a) {
            this.f3001e = false;
        }
        this.f3002f = new b(this, context);
        this.f3003g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f3004h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2998b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f3004h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f3004h.getPaddingRight(), this.f3004h.getPaddingBottom());
            c.a aVar = this.f3000d;
            if (aVar != null) {
                aVar.a(null, this.f3004h.getPaddingLeft(), this.f3004h.getPaddingRight(), this.f3004h.getPaddingTop() - this.f2998b, this.f3004h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.e.l.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2999c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f3000d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f3001e && (bVar = this.f3002f) != null) {
            this.f3004h = view;
            bVar.d(Math.abs(this.f2998b), this.f3003g);
            this.f3005i.postDelayed(this.f3006j, this.f3003g);
        }
    }
}
