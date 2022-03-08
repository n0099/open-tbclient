package c.a.p0.a.s1.b.f;

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
import c.a.p0.a.s1.b.f.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Context f7445b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f7446c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f7447d;

    /* renamed from: e  reason: collision with root package name */
    public View f7448e;

    /* renamed from: f  reason: collision with root package name */
    public View f7449f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f7450g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f7451h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f7452i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f7453j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7454e;

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
            this.f7454e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f7454e.f7448e != null) {
                    if (this.f7454e.f7448e.getParent() != null) {
                        this.f7454e.f7446c.removeView(this.f7454e.f7448e);
                        if (this.f7454e.k != null) {
                            this.f7454e.k.onDismiss();
                            this.f7454e.k = null;
                        }
                    }
                    this.f7454e.f7448e = null;
                }
                if (this.f7454e.m != null) {
                    if (this.f7454e.m.getParent() != null) {
                        this.f7454e.f7446c.removeView(this.f7454e.m);
                    }
                    this.f7454e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7455e;

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
            this.f7455e = cVar;
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
                if (this.f7455e.l) {
                    if (this.f7455e.m != null && (this.f7455e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f7455e.m.getParent()).removeView(this.f7455e.m);
                    }
                    WindowManager.LayoutParams t = this.f7455e.t();
                    this.f7455e.n = new FrameLayout(this.f7455e.f7445b);
                    this.f7455e.n.setClickable(true);
                    this.f7455e.f7446c.addView(this.f7455e.n, t);
                    this.f7455e.m = this.f7455e.n;
                }
                if (this.f7455e.f7449f != null && (this.f7455e.f7449f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f7455e.f7449f.getParent()).removeView(this.f7455e.f7449f);
                }
                this.f7455e.f7446c.addView(this.f7455e.f7449f, this.f7455e.f7450g);
                this.f7455e.f7448e = this.f7455e.f7449f;
                this.f7455e.f7451h.postDelayed(this.f7455e.f7453j, this.f7455e.f7447d * 1000);
                boolean unused = this.f7455e.a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.s1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0463c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f7456e;

        public RunnableC0463c(c cVar) {
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
            this.f7456e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f7456e.f7448e != null) {
                    if (this.f7456e.f7448e.getParent() != null) {
                        this.f7456e.f7446c.removeViewImmediate(this.f7456e.f7448e);
                    }
                    if (this.f7456e.k != null) {
                        this.f7456e.k.onDismiss();
                        this.f7456e.k = null;
                    }
                    boolean unused = this.f7456e.a;
                    this.f7456e.f7448e = null;
                }
                if (this.f7456e.m != null) {
                    if (this.f7456e.m.getParent() != null) {
                        this.f7456e.f7446c.removeViewImmediate(this.f7456e.m);
                    }
                    boolean unused2 = this.f7456e.a;
                    this.f7456e.m = null;
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
        this.f7445b = context;
        this.f7446c = (WindowManager) context.getSystemService("window");
        this.f7451h = new Handler(Looper.getMainLooper());
        this.f7453j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f7450g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f7450g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f7447d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f7450g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f7452i;
            if (runnable != null) {
                this.f7451h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f7452i = bVar;
            this.f7451h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f7451h) == null) {
            return;
        }
        handler.post(new RunnableC0463c(this));
        this.f7451h.removeCallbacks(this.f7453j);
        boolean z = this.a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f7445b);
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
            View view = this.f7448e;
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
            this.f7447d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f7450g) == null) {
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
            this.f7449f = view;
            view.setClickable(true);
        }
    }
}
