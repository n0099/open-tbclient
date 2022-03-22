package c.a.n0.a.s1.b.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.s1.b.f.e;
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
    public Context f6296b;

    /* renamed from: c  reason: collision with root package name */
    public WindowManager f6297c;

    /* renamed from: d  reason: collision with root package name */
    public volatile int f6298d;

    /* renamed from: e  reason: collision with root package name */
    public View f6299e;

    /* renamed from: f  reason: collision with root package name */
    public View f6300f;

    /* renamed from: g  reason: collision with root package name */
    public WindowManager.LayoutParams f6301g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f6302h;
    public Runnable i;
    public Runnable j;
    public e.b k;
    public boolean l;
    public View m;
    public View n;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f6299e != null) {
                    if (this.a.f6299e.getParent() != null) {
                        this.a.f6297c.removeView(this.a.f6299e);
                        if (this.a.k != null) {
                            this.a.k.onDismiss();
                            this.a.k = null;
                        }
                    }
                    this.a.f6299e = null;
                }
                if (this.a.m != null) {
                    if (this.a.m.getParent() != null) {
                        this.a.f6297c.removeView(this.a.m);
                    }
                    this.a.m = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.a.l) {
                    if (this.a.m != null && (this.a.m.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.a.m.getParent()).removeView(this.a.m);
                    }
                    WindowManager.LayoutParams t = this.a.t();
                    this.a.n = new FrameLayout(this.a.f6296b);
                    this.a.n.setClickable(true);
                    this.a.f6297c.addView(this.a.n, t);
                    this.a.m = this.a.n;
                }
                if (this.a.f6300f != null && (this.a.f6300f.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.a.f6300f.getParent()).removeView(this.a.f6300f);
                }
                this.a.f6297c.addView(this.a.f6300f, this.a.f6301g);
                this.a.f6299e = this.a.f6300f;
                this.a.f6302h.postDelayed(this.a.j, this.a.f6298d * 1000);
                if (this.a.a) {
                    Log.d("ToastCustom", "add mView");
                }
            } finally {
                if (!z) {
                }
            }
        }
    }

    /* renamed from: c.a.n0.a.s1.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0455c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public RunnableC0455c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                return;
            }
            try {
                if (this.a.f6299e != null) {
                    if (this.a.f6299e.getParent() != null) {
                        this.a.f6297c.removeViewImmediate(this.a.f6299e);
                    }
                    if (this.a.k != null) {
                        this.a.k.onDismiss();
                        this.a.k = null;
                    }
                    if (this.a.a) {
                        Log.d("ToastCustom", "remove mView");
                    }
                    this.a.f6299e = null;
                }
                if (this.a.m != null) {
                    if (this.a.m.getParent() != null) {
                        this.a.f6297c.removeViewImmediate(this.a.m);
                    }
                    if (this.a.a) {
                        Log.d("ToastCustom", "remove mMaskView");
                    }
                    this.a.m = null;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6296b = context;
        this.f6297c = (WindowManager) context.getSystemService("window");
        this.f6302h = new Handler(Looper.getMainLooper());
        this.j = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f6301g = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.obfuscated_res_0x7f10040f;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f6301g;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f6298d = 2;
        this.a = false;
    }

    public void A(@StyleRes int i) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || (layoutParams = this.f6301g) == null) {
            return;
        }
        layoutParams.windowAnimations = i;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Runnable runnable = this.i;
            if (runnable != null) {
                this.f6302h.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.i = bVar;
            this.f6302h.post(bVar);
        }
    }

    public void s() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (handler = this.f6302h) == null) {
            return;
        }
        handler.post(new RunnableC0455c(this));
        this.f6302h.removeCallbacks(this.j);
        if (this.a) {
            Log.d("ToastCustom", "cancel");
        }
    }

    public final WindowManager.LayoutParams t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = e.c(this.f6296b);
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
            View view = this.f6299e;
            return (view == null || view.getParent() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            if (i <= 0) {
                i = 2;
            }
            this.f6298d = i;
        }
    }

    public void w(int i, int i2, int i3) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(1048582, this, i, i2, i3) == null) || (layoutParams = this.f6301g) == null) {
            return;
        }
        layoutParams.gravity = i;
        layoutParams.x = i2;
        layoutParams.y = i3;
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
            this.f6300f = view;
            view.setClickable(true);
        }
    }
}
