package c.a.r0.a.c2.b.f;

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
import c.a.r0.a.c2.b.f.e;
import c.a.r0.a.i;
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
    public Context f5612b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f5613c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f5614d;

    /* renamed from: e  reason: collision with root package name */
    public View f5615e;

    /* renamed from: f  reason: collision with root package name */
    public View f5616f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f5617g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f5618h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f5619i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f5620j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5621e;

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
            this.f5621e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f5621e.f5615e != null) {
                    if (this.f5621e.f5615e.getParent() != null) {
                        this.f5621e.f5613c.removeView(this.f5621e.f5615e);
                        if (this.f5621e.k != null) {
                            this.f5621e.k.onDismiss();
                            this.f5621e.k = null;
                        }
                    }
                    this.f5621e.f5615e = null;
                }
                if (this.f5621e.m != null) {
                    if (this.f5621e.m.getParent() != null) {
                        this.f5621e.f5613c.removeView(this.f5621e.m);
                    }
                    this.f5621e.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5622e;

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
            this.f5622e = cVar;
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
                if (this.f5622e.l) {
                    if (this.f5622e.m != null && (this.f5622e.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f5622e.m.getParent()).removeView(this.f5622e.m);
                    }
                    WindowManager.LayoutParams t = this.f5622e.t();
                    this.f5622e.n = new FrameLayout(this.f5622e.f5612b);
                    this.f5622e.n.setClickable(true);
                    this.f5622e.f5613c.addView(this.f5622e.n, t);
                    this.f5622e.m = this.f5622e.n;
                }
                if (this.f5622e.f5616f != null && (this.f5622e.f5616f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.f5622e.f5616f.getParent()).removeView(this.f5622e.f5616f);
                }
                this.f5622e.f5613c.addView(this.f5622e.f5616f, this.f5622e.f5617g);
                this.f5622e.f5615e = this.f5622e.f5616f;
                this.f5622e.f5618h.postDelayed(this.f5622e.f5620j, this.f5622e.f5614d * 1000);
                boolean unused = this.f5622e.a;
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.r0.a.c2.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0298c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f5623e;

        public RunnableC0298c(c cVar) {
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
            this.f5623e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.f5623e.f5615e != null) {
                    if (this.f5623e.f5615e.getParent() != null) {
                        this.f5623e.f5613c.removeViewImmediate(this.f5623e.f5615e);
                    }
                    if (this.f5623e.k != null) {
                        this.f5623e.k.onDismiss();
                        this.f5623e.k = null;
                    }
                    boolean unused = this.f5623e.a;
                    this.f5623e.f5615e = null;
                }
                if (this.f5623e.m != null) {
                    if (this.f5623e.m.getParent() != null) {
                        this.f5623e.f5613c.removeViewImmediate(this.f5623e.m);
                    }
                    boolean unused2 = this.f5623e.a;
                    this.f5623e.m = null;
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
        this.f5612b = context;
        this.f5613c = (WindowManager) context.getSystemService("window");
        this.f5618h = new Handler(Looper.getMainLooper());
        this.f5620j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f5617g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = i.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f5617g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f5614d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || (layoutParams = this.f5617g) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.f5619i;
            if (runnable != null) {
                this.f5618h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f5619i = bVar;
            this.f5618h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f5618h) == null) {
            return;
        }
        handler.post(new RunnableC0298c(this));
        this.f5618h.removeCallbacks(this.f5620j);
        boolean z = this.a;
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f5612b);
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
            View view = this.f5615e;
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
            this.f5614d = i2;
        }
    }

    public void w(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i2, i3, i4) == null) || (layoutParams = this.f5617g) == null) {
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
            this.f5616f = view;
            view.setClickable(true);
        }
    }
}
