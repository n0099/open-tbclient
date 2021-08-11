package c.a.n0.a.z1.b.f;

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
import c.a.n0.a.i;
import c.a.n0.a.z1.b.f.e;
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
    public boolean f9771a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9772b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f9773c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f9774d;

    /* renamed from: e  reason: collision with root package name */
    public View f9775e;

    /* renamed from: f  reason: collision with root package name */
    public View f9776f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f9777g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f9778h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f9779i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f9780j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9781e;

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
            this.f9781e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9781e.f9775e != null) {
                    if (this.f9781e.f9775e.getParent() != null) {
                        this.f9781e.f9773c.removeView(this.f9781e.f9775e);
                        if (this.f9781e.k != null) {
                            this.f9781e.k.onDismiss();
                            this.f9781e.k = null;
                        }
                    }
                    this.f9781e.f9775e = null;
                }
                if (this.f9781e.m != null) {
                    if (this.f9781e.m.getParent() != null) {
                        this.f9781e.f9773c.removeView(this.f9781e.m);
                    }
                    this.f9781e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9782e;

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
            this.f9782e = cVar;
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
                if (this.f9782e.l) {
                    if (this.f9782e.m != null && (this.f9782e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f9782e.m.getParent()).removeView(this.f9782e.m);
                    }
                    WindowManager.LayoutParams t = this.f9782e.t();
                    this.f9782e.n = new FrameLayout(this.f9782e.f9772b);
                    this.f9782e.n.setClickable(true);
                    this.f9782e.f9773c.addView(this.f9782e.n, t);
                    this.f9782e.m = this.f9782e.n;
                }
                if (this.f9782e.f9776f != null && (this.f9782e.f9776f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f9782e.f9776f.getParent()).removeView(this.f9782e.f9776f);
                }
                this.f9782e.f9773c.addView(this.f9782e.f9776f, this.f9782e.f9777g);
                this.f9782e.f9775e = this.f9782e.f9776f;
                this.f9782e.f9778h.postDelayed(this.f9782e.f9780j, this.f9782e.f9774d * 1000);
                boolean unused = this.f9782e.f9771a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0476c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9783e;

        public RunnableC0476c(c cVar) {
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
            this.f9783e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f9783e.f9775e != null) {
                    if (this.f9783e.f9775e.getParent() != null) {
                        this.f9783e.f9773c.removeViewImmediate(this.f9783e.f9775e);
                    }
                    if (this.f9783e.k != null) {
                        this.f9783e.k.onDismiss();
                        this.f9783e.k = null;
                    }
                    boolean unused = this.f9783e.f9771a;
                    this.f9783e.f9775e = null;
                }
                if (this.f9783e.m != null) {
                    if (this.f9783e.m.getParent() != null) {
                        this.f9783e.f9773c.removeViewImmediate(this.f9783e.m);
                    }
                    boolean unused2 = this.f9783e.f9771a;
                    this.f9783e.m = null;
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
        this.f9772b = context;
        this.f9773c = (WindowManager) context.getSystemService("window");
        this.f9778h = new Handler(Looper.getMainLooper());
        this.f9780j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9777g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f9777g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f9774d = 2;
        this.f9771a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f9777g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f9779i;
            if (runnable != null) {
                this.f9778h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f9779i = bVar;
            this.f9778h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f9778h) == null) {
            return;
        }
        handler.post(new RunnableC0476c(this));
        this.f9778h.removeCallbacks(this.f9780j);
        boolean z = this.f9771a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f9772b);
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
            View view = this.f9775e;
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
            this.f9774d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f9777g) == null) {
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
            this.f9776f = view;
            view.setClickable(true);
        }
    }
}
