package c.a.d.n.e;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.Scroller;
import c.a.d.n.e.c;
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
    public int f3328b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.d.n.f.a f3329c;

    /* renamed from: d  reason: collision with root package name */
    public c.a f3330d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f3331e;

    /* renamed from: f  reason: collision with root package name */
    public b f3332f;

    /* renamed from: g  reason: collision with root package name */
    public int f3333g;

    /* renamed from: h  reason: collision with root package name */
    public View f3334h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f3335i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f3336j;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f3337e;

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
            this.f3337e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bVar = this.f3337e.f3332f) == null) {
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
        public int f3338e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f3339f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ f f3340g;

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
            this.f3340g = fVar;
            this.f3339f = new Scroller(context);
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f fVar = this.f3340g;
                fVar.f3335i.removeCallbacks(fVar.f3336j);
                Scroller scroller = this.f3339f;
                if (scroller != null) {
                    scroller.abortAnimation();
                    this.f3339f.forceFinished(true);
                }
                View view = this.f3340g.f3334h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
                if (this.f3340g.f3329c != null) {
                    this.f3340g.f3329c.onOver();
                }
            }
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                f fVar = this.f3340g;
                Handler handler = fVar.f3335i;
                if (handler != null) {
                    handler.removeCallbacks(fVar.f3336j);
                }
                View view = this.f3340g.f3334h;
                if (view != null) {
                    view.removeCallbacks(this);
                }
            }
        }

        public void d(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) || this.f3340g.f3334h == null || this.f3339f == null) {
                return;
            }
            if (i2 == 0) {
                i2--;
            }
            c();
            this.f3338e = 0;
            this.f3339f.startScroll(0, 0, 0, i2, i3);
            this.f3340g.f3334h.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            Scroller scroller;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.f3340g.f3334h == null || (scroller = this.f3339f) == null) {
                return;
            }
            boolean computeScrollOffset = scroller.computeScrollOffset();
            boolean z = false;
            if (this.f3339f.timePassed() >= this.f3340g.f3333g) {
                computeScrollOffset = false;
            }
            int currY = this.f3339f.getCurrY();
            int i2 = currY - this.f3338e;
            boolean z2 = true;
            if (computeScrollOffset) {
                if (i2 != 0) {
                    z = !this.f3340g.c(i2);
                    this.f3338e = currY;
                }
                if (!z) {
                    this.f3340g.f3334h.post(this);
                }
                z2 = z;
            }
            if (z2) {
                f fVar = this.f3340g;
                fVar.f3335i.removeCallbacks(fVar.f3336j);
                f fVar2 = this.f3340g;
                fVar2.f3335i.post(fVar2.f3336j);
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
        this.f3331e = true;
        this.f3335i = new Handler();
        this.f3336j = new a(this);
        int abs = Math.abs(i2 - i3);
        this.f3328b = i3;
        if (abs < this.a) {
            this.f3331e = false;
        }
        this.f3332f = new b(this, context);
        this.f3333g = i4;
    }

    public final boolean c(int i2) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
            int paddingTop = this.f3334h.getPaddingTop() - Math.abs(i2);
            int i3 = this.f3328b;
            if (paddingTop <= i3) {
                paddingTop = i3;
                z = false;
            } else {
                z = true;
            }
            View view = this.f3334h;
            view.setPadding(view.getPaddingLeft(), paddingTop, this.f3334h.getPaddingRight(), this.f3334h.getPaddingBottom());
            c.a aVar = this.f3330d;
            if (aVar != null) {
                aVar.a(null, this.f3334h.getPaddingLeft(), this.f3334h.getPaddingRight(), this.f3334h.getPaddingTop() - this.f3328b, this.f3334h.getPaddingBottom());
            }
            return z;
        }
        return invokeI.booleanValue;
    }

    public void d(c.a.d.n.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.f3329c = aVar;
        }
    }

    public void e(c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            this.f3330d = aVar;
        }
    }

    public void f(View view) {
        b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, view) == null) && this.f3331e && (bVar = this.f3332f) != null) {
            this.f3334h = view;
            bVar.d(Math.abs(this.f3328b), this.f3333g);
            this.f3335i.postDelayed(this.f3336j, this.f3333g);
        }
    }
}
