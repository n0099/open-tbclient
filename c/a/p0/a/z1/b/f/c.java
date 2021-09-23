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
    public boolean f10053a;

    /* renamed from: b  reason: collision with root package name */
    public Context f10054b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f10055c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f10056d;

    /* renamed from: e  reason: collision with root package name */
    public View f10057e;

    /* renamed from: f  reason: collision with root package name */
    public View f10058f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f10059g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f10060h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f10061i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f10062j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10063e;

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
            this.f10063e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f10063e.f10057e != null) {
                    if (this.f10063e.f10057e.getParent() != null) {
                        this.f10063e.f10055c.removeView(this.f10063e.f10057e);
                        if (this.f10063e.k != null) {
                            this.f10063e.k.onDismiss();
                            this.f10063e.k = null;
                        }
                    }
                    this.f10063e.f10057e = null;
                }
                if (this.f10063e.m != null) {
                    if (this.f10063e.m.getParent() != null) {
                        this.f10063e.f10055c.removeView(this.f10063e.m);
                    }
                    this.f10063e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f10064e;

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
            this.f10064e = cVar;
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
                if (this.f10064e.l) {
                    if (this.f10064e.m != null && (this.f10064e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f10064e.m.getParent()).removeView(this.f10064e.m);
                    }
                    WindowManager.LayoutParams t = this.f10064e.t();
                    this.f10064e.n = new FrameLayout(this.f10064e.f10054b);
                    this.f10064e.n.setClickable(true);
                    this.f10064e.f10055c.addView(this.f10064e.n, t);
                    this.f10064e.m = this.f10064e.n;
                }
                if (this.f10064e.f10058f != null && (this.f10064e.f10058f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f10064e.f10058f.getParent()).removeView(this.f10064e.f10058f);
                }
                this.f10064e.f10055c.addView(this.f10064e.f10058f, this.f10064e.f10059g);
                this.f10064e.f10057e = this.f10064e.f10058f;
                this.f10064e.f10060h.postDelayed(this.f10064e.f10062j, this.f10064e.f10056d * 1000);
                boolean unused = this.f10064e.f10053a;
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
        public final /* synthetic */ c f10065e;

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
            this.f10065e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f10065e.f10057e != null) {
                    if (this.f10065e.f10057e.getParent() != null) {
                        this.f10065e.f10055c.removeViewImmediate(this.f10065e.f10057e);
                    }
                    if (this.f10065e.k != null) {
                        this.f10065e.k.onDismiss();
                        this.f10065e.k = null;
                    }
                    boolean unused = this.f10065e.f10053a;
                    this.f10065e.f10057e = null;
                }
                if (this.f10065e.m != null) {
                    if (this.f10065e.m.getParent() != null) {
                        this.f10065e.f10055c.removeViewImmediate(this.f10065e.m);
                    }
                    boolean unused2 = this.f10065e.f10053a;
                    this.f10065e.m = null;
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
        this.f10054b = context;
        this.f10055c = (WindowManager) context.getSystemService("window");
        this.f10060h = new Handler(Looper.getMainLooper());
        this.f10062j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f10059g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f10059g;
        layoutParams2.flags = 168;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f10056d = 2;
        this.f10053a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f10059g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f10061i;
            if (runnable != null) {
                this.f10060h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f10061i = bVar;
            this.f10060h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f10060h) == null) {
            return;
        }
        handler.post(new RunnableC0486c(this));
        this.f10060h.removeCallbacks(this.f10062j);
        boolean z = this.f10053a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f10054b);
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
            View view = this.f10057e;
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
            this.f10056d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f10059g) == null) {
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
            this.f10058f = view;
            view.setClickable(true);
        }
    }
}
