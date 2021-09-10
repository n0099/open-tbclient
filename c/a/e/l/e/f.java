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
    public int f2988a;

    /* renamed from: b  reason: collision with root package name */
    public int f2989b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.e.l.f.a f2990c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f2991d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2992e;

    /* renamed from: f  reason: collision with root package name */
    public b f2993f;

    /* renamed from: g  reason: collision with root package name */
    public int f2994g;

    /* renamed from: h  reason: collision with root package name */
    public View f2995h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f2996i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f2997j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f2998e;

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
            this.f2998e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f2998e.f2993f) == null) {
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
        public int f2999e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f3000f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f3001g;

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
            this.f3001g = fVar;
            this.f3000f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f3001g;
                fVar.f2996i.removeCallbacks(fVar.f2997j);
                Scroller scroller = this.f3000f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f3000f.forceFinished(true);
                }
                View view = this.f3001g.f2995h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f3001g.f2990c != null) {
                    this.f3001g.f2990c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f3001g;
                Handler handler = fVar.f2996i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f2997j);
                }
                View view = this.f3001g.f2995h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f3001g.f2995h == null || this.f3000f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f2999e = 0;
            this.f3000f.startScroll(0, 0, 0, i2, i3);
            this.f3001g.f2995h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f3001g.f2995h == null || (scroller = this.f3000f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f3000f.timePassed() >= this.f3001g.f2994g) {
                computeScrollOffset = false;
            }
            int currY = this.f3000f.getCurrY();
            int i2 = currY - this.f2999e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f3001g.c(i2);
                    this.f2999e = currY;
                }
                if (!z) {
                    this.f3001g.f2995h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f3001g;
                fVar.f2996i.removeCallbacks(fVar.f2997j);
                f fVar2 = this.f3001g;
                fVar2.f2996i.post(fVar2.f2997j);
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
        this.f2988a = 1;
        this.f2992e = true;
        this.f2996i = new Handler();
        this.f2997j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f2989b = i3;
        if (abs < this.f2988a) {
            this.f2992e = false;
        }
        this.f2993f = new b(this, context);
        this.f2994g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f2995h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f2989b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f2995h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f2995h.getPaddingRight(), this.f2995h.getPaddingBottom());
            c.a aVar = this.f2991d;
            if (aVar != null) {
                aVar.a(null, this.f2995h.getPaddingLeft(), this.f2995h.getPaddingRight(), this.f2995h.getPaddingTop() - this.f2989b, this.f2995h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.e.l.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f2990c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f2991d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f2992e && (bVar = this.f2993f) != null) {
            this.f2995h = view;
            bVar.d(Math.abs(this.f2989b), this.f2994g);
            this.f2996i.postDelayed(this.f2997j, this.f2994g);
        }
    }
}
