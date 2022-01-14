package c.a.j.l.h.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import c.a.j.l.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.w0;
/* loaded from: classes.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public WindowManager f4046b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f4047c;

    /* renamed from: d  reason: collision with root package name */
    public View f4048d;

    /* renamed from: e  reason: collision with root package name */
    public View f4049e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f4050f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4051g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f4052h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f4053i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f4054j;
    public View k;
    public View l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4055e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4055e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f4055e.f4048d != null) {
                    if (this.f4055e.f4048d.getParent() != null) {
                        this.f4055e.f4046b.removeView(this.f4055e.f4048d);
                    }
                    this.f4055e.f4048d = null;
                }
                if (this.f4055e.k != null) {
                    if (this.f4055e.k.getParent() != null) {
                        this.f4055e.f4046b.removeView(this.f4055e.k);
                    }
                    this.f4055e.k = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4056e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4056e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4056e.f4054j) {
                        if (this.f4056e.k != null && (this.f4056e.k.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.f4056e.k.getParent()).removeView(this.f4056e.k);
                        }
                        WindowManager.LayoutParams m = this.f4056e.m();
                        this.f4056e.l = new FrameLayout(this.f4056e.a);
                        this.f4056e.l.setClickable(true);
                        this.f4056e.f4046b.addView(this.f4056e.l, m);
                        this.f4056e.k = this.f4056e.l;
                    }
                    if (this.f4056e.f4049e != null && (this.f4056e.f4049e.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f4056e.f4049e.getParent()).removeView(this.f4056e.f4049e);
                    }
                    this.f4056e.f4046b.addView(this.f4056e.f4049e, this.f4056e.f4050f);
                    this.f4056e.f4048d = this.f4056e.f4049e;
                    this.f4056e.f4051g.postDelayed(this.f4056e.f4053i, this.f4056e.f4047c * 1000);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f4057e;

        public c(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f4057e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f4057e.f4048d != null) {
                        if (this.f4057e.f4048d.getParent() != null) {
                            this.f4057e.f4046b.removeViewImmediate(this.f4057e.f4048d);
                        }
                        this.f4057e.f4048d = null;
                    }
                    if (this.f4057e.k != null) {
                        if (this.f4057e.k.getParent() != null) {
                            this.f4057e.f4046b.removeViewImmediate(this.f4057e.k);
                        }
                        this.f4057e.k = null;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public e(Context context) {
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
        this.a = context;
        this.f4046b = (WindowManager) context.getSystemService("window");
        this.f4051g = new Handler(Looper.getMainLooper());
        this.f4053i = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f4050f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f4050f;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f4047c = 2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Runnable runnable = this.f4052h;
            if (runnable != null) {
                this.f4051g.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f4052h = bVar;
            this.f4051g.post(bVar);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f4047c = i2;
        }
    }

    public void e(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) || (layoutParams = this.f4050f) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f4049e = view;
            view.setClickable(true);
        }
    }

    public void i() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.f4051g) == null) {
            return;
        }
        handler.post(new c(this));
        this.f4051g.removeCallbacks(this.f4053i);
    }

    public void j(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (layoutParams = this.f4050f) == null) {
            return;
        }
        layoutParams.windowAnimations = i2;
    }

    public final WindowManager.LayoutParams m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.verticalMargin = c.a.j.l.h.d.b.m(this.a);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public void n(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (layoutParams = this.f4050f) == null) {
            return;
        }
        layoutParams.type = i2;
    }
}
