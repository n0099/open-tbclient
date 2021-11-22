package b.a.p0.a.c2.b.f;

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
import b.a.p0.a.c2.b.f.e;
import b.a.p0.a.i;
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
    public boolean f4399a;

    /* renamed from: b  reason: collision with root package name */
    public Context f4400b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f4401c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f4402d;

    /* renamed from: e  reason: collision with root package name */
    public View f4403e;

    /* renamed from: f  reason: collision with root package name */
    public View f4404f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f4405g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f4406h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4407i;
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
        public final /* synthetic */ c f4408e;

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
            this.f4408e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4408e.f4403e != null) {
                    if (this.f4408e.f4403e.getParent() != null) {
                        this.f4408e.f4401c.removeView(this.f4408e.f4403e);
                        if (this.f4408e.k != null) {
                            this.f4408e.k.onDismiss();
                            this.f4408e.k = null;
                        }
                    }
                    this.f4408e.f4403e = null;
                }
                if (this.f4408e.m != null) {
                    if (this.f4408e.m.getParent() != null) {
                        this.f4408e.f4401c.removeView(this.f4408e.m);
                    }
                    this.f4408e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4409e;

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
            this.f4409e = cVar;
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
                if (this.f4409e.l) {
                    if (this.f4409e.m != null && (this.f4409e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f4409e.m.getParent()).removeView(this.f4409e.m);
                    }
                    WindowManager.LayoutParams t = this.f4409e.t();
                    this.f4409e.n = new FrameLayout(this.f4409e.f4400b);
                    this.f4409e.n.setClickable(true);
                    this.f4409e.f4401c.addView(this.f4409e.n, t);
                    this.f4409e.m = this.f4409e.n;
                }
                if (this.f4409e.f4404f != null && (this.f4409e.f4404f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f4409e.f4404f.getParent()).removeView(this.f4409e.f4404f);
                }
                this.f4409e.f4401c.addView(this.f4409e.f4404f, this.f4409e.f4405g);
                this.f4409e.f4403e = this.f4409e.f4404f;
                this.f4409e.f4406h.postDelayed(this.f4409e.j, this.f4409e.f4402d * 1000);
                boolean unused = this.f4409e.f4399a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: b.a.p0.a.c2.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0140c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4410e;

        public RunnableC0140c(c cVar) {
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
            this.f4410e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f4410e.f4403e != null) {
                    if (this.f4410e.f4403e.getParent() != null) {
                        this.f4410e.f4401c.removeViewImmediate(this.f4410e.f4403e);
                    }
                    if (this.f4410e.k != null) {
                        this.f4410e.k.onDismiss();
                        this.f4410e.k = null;
                    }
                    boolean unused = this.f4410e.f4399a;
                    this.f4410e.f4403e = null;
                }
                if (this.f4410e.m != null) {
                    if (this.f4410e.m.getParent() != null) {
                        this.f4410e.f4401c.removeViewImmediate(this.f4410e.m);
                    }
                    boolean unused2 = this.f4410e.f4399a;
                    this.f4410e.m = null;
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
        this.f4400b = context;
        this.f4401c = (WindowManager) context.getSystemService("window");
        this.f4406h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4405g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f4405g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f4402d = 2;
        this.f4399a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f4405g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f4407i;
            if (runnable != null) {
                this.f4406h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f4407i = bVar;
            this.f4406h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f4406h) == null) {
            return;
        }
        handler.post(new RunnableC0140c(this));
        this.f4406h.removeCallbacks(this.j);
        boolean z = this.f4399a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f4400b);
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
            View view = this.f4403e;
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
            this.f4402d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f4405g) == null) {
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
            this.f4404f = view;
            view.setClickable(true);
        }
    }
}
