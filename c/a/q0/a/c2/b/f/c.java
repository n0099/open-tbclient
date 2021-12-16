package c.a.q0.a.c2.b.f;

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
import c.a.q0.a.c2.b.f.e;
import c.a.q0.a.i;
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
    public Context f4855b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f4856c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f4857d;

    /* renamed from: e  reason: collision with root package name */
    public View f4858e;

    /* renamed from: f  reason: collision with root package name */
    public View f4859f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f4860g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f4861h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4862i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f4863j;

    /* renamed from: k  reason: collision with root package name */
    public e.b f4864k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4865e;

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
            this.f4865e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4865e.f4858e != null) {
                    if (this.f4865e.f4858e.getParent() != null) {
                        this.f4865e.f4856c.removeView(this.f4865e.f4858e);
                        if (this.f4865e.f4864k != null) {
                            this.f4865e.f4864k.onDismiss();
                            this.f4865e.f4864k = null;
                        }
                    }
                    this.f4865e.f4858e = null;
                }
                if (this.f4865e.m != null) {
                    if (this.f4865e.m.getParent() != null) {
                        this.f4865e.f4856c.removeView(this.f4865e.m);
                    }
                    this.f4865e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4866e;

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
            this.f4866e = cVar;
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
                if (this.f4866e.l) {
                    if (this.f4866e.m != null && (this.f4866e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f4866e.m.getParent()).removeView(this.f4866e.m);
                    }
                    WindowManager.LayoutParams t = this.f4866e.t();
                    this.f4866e.n = new FrameLayout(this.f4866e.f4855b);
                    this.f4866e.n.setClickable(true);
                    this.f4866e.f4856c.addView(this.f4866e.n, t);
                    this.f4866e.m = this.f4866e.n;
                }
                if (this.f4866e.f4859f != null && (this.f4866e.f4859f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f4866e.f4859f.getParent()).removeView(this.f4866e.f4859f);
                }
                this.f4866e.f4856c.addView(this.f4866e.f4859f, this.f4866e.f4860g);
                this.f4866e.f4858e = this.f4866e.f4859f;
                this.f4866e.f4861h.postDelayed(this.f4866e.f4863j, this.f4866e.f4857d * 1000);
                boolean unused = this.f4866e.a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.q0.a.c2.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0230c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f4867e;

        public RunnableC0230c(c cVar) {
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
            this.f4867e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f4867e.f4858e != null) {
                    if (this.f4867e.f4858e.getParent() != null) {
                        this.f4867e.f4856c.removeViewImmediate(this.f4867e.f4858e);
                    }
                    if (this.f4867e.f4864k != null) {
                        this.f4867e.f4864k.onDismiss();
                        this.f4867e.f4864k = null;
                    }
                    boolean unused = this.f4867e.a;
                    this.f4867e.f4858e = null;
                }
                if (this.f4867e.m != null) {
                    if (this.f4867e.m.getParent() != null) {
                        this.f4867e.f4856c.removeViewImmediate(this.f4867e.m);
                    }
                    boolean unused2 = this.f4867e.a;
                    this.f4867e.m = null;
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
        this.f4855b = context;
        this.f4856c = (WindowManager) context.getSystemService("window");
        this.f4861h = new Handler(Looper.getMainLooper());
        this.f4863j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4860g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f4860g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f4857d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f4860g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f4862i;
            if (runnable != null) {
                this.f4861h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f4862i = bVar;
            this.f4861h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f4861h) == null) {
            return;
        }
        handler.post(new RunnableC0230c(this));
        this.f4861h.removeCallbacks(this.f4863j);
        boolean z = this.a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f4855b);
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
            View view = this.f4858e;
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
            this.f4857d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f4860g) == null) {
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
            this.f4864k = bVar;
        }
    }

    public void z(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            this.f4859f = view;
            view.setClickable(true);
        }
    }
}
