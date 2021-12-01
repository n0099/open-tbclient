package c.a.p0.a.c2.b.f;

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
import c.a.p0.a.c2.b.f.e;
import c.a.p0.a.i;
import com.baidu.android.imsdk.internal.Constants;
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
    public Context f4546b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f4547c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f4548d;

    /* renamed from: e  reason: collision with root package name */
    public View f4549e;

    /* renamed from: f  reason: collision with root package name */
    public View f4550f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f4551g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f4552h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4553i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f4554j;

    /* renamed from: k  reason: collision with root package name */
    public e.b f4555k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4556e;

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
            this.f4556e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4556e.f4549e != null) {
                    if (this.f4556e.f4549e.getParent() != null) {
                        this.f4556e.f4547c.removeView(this.f4556e.f4549e);
                        if (this.f4556e.f4555k != null) {
                            this.f4556e.f4555k.onDismiss();
                            this.f4556e.f4555k = null;
                        }
                    }
                    this.f4556e.f4549e = null;
                }
                if (this.f4556e.m != null) {
                    if (this.f4556e.m.getParent() != null) {
                        this.f4556e.f4547c.removeView(this.f4556e.m);
                    }
                    this.f4556e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4557e;

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
            this.f4557e = cVar;
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
                if (this.f4557e.l) {
                    if (this.f4557e.m != null && (this.f4557e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f4557e.m.getParent()).removeView(this.f4557e.m);
                    }
                    WindowManager.LayoutParams t = this.f4557e.t();
                    this.f4557e.n = new FrameLayout(this.f4557e.f4546b);
                    this.f4557e.n.setClickable(true);
                    this.f4557e.f4547c.addView(this.f4557e.n, t);
                    this.f4557e.m = this.f4557e.n;
                }
                if (this.f4557e.f4550f != null && (this.f4557e.f4550f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f4557e.f4550f.getParent()).removeView(this.f4557e.f4550f);
                }
                this.f4557e.f4547c.addView(this.f4557e.f4550f, this.f4557e.f4551g);
                this.f4557e.f4549e = this.f4557e.f4550f;
                this.f4557e.f4552h.postDelayed(this.f4557e.f4554j, this.f4557e.f4548d * 1000);
                boolean unused = this.f4557e.a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.p0.a.c2.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0196c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4558e;

        public RunnableC0196c(c cVar) {
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
            this.f4558e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f4558e.f4549e != null) {
                    if (this.f4558e.f4549e.getParent() != null) {
                        this.f4558e.f4547c.removeViewImmediate(this.f4558e.f4549e);
                    }
                    if (this.f4558e.f4555k != null) {
                        this.f4558e.f4555k.onDismiss();
                        this.f4558e.f4555k = null;
                    }
                    boolean unused = this.f4558e.a;
                    this.f4558e.f4549e = null;
                }
                if (this.f4558e.m != null) {
                    if (this.f4558e.m.getParent() != null) {
                        this.f4558e.f4547c.removeViewImmediate(this.f4558e.m);
                    }
                    boolean unused2 = this.f4558e.a;
                    this.f4558e.m = null;
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
        this.f4546b = context;
        this.f4547c = (WindowManager) context.getSystemService("window");
        this.f4552h = new Handler(Looper.getMainLooper());
        this.f4554j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4551g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f4551g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f4548d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f4551g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f4553i;
            if (runnable != null) {
                this.f4552h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f4553i = bVar;
            this.f4552h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f4552h) == null) {
            return;
        }
        handler.post(new RunnableC0196c(this));
        this.f4552h.removeCallbacks(this.f4554j);
        boolean z = this.a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f4546b);
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
            View view = this.f4549e;
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
            this.f4548d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f4551g) == null) {
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
            this.f4555k = bVar;
        }
    }

    public void z(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f4550f = view;
            view.setClickable(true);
        }
    }
}
