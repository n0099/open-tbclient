package c.a.p0.a.z1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.i;
import c.a.p0.a.z1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f10045a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10046b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f10047c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f10048d;

    /* renamed from: e  reason: collision with root package name */
    public View f10049e;

    /* renamed from: f  reason: collision with root package name */
    public View f10050f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f10051g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f10052h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f10053i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f10054j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10055e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10055e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10055e.f10049e != null) {
                    if (this.f10055e.f10049e.getParent() != null) {
                        this.f10055e.f10047c.removeView(this.f10055e.f10049e);
                        if (this.f10055e.k != null) {
                            this.f10055e.k.onDismiss();
                            this.f10055e.k = null;
                        }
                    }
                    this.f10055e.f10049e = null;
                }
                if (this.f10055e.m != null) {
                    if (this.f10055e.m.getParent() != null) {
                        this.f10055e.f10047c.removeView(this.f10055e.m);
                    }
                    this.f10055e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10056e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10056e = cVar;
        }

        /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, INVOKE]}, finally: {[IGET, INVOKE, RETURN, IF] complete} */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f10056e.l) {
                    if (this.f10056e.m != null && (this.f10056e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f10056e.m.getParent()).removeView(this.f10056e.m);
                    }
                    WindowManager.LayoutParams t = this.f10056e.t();
                    this.f10056e.n = new FrameLayout(this.f10056e.f10046b);
                    this.f10056e.n.setClickable(true);
                    this.f10056e.f10047c.addView(this.f10056e.n, t);
                    this.f10056e.m = this.f10056e.n;
                }
                if (this.f10056e.f10050f != null && (this.f10056e.f10050f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f10056e.f10050f.getParent()).removeView(this.f10056e.f10050f);
                }
                this.f10056e.f10047c.addView(this.f10056e.f10050f, this.f10056e.f10051g);
                this.f10056e.f10049e = this.f10056e.f10050f;
                this.f10056e.f10052h.postDelayed(this.f10056e.f10054j, this.f10056e.f10048d * 1000);
                boolean unused = this.f10056e.f10045a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0486c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10057e;

        public RunnableC0486c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10057e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f10057e.f10049e != null) {
                    if (this.f10057e.f10049e.getParent() != null) {
                        this.f10057e.f10047c.removeViewImmediate(this.f10057e.f10049e);
                    }
                    if (this.f10057e.k != null) {
                        this.f10057e.k.onDismiss();
                        this.f10057e.k = null;
                    }
                    boolean unused = this.f10057e.f10045a;
                    this.f10057e.f10049e = null;
                }
                if (this.f10057e.m != null) {
                    if (this.f10057e.m.getParent() != null) {
                        this.f10057e.f10047c.removeViewImmediate(this.f10057e.m);
                    }
                    boolean unused2 = this.f10057e.f10045a;
                    this.f10057e.m = null;
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f10046b = context;
        this.f10047c = (WindowManager) context.getSystemService("window");
        this.f10052h = new Handler(Looper.getMainLooper());
        this.f10054j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f10051g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f10051g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f10048d = 2;
        this.f10045a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f10051g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f10053i;
            if (runnable != null) {
                this.f10052h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f10053i = bVar;
            this.f10052h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f10052h) == null) {
            return;
        }
        handler.post(new RunnableC0486c(this));
        this.f10052h.removeCallbacks(this.f10054j);
        boolean z = this.f10045a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f10046b);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            View view = this.f10049e;
            return (view == null || view.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f10048d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f10051g) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.l = z;
        }
    }

    public void y(e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void z(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f10050f = view;
            view.setClickable(true);
        }
    }
}
