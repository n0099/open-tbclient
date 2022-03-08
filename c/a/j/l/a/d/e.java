package c.a.j.l.a.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
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
    public WindowManager f3824b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f3825c;

    /* renamed from: d  reason: collision with root package name */
    public View f3826d;

    /* renamed from: e  reason: collision with root package name */
    public View f3827e;

    /* renamed from: f  reason: collision with root package name */
    public WindowManager.LayoutParams f3828f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f3829g;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f3830h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f3831i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3832j;
    public View k;
    public View l;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3833e;

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
            this.f3833e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f3833e.f3826d != null) {
                    if (this.f3833e.f3826d.getParent() != null) {
                        this.f3833e.f3824b.removeView(this.f3833e.f3826d);
                    }
                    this.f3833e.f3826d = null;
                }
                if (this.f3833e.k != null) {
                    if (this.f3833e.k.getParent() != null) {
                        this.f3833e.f3824b.removeView(this.f3833e.k);
                    }
                    this.f3833e.k = null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f3834e;

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
            this.f3834e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3834e.f3832j) {
                        if (this.f3834e.k != null && (this.f3834e.k.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) this.f3834e.k.getParent()).removeView(this.f3834e.k);
                        }
                        WindowManager.LayoutParams m = this.f3834e.m();
                        this.f3834e.l = new FrameLayout(this.f3834e.a);
                        this.f3834e.l.setClickable(true);
                        this.f3834e.f3824b.addView(this.f3834e.l, m);
                        this.f3834e.k = this.f3834e.l;
                    }
                    if (this.f3834e.f3827e != null && (this.f3834e.f3827e.getParent() instanceof ViewGroup)) {
                        ((ViewGroup) this.f3834e.f3827e.getParent()).removeView(this.f3834e.f3827e);
                    }
                    this.f3834e.f3824b.addView(this.f3834e.f3827e, this.f3834e.f3828f);
                    this.f3834e.f3826d = this.f3834e.f3827e;
                    this.f3834e.f3829g.postDelayed(this.f3834e.f3831i, this.f3834e.f3825c * 1000);
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
        public final /* synthetic */ e f3835e;

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
            this.f3835e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    if (this.f3835e.f3826d != null) {
                        if (this.f3835e.f3826d.getParent() != null) {
                            this.f3835e.f3824b.removeViewImmediate(this.f3835e.f3826d);
                        }
                        this.f3835e.f3826d = null;
                    }
                    if (this.f3835e.k != null) {
                        if (this.f3835e.k.getParent() != null) {
                            this.f3835e.f3824b.removeViewImmediate(this.f3835e.k);
                        }
                        this.f3835e.k = null;
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
        this.f3824b = (WindowManager) context.getSystemService("window");
        this.f3829g = new Handler(Looper.getMainLooper());
        this.f3831i = new a(this);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f3828f = layoutParams;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.toast_animation;
        layoutParams.type = 2005;
        layoutParams.setTitle("Toast");
        WindowManager.LayoutParams layoutParams2 = this.f3828f;
        layoutParams2.flags = w0.d0;
        layoutParams2.gravity = 81;
        layoutParams2.y = -30;
        this.f3825c = 2;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Runnable runnable = this.f3830h;
            if (runnable != null) {
                this.f3829g.removeCallbacks(runnable);
            }
            b bVar = new b(this);
            this.f3830h = bVar;
            this.f3829g.post(bVar);
        }
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 <= 0) {
                i2 = 2;
            }
            this.f3825c = i2;
        }
    }

    public void e(int i2, int i3, int i4) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i2, i3, i4) == null) || (layoutParams = this.f3828f) == null) {
            return;
        }
        layoutParams.gravity = i2;
        layoutParams.x = i3;
        layoutParams.y = i4;
    }

    public void f(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
            this.f3827e = view;
            view.setClickable(true);
        }
    }

    public void i() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (handler = this.f3829g) == null) {
            return;
        }
        handler.post(new c(this));
        this.f3829g.removeCallbacks(this.f3831i);
    }

    public void j(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048581, this, i2) == null) || (layoutParams = this.f3828f) == null) {
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
            layoutParams.verticalMargin = c.a.j.l.a.d.b.m(this.a);
            layoutParams.flags = 2176;
            layoutParams.type = 2005;
            return layoutParams;
        }
        return (WindowManager.LayoutParams) invokeV.objValue;
    }

    public void n(int i2) {
        WindowManager.LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i2) == null) || (layoutParams = this.f3828f) == null) {
            return;
        }
        layoutParams.type = i2;
    }
}
