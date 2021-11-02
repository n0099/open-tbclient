package b.a.p0.a.z1.b.f;

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
import b.a.p0.a.i;
import b.a.p0.a.z1.b.f.e;
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
    public boolean f9280a;

    /* renamed from: b  reason: collision with root package name */
    public Context f9281b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f9282c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f9283d;

    /* renamed from: e  reason: collision with root package name */
    public View f9284e;

    /* renamed from: f  reason: collision with root package name */
    public View f9285f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f9286g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f9287h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f9288i;
    public Runnable j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9289e;

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
            this.f9289e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f9289e.f9284e != null) {
                    if (this.f9289e.f9284e.getParent() != null) {
                        this.f9289e.f9282c.removeView(this.f9289e.f9284e);
                        if (this.f9289e.k != null) {
                            this.f9289e.k.onDismiss();
                            this.f9289e.k = null;
                        }
                    }
                    this.f9289e.f9284e = null;
                }
                if (this.f9289e.m != null) {
                    if (this.f9289e.m.getParent() != null) {
                        this.f9289e.f9282c.removeView(this.f9289e.m);
                    }
                    this.f9289e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9290e;

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
            this.f9290e = cVar;
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
                if (this.f9290e.l) {
                    if (this.f9290e.m != null && (this.f9290e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f9290e.m.getParent()).removeView(this.f9290e.m);
                    }
                    WindowManager.LayoutParams t = this.f9290e.t();
                    this.f9290e.n = new FrameLayout(this.f9290e.f9281b);
                    this.f9290e.n.setClickable(true);
                    this.f9290e.f9282c.addView(this.f9290e.n, t);
                    this.f9290e.m = this.f9290e.n;
                }
                if (this.f9290e.f9285f != null && (this.f9290e.f9285f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f9290e.f9285f.getParent()).removeView(this.f9290e.f9285f);
                }
                this.f9290e.f9282c.addView(this.f9290e.f9285f, this.f9290e.f9286g);
                this.f9290e.f9284e = this.f9290e.f9285f;
                this.f9290e.f9287h.postDelayed(this.f9290e.j, this.f9290e.f9283d * 1000);
                boolean unused = this.f9290e.f9280a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.z1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0481c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f9291e;

        public RunnableC0481c(c cVar) {
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
            this.f9291e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f9291e.f9284e != null) {
                    if (this.f9291e.f9284e.getParent() != null) {
                        this.f9291e.f9282c.removeViewImmediate(this.f9291e.f9284e);
                    }
                    if (this.f9291e.k != null) {
                        this.f9291e.k.onDismiss();
                        this.f9291e.k = null;
                    }
                    boolean unused = this.f9291e.f9280a;
                    this.f9291e.f9284e = null;
                }
                if (this.f9291e.m != null) {
                    if (this.f9291e.m.getParent() != null) {
                        this.f9291e.f9282c.removeViewImmediate(this.f9291e.m);
                    }
                    boolean unused2 = this.f9291e.f9280a;
                    this.f9291e.m = null;
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
        this.f9281b = context;
        this.f9282c = (WindowManager) context.getSystemService("window");
        this.f9287h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f9286g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f9286g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f9283d = 2;
        this.f9280a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f9286g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f9288i;
            if (runnable != null) {
                this.f9287h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f9288i = bVar;
            this.f9287h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f9287h) == null) {
            return;
        }
        handler.post(new RunnableC0481c(this));
        this.f9287h.removeCallbacks(this.j);
        boolean z = this.f9280a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f9281b);
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
            View view = this.f9284e;
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
            this.f9283d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f9286g) == null) {
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
            this.f9285f = view;
            view.setClickable(true);
        }
    }
}
