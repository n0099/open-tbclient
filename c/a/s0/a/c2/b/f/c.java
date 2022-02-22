package c.a.s0.a.c2.b.f;

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
import c.a.s0.a.c2.b.f.e;
import c.a.s0.a.i;
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
    public Context f5712b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f5713c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f5714d;

    /* renamed from: e  reason: collision with root package name */
    public View f5715e;

    /* renamed from: f  reason: collision with root package name */
    public View f5716f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f5717g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f5718h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f5719i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f5720j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5721e;

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
            this.f5721e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5721e.f5715e != null) {
                    if (this.f5721e.f5715e.getParent() != null) {
                        this.f5721e.f5713c.removeView(this.f5721e.f5715e);
                        if (this.f5721e.k != null) {
                            this.f5721e.k.onDismiss();
                            this.f5721e.k = null;
                        }
                    }
                    this.f5721e.f5715e = null;
                }
                if (this.f5721e.m != null) {
                    if (this.f5721e.m.getParent() != null) {
                        this.f5721e.f5713c.removeView(this.f5721e.m);
                    }
                    this.f5721e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5722e;

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
            this.f5722e = cVar;
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
                if (this.f5722e.l) {
                    if (this.f5722e.m != null && (this.f5722e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f5722e.m.getParent()).removeView(this.f5722e.m);
                    }
                    WindowManager.LayoutParams t = this.f5722e.t();
                    this.f5722e.n = new FrameLayout(this.f5722e.f5712b);
                    this.f5722e.n.setClickable(true);
                    this.f5722e.f5713c.addView(this.f5722e.n, t);
                    this.f5722e.m = this.f5722e.n;
                }
                if (this.f5722e.f5716f != null && (this.f5722e.f5716f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f5722e.f5716f.getParent()).removeView(this.f5722e.f5716f);
                }
                this.f5722e.f5713c.addView(this.f5722e.f5716f, this.f5722e.f5717g);
                this.f5722e.f5715e = this.f5722e.f5716f;
                this.f5722e.f5718h.postDelayed(this.f5722e.f5720j, this.f5722e.f5714d * 1000);
                boolean unused = this.f5722e.a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.s0.a.c2.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0309c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5723e;

        public RunnableC0309c(c cVar) {
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
            this.f5723e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f5723e.f5715e != null) {
                    if (this.f5723e.f5715e.getParent() != null) {
                        this.f5723e.f5713c.removeViewImmediate(this.f5723e.f5715e);
                    }
                    if (this.f5723e.k != null) {
                        this.f5723e.k.onDismiss();
                        this.f5723e.k = null;
                    }
                    boolean unused = this.f5723e.a;
                    this.f5723e.f5715e = null;
                }
                if (this.f5723e.m != null) {
                    if (this.f5723e.m.getParent() != null) {
                        this.f5723e.f5713c.removeViewImmediate(this.f5723e.m);
                    }
                    boolean unused2 = this.f5723e.a;
                    this.f5723e.m = null;
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
        this.f5712b = context;
        this.f5713c = (WindowManager) context.getSystemService("window");
        this.f5718h = new Handler(Looper.getMainLooper());
        this.f5720j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f5717g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f5717g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f5714d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f5717g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f5719i;
            if (runnable != null) {
                this.f5718h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f5719i = bVar;
            this.f5718h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f5718h) == null) {
            return;
        }
        handler.post(new RunnableC0309c(this));
        this.f5718h.removeCallbacks(this.f5720j);
        boolean z = this.a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f5712b);
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
            View view = this.f5715e;
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
            this.f5714d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f5717g) == null) {
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
            this.f5716f = view;
            view.setClickable(true);
        }
    }
}
